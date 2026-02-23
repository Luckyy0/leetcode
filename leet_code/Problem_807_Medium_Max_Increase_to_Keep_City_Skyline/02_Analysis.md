# Analysis for Max Increase to Keep City Skyline
# *Phân tích cho bài toán Tăng tối đa để giữ nguyên đường chân trời thành phố*

## 1. Problem Essence & Skyline Definition
## *1. Bản chất vấn đề & Định nghĩa Đường chân trời*

### The Challenge
### *Thách thức*
The skyline from the west or east is determined by the maximum height in each row.
The skyline from the north or south is determined by the maximum height in each column.
*Đường chân trời từ hướng đông/tây được xác định bởi chiều cao lớn nhất trong mỗi hàng. Đường chân trời hướng nam/bắc được xác định bởi chiều cao lớn nhất trong mỗi cột.*

To keep the skyline the same, for any building $(r, c)$, its new height $H'_{r,c}$ must satisfy:
1. $H'_{r,c} \le Max(Row_r)$
2. $H'_{r,c} \le Max(Col_c)$
*Để giữ nguyên đường chân trời, chiều cao mới của mỗi tòa nhà phải không vượt quá giá trị lớn nhất trong hàng và không vượt quá giá trị lớn nhất trong cột của nó.*

Hence, $H'_{r,c} = Min(Max(Row_r), Max(Col_c))$.
*Do đó, chiều cao mới tối đa có thể đạt được là giá trị nhỏ nhất giữa hai cực đại này: $Min(Max(Row_r), Max(Col_c))$.*

---

## 2. Strategy: Precompute Maxima
## *2. Chiến lược: Tính trước các giá trị cực đại*

### Algorithm
### *Thuật toán*

1.  **Row Maxima:** Create an array `rowMax` where `rowMax[i]` is the maximum height in row `i`.
2.  **Column Maxima:** Create an array `colMax` where `colMax[j]` is the maximum height in column `j`.
3.  **Calculate Increase:**
    - For each building `grid[i][j]`, its max allowed height is `min(rowMax[i], colMax[j])`.
    - Increase for this building: `min(rowMax[i], colMax[j]) - grid[i][j]`.
    - Sum all increases.
    *   **Tính cực đại:** Tìm `rowMax` và `colMax`. **Tính lượng tăng:** Mỗi tòa nhà có chiều cao mới là `min(rowMax[i], colMax[j])`. Cộng dồn độ chênh lệch so với chiều cao cũ.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$. We traverse the grid twice (once to find maxima, once to calculate increase).
    *   **Độ phức tạp thời gian:** $O(N^2)$.*
*   **Space Complexity:** $O(N)$ to store `rowMax` and `colMax`.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:** `grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]`
1. `rowMax`: [8, 7, 9, 3].
2. `colMax`: [9, 4, 8, 7].
3. For cell (0,0): val=3, $\min(8, 9) = 8$. Increase = $8 - 3 = 5$.
4. For cell (0,1): val=0, $\min(8, 4) = 4$. Increase = $4 - 0 = 4$.
**Total Sum:** ...

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simple O(N^2) summation with precomputed maxima is the optimal approach.
*Sử dụng tổng O(N^2) với các giá trị cực đại tính trước là cách tiếp cận tốt nhất.*
