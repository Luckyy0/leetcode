package Problem_1052_Medium_Grumpy_Bookstore_Owner;

/**
 * 1052. Grumpy Bookstore Owner
 * 
 * There is a bookstore owner that has a store open for n minutes.
 * You are given an integer array customers of length n where customers[i] is
 * the number of customers
 * that enter the store at the start of the ith minute.
 * 
 * You are given a binary array grumpy where grumpy[i] is 1 if the owner is
 * grumpy during the ith minute, and is 0 otherwise.
 * The owner knows a secret technique to safely keep themselves not grumpy for
 * exactly 'minutes' consecutive minutes,
 * but can only use it once.
 * 
 * Return the maximum number of customers that can be satisfied throughout the
 * day.
 */
public class Solution {

    /**
     * Thuật toán: Cửa Số Trượt (Sliding Window) Kích thước cố định.
     * Bài toán được chia làm 2 phần tĩnh và động:
     * 1. Phần Tĩnh: Những khách hàng luôn luôn Hài Lòng (do lão chủ tự nhiên Không
     * Cáu ở các phút grumpy[i] == 0).
     * 2. Phần Điểm Thưởng Động: Lượng khách hàng Đang Bị Cáu Bẳn Nằm Gọn TRONG BÊN
     * TRONG Cửa Sổ Trượt (kích thước = minutes).
     * Ta trượt cửa sổ này từ đầu đến cuối mảng và tìm vị trí mà Lượng Khách Khổ Cực
     * bên trong là Lớn Nhất để Bung Bí Kíp.
     * 
     * @param customers Mảng số lượng khách hàng theo từng phút
     * @param grumpy    Mảng thái độ cáu kỉnh của lão chủ (1: cáu, 0: không cáu)
     * @param minutes   Thời gian (số phút liên tục) lão chủ có thể dùng Bí kíp để
     *                  KHÔNG CÁU
     * @return Số khách hàng Hài Lòng Tối Đa Cả Đời
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int baseSatisfiedCustomers = 0;

        // Bước 1: Tính toán Phần Nền Tĩnh (Điểm Gốc Mặc Định Mãn Nguyện)
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                baseSatisfiedCustomers += customers[i];
            }
        }

        int currentWindowExtra = 0; // Trụ đếm Số Khách Đang Nằm Vùng Chịu Cực (Sẽ được Bí kíp hóa giải) trong Khung
                                    // Cửa
        int maxWindowExtra = 0; // Số Lượng Cứu Vớt Rực Rỡ Kỷ Lục Nhất

        // Bước 2: Dùng Cửa Sổ Trượt Chặn Kích Thước (minutes) Quét Mảng Tìm Cơ Hội Giải
        // Cứu Lớn Nhất
        for (int i = 0; i < n; i++) {
            // Nuốt Khách Bị Tệ Bạc Vừa Trượt Tới Vào Cửa Sổ
            if (grumpy[i] == 1) {
                currentWindowExtra += customers[i];
            }

            // Xả Bỏ Lượng Khách Nằm Ngoài Rìa Trái (Vi Cửa Sổ Đã Đầy Chật Chỗ So Với Size
            // Mặc Định 'minutes')
            if (i >= minutes) {
                int leftDropIndex = i - minutes; // Chốt người đứng ngoài rìa sắp rớt

                // Cẩn thận: Chỉ trừ Khấu Hao nếu Vị khách bị rớt này đã Từng Nằm Vùng Trong
                // Danh Sách (Tức grumpy == 1)
                // Lượng Khách Hiền baseSatisfiedCustomers đã ăn riêng vòng ngoài nên đừng trừ
                // lộn!
                if (grumpy[leftDropIndex] == 1) {
                    currentWindowExtra -= customers[leftDropIndex];
                }
            }

            // Ghi nhận Điểm Giải Cứu Kỷ Lục Lịch Sử
            maxWindowExtra = Math.max(maxWindowExtra, currentWindowExtra);
        }

        // Tổng Số Lặng Kết = Khách Tự Nhiên Dễ Chịu Mặc Định + Khách Bí Tích Được Hóa
        // Giải Kéo Theo Nhờ Bí Kíp
        return baseSatisfiedCustomers + maxWindowExtra;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] customers1 = { 1, 0, 1, 2, 1, 1, 7, 5 };
        int[] grumpy1 = { 0, 1, 0, 1, 0, 1, 0, 1 };
        int minutes1 = 3;
        System.out.println("Test 1: " + sol.maxSatisfied(customers1, grumpy1, minutes1)); // Expected: 16

        int[] customers2 = { 1 };
        int[] grumpy2 = { 0 };
        int minutes2 = 1;
        System.out.println("Test 2: " + sol.maxSatisfied(customers2, grumpy2, minutes2)); // Expected: 1
    }
}
