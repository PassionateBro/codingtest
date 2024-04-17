package com.ocrtest;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-11-13 16:23
 */
public class ClasTest {

    public static void main(String[] args) throws IOException {
//        String testImgDir = "D:/cjm/feijiang/ppocr_img/ppocr_img/imgs/";
        String testDir = "C:\\Users\\caijiamin\\Desktop\\报销\\test";
        String url = "http://2380.dev.local/imagenet/prediction";
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
                        System.out.println(jsonRes);
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
        String requestBody = String.format("{\"key\": [\"image\"], \"value\": [\"%s\"]}", imageBase64);
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
}
