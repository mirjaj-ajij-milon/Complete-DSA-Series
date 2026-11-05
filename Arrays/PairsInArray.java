/**
 * Problem Description:
 * Print All Unique Pairs in an Array.
 * Given an integer array, generate and print all distinct unordered pairs of elements
 * (num[i], num[j]) where i < j, and calculate the total count of pairs.
 * Formula for total pairs: Total Pairs = n * (n - 1) / 2.
 *
 * Algorithm / Approach:
 * 1. Initialize a counter `tp = 0` to keep track of total pairs printed.
 * 2. Outer loop `i` runs from 0 to n - 1 (picking the first element).
 * 3. Inner loop `j` runs from `i + 1` to n - 1 (pairing with every subsequent element).
 * 4. Print the pair `(num[i], num[j])` and increment `tp`.
 * 5. Print the total number of pairs at the end.
 *
 * Time Complexity: O(n^2) - There are n*(n-1)/2 total pairs to generate.
 * Space Complexity: O(1) - Constant auxiliary space.
 */
public class PairsInArray {

    public static void printPairs(int num[]) {
        int tp = 0; // To find Total pairs

        for (int i = 0; i < num.length; i++) {
            int current = num[i];

            for (int j = i + 1; j < num.length; j++) {
                System.out.print("(" + current + "," + num[j] + ")");
                tp++;
            }
            System.out.println();
        }

        System.out.println("Total pairs  = " + tp);
    }

    public static void main(String args[]) {
        int num[] = {2, 4, 6, 8, 45, 47, 49, 10, 12};
        printPairs(num);
    }
}
