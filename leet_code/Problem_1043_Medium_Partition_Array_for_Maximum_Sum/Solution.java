package Problem_1043_Medium_Partition_Array_for_Maximum_Sum;

/**
 * 1043. Partition Array for Maximum Sum
 * 
 * Given an integer array arr, partition the array into (contiguous) subarrays
 * of length at most k.
 * After partitioning, each subarray has their values changed to become the
 * maximum value of that subarray.
 * Return the largest sum of the given array after partitioning.
 */
public class Solution {

    /**
     * Dùng Quy hoạch động (Dynamic Programming) 1 chiều.
     * 
     * @param arr Mảng chứa các số nguyên ban đầu
     * @param k   Độ dài tối đa cho phép của một mảng con
     * @return Tổng lớn nhất đạt được từ toàn bộ mảng sau khi phân tách
     */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        // Mảng DP nơi dp[i] là TỔNG MAX Cực Đại Thu Lượm Được tính từ đầu chuỗi cho đến
        // hết phần tử thứ i (độ dài i).
        int[] dp = new int[n + 1];

        // Duyệt lần lượt từng Mũi Chóp cắt (từ độ dài 1 cho tới n, đại diện cho đích
        // đến của mảng)
        for (int i = 1; i <= n; i++) {

            // Biến kẹp Giữ Số Giá trị Lớn nhất TRONG nội bộ cái Mảng Mẩu Vuông Cắt Cuối
            // Cùng
            int currentMaxInSubarray = 0;

            // Tung Lưới lôi giật lùi về Lịch Sử. Tưởng tượng ta rạch Nhát Dao Cuối cắt ra
            // một khúc Mẩu Sub-array.
            // Khúc rạch này có kích thước là j.
            // Đoạn j này kéo lùi ra sau tối đa chịu hạn bởi k, VÀ không được rớt khỏi gốc
            // (j <= i)
            for (int j = 1; j <= Math.min(k, i); j++) {

                // Múc Điểm Chốt Từng Em Mất Xác Vuốt Nhích Lùi Về Mép Trái
                // Cập Nhật Đại Ca Voi Max Sổ Hữu Quyền Lực Nhất Rừng Sub-Array này
                // (Index i-j chính xác là điểm cắt chốt trên mảng gốc)
                currentMaxInSubarray = Math.max(currentMaxInSubarray, arr[i - j]);

                // Thu gom Thuế DP: TỔNG VÀNG bằng Số Tỉ Giá Đời Lịch Sử dp[i-j] (vốn gạch xén
                // tới đó) CỘNG với Giá Mẩu Cắt Cuối!
                // Mẩu Băm Cuối Cắt Này (size j) bị CƯỠNG ÉP Đẩy Thổi Phình Hết thành Khổng Lồ
                // Đại Ca (currentMaxInSubarray * j)
                dp[i] = Math.max(dp[i], dp[i - j] + currentMaxInSubarray * j);
            }
        }

        // Lưới thả nạp căng Lái Thống Kê Đi Tới Chuôi Xích Trục N cuối Dải (Hoàn thành
        // Nhiệm Vụ!)
        return dp[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 1, 15, 7, 9, 2, 5, 10 };
        int k1 = 3;
        System.out.println("Test 1: " + sol.maxSumAfterPartitioning(arr1, k1));
        // Expected: 84 (15*3 + 9*1 + 10*3)

        int[] arr2 = { 1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3 };
        int k2 = 4;
        System.out.println("Test 2: " + sol.maxSumAfterPartitioning(arr2, k2));
        // Expected: 83

        int[] arr3 = { 1 };
        int k3 = 1;
        System.out.println("Test 3: " + sol.maxSumAfterPartitioning(arr3, k3));
        // Expected: 1
    }
}
