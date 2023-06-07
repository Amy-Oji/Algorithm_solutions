
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalMerger {
    /**
     * From LeetCode : https://leetcode.com/problems/merge-intervals/
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
     * and return an array of the non-overlapping intervals that cover all the intervals in the input.
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     *
     *
     * Example 2:
     *
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     *
     * **/
    public int[][] mergeIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        
        // Sort the intervals based on their start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            
            if (interval[0] <= currentInterval[1]) {
                // Overlapping intervals, update the end time
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                // Non-overlapping interval, add the current interval to the result and update the current interval
                mergedIntervals.add(currentInterval);
                currentInterval = interval;
            }
        }
        
        // Add the last interval
        mergedIntervals.add(currentInterval);
        
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
    
    public static void main(String[] args) {
        IntervalMerger merger = new IntervalMerger();
        
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergedIntervals1 = merger.mergeIntervals(intervals1);
        System.out.println(Arrays.deepToString(mergedIntervals1)); // [[1, 6], [8, 10], [15, 18]]
        
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] mergedIntervals2 = merger.mergeIntervals(intervals2);
        System.out.println(Arrays.deepToString(mergedIntervals2)); // [[1, 5]]
    }
}
