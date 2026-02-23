package leet_code.Problem_390_Medium_Elimination_Game;

public class Solution_HeadTracking {

    /**
     * Finds the last remaining number in the elimination game.
     * Uses head-tracking for O(log N) efficiency.
     * Time: O(log N), Space: O(1).
     * 
     * Tìm số cuối cùng còn lại trong trò chơi loại trừ.
     * Sử dụng phương pháp theo dõi điểm đầu để đạt hiệu suất O(log N).
     */
    public int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        int remaining = n;
        boolean leftToRight = true;

        while (remaining > 1) {
            // Head changes if we move L->R OR if we move R->L and length is odd
            // Điểm đầu thay đổi nếu di chuyển TẢ -> HỮU HOẶC di chuyển HỮU -> TẢ và độ dài
            // lẻ
            if (leftToRight || remaining % 2 == 1) {
                head += step;
            }

            remaining /= 2;
            step *= 2;
            leftToRight = !leftToRight;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution_HeadTracking solution = new Solution_HeadTracking();

        // Test Case 1: n = 9 -> 6
        System.out.println("Result 9: " + solution.lastRemaining(9));

        // Test Case 2: n = 1 -> 1
        System.out.println("Result 1: " + solution.lastRemaining(1));
    }
}
