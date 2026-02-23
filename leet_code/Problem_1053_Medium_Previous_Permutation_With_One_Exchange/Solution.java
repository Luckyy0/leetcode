package Problem_1053_Medium_Previous_Permutation_With_One_Exchange;

import java.util.Arrays;

/**
 * 1053. Previous Permutation With One Exchange
 * 
 * Given an array of positive integers arr (not necessarily distinct),
 * return the lexicographically largest permutation that is strictly smaller
 * than arr,
 * that can be made with exactly one swap of two elements.
 * If it cannot be done, then return the same array.
 */
public class Solution {

    /**
     * Thuật toán: Quét Chuỗi Hậu Tố Tham Lam (Greedy Lexicographical Suffix Scan)
     * Để tạo ra chữ số NHỎ HƠN nhưng LỚN NHẤT CÓ THỂ BẰNG 1 CÚ TRÁO:
     * 1. Phải tìm vị trí i CÀNG VỀ PHÍA CUỐI CÀNG TỐT sao cho arr[i] > arr[i+1].
     * 2. Phải tìm vị trí j ở đuôi mảng (từ i+1 trở đi) thỏa mãn 2 điều kiện:
     * - Nhỏ hơn arr[i] (Vì ta muốn làm mảng nhỏ đi).
     * - Là số LỚN NHẤT trong số những số nhỏ hơn arr[i] đó (Vì ta muốn giữ giá trị
     * lớn nhất có thể).
     * -> Do lúc này chuỗi đuôi đang có tính chất "Không giảm ngược từ cuối", việc
     * lấy rớt chạm j từ phải sang đáp ứng điều này.
     * 3. Xử lý Trùng Lặp Cực Kỳ Quan Trọng:
     * - Đụng trường hợp số trùng nhau: Ta BẮT BUỘC ưu tiên tráo với số NẰM BÊN TRÁI
     * CÙNG trong dàn anh em sinh đôi đó.
     * 
     * @param arr Mảng chứa các số nguyên ban đầu
     * @return Mảng Hoán Vị liền kề nhỏ hơn được tạo sau 1 lần đổi chỗ
     */
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;

        // Bước 1: Quét dọc từ Hữu Sang Tả, Lùng Sục Điểm Gãy Chóp Đầu Tiên (Pivot i)
        // Tìm i mà tại đó Kẻ đứng trước lớn hơn Kẻ đứng sau (arr[i] > arr[i+1])
        int i = n - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }

        // Vô Vọng Logic: Nếu i trôi tụt về âm (< 0), tức là mảng đang xếp tăng dần quá
        // đẹp.
        // Nó vốn đã là Mảng Thấp Bé Nhất Hệ Mặt Trời Thể Hoán Vị, đành Bất Lực Về
        // Không!
        if (i < 0) {
            return arr;
        }

        // Bước 2: Bủa Lưới Tìm Tay Đổi Chéo j Siêu Ưu Việt Trọng Tâm Mạng
        int j = n - 1;
        // Rớt từ Phải Chót qua, lùi dần tìm cái Số Đầu Tiên BÉ HƠN Tướng arr[i]
        while (arr[j] >= arr[i]) {
            j--;
        }

        // TRỌNG ĐIỂM SINH TỬ SỐ 3 (Quyết Định Tỉ Số Test Case):
        // Lỡ trúng ngay Ổ Anh Em Sinh Đôi Mang Nghề Nghiệp Giá Trị Giống Cả Cái Thằng
        // Phát Hiện Ở [j].
        // Phải Phóng Nước Rút Vượt Qua Kéo Ác - Tìm Bắt Thằng "Sinh Đôi Nằm Xa Nhất Về
        // Phía Trái"!
        // Tráo với thằng bên trái nhất sẽ giúp Hoán Lệnh Cập Cáp To Hơn Cả!
        while (j > i && arr[j] == arr[j - 1]) {
            j--;
        }

        // TUNG CHIÊU HOÁN ĐỔI DUY NHẤT LỊCH SỬ
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return arr;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 3, 2, 1 };
        System.out.println("Test 1: " + Arrays.toString(sol.prevPermOpt1(arr1))); // Expected: [3, 1, 2]

        int[] arr2 = { 1, 1, 5 };
        System.out.println("Test 2: " + Arrays.toString(sol.prevPermOpt1(arr2))); // Expected: [1, 1, 5]

        int[] arr3 = { 1, 9, 4, 6, 7 };
        System.out.println("Test 3: " + Arrays.toString(sol.prevPermOpt1(arr3))); // Expected: [1, 7, 4, 6, 9]

        int[] arr4 = { 3, 1, 1, 3 };
        System.out.println("Test 4: " + Arrays.toString(sol.prevPermOpt1(arr4))); // Expected: [1, 3, 1, 3]
    }
}
