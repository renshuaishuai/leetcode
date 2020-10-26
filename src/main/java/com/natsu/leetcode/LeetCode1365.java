package com.natsu.leetcode;

import java.util.Arrays;

/**
 * 1365. 有多少小于当前数字的数字
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * <p>
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * <p>
 * 以数组形式返回答案。
 *
 * @author shuaishuai.ren
 * @since 2020-10-26
 */
public class LeetCode1365 {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null) {
            return null;
        }
        final int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                if (nums[j] < nums[i]) {
                    res[i] = ++res[i];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
    }
}
