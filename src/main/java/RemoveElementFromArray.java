public class RemoveElementFromArray {

    /**
     * From Leetcode: https://leetcode.com/problems/remove-element/
     *
     *
     * **/
    public static int removeElement(int[] nums, int val) {
        int k = 0; // Pointer to keep track of the position where elements different from val should be placed

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Move the element to the position pointed by 'k'
                k++; // Increment 'k' to move to the next position
            }
        }

        return k; // 'k' represents the number of elements different from val
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int k1 = removeElement(nums1, val1);
        printResult(nums1, k1);

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int k2 = removeElement(nums2, val2);
        printResult(nums2, k2);
    }

    public static void printResult(int[] nums, int k) {
        System.out.print("Output: " + k + ", nums = [");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]);
            if (i != k - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
