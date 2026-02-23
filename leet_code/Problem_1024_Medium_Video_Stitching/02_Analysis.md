# Analysis for Video Stitching
# *Phân tích cho bài toán Khâu Cuộn Cắt Phim (Video Stitching)*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Select the absolute minimum number of video clip overlapping intervals to construct a continuous unbroken timeline specifically spanning exactly from $0$ exactly to `time`. If any gap exists across the target interval, it's a structural failure (`-1`). Note that you can only "select" whole clips, then trim them. Trimming functionally just means you can effortlessly discard overlapping redundant segments, but you originally MUST select the broad covering clip.
*Ra lệnh chắp vá và khâu MỤC TIÊU SỐ LƯỢNG ÍT NHẤT băng dải chuỗi thời gian đứt đoạn phủ một lớp da dày dặn mượt mà trơn tru xuyên không từ mốc $0$ đúng tới ranh giới `time`. Hễ lộ ra dù chỉ một kẽ nứt thời gian, nhiệm vụ bốc cháy (`-1`). Bạn chỉ có quyền bóc VĨ ĐẠI BĂNG GỐC, phần "cắt xẻ gọt tỉa" chẳng qua là cách luồn nách bỏ đi rác đè nhau đâm lố ngấn, MẶC ĐỊNH BẠN PHẢI CHỌN ĐỦ CLIP ÔM NGUYÊN KHỐI.*

---

## 2. Strategy 1: Naive (Dynamic Programming / Top-Down)
## *2. Chiến lược 1: Ngây thơ (Quy hoạc Động)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive strategy views this as a standard knapsack or interval selection problem using Dynamic Programming. We can define `dp[i]` as the minimum number of clips physically required to cover the exact specific interval `[0, i]`.
Initialization: `dp[0] = 0`, everything else is conceptual infinity $\infty$.
We iterate `i` from point $1$ up to `time`. For every time tick `i`, we scan through absolutely all given clips. If a clip explicitly spans across `i` (meaning `clip[0] <= i <= clip[1]`), we transition: `dp[i] = min(dp[i], dp[clip[0]] + 1)`.
*Tư duy ngây thơ coi đây là bài toán Quy Hoạch Động tốn nơ-ron hệt xếp Balo cổ điển. Ta gọi `dp[i]` là SỐ CHIẾC CLIP MỎNG NHẤT vất vả nạo vét để gánh mảng lót thời gian chính xác `[0, i]`.*
*Khởi nguồn: `dp[0] = 0` (chưa đẻ giờ nào), còn lại phết sơn Vô Cực $\infty$ toàn bộ.*
*Thả chạy máy thời gian `i` từ mốc $1$ bò rúc lên chạm vạch `time`. Tại mỗi cái mốc lẻ `i` đó, ta vác mắt đi rà soát lại TOÀN BỘ KHO CLIP! Ái chà, đứa clip nào dũng mãnh ùa phủ nằm vắt ngang mốc `i` (clip có lõi `start <= i <= end`), cắn răng cập nhật phép màu: `dp[i] = min(dp[i], dp[clip.start_bé] + 1)`.*

```java
import java.util.Arrays;

public class Solution {
    public int videoStitchingNaive(int[][] clips, int time) {
        int[] dp = new int[time + 1];
        Arrays.fill(dp, 1000); // Max possible is 100, 1000 is safe infinity
        dp[0] = 0;
        
        for (int i = 1; i <= time; i++) {
            for (int[] clip : clips) {
                if (clip[0] <= i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        
        return dp[time] == 1000 ? -1 : dp[time];
    }
}
```

- **Weakness (Điểm yếu):** While $O(N \times \text{time})$ operates decently for the $N=100$ constraint, DP inherently executes significantly redundant scans continuously revisiting massive amounts of identical clips per each time ticket tick blindly. Additionally, you instantiate a full DP memory array structurally scaling to the time parameter unnecessarily. It lacks elegance.
  *Với con rồng constraint $N=100$, chạy $O(N \times \text{time})$ thì hàm DP này vẫn sống phây phây. Khổ nỗi, DP cày nát bản thân bằng các vòng lặp đụn cát thừa thãi dội quét ngó nhìn mù quáng lại y chang từng ấy cuộn Kho Clip N lần Cùng Lúc Mọi Tick! Tiếp nữa, nó trói mình đẻ ra nguyên Mảng Ký ức ảo cồng kềnh tuỳ thuộc vào chiều dài thời gian chả để làm gì. Quá máy móc.*

---

## 3. Strategy 2: Optimal (Greedy Interval Jumps)
## *3. Chiến lược 2: Tối ưu (Tham Lam phóng Cóc Khoảng)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Imagine standing at the very beginning of the timeline (`start = 0`). To use the absolute MINIMUM number of clips, we must passionately and relentlessly jump as FAR to the RIGHT as mathematically possible in a single bound! 
This triggers the **Greedy Jump** algorithm (similar to Jump Game II).
Step 1: Create an array `maxJump` of size `time + 1`. For every explicitly given `clip`, find its `start` point. If `start` is relevant (falls within `[0, time]`), update the maximum reach capable from this starting location: `maxJump[start] = max(maxJump[start], end)`.
Step 2: We simulate the greedy traversal. 
- Keep track of the `currentEnd` (how far our actual confirmed clips currently comfortably reach) and the `farthestPossible` reach we discovered scanning from our base.
- Iterate point `i` through the timeline. At each step, eagerly absorb the `maxJump[i]` into our radar `farthestPossible = max(farthestPossible, maxJump[i])`.
- If `i == farthestPossible`: Disaster strikes! We successfully reached the mathematical end of our radar, but we haven't reached the final target yet! This indicates a lethal gap, return `-1`.
- If `i == currentEnd`: It strongly implies we absolutely MUST consume 1 additional jump clip to cross the gap and extend our solid grasp! We increment the `clipsCount` and officially adopt our scouted radar's edge `currentEnd = farthestPossible`.
*Hãy mường tượng đứng chân ở bờ vực Cây Số 0 (`start = 0`). Mệnh lệnh: Dùng "QUÁ ÍT BĂNG KEO", Đứng trước rổ Băng keo, Cầm cuộn Băng VƯƠN THẬT THON THẬT XA VÙ DÀI SANG PHẢI NHẤT CÓ THỂ ĐỂ LĂN TRỌN BẰNG 1 CÚ NHẢY!*
*Kích nạp thuật toán **Tham Lam Cóc Nhảy** (Săn mồi kiểu Jump Game II)!*
*Màn 1: Xin 1 mảng nhỏ bé `maxJump` vạch ngang chóp độ dài Bảng thời gian. Phun rắc mớ Clip Hỗn độn vào. Ở mỗi cái Đầu Nút (Start), nhặt thằng Đuôi (End) NÀO DÀI CỤ TỔ NHẤT gán độc cho Đầu Nút đó! Lọc phế phẩm ngắn lè tè! Tóm gọn: `maxJump[start] = DÀI_NHẤT`.*
*Màn 2: Hành trình Băng Trèo.*
*- Nuôi 2 biến: `currentEnd` (Ranh giới bọc lót Tận cùng chính thức do mình đang sở hữu), `farthest` (Sức ném Tầm Nhìn Chờ của cái dải xịn nhất mình nhặt hờ trên đường).*
*- Nhích nhẹ `i` đi lên. Trên đường mót nhặt tầm nhìn rực rỡ `farthest = max(farthest, maxJump[i])`.*
*- Trớ trêu nếu `i == farthest` bế tắc: Tức là mình lết mỏi cẳng tới tận bờ rìa Tầm Nhìn, mà éo lết qua nổi bên kia Dốc `Time`! Vực sâu Tử thần! Khóc thét quẳng `-1`.*
*- Khắc nghiệt nếu `i == currentEnd`: Chân mình lê đúng rìa cạn Cây Phim cũ rồi! Bắt Buộc PHẢI TIÊU HAO 1 CUP Phim MỚI để Lót Đường Cấp Cứu rướn cổ lên. Rút cuộn phim Đỉnh Nhất mình thó trên chặng vừa qua vắt vô: `currentEnd = farthest`, cộng thêm phí 1 Cuộn Phim `count`.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public int videoStitching(int[][] clips, int time) {
        // Mảng Lọc Tinh Hoa: Từ cột mốc (i), tôi có thể phi sải cánh xa nhất là đuôi nào?
        int[] maxJumpInfo = new int[time + 1];
        
        for (int[] clip : clips) {
            int start = clip[0];
            int end = clip[1];
            // Nếu cục Băng Keo bắt đầu lọt chọt bên trong Time thì ta mới thèm dòm ngó
            if (start <= time) {
                maxJumpInfo[start] = Math.max(maxJumpInfo[start], end);
            }
        }
        
        int jumpCount = 0;    // Tổng Vốn Đầu tư: Số cuộn phim xuất kho
        int currentEnd = 0;   // Bờ Đê Ranh giới chính thức đã đúc cứng xong xui
        int farthest = 0;     // Tầm mắt Hứa Hẹn trinh sát dò được của Cuộn Phim xịn nhất
        
        // Nhích chận chậm dò đá sang sông, không cần duyệt qua mốc Time cuối vì Time là Đích!
        for (int i = 0; i < time; i++) {
            // Nuốt chửng Tầm Mắt Xa vào Lòng Radar
            farthest = Math.max(farthest, maxJumpInfo[i]);
            
            // Leo qua Đỉnh Tầm Nhìn mà méo đi đâu lọt nữa? Thất thủ rụng lầu, Vực Mù Kẽ Nứt
            if (i == farthest) {
                return -1;
            }
            
            // Lết chân Đạp Biên Giới Ranh Giới đúc? Hú còi Nhả đạn! 
            // Vác Cục Trinh Sát Farthest rải thảm ra nới biên giới chóp! 
            if (i == currentEnd) {
                jumpCount++;           // Hao tốn 1 Lược Phim
                currentEnd = farthest; // Nới Tường Thành ra Cỡ Đại (Sài con Cóc Tướng)
            }
        }
        
        return jumpCount;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + \text{time})$. Single direct structural array iteration precisely over the provided $N$ lengths of total raw clips tightly mapping elements out natively into purely constant limits array elements exactly once! Secondly, single pure mathematical iteration spanning over `time` dimension parameter strictly updating the jumping variables sequentially! Radically faster mathematically executing at peak CPU threshold.
    *   **Độ phức tạp thời gian:** $O(N + T)$. Cú cày cuốc trượt mài ngọc cực phẩm chia 2 luồng rõ rệt 1 đường lặp cày tung 100 Cuộn Băng Mộc, Và 1 luồng cày rọc trục Mảng Toán học Time Nhảy cóc siêu thanh! Nín cắn nạp O(T) cày dập DP nát sịt.*
*   **Space Complexity:** $O(\text{time})$. Creation of a single explicitly preallocated array `maxJump` bounded functionally uniformly to exactly parameter scope length `time`. With scale $T \le 100$, allocating technically 100 tiny integers allocates a non-existent fractional overhead block size logically equated to pure zero in reality $O(1)$.
    *   **Độ phức tạp không gian:** $O(T)$. Mảng Trinh Sát Bàn Đạp Đuôi Cóc cóc nhảy khư khư nặn ra khít khịt theo chiều dọc Thời Gian `time`. Rất rẻ tiền nếu vung thêm có 100 cái số Integers cắm rào, gần như Mảng phụ $O(1)$ chả đáng để xét.*
