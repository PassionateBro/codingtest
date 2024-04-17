package com.ocrtest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-03-31 14:32
 */
public class TestOcr {

    static Pattern pattern = Pattern.compile(".*\\d+.*");
    static Pattern patternNumber = Pattern.compile("\\d+");

    public static void main(String[] args) throws IOException {
        String testImgDir = "D:/cjm/feijiang/ppocr_img/ppocr_img/imgs/";
        String testDir = "C:\\Users\\caijiamin\\Desktop\\shenhe\\test";

        String url = "http://ocr.sit.local/ocr/prediction";
//        String url = "http://10.188.150.7:9998/ocr/prediction";
//        String url = "http://2349.dev.local/ocr/prediction";
//        String url = "http://10.188.151.246:9998/ocr/prediction";
//        String url = "http://localhost:8753/driverservice/imageOcrAnalysis";
        File folder = new File(testDir);
        File[] listOfFiles = folder.listFiles();
        AtomicInteger res = new AtomicInteger();
        AtomicInteger point = new AtomicInteger();
        for (File imgFile : listOfFiles) {
            if (imgFile.isFile()) {
                System.out.println(imgFile.getName());
                byte[] bytes = toByteArray(imgFile.getAbsolutePath());
                java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
                String base64Str = encoder.encodeToString(bytes);
//                String base64Str = "";
//                FileInputStream fileInputStream = new FileInputStream(imgFile);
//                byte[] bytes = new byte[(int)imgFile.length()];
//                fileInputStream.read(bytes);
//                fileInputStream.close();
//                String imageBase64 = Base64.encodeBase64String(bytes);
//                File file = new File("d:/2.txt");
//                FileWriter fileWriter = new FileWriter(file);
//                fileWriter.write(imageBase64);
//                fileWriter.flush();
                for (int j = 0; j < 1; j++) {
                    ArrayList<CompletableFuture<String>> list = new ArrayList<>();
                    for (int i = 0; i < 1; i++) {
                        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                            String jsonResponse = null;
                            try {
                                long time = System.currentTimeMillis();
                                System.out.println("start");
                                jsonResponse = sendRequest(url, base64Str);
                                long times = (System.currentTimeMillis() - time);
                                res.getAndIncrement();
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
                            System.out.println(c.get());
                            JSONObject jsonRes = JSONObject.parseObject(c.get());
                            dealDrivingLicenseArray(jsonRes.getJSONArray("value"));
//                            Deque<Map<String, Object>> maps = dataFormat(jsonRes.getJSONArray("value").getString(0));
//                            System.out.println(maps);
//                            Map<String, Object> stringObjectMap = cardListBackDataFormat(maps);
//                            point.addAndGet(stringObjectMap.size());
//                            System.out.println(stringObjectMap);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
                    System.out.println("==============================================");
                }
            }
        }
        System.out.println(point.get() * 1.0 / (res.get() * 6 * 1.0));
    }


    private static void dealDrivingLicenseArray(JSONArray array) {
        String dataRes = array.getString(0);
        Deque<Map<String, Object>> mapDeque = dealIndex(PaddleOCRFactory.dataFormat(dataRes));
        if (mapDeque.size() >= 10) {
            Map<String, Object> map0 = mapDeque.pollFirst();
            String plateNo = String.valueOf(mapDeque.pollFirst().get("key"));
            String vehicleType = String.valueOf(mapDeque.pollFirst().get("key"));
            String owner = String.valueOf(mapDeque.pollFirst().get("key"));
            String useCharacter = null;
            String vin = null;
            String engineNo = null;
            Map<String, Object> useCharacterMap = null; // 使用性质
            Map<String, Object> modelMap = null; // 品牌型号
            while (!mapDeque.isEmpty()) {
                // 过滤住址
                if (useCharacterMap != null) {
                    Map<String, Object> tempMap = mapDeque.pollFirst();
                    if (Math.abs(Integer.valueOf(String.valueOf(tempMap.get("y"))) - Integer.valueOf(String.valueOf(useCharacterMap.get("y")))) < 15) {
                        // y值差值在15以内视为同一行 第一组同行字段为性质+型号
                        modelMap = tempMap;
                        break;
                    } else {
                        useCharacterMap = tempMap;
                    }
                } else {
                    useCharacterMap = mapDeque.pollFirst();
                }
            }
            if (useCharacterMap != null) {
                useCharacter = String.valueOf(useCharacterMap.get("key"));
            }
            if (!mapDeque.isEmpty()) {
                vin = String.valueOf(mapDeque.pollFirst().get("key"));
            }
            if (!mapDeque.isEmpty()) {
                engineNo = String.valueOf(mapDeque.pollFirst().get("key"));
            }
            Map<String, Object> registrationDateMap = null; // 注册日期
            Map<String, Object> issueCertificationMap = null; // 发证日期
            while (!mapDeque.isEmpty()) {
                if (registrationDateMap != null) {
                    Map<String, Object> tempMap = mapDeque.pollFirst();
                    if (Math.abs(Integer.valueOf(String.valueOf(tempMap.get("y"))) - Integer.valueOf(String.valueOf(registrationDateMap.get("y")))) < 15) {
                        // y值差值在15以内视为同一行
                        issueCertificationMap = tempMap;
                        break;
                    } else {
                        registrationDateMap = tempMap;
                    }
                } else {
                    registrationDateMap = mapDeque.pollFirst();
                }
            }
        }
    }

    /**
     * 对给定的识别列表进行横行排序 因为同行最多只存在两个字段 所以可以直接两个双端队列排
     *
     * @param dealQueue
     * @return
     */
    private static Deque<Map<String, Object>> dealIndex(Deque<Map<String, Object>> dealQueue) {
        Deque<Map<String, Object>> leftQueue = new LinkedList<>();
        while (!dealQueue.isEmpty()) {
            if (!leftQueue.isEmpty()) {
                Map<String, Object> tempMap = dealQueue.pollFirst();
                // y轴差值在15以内视为同一行，其他情况不考虑
                if (Math.abs(Integer.valueOf(String.valueOf(leftQueue.peekLast().get("y")))
                        - Integer.valueOf(String.valueOf(tempMap.get("y")))) <= 15) {
                    // x1 > x2 则x2位置在前
                    if (Integer.valueOf(String.valueOf(leftQueue.peekLast().get("x")))
                            > Integer.valueOf(String.valueOf(tempMap.get("x")))) {
                        Map<String, Object> waitMap = leftQueue.pollLast();
                        leftQueue.offerLast(tempMap);
                        leftQueue.offerLast(waitMap);
                        continue;
                    }
                }
                leftQueue.offerLast(tempMap);
            } else {
                leftQueue.offerLast(dealQueue.pollFirst());
            }
        }
        return leftQueue;
    }

    private static byte[] toByteArray(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        inputStream.read(bytes);
        inputStream.close();
        return bytes;
    }

    public static String imageToBase64(BufferedImage image) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", byteArrayOutputStream);
        return Base64.encodeBase64String(byteArrayOutputStream.toByteArray());
    }

    public static String sendRequest(String url, String imageBase64) throws IOException {
//        String requestBody = String.format("{\"feed\": [{\"x\": \"%s\"}], \"fetch\": [\"res\"]}",  imageBase64);
//        String requestBody = String.format("{\"key\": [\"image\"], \"value\": [\"%s\"]}", imageBase64);
        String requestBody = String.format("{\"key\": [\"image\",\"imageType\"], \"value\": [\"%s\", \"%s\"]}", imageBase64,"normal");
//        String requestBody = String.format("{\"key\": [\"image\",\"imageType\"], \"value\": [\"%s\", \"%s\"]}", imageBase64, "driving_license");
//        String requestBody = String.format("{\"key\": [\"image\",\"imageType\"], \"value\": [\"%s\", \"%s\"]}", imageBase64, "idcard");
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

    private static void dealArray(JSONArray array) {
        String dataRes = array.getString(0);
        LinkedList<Map<String, Object>> maps = PaddleOCRFactory.dataFormat(dataRes);
        System.out.println(maps);
//        int carryNum = 0;
//        String licensePlateNo = "";
//        String checkValidTime = "";
//        while (!maps.isEmpty()) {
//            Map<String, Object> poll = maps.pollFirst();
//            String key = String.valueOf(poll.get("key"));
//            if (checkPlateNumberFormat(key)) {
//                licensePlateNo = key;
//                continue;
//            }
//            if (key.contains("人")) {
//                String ns = key.replace("人", "");
//                if (isNumber(ns)) {
//                    carryNum = Integer.valueOf(ns);
//                    continue;
//                }
//            }
//            if (key.contains("检验") || key.contains("有效期")) {
//                int begin = key.indexOf("2");
//                int end = key.lastIndexOf("月") + 1;
//                checkValidTime = key.substring(begin, end);
//            }
//        }
    }

    public static boolean isNumber(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }


    /**
     * 车牌号校验
     * @param content
     * @return
     */
    public static boolean checkPlateNumberFormat(String content) {
        String pattern = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]{1}(([A-HJ-Z]{1}[A-HJ-NP-Z0-9]{5})|([A-HJ-Z]{1}(([DF]{1}[A-HJ-NP-Z0-9]{1}[0-9]{4})|([0-9]{5}[DF]{1})))|([A-HJ-Z]{1}[A-D0-9]{1}[0-9]{3}警)))|([0-9]{6}使)|((([沪粤川云桂鄂陕蒙藏黑辽渝]{1}A)|鲁B|闽D|蒙E|蒙H)[0-9]{4}领)|(WJ[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼·•]{1}[0-9]{4}[TDSHBXJ0-9]{1})|([VKHBSLJNGCE]{1}[A-DJ-PR-TVY]{1}[0-9]{5})";
        return Pattern.matches(pattern, content);
    }


}
