# 931. Minimum Falling Path Sum / Tổng Đường đi Rơi Tối thiểu

## Problem Description / Mô tả bài toán
Given an `n x n` array of integers `matrix`, return the minimum sum of any falling path through the matrix.
Cho một mảng `n x n` các số nguyên `matrix`, hãy trả về tổng nhỏ nhất của bất kỳ đường đi rơi nào qua ma trận.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below, or diagonally left/right.
Một đường rơi bắt đầu ở bất kỳ phần tử nào trong hàng đầu tiên và chọn phần tử trong hàng tiếp theo nằm ngay bên dưới, hoặc chéo sang trái/phải.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
`dp[i][j]` = minimum falling path sum ending at `matrix[i][j]`.
`dp[i][j]` = tổng đường đi rơi tối thiểu kết thúc tại `matrix[i][j]`.

Transition:
`dp[i][j] = matrix[i][j] + min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1])`.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(1) if modifying `matrix` in place, or O(N^2).

---

## Analysis / Phân tích

### Approach: Row-wise Progression
Construct the solution from the top row downwards. For each cell in the subsequent rows, identify its best possible predecessor from the row above to accumulate the cumulative minimum path sum.
Xây dựng giải pháp từ hàng trên cùng xuống dưới. Đối với mỗi ô ở các hàng tiếp theo, hãy xác định ô tiền nhiệm tốt nhất có thể từ hàng phía trên để tích lũy tổng đường đi tối thiểu.

---
