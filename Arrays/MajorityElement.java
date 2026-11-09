
/**
 * Problem Description:
 * Majority Element (LeetCode 169).
 *
 * Given an integer array `num` of size n, find the majority element.
 * The majority element is the element that appears more than
 * floor(n / 2) times.
 *
 * If no majority element exists, return -1.
 *
 * ---------------------------------------------------------
 * Approach 1: Brute Force
 * ---------------------------------------------------------
 * 1. Traverse each element using an outer loop.
 * 2. Initialize count = 0 for every element.
 * 3. Use an inner loop to compare the current element
 * with every other element.
 * 4. If both elements are equal, increment count.
 * 5. If count > n / 2, return the current element.
 * 6. If no majority element is found, return -1.
 *
 * Time Complexity: O(n^2) - Two nested loops.
 * Space Complexity: O(1) - Only a counter variable is used.
 *
 * ---------------------------------------------------------
 * Approach 2: Optimized (Boyer-Moore Voting Algorithm)
 * ---------------------------------------------------------
 * Step 1: Find a Candidate
 * 1. Initialize majority = num[0] and lead = 1.
 * 2. Traverse the array from index 1:
 * a. If num[i] == majority, increment lead.
 * b. Else if lead > 0, decrement lead.
 * c. Else, update majority = num[i] and lead = 1.
 *
 * Step 2: Verify the Candidate
 * 1. Initialize count = 0.
 * 2. Traverse the array and count occurrences of majority.
 * 3. If count > n / 2, return majority.
 * 4. Otherwise, return -1.
 *
 * Time Complexity: O(n) - Two linear traversals.
 * Space Complexity: O(1) - Only a few variables are used.
 *
 * ---------------------------------------------------------
 * Key Concept:
 * Same element -> Increment lead (vote +1).
 * Different element -> Decrement lead (vote -1).
 * Lead becomes 0 -> Select a new candidate.
 *
 * Important:
 * Boyer-Moore finds a possible candidate, not necessarily
 * a guaranteed majority element. Always verify the candidate
 * if the problem does not guarantee a majority element.
 */
public class MajorityElement {

    // Brute Force Approach - O(n^2)
    public static int majorityElement(int nums[]) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }

    // Optimized Approach - Boyer-Moore Voting Algorithm - O(n)
    public static int findmajorityelement(int num[]) {
        int majority = num[0], lead = 1;
        int n = num.length;

        // Step 1: Find candidate
        for (int i = 1; i < n; i++) {
            if (num[i] == majority) {
                lead++;
            } else if (lead > 0) {
                lead--;
            } else {
                majority = num[i];
                lead = 1;
            }
        }

        // Step 2: Verify candidate if we not assume al least one major exist
        // int count = 0;

        // for (int i = 0; i < n; i++) {
        //     if (num[i] == majority) {
        //         count++;
        //     }
        // }

        // return count > n / 2 ? majority : -1;
        return majority;
    }

    public static void main(String args[]) {
        int num[] = { 2, 5, 3, 3, 3, 2, 3, 3, 2, 3, 5, 6, 4 };

        System.out.println(
                "The majority element in this array is : "
                        + findmajorityelement(num));
    }
}
