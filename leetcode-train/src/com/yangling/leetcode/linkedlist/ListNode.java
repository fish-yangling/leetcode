package com.yangling.leetcode.linkedlist;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);

        ListNode node = listNode;
        listNode = listNode.next;
        System.out.println(node.val);
    }
}
