# 1183. Maximum Number of Ones / Số lượng Số 1 Tối đa

## Problem Description / Mô tả bài toán
Consider a matrix `M` with dimensions `width * height`, such that every `sideLength * sideLength` square sub-matrix of `M` contains at most `maxOnes` ones.
Return the maximum possible number of ones that the matrix `M` can have.
Xem xét một ma trận `M` có kích thước `width * height`, sao cho mỗi ma trận con vuông `sideLength * sideLength` của `M` chứa tối đa `maxOnes` số 1.
Trả về số lượng số 1 tối đa có thể có mà ma trận `M` có thể có.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Pattern Repetition / Greedy with Priority Queue / Lặp lại Mẫu / Tham lam với Hàng đợi Ưu tiên
The constraint applies to *every* square. This forces a periodic pattern.
Specifically, `M[i][j]` is effectively tied to `M[i % side][j % side]`.
If we maximize ones, we should pick positions `(r, c)` (where `0 <= r, c < sideLength`) that appear most frequently in the full `width * height` grid.
Count how many times each position `(r, c)` in a `side * side` block is repeated in the full grid.
Sort these positions by frequency.
Pick `maxOnes` positions with the highest frequencies.
Fill them with 1s.
Total ones = sum of frequencies of chosen positions.

### Complexity / Độ phức tạp
- **Time**: O(S^2 log S) where S is sideLength.
- **Space**: O(S^2).

---

## Analysis / Phân tích

### Approach: Modular Frequency Ranking
The constraint forces periodicity. Placing a 1 at `(i, j)` in the top-left `sideLength x sideLength` block effectively allows placing 1s at all `(i + k*side, j + m*side)` throughout the grid. Calculate how many times each cell `(r, c)` (modulo `sideLength`) appears in the entire grid. Sort these counts in descending order and greedily select the top `maxOnes` counts to maximize the total ones.
Ràng buộc buộc phải có tính chu kỳ. Việc đặt 1 tại `(i, j)` trong khối `sideLength x sideLength` trên cùng bên trái sẽ cho phép đặt các số 1 tại tất cả `(i + k*side, j + m*side)` trong toàn bộ lưới. Tính xem mỗi ô `(r, c)` (modulo `sideLength`) xuất hiện bao nhiêu lần trong toàn bộ lưới. Sắp xếp các số đếm này theo thứ tự giảm dần và chọn một cách tham lam `maxOnes` số đếm hàng đầu để tối đa hóa tổng số 1.

---
