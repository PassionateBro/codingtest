package com.learnnew4;

import java.util.HashMap;

/**
 * @describtion: 剑指 Offer 35. 复杂链表的复制
 * @author: CaiJm
 * @Date: 2022-01-27 10:10
 */
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (head.next == null) {
            Node node = new Node(head.val);
            if (head.random == null) return node;
            node.random = node;
            return node;
        }
        Node newHead = new Node(head.val);
        Node tempNode = head;
        Node next = newHead;
        HashMap<Integer, Node> map = new HashMap<>();
        map.put(tempNode.hashCode(), newHead);
        tempNode = head.next;
        while (tempNode != null) {
            next.next = new Node(tempNode.val);
            next = next.next;
            map.put(tempNode.hashCode(), next);
            tempNode = tempNode.next;
        }

        tempNode = newHead;
        while (tempNode != null) {
            if (head.random == null) {
                tempNode.random = null;
            } else {
                tempNode.random = map.get(head.random.hashCode());
            }
            tempNode = tempNode.next;
            head = head.next;
        }
        return newHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
