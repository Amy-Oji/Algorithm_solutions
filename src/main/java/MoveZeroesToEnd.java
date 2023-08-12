import java.util.Arrays;

public class MoveZeroesToEnd {
/**
 *
 * From LeetCode: https://leetcode.com/problems/move-zeroes/
 *
**/
    public static void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[nonZeroIndex];
                nums[nonZeroIndex] = nums[i];
                nums[i] = temp;

                // Increment nonZeroIndex
                nonZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);

        System.out.println(Arrays.toString(nums)); // Output: [1, 3, 12, 0, 0]
    }
}
