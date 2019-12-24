package com.yangling.leetcode.linkedlist;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class _206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        //解法1：迭代+外部空间 - 空间复杂度：O(n)
        /*ListNode curr = head.next;
        ListNode res = new ListNode(head.val);
        while (curr != null) {
            ListNode tmp = new ListNode(curr.val);
            tmp.next = res;
            res = tmp;
            curr = curr.next;
        }

        return res;
        */

        //解法2：双指针迭代，- 空间复杂度：O(1)
        /*ListNode curr = head;
        ListNode pre = null, tmp;

        while (curr != null) {
            tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }

        return pre;*/

        //解法3：递归
        if (head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}
