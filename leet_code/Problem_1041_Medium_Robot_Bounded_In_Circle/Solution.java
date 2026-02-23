package Problem_1041_Medium_Robot_Bounded_In_Circle;

/**
 * 1041. Robot Bounded In Circle
 * 
 * On an infinite plane, a robot initially stands at (0, 0) and faces north.
 * The robot can receive one of three instructions:
 * - 'G': go straight 1 unit;
 * - 'L': turn 90 degrees to the left;
 * - 'R': turn 90 degrees to the right.
 * 
 * The robot performs the instructions given in order, and repeats them forever.
 * Return true if and only if there exists a circle in the plane such that the
 * robot never leaves the circle.
 */
public class Solution {

    /**
     * Dùng Toán học Vector không gian để xác định chu kỳ lặp vòng của Robot.
     * 
     * @param instructions Chuỗi Lệnh di chuyển của Robot
     * @return Kiểm tra xem Robot có bị vướng vào đường chạy tuần hoàn không lối
     *         thoát hay không
     */
    public boolean isRobotBounded(String instructions) {
        // La bàn Tọa độ Vector Hướng: Bắc, Đông, Nam, Tây
        // Gốc (0, 0), Robot Mặc định Mắt nhìn Bắc (Điểm Y Tịnh Tiến Dương).
        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int x = 0;
        int y = 0;
        int dir = 0; // 0 = Bắc

        // Chạy Nhám Đúng 1 Vòng Luân Hồi
        for (char c : instructions.toCharArray()) {
            if (c == 'R') {
                // Ngoặt Phải Thuận Kim Đồng Hồ 90 Độ
                dir = (dir + 1) % 4;
            } else if (c == 'L') {
                // Ngoặt Trái Nghịch Kim Đồng Hồ 90 Độ
                dir = (dir + 3) % 4;
            } else {
                // Cắm Cổ Đi Thẳng G -> Cộng Vector của Hướng Hiện Tại Vào Tọa độ
                x += directions[dir][0];
                y += directions[dir][1];
            }
        }

        // Quyết Định Vận Mệnh: Liệu Nó về Nhà Mẹ? Hay Hướng Cổ Nó Đã Bị Bẻ Xẹo Quẹo
        // Khỏi Mốc BẮC Cự Giải!
        return (x == 0 && y == 0) || dir != 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String instructions1 = "GGLLGG";
        System.out.println("Test 1: " + sol.isRobotBounded(instructions1)); // Expected: true

        String instructions2 = "GG";
        System.out.println("Test 2: " + sol.isRobotBounded(instructions2)); // Expected: false

        String instructions3 = "GL";
        System.out.println("Test 3: " + sol.isRobotBounded(instructions3)); // Expected: true
    }
}
