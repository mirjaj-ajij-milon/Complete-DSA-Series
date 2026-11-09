/**
 * Problem Description:
 * Print All Contiguous Subarrays of an Array.
 * Given an integer array, generate and print all possible continuous subarrays and count
 * the total number of subarrays generated.
 * Formula for total subarrays: Total Subarrays = n * (n + 1) / 2.
 *
 * Algorithm / Approach:
 * 1. Initialize a counter `ts = 0` to track the total number of subarrays.
 * 2. Outer loop `i` chooses the starting index (0 to n - 1).
 * 3. Middle loop `j` chooses the ending index (i to n - 1).
 * 4. Inner loop `k` traverses from `start` to `end`, printing each element in the current subarray.
 * 5. Increment `ts` after printing each subarray.
 * 6. Print the total subarray count.
 *
 * Time Complexity: O(n^3) - Generates O(n^2) subarrays, printing each takes up to O(n).
 * Space Complexity: O(1) - Constant auxiliary space.
 */
public class PrintSubarrays {

    public static void printSubArry(int num[]) {
        int ts = 0;

        for (int i = 0; i < num.length; i++) { // Find the start point in an array
            int start = i;

            for (int j = i; j < num.length; j++) { // Find end point
                int end = j;

                for (int k = start; k <= end; k++) { // print
                    System.out.print(num[k] + " "); // SubArrays
                }
                ts++;

                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total Subarray is = " + ts);
    }

    public static void main(String args[]) {
        int num[] = {2, 6, 8, 10, 12, 14, 16, 18, 20};
        printSubArry(num);
    }
}
