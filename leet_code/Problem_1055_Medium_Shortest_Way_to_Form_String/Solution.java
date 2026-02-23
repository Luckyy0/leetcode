package Problem_1055_Medium_Shortest_Way_to_Form_String;

/**
 * 1055. Shortest Way to Form String
 * 
 * From any string, we can form a subsequence of that string by deleting some
 * number of characters (possibly no deletions).
 * Given two strings source and target, return the minimum number of
 * subsequences of source such that
 * their concatenation equals target. If the task is impossible, return -1.
 */
public class Solution {

    /**
     * Thuật toán: Con Trỏ Kép Tham Lam (Greedy Two Pointers).
     * Để dùng ÍT CHUỖI CON NHẤT, mỗi lần lấy 1 chuỗi con từ Source ra, ta phải cố
     * gắng
     * ráng ghép cho bằng được nhiều Ký Tự nhất có thể vào Target.
     * 
     * @param source Dải ký tự Mẹ (Cung cấp nguyên liệu)
     * @param target Dải ký tự Đích (Cần được đắp nối thành)
     * @return Số lượng đoạn cắt ghép (Subsequences) ít nhất cần dùng. Trả về -1 nếu
     *         Vô Vọng.
     */
    public int shortestWay(String source, String target) {
        // Bước 1: Trạm Lọc Vé Mất Khả Kháng (Chặn Đứng Vòng Lặp Vô Vọng).
        // Nếu trong 'target' có mọc ra bất kỳ 1 chữ cái lạ hoắc nào mà ở 'source' CẠN
        // KIỆT không có...
        // Phá sản toàn tập, đừng ráp nữa!
        boolean[] sourceChars = new boolean[26];
        for (char c : source.toCharArray()) {
            sourceChars[c - 'a'] = true;
        }

        for (char c : target.toCharArray()) {
            if (!sourceChars[c - 'a']) {
                return -1; // Từ Chối Khéo - Bỏ cuộc vì Vô Phương Cứu Chữa!
            }
        }

        // Bước 2: Tung Cán Cân Tham Lam Rút Tỉa Từng Mảng
        int subsequenceCount = 0; // Đếm Tổng Lượt Dùng Phiếu Rứt Chuỗi Mới
        int t = 0; // Con Trỏ rà soát trên bề mặt Đích 'target'

        int sLength = source.length();
        int tLength = target.length();

        // Vòng Lặp Lớn: Chừng nào Trục 't' chưa bò dọn sạch tới Đáy Điểm Cuối của Đích
        while (t < tLength) {
            int s = 0; // Đầu Quy Chuẩn Khởi điểm Rà Quét Lại Từ Đầu trên Đường Băng 'source'

            // Vuốt Kéo Kì Cuối Gạn Mép 1 Phiên Bản 'source'
            while (s < sLength && t < tLength) {
                // Săm Soi Ốc Vít - Hút Sát Thấy 1 Ký Tự Trùng Khớp Lệnh Nhau Ư?
                if (source.charAt(s) == target.charAt(t)) {
                    t++; // Nhồi Kéo Toa Tàu Đích Ăn Mồi Ngon Liền! Nhích Tới Ký Tự Đích Tiếp Theo!
                }
                // Bất Chấp Có Khớp Hay Không Khớp, Cửa Cưa 's' Của Dải Mẹ Vẫn Trượt Mòn Bỏ Đi
                // Lưới Tiến Theo Khúc
                // Nếu không Khớp? Cắt Bỏ Mẩu Chữ Đừng Lấy (Deletion của Subsequence)
                s++;
            }

            // Xẹt Hết 1 Vòng Dải Mẹ Rụng Băng, Có Ít Hay Nhiều Lỗi Vuột Mất. Ghi Phạt Phải
            // Cắt Chắp 1 Chuỗi Mới Nối Vành!
            subsequenceCount++;
        }

        return subsequenceCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Test 1: " + sol.shortestWay("abc", "abcbc")); // Expected: 2 ("abc" + "bc")
        System.out.println("Test 2: " + sol.shortestWay("abc", "acdbc")); // Expected: -1 (Missing 'd' in source)
        System.out.println("Test 3: " + sol.shortestWay("xyz", "xzyxz")); // Expected: 3 ("xz" + "y" + "xz")
    }
}
