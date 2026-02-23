# Analysis for Flip Game
# *Phân tích cho bài toán Trò chơi Lật*

## 1. Problem Essence & String Manipulation
## *1. Bản chất vấn đề & Thao tác chuỗi*

### The Move
### *Nước đi*
Find `++`. Replace with `--`. Return all possibilities.

### Strategy: Linear Scan
### *Chiến lược: Quét tuyến tính*
Iterate `i` from `0` to `n-2`.
If `s[i] == '+'` and `s[i+1] == '+'`:
- Construct new string: `s[0...i] + "--" + s[i+2...end]`.
- Add to list.

---

## 2. Approach: Iteration and Substring
## *2. Hướng tiếp cận: Lặp và Chuỗi con*

### Logic
### *Logic*
1.  List `result`.
2.  For `i` from 0 to `len - 2`:
    - if startsWith `++` at `i`:
        - `result.add(substring(0, i) + "--" + substring(i+2))`.
3.  Return `result`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Simple:** Just simulation.
    *Đơn giản: Chỉ là mô phỏng.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot N)$ in Java (String creation takes $O(N)$, loop takes $O(N)$). $N \le 500$, so $2.5 \times 10^5$ ops. Fast.
    *Độ phức tạp thời gian: $O(N^2)$.*
*   **Space Complexity:** $O(N \cdot N)$ to store results.
    *Độ phức tạp không gian: $O(N^2)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `++++`
1.  `i=0`. `++` at 0. Make `--++`.
2.  `i=1`. `++` at 1. Make `+--+`.
3.  `i=2`. `++` at 2. Make `++--`.
Result: `["--++", "+--+", "++--"]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Basic string manipulation.
*Thao tác chuỗi cơ bản.*
---
*Đôi khi một thay đổi nhỏ (flip) có thể mở ra nhiều viễn cảnh khác nhau (states). Hãy xem xét mọi khả năng.*
Sometimes a small change (flip) can open up many different perspectives (states). Consider all possibilities.
