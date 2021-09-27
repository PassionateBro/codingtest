package com.learn;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @describtion: 剑指 Offer II 025. 链表中的两数相加
 *
 * 正解应该直接把链表反向去处理，不要使用额外空间
 * @author: CaiJm
 * @Date: 2021-09-27 10:27
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new LinkedList<>();
        ListNode node1 = l1;
        ListNode node2 = l2;
        while (true) {
            list1.add(node1.val);
            if (node1.next == null) {
                break;
            } else {
                node1 = node1.next;
            }
        }
        List<Integer> list2 = new LinkedList<>();
        while (true) {
            list2.add(node2.val);
            if (node2.next == null) {
                break;
            } else {
                node2 = node2.next;
            }
        }
        Stack<ListNode> stack = new Stack<>();
        int i = list1.size() - 1;
        int j = list2.size() - 1;
        int nextval = 0;
        while (true) {
            if (i < 0 && j < 0) {
                if (nextval > 0) {
                    stack.push(new ListNode(nextval));
                }
                break;
            }
            int num1 = 0, num2 = 0;
            if (i >= 0) {
                num1 = list1.get(i);
                i--;
            }
            if (j >= 0) {
                num2 = list2.get(j);
                j--;
            }
            int res = num1 + num2 + nextval;
            if (res > 9) {
                nextval = res / 10;
                res = res % 10;
            } else {
                nextval = 0;
            }
            stack.push(new ListNode(res));
        }
        ListNode pop = stack.pop();
        ListNode begin = pop;
        while (!stack.empty()) {
            ListNode pop1 = stack.pop();
            pop.next = pop1;
            pop = pop1;
        }
        return begin;
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
