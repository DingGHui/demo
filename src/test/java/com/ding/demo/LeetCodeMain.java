package com.ding.demo;

import com.ding.demo.leetcode.Solution;

import java.math.BigDecimal;

public class LeetCodeMain {
//    private static int[] ARR_1 = new int[]{1,3,5,6};

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(5>>>1);
        int[][] c = new int[1][1];
        c[0][0] = 0;
        System.out.println(solution.uniquePathsWithObstacles(c));
    }
}
