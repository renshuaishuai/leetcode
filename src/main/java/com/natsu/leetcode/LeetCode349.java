package com.natsu.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 * @author shuaishuai.ren
 * @since 2020-11-02
 */
public class LeetCode349 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        final int len = Math.min(nums1.length, nums1.length);
        Set<Integer> res = new HashSet<>(len);
        for (int i = 0; i < nums1.length; i++) {
            final int n1 = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                final int n2 = nums2[j];
                if (n1 == n2) {
                    res.add(n1);
                }
            }
        }
        final Iterator<Integer> iterator = res.iterator();
        int index = 0;
        final int[] result = new int[res.size()];
        while (iterator.hasNext()) {
            result[index++] = iterator.next();
        }
        return result;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {


        Set<Integer> source = new HashSet<>(nums1.length);
        for (int num : nums1) {
            source.add(num);
        }
        Set<Integer> res = new HashSet<>(Math.min(nums1.length, nums2.length));
        for (int num : nums2) {
            if (source.contains(num)) {
                res.add(num);
            }
        }
        final Iterator<Integer> iterator = res.iterator();
        int index = 0;
        final int[] result = new int[res.size()];
        while (iterator.hasNext()) {
            result[index++] = iterator.next();
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(intersection2(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
