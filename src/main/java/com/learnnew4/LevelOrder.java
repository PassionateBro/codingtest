package com.learnnew4;

import java.util.ArrayList;
import java.util.List;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-02-08 14:24
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayList<List<Integer>> objects = new ArrayList<>();
        pr(root, objects, 0);
        return objects;
    }

    private void pr(TreeNode root, ArrayList<List<Integer>> mainList, int idx) {
        List<Integer> addList;
        if (mainList.size() <= idx) {
            addList = new ArrayList<>();
            mainList.add(addList);
        } else {
            addList = mainList.get(idx);
        }
        addList.add(root.val);
        if (root.left != null) {
            pr(root.left, mainList, idx + 1);
        }
        if (root.right != null) {
            pr(root.right, mainList, idx + 1);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
