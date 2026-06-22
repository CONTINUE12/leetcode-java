package com.wangli.leetcode.algorithm.tree;

import com.wangli.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class P111_minDepth {

    /**
     * 递归，后序遍历
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (root.left == null && root.right != null) {
            return 1 + rightDepth;
        }
        if (root.left != null && root.right == null) {
            return 1 + leftDepth;
        }

        return 1 + Math.min(leftDepth, rightDepth);
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public int minDepthV2(TreeNode root) {
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
                // 没有左右子节点，最短深度
                if (cur.left == null && cur.right == null) {
                    return res;
                }
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
