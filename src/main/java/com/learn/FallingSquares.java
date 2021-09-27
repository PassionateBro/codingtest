package com.learn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @describtion: 699. 掉落的方块
 * <p>
 * 在无限长的数轴（即 x 轴）上，我们根据给定的顺序放置对应的正方形方块。
 * <p>
 * 第 i 个掉落的方块（positions[i] = (left, side_length)）是正方形，其中left 表示该方块最左边的点位置(positions[i][0])，side_length 表示该方块的边长(positions[i][1])。
 * <p>
 * 每个方块的底部边缘平行于数轴（即 x 轴），并且从一个比目前所有的落地方块更高的高度掉落而下。在上一个方块结束掉落，并保持静止后，才开始掉落新方块。
 * <p>
 * 方块的底边具有非常大的粘性，并将保持固定在它们所接触的任何长度表面上（无论是数轴还是其他方块）。邻接掉落的边不会过早地粘合在一起，因为只有底边才具有粘性。
 * <p>
 * <p>
 * <p>
 * 返回一个堆叠高度列表ans 。每一个堆叠高度ans[i]表示在通过positions[0], positions[1], ..., positions[i]表示的方块掉落结束后，目前所有已经落稳的方块堆叠的最高高度。
 * @author: CaiJm
 * @Date: 2021-09-16 9:40
 */
public class FallingSquares {
    public List<Integer> fallingSquares(int[][] positions) {
        Node dummy = new Node(0, Integer.MAX_VALUE, 0, null);
        int n = positions.length;
        List<Integer> res = new ArrayList<>(n);
        int maxHeight = 0;
        for (int[] position : positions) {
            int left = position[0];
            int right = left + position[1];
            Node leftNode = dummy;
            while (left >= leftNode.r) {
                leftNode = leftNode.next;
            }
            int currentHeight = leftNode.height;
            Node rightNode = leftNode;
            while (right > rightNode.r) {
                rightNode = rightNode.next;
                currentHeight = Math.max(currentHeight, rightNode.height);
            }
            if (leftNode == rightNode) {
                rightNode = new Node(right, rightNode.r, rightNode.height, rightNode.next);
            } else {
                rightNode.l = right;
            }
            Node node = new Node(left, right, currentHeight + position[1], rightNode);
            leftNode.r = left; leftNode.next = node;
            maxHeight = Math.max(maxHeight, node.height);
            res.add(maxHeight);
        }
        return res;
    }

    private static class Node {
        private int l;
        private int r;
        private int height;
        private Node next;

        public Node(int l, int r, int height, Node next) {
            this.l = l;
            this.r = r;
            this.height = height;
            this.next = next;
        }
    }
}
