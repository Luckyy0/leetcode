package leetcode.P1295_FindNumbersWithEvenNumberOfDigits;

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int x : nums) {
            // Log10 method
            // int digits = (int) (Math.log10(x) + 1);
            // if (digits % 2 == 0) count++;

            // Or range check
            if ((x >= 10 && x <= 99) || (x >= 1000 && x <= 9999) || (x == 100000)) {
                count++;
            }
        }
        return count;
    }
}
