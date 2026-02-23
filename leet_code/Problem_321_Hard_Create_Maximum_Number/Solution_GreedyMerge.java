package leet_code.Problem_321_Hard_Create_Maximum_Number;

public class Solution_GreedyMerge {

    /**
     * Creates maximum number of length k.
     * Uses Greedy Subsequence and Merge Logic.
     * Time: O(K * (M+N)^2) worst case, effectively faster. Space: O(K).
     * 
     * Tạo số lớn nhất có độ dài k.
     * Sử dụng Chuỗi con Tham lam và Logic Hợp nhất.
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] maxAns = new int[k];

        // Iterate over the length 'i' to be picked from nums1
        // 'i' must be at least k - n (if we take all from nums2, we still need k-n from
        // nums1)
        // 'i' can be at most m
        // Lặp qua độ dài 'i' được chọn từ nums1
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            // Get max subsequence of length i from nums1
            int[] sub1 = maxSubsequence(nums1, i);
            // Get max subsequence of length k-i from nums2
            int[] sub2 = maxSubsequence(nums2, k - i);

            // Merge them
            int[] candidate = merge(sub1, sub2);

            // Update global max
            if (greater(candidate, 0, maxAns, 0)) {
                maxAns = candidate;
            }
        }

        return maxAns;
    }

    // Finds max subsequence of certain length k using Monotonic Stack logic
    private int[] maxSubsequence(int[] nums, int k) {
        int[] res = new int[k];
        int len = 0; // Stack pointer
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // We can pop if we have enough remaining elements to fill the stack to size k
            // Remaining elements in array: n - 1 - i
            // Elements currently in stack: len
            // Total available: len + n - 1 - i
            // If we pop 1, we have len - 1 + n - 1 - i.
            // Condition: While stack not empty AND peek < current AND we still have enough
            // to fill k
            // Remaining elements to process including current: n - i
            // We need 'k' elements total. Current stack has 'len'.
            // If we pop, we have 'len - 1'. We can fill remaining 'k - (len - 1)' from 'n -
            // i'.
            // So n - i >= k - (len - 1) => n - i >= k - len + 1 => n - i + len - 1 >= k?
            // Correct logic: number of elements we can drop = n - k

            while (len > 0 && len + (n - i) > k && nums[i] > res[len - 1]) {
                len--;
            }
            if (len < k) {
                res[len++] = nums[i];
            }
        }
        return res;
    }

    // Merges two arrays to form largest number
    private int[] merge(int[] nums1, int[] nums2) {
        int k = nums1.length + nums2.length;
        int[] res = new int[k];
        int i = 0, j = 0;

        for (int r = 0; r < k; r++) {
            // Compare rest of arrays to decide which to pick
            if (greater(nums1, i, nums2, j)) {
                res[r] = nums1[i++];
            } else {
                res[r] = nums2[j++];
            }
        }
        return res;
    }

    // Returns true if nums1[i...] > nums2[j...] lexicographically
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j])
                return true;
            if (nums1[i] < nums2[j])
                return false;
            i++;
            j++;
        }
        // If one ends, the one with remaining elements is technically "greater prefix"?
        // Logic: if nums1 is prefix of nums2 (e.g. [1,2] vs [1,2,3]), then nums2 is
        // greater.
        return j == nums2.length && i < nums1.length;
        // Wait, standard lexicographical comparison:
        // If equal up to end of one: the longer one is greater?
        // E.g. [9] vs [9, 8]. [9] ? [9, 8].
        // If we pick 9 from first, we have [] and [9, 8]. Next is 9.
        // If we pick 9 from second, we have [9] and [8]. Next is 9.
        // Here we just want to know strictly greater.
        // Actually length is handled by loop condition.
        // If loop ends:
        // if i reached end and j didn't: nums2 longer. return false (nums2 > nums1).
        // if j reached end and i didn't: nums1 longer. return true.
        // if both reached end: equal. return true (doesn't matter).
    }

    public static void main(String[] args) {
        Solution_GreedyMerge solution = new Solution_GreedyMerge();

        // Test Case 1
        int[] n1 = { 3, 4, 6, 5 };
        int[] n2 = { 9, 1, 2, 5, 8, 3 };
        int[] res1 = solution.maxNumber(n1, n2, 5);
        System.out.print("Result 1: ");
        for (int x : res1)
            System.out.print(x + " ");
        System.out.println(); // 9 8 6 5 3

        // Test Case 2
        int[] n3 = { 6, 7 };
        int[] n4 = { 6, 0, 4 };
        int[] res2 = solution.maxNumber(n3, n4, 5);
        System.out.print("Result 2: ");
        for (int x : res2)
            System.out.print(x + " ");
        System.out.println(); // 6 7 6 0 4
    }
}
