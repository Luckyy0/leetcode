package leetcode.P754_ReachANumber;

class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        long sum = 0;

        while (sum < target) {
            k++;
            sum += k;
        }

        // While the difference between sum and target is odd, we can't flip signs to
        // match
        // Trong khi hiệu giữa sum và target là lẻ, chúng ta không thể lật dấu để khớp
        while ((sum - target) % 2 != 0) {
            k++;
            sum += k;
        }

        return k;
    }
}
