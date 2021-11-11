package com.learn2;

/**
 * @describtion: 237. 删除链表中的节点
 * @author: CaiJm
 * @Date: 2021-11-02 9:09
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
