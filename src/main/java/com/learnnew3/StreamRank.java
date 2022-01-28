package com.learnnew3;

/**
 * @describtion: 面试题 10.10. 数字流的秩
 * @author: CaiJm
 * @Date: 2022-01-13 16:46
 */
public class StreamRank {

    private ArrayNode lastNode;

    public StreamRank() {
        lastNode = new ArrayNode();
        lastNode.idx = 1;
        lastNode.val = 500001;
    }

    public void track(int x) {
        ArrayNode arrayNode = new ArrayNode();
        arrayNode.val = x;
        find(lastNode, arrayNode);
    }

    private ArrayNode find(ArrayNode node, ArrayNode judgeNode) {
        if (node == null) {
            judgeNode.idx = 1;
            return judgeNode;
        }
        if (judgeNode.val >= node.val) {
            judgeNode.idx = node.idx + 1;
            judgeNode.before = node;
            return judgeNode;
        } else {
            ArrayNode arrayNode = find(node.before, judgeNode);
            node.before = arrayNode;
            node.idx++;
            return node;
        }
    }

    public int getRankOfNumber(int x) {
        ArrayNode node = lastNode;
        while (node != null) {
            if (node.val <= x) return node.idx;
            node = node.before;
        }
        return 0;
    }

    class ArrayNode {
        public ArrayNode before;
        public int val;
        public int idx;

        public ArrayNode() {

        }
    }

}
