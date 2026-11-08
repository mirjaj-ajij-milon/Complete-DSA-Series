/**
 * Problem Description:
 * Maximum Subarray Sum using Brute Force.
 * Given an integer array, find the maximum sum among all possible continuous subarrays
 * by examining every subarray with 3 nested loops.
 *
 * Algorithm / Approach (Brute Force):
 * 1. Initialize `maxsum = Integer.MIN_VALUE`.
 * 2. Outer loop `i` picks the start point of each subarray (from 0 to n - 1).
 * 3. Inner loop `j` picks the end point of each subarray (from i to n - 1).
 * 4. Innermost loop `k` iterates from `start` to `end`, calculating `currsum += num[k]`.
 * 5. Track the maximum sum: `maxsum = Math.max(currsum, maxsum)`.
 * 6. Print the sums and output the maximum subarray sum found.
 *
 * Time Complexity: O(n^3) - Three nested loops (O(n^2) subarrays with O(n) sum each).
 * Space Complexity: O(1) - Constant auxiliary space.
 */
public class MaxSubarrayBruteForce {

    public static void maxsubarrsum(int num[]) {
        int currsum;
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            int start = i;

            for (int j = i; j < num.length; j++) {
                int end = j;
                currsum = 0;

                for (int k = start; k <= end; k++) {
                    currsum += num[k];
                }
                System.out.println("Sum of All sub Array = " + currsum);
                maxsum = Math.max(currsum, maxsum);
            }
        }

        System.out.println("The max sum of sub Array = " + maxsum);
    }

    public static void main(String args[]) {
        // MaxSum 
        int num[] = {2, 3, 5, 7, 9, 6};
        maxsubarrsum(num);
    }
}
