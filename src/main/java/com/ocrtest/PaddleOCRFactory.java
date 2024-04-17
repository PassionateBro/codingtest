package com.ocrtest;


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-04-07 15:15
 */
public class PaddleOCRFactory {

    static Pattern pattern = Pattern.compile(".*\\d+.*");
    static Pattern patternNumber = Pattern.compile("\\d+");


    /**
     * 将识别数据转换为key value 形式
     * key：   识别字符串
     * score： 识别得分
     *
     * @param paddleResList
     * @return
     */
    public static LinkedList<Map<String, Object>> dataFormat(String paddleResList) {
        LinkedList<Map<String, Object>> list = new LinkedList<>();
        String[] split = paddleResList.split("]]],");
        for (int i = 0; i < split.length; i++) {
            String tempS = split[i];
            String[] textSplit = tempS.split("',");
            if (textSplit.length != 2) {
                continue;
            }
            HashMap<String, Object> map = new HashMap<>(4);
            map.put("key", textSplit[0].substring(textSplit[0].indexOf("'") + 1));
            String dealString = textSplit[1].replace(")", "").replace("[", "").replace("]", "").replace(" ", "");
            String[] dealSplit = dealString.split(",");
            map.put("score", dealSplit[0]);
            int[][] location = new int[4][2];
            int tempIdx = 1;
            for (int j = 0; j < location.length; j++) {
                for (int k = 0; k < 2; k++) {
                    location[j][k] = Double.valueOf(dealSplit[tempIdx]).intValue();
                    tempIdx++;
                }
            }
            map.put("x", location[0][0]);
            map.put("y", location[0][1]);
            map.put("location", location);
            // 置信度>0.60的字段才进行返回
            if (Float.valueOf(String.valueOf(map.get("score"))) >= 0.60f) {
                list.add(map);
            }
        }

        return list;
    }


    private static void signAgencyStream(Deque<Map<String, Object>> list, Map<String, Object> map) {
        while (!list.isEmpty()) {
            String key = String.valueOf(list.pollFirst().get("key"));
            if (key.indexOf("公安") > 0) {
                if (key.indexOf("签发机关") >= 0) {
                    // 识别合并了
                    map.put("personalInfoRegistAgency", key.substring(key.indexOf("签发机关") + 4).trim());
                    return;
                }
                map.put("personalInfoRegistAgency", key);
                return;
            }
        }
    }


}
