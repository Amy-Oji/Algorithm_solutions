import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    /**
     * LeetCode
     * Link: <a href="https://leetcode.com/problems/two-sum/">Click Here</a>
     * Given an array of integers nums and an integer target,
     * return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution,
     * and you may not use the same element twice.
     *
     * You can return the answer in any order.
     *
     * Example 1:
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * Example 2:
     *
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * Example 3:
     *
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     * **/

//    solution1
    public static int[] twoSum2(int[] nums, int target) {

        int[] ans = new int[2];

        // number and it's corresponding index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {  //[3,2,4],
            /*
            * using the array values to check the map if it contains it as key.
            * Then later subtract the values from target and store the result as the map keys
            * then store their indexes as the map values.
            * This is so that when we get the value that balances our target,
            * we would have already stored it as key
            * and the program would skip to the else statement
            * and store the indexes of those values in our answer array
             * */
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);

            } else {
                ans[1] = i;
                ans[0] = map.get(nums[i]);
                break;
        }
    }
        return ans;
}

//solution 2
    public static int[] twoSum(int[] nums, int target) {
        Set<Integer> result = new HashSet<>();

        for(int i=0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(j!=i){
                    if (nums[i] + nums[j] == target) {
                        result.add(i);
                        result.add(j);
                    }
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int t = 9           ;
        int[] intArr = {3,2,4};
        int[] intArr2 = {2,8,9,7,10};
        int[] intArr3 = {3,2, 3};


        System.out.println(Arrays.toString(twoSum2(intArr2, 9)));

    }
}