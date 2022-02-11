package com.learnnew4;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-02-09 16:35
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        del(head, val);
        return head;
    }

    private void del(ListNode node, int val) {
        if (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                del(node.next, val);
            }
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
