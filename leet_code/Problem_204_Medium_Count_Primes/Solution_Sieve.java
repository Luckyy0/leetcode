package leet_code.Problem_204_Medium_Count_Primes;

import java.util.Arrays;

public class Solution_Sieve {

    /**
     * Counts the number of prime numbers less than n.
     * Uses the Sieve of Eratosthenes algorithm.
     * Time: O(N log log N), Space: O(N).
     * 
     * Đếm số lượng số nguyên tố nhỏ hơn n.
     * Sử dụng thuật toán Sàng Eratosthenes.
     */
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        // Initialize all entries as true. A value in isPrime[i] will
        // be false if i is Not a prime, true if i is a prime.
        Arrays.fill(isPrime, true);

        // 0 and 1 are not prime
        isPrime[0] = false;
        isPrime[1] = false;

        // Loop up to sqrt(n)
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // If isPrime[i] is true, then it is a prime.
                // Mark all multiples of i starting from i*i
                // Đánh dấu tất cả các bội số của i bắt đầu từ i*i
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count primes
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution_Sieve solution = new Solution_Sieve();

        // Test Case 1: 10 -> 4 (2, 3, 5, 7)
        System.out.println("Primes < 10: " + solution.countPrimes(10));

        // Test Case 2: 0 -> 0
        System.out.println("Primes < 0: " + solution.countPrimes(0));

        // Test Case 3: 50 -> 15
        System.out.println("Primes < 50: " + solution.countPrimes(50));
    }
}
