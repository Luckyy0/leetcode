# Analysis for Keyboard Row
# *Phân tích cho bài toán Hàng Bàn phím*

## 1. Problem Essence & Set Membership
## *1. Bản chất vấn đề & Thành viên Tập hợp*

### The Challenge
### *Thách thức*
Checking if all characters in a string belong to the same pre-defined set of characters (keyboard rows).

### Strategy: Hash Set / Map
### *Chiến lược: Hash Set / Map*

1.  **Map Characters to Rows:** Create a mapping `char -> rowIndex`.
    - Row 1: `qwertyuiop` -> 1
    - Row 2: `asdfghjkl` -> 2
    - Row 3: `zxcvbnm` -> 3
    - Handle case insensitivity (map both `A` and `a`).
2.  **Validation:**
    - For each word, find the row index of the first character.
    - Check if all subsequent characters have the same row index.
    - If yes, add to result.

---

## 2. Approach: Array Lookup (Optimization)
## *2. Hướng tiếp cận: Tra cứu Mảng (Tối ưu hóa)*

### Logic
### *Logic*
(See above). Use an array `int[26]` (or `int[128]`) for fast lookup since strictly ASCII letters.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Check:** Accessing array/map is constant time.
    *Kiểm tra O(1): Truy cập mảng/map là thời gian hằng số.*
*   **Simple Logic:** Direct iteration.
    *Logic đơn giản: Duyệt trực tiếp.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot L)$, where $N$ is number of words, $L$ is max word length.
    *Độ phức tạp thời gian: $O(N \cdot L)$.*
*   **Space Complexity:** $O(1)$ (fixed size map).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `["Alaska"]`
1. Row Map: `a->2, l->2, s->2, k->2`.
2. First char `A`. Lower `a`. Row 2.
3. `l` -> Row 2. Match.
4. `a` -> Row 2. Match.
5. ... All match. Return Alaska.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Pre-compute row indices and validate each word.
*Tính trước chỉ số hàng và xác thực từng từ.*
---
*Sự đồng bộ (same row) tạo nên tốc độ. Khi mọi thành phần (characters) cùng nằm trên một mặt phẳng (row), việc kết nối chúng trở nên trơn tru và ít tốn sức nhất. Sự phân tán (different rows) tuy mang lại đa dạng nhưng lại làm giảm hiệu suất của sự tập trung.*
Synchronization (Same Row) creates speed. When all components (Characters) are on the same plane (Row), connecting them becomes the smoothest and least effort. Dispersion (Different Rows), although providing diversity, reduces the performance of concentration.
