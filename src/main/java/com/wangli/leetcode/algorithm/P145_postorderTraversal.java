package com.wangli.leetcode.algorithm;

import com.wangli.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

        postorder(cur.left, res);
        postorder(cur.right, res);
        res.add(cur.val);
    }

    // =================== 中序迭代写法 =======================
    public List<Integer> postorderTraversalV2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }

        return res;
    }
}
