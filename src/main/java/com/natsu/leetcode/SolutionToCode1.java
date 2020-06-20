package com.natsu.leetcode;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * @author shuaishuai.ren
 * @since 2020-06-20
 */
public class SolutionToCode1 {

    /**
     * 暴力法，双层循环
     * @param nums nums
     * @param target target
     * @return int[]
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i= 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }

        return new int[]{-1,-1};
    }

    /**
     * hash法
     * @param nums nums
     * @param target target
     * @return int[]
     */
    public int[] twoSum2(int[] nums, int target) {
        final HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            final int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        return new int[]{-1,-1};
    }

}
