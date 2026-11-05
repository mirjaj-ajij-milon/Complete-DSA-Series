import java.util.*;

/**
 * Problem Description:
 * Binary Search in a Sorted Array.
 * Given a sorted array of integers in ascending order and a target `key`, efficiently
 * find the index of `key` using the divide-and-conquer search technique. If not found, return -1.
 *
 * Algorithm / Approach:
 * 1. Maintain two pointers: `start = 0` and `end = num.length - 1`.
 * 2. While `start <= end`:
 *    a. Find the middle index: `mid = (start + end) / 2`.
 *    b. If `num[mid] == key`, return `mid` (element found).
 *    c. If `num[mid] < key`, the target lies in the right half, so update `start = mid + 1`.
 *    d. If `num[mid] > key`, the target lies in the left half, so update `end = mid - 1`.
 * 3. If `start > end`, the target is not in the array, return -1.
 *
 * Time Complexity:
 *   - Best Case: O(1) when key is at the mid index on the first check.
 *   - Worst / Average Case: O(log n) as search space is halved in each step.
 * Space Complexity: O(1) - Iterative approach uses constant extra memory.
 */
public class BinarySearch {

    public static int binarySearch(int num[], int key) {
        int start = 0;
        int end = num.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2; // to find the mid of array

            if (num[mid] == key) { // Found
                return mid;
            }
            if (num[mid] < key) { // Right half
                start = mid + 1;
            } else { // Left half
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int num[] = {2, 4, 6, 8, 10, 12, 14, 16, 18};

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the key do you find in array index : ");
        int key = sc.nextInt();
        System.out.println(" Idnex for key : " + binarySearch(num, key));
        sc.close();
    }
}
