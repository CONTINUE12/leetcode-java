package com.wangli.leetcode.algorithm.tree;

import com.wangli.leetcode.model.TreeNode;

import java.util.*;

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

        inorder(cur.left, res);
        res.add(cur.val);
        inorder(cur.right, res);
    }

    // =================== 后序迭代写法 =======================
    public List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);

            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        // 中右左，反转后 左右中
        Collections.reverse(res);

        return res;
    }
}
