package com;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2021-12-17 10:10
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        String s=  "性别男民族汉";
        System.out.println(s.substring(s.indexOf("性别") + 2, s.indexOf("性别") + 3));
    }
}
