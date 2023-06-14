class MyPow {

    /**
     *
     * From LeetCode:  https://leetcode.com/problems/length-of-last-word/
     * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
     *
     *
     * Example 1:
     *
     * Input: x = 2.00000, n = 10
     * Output: 1024.00000
     *
     *
     * Example 2:
     *
     * Input: x = 2.10000, n = 3
     * Output: 9.26100
     *
     *
     * Example 3:
     *
     * Input: x = 2.00000, n = -2
     * Output: 0.25000
     * Explanation: 2-2 = 1/22 = 1/4 = 0.25
     * **/
    public static double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    public static void main(String[] args) {
        System.out.println("Example 1 == "+ myPow(2.00000, 10)); // output = 1024.00000
        System.out.println("Example 2 == "+ myPow(2.00000, 3)); // output = 9.26100
        System.out.println("Example 3 == "+ myPow(2.00000, -2)); // output = 0.25000


    }
}