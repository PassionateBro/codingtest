package com.ocrtest;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-11-14 16:22
 */
public class ClasAndOcr {

    public static void main(String[] args) throws IOException {
        String base64Image = "";
        String testDir = "D:\\cjm\\drving_det\\test\\";
        File folder = new File(testDir);
        File[] listOfFiles = folder.listFiles();
        for (File imgFile : listOfFiles) {
            if (imgFile.isFile()) {
                System.out.println(imgFile.getName());
                byte[] bytes = toByteArray(imgFile.getAbsolutePath());
                java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
                String base64Str = encoder.encodeToString(bytes);
                base64Image = base64Str;
            }
        }
        long time = System.currentTimeMillis();
        System.out.println("start");
        try {
            // 判断图片方向
            String clasRes = sendPaddleOCRClasRequest("http://dev.local/imagenet/prediction", base64Image
                    , 3000);
            JSONObject clasJsonRes = JSONObject.parseObject(clasRes);
            int clas = 0; // 图片旋转度数
            if (clasJsonRes.getInteger("err_no") == 0) {
                String angle = clasJsonRes.getJSONArray("value").getString(0).replaceAll("[^0-9]", "");
                clas = Integer.valueOf(angle);
            }
            System.out.println("endTime: " + (System.currentTimeMillis() - time) + "Thread :" + Thread.currentThread());
            // 将文件格式优化为图片格式 缩小base64的大小。更容易识别
            byte[] bytes = Base64.decodeBase64(base64Image);
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            BufferedImage bufferedImage = ImageIO.read(bis);
            // 角度有问题 对图片进行旋转
            if (clas > 0) {
                // 创建一个旋转后的BufferedImage
                BufferedImage rotatedImage = rotateImage(bufferedImage, Double.valueOf(360 - clas));
                bufferedImage = rotatedImage;
            }
            System.out.println("endTime: " + (System.currentTimeMillis() - time) + "Thread :" + Thread.currentThread());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            System.out.println("endTime: " + (System.currentTimeMillis() - time) + "Thread :" + Thread.currentThread());
            String resp = sendPaddleOCRRequest("http://dev.local/ocr/prediction",
                    Base64.encodeBase64String(baos.toByteArray()), 3000, "driving_license_sub");
            JSONObject jsonRes = JSONObject.parseObject(resp);
            System.out.println(jsonRes);
            System.out.println("endTime: " + (System.currentTimeMillis() - time) + "Thread :" + Thread.currentThread());
        } catch (Exception e) {

        }
    }


    public static String sendPaddleOCRClasRequest(String url, String imageBase64, int timeOut) throws IOException {
        String requestBody = String.format("{\"value\": [\"%s\"], \"key\": [\"image\"]}",
                imageBase64);
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        connection.setConnectTimeout(timeOut);
        connection.setReadTimeout(timeOut);
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


    public static String sendPaddleOCRRequest(String url, String imageBase64, int timeOut, String imageType) throws
            IOException {
        String requestBody = String.format("{\"value\": [\"%s\" , \"%s\"], \"key\": [\"image\", \"imageType\"]}",
                imageBase64, imageType);
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        connection.setConnectTimeout(timeOut);
        connection.setReadTimeout(timeOut);
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

    public static BufferedImage rotateImage(BufferedImage originalImage, double angle) {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        BufferedImage rotatedImage = new BufferedImage(width, height, originalImage.getType());
        Graphics2D g2d = rotatedImage.createGraphics();

        // 设置旋转角度
        g2d.rotate(Math.toRadians(angle), width / 2, height / 2);

        // 绘制旋转后的图像
        g2d.drawImage(originalImage, null, 0, 0);
        g2d.dispose();

        return rotatedImage;
    }

    private static byte[] toByteArray(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        inputStream.read(bytes);
        inputStream.close();
        return bytes;
    }
}
