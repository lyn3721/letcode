package com.letcode.practice.general.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lyn
 * @since 2022/7/31 23:13
 * <p>
 * 给你一个二叉树的根节点root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中最小 的那个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumLevelSumOfOneBinaryTree {
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

    //[1,1,0,7,-8,-7,9]
    //[1,7,0,7,-8,null,null]
    //[-100,-200,-300,-20,-5,-10,null]
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(-100,
                new TreeNode(-200,
                        new TreeNode(-20, null, null),
                        new TreeNode(-5, null, null)
                )
                ,
                new TreeNode(-300,
                        new TreeNode(-10, null, null),
                        null
                )
        );
        System.out.println(maxLevelSum(treeNode));


    }

    public static int maxLevelSum(TreeNode root) {
        Deque<TreeNode> result = new ArrayDeque<>();
        int level = 1;
        int returnLevel = 1;
        if (root == null) {
            return level;
        }
        int maxSum = root.val;
        result.add(root);

        while (!result.isEmpty()) {

            int num = 0;
            int size = result.size();
            for (int i = 0; i < size; i++) {
                TreeNode tree = result.poll();
                if (tree.left != null) {
                    num += tree.left.val;
                    result.add(tree.left);
                }
                if (tree.right != null) {
                    num += tree.right.val;
                    result.add(tree.right);
                }
            }
            if (result.isEmpty()) {
                break;
            }
            if (num > maxSum) {
                maxSum = num;
                returnLevel = level;
            }



        }
        return returnLevel;
    }
}