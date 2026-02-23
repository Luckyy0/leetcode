package leet_code.Problem_277_Medium_Find_The_Celebrity;

// Mock class to simulate the API
class Relation {
    boolean knows(int a, int b) {
        // Implementation hidden by LeetCode
        return false;
    }
}

public class Solution_TwoPass extends Relation {

    /**
     * Finds the celebrity.
     * Uses Two-Pass Logic to minimize API calls.
     * Time: O(N), Space: O(1).
     * 
     * Tìm người nổi tiếng.
     * Sử dụng Logic Hai Lượt để giảm thiểu cuộc gọi API.
     */
    public int findCelebrity(int n) {
        int candidate = 0;

        // Pass 1: Find a potential candidate
        // Logic: specific elimination
        // Lượt 1: Tìm ứng viên tiềm năng
        // Logic: loại trừ cụ thể
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                // If candidate knows i, candidate cannot be celebrity.
                // i could be the celebrity.
                // Nếu candidate biết i, candidate không thể là người nổi tiếng.
                // i có thể là người nổi tiếng.
                candidate = i;
            }
            // If candidate doesn't know i, i cannot be celebrity (celeb is known by all).
            // candidate stays the same.
        }

        // Pass 2: Verify the candidate
        // Lượt 2: Xác minh ứng viên
        for (int i = 0; i < n; i++) {
            if (i == candidate)
                continue;

            // Criteria:
            // 1. Candidate must know NO ONE (knows(candidate, i) must be false)
            // 2. Everyone must know candidate (knows(i, candidate) must be true)
            // Tiêu chí:
            // 1. Candidate không được biết AI (knows(candidate, i) phải false)
            // 2. Mọi người phải biết candidate (knows(i, candidate) phải true)
            if (knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }

        return candidate;
    }
}
