package com.learnnew4;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-02-09 9:44
 */
public class Connect {
    public Node connect(Node root) {
        bfs(root);
        return root;
    }

    private void bfs(Node node) {
        if (node == null) return;
        Node tempNode = null, nextNode = node.next;
        while (tempNode == null && nextNode != null) {
            if (nextNode.right != null) {
                tempNode = nextNode.right;
            }
            if (nextNode.left != null) {
                tempNode = nextNode.left;
            }
            if (tempNode == null) {
                nextNode = nextNode.next;
            }
        }
        if (node.right != null) {
            node.right.next = tempNode;
        }
        if (node.left != null) {
            if (node.right != null) {
                node.left.next = node.right;
            } else {
                node.left.next = tempNode;
            }
        }
        bfs(node.right);
        bfs(node.left);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
