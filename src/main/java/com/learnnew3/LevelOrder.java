package com.learnnew3;

import com.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @describtion: 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * @author: CaiJm
 * @Date: 2021-12-17 14:33
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        add(root, 0, list);
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 != 0) {
                Collections.reverse(list.get(i));
            }
        }
        return list;
    }

    private void add(TreeNode root, int idx, ArrayList<List<Integer>> list) {
        if (root == null) return;
        if (list.size() <= idx) {
            list.add(idx, new ArrayList<>());
        }
        list.get(idx).add(root.val);
        add(root.left, idx + 1, list);
        add(root.right, idx + 1, list);
    }
}
