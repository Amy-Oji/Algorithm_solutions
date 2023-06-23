public class ReverseInteger {

    /**
     * From Leetcode : https://leetcode.com/problems/reverse-integer/
     *
     * Given a signed 32-bit integer x, return x with its digits reversed.
     * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     *
     * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     *
     * Example 1:
     *
     * Input: x = 123
     * Output: 321
     *
     *
     * Example 2:
     *
     * Input: x = -123
     * Output: -321
     *
     *
     * Example 3:
     *
     * Input: x = 120
     * Output: 21
     * **/
    public static int reverse(int x) {
        int reversed = 0;
        
        while (x != 0) {
            int digit = x % 10;
            
            // Check if reversing x causes overflow
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;
            
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return reversed;
    }
    
    public static void main(String[] args) {
        int x1 = 123;
        int x2 = -123;
        int x3 = 120;
        
        System.out.println("Input: " + x1);
        System.out.println("Output: " + reverse(x1));
        
        System.out.println("Input: " + x2);
        System.out.println("Output: " + reverse(x2));
        
        System.out.println("Input: " + x3);
        System.out.println("Output: " + reverse(x3));
    }
}
