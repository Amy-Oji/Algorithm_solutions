public class IsPalindrome {
    /**
     * From LeetCode: https://leetcode.com/problems/palindrome-number/
     **
     * Given an integer x, return true if x is a
     * palindrome, and false otherwise.
     *
     * Example 1:
     *
     * Input: x = 121
     * Output: true
     * Explanation: 121 reads as 121 from left to right and from right to left.
     * Example 2:
     *
     * Input: x = -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     * Example 3:
     *
     * Input: x = 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     *
     * **/
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int original = x;
        int reversed = 0;

        while (x > 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return original == reversed;
    }

    public static void main(String[] args) {
        int x1 = 121;
        int x2 = -121;
        int x3 = 10;

        System.out.println(isPalindrome(x1)); // Output: true
        System.out.println(isPalindrome(x2)); // Output: false
        System.out.println(isPalindrome(x3)); // Output: false
    }
}
