package leetcode.P1497_CheckIfArrayPairsAreDivisibleByK;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        for (int x : arr) {
            int rem = x % k;
            if (rem < 0)
                rem += k;
            freq[rem]++;
        }

        if (freq[0] % 2 != 0)
            return false;

        for (int i = 1; i <= k / 2; i++) {
            if (i == k - i) { // Middle element (e.g. k=4, i=2)
                if (freq[i] % 2 != 0)
                    return false;
            } else {
                if (freq[i] != freq[k - i])
                    return false;
            }
        }

        return true;
    }
}
