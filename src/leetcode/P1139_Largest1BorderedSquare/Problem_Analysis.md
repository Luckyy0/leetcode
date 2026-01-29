# 1139. Largest 1-Bordered Square / Hình vuông Viền 1 Lớn nhất

## Problem Description / Mô tả bài toán
Given a 2D grid of 0s and 1s, return the number of elements in the largest square subgrid that has all 1s on its border, or 0 if such a subgrid doesn't exist in the grid.
Cho một lưới 2D gồm các số 0 và 1, hãy trả về số lượng phần tử trong lưới con hình vuông lớn nhất có tất cả các số 1 trên viền của nó, hoặc 0 nếu lưới con như vậy không tồn tại trong lưới.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming (Precomputed Lines) / Quy hoạch Động (Đường tính trước)
We need constant time check if a border is all 1s.
Compute `hor[i][j]` = consecutive 1s ending at `(i, j)` horizontally (left).
Compute `ver[i][j]` = consecutive 1s ending at `(i, j)` vertically (up).

For each cell `(i, j)` as bottom-right corner, check largest possible size `k` such that:
`size = min(hor[i][j], ver[i][j])`.
This is the max potential size. Check if the other corners are valid.
Iterate `s` from `size` down to 1.
Other corners: `(i, j-s+1)` (bottom-left) and `(i-s+1, j)` (top-right).
Check if `ver[i][j-s+1] >= s` (left edge) and `hor[i-s+1][j] >= s` (top edge).
First valid `s` updates max size.
Result is `max_s * max_s`.

### Complexity / Độ phức tạp
- **Time**: O(N^3) (or N^2 * N check).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Border Validation with DP
Precompute the length of continuous horizontal and vertical segments of 1s ending at each cell. This allows checking any potential square border in O(1). Iterate through every cell treating it as the bottom-right corner of a potential square. Check possible square sizes (bounded by the local horizontal and vertical lengths) by verifying if the corresponding top and left edges exist.
Tính toán trước độ dài của các đoạn ngang và dọc liên tục của các số 1 kết thúc tại mỗi ô. Điều này cho phép kiểm tra bất kỳ đường viền vuông tiềm năng nào trong O(1). Lặp qua mỗi ô coi nó là góc dưới bên phải của một hình vuông tiềm năng. Kiểm tra các kích thước hình vuông có thể có (bị giới hạn bởi độ dài ngang và dọc cục bộ) bằng cách xác minh xem các cạnh trên và trái tương ứng có tồn tại hay không.

---
