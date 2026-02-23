# Analysis for Zigzag Conversion
# *Phân tích cho bài toán Chuyển Đổi Zigzag*

## 1. Understanding & Constraints
## *1. Hiểu đề & Ràng buộc*

### Input/Output
### *Dữ liệu Vào/Ra*
*   **Input:** String `s` and integer `numRows`. *Chuỗi `s` và số nguyên `numRows`.*
*   **Output:** The string rearranged line by line. *Chuỗi được sắp xếp lại theo từng dòng.*

### Constraints Analysis
### *Phân tích Ràng buộc*
*   `s.length <= 1000`. Direct simulation is feasible. *`s.length <= 1000`. Mô phỏng trực tiếp là khả thi.*
*   `numRows <= 1000`. *`numRows <= 1000`.*
*   If `numRows == 1` or `numRows >= s.length()`, no conversion needed. *Nếu `numRows == 1` hoặc `numRows >= s.length()`, không cần chuyển đổi.*

## 2. Approach & Algorithm
## *2. Giải thuật & Hướng tiếp cận*

### Approach: Simulation by Row
### *Hướng tiếp cận: Mô phỏng theo Hàng*

*   **Intuition:** We can create `numRows` string buffers (or lists). iterate through `s`, and place each character into the correct row.
    *Ý tưởng: Chúng ta có thể tạo `numRows` bộ đệm chuỗi (hoặc danh sách). Duyệt qua `s`, và đặt từng ký tự vào đúng hàng.*
*   **Movement Logic:**
    *   We move down: Row $0 \rightarrow 1 \rightarrow \dots \rightarrow numRows-1$.
    *   Then we move up: Row $numRows-1 \rightarrow numRows-2 \rightarrow \dots \rightarrow 0$.
    *   Repeat.
    *   Logic di chuyển: Xuống rồi Lên.
*   **Algorithm Steps:**
    1.  Edge Cases: If `numRows == 1` return `s`.
    2.  Create `StringBuilder[] rows`.
    3.  Iterate `char c : s.toCharArray()`.
    4.  Append `c` to current row.
    5.  Change direction if we hit top or bottom row.
    6.  Combine all rows.
*   **Complexity:**
    *   Time: $O(N)$ where $N =$ length of `s`. We visit each char once. *Thời gian: $O(N)$ với $N =$ độ dài của `s`. Chúng ta thăm mỗi ký tự một lần.*
    *   Space: $O(N)$ to store the result strings. *Không gian: $O(N)$ để lưu trữ chuỗi kết quả.*

### Dry Run
### *Chạy thử*
`s = "PAYPAL"`, `numRows = 3`
1.  `P` -> Row 0. Dir Down. `currRow` becomes 1.
2.  `A` -> Row 1. Dir Down. `currRow` becomes 2.
3.  `Y` -> Row 2. Hit Bottom! Dir Up. `currRow` becomes 1.
4.  `P` -> Row 1. Dir Up. `currRow` becomes 0.
5.  `A` -> Row 0. Hit Top! Dir Down. `currRow` becomes 1.
6.  `L` -> Row 1.
Result Rows:
0: P A
1: A P L
2: Y
Concat: "PAAPLY"
