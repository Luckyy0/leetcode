package leetcode.P866_PrimePalindrome;

class Solution {
    public int primePalindrome(int n) {
        if (8 <= n && n <= 11)
            return 11;

        for (int i = 1; i < 100000; i++) {
            // odd length palindrome: root i, e.g. 123 -> 12321
            String s = Integer.toString(i);
            StringBuilder sb = new StringBuilder(s);
            for (int j = s.length() - 2; j >= 0; j--)
                sb.append(s.charAt(j));

            int p = Integer.parseInt(sb.toString());
            if (p >= n && isPrime(p))
                return p;
        }
        return -1;
    }

    private boolean isPrime(int x) {
        if (x < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}
