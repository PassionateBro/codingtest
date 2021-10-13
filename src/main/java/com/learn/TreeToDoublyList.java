package com.learn;

import java.util.LinkedList;

/**
 * @describtion: 剑指 Offer 36. 二叉搜索树与双向链表
 * @author: CaiJm
 * @Date: 2021-10-12 10:55
 */
public class TreeToDoublyList {
    Node minNode = null;
    Node maxNode = null;
    LinkedList<Node> nodes;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        nodes = new LinkedList<>();
        pushStack(root);
        maxNode = nodes.get(0);
        nodes.remove(0);
        Node tempNode = maxNode;
        for (Node node : nodes) {
            tempNode.left = node;
            node.right = tempNode;
            tempNode = node;
        }
        minNode = tempNode;
        minNode.left = maxNode;
        maxNode.right = minNode;
        return minNode;
    }

    public void pushStack(Node node) {
        if (node == null) return;
        if (node.right != null) {
            pushStack(node.right);
        }
        nodes.add(node);
        if (node.left != null) {
            pushStack(node.left);
        }
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public static void main(String[] args) {
        TreeToDoublyList treeToDoublyList = new TreeToDoublyList();
        Node node27 = new Node(27);
        Node nodeD99 = new Node(-99);
        Node node55 = new Node(55);
        Node nodeD34 = new Node(-34);
        Node node58 = new Node(58);
        Node nodeD8 = new Node(-8);
        Node node59 = new Node(59);
        Node node8 = new Node(8);
        Node node68 = new Node(68);
        node27.right = node55;
        node27.left = nodeD99;
        nodeD99.right = nodeD34;
        nodeD34.right = nodeD8;
        nodeD8.right = node8;
        node55.right = node58;
        node58.right = node59;
        node59.right = node68;
        treeToDoublyList.treeToDoublyList(node27);
    }
}
