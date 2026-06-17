package com.wangli.leetcode.algorithm;

import com.wangli.leetcode.model.TreeNode;

public class P700_searchBST {

    /**
     * 迭代法
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val > val) {
                root = root.left;
            } else if (root.val < val) {
                root = root.right;
            } else {
                return root;
            }
        }

        return null;
    }

    /**
     * 递归法
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBSTV2(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        TreeNode res = null;
        if (root.val > val) {
            res = searchBSTV2(root.left, val);
        } else {
            res = searchBSTV2(root.right, val);
        }

        return res;
    }
}
