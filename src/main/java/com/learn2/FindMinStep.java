package com.learn2;

import java.util.Arrays;
/**
 * @describtion: 488. 祖玛游戏
 * @author: CaiJm
 * @Date: 2021-11-09 9:20
 */
public class FindMinStep {

    /*
     在一次消除完成后，若没有步数更少的方案，则将其记录到min
     boardStatus用于描述盘面情况，非常重要
      */
    int min = -1, boardStatus;

    public int findMinStep(String board, String hand) {
        int bLen = board.length();
        //真正用于计算和处理的数组，由于存在插入的情况，所以对于原数组以0进行了分割
        char[] line = new char[(bLen << 1) - 1];

        for (int i = 0; i < board.length(); i++) {
            line[i << 1] = board.charAt(i);
            //录入数据的同时记录状态
            boardStatus ^= 1 << (i << 1);
        }

        char[] hands = hand.toCharArray();
        //对数组排序的目的是让相同的手牌集中到一起，方便遍历的时候进行剪枝
        Arrays.sort(hands);
        //搜索
        dfs(line, hands, hand.length());
        return min;
    }

    void dfs(char[] board, char[] hand, int remain) {
        //表明已全部消除，原手牌与剩余手牌的差即步数
        if (boardStatus == 0) {
            int res = hand.length - remain;
            if (min == -1)
                min = res;
            else if (res < min)
                min = res;
            return;
        }

        //手牌用完还没有全消除，此次搜索失败
        if (remain == 0)
            return;

        char val = 0;
        for (int i = 0; i < board.length; i++) {
            //跳过被干掉的球（或者本身就存在的空格）以及跟上一个球同色的球（因为两者是被视为一组进行处理的）
            //PS：本身就存在的空格指最开始为了满足插入操作而填充的0，这些0有可能会通过插入变为“有球”状态并参与消除
            if ((boardStatus & (1 << i)) == 0 || board[i] == val)
                continue;

            //记录颜色（即“下次循环的上一个颜色”）
            val = board[i];
            //寻找下一个有效的球（如果存在）是否与此球同色
            int next = sameNext(board, i);

            //同色
            if (next != -1) {//double set
                //insert a ball with another color
                for (int j = 0; j < hand.length; j++) {
                    if (hand[j] != 0 && hand[j] != val && (j == 0 || hand[j - 1] != hand[j])) {
                        //save status
                        int mirror = boardStatus;
                        char temp = hand[j];
                        if (board[next - 1] != 0)
                            continue;
                        board[next - 1] = temp;
                        hand[j] = 0;
                        boardStatus ^= 1 << (next - 1);
                        dfs(board, hand, remain - 1);
                        //back track
                        boardStatus = mirror;
                        hand[j] = temp;
                    }
                }
                //pop this double with one from hand
                int j = 0;
                while (j < hand.length && hand[j] != val)
                    j++;
                if (j < hand.length) {
                    //play hand[j] and pop
                    int mirror = boardStatus;
                    hand[j] = 0;
                    boardStatus ^= 1 << i | 1 << next;
                    checkThree(board, i - 1, next + 1);
                    dfs(board, hand, remain - 1);
                    //back track
                    hand[j] = val;
                    boardStatus = mirror;
                }
            } else { // next == -1
                //pop single with double from hand
                int left = 0;
                while (left < hand.length && hand[left] != val)
                    left++;
                if (left < hand.length - 1) {
                    int right = hand.length - 1;
                    while (right > left && hand[right] != val)
                        right--;
                    if (left < right) {
                        //save
                        int mirror = boardStatus;
                        hand[left] = hand[right] = 0;
                        boardStatus ^= 1 << i;
                        checkThree(board, i - 1, i + 1);
                        dfs(board, hand, remain - 2);
                        //back track
                        hand[left] = hand[right] = val;
                        boardStatus = mirror;
                    }
                }
            }
        }
    }

    int sameNext(char[] board, int i) {
        int val = board[i];
        while (++i < board.length)
            if ((boardStatus & 1 << i) != 0)
                return board[i] == val ? i : -1;
        return -1;
    }

    //Check combo pop after a pop by playing a ball.
    void checkThree(char[] board, int left, int right) {
        //过滤无效位
        while (left >= 0 && (boardStatus & 1 << left) == 0)
            left--;
        while (right < board.length && (boardStatus & 1 << right) == 0)
            right++;

        if (left < 0 || right >= board.length || board[left] != board[right])
            return;

        //没有return，说明left和right处的球同色，继续向两端搜索同色球
        char val = board[left];

        int l = left - 1, r = right + 1;
        boolean pop = false;
        while (l >= 0) {
            if ((boardStatus & 1 << l) != 0) {
                if (board[l] == val) {
                    pop = true;
                    boardStatus ^= 1 << l;
                }
                break;
            } else
                l--;
        }
        while (r < board.length) {
            if ((boardStatus & 1 << r) != 0) {
                if (board[r] == val) {
                    pop = true;
                    boardStatus ^= 1 << r;
                }
                break;
            } else
                r++;
        }
        //表面有超过3个同色相邻的球，触发自动消除，并进一步递归检测
        if (pop) {
            //由于触发了消除，将两个同色的球位也置为“无效”
            boardStatus ^= 1 << left | 1 << right;
            checkThree(board, l, r);
        }
    }
}
