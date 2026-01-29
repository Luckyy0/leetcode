package leetcode.P1363_LargestMultipleOfThree;

class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int[] count = new int[10];
        int sum = 0;
        for (int d : digits) {
            count[d]++;
            sum += d;
        }

        int rem = sum % 3;

        if (rem != 0) {
            int[] mod1 = { 1, 4, 7 };
            int[] mod2 = { 2, 5, 8 };

            if (rem == 1) {
                if (!remove(count, mod1, 1)) {
                    remove(count, mod2, 2);
                }
            } else { // rem == 2
                if (!remove(count, mod2, 1)) {
                    remove(count, mod1, 2);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (count[i] > 0) {
                sb.append(i);
                count[i]--;
            }
        }

        if (sb.length() > 0 && sb.charAt(0) == '0')
            return "0";
        return sb.toString();
    }

    // returns true if successfully removed k elements from mods group
    private boolean remove(int[] count, int[] mods, int k) {
        int removed = 0;
        // Try to remove smallest digits first?
        // Wait, to maximize number, we should remove SMALLEST digits.
        // Array mods is sorted ascending.
        for (int d : mods) {
            while (count[d] > 0 && removed < k) {
                count[d]--;
                removed++;
            }
        }
        return removed == k;
    }
}
