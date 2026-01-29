package leetcode.P2180_CountIntegersWithEvenDigitSum;

public class Solution {
    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (digitSum(i) % 2 == 0)
                count++;
        }
        return count;
    }

    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
