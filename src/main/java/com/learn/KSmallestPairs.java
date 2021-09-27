package com.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @describtion: 373. 查找和最小的K对数字
 * @author: CaiJm
 * @Date: 2021-09-22 16:18
 */
public class KSmallestPairs {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result=new ArrayList<>();
        PriorityQueue<List<Integer>> heap=new PriorityQueue<>((a, b)-> -(a.get(0)+a.get(1))+(b.get(0)+b.get(1)));
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                ArrayList<Integer> list=null;
                if(heap.size()<k){
                    list=new ArrayList<Integer>();
                    list.add(nums1[i]);
                    list.add(nums2[j]);
                    heap.add(list);
                }else{
                    List<Integer> peek=heap.peek();
                    if(nums1[i]+nums2[j]<peek.get(0)+peek.get(1)){
                        heap.poll();
                        list=new ArrayList<Integer>();
                        list.add(nums1[i]);
                        list.add(nums2[j]);
                        heap.add(list);
                    }else{
                        break;
                    }
                }
            }
        }
        while(heap.size()>0){
            result.add(heap.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));
    }
}
