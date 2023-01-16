package com.letcode.practice.swordfingeroffer;

import com.letcode.practice.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 *
 * @author lyn
 * @since 2023/1/16 00:17
 */
public class Offer_35 {
    private static Map<ListNode, ListNode> cache = new HashMap<>();
    public static  ListNode copyRandomList(ListNode head) {
        if (head == null) {
            return null;
        }
       if (!cache.containsKey(head)) {
          ListNode node = new ListNode(head.getVal());
           cache.put(head, node);
          node.setNext(copyRandomList(head.getNext()));
          node.setRadom(copyRandomList(head.getRadom()));
      }

        return cache.get(head);
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,
                new ListNode(3,
                        new ListNode(2),
                        new ListNode(1)),
                new ListNode(2));
        copyRandomList(listNode);

        System.out.println(111);
    }
}
