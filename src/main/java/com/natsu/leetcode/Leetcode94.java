package com.natsu.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 返回二叉树中序遍历
 * 左 -> 根 -> 右
 *
 * @author shuaishuai.ren
 * @since 2020-09-14
 */
public class Leetcode94 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        //递归(隐式堆栈)
        inorder(root, result);
        //栈(显式堆栈)
//        inorder2(root, result);
        return result;
    }


    private static void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    private static void inorder2(TreeNode root, List<Integer> result) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
    }

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        final List<Integer> list = inorderTraversal(root);
        System.out.println(list);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
