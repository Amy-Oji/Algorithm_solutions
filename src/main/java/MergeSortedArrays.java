import java.util.Arrays;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;  // Pointer for nums1
        int p2 = n - 1;  // Pointer for nums2
        int p = m + n - 1;  // Pointer for merged array

        // Merge nums1 and nums2 from the end
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // Copy remaining elements from nums2, if any
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArrays solution = new MergeSortedArrays();

        // Example 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));  // Output: [1, 2, 2, 3, 5, 6]

        // Example 2
        int[] nums3 = {1};
        int m2 = 1;
        int[] nums4 = {};
        int n2 = 0;
        solution.merge(nums3, m2, nums4, n2);
        System.out.println(Arrays.toString(nums3));  // Output: [1]

        // Example 3
        int[] nums5 = {0};
        int m3 = 0;
        int[] nums6 = {1};
        int n3 = 1;
        solution.merge(nums5, m3, nums6, n3);
        System.out.println(Arrays.toString(nums5));  // Output: [1]
    }
}
