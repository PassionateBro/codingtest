package com.learnnew4;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-02-09 16:43
 */
public class GetKthFromEnd {
    ListNode res = null;

    public ListNode getKthFromEnd(ListNode head, int k) {
        deal(head, k);
        return res;
    }

    public int deal(ListNode head, int k) {
        if (head == null) {
            return 0;
        }
        int now = deal(head.next, k) + 1;
        if (now == k) {
            res = head;
        }
        return now;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
