package com.natsu.leetcode;

/**
 * 717. 1比特与2比特字符
 * <p>
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 * <p>
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 *
 * @author shuaishuai.ren
 * @since 2020-09-22
 */
public class LeetCode717 {

    public static boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        int maxIndex = bits.length - 1;
        //如果数组最后一位不是0或者数组长度是2的倍数则直接返回false
        if (bits[maxIndex] != 0 && bits.length % 2 == 0) {
            return false;
        }
        while (index < maxIndex) {
            //2比特首位是1
            if (bits[index] == 1) {
                index += 2;
            } else {
                //1比特首位是0
                index += 1;
            }
        }
        //如果index等于数组长度,说明最后都出来一位
        return index == maxIndex;
    }

    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{1, 0, 0}));
    }
}
