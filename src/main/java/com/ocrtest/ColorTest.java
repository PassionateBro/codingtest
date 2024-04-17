package com.ocrtest;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-12-25 13:16
 */
public class ColorTest {
    private final static int WHITE_THRESHOLD = 200;

    public static void main(String[] args) {
        try {
            // 读入图像
            BufferedImage image = ImageIO.read(new File("C:\\Users\\caijiamin\\Desktop\\报销\\test\\_ali_1cdaeb804c944644b50f365747c182bf.png"));
            long tie = System.currentTimeMillis();
            // 定义红色的 RGB 范围
            int redLower = 160;  // 调整根据实际情况
            int redUpper = 255;

            // 处理图像
            removeRedStamp(image);
            System.out.println(System.currentTimeMillis() - tie);
            // 保存处理后的图像
            ImageIO.write(image, "png", new File("C:\\Users\\caijiamin\\Desktop\\报销\\test\\result4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void removeRedStamp(BufferedImage image) {
        int redLower = 185;
        int redUpper = 255;
        int width = image.getWidth();
        int height = image.getHeight();
//        if (height < width) {
//            return;
//        }
        // 遍历图像的每个像素
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // 获取当前像素的 RGB 值
                int rgb = image.getRGB(x, y);

                // 分离红色通道值
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xfa; // 250 = 0xfa
                int blue = (rgb & 0xff); // 255 = 0xff
                // 如果红色在指定范围内，将当前像素设为背景色（白色）
                //&& green < 150 && blue < 150
                if (red >= redLower && red <= redUpper) {
                    image.setRGB(x, y, Color.WHITE.getRGB());
                }
            }
        }
    }
}
