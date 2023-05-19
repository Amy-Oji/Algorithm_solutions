import java.util.Arrays;

public class SearchRange {

    /**
     * From LeetCode:  https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     *
     * Given an array of integers nums sorted in non-decreasing order,
     * find the starting and ending position of a given target value.
     *
     * If target is not found in the array, return [-1, -1].
     *
     * You must write an algorithm with O(log n) runtime complexity.
     * Example 1:
     *
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     *
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     * Example 3:
     *
     * Input: nums = [], target = 0
     * Output: [-1,-1]
     * **/

//    solution 1
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false) - 1;

        if (left <= right && right < nums.length && nums[left] == target) {
            return new int[] {left, right};
        } else {
            return new int[] {-1, -1};
        }
    }

    private int binarySearch(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] > target || (isLeft && nums[mid] == target)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

// solution 2
    public static int[] searchRange2(int[] nums, int target) {
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        System.out.println(left);
        System.out.println(right);

        if (left > right) {
            return new int[] {-1, -1};
        } else {
            return new int[] {left, right};
        }
    }

    private static int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target <= nums[mid] ) {

                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        int [] nums = { 0,0,1,2,};
        System.out.println(Arrays.toString(searchRange2(nums, 0)));
    }

}
