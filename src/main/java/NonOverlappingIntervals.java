import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    /**
     * From Leetcode: https://leetcode.com/problems/non-overlapping-intervals/
     * **/
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        // Sort intervals by their ending time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        
        int nonOverlapCount = 1;
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval does not overlap with the previous one, increment nonOverlapCount
            if (intervals[i][0] >= end) {
                nonOverlapCount++;
                end = intervals[i][1];
            }
        }
        
        // The total number of intervals to be removed is the difference between the total intervals and non-overlapping intervals
        return intervals.length - nonOverlapCount;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals solution = new NonOverlappingIntervals();

        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Output for intervals1: " + solution.eraseOverlapIntervals(intervals1)); // Output: 1
        
        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println("Output for intervals2: " + solution.eraseOverlapIntervals(intervals2)); // Output: 2
        
        int[][] intervals3 = {{1, 2}, {2, 3}};
        System.out.println("Output for intervals3: " + solution.eraseOverlapIntervals(intervals3)); // Output: 0
    }
}
