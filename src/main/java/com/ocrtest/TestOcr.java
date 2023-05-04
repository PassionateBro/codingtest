package com.ocrtest;

import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-03-31 14:32
 */
public class TestOcr {

    public static void main(String[] args) throws IOException {
        String testImgDir = "D:/cjm/feijiang/ppocr_img/ppocr_img/imgs/";
        String testDir = "C:/Users/caijiamin/Desktop/imag_data/test2/";

        String url = "http://2349.saicmdev.local/ocr/prediction";
//        String url = "http://10.188.151.246:9998/ocr/prediction";
//        String url = "http://localhost:8753/driverservice/imageOcrAnalysis";
        File folder = new File(testDir);
        File[] listOfFiles = folder.listFiles();
        for (File imgFile : listOfFiles) {
            if (imgFile.isFile()) {
                BufferedImage image = ImageIO.read(imgFile);
                String imageBase64 = imageToBase64(image);
                for (int j = 0; j < 1; j++) {
                    ArrayList<CompletableFuture<String>> list = new ArrayList<>();
                    for (int i = 0; i < 1; i++) {
                        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                            String jsonResponse = null;
                            try {
                                long time = System.currentTimeMillis();
                                jsonResponse = sendRequest(url, imageBase64);
                                long times = (System.currentTimeMillis() - time);
                                System.out.println("endTime: " + times + "Thread :" + Thread.currentThread());

                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            return jsonResponse;
                        });
                        list.add(future);
                    }
                    list.forEach(c -> {
                        try {
                            System.out.println(cardListFontDataFormat(dataFormat(c.get())));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } catch (ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    System.out.println("==============================================");
                }
            }
        }
    }

    public static String imageToBase64(BufferedImage image) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", byteArrayOutputStream);
        return Base64.encodeBase64String(byteArrayOutputStream.toByteArray());
    }

    public static String sendRequest(String url, String imageBase64) throws IOException {
//        String requestBody = String.format("{\"feed\": [{\"x\": \"%s\"}], \"fetch\": [\"res\"]}", imageBase64);
        String requestBody = String.format("{\"key\": [\"image\"], \"value\": [\"%s\"]}", imageBase64);
//        String requestBody = String.format("{\"filePath\": \"%s\", \"imageType\": \"ID_CARD_FRONT\"}", "123," + imageBase64);
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);
        try (OutputStream output = connection.getOutputStream()) {
            output.write(requestBody.getBytes("UTF-8"));
        }

        StringBuilder jsonResponse = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonResponse.append(line);
            }
        }
        return jsonResponse.toString();
    }


    public static Deque<Map<String, String>> dataFormat(String paddleResList) {
        char[] charArray = paddleResList.toCharArray();
        Deque<Map<String, String>> list = new LinkedList<>();
        int temp = 0;
        while (temp < charArray.length) {
            if (charArray[temp] == '(') {
                temp++;
                StringBuilder builder = new StringBuilder();
                while (charArray[temp] != ')' && temp < charArray.length) {
                    builder.append(charArray[temp]);
                    temp++;
                }
                HashMap<String, String> map = new HashMap<>(2);
                String[] splits = builder.toString().split(",");
                map.put("key", splits[0].replace("\'", "").trim());
                if (splits.length > 1) {
                    map.put("score", splits[1].trim());
                }
                list.addLast(map);
            } else {
                temp++;
            }
        }
        return list;
    }

    public static Map<String, Object> cardListFontDataFormat(Deque<Map<String, String>> list) {
        Map<String, Object> map = new HashMap<>(6);
        // 按顺序处理相应字段
        nameStream(list, map);
        genderStream(list, map);
        brithStream(list, map);
        addrStream(list, map);
        cardNoStream(list, map);
        return map;
    }

    private static void nameStream(Deque<Map<String, String>> list, Map<String, Object> map) {
        if (!list.isEmpty()) {
            Map<String, String> stringMap = list.pollFirst();
            String name = stringMap.get("key").replace(" ", "");
            if (name.indexOf("姓名") >= 0) {
                if (name.length() == 2) {
                    // key1 = 姓名， key2 = xxx
                    String realName = list.isEmpty() ? "" : list.pollFirst().get("key").replace(" ", "");
                    map.put("driverName", realName);
                } else {
                    map.put("driverName", name.substring(2));
                }
            } else {
                map.put("driverName", name);
            }
        }
    }

    private static void genderStream(Deque<Map<String, String>> list, Map<String, Object> map) {
        StringBuilder builder = new StringBuilder();
        while (!list.isEmpty()) {
            String key = list.peekFirst().get("key");
            if (key.indexOf("住址") >= 0 || key.indexOf("出生") >= 0) {
                break;
            } else {
                builder.append(key.replace(" ", ""));
                list.pollFirst();
            }
        }
        // 性别男民族汉，最少6位字符
        if (builder.length() >= 6) {
            String temp = builder.toString();
            int idxGender = temp.indexOf("性别");
            if (idxGender >= 0) {
                String gender = temp.substring(idxGender + 2, idxGender + 3);
                map.put("gender", gender.equals("男") ? 1 : 2);
            } else {
                // 说明性，和别字有一个字识别错误了，这种暂时忽略，也可以特殊处理
            }
            int idxNation = temp.indexOf("民族");
            // 处理方式同上
            if (idxNation >= 0) {
                String nation = temp.substring(idxNation + 2);
                map.put("nation", nation);
            }
        }
    }

    private static void brithStream(Deque<Map<String, String>> list, Map<String, Object> map) {
        StringBuilder builder = new StringBuilder();
        while (!list.isEmpty()) {
            String key = list.peekFirst().get("key");
            if (key.indexOf("住址") >= 0) {
                break;
            } else {
                builder.append(key.replace(" ", ""));
                list.pollFirst();
            }
        }
        if (builder.length() > 0) {
            String temp = builder.toString();
            int birthIdx = temp.indexOf("出生");
            if (birthIdx >= 0) {
                String birth = temp.substring(birthIdx + 2);
                String[] bSplit = birth.split("\\D+");
                for (int i = 0; i < bSplit.length; i++) {
                    if (bSplit[i].length() <= 1) {
                        bSplit[i] = "0" + bSplit[i];
                    }
                }
                if (bSplit.length > 2) {
                    map.put("birthday", bSplit[0] + "-" + bSplit[1] + "-" + bSplit[2]);
                }
            }
        }
    }

    private static void addrStream(Deque<Map<String, String>> list, Map<String, Object> map) {
        StringBuilder builder = new StringBuilder();
        while (!list.isEmpty()) {
            String key = list.peekFirst().get("key");
            if (key.indexOf("身份号码") >= 0) {
                break;
            } else {
                builder.append(key.replace(" ", ""));
                list.pollFirst();
            }
        }
        if (builder.length() > 0) {
            String temp = builder.toString();
            int addrIdx = temp.indexOf("住址");
            if (addrIdx >= 0) {
                String addr = temp.substring(addrIdx + 2);
                map.put("address", addr);
            }
        }
    }

    private static void cardNoStream(Deque<Map<String, String>> list, Map<String, Object> map) {
        StringBuilder builder = new StringBuilder();
        while (!list.isEmpty()) {
            builder.append(list.pollFirst().get("key").replace(" ", ""));
        }
        if (builder.length() > 0) {
            String temp = builder.toString();
            int cardNoIdx = temp.indexOf("身份号码");
            if (cardNoIdx < 0) {
                return;
            }
            String cardNo = temp.substring(cardNoIdx + 4);
            if (cardNo.length() == 18) {
                map.put("cardNo", cardNo);
            }
        }
    }
}
