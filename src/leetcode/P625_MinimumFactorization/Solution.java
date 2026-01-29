package leetcode.P625_MinimumFactorization;

class Solution {
    public int smallestFactorization(int num) {
        if (num < 2)
            return num;

        long result = 0;
        long multiplier = 1;

        // Try digits from 9 down to 2
        // Thử các chữ số từ 9 xuống 2
        for (int i = 9; i >= 2; i--) {
            while (num % i == 0) {
                num /= i;
                result = multiplier * i + result;
                multiplier *= 10;

                // If result exceeds integer max, return 0
                // Nếu kết quả vượt quá giới hạn số nguyên, trả về 0
                if (result > Integer.MAX_VALUE) {
                    return 0;
                }
            }
        }

        // If num is still > 1, it means it has prime factors > 9 (impossible to form
        // with digits)
        // Nếu num vẫn > 1, có nghĩa là nó có các thừa số nguyên tố > 9 (không thể tạo
        // thành từ các chữ số)
        return (num < 2 && result <= Integer.MAX_VALUE) ? (int) result : 0;
    }
}
