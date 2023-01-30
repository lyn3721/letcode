package com.letcode.practice.swordfingeroffer;

import com.letcode.practice.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * 剑指 Offer 26. 树的子结构
 *
 * @author lyn
 * @since 2023/1/29 20:46
 */
public class Offer_26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return Objects.nonNull(A) && Objects.nonNull(B)  && (recur(A, B) || isSubStructure(A.getLeft(), B) || isSubStructure(A.getRight(), B));
    }

    private boolean recur(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null || a.getVal() != b.getVal()) return false;
        return recur(a.getLeft(), b.getLeft()) && recur(a.getRight(), b.getRight());
    }


}
