package com.work;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.RandomUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-09-15 14:02
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> rewardNumbers = new ArrayList<>();
        int canCrushNumber = 100;
        int configRewardNumber = 80;

        /**
         * 1.如果m <= n，则所有人都必中奖
         * 2.如果m > n，从m中生成n个随机数保存在redis中，司机端抽奖时，维护一个自增的数，司机抽奖自动加1，当累计的值等于生成的随机数时
         * 判断该司机中奖，否则就发安慰奖
         */
        if (canCrushNumber <= configRewardNumber) {
            for (int i = 0; i < canCrushNumber; i++) {
                rewardNumbers.add(i + 1);
            }
        } else {
            double loop = new BigDecimal(canCrushNumber).divide(new BigDecimal(configRewardNumber), 2, BigDecimal.ROUND_DOWN).doubleValue();
            double left = 1.;
            double right = loop;
            for (int i = 1; i <= configRewardNumber; i++) {
                int max = (int) (right + 1);
                if (i == configRewardNumber) {
                    max = canCrushNumber + 1;
                }
                rewardNumbers.add(RandomUtil.randomInt((int) left, max));
                left = max;
                right = max + (loop - (left - right));
            }
        }

        System.out.println(rewardNumbers);
        System.out.println(CollectionUtil.join(rewardNumbers, ","));
    }
}
