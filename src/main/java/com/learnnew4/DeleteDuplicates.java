package com.learnnew4;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2022-01-28 13:44
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        //dummy节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //记录前置节点，处理要删除的情况
        ListNode pre = dummy;
        //记录当前节点，需要遍历整个链表
        ListNode cur = head;

        while (cur != null) {
            //找到下一个cur和cur.next不相同的位置
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            //cur往前走一步，为不相同的两个值的后者，如3->3->4, 不相同的位置为3->4,后者为4
            cur = cur.next;
            /**
             * 如果前置节点和cur的位置超过2，如1->2->3，3和1的距离未超过2，反之1->2->2->3,3和1的距离超过2
             * 则将前置节点pre直接连接当前节点cur
             * 否则前置节点向前
             */
            if (pre.next.next != cur) {
                pre.next = cur;
            } else {
                pre = pre.next;
            }
        }

        return dummy.next;
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
