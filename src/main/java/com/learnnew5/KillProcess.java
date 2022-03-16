package com.learnnew5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @describtion: 582. 杀掉进程
 * @author: CaiJm
 * @Date: 2022-03-15 14:20
 */
public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0, size = pid.size(); i < size; i++) {
            int parent = ppid.get(i);
            TreeNode treeNode = map.get(parent);
            if (treeNode == null) {
                treeNode = new TreeNode(parent);
                map.put(parent, treeNode);
            }
            TreeNode son = map.get(pid.get(i));
            if (son == null) {
                son = new TreeNode(pid.get(i));
                map.put(pid.get(i), son);
            }
            treeNode.list.add(son);
        }
        TreeNode head = map.get(0);
        List<Integer> res = new ArrayList<>();
        dfs(kill, head, res, false);
        return res;
    }

    private void dfs(int kill, TreeNode node, List<Integer> res, boolean kills) {
        if (node == null) return;
        if (node.val == kill) {
            kills = true;
        }
        List<TreeNode> list = node.list;
        if (kills == true) {
            res.add(node.val);
        }
        for (TreeNode node1 : list) {
            if (node1.val == kill) {
                dfs(kill, node1, res, true);
            } else {
                dfs(kill, node1, res, kills);
            }
        }
    }

    class TreeNode {
        int val;
        List<TreeNode> list;

        public TreeNode(int val) {
            this.val = val;
            list = new ArrayList<>();
        }
    }
}
