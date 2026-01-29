package leetcode.P1134_ArmstrongNumber;

class Solution {
    public boolean isArmstrong(int n) {
        String s = String.valueOf(n);
        int k = s.length();
        int sum = 0;
        int temp = n;

        while (temp > 0) {
            int d = temp % 10;
            sum += Math.pow(d, k);
            temp /= 10;
        }

        return sum == n;
    }
}
