package com.learnnew3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-01-21 14:59
 */
public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ArrayList<TreeNode> res = new ArrayList<>();
        viewAll(root, new HashMap<>(), res);
        return res;
    }

    private String viewAll(TreeNode node, HashMap<String, Integer> map, List<TreeNode> res) {
        if (node == null) return "#";
        String s = node.val + "#" + viewAll(node.left, map, res) + "#" + viewAll(node.right, map, res);
        ;
        if (map.containsKey(s)) {
            if (map.get(s) == 0) {
                res.add(node);
                map.put(s, 1);
            }
        } else {
            map.put(s, 0);
        }
        return s;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
