import java.util.Arrays;

public class NextPermutation {
    /**
     * From Leetcode https://leetcode.com/problems/next-permutation/
     * **/
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Find the first decreasing element from right to left
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = n - 1;
            // Find the smallest element greater than nums[i]
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // Swap nums[i] and nums[j]
            swap(nums, i, j);
        }

        // Reverse the subarray to the right of i
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();

        int[] nums1 = {1, 2, 3};
        solution.nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1)); // Output: [1, 3, 2]

        int[] nums2 = {3, 2, 1};
        solution.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2)); // Output: [1, 2, 3]

        int[] nums3 = {1, 1, 5};
        solution.nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3)); // Output: [1, 5, 1]
    }
}
