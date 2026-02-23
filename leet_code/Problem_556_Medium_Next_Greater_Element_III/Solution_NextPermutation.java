package leet_code.Problem_556_Medium_Next_Greater_Element_III;

public class Solution_NextPermutation {

    /**
     * Finds the smallest integer greater than n with same digits.
     * Strategy: Next Permutation algorithm.
     * Time: O(D), Space: O(D).
     */
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;

        // 1. Find pivot from right
        int i = len - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        if (i < 0)
            return -1;

        // 2. Find successor to swap with i
        int j = len - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // 3. Swap i and j
        swap(digits, i, j);

        // 4. Reverse suffix starting from i + 1
        reverse(digits, i + 1, len - 1);

        // 5. Convert back and check overflow
        try {
            long val = Long.parseLong(new String(digits));
            return val > Integer.MAX_VALUE ? -1 : (int) val;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void reverse(char[] a, int start, int end) {
        while (start < end) {
            swap(a, start++, end--);
        }
    }

    public static void main(String[] args) {
        Solution_NextPermutation solution = new Solution_NextPermutation();
        System.out.println("Result 12 -> " + solution.nextGreaterElement(12)); // 21
        System.out.println("Result 21 -> " + solution.nextGreaterElement(21)); // -1
        System.out.println("Result 1999999999 -> " + solution.nextGreaterElement(1999999999)); // -1 (Overflow)
    }
}
