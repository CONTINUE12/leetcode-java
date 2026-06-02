package com.wangli.leetcode.algorithm;

import com.wangli.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P145_postorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        postorder(root, res);
        return res;
    }

    /**
     * 后序遍历-递归
     * @param cur
     * @param res
     */
    public static void postorder(TreeNode cur, List<Integer> res) {
        if (cur == null) {
            return;
        }

        postorder(cur.getLeft(), res);
        postorder(cur.getRight(), res);
        res.add(cur.getVal());
    }
}
