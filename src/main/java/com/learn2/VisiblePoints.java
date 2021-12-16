package com.learn2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @describtion: 1610. 可见点的最大数目
 * @author: CaiJm
 * @Date: 2021-12-16 13:53
 */
public class VisiblePoints {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int samePointNum = 0;
        List<Double> degrees = new ArrayList<>();
        int locX = location.get(0) , locY = location.get(1);
        // 计算每个点到location的角度
        for(List<Integer> point:points){
            int curX = point.get(0) , curY = point.get(1);
            if(curX==locX && curY==locY){
                samePointNum++;
            }else{
                degrees.add(Math.atan2(curY-locY,curX-locX)/Math.PI*180);
            }
        }
        // 排序
        Collections.sort(degrees);
        // 因为是个环，把末尾的部分加上
        // 可以不用全加进去 只需要degrees.get(i)+180<=angle
        int n = degrees.size();
        for(int i=0;i<n && degrees.get(i)+180<=angle;i++){
            degrees.add(degrees.get(i)+360);
        }
        // 滑动窗口
        int res = 0;
        int left = 0 , right = 0;
        while(right<degrees.size()){
            right++;
            while(left<right && degrees.get(right-1)-degrees.get(left)>angle){
                left++;
            }
            res = Math.max(res , right-left);
        }
        return res+samePointNum;
    }

}
