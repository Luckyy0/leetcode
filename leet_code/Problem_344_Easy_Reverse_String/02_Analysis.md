# Analysis for Reverse String
# *Phân tích cho bài toán Đảo ngược Chuỗi*

## 1. Problem Essence & Two Pointers
## *1. Bản chất vấn đề & Hai Con trỏ*

### The Challenge
### *Thách thức*
Reverse array in place.

### Strategy: Two Pointers
### *Chiến lược: Hai Con trỏ*
`left` at 0, `right` at `n-1`.
Swap `s[left]` and `s[right]`.
`left++`, `right--`.
Repeat while `left < right`.

---

## 2. Approach: Two Pointers
## *2. Hướng tiếp cận: Hai Con trỏ*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Space:** In-place modification.
    *Không gian O(1): Sửa đổi tại chỗ.*

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

**Input:** ["h", "e", "l", "l", "o"]
L=0, R=4. Swap h, o. ["o", "e", "l", "l", "h"]
L=1, R=3. Swap e, l. ["o", "l", "l", "e", "h"]
L=2, R=2. Stop.
Result: o,l,l,e,h.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard Two Pointers.
*Hai Con trỏ tiêu chuẩn.*
---
*Đôi khi để nhìn lại quá khứ (reverse), ta phải hoán đổi vị trí của điểm đầu và điểm cuối, gặp nhau ở giữa để tìm sự cân bằng.*
Sometimes to look back at the past (reverse), we have to swap the positions of the beginning and the end, meeting in the middle to find balance.
