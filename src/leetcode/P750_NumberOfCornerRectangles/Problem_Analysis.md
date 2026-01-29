# 750. Number Of Corner Rectangles / Số lượng Hình chữ nhật Góc

## Problem Description / Mô tả bài toán
Given an `m x n` integer matrix `grid` where each entry is only `0` or `1`, return the number of **corner rectangles**.
Cho một ma trận số nguyên `m x n` `grid` trong đó mỗi mục nhập chỉ là `0` hoặc `1`, hãy trả về số lượng các **hình chữ nhật góc**.

A corner rectangle is four distinct `1`s on the grid that form the four corners of a rectangle.
Một hình chữ nhật góc là bốn số `1` phân biệt trên lưới tạo thành bốn góc của một hình chữ nhật.

Note that only the corners need to have the value 1.
Lưu ý rằng chỉ các góc mới cần có giá trị 1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Combinatorics / Tổ hợp
A rectangle is defined by two rows `r1, r2` and two columns `c1, c2`.
Một hình chữ nhật được xác định bởi hai hàng `r1, r2` và hai cột `c1, c2`.

If `grid[r1][c1], grid[r1][c2], grid[r2][c1], grid[r2][c2]` are all 1s, it forms a corner rectangle.
Nếu tất cả các góc bằng 1, nó tạo thành một hình chữ nhật góc.

Optimized approach:
Fix any two rows `r1` and `r2`.
Find all columns `j` such that `grid[r1][j] == 1` and `grid[r2][j] == 1`.
Let the number of such columns be `count`.
The number of rectangles formed using these two rows is `count * (count - 1) / 2`.
Số lượng hình chữ nhật được tạo thành bằng cách sử dụng hai hàng này là `count * (count - 1) / 2`.

### Complexity / Độ phức tạp
- **Time**: O(M^2 * N) where M is number of rows and N is number of columns.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Row Pairs Comparison
Iterate through every pair of rows. For each pair, scan the columns once to find common '1's. This reduces a 4D problem into a 3D one.
Lặp lại qua mọi cặp hàng. Đối với mỗi cặp, hãy quét các cột một lần để tìm các số '1' chung. Điều này làm giảm bài toán 4D xuống thành bài toán 3D.

---
