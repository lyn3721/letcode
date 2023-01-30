package com.letcode.practice.swordfingeroffer;

import com.letcode.practice.ListNode;

import java.util.Arrays;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 *
 * @author lyn
 * @since 2023/1/29 21:48
 */
public class Offer_22 {
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        for (int i = 1; i <= k ; i ++) {
            tail = tail.getNext();
        }
        ListNode pre = head;
        while (tail != null) {
            pre = pre.getNext();
            tail = tail.getNext();
        }
        int[] a = new int[0];
        int[] ints = Arrays.stream(a).sorted().toArray();

        int sum = Arrays.stream(a).filter(i -> i == 0).sum();
        return pre;
    }

    public static void main(String[] args) {
        ListNode kthFromEnd = getKthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3))), 3);
        System.out.println(kthFromEnd);
    }
}
