package com.learn;

import java.util.ArrayList;

/**
 * @describtion: 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 * @author: CaiJm
 * @Date: 2021-09-06 16:13
 */
public class RemoveNthFromEnd {

    public static class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> nodesList = new ArrayList<>();
        ListNode tempNode = head;
        while (tempNode != null) {
            nodesList.add(tempNode);
            tempNode = tempNode.next;
        }
        int x = nodesList.size();
        if (x == n) {
            return head.next;
        }
        nodesList.add(null);
        nodesList.get(x - n - 1).next = nodesList.get(x - n + 1);
        return head;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        removeNthFromEnd.removeNthFromEnd(new ListNode(1, new ListNode(2, null)), 2);
    }
}
