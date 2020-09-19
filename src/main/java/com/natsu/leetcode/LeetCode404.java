package com.natsu.leetcode;

/**
 * 计算给定二叉树的所有左叶子之和。
 * <p/>
 * 叶子节点:没有子节点
 *
 * @author shuaishuai.ren
 * @since 2020-09-19
 */
public class LeetCode404 {

    public static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum = root.left.val;
        }
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        final int sum = sumOfLeftLeaves(root);
        System.out.println(sum);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
