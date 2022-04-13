/**
 * First, we will build a cumulative sum array while taking the inputs.
 * This will help in calculating the sum of weights of any sub-array in O(1) time.
 * Building the cumulative sum array requires O(N) time.
 *
 * Next, we will use the sliding window approach.
 * We will expand the sliding window by incrementing end_index
 * until sum of weights of the sub-array is greater than or equal the weight limit.
 * If the sum of weights is over the limit then we will reduce the window by incrementing begin_index
 * until sum of weights is less than the weight limit.
 *
 * Every time we expand the window we keep track of all the possible sub-arrays within the window
 * that ends with the last index. This can be simply calculated by end_index - begin_index + 1
 * For example, for a window where begin = 2 and end = 4, the following sub-arrays will be counted:
 * sub-array[2 to 4]
 * sub-array[3 to 4]
 * sub-array[4 to 4]
 *
 * Overall time complexity for this approach is O(N)
 */

import java.util.Arrays;
import java.util.Scanner;

public class ProblemC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int test = sc.nextInt(); test --> 0;) {
            long[] arr = new long[sc.nextInt()];
            long limit = sc.nextLong();
            Arrays.setAll(arr, i -> sc.nextLong() + (i == 0 ? 0 : arr[i - 1]));
            solve(limit, arr);
        }
    }

    public static void solve(long limit, long[] arr) {
        int begin = 0, end = 0;
        long count = 0;

        while (end < arr.length) {
            if (getCumulativeSum(arr, begin, end) < limit) {
                count += end - begin + 1;
                end++;
            } else {
                begin++;
            }
            if (begin > end) {
                end = begin;
            }
        }
        System.out.println(count);
    }

    public static long getCumulativeSum(long[] arr, int from, int to) {
        return arr[to] - (from == 0 ? 0 : arr[from - 1]);
    }

}
