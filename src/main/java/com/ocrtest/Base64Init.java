package com.ocrtest;


import java.io.*;
import java.util.Base64;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-06-25 13:49
 */
public class Base64Init {

    public static void main(String[] args) throws IOException {
        String filePath = "C:/Users/caijiamin/Desktop/64.txt";

        try {
            // 读取文件内容
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] fileBytes = new byte[(int) file.length()];
            fileInputStream.read(fileBytes);
            fileInputStream.close();

            // 将文件内容转换为Base64编码
            String base64Encoded = Base64.getEncoder().encodeToString(fileBytes);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(base64Encoded);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
