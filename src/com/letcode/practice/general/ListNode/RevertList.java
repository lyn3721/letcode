package com.letcode.practice.general.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 翻转链表
 *
 * @author lyn
 * @since 2022/11/27 02:26
 */
public class RevertList {
    /**
     * Definition for singly-linked list.

     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int x) { val = x; }
        ListNode(int x, ListNode next) { val = x; this.next = next;}

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode reverseList1(ListNode head) {
        Deque<Integer> de = new ArrayDeque<>();
        while (head != null) {
            de.push(head.val);
            head.next = head;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!de.isEmpty()) {
            cur.next = new ListNode(de.pop());
            cur = cur.next;
        }

        return dummy.next;
    }
    public static ListNode reverseList2(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }

    /**
     * 分段翻转
     */
    public static ListNode reverseBetween(ListNode head, int left , int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
//        ListNode dummyNode = new ListNode(-1);
//        dummyNode.next = head;
//
//        ListNode pre = dummyNode;
//        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
//        // 建议写在 for 循环里，语义清晰
//        for (int i = 0; i < left - 1; i++) {
//            pre = pre.next;
//        }
//
//        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
//        ListNode rightNode = pre;
//        for (int i = 0; i < right - left + 1; i++) {
//            rightNode = rightNode.next;
//        }
//
//        // 第 3 步：切断出一个子链表（截取链表）
//        ListNode leftNode = pre.next;
//        ListNode curr = rightNode.next;
//
//        // 注意：切断链接
//        pre.next = null;
//        rightNode.next = null;
//
//        // 第 4 步：同第 206 题，反转链表的子区间
//        reverseList2(leftNode);
//
//        // 第 5 步：接回到原来的链表中
//        pre.next = rightNode;
//        leftNode.next = curr;
//        return dummyNode.next;


        int i = 0;
        ListNode cur = head;
        ListNode h = new ListNode();
        ListNode hC = h;
        ListNode t = new ListNode();
        ListNode tC = t;
        ListNode rev = new ListNode();
        ListNode rC = rev;

        while (head != null) {
            if (i < left) {
                hC.next = cur;
                hC = hC.next;
            }
            else if (i > right - 1) {
                tC.next = cur;
                tC = tC.next;
            } else {
                rC.next = cur;
                rC = rC.next;
            }
            cur = cur.next;
            i ++;
        }
        reverseList2(rev.next);
        h.next = rev;

return rev;

    }

    /**
     *  翻转链表 （递归）
     * @param args
     */
//    public static ListNode reverseList(ListNode head) {
//        return recur(head, null);    // 调用递归并返回
//    }
//    private static ListNode recur(ListNode cur, ListNode pre) {
//        if (cur == null) {
//            return pre; // 终止条件
//        }
//        ListNode res = recur(cur.next, cur);  // 递归后继节点
//        cur.next = pre;              // 修改节点引用指向
//        return res;                  // 返回反转链表的头节点
//    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode x = reverseBetween(listNode, 2, 4);
//        System.out.println(x);
        System.out.println(111);
    }

}
