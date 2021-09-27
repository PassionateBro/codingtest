package com.learn;

import java.util.*;

/**
 * @describtion: 127. 单词接龙
 * @author: CaiJm
 * @Date: 2021-09-26 17:11
 */
public class LadderLength {
    /**
     * dfs 超时版本
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        int len = wordList.size();
        int[] used = new int[len];
        ArrayList<Integer> objects = new ArrayList<>();
        dfs(used, wordList, 0, beginWord, endWord, objects);
        if (objects.size() == 0) return 0;
        int min = Integer.MAX_VALUE;
        for (Integer i : objects) {
            min = Math.min(min, i);
        }
        return min + 1;
    }

    private void dfs(int[] used, List<String> wordList, int num, String beginWord, String endWord, List res) {
        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            if (used[i] == 1) continue;
            int judge = 0;
            String judgeWord = wordList.get(i);
            char[] chars = beginWord.toCharArray();
            char[] chars1 = judgeWord.toCharArray();
            int blen = beginWord.length();
            for (int j = 0; j < blen; j++) {
                if (chars[j] != chars1[j]) judge++;
                if (judge >= 2) break;
            }
            if (judge == 1) {
                if (judgeWord.equals(endWord)) {
                    res.add(num + 1);
                    return;
                } else {
                    used[i] = 1;
                    dfs(used, wordList, num + 1, judgeWord, endWord, res);
                    used[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(new String[]{"hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot"});

        System.out.println(new LadderLength().ladderLength("hot", "dog", strings));
    }

    /**
     * bfs
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int lad(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList); //转换为hashset 加快速度
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {  //特殊情况判断
            return 0;
        }
        Queue<String> queue = new LinkedList<>(); //bfs 队列
        queue.offer(beginWord);
        Map<String, Integer> map = new HashMap<>(); //记录单词对应路径长度
        map.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll(); //取出队头单词
            int path = map.get(word); //获取到该单词的路径长度
            for (int i = 0; i < word.length(); i++) { //遍历单词的每个字符
                char[] chars = word.toCharArray(); //将单词转换为char array，方便替换
                for (char k = 'a'; k <= 'z'; k++) { //从'a' 到 'z' 遍历替换
                    chars[i] = k; //替换第i个字符
                    String newWord = String.valueOf(chars); //得到新的字符串
                    if (newWord.equals(endWord)) {  //如果新的字符串值与endWord一致，返回当前长度+1
                        return path + 1;
                    }
                    if (wordSet.contains(newWord) && !map.containsKey(newWord)) { //如果新单词在set中，但是没有访问过
                        map.put(newWord, path + 1); //记录单词对应的路径长度
                        queue.offer(newWord);//加入队尾
                    }
                }
            }
        }
        return 0; //未找到
    }
}
