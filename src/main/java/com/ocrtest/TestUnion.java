package com.ocrtest;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

import com.google.gson.*;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-05-18 16:49
 */
public class TestUnion {
    public static void main(String[] args) {
        String filePath = "D:\\cjm\\feijiang\\PaddleOCR\\train_data\\idcar2015\\text_localization\\driver_license_img_1\\Label4.txt";
        String updatedFilePath = "D:\\cjm\\feijiang\\PaddleOCR\\train_data\\idcar2015\\text_localization\\driver_license_img_1\\Label5.txt";

        // 读取文件
        String content = readFile(filePath);
        String[] id_card_front_imgs = content.split("driver_license_img");
        String newContent ="";
        for (int i = 1; i < id_card_front_imgs.length; i++) {
            String[] split = id_card_front_imgs[i].split("\t");
            JsonArray jsonArray = new Gson().fromJson(split[1], JsonArray.class);
            JsonArray jsonArray1 = new JsonArray();
            TreeMap<Integer,JsonObject> map = new TreeMap<>();
            for (int j = 0; j < jsonArray.size(); j++) {
                JsonObject item = jsonArray.get(j).getAsJsonObject();
                if (item.get("transcription").getAsString().equals("valid_date_begin")) {
                    map.put(new Integer(8888), item);
                } else if (item.get("transcription").getAsString().equals("valid_date_end")) {
                    map.put(new Integer(9999), item);
                } else {
                    JsonArray points = item.get("points").getAsJsonArray();
                    JsonElement jsonElement = points.get(0).getAsJsonArray().get(1);
                    map.put(jsonElement.getAsInt(),item);
                }
            }
            for (JsonObject value : map.values()) {
                jsonArray1.add(value);
            }
            // 将修改后的JsonArray转换为字符串
            String updatedContent = new GsonBuilder().disableHtmlEscaping().create().toJson(jsonArray1);
            newContent += "driver_license_img" + split[0] + "\t" + updatedContent + "\n";
        }
        newContent = newContent.replaceAll(",",", ");
        newContent = newContent.replaceAll(":",": ");
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
