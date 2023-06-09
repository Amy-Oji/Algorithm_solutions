import java.util.*;

public class TopKFrequent {

    /**
     * From LeetCode: https://leetcode.com/problems/top-k-frequent-elements/
     *
     * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     *
     *
     * Example 2:
     *
     * Input: nums = [1], k = 1
     * Output: [1]
     * **/
    public static int[] topKFrequent(int[] nums, int k) {
        // Count the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Create a min heap based on the frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(frequencyMap::get));
        
        // Keep only the top k frequent elements in the min heap
        for (int num : frequencyMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // Convert the min heap to an array
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }
        
        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println(Arrays.toString(topKFrequent(nums1, k1)));  // Output: [1, 2]

        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(topKFrequent(nums2, k2)));  // Output: [1]
    }

}
