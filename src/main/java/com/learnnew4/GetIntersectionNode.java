package com.learnnew4;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-02-09 17:09
 */
public class GetIntersectionNode {
    ListNode res = null;

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode n1 = headA;
        ListNode n2 = headB;

        while(n1 != n2){
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
