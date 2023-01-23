import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public static final int START = 0;
    public static final int END = 1;

    public static void main(String[] args) {
        
        // case variables
        int[][] intervals;
        int[] newInterval;

        // // case 1
        // intervals = new int[][]{{1, 3}, {6, 9}};
        // newInterval = new int[]{2, 5};
        // printArray(new Solution().insert(intervals, newInterval));

        // // case 2
        // intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        // newInterval = new int[]{4, 8};
        // printArray(new Solution().insert(intervals, newInterval));

        // // case 3
        // intervals = new int[][]{};
        // newInterval = new int[]{4, 8};
        // printArray(new Solution().insert(intervals, newInterval));

        // case 4
        intervals = new int[][]{{1, 5}};
        newInterval = new int[]{2, 3};
        printArray(new Solution().insert(intervals, newInterval));

    }
    
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        
        boolean isIntervalInserted = false;
        ArrayList<int[]> result = new ArrayList<>();

        for (int index = 0; index < intervals.length; index++) {
            
            if (intervalsAreOverlapping(newInterval, intervals[index])) {

                newInterval = mergeTwoOverlappingIntervals(newInterval, intervals[index]);

            } else if (newInterval[START] < intervals[index][START] && !isIntervalInserted) {

                result.add(newInterval);
                result.add(intervals[index]);
                isIntervalInserted = true;

            } else {

                result.add(intervals[index]);

            }

        }

        if (!isIntervalInserted) {
            result.add(newInterval);
        }

        return result.stream().toArray(int[][]::new);

    }

    public boolean intervalsAreOverlapping(int[] interval1, int[] interval2) {
        return Math.max(interval1[START], interval2[START]) <= Math.min(interval1[END], interval2[END]);
    }

    public int[] mergeTwoOverlappingIntervals(int[] interval1, int[] interval2) {
        return new int[]{
            Math.min(interval1[START], interval2[START]),
            Math.max(interval1[END], interval2[END])
        };
    }

    public static void printArray(int[][] arr) {
        for (int[] innerArray : arr) {
            System.out.print(Arrays.toString(innerArray) + ' ');
        }
        System.out.println();
    }
    
}