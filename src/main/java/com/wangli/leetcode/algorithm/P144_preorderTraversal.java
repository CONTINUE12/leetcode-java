package com.wangli.leetcode.algorithm;

import com.wangli.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

        res.add(cur.val);
        preorder(cur.left, res);
        preorder(cur.right, res);
    }

    // =================== 前序迭代写法 =======================
    public List<Integer> preorderTraversalV2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

        return res;
    }
}
