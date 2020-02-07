package com.ding.demo.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    /*************************** 二分法 ***********************/
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * @param nums   [1,3,5,6],
     * @param target 5
     * @return 2
     */
    public int searchInsert(int[] nums, int target) {
        int right = nums.length;
        int left = 0;
        int mid = 0;
        while (left < right) {
            mid = (left + right) >>> 1;
            System.out.println("mid = " + mid + "nums[mid]=" + nums[mid]);
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                // 当中位数 >= target的时候, 右边界 可能就是右边界, 要考虑 == 的情况
                right = mid;
            }
        }
        return left;
    }


    public int mySqrt(int x) {
        long left = 0, right = x;
        while (left < right) {
            // 找到中位数 或者是 左中位数
            long mid = left + (right - left + 1) / 2;
            // 排除中间值
            if (mid * mid > x) {
                // 如果中位数的平方 > 目标值
                // 右边界收缩
                right = mid - 1;

            } else {
                // 如果中位数的平方 <= 目标值
                // 左边界收缩
                left = mid;
            }
        }
        return (int) left;
    }

    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * <p>
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * <p>
     * 说明:
     * <p>
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素
     *
     * @param numbers [2, 7, 11, 15]
     * @param target  9
     * @return 1, 2
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right = right - 1;
            } else if (numbers[left] + numbers[right] < target) {
                left = left + 1;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return null;
    }


    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     * @param nums   array
     * @param target target
     * @return idx
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果中间数 < target, left ==> 左边界向右收缩
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 如果中间数 >= target,右边界向左收缩
                right = mid;
            }
        }
        return nums[right] == target ? right : -1;
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * @param nums [-2,1,-3,4,-1,2,1,-5,4],
     * @return 6
     * 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }


    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * <p>
     *
     * @param nums 数组
     * @return element
     */
    public int majorityElement(int[] nums) {

        return 0;
    }


    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * @param nums1 ar1
     * @param nums2 ar2
     * @return ins
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        set1.retainAll(set2);

        int[] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;

    }

    /********************** 动态规划 *******************/

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意你不能在买入股票前卖出股票。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
        }
        return 0;
    }

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     *
     * @param m m
     * @param n n
     * @return rs
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] grid){
        int r = grid.length ;
        int c = grid[0].length;
        if(grid[0][0] == 1) return 0;
        grid[0][0] = 1;

        for (int i = 1; i < grid.length; i++) {
            grid[i][0] = (grid[i][0] == 0 && grid[i - 1][0] == 1) ? 1 : 0;

        }
        for (int j = 1; j < grid[0].length; j++) {
            grid[0][j] = (grid[0][j] == 0 && grid[0][j - 1] == 1) ? 1 : 0;


        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if(grid[i][j] == 0){
                    grid[i][j] = grid[i][j-1] + grid[i-1][j];
                }else{
                    grid[i][j] = 0;
                }
            }
        }
        return grid[r- 1][ c- 1];
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int maxLen = 1;

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {

                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i, j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }




    public static String test(String s){
          int len = s.length() ;
        if (len < 2 ) return s;

        int start = 0;
      int maxLen = 1;
        int [][] dp = new int [len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    if(i - j < 3){
                        dp[j][i] = 1;
                    }else{
                        dp[j][i] = dp[j + 1][i-1];
                    }

                }else{
                    dp[j][i] = 0;
                }
                if(dp[j][i] == 1){
                    int l = i - j + 1;
                    if (l > maxLen){
                        maxLen = l;
                        start = j;
                    }
                }
            }
        }
        return s.substring(start,start + maxLen );
    }




    public static int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][] dp = grid;
        // 1. 求出第一行的和 : 就是 0行 N 列
        for (int i = 1; i < c; i++) {
            dp[0][i] += dp[0][i - 1];
            System.out.println("0行" + i + "列: " + dp[0][i]);

        }
        // 2. 求出第一列的和 : 就是 0 列 N 行
        for (int i = 1; i < r; i++) {
            dp[i][0] += dp[i - 1][0];
            System.out.println("0列" + i + "行: "+ dp[i][0] );
        }

        // 3. 从 dp[1][1] 遍历 ,求解最小值
        for (int i = 1; i < c; i++) { // 遍历列数
            // cp = 1 : 就是1列

            // rp = 1: 就是 1行
            for (int j = 1; j < r; j++) { // 遍历行数

                // 求解第 1列1行 . 1列2行 ...的值
                if (dp[i][j - 1] < dp[i - 1][j]) {
                    dp[i][j] += dp[i][j - 1];
                } else {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }

        return dp[r - 1][c - 1];
    }

    public int findLength(int[] A, int[] B) {
        int maxLen = 0;
        // 转成字符串
        String a = Arrays.toString(A).replaceAll(", ","").replaceAll("\\[","").replaceAll("\\]","");
        String b = Arrays.toString(B).replaceAll(", ","").replaceAll("\\[","").replaceAll("\\]","");

        maxLen = getMaxLen(maxLen, a, b);
        System.out.println("=========");
        maxLen = getMaxLen(maxLen, b, a);
        return maxLen;
    }

    private static int getMaxLen(int maxLen, String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            int temp = 0;
            for (int j = 0; j < b.length(); j++) {
                System.out.println("i : " + i + ",j :" + j);
                if(b.charAt(j) == a.charAt(i + j)){
                    temp+=1;
                }
            }
            if(temp>maxLen) maxLen = temp;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int maxLen = 0;
        String a = "12321";
        String b = "32147";
        maxLen = getMaxLen(maxLen, a, b);
        System.out.println("=========");
        maxLen = getMaxLen(maxLen, b, a);
        System.out.println(maxLen);
    }

}
