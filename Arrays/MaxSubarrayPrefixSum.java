/**
 * Problem Description:
 * Maximum Subarray Sum using Prefix Sum Approach.
 * Given an integer array, find the maximum sum of a contiguous subarray in
 * O(n^2) time
 * by precomputing prefix sums to evaluate any range sum in O(1).
 *
 * Algorithm / Approach (Prefix Sum):
 * 1. Construct a prefix sum array `prefix[]` of size n:
 * - `prefix[0] = num[0]`
 * - For each i from 1 to n - 1: `prefix[i] = prefix[i - 1] + num[i]`.
 * 2. Iterate through all possible subarray boundaries `[start, end]`:
 * - If `start == 0`: subarray sum is `prefix[end]`.
 * - Otherwise: subarray sum is `prefix[end] - prefix[start - 1]`.
 * 3. Track and update `maxsum` with the maximum `currsum` found.
 * 4. Print the maximum subarray sum.
 *
 * Time Complexity: O(n^2) - Precomputation takes O(n), and evaluating all
 * subarrays takes O(n^2).
 * Space Complexity: O(n) - Auxiliary array of size n to store prefix sums.
 */
public class MaxSubarrayPrefixSum {

    public static void maxsubarrsum(int num[]) {
        if (num == null || num.length == 0) {
            System.out.println("Array is empty");
            return;
        }
        int currsum;
        int maxsum = Integer.MIN_VALUE;
        int prefix[] = new int[num.length];

        prefix[0] = num[0];
        // calculate prefix array
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + num[i];
        }

        for (int i = 0; i < num.length; i++) {
            int start = i;

            for (int j = i; j < num.length; j++) {
                int end = j;
                currsum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

                if (maxsum < currsum) {
                    maxsum = currsum;
                }
            }
        }

        System.out.println("The max sum of sub Array = " + maxsum);
    }

    public static void main(String args[]) {
        int num[] = { 2, 3, 5, 7, 9, 6 };
        maxsubarrsum(num);
    }
}
