package com.letcode.practice.general.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lyn
 * @since 2022/8/17 19:28
 * /**
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 * <p>
 * <p>
 * * Definition for a binary tree node.
 * * public class TreeNode {
 * *     int val;
 * *     TreeNode left;
 * *     TreeNode right;
 * *     TreeNode() {}
 * *     TreeNode(int val) { this.val = val; }
 * *     TreeNode(int val, TreeNode left, TreeNode right) {
 * *         this.val = val;
 * *         this.left = left;
 * *         this.right = right;
 * *     }
 * * }
 * *
 */
public class DeepestLeavesSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> sumList = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            sumList.add(sum);
        }
        return sumList.get(sumList.size() - 1);
    }


    public static void main(String[] args) {
        //[1,2,3,4,5,null,6,7,null,null,null,null,8]
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(
                                        7, null, null
                                ),
                                null
                        ),
                        new TreeNode(5,
                                null, null)
                ),
                new TreeNode(3,
                        null,
                        new TreeNode(6,
                                null,
                                new TreeNode(8,
                                        null,
                                        null
                                )
                        )
                )
        );

        System.out.println(deepestLeavesSum(treeNode));
    }

}
