package com.natsu.leetcode;

import java.util.Arrays;

/**
 * 977
 * @author shuaishuai.ren
 * @since 2020-10-16
 */
public class LeetCode977 {

    public static int[] sortedSquares(int[] A) {

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                break;
            }
            A[i] = -A[i];
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }

        return A;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
