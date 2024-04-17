package com.ocrtest;

import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2024-01-02 14:35
 */
public class PlateNoOcr {
    public static void main(String[] args) throws IOException {
        String url = "http://2378.dev.local/getVehicleNoByImage";
        String filePath = "C:\\Users\\caijiamin\\Desktop\\报销\\test\\_ali_853d5d5a87024f4fb49ad265dc4b273a.jpg";
        AtomicInteger res = new AtomicInteger();
        File file = new File(filePath);
        byte[] bytes = toByteArray(file.getAbsolutePath());
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
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            System.out.println("==============================================");
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
        String requestBody = String.format("{\"image\": \"%s\"}",
                imageBase64);
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
