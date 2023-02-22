package com.lerannew7;

import java.util.Arrays;

/**
 * @describtion: 2187. 完成旅途的最少时间
 * @author: CaiJm
 * @Date: 2023-02-08 13:35
 */
public class MinimumTime {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        // 计算最长时间:全部旅途都用速度最快的一辆车跑完
        long right = 1L * time[0] * totalTrips;
        long left = 0;
        // 进行二分查找
        while(left < right) {
            long mid = (left + right) >>> 1;
            // 计算mid时间能走的旅途次数
            long trips = 0;
            for(int t : time) {
                // 当mid时间不足以完成一趟旅途,接下来的车更不可能,退出
                if(mid < t) {
                    break;
                }
                // 累加每辆车在mid时间内能完成的旅行次数
                trips += mid / t;
            }
            // 判断trips与totalTrips的大小关系进行转移
            if(trips >= totalTrips)  {
                // 旅途数超标,时间还可以再优化,向左查找
                right = mid;
            }else {
                // 旅途数不足,时间不足,向右查找
                left = mid + 1;
            }
        }
        // 最后left=right,任意返回一个即可
        return left;
    }
}
