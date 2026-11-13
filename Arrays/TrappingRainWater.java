/**
 * Problem Description:
 * Trapping Rain Water (LeetCode 42).
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Algorithm / Approach (Prefix & Suffix Max Arrays):
 * 1. For each bar at index i, the water it holds is bounded by:
 * Water Level = min(leftMaxBoundary, rightMaxBoundary)
 * Trapped Water at index i = Water Level - height[i].
 * 2. Precompute left maximum boundary array `leftmax[]`:
 * `leftmax[0] = height[0]`
 * `leftmax[i] = Math.max(height[i], leftmax[i - 1])`
 * 3. Precompute right maximum boundary array `rightmax[]`:
 * `rightmax[n - 1] = height[n - 1]`
 * `rightmax[i] = Math.max(height[i], rightmax[i + 1])`
 * 4. Loop through each bar, calculate water level, and accumulate total trapped
 * water:
 * `trappedWater += (waterLevel - height[i])`.
 *
 * Time Complexity: O(n) - Three sequential linear passes of length n.
 * Space Complexity: O(n) - Two auxiliary arrays of size n for left and right
 * maximum boundaries.
 */
public class TrappingRainWater {

    public static int trappedRainWater(int height[]) {
        int n = height.length;

        // Calculate left max boundary - Array (helper array)
        int leftmax[] = new int[n];
        leftmax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(height[i], leftmax[i - 1]);
        }

        // Calculate right max boundary - Array (helper array)
        int rightmax[] = new int[n];
        rightmax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(height[i], rightmax[i + 1]);
        }

        // Loop
        int trappedwater = 0;
        for (int i = 0; i < n; i++) {
            int waterlevel = Math.min(leftmax[i], rightmax[i]);
            int totalWater = waterlevel - height[i];

            if (totalWater > 0) {
                trappedwater += totalWater;
            }
        }

        return trappedwater;
    }

    public static void main(String args[]) {
        int height[] = { 7, 5, 4, 2, 6, 8, 7, 5, 8 };
        System.out.println("The volume of stored Trapped Rain Water is : " + trappedRainWater(height));
    }
}
