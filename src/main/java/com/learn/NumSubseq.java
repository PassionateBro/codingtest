package com.learn;

import java.util.Arrays;

/**
 * @describtion: 1498. 满足条件的子序列数目
 * @author: CaiJm
 * @Date: 2021-09-23 9:06
 */
public class NumSubseq {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1000000007;
        int res=0;
        int n=nums.length;
        int[] pow = new int[n];
        pow[0]=1;
        for(int i=1;i<n;i++){
            pow[i]=pow[i-1]*2%mod;
        }
        int left=0,right=n-1;
        while(left<=right){
            if(nums[left]+nums[right]<=target){
                res+=pow[right-left];
                res%=mod;
                left++;
            }
            else
                right--;
        }
        return res;
    }

    public static void main(String[] args) {
        NumSubseq numSubseq = new NumSubseq();
        System.out.println(numSubseq.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
    }
}
