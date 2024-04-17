package com.ocrtest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.*;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-06-14 10:53
 */
public class TestDel {
    public static void main(String[] args) {
        String filePath = "D:\\cjm\\feijiang\\PaddleOCR\\train_data\\idcar2015\\text_localization\\driver_license_img\\Label.txt";
        String updatedFilePath = "D:\\cjm\\feijiang\\PaddleOCR\\train_data\\idcar2015\\text_localization\\driver_license_img\\Label_del.txt";

        // 读取文件
        String content = readFile(filePath);
        String[] id_card_front_imgs = content.split("driver_license_img");
        String newContent ="";
        for (int i = 1; i < id_card_front_imgs.length; i++) {
            String[] split = id_card_front_imgs[i].split("\t");
            JsonArray jsonArray = new Gson().fromJson(split[1], JsonArray.class);
            for (int j = 0; j < jsonArray.size(); j++) {
                JsonObject item = jsonArray.get(j).getAsJsonObject();
                if (item.get("transcription").getAsString().equals("initial_no")) {
                    jsonArray.remove(j);
                    j--;
                }
            }
            // 将修改后的JsonArray转换为字符串
            String updatedContent = new GsonBuilder().disableHtmlEscaping().create().toJson(jsonArray);
            newContent += "driver_license_img" + split[0] + "\t" + updatedContent + "\n";
        }
//        newContent = newContent.replaceAll(",",", ");
//        newContent = newContent.replaceAll(":",": ");
        saveFile(updatedFilePath, newContent);
    }

    private static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private static void saveFile(String filePath, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
