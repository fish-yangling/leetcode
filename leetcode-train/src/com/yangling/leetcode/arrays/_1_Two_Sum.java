package com.yangling.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 例子：
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * https://leetcode-cn.com/problems/two-sum/
 */
public class _1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {


        //解法1：暴力遍历
        //时间复杂度：O(n^2)
        //空间复杂度：O(1)
        /*int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }*/

        //解法2：两遍hashMap
        /*Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }*/

        //解法3：一遍hashMap
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }


        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        _1_Two_Sum ts = new _1_Two_Sum();
        int[] ints = ts.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(ints);
    }
}
