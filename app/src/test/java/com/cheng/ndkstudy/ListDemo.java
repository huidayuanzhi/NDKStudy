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

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // 方法二：递归
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
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
        if (lists == null || lists.length <= 0) return null;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode node : lists) {
            queue.offer(node);
        }
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            tail.next = temp;
            tail = tail.next;
            if (temp.next != null) {
                queue.offer(temp.next);
            }
        }
        return head.next;
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
        if (head == null || left < 0 || right <= left) return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;
        // 第 4 步：反转链表的子区间
        reverseLinkedList(leftNode);
        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private static void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    // 方法二：一次遍历「穿针引线」反转链表（头插法）
    // 在需要反转的区间里，每遍历到一个节点，让这个新节点来到反转部分的起始位置
    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
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
        if (head == null || head.next == null || k < 1) return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummyNode.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverse = reverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return dummyNode.next;
    }

    private static ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }

    /**
     * 141. 环形链表
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 142. 环形链表 II
     * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回 null。
     */
    // 方法一：哈希表
    public static ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode pos = head;
        Set<ListNode> set = new HashSet<>();
        while (pos != null) {
            if (set.contains(pos)) {
                return pos;
            } else {
                set.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    // 方法二：快慢指针
    // 当发现 slow 与 fast 相遇时，再额外使用一个指针 ptr。起始，它指向链表头部；
    // 随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
    public static ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}
