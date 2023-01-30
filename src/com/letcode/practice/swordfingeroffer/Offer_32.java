package com.letcode.practice.swordfingeroffer;

import com.letcode.practice.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 *
 * @author lyn
 * @since 2023/1/19 18:20
 */
public class Offer_32 {

    List<Integer> list1 = new ArrayList<>();
    public int[] levelOrder(TreeNode root) {
        Deque<TreeNode> de = new ArrayDeque<>();
        de.offer(root);
        ArrayList<Integer> integers = new ArrayList<>();
        while (!de.isEmpty()) {
            TreeNode poll = de.poll();
            integers.add(root.getVal());
            if(poll.getLeft() != null) {
                de.offer(poll.getLeft());
            }
            if (poll.getRight() != null) {
                de.offer(poll.getRight());
            }
        }
        return integers.stream().mapToInt(Integer::intValue).toArray();
    }


    public List<List<Integer>> levelOrder1(TreeNode root) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size -1 ; i++) {
                TreeNode node = queue.poll();
                level.add(node.getVal());
                if(node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            ret.add(level);
        }
        return ret;
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        ArrayList<List<Integer>> ret = new ArrayList<>();

        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        boolean isfirst = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Deque<Integer> de = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size -1 ; i++) {
                TreeNode node = queue.poll();
                if (isfirst) {
                    de.addFirst(node.getVal());
                } else {
                    de.addLast(node.getVal());
                }
                if(node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            ret.add(new LinkedList<>(de));
            isfirst = !isfirst;
        }
        return ret;
    }



}
