package com.learnnew4;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-01-27 10:04
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode temp = null;
        ListNode next = head;
        while (next != null) {
            next = head.next;
            head.next = temp;
            temp = head;
            if (next != null) {
                head = next;
            }
        }
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
