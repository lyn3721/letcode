package com.letcode.practice;

/**
 * general ListNode
 *
 * @author lyn
 * @since 2023/1/15 21:50
 */

public class ListNode {
    private int val;
    private ListNode next;
    private ListNode radom;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }

    public ListNode(int x, ListNode next, ListNode radom) {
        this.val = x;
        this.next = next;
        this.radom = radom;
    }
    public ListNode() {

    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getRadom() {
        return radom;
    }

    public void setRadom(ListNode radom) {
        this.radom = radom;
    }
}
