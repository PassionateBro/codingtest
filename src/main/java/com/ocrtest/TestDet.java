//package com.ocrtest;
//
//import cn.hutool.core.img.ImgUtil;
//import cn.hutool.json.JSONObject;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Base64;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @describtion:
// * @author: CaiJm
// * @Date: 2023-06-07 15:35
// */
//public class TestDet {
//    public static void main(String[] args) throws IOException {
//        String testImgDir = "D:/cjm/feijiang/ppocr_img/ppocr_img/imgs/";
//        String testDir = "C:/Users/caijiamin/Desktop/imag_data/test4/";
//
//        String url = "http://2.0.0.1:9292/ocr/prediction";
//        String recUrl = "http://2.0.0.1:9293/ocr/prediction";
//        File folder = new File(testDir);
//        File[] listOfFiles = folder.listFiles();
//        AtomicInteger res = new AtomicInteger();
//        AtomicInteger point = new AtomicInteger();
//        for (File imgFile : listOfFiles) {
//            if (imgFile.isFile()) {
//                if (!imgFile.getName().equals("28.png")) {
//                    continue;
//                }
//                byte[] bytes = toByteArray(imgFile.getAbsolutePath());
//
//                System.out.println(imgFile.getName());
//                BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                ImageIO.write(img, "png", baos);
//                ImgUtil.writeJpg(img, baos);
//                String abc = org.apache.commons.codec.binary.Base64.encodeBase64String(baos.toByteArray());
////                byte[] imageBytes = Base64.decodeBase64(abc);
////                // 从字节数组中读取图像
////                BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
////
////                // 显示图像
////                ImageIcon icon=new ImageIcon(img);
////                JFrame frame=new JFrame();
////                frame.setLayout(new FlowLayout());
////                frame.setSize(500,500);
////                JLabel lbl=new JLabel();
////                lbl.setIcon(icon);
////                frame.add(lbl);
////                frame.setVisible(true);
////                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//
////                FileInputStream fileInputStream = new FileInputStream(imgFile);
////                byte[] bytes = new byte[(int)imgFile.length()];
////                fileInputStream.read(bytes);
////                fileInputStream.close();
////                String imageBase64 = Base64.encodeBase64String(bytes);
////                File file = new File("d:/2.txt");
////                FileWriter fileWriter = new FileWriter(file);
////                fileWriter.write(imageBase64);
////                fileWriter.flush();
//                for (int j = 0; j < 1; j++) {
//                    ArrayList<CompletableFuture<String>> list = new ArrayList<>();
//                    for (int i = 0; i < 1; i++) {
//                        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//                            String jsonResponse = null;
//                            try {
//                                long time = System.currentTimeMillis();
//                                jsonResponse = sendRequest(url, abc);
//                                long times = (System.currentTimeMillis() - time);
//                                res.getAndIncrement();
//                                System.out.println("endTime: " + times + "Thread :" + Thread.currentThread());
//
//                            } catch (IOException e) {
//                                throw new RuntimeException(e);
//                            }
//                            return jsonResponse;
//                        });
//                        list.add(future);
//                    }
//                    list.forEach(c -> {
//                        try {
////                            System.out.println(c.get().replace("\\n","\n"));
//                            JSONObject jsonObject = new JSONObject(c.get());
//                            System.out.println(jsonObject);
//                            JSONObject result = jsonObject.getJSONObject("result");
//                            String detRes = result.getStr("x");
//                            String shape = result.getStr("shape");
////                            String s = sendRecRequest(recUrl, imageBase64, detRes, shape);
////                            System.out.println(s);
//                        } catch (Exception e) {
//                            throw new RuntimeException(e);
//                        }
//                    });
//                    System.out.println("==============================================");
//                }
//            }
//        }
//        System.out.println(point.get() * 1.0 / (res.get() * 6 * 1.0));
//    }
//
//
//    private static byte[] toByteArray(String fileName) throws IOException {
//        File file = new File(fileName);
//        FileInputStream inputStream = new FileInputStream(file);
//        byte[] bytes = new byte[(int) file.length()];
//        inputStream.read(bytes);
//        inputStream.close();
//        return bytes;
//    }
//
////    public static String imageToBase64(BufferedImage image) throws IOException {
////        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
////        ImageIO.write(image, "jpg", byteArrayOutputStream);
////        return Base64.encodeBase64String(byteArrayOutputStream.toByteArray());
////    }
//
//    public static String sendRequest(String url, String imageBase64) throws IOException {
////        String requestBody = String.format("{\"key\": [\"image\"], \"value\": [\"%s\"]}", imageBase64);
//        String requestBody = String.format("{\"feed\": [{\"x\": \"%s\"}], \"fetch\": [\"res\"]}", imageBase64);
//        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//        connection.setRequestMethod("POST");
//        connection.setRequestProperty("Content-Type", "application/json");
//        connection.setDoOutput(true);
//        connection.setConnectTimeout(15000);
//        connection.setReadTimeout(15000);
//        try (OutputStream output = connection.getOutputStream()) {
//            output.write(requestBody.getBytes("UTF-8"));
//        }
//
//        StringBuilder jsonResponse = new StringBuilder();
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                jsonResponse.append(line);
//            }
//        }
//        return jsonResponse.toString();
//    }
//
//
//    public static String sendRecRequest(String url, String imageBase64, String dtBoxes, String shape) throws IOException {
//        System.out.println(dtBoxes.replace("\n",""));
//        String requestBody = String.format("{\"feed\": [{\"x\": \"%s\"}, {\"dt_boxes\": \"%s\"},{\"shape\": \"%s\"}], " +
//                        "\"fetch\": [\"res\"]}",
//                imageBase64, dtBoxes.replace("\n",""), shape);
//        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//        connection.setRequestMethod("POST");
//        connection.setRequestProperty("Content-Type", "application/json");
//        connection.setDoOutput(true);
//        connection.setConnectTimeout(15000);
//        connection.setReadTimeout(15000);
//        try (OutputStream output = connection.getOutputStream()) {
//            output.write(requestBody.getBytes("UTF-8"));
//        }
//
//        StringBuilder jsonResponse = new StringBuilder();
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                jsonResponse.append(line);
//            }
//        }
//        return jsonResponse.toString();
//    }
//}
