package com.letcode.practice.swordfingeroffer;

import com.letcode.practice.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 剑指 Offer 24. 反转链表
 *
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @author lyn
 * @since 2023/1/15 22:29
 */
public class Offer_24 {

    //输入: 1->2->3->4->5->NULL
    //输出: 5->4->3->2->1->NULL
    public static ListNode reverseList(ListNode head) {
        ListNode pr = new ListNode();
        ListNode cur = head;
         while (cur != null) {
            ListNode next = cur.getNext();
            cur.setNext(pr);
            pr = cur;
            cur = next;
        }
        return pr;
    }

    public static ListNode reverseListWithStack(ListNode head) {
        ListNode cur = head;
        Deque<ListNode> deque = new ArrayDeque<>();
        while (cur != null) {
            deque.push(cur);
            cur = cur.getNext();
        }

        ListNode pre = new ListNode();
        ListNode tmp = pre;
        while (!deque.isEmpty()) {
            ListNode pop = deque.pop();
            pre.setNext(pop);

            pre = pre.getNext();

        }


        return tmp.getNext();
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(3, new ListNode(2)));
        reverseListWithStack(listNode);
    }
}
