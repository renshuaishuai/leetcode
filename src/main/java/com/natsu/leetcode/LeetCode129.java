package com.natsu.leetcode;

import com.natsu.tools.Builder;

/**
 * 129. 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * <p>
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * <p>
 * 计算从根到叶子节点生成的所有数字之和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 输入: [1,2,3]
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 * @author shuaishuai.ren
 * @since 2020-10-29
 */
public class LeetCode129 {

    public static int sumNumbers(TreeNode root) {
//        return sum(root, 0);
        return sum2(root, 0);
    }

    private static int sum(TreeNode node, int pre) {
        //当前节点的和 = 父节点*10 + 自身值
        int currentSum = pre * 10 + node.val;
        //如果当前节点的左右子节点都为null,说明已经到达当前叶子分支的最终节点,直接返回当前节点的和
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        //说明至少存在一个叶子节点,说明当前节点还不是当前叶子分支的最终节点,初始化和为0
        int sum = 0;
        //如果存在左叶子节点,则把左叶子节点的和相加
        if (node.left != null) {
            sum += sum(node.left, currentSum);
        }
        //如果存在右叶子节点,则把右叶子节点的和相加
        if (node.right != null) {
            sum += sum(node.right, currentSum);
        }
        //返回
        return sum;
    }

    /**
     * 简化版
     *
     * @param node N
     * @param pre  P
     * @return S
     */
    private static int sum2(TreeNode node, int pre) {
        if (node == null) {
            return 0;
        }
        int currentSum = pre * 10 + node.val;
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        return sum2(node.left, currentSum) + sum2(node.right, currentSum);
    }

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        System.out.println(sumNumbers(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
