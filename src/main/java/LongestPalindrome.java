class LongestPalindrome {

    /**
     * From LeetCode: https://leetcode.com/problems/longest-palindromic-substring/
     *
     *
     *
     * **/
    public static String longestPalindrome(String s) {
         if (s == null || s.length() < 2) {
            return s;
        }
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i); // Odd-length palindrome
            int len2 = expandFromCenter(s, i, i + 1); // Even-length palindrome
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s1 = "babad";
        System.out.println("Longest palindromic substring for " + s1 + ": " + longestPalindrome(s1)); // output -> aba

        String s2 = "cbbd";
        System.out.println("Longest palindromic substring for " + s2 + ": " + longestPalindrome(s2)); // output -> bb
    }
}