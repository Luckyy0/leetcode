# Analysis for Divisor Game
# *Phân tích cho bài toán Trò Chơi Chia Ước Số*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
A classic Game Theory problem where two players predictably try to force their opponent into a losing state. Alice wins only if she successfully corners Bob into a state where he cannot find any valid divisor for $N$. The game only terminates when a player faces the number `1` (which has no valid divisor $X$ satisfying $0 < X < 1$). Both players play perfectly optimally to win or deny the win.
*Đây là bài toán Thuyết Trò Chơi (Game Theory) kinh điển nơi hai đấu sĩ cố tình ép dồn đối phương vào chóp cụt cái chết. Alice lấy rinh cúp chiến thắng `true` khi và chỉ khi cô ấy ép được Bob rơi vào tình huống không móc đâu ra số X chia hết cho N. Tiếng còi kết thúc game chỉ vang lên khi ai đó giáp mặt số `1` (vì số 1 đếch có ước X nào lọt khe $0 < X < 1$). Bắt buộc nhớ kỹ: cả hai phe đều thiên tài, thủ đoạn đỉnh cao và tuyệt đối chơi cờ Gánh Tối Ưu, không ai đánh ngu.*

---

## 2. Strategy 1: Naive (Dynamic Programming / Top-Down DFS with Memoization)
## *2. Chiến lược 1: Ngây thơ (Quy hoạc Động / Lùi đệ quy DFS có Nhớ đệm)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive strategy simulates mathematically every single plausible branch of the game. For any number $N$, player A is determined to win if A can deliberately choose *at least one* valid divisor $X$ such that the resulting state $(N - X)$ unconditionally constitutes a "Losing state for the next player B".
We use an array `dp[N]` storing the win/lose `boolean` outcome from every node.
*Lối mòn ngây thơ mưu phỏng bằng máy tính xới tung mọi nhánh cây quyết định của bộ não con người. Đứng trước số $N$, Đấu sĩ A hò reo Chiến Thắng nếu như A móc ra được **chí ít một cái Ước $X$ thần thánh** sao cho cục than hồng $(N - X)$ được đẩy sang tay Đấu sĩ B thực chất là một Tàn cuộc "Chắc chắn Chết" đối diện cho kẻ B!*
*Ta nặn ra cây tháp Mảng Ký ức `dp[N]` nhớ từng trận thắng/thua của mỗi con số làm vốn liếng.*

```java
public class Solution {
    public boolean divisorGameNaive(int n) {
        Boolean[] memo = new Boolean[n + 1];
        return canWin(n, memo);
    }
    
    private boolean canWin(int n, Boolean[] memo) {
        if (n <= 1) return false;
        if (memo[n] != null) return memo[n];
        
        // Quét vớt đủ loại ước xem có tia hy vọng sống nào không
        for (int x = 1; x < n; x++) {
            if (n % x == 0) {
                // Đẩy con n - x cho người kia chạy đệ quy. 
                // Nếu người kia "có thể Thua" -> Tức là Mình "thắng"! 
                if (!canWin(n - x, memo)) {
                    memo[n] = true;
                    return true;
                }
            }
        }
        
        memo[n] = false;
        return false;
    }
}
```

- **Weakness (Điểm yếu):** While the DP properly bounds time complexity to theoretically $O(N \sqrt{N})$ or $O(N^2)$ and is well-accepted under $N \le 1000$, it fundamentally overcomplicates strictly rigid mathematical truth. The code writes memory buffers, engages deep nested stacks, and computes modular divisions relentlessly unnecessarily.
  *Với chặn $N \le 1000$, trò chạy đệ quy DP Mảng `O(N^2)` này đủ để sống lây lất nộp thi. Nhưng hỡi ôi, thuật toán đâm lút cán vào sự rườm rà cồng kềnh đáng xấu hổ trước mặt một chân lý toán học vĩ đại. Viết Mảng đệm dài thòng, xoắn não Đệ Quy thóp, tính Toán dội Modulo dồn dập hàng loạt chỉ để chứng minh 1 Định lý chói loá.*

---

## 3. Strategy 2: Optimal (Mathematical Logical Deduction)
## *3. Chiến lược 2: Tối ưu (Suy Luận Logic Toán Học Thiên Tài)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Let's deduce strictly theoretically:
1. **Base Case:** 
   - State `N = 1` -> Next player immediately loses (False).
   - State `N = 2` -> Next player subtracts `x=1`, creating `N=1` for the opponent. -> Next player instantly wins! (True).
2. **The Parity Secret (Bí mật chẵn lẻ):**
   - If the current number $N$ is **ODD (lẻ)**: ALL its divisors $X$ are rigorously **ODD**. (Because $ODD \% EVEN = \text{remainder}$). If an Odd Number $N$ strictly subtracts an Odd Divisor $X$, the resulting Math formula $N - X$ fundamentally evaluates flawlessly into an **EVEN (chẵn)** number!
     -> *Conclusion: Any player holding an Odd number is literally FORCED structurally to hand an Even number to their opponent!*
   - If the current number $N$ is **EVEN (chẵn)**: The player can optionally choose the simplest divisor $X = 1$ (which is Odd). What happens? The opponent is unconditionally forced to accept $N - 1$, which is fundamentally **ODD**!
3. **The Absolute Strategy (Chiến lược Bất bại tuyệt đối):**
   - If Alice starts forcefully with an **EVEN** number $N$, she permanently plays `X = 1`. This forcefully hands Bob an **ODD** number. 
   - Bob, now holding an **ODD** number, is mathematically trapped! Whatever divisor he selects, he is systematically FORCED to subtract an odd slice, thus inevitably and continuously handing Alice back an **EVEN** number!
   - This cycle ($Even \to Alice \to Odd \to Bob \to Even \to Alice$) eternally preserves Alice's absolute control. Following this chain to the bottom, Bob will inevitably be the one cornered receiving `1` (Odd), and he instantly dies.
   - Conversely, if Alice explicitly starts with an **ODD** number, she is trapped feeding Bob Even numbers. Bob applies the same brutal strategy and crushes her.
     
**The Code boils down perfectly cleanly to exactly 1 single line: `return n % 2 == 0;` O(1) time.**
*Hãy lột phăng mặt nạ toán học:*
*1. **Ca Cơ Sở:** Cầm rớt số 1 $\to$ Bơm máu Ngỏm củ tỏi (False). Cầm vô số 2 $\to$ Đẩy 1 cho đối phương -> Đối phương ngỏm, Mình Bất tử (True).*
*2. **Định lý Chẵn Lẻ Xương Sườn:***
   *- Rơi vào **SỐ LẺ (ODD)**: Toàn bộ ước số $X$ của số Lẻ chỉ có thể đẻ ra SỐ LẺ. Thử làm phép trừ học sinh cấp 1: $Số\_Lẻ - Số\_Lẻ = SỐ\_CHẴN$! Lệnh thiết quân luật: Nếu Lượt của bạn dính Số Lẻ, BẠN BỊ ÉP BUỘC TRONG TUYỆT VỌNG PHẢI ĐẨY QUA CHO THẰNG ĐỐI THỦ MỘT **SỐ CHẴN**! Mọi nước cờ đều như thế!*
   *- Rơi vào **SỐ CHẴN (EVEN)**: Bạn sướng điên người vì có quyền chọn móc cạn cái bánh $X = 1$ (Số lẻ). Móc 1 ra, thằng Đấu Kế Tiếp văng miểng BỊ BẮT KINH CHỊU ĐỰNG CHÍNH XÁC $(N - 1)$ vốn là Một **SỐ LẺ** đau khổ!*
*3. **Chiến Đạo Độc Tôn:***
   *- Nếu xuất hành đầu tiên Alice búng ngay vào **SỐ CHẴN**, cô ả thủ đoạn ra tay vắt sạch mỡ chọn $X=1$. Đẩy rớt bịch cho anh chàng Bob con phó thác **SỐ LẺ**.*
   *- Thằng Bob nghèo hèn ngâm **SỐ LẺ**, quẫy đạp kiểu nào cũng Bị Thắt Cổ tuân quy luật trên TRẢ LẠI cho Alice cái **SỐ CHẴN** phì nhiêu.*
   *- Guồng quay vô vọng: ($Chẵn \to Alice \to Lẻ \to Bob \to Chẵn \to Alice$). Alice ôm chặt cái lợi thế SỐ CHẴN. Khi đứt vạch vôi đâm tới tận chót nách, thằng lãnh án Tử Hình ôm con dốc **Số 1** chắc cú 100% sẽ rớt thẳng xuống đùi Bob vì số 1 là Số Lẻ! Alice thắng ngạo nghễ.*
*- Trái chiều tương tự, rụng ngay con **SỐ LẺ** lúc Mở cửa, Alice nếm mùi đập bàn Thua ngược lại Bob tơi bời!*
*(Chỉ cần duy nhất 1 Dòng Lệnh `return N % 2 == 0` thần thánh $O(1)$).*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public boolean divisorGame(int n) {
        // Đỉnh điểm của mưu trí Toán Học
        // Số chẵn là Alice nắm thóp kiểm soát cả bàn cờ, số Lẻ Alice nắm dao cắt tay thề tử
        return n % 2 == 0;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$ constant time execution tight! The computation strictly boils fundamentally down to evaluating precisely a singular basic modulus CPU arithmetic instruction independently evaluating parity efficiently. Completely wipes out nested graph complexities!
    *   **Độ phức tạp thời gian:** $O(1)$ khép góc chớp nhoáng Tích tắc! Một nốt nhạc nhả khói phép mod `\%` tại lòng CPU quét đuôi chẵn/lẻ bằng rễ chân tơ kẽ tóc. Đánh chìm toàn bộ mớ Tháp Đệ quy đồ sộ xuống mồ lãng quên.*
*   **Space Complexity:** $O(1)$ constant strictly explicitly overhead footprint! No allocated arrays intrinsically deployed. Pure registry stack memory space natively processing minimal bytes scaling overhead limits. Absolute perfection. 
    *   **Độ phức tạp không gian:** $O(1)$. Hoàn toàn không đẻ không nặn không bơm tí Ram nào! Quăng vô xó Mép máy trần trụi tính phép `return`. Vẻ hoàn mỹ sừng sững!*
