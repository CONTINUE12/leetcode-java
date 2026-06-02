package com.wangli.leetcode.algorithm;

import com.wangli.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P94_inorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        inorder(root, res);
        return res;
    }

    /**
     * 中序遍历-递归
     * @param cur
     * @param res
     */
    public static void inorder(TreeNode cur, List<Integer> res) {
        if (cur == null) {
            return;
        }

        inorder(cur.getLeft(), res);
        res.add(cur.getVal());
        inorder(cur.getRight(), res);
    }
}
