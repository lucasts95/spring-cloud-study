package com.huawei.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NoRepeatString {
    /*
    的起始位置，那么子串的结束位置也是递增的！这里的原因在于，
    假设我们选择字符串中的第 k 个字符作为起始位置，并且得到了不包含重复字符的最长子串的结束位置为 r_k。
    那么当我们选择第 k+1 个字符作为起始位置时，首先从 k+1 到 r_k 的字符显然是不重复的，
    并且由于少了原本的第 k 个字符，我们可以尝试继续增大 r_k，直到右侧出现了重复字符为止。
     */
    public int lengthOfLongestSubstring(String s) {
        //用set存放出现过的元素
        HashSet<Character> set = new HashSet<>();
        //右指针 -1表示在左边界之外
        int rp = -1;
        //最大长度
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            //左指针向右前进,set移除一个元素
            if (i != 0) {
                set.remove(s.charAt(i-1));
            }
            //右指针不断向右,直到出现重复元素
            while (!set.contains(s.charAt(rp + 1)) && rp + 1 < s.length()) {
                set.add(s.charAt(rp+1));
                rp++;
            }
            maxLen=Math.max(maxLen,rp+1-i);
        }
        return maxLen;
    }
}
