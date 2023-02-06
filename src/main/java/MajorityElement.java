import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MajorityElement {

    /**
     * From LeetCode
     *
     * Link:  https://leetcode.com/problems/majority-element/
     *
     * Given an array nums of size n, return the majority element.
     *
     * The majority element is the element that appears more than ⌊n / 2⌋ times.
     * You may assume that the majority element always exists in the array.
     *
     * Example 1:
     *
     * Input: nums = [3,2,3]
     * Output: 3
     * Example 2:
     *
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     * **/
    public static int majorityElement(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int element = 0 ;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer,Integer>> entrySet =map.entrySet();

        for(Map.Entry<Integer,Integer> entry : entrySet) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                element = entry.getKey();
            }
        }

        return element;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 4, 7, 1, 1,}));
    }
}
