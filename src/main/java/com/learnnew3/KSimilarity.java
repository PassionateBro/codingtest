//package com.learnnew3;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @describtion:
// * @author: CaiJm
// * @Date: 2022-01-10 15:10
// */
//public class KSimilarity {
//    int sum = 0;
//
//    public int kSimilarity(String s1, String s2) {
//        int len1 = s1.length();
//        char[] char1 = s1.toCharArray();
//        char[] char2 = s2.toCharArray();
//        ArrayList<Character> list1 = new ArrayList<>();
//        ArrayList<Character> list2 = new ArrayList<>();
//        for (int i = 0; i < len1; i++) {
//            list1.add(char1[i]);
//            list2.add(char2[i]);
//        }
//        bfs(list1, list2);
//        return sum;
//    }
//
//    private int bfs(List<Character> list1, List<Character> list2, int sum) {
//        if (list1.size() == 0 || list2.size() == 0) return sum;
//        ArrayList<Character> newList1 = new ArrayList<>();
//        ArrayList<Character> newList2 = new ArrayList<>();
//        for (int i = 0, size = list1.size(); i < size; i++) {
//            char c = list1.get(i);
//            if (c == list2.get(i)) continue;
//            for (int j = i + 1, sizeJ = list2.size(); j < sizeJ; j++) {
//                if (c == list2.get(j) && list1.get(j) == list2.get(i)) {
//                    char temp = list2.get(i);
//                    list2.set(i, c);
//                    list2.set(j, temp);
//                    sum++;
//                    break;
//                }
//            }
//            if (list1.get(i) != list2.get(i)) {
//                newList1.add(list1.get(i));
//                newList2.add(list2.get(i));
//            }
//        }
//        // 剩下无法抵消的数据对，寻找使一个数据相等的进行交换
//        for (int i = 0, size = newList1.size(); i < size; i++) {
//            char a = newList1.get(i);
//            if (a == newList2.get(i)) continue;
//            for (int j = i + 1, sizeJ = newList2.size(); j < sizeJ; j++) {
//                if (newList2.get(j) == a) {
//                    newList2.set(j, newList2.get(i));
//                    newList2.set(i, a);
//                    sum++;
//                    break;
//                }
//            }
//        }
//        bfs(newList1, newList2);
//    }
//
//    public static void main(String[] args) {
//        KSimilarity kSimilarity = new KSimilarity();
//        System.out.println(kSimilarity.kSimilarity("aabcde","cdaeba"));
//    }
//
//}
