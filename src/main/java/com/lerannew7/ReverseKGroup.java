package com.lerannew7;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-02-21 13:46
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode newHead = null;
        ListNode lastNode = null;
        Deque<ListNode> deque = new LinkedList();
        int temp = k;
        ListNode tempNode = head;
        while (tempNode != null) {
            deque.addLast(tempNode);
            tempNode = tempNode.next;
            temp--;
            if (temp == 0) {
                // 翻转
                while (!deque.isEmpty()) {
                    ListNode listNode = deque.pollLast();
                    if (lastNode == null) {
                        newHead = listNode;
                    } else {
                        lastNode.next = listNode;
                        if (listNode.next == lastNode) {
                            listNode.next = null;
                        }
                    }
                    lastNode = listNode;
                }
                temp = k;
            }
        }
        if (!deque.isEmpty()) {
            lastNode.next = deque.pollFirst();
        }
        return newHead;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
