package leetcode.P650_2KeysKeyboard;

class Solution {
    public int minSteps(int n) {
        if (n == 1)
            return 0;

        int steps = 0;
        int factor = 2;

        // Find prime factorization and sum the factors
        // Tìm phân tích thừa số nguyên tố và tính tổng các thừa số
        while (n > 1) {
            while (n % factor == 0) {
                steps += factor;
                n /= factor;
            }
            factor++;
        }

        return steps;
    }
}
