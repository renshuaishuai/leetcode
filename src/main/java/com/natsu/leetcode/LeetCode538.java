package com.natsu.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * @author shuaishuai.ren
 * @since 2020-09-21
 */
public class LeetCode538 {

    /**
     * 先中序遍历,再累加
     *
     * @param root
     * @return
     */
    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        final Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        stack(root, deque);
        int preVal = 0;
        while (!deque.isEmpty()) {
            final TreeNode node = deque.pollLast();
            node.val += preVal;
            preVal = node.val;
        }

        return root;
    }

    static int sum = 0;

    /**
     * 反序中序遍历累加
     *
     * @param root
     * @return
     */
    public static TreeNode convertBST2(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST2(root.right);
        sum += root.val;
        root.val = sum;
        convertBST2(root.left);
        return root;
    }


    private static void stack(TreeNode node, Deque<TreeNode> deque) {
        if (node == null) {
            return;
        }
        stack(node.left, deque);
        deque.add(node);
        stack(node.right, deque);
    }


    public static void main(String[] args) {
//        final TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(-1);
//        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(-3);
//        root.right.right = new TreeNode(4);
//        final TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(0);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(-4);
//        root.left.right = new TreeNode(1);
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(-2);
        root.right.left = new TreeNode(3);
        System.out.println(convertBST(root));
//        System.out.println(convertBST2(root));
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
