package com.lerannew7;

import java.util.PriorityQueue;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-02-22 14:12
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode node = null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> {
            return o1.val - o2.val;
        });
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            while (list != null) {
                queue.offer(list);
                list = list.next;
            }
        }
        ListNode temp = null;
        if (!queue.isEmpty()) {
            node = queue.poll();
            temp = node;
        }
        while (!queue.isEmpty()) {
            temp.next = queue.poll();
            temp = temp.next;
        }
        if (temp != null) {
            temp.next = null;
        }
        return node;
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(new Integer(0x3f));
    }

    class ListNode {
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
