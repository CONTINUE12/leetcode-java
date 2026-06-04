package com.wangli.leetcode.algorithm;

import com.wangli.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class P226_invertTree {

    /**
     * 层序遍历迭代实现
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode cur = queue.poll();
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                len--;
            }
        }

        return root;
    }

    /**
     * 前序遍历递归实现
     * @param root
     * @return
     */
    public TreeNode invertTreeV2(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeV2(root.left);
        invertTreeV2(root.right);

        return root;
    }
}
