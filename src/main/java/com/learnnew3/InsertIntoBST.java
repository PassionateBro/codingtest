package com.learnnew3;

import com.TreeNode;

/**
 * @describtion: 701. 二叉搜索树中的插入操作
 * @author: CaiJm
 * @Date: 2021-12-17 10:09
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val < val){
            root.right = insertIntoBST(root.right,val);
        } else {
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }
}
