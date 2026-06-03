package com.wangli.leetcode.algorithm;

import com.wangli.leetcode.model.TreeNode;

import java.util.*;

public class P102_levelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> levelRes = new ArrayList<>();
            while (len > 0) {
                TreeNode cur = queue.poll();
                levelRes.add(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }

                len--;
            }
            res.add(levelRes);
        }

        return res;
    }
}
