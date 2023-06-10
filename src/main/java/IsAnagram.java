import java.util.*;

public class IsAnagram {

    /**
     * From LeetCode: https://leetcode.com/problems/valid-anagram/
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     * Example 2:
     *
     * Input: s = "rat", t = "car"
     * Output: false
     * **/
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        // Count the frequency of characters in string s
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Compare the frequency of characters in string t
        for (char c : t.toCharArray()) {
            if (!frequencyMap.containsKey(c) || frequencyMap.get(c) <= 0) {
                return false;
            }
            frequencyMap.put(c, frequencyMap.get(c) - 1);
        }
        
        return true;
    }

    public static void main(String[] args) {

        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println(isAnagram(s1, t1));  // Output: true

        String s2 = "rat";
        String t2 = "car";
        System.out.println(isAnagram(s2, t2));  // Output: false
    }

}
