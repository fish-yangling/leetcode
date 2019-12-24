package com.yangling.leetcode.linkedlist;

/**
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 标签：链表 + 虚拟头节点
 * 思路：相同长度链表的遍历，若一个链表较短，则添加0
 * 进位
 * 全部遍历完成后，若有进位，则在链表中添加元素
 */
public class _2_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        //虚拟头节点
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        //计算进位值
        int carry = 0;

        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            int sum = num1 + num2 + carry;
            int val = sum % 10;
            carry = sum / 10;

            cur.next = new ListNode(val);

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

            cur = cur.next;
        }

        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return pre.next;
    }

    public static void main(String[] args) {
        _2_Add_Two_Numbers at = new _2_Add_Two_Numbers();
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(0);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(9);

        ListNode listNode = at.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

}

