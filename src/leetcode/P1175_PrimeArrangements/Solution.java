package leetcode.P1175_PrimeArrangements;

class Solution {
    public int numPrimeArrangements(int n) {
        int primes = countPrimes(n);
        int nonPrimes = n - primes;
        long mod = 1_000_000_007;

        long res = 1;
        for (int i = 1; i <= primes; i++)
            res = (res * i) % mod;
        for (int i = 1; i <= nonPrimes; i++)
            res = (res * i) % mod;

        return (int) res;
    }

    private int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i))
                count++;
        }
        return count;
    }

    private boolean isPrime(int x) {
        if (x < 2)
            return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}
