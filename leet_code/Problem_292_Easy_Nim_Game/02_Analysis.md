# Analysis for Nim Game
# *Phân tích cho bài toán Trò chơi Nim*

## 1. Problem Essence & Game Theory
## *1. Bản chất vấn đề & Lý thuyết trò chơi*

### The Pattern
### *Mẫu*
Limit: Take 1, 2, or 3 stones.
- 1, 2, 3 stones: You take all. You Win.
- 4 stones: You take 1 -> 3 left (Friend wins). You take 2 -> 2 left (Friend wins). You take 3 -> 1 left (Friend wins). **You Lose**.
- 5 stones: You take 1 -> 4 left (Friend gets 4). Since 4 is a losing position for whoever starts, Friend loses. **You Win**.
- 6 stones: You take 2 -> 4 left. Friend loses. **You Win**.
- 7 stones: You take 3 -> 4 left. Friend loses. **You Win**.
- 8 stones: You leave 7, 6, or 5. All are Winning positions for Friend. **You Lose**.

Pattern: Win, Win, Win, Lose, Win, Win, Win, Lose...
Multiples of 4 are Losing positions.

### Strategy: Math
### *Chiến lược: Toán học*
If `n % 4 != 0`, you checkmate the opponent.
Basically, you want to leave the opponent with a multiple of 4.
If `n` is already a multiple of 4, you cannot avoid leaving a non-multiple-of-4 to the opponent (who will then force you back to multiple of 4).

---

## 2. Approach: Modulo
## *2. Hướng tiếp cận: Modulo*

### Logic
### *Logic*
Return `n % 4 != 0`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1):** Instant calculation.
    *O(1): Tính toán tức thì.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$.
    *Độ phức tạp thời gian: $O(1)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** 4
`4 % 4 == 0`. Return False.

**Input:** 5
`5 % 4 != 0`. Return True.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Classic introductory Game Theory problem.
*Bài toán nhập môn Lý thuyết trò chơi kinh điển.*
---
*Đôi khi chiến thắng được định đoạt ngay từ vạch xuất phát. Nếu bạn nắm được quy luật (luật chơi), bạn có thể dự đoán kết quả mà không cần chơi.*
Sometimes victory is determined right from the starting line. If you grasp the rule (game laws), you can predict the outcome without playing.
