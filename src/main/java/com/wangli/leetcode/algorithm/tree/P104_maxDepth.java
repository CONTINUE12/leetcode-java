package com.wangli.leetcode.algorithm.tree;

import com.wangli.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class P104_maxDepth {

    /**
     * 递归，后序遍历
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int maxDepth = Math.max(leftDepth, rightDepth);

        return 1 + maxDepth;
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public int maxDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            res++;
            int len = queue.size();
            while (len > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                len--;
            }
        }

        return res;
    }
}
