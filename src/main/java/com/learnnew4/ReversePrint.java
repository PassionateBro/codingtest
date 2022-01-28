package com.learnnew4;

import java.util.Stack;

/**
 * @describtion: 剑指 Offer 06. 从尾到头打印链表
 * @author: CaiJm
 * @Date: 2022-01-27 9:55
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
