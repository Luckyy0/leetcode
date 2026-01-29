# 799. Champagne Tower / Tháp Sâm panh

## Problem Description / Mô tả bài toán
We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on.
Chúng ta xếp các ly thành một hình kim tự tháp, trong đó hàng thứ nhất có 1 ly, hàng thứ hai có 2 ly, v.v.

When a glass is full, any excess liquid flows equally to the two glasses immediately below it.
Khi một ly đầy, bất kỳ chất lỏng dư thừa nào sẽ chảy đều vào hai ly ngay bên dưới nó.

After pouring `poured` cups of champagne, return how full the `jth` glass of the `ith` row is.
Sau khi đổ `poured` chén sâm panh, hãy trả về mức độ đầy của ly thứ `j` ở hàng thứ `i`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation with Overflow / Mô phỏng với phần Dư
We can simulate the flow row by row.
Chúng ta có thể mô phỏng dòng chảy theo từng hàng.

Algorithm:
1. Create a 2D array `dp[101][101]`.
2. `dp[0][0] = poured`.
3. For each row `r` from 0 to `query_row`:
   - For each glass `c` in the row:
     - `excess = (dp[r][c] - 1.0) / 2.0`.
     - If `excess > 0`:
       - `dp[r+1][c] += excess`.
       - `dp[r+1][c+1] += excess`.
4. Result is `min(1.0, dp[query_row][query_glass])`.

### Complexity / Độ phức tạp
- **Time**: O(R^2) where R is the number of rows.
- **Space**: O(R).

---

## Analysis / Phân tích

### Approach: Pressure Distribution
Each glass acts as a reservoir. Once the reservoir capacity (1.0) is exceeded, the pressure is split and communicated down to the direct children.
Mỗi ly đóng vai trò như một kho dự trữ. Sau khi vượt quá dung tích (1.0), áp lực sẽ được chia đôi và truyền xuống các ly con trực tiếp.

---
