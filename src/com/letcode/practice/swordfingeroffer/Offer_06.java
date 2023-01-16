package com.letcode.practice.swordfingeroffer;

import com.letcode.practice.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * @author lyn
 * @since 2023/1/15 21:49
 */
public class Offer_06 {
    public static int[] reversePrint1(ListNode head) {
        if (head == null) {
            return  new int[0];
        }
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode tmp = head;
        deque.push(head);
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            deque.push(tmp);
        }
        int[] arr = new int[deque.size()];
        for (int i = 0; i < arr.length; i++) {
             arr[i] = deque.pop().getVal();
        }
        return arr;
    }


    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return  new int[0];
        }
        List<Integer> list = new ArrayList<>();
        reverse(head, list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void reverse(ListNode head, List<Integer> list ) {
        if (head == null) {
            return;
        }
        reverse(head.getNext(), list);
        list.add(head.getVal());
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(3, new ListNode(2)));
        int[] x = reversePrint(listNode);
        System.out.println(x);
    }
}
