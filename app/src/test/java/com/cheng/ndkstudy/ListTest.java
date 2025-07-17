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

    @Test
    public void testMiddleNode() {
        // 1,2,3,4,5
        ListDemo.ListNode head = new ListDemo.ListNode(1);
        ListDemo.ListNode node2 = new ListDemo.ListNode(2);
        ListDemo.ListNode node3 = new ListDemo.ListNode(3);
        ListDemo.ListNode node4 = new ListDemo.ListNode(4);
        ListDemo.ListNode node5 = new ListDemo.ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListDemo.ListNode middle = ListDemo.middleNode(head);
        Logger.log("middleNode - 1,2,3,4,5 -> result = " + middle.val); // 3
    }

    @Test
    public void testIsPalindrome() {
        // 1,2,2,1
        ListDemo.ListNode head1 = new ListDemo.ListNode(1);
        ListDemo.ListNode node1_1 = new ListDemo.ListNode(2);
        ListDemo.ListNode node1_2 = new ListDemo.ListNode(2);
        ListDemo.ListNode node1_3 = new ListDemo.ListNode(1);
        head1.next = node1_1;
        node1_1.next = node1_2;
        node1_2.next = node1_3;
        Logger.log("isPalindrome - 1,2,2,1 -> result = " + ListDemo.isPalindrome(head1)); // true
        // 1,2
        ListDemo.ListNode head2 = new ListDemo.ListNode(1);
        ListDemo.ListNode node2_1 = new ListDemo.ListNode(2);
        head2.next = node2_1;
        Logger.log("isPalindrome - 1,2 -> result = " + ListDemo.isPalindrome(head2)); // false
        // 1,2,1
        ListDemo.ListNode head3 = new ListDemo.ListNode(1);
        ListDemo.ListNode node3_1 = new ListDemo.ListNode(2);
        ListDemo.ListNode node3_2 = new ListDemo.ListNode(1);
        head3.next = node3_1;
        node3_1.next = node3_2;
        Logger.log("isPalindrome - 1,2,1 -> result = " + ListDemo.isPalindrome(head3)); // true
    }

    @Test
    public void testReverseList1() {
        // 1,2,3,4,5
        ListDemo.ListNode head1 = new ListDemo.ListNode(1);
        ListDemo.ListNode node1_1 = new ListDemo.ListNode(2);
        ListDemo.ListNode node1_2 = new ListDemo.ListNode(3);
        ListDemo.ListNode node1_3 = new ListDemo.ListNode(4);
        ListDemo.ListNode node1_4 = new ListDemo.ListNode(5);
        head1.next = node1_1;
        node1_1.next = node1_2;
        node1_2.next = node1_3;
        node1_3.next = node1_4;
        Logger.log("reverseList - before");
        log(head1);
        ListDemo.ListNode preHead1 = ListDemo.reverseList1(head1);
        Logger.log("reverseList - after");
        log(preHead1);
        // 1,2
        ListDemo.ListNode head2 = new ListDemo.ListNode(1);
        ListDemo.ListNode node2_1 = new ListDemo.ListNode(2);
        head2.next = node2_1;
        Logger.log("reverseList - before");
        log(head2);
        ListDemo.ListNode preHead2 = ListDemo.reverseList1(head2);
        Logger.log("reverseList - after");
        log(preHead2);
    }

    @Test
    public void testReverseList2() {
        // 1,2,3,4,5
        ListDemo.ListNode head1 = new ListDemo.ListNode(1);
        ListDemo.ListNode node1_1 = new ListDemo.ListNode(2);
        ListDemo.ListNode node1_2 = new ListDemo.ListNode(3);
        ListDemo.ListNode node1_3 = new ListDemo.ListNode(4);
        ListDemo.ListNode node1_4 = new ListDemo.ListNode(5);
        head1.next = node1_1;
        node1_1.next = node1_2;
        node1_2.next = node1_3;
        node1_3.next = node1_4;
        Logger.log("reverseList - before");
        log(head1);
        ListDemo.ListNode preHead1 = ListDemo.reverseList2(head1);
        Logger.log("reverseList - after");
        log(preHead1);
        // 1,2
        ListDemo.ListNode head2 = new ListDemo.ListNode(1);
        ListDemo.ListNode node2_1 = new ListDemo.ListNode(2);
        head2.next = node2_1;
        Logger.log("reverseList - before");
        log(head2);
        ListDemo.ListNode preHead2 = ListDemo.reverseList2(head2);
        Logger.log("reverseList - after");
        log(preHead2);
    }

}
