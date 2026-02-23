# Analysis for Minimum Add to Make Parentheses Valid
# *Phân tích cho bài toán Bổ sung Tối thiểu để Làm Hợp lệ Dấu ngoặc*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Insert parentheses to make the string valid. Minimize insertions.
*Chèn thêm dấu ngoặc để chuỗi hợp lệ. Tối thiểu hóa số lần chèn.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- A string is valid if every `')'` has a preceding `'('` and every `'('` has a subsequent `')'`.
- We can scan the string and cancel out valid `()` pairs.
- Whatever remains in the string cannot form pairs, so we must add corresponding parentheses for them.
- If we have `balance` counter:
  - Increment for `'('`.
  - Decrement for `')'`.
- If `balance` becomes negative (i.e., we have a `)` with no previous `(`), we MUST add a `(` before it.
- After processing the whole string, if `balance` is positive (i.e., we have remaining `(` that were not closed), we MUST add `)` after them.
- Total moves = (insertions for unmatched `)`) + (insertions for unmatched `(`).
*Duyệt chuỗi. `(` tăng balance. `)` giảm balance. Nếu balance < 0 (dư ngoặc đóng), ta cần thêm ngoặc mở ngay lập tức (hoặc đếm số lượng cần thêm). Cuối cùng, nếu balance > 0 (dư ngoặc mở), ta cần thêm số lượng ngoặc đóng tương ứng.*

---

## 2. Strategy: Greedy Balance
## *2. Chiến lược: Cân bằng Tham lam*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `openNeeded = 0` (for unmatched `)`), `closeNeeded = 0` (currently open, waiting for `)`).
    *   **Khởi tạo:** `openNeeded` (cho `)` dư thừa), `closeNeeded` (cho `(` đang mở).*

2.  **Iterate:** For each char `c`:
    - If `'('`: `closeNeeded++`.
    - If `')'`:
        - If `closeNeeded > 0`: `closeNeeded--` (Match found).
        - Else: `openNeeded++` (We had a `)` but no `(` to match, so we need to add `(`).
    *   **Duyệt:** Nếu `(`, tăng `closeNeeded`. Nếu `)`, kiểm tra `closeNeeded`. Nếu có thể match, giảm `closeNeeded`. Nếu không, tăng `openNeeded`.*

3.  **Result:** `openNeeded + closeNeeded`.
    *   **Kết quả:** `openNeeded + closeNeeded`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int minAddToMakeValid(String s) {
    int openCount = 0; // Tracks unmatched '('
    int neededOpen = 0; // Tracks needed '(' for unmatched ')'
    
    for (char c : s.toCharArray()) {
        if (c == '(') {
            openCount++;
        } else {
            // It is ')'
            if (openCount > 0) {
                openCount--;
            } else {
                neededOpen++;
            }
        }
    }
    
    // Result is needed '(' plus remaining unmatched '(' (which need ')')
    return neededOpen + openCount;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple greedy approach using counters tracks exactly what is missing.
*Phương pháp tham lam đơn giản sử dụng các biến đếm theo dõi chính xác những gì còn thiếu.*
