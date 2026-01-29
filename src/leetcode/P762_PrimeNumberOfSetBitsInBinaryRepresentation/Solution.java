package leetcode.P762_PrimeNumberOfSetBitsInBinaryRepresentation;

class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        // Prime filter for set bits count up to 32 bits
        // Bộ lọc số nguyên tố cho số lượng bit lên tới 32 bit
        boolean[] isPrime = new boolean[33];
        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
        for (int p : primes)
            isPrime[p] = true;

        for (int i = left; i <= right; i++) {
            if (isPrime[Integer.bitCount(i)]) {
                count++;
            }
        }
        return count;
    }
}
