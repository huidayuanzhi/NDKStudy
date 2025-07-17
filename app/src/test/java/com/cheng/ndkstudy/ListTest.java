package com.cheng.ndkstudy;

import org.junit.Test;

public class ListTest {

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
        Logger.log("middleNode - 1,2,3,4,5 -> result = " + middle.val);
    }
}
