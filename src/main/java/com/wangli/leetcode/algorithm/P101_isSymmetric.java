package com.wangli.leetcode.algorithm;

import com.wangli.leetcode.model.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class P101_isSymmetric {

    /**
     * 递归
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        return compare(root.left, root.right);
    }
    
    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else if (left.val != right.val) {
            return false;
        }

        boolean isLeftEquals = compare(left.left, right.right);
        boolean isRightEquals = compare(left.right, right.left);
        return isLeftEquals && isRightEquals;
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public boolean isSymmetricV2(TreeNode root) {
        if (root == null) {
            return false;
        }

        // 通过队列层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }

            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }

        return true;
    }
}
