# Analysis for Detect Capital
# *Phân tích cho bài toán Phát hiện Chữ hoa*

## 1. Problem Essence & Counting
## *1. Bản chất vấn đề & Đếm*

### The Challenge
### *Thách thức*
Validating capital usage rules.
1. Count of capitals = N (All caps).
2. Count of capitals = 0 (All lower).
3. Count of capitals = 1 AND `word[0]` is capital (Title case).

### Strategy: Count Capitals
### *Chiến lược: Đếm Chữ hoa*

1.  **Count:** Iterate characters to count uppercase letters.
2.  **Check:**
    - `caps == len`.
    - `caps == 0`.
    - `caps == 1 && isUpper(word[0])`.

---

## 2. Approach: Simple Iteration
## *2. Hướng tiếp cận: Duyệt Đơn giản*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Simplicity:** No complex regex needed (though Regex `[A-Z]*|[a-z]*|[A-Z][a-z]*` works too).
    *Đơn giản: Không cần regex phức tạp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `FlaG`
1. 'F' -> Upper (1).
2. 'l' -> Lower.
3. 'a' -> Lower.
4. 'G' -> Upper (2).
Total 2. Length 4.
- 2 != 4.
- 2 != 0.
- 2 != 1.
Result: False.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Count uppercase chars and validate against rules.
*Đếm số ký tự hoa và xác thực theo quy tắc.*
---
*Quy tắc (Rules) tạo nên sự trật tự. Dù là hét lớn (ALL CAPS), thì thầm (lowercase) hay chỉ nhấn mạnh sự khởi đầu (Title case), mọi thứ đều cần sự nhất quán (Consistency). Sự trộn lẫn tùy tiện (FlaG) chỉ tạo ra sự hỗn loạn.*
Rules create order. Whether shouting (ALL CAPS), whispering (lowercase) or just emphasizing the beginning (Title Case), everything needs consistency (Consistency). Arbitrary mixing (FLA) only creates chaos.
