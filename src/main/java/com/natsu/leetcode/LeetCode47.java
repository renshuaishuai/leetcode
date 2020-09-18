package com.natsu.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * @author shuaishuai.ren
 * @since 2020-09-18
 */
public class LeetCode47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        final int len = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (len == 0) {
            return result;
        }
        //排序
        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<Integer>(len);
        dfs(nums, len, 0, used, path, result);

        return new ArrayList<List<Integer>>(result);
    }

    private static void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> result) {
        if (depth == len) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i -1] && !used[i-1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i]  = true;

            dfs(nums, len, depth+1, used, path,  result);

            used[i] = false;
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        final List<List<Integer>> result = permuteUnique(new int[]{1, 1, 2});
        System.out.println(result);
    }

}
