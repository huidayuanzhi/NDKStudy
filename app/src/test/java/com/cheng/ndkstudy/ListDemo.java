package com.cheng.ndkstudy;

public class ListDemo {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /**
     * 876. 链表的中间结点
     * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     */
    public static ListNode middleNode(ListNode head) {
        if (head == null) return head;
        ListNode slower = head;
        ListNode faster = head;
        while (faster != null && faster.next != null) {
            slower = slower.next;
            faster = faster.next.next;
        }
        return slower;
    }

    /**
     * 234. 回文链表
     * 示例 1：
     * 输入：head = [1,2,2,1]
     * 输出：true
     * 示例 2：
     * 输入：head = [1,2]
     * 输出：false
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = rotate(slow.next);
        ListNode pre = slow;
        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        rotate(pre);
        return true;
    }

    private static ListNode rotate(ListNode head) {
        ListNode pre = head;
        while (head != null && head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre;
            pre = next;
        }
        return pre;
    }

    /**
     * 206. 反转链表
     * 示例 1：
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     * 示例 2：
     * 输入：head = [1,2]
     * 输出：[2,1]
     */
    // 方法一：迭代
    public static ListNode reverseList1(ListNode head) {
        if (head == null) return head;
        ListNode pre = head;
        while (head != null && head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre;
            pre = next;
        }
        return pre;
    }

    // 方法二：递归
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}
