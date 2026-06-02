package com.wangli.leetcode.algorithm;

import com.wangli.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P144_preorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        preorder(root, res);
        return res;
    }

    /**
     * 前序遍历-递归
     * @param cur
     * @param res
     */
    public static void preorder(TreeNode cur, List<Integer> res) {
        if (cur == null) {
            return;
        }

        res.add(cur.getVal());
        preorder(cur.getLeft(), res);
        preorder(cur.getRight(), res);
    }
}
