package Problem_1049_Medium_Last_Stone_Weight_II;

/**
 * 1049. Last Stone Weight II
 * 
 * You are given an array of integers stones where stones[i] is the weight of
 * the ith stone.
 * We are playing a game with the stones. On each turn, we choose any two stones
 * and smash them together.
 * If x == y, both stones are destroyed.
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has
 * new weight y - x.
 * 
 * Return the smallest possible weight of the left stone. If there are no stones
 * left, return 0.
 */
public class Solution {

    /**
     * Thuật toán: Quy Hoạch Động - Bài toán Cái Ba Lô 0-1 (0-1 Knapsack Problem).
     * Dù ta có đập bằng bất cứ tổ hợp nào, khối lượng viên đá cuối cùng cũng bằng
     * việc chia tổng lượng đá ban đầu thành 2 nhóm, và lấy hiệu số của 2 nhóm đó.
     * Để hiệu số nhỏ nhất, ta cố gắng tìm một nhóm sao cho tổng khối lượng của nó
     * CÀNG GẦN MỨC (SUM / 2) CÀNG TỐT (nhưng không vượt quá).
     * Mức đó gọi là Cân Nặng Ba Lô.
     * 
     * @param stones Mảng chứa khối lượng đá
     * @return Khối lượng viên đá còn sót lại nhỏ nhất
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stoneWeight : stones) {
            sum += stoneWeight;
        }

        // Sức chứa tối đa của 1 nhóm (Mục tiêu tiệm cận)
        int targetCapacity = sum / 2;

        // dp[j] là mảng quy hoạch 1 chiều chạy từ 0 đến targetCapacity.
        // Nêu dp[j] == true, có nghĩa là ta có thể gom vài hòn đá tạo ra TỔNG KHỐI
        // LƯỢNG bằng đúng J.
        boolean[] dp = new boolean[targetCapacity + 1];
        dp[0] = true; // Chắc chắn có thể ghép được khối lượng 0 (chưa chọn viên nào).

        // Kiểm tra từng viên đá một
        for (int stoneWeight : stones) {
            // Duyệt ngược mảng Trọng lượng DP từ trên xuống dưới
            // KHÔNG DUYỆT TỪ DƯỚI LÊN để tránh tình trạng 1 viên đá bị đem CỘNG DỒN tự lặp
            // 2 lần!!! (Đây là rule của Ba Lô 0-1)
            for (int j = targetCapacity; j >= stoneWeight; j--) {
                // Nếu mình từng đạt được mức Cân (j - stoneWeight) Bằng CÁC Viên Đá Cũ,
                // Thì Lắp Nốt Viên Hiện Tại (stoneWeight) sẽ giúp ta leo lên Đạt Mức Cân J.
                if (dp[j - stoneWeight]) {
                    dp[j] = true;
                }
            }
        }

        // Khi DP quét xong, Tìm Ngược Số Cân Nặng (J) lớn nhất nằm Lọt dưới Mốc cưa 1/2
        // mà ta Thành Công Đạt Được
        int maxCapacityGroup1 = 0;
        for (int j = targetCapacity; j >= 0; j--) {
            if (dp[j]) {
                maxCapacityGroup1 = j;
                break;
            }
        }

        // Hệ quả: Nhóm 1 nặng maxCapacityGroup1. Vậy Nhóm 2 nặng (sum -
        // maxCapacityGroup1).
        // Phép đập đá triệt tiêu 2 nhóm cuối cùng sinh ra cục Mẩu Lệch Chênh Lệch Này.
        return sum - maxCapacityGroup1 * 2;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] stones1 = { 2, 7, 4, 1, 8, 1 };
        System.out.println("Test 1: " + sol.lastStoneWeightII(stones1)); // Expected: 1

        int[] stones2 = { 31, 26, 33, 21, 40 };
        System.out.println("Test 2: " + sol.lastStoneWeightII(stones2)); // Expected: 5
    }
}
