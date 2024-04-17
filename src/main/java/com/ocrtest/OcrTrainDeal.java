//package com.ocrtest;
//
//import cn.hutool.core.codec.Base64;
//import cn.hutool.core.date.DateUtil;
//import com.alibaba.fastjson.JSONObject;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutionException;
//
///**
// * @describtion:
// * @author: CaiJm
// * @Date: 2023-12-25 15:48
// */
//public class OcrTrainDeal {
//
//    public static void main(String[] args) throws IOException {
//        String filePath = "C:\\Users\\caijiamin\\Desktop\\shenhe\\test";
//        String saveFilePath = "C:\\Users\\caijiamin\\Desktop\\shenhe\\train\\人证车证训练\\test\\";
//        File folder = new File(filePath);
//        File[] listOfFiles = folder.listFiles();
//        String url = "http://2380.dev.local/imagenet/prediction";
//        int textIdx = 0;
//        long last = System.currentTimeMillis();
//        for (File imgFile : listOfFiles) {
//            if (imgFile.isFile()) {
//                System.out.println(imgFile.getName());
//                byte[] bytes = toByteArray(imgFile.getAbsolutePath());
//                java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
//                String base64Str = encoder.encodeToString(bytes);
//                ArrayList<CompletableFuture> objects = new ArrayList<>();
//                for (int i = 0; i < 1; i++) {
//                    // 判断图片方向
//                    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//                        String a = "";
//                        try {
//                            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\caijiamin\\Desktop\\base64.txt"));
//                            StringBuilder stringBuilder = new StringBuilder();
//                            String line = null;
//                            while ((line = reader.readLine()) != null) {
//                                stringBuilder.append(line);
//                            }
//                            // 删除最后一个新行分隔符
//                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//                            reader.close();
//                            char[] chars = stringBuilder.toString().toCharArray();
//                            for (int j = 0; j < chars.length; j++) {
//                                if (chars[j] == '=') {
//                                    System.out.println(j);
//                                }
//                            }
//                            Base64.isBase64(stringBuilder.toString());
//                            String content = stringBuilder.toString().replace("\n","").replace("\r","").replace("\t","");
//                            System.out.println("并发");
//                            System.out.println(Base64.isBase64(content.getBytes()));
//                            a = sendRequest(url, content);
//                            System.out.println(a);
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//                        return a;
//                    });
//                    objects.add(future);
//                }
//                String b = "";
//                for (CompletableFuture f : objects) {
//                    try {
//                        b = String.valueOf(f.get());
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    } catch (ExecutionException e) {
////                        throw new RuntimeException(e);
//                        System.out.println(e);
//                        continue;
//                    }
//                }
//                JSONObject clasJsonRes = JSONObject.parseObject(b);
//                int clas = 0; // 图片旋转度数
//                System.out.println("=============" + (System.currentTimeMillis() - last));
//                last = System.currentTimeMillis();
//                System.out.println(clasJsonRes);
//                if (clasJsonRes.getInteger("err_no") == 0) {
//                    String angle = clasJsonRes.getJSONArray("value").getString(0).replaceAll("[^0-9]", "");
//                    clas = Integer.valueOf(angle);
//                }
//                break;
////                // 将文件格式优化为图片格式 缩小base64的大小。更容易识别
////                byte[] bytes1 = Base64.decodeBase64(base64Str);
////                Image image = Toolkit.getDefaultToolkit().createImage(bytes1);
////                BufferedImage bufferedImage = toBufferedImage(image);
////
////                // 角度有问题 对图片进行旋转
////                if (clas > 0) {
////                    // 创建一个旋转后的BufferedImage
////                    BufferedImage rotatedImage = rotateImage(bufferedImage, Double.valueOf(360 - clas));
////                    bufferedImage = rotatedImage;
////                }
////                // 处理图像
//////                removeRedStamp(bufferedImage);
////                bufferedImage.setRGB(0, 0, BufferedImage.TYPE_3BYTE_BGR);
////                // 保存处理后的图像
////                ImageIO.write(bufferedImage, "jpg", new File(saveFilePath + textIdx + ".jpg"));
////                textIdx++;
//            }
//        }
//    }
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
//
//    private static void removeRedStamp(BufferedImage image) {
//        int redLower = 185;
//        int redUpper = 255;
//        int width = image.getWidth();
//        int height = image.getHeight();
//        if (height < width) {
//            return;
//        }
//        // 遍历图像的每个像素
//        for (int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                // 获取当前像素的 RGB 值
//                int rgb = image.getRGB(x, y);
//
//                // 分离红色通道值
//                int red = (rgb >> 16) & 0xFF;
//
//                // 如果红色在指定范围内，将当前像素设为背景色（白色）
//                if (red >= redLower && red <= redUpper) {
//                    image.setRGB(x, y, Color.WHITE.getRGB());
//                }
//            }
//        }
//    }
//
//    public static BufferedImage rotateImage(BufferedImage originalImage, double angle) {
//        int width = originalImage.getWidth();
//        int height = originalImage.getHeight();
//
//        BufferedImage rotatedImage = new BufferedImage(width, height, originalImage.getType());
//        Graphics2D g2d = rotatedImage.createGraphics();
//
//        // 设置旋转角度
//        g2d.rotate(Math.toRadians(angle), width / 2, height / 2);
//
//        // 绘制旋转后的图像
//        g2d.drawImage(originalImage, null, 0, 0);
//        g2d.dispose();
//
//        return rotatedImage;
//    }
//
//    public static String sendRequest(String url, String imageBase64) throws IOException {
//        String requestBody = String.format("{\"key\": [\"image\"], \"value\": [\"%s\"]}", imageBase64);
//        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//        connection.setRequestMethod("POST");
//        connection.setRequestProperty("Content-Type", "application/json");
//        connection.setDoOutput(true);
//        connection.setConnectTimeout(3000);
//        connection.setReadTimeout(3000);
//        try (OutputStream output = connection.getOutputStream()) {
//            output.write(requestBody.getBytes("UTF-8"));
//        }
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
//    public static BufferedImage toBufferedImage(Image image) {
//        if (image instanceof BufferedImage) {
//            return (BufferedImage) image;
//        }
//        // This code ensures that all the pixels in the image are loaded
//        image = new ImageIcon(image).getImage();
//        BufferedImage bimage = null;
//        GraphicsEnvironment ge = GraphicsEnvironment
//                .getLocalGraphicsEnvironment();
//        try {
//            int transparency = Transparency.OPAQUE;
//            GraphicsDevice gs = ge.getDefaultScreenDevice();
//            GraphicsConfiguration gc = gs.getDefaultConfiguration();
//            bimage = gc.createCompatibleImage(image.getWidth(null),
//                    image.getHeight(null), transparency);
//        } catch (HeadlessException e) {
//            // The system does not have a screen
//        }
//        if (bimage == null) {
//            // Create a buffered image using the default color model
//            int type = BufferedImage.TYPE_INT_RGB;
//            bimage = new BufferedImage(image.getWidth(null),
//                    image.getHeight(null), type);
//        }
//        // Copy image to buffered image
//        Graphics g = bimage.createGraphics();
//        // Paint the image onto the buffered image
//        g.drawImage(image, 0, 0, null);
//        g.dispose();
//        return bimage;
//    }
//}
