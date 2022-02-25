package com.learnnew5;

import java.util.Arrays;

/**
 * @describtion: 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * @author: CaiJm
 * @Date: 2022-02-15 14:45
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) return false;
        if (postorder.length <= 2) return true;
        int rootValue = postorder[postorder.length - 1];
        int rightIdx = postorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            if (postorder[i] > rootValue) {
                rightIdx = i;
            } else {
                break;
            }
        }
        for (int i = 0; i < rightIdx; i++) {
            if (postorder[i] > rootValue) return false;
        }
        int[] left = Arrays.copyOfRange(postorder, 0, rightIdx);
        int[] right = Arrays.copyOfRange(postorder, rightIdx, postorder.length - 1);
        return verifyPostorder(left) && verifyPostorder(right);
    }

    public static void main(String[] args) {
        int[] s =  new int[]{4, 6,7,5};
        VerifyPostorder a = new VerifyPostorder();
        a.verifyPostorder(s);
    }
}
