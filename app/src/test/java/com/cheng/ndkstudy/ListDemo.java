package com.cheng.ndkstudy;

import androidx.annotation.NonNull;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ListDemo {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @NonNull
        @Override
        public String toString() {
            return super.toString() + " -> val = " + val;
        }
    }

    /**
     * 876. 链表的中间结点
     * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     */
    public static ListNode middleNode(ListNode head) {
        return null;
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
        return false;
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
        return null;
    }

    public static ListNode reverseList2(ListNode head) {
        return null;
    }

    // 方法二：递归
    public static ListNode reverseList3(ListNode head) {
        return null;
    }

    /**
     * 23. 合并 K 个升序链表
     * 示例 1：
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        return null;
    }

    /**
     * 92. 反转链表 II
     * 给你单链表的头指针 head 和两个整数 left 和 right，其中 left <= right。
     * 反转从位置 left 到位置 right 的链表节点，返回反转后的链表。
     * 示例 1：
     * 输入：head = [1,2,3,4,5], left = 2, right = 4
     * 输出：[1,4,3,2,5]
     */
    // 方法一：穿针引线
    public static ListNode reverseBetween1(ListNode head, int left, int right) {
        return null;
    }

    // 方法二：一次遍历「穿针引线」反转链表（头插法）
    // 在需要反转的区间里，每遍历到一个节点，让这个新节点来到反转部分的起始位置
    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        return null;
    }

    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的升序链表并返回。
     */
    // 方法一：递归
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        return null;
    }

    // 方法二：迭代
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        return null;
    }

    /**
     * 25. K 个一组翻转链表
     * 如果节点总数不是 k 的整数倍，那么将最后剩余的节点保持原有顺序。
     * 示例 1：
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     * 示例 2：
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        return null;
    }

    /**
     * 141. 环形链表
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     */
    public static boolean hasCycle(ListNode head) {
        return false;
    }

    /**
     * 142. 环形链表 II
     * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回 null。
     */
    // 方法一：哈希表
    public static ListNode detectCycle1(ListNode head) {
        return null;
    }

    // 方法二：快慢指针
    // 当发现 slow 与 fast 相遇时，再额外使用一个指针 ptr。起始，它指向链表头部；
    // 随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
    public static ListNode detectCycle2(ListNode head) {
        return null;
    }

    /**
     * 147. 对链表进行插入排序
     * 给定单个链表的头 head，使用插入排序对链表进行排序，并返回排序后链表的头。
     */
    // 方法一：从前往后找插入点
    public static ListNode insertionSortList(ListNode head) {
        return null;
    }

    /**
     * 148. 排序链表
     * 给你链表的头结点 head，请将其按升序排列并返回排序后的链表。
     * 要求达到 O(nlogn) 的时间复杂度和 O(1) 的空间复杂度
     */
    // 方法一：自顶向下归并排序
    public static ListNode sortList(ListNode head) {
        return null;
    }

    /**
     * 160. 相交链表
     * 给你两个单链表的头节点 headA 和 headB，请找出并返回两个单链表相交的起始节点。
     * 如果两个链表不存在相交节点，返回 null。
     */
    // 方法一：哈希集合
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        return null;
    }

    // 方法二：双指针
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        return null;
    }

}
