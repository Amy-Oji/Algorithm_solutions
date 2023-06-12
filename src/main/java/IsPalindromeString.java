public class IsPalindromeString {
    /**
     * From LeetCode https://leetcode.com/problems/valid-palindrome/
     *
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
     * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
     *
     * Given a string s, return true if it is a palindrome, or false otherwise.
     *
     * Example 1:
     *
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     *
     *
     * Example 2:
     *
     * Input: s = "race a car"
     * Output: false
     * Explanation: "raceacar" is not a palindrome.
     *
     * 
     * Example 3:
     *
     * Input: s = " "
     * Output: true
     * Explanation: s is an empty string "" after removing non-alphanumeric characters.
     * Since an empty string reads the same forward and backward, it is a palindrome.
     * **/
    public static boolean isPalindrome(String s) {
        // Convert the string to lowercase and remove non-alphanumeric characters
        String cleanedString = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        // Check if the cleaned string is a palindrome
        int left = 0;
        int right = cleanedString.length() - 1;
        
        while (left < right) {
            if (cleanedString.charAt(left) != cleanedString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    public static void main(String[] args) {

        // Example 1
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s1));  // Output: true

        // Example 2
        String s2 = "race a car";
        System.out.println(isPalindrome(s2));  // Output: false

        // Example 3
        String s3 = " ";
        System.out.println(isPalindrome(s3));  // Output: true
    }

}
