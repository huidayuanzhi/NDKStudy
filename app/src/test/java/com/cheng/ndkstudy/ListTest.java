package com.cheng.ndkstudy;

import org.junit.Test;

public class ListTest {

    private void log(ListDemo.ListNode head) {
        if (head == null) return;
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val);
            builder.append(",");
            head = head.next;
        }
        String str = builder.substring(0, builder.length() - 1);
        Logger.log(str);
    }

    private ListDemo.ListNode create(int[] nums) {
        if (nums == null || nums.length <= 0) return null;
        ListDemo.ListNode head = new ListDemo.ListNode(0);
        ListDemo.ListNode tail = head;
        for (int num : nums) {
            ListDemo.ListNode node = new ListDemo.ListNode(num);
            tail.next = node;
            tail = tail.next;
        }
        return head.next;
    }

    @Test
    public void testMiddleNode() {
        // 1,2,3,4,5
        ListDemo.ListNode head1 = create(new int[]{1, 2, 3, 4, 5});
        ListDemo.ListNode middle1 = ListDemo.middleNode(head1);
        Logger.log("middleNode - 1,2,3,4,5 -> result = " + middle1.val); // 3
        // 1,2,3,4,5,6
        ListDemo.ListNode head2 = create(new int[]{1, 2, 3, 4, 5, 6});
        ListDemo.ListNode middle2 = ListDemo.middleNode(head2);
        Logger.log("middleNode - 1,2,3,4,5,6 -> result = " + middle2.val); // 4
    }

    @Test
    public void testIsPalindrome() {
        // 1,2,2,1
        ListDemo.ListNode head1 = create(new int[]{1, 2, 2, 1});
        Logger.log("isPalindrome - 1,2,2,1 -> result = " + ListDemo.isPalindrome(head1)); // true
        // 1,2
        ListDemo.ListNode head2 = new ListDemo.ListNode(1);
        ListDemo.ListNode node2_1 = new ListDemo.ListNode(2);
        head2.next = node2_1;
        Logger.log("isPalindrome - 1,2 -> result = " + ListDemo.isPalindrome(head2)); // false
        // 1,2,1
        ListDemo.ListNode head3 = create(new int[]{1, 2, 1});
        Logger.log("isPalindrome - 1,2,1 -> result = " + ListDemo.isPalindrome(head3)); // true
    }

    @Test
    public void testReverseList1() {
        // 1,2,3,4,5
        ListDemo.ListNode head1 = create(new int[]{1, 2, 3, 4, 5});
        Logger.log("reverseList - before");
        log(head1);
        ListDemo.ListNode preHead1 = ListDemo.reverseList1(head1);
        Logger.log("reverseList - after");
        log(preHead1);
        // 1,2
        ListDemo.ListNode head2 = create(new int[]{1, 2});
        Logger.log("reverseList - before");
        log(head2);
        ListDemo.ListNode preHead2 = ListDemo.reverseList1(head2);
        Logger.log("reverseList - after");
        log(preHead2);
    }

    @Test
    public void testReverseList2() {
        // 1,2,3,4,5
        ListDemo.ListNode head1 = create(new int[]{1, 2, 3, 4, 5});
        Logger.log("reverseList - before");
        log(head1);
        ListDemo.ListNode preHead1 = ListDemo.reverseList2(head1);
        Logger.log("reverseList - after");
        log(preHead1);
        // 1,2
        ListDemo.ListNode head2 = create(new int[]{1, 2});
        Logger.log("reverseList - before");
        log(head2);
        ListDemo.ListNode preHead2 = ListDemo.reverseList2(head2);
        Logger.log("reverseList - after");
        log(preHead2);
    }

    @Test
    public void testMergeKLists() {
        Logger.log("mergeKLists");
        ListDemo.ListNode[] lists = new ListDemo.ListNode[]{
                create(new int[]{1, 4, 5}),
                create(new int[]{1, 3, 4}),
                create(new int[]{2, 6}),
        };
        for (ListDemo.ListNode list : lists) {
            log(list);
        }
        ListDemo.ListNode head = ListDemo.mergeKLists(lists);
        Logger.log("mergeKLists result -");
        log(head);
    }

    @Test
    public void testReverseBetween1() {
        Logger.log("reverseBetween1");
        // head = [1,2,3,4,5], left = 2, right = 4 -> [1,4,3,2,5]
        ListDemo.ListNode head = create(new int[]{1,2,3,4,5});
        log(head);
        ListDemo.ListNode newHead = ListDemo.reverseBetween1(head, 2, 4);
        Logger.log("reverseBetween1 result -");
        log(newHead);
    }

    @Test
    public void testReverseBetween2() {
        Logger.log("reverseBetween2");
        // head = [1,2,3,4,5], left = 2, right = 4 -> [1,4,3,2,5]
        ListDemo.ListNode head = create(new int[]{1,2,3,4,5});
        log(head);
        ListDemo.ListNode newHead = ListDemo.reverseBetween2(head, 2, 4);
        Logger.log("reverseBetween1 result -");
        log(newHead);
    }

}
