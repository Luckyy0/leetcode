package leet_code.Problem_1025_Easy_Divisor_Game;

/**
 * Problem 1025: Divisor Game
 * https://leetcode.com/problems/divisor-game/
 */
public class Solution {

    /**
     * Determines if Alice wins the Divisor Game.
     * Strategy: Mathematical Logical Deduction (Parity Check).
     * 
     * @param n The starting number on the chalkboard.
     * @return True if Alice wins, assuming optimal play.
     * 
     *         Tóm tắt chiến lược:
     *         1. "Trò chơi Chia Ước Số" mang vỏ bọc của một bài Cây Đệ Quy Phức tạp
     *         hoặc Quy hoạch Động đệ quy với chằng chịt O(N^2).
     *         2. Chân Lý Tối Cao Bất Biến Của Toán Học:
     *         - Quy tắc cơ bản: Bạn Lãnh "SỐ LẺ", Bạn bị ÉP BUỘC quăng cho kẻ
     *         đối diện một "SỐ CHẴN" (Vì Số lẻ trích xuất ước số luôn là LẺ,
     *         MÀ $LẺ - LẺ = CHẴN$).
     *         - Quy tắc cơ bản: Bạn ôm trong tay "SỐ CHẴN", Bạn có Quyền Lực vùi
     *         dập kẻ thù bằng cách móc lấy số $X = 1$ (Số lẻ), ÉP KẺ THÙ ăn nguyên
     *         cục $(N - 1)$ => Chắc chắn là "SỐ LẺ".
     *         3. TRẬN ĐẤU CÂN NÃO:
     *         - Tới phiên Alice, nếu Nhả ra $N$ là "SỐ CHẴN": Cô ấy Tóm Ngay và dồn
     *         ép Thằng Bob bằng cách tước đi $1$ Nhím. Quăng Bob vào thế Gồng Mình
     *         Cự
     *         cái "SỐ LẺ".
     *         - Theo Quyết tắc 1, Bob ngoắc ngoải dẫy dụa làm gì cũng bị Đẩy Ngược
     *         Lại cho Alice cái "SỐ CHẴN". Cứ lặp hoài như Bánh xe luân hồi!
     *         - Vong Xoáy Độc Chiếm: $Alice (Chẵn) \to Bob (Lẻ) \to Alice
     *         (Chẵn)...$
     *         Càng lúc N càng lùi nhích nhỏ đi. Cuối cùng, Con Xúc Xắc Chết Chóc
     *         "Số 1" LÀ SỐ LẺ kịch kim 100% sẽ rơi tọt vào Tay Của Thằng Bob.
     *         Thằng nhãi đứt dây sống! Alice Thắng!
     *         4. Trái lại, Nếu ngậm Số Lẻ mở màn, Alice trở thành Nạn Nhân Chết Gục
     *         dưới bánh xe đó trong tay Bob.
     *         5. Vở diễn khép lại với 1 Cú Lọc Số Dư Modulo Siêu Tốc $O(1)$!
     */
    public boolean divisorGame(int n) {
        // Bí quyết Thiên tài gỡ màng não: Alice có bắt mạch SỐ CHẴN hay không?
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result 1: " + sol.divisorGame(2)); // expected true
        System.out.println("Result 2: " + sol.divisorGame(3)); // expected false
        System.out.println("Result 3: " + sol.divisorGame(4)); // expected true
        System.out.println("Result 4: " + sol.divisorGame(9)); // expected false
    }
}
