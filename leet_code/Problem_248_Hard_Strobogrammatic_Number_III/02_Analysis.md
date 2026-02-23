# Analysis for Strobogrammatic Number III
# *Phân tích cho bài toán Số Strobogrammatic III*

## 1. Problem Essence & Counting
## *1. Bản chất vấn đề & Đếm*

### The Range
### *Phạm vi*
We need to count numbers strobogrammatic such that:
`compare(low, num) <= 0` AND `compare(num, high) <= 0`.
Lengths are small (up to 15).

### Strategy
### *Chiến lược*
Generate all strobogrammatic numbers with length from `low.length` to `high.length`.
For each generated number:
- If `len > low.len` AND `len < high.len`: Count it.
- If `len == low.len`: Check if `>= low`.
- If `len == high.len`: Check if `<= high`.

Since total numbers are small (roughly $5^{15/2} \approx 5^7 \approx 78000$), we can generate all and filter.

---

## 2. Approach: DFS Generation with Check
## *2. Hướng tiếp cận: Sinh DFS kèm Kiểm tra*

### Logic
### *Logic*
1.  Iterate `len` from `low.length` to `high.length`.
2.  Call DFS to generate numbers of length `len`.
3.  Inside DFS base case (when full string built):
    - Check boundaries.
    - If valid, increment counter.
4.  Optimization: Don't construct full list; just count.

### Comparison
### *So sánh*
Since they are strings:
- If length differs, longer is larger.
- If length same, lexicographical comparison.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Constructive:** Only generating valid candidates avoids iterating through all numbers in range $[low, high]$.
    *Mang tính xây dựng: Chỉ sinh ra các ứng viên hợp lệ, tránh duyệt toàn bộ phạm vi.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Proportional to result count. $O(5^{N/2})$.
    *Độ phức tạp thời gian: Tỷ lệ thuận với số lượng kết quả.*
*   **Space Complexity:** Recursion stack.

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** "50" to "100" (Len 2 to 3).

1.  **Len 2:**
    - Generate "11", "69", "88", "96".
    - "11" < "50"? Yes. Invalid.
    - "69" >= "50"? Yes. Valid.
    - "88" >= "50"? Yes. Valid.
    - "96" >= "50"? Yes. Valid.
2.  **Len 3:**
    - Generate "101", "111", "181", "609", "619"...
    - Check "101" <= "100"? No. Invalid.
    - "111" > "100". Invalid.
    - ...
    Wait, "100" is limit. "101" > "100". So no len 3 numbers match.

Total: 3 (69, 88, 96).

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Reuse the generation logic from Problem 247. Add boundary checks.
*Tái sử dụng logic sinh từ Bài 247. Thêm kiểm tra biên.*
---
*Đừng đi quá giới hạn (high), nhưng cũng đừng hạ thấp bản thân (low). Hãy tìm điểm cân bằng xứng đáng.*
Don't exceed the limit (high), but don't lower yourself (low). Find the worthy equilibrium.
