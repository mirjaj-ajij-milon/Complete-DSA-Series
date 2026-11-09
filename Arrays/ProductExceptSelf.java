
/**
 * Problem Description:
 * Product of Array Except Self (LeetCode 238).
 *
 * Given an integer array `num`, return an array `res` such that
 * res[i] contains the product of all elements except num[i].
 *
 * ---------------------------------------------------------
 * Approach 1: Brute Force
 * ---------------------------------------------------------
 * 1. Create a result array `res` of size n.
 * 2. Use an outer loop to traverse each index i.
 * 3. Initialize product = 1 for every index.
 * 4. Use an inner loop to traverse the entire array.
 * 5. If i != j, multiply num[j] with product.
 * 6. Store the product in res[i].
 * 7. Return the result array.
 *
 * Time Complexity: O(n^2) - Two nested loops.
 * Space Complexity: O(n) - Result array.
 *
 * ---------------------------------------------------------
 * Approach 2: Optimized Using Prefix and Suffix Arrays
 * ---------------------------------------------------------
 * 1. Create three arrays: prefix, suffix and res.
 * 2. Prefix Array:
 * - prefix[i] stores the product of all elements
 * from index 0 to i.
 * - prefix[i] = prefix[i - 1] * num[i].
 *
 * 3. Suffix Array:
 * - suffix[i] stores the product of all elements
 * from index i to n - 1.
 * - suffix[i] = suffix[i + 1] * num[i].
 *
 * 4. Calculate the result:
 * - For the first index, use suffix[1].
 * - For the last index, use prefix[n - 2].
 * - For middle indices, multiply:
 * prefix[i - 1] * suffix[i + 1].
 *
 * 5. Return the result array.
 *
 * Time Complexity: O(n) - Three separate traversals.
 * Space Complexity: O(n) - Prefix, suffix and result arrays.
 *
 * ---------------------------------------------------------
 * Key Concept:
 * Prefix = Product of elements on the left.
 * Suffix = Product of elements on the right.
 * Result = Prefix * Suffix.
 */
public class ProductExceptSelf {

    public static int[] prodEself(int num[]) { // O(n^2)
        int res[] = new int[num.length];

        for (int i = 0; i < num.length; i++) {
            int product = 1;

            for (int j = 0; j < num.length; j++) {
                if (i != j) {
                    product = product * num[j];
                }
            }

            res[i] = product;
        }

        return res;
    }

    // Optimized Using Prefix and Suffix Arrays
    public static int[] prodEselfOptmize(int arr[]) { // O(n)
        int n = arr.length;
        int res[] = new int[n];

        int prefix[] = new int[n];
        int suffix[] = new int[n];

        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * arr[i];
        }

        suffix[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * arr[i];
        }

        for (int i = 1; i < n - 1; i++) {
            res[i] = prefix[i - 1] * suffix[i + 1];
        }

        res[0] = suffix[1];
        res[n - 1] = prefix[n - 2];

        return res;
    }

    public static void main(String[] args) {
        int num[] = { 2, 4, 8, 6, 9, 3, 4 };

        int result[] = prodEselfOptmize(num);

        for (int i = 0; i < result.length; i++) {
            System.out.println(
                    "The product value except self is : " + result[i]);
        }
    }
}
