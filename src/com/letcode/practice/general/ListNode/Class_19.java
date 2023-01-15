package com.letcode.practice.general.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * @author lyn
 * @since 2022/11/14 19:13
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class Class_19 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
       ListNode list =  new ListNode(
                1, new ListNode(
                2, new ListNode(
                3, new ListNode(
                4, new ListNode(
                5)))));

       removeNthFromEnd(list, 2);
        System.out.println("________________");

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Deque<ListNode> node = new ArrayDeque<>();
        ListNode cur2 = head;
        ListNode curHead = new ListNode(0, head);
        ListNode cur = curHead;
        while (cur != null) {
            node.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n; i++) {
            node.pop();
        }
        ListNode pre = node.peek();
        pre.next = pre.next.next;
        ListNode cur1 = curHead.next;
        return cur1;
    }
}

