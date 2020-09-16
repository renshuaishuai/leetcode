package com.natsu.leetcode;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 *
 * @author shuaishuai.ren
 * @since 2020-09-16
 */
public class LeetCode226 {
    public static TreeNode invertTree(TreeNode root) {
        TreeNode result = root;
        invert(result);
        return result;
    }

    private static void invert(TreeNode node) {
        if (node == null) {
            return;
        }
        invert(node.left);
        invert(node.right);

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

    }

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        final TreeNode result = invertTree(root);
        System.out.println(result);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
