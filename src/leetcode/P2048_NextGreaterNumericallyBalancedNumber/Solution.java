package leetcode.P2048_NextGreaterNumericallyBalancedNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    List<Integer> balanced;

    public int nextBeautifulNumber(int n) {
        balanced = new ArrayList<>();
        // Generate for lengths 1 to 7 (since n <= 10^6, answer could be e.g. 1224444)
        // Length 7 sum digits: 1+2+4=7.
        generate(0, 0, new int[10]);
        Collections.sort(balanced);

        for (int x : balanced) {
            if (x > n)
                return x;
        }
        return -1;
    }

    private void generate(int currentLen, int currentVal, int[] counts) {
        // Optimizing generation: We can't easily iterate values.
        // Better: Generate valid combinations of digits, then permute.
        // But iterating just by checking is valid is harder?
        // Let's iterate on 'combinations of digits that sum to length'.
        // Actually, simpler recursive generation:
        // Or bruteforce check starting from n+1?
        // Max gap?
        // 10^6 approx. Next is 1224444. Gap could be large.
        // Generation is better.

        // Re-implement generation:
        // Iterate lengths L from 1 to 7.
        // Find partitions of L into d1 + d2 + ... = L.
        // e.g. L=3 -> 3 (use digit 3, 3 times), 1+2 (use digit 1 once, digit 2 twice).
        // For each combination, generate permutations.
    }

    // Improved approach:
    // Just use backtracking to form number with counts.
    // Or simpler: Enumerate possible digit sets.
    // Possible sets:
    // L=1: {1}
    // L=2: {2,2}
    // L=3: {1,2,2}, {3,3,3}
    // L=4: {1,3,3,3}, {4,4,4,4}
    // L=5: {1,4,4,4,4}, {2,2,3,3,3}, {5,5,5,5,5}
    // L=6: {1,2,2,3,3,3}, {1,5,5,5,5,5}, {2,2,2,4,4,4,4}, {6,6,6,6,6,6} NO wait sum
    // must match.
    // L=6: {1,5...}, {2,4...}, {3,3... No sum 6: {1,2,3} -> 1+2+3=6 YES use 1 one,
    // 2 two, 3 three.
    // {6...} -> {6 six times}.
    // L=7: {1,2,4...} -> 1+2+4=7.
    // {1,6...} -> 1+6=7.
    // {2,5...} -> 2+5=7.
    // {3,4...} -> 3+4=7.
    // {7...} -> 7.

    // Hardcoding sets is cleaner.
    // L=1: [1]
    // L=2: [2,2]
    // L=3: [1,2,2], [3,3,3]
    // L=4: [1,3,3,3], [4,4,4,4]
    // L=5: [1,4,4,4,4], [2,2,3,3,3], [5,5,5,5,5]
    // L=6: [1,2,2,3,3,3], [1,5,5,5,5,5], [2,2,2,4,4,4,4], [6,6,6,6,6,6]
    // L=7: [1,2,2,4,4,4,4], [1,6,6,6,6,6,6], [2,2,5,5,5,5,5], [3,3,3,4,4,4,4],
    // [7,7,7,7,7,7,7]

    // Just permute these.

    public int nextBeautifulNumber_Correct(int n) {
        // Redefine to use permuter
        List<int[]> sets = new ArrayList<>();
        sets.add(new int[] { 1 });
        sets.add(new int[] { 2, 2 });
        sets.add(new int[] { 1, 2, 2 });
        sets.add(new int[] { 3, 3, 3 });
        sets.add(new int[] { 1, 3, 3, 3 });
        sets.add(new int[] { 4, 4, 4, 4 });
        sets.add(new int[] { 1, 4, 4, 4, 4 });
        sets.add(new int[] { 2, 2, 3, 3, 3 });
        sets.add(new int[] { 5, 5, 5, 5, 5 });
        sets.add(new int[] { 1, 2, 2, 3, 3, 3 });
        sets.add(new int[] { 1, 5, 5, 5, 5, 5 });
        sets.add(new int[] { 2, 2, 2, 4, 4, 4, 4 });
        sets.add(new int[] { 6, 6, 6, 6, 6, 6 });
        sets.add(new int[] { 1, 2, 2, 4, 4, 4, 4 });
        sets.add(new int[] { 1, 6, 6, 6, 6, 6, 6 });
        sets.add(new int[] { 2, 2, 5, 5, 5, 5, 5 });
        sets.add(new int[] { 3, 3, 3, 4, 4, 4, 4 });
        sets.add(new int[] { 7, 7, 7, 7, 7, 7, 7 });

        List<Integer> cands = new ArrayList<>();
        for (int[] s : sets) {
            permute(s, 0, cands);
        }
        Collections.sort(cands);

        for (int x : cands) {
            if (x > n)
                return x;
        }
        return -1;
    }

    private void permute(int[] arr, int start, List<Integer> res) {
        if (start == arr.length) {
            int val = 0;
            for (int d : arr)
                val = val * 10 + d;
            res.add(val);
            return;
        }

        // Handle duplicates
        for (int i = start; i < arr.length; i++) {
            if (isDuplicate(arr, start, i))
                continue;
            swap(arr, start, i);
            permute(arr, start + 1, res);
            swap(arr, start, i);
        }
    }

    private boolean isDuplicate(int[] arr, int start, int curr) {
        for (int i = start; i < curr; i++) {
            if (arr[i] == arr[curr])
                return true;
        }
        return false;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int nextBeautifulNumberFinal(int n) {
        return nextBeautifulNumber_Correct(n);
    }
}
