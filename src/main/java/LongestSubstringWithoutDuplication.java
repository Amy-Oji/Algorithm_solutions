import java.util.HashSet;

public class LongestSubstringWithoutDuplication {
/**
 * from LeetCode:https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.


 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.


 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.


 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * **/

// weak solution
    public static int longestSubstringWithoutDuplication(String str) {
        String[] arr = str.split("");
        StringBuilder result = new StringBuilder();

        for (String s : arr) {
            if (!result.toString().contains(s)) {
                result.append(s);
            }
        }
        return result.length();
    }

// better solution.
    public static int longestSubstringWithoutDuplication2(String str) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int start = 0;
        int end = 0;
        String longestSubstring = "";

        while (end < str.length()) {
            char currentChar = str.charAt(end);
            if (!set.contains(currentChar)) {
                set.add(currentChar);
                if (end - start + 1 > maxLength) {
                    maxLength = end - start + 1;
                    longestSubstring = str.substring(start, end + 1);
                }
                end++;
            } else {
                set.remove(str.charAt(start));
                start++;
            }
        }
        System.out.println(longestSubstring);
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication2("abcc"));
    }

}
