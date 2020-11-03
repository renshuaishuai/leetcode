package com.natsu.leetcode;

/**
 * 941. 有效的山脉数组
 * <p>
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * <p>
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * @author shuaishuai.ren
 * @since 2020-11-03
 */
public class LeetCode941 {

    public static boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        if (A[0] >= A[1]) {
            return false;
        }
        int preNum = A[1];
        boolean isIncr = true;
        for (int i = 2; i < A.length; i++) {
            if (isIncr) {
                if (A[i] != preNum) {
                    isIncr = preNum < A[i];
                    preNum = A[i];
                } else {
                    return false;
                }
            } else {
                if (A[i] < preNum) {
                    preNum = A[i];
                } else {
                    return false;
                }
            }
        }
        return !isIncr;
    }


    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{3, 7, 20, 14, 15, 14, 10, 8, 2, 1}));
    }
}
