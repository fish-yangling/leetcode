package com.yangling.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 标签：滑动窗口
 *
 * 1、什么是滑动窗口？
 * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，
 * 当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
 *
 * 2、如何移动？
 * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
 * 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
 *
 * 思路：不使用队列【不知道内部值】，维护数组指针，挪动start和end指针
 *
 */
public class _3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int res = 0;

        //指针内范围为子串
        for (int start = 0, end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)), start);
            }

            res = Math.max(res, end - start + 1);
            map.put(s.charAt(end), end + 1);//加 1 表示从字符位置后一个才开始不重复
        }

        return res;
    }

    public static void main(String[] args) {
        _3_Longest_Substring_Without_Repeating_Characters ls = new _3_Longest_Substring_Without_Repeating_Characters();
        System.out.println(ls.lengthOfLongestSubstring("abcdb"));
    }
}
