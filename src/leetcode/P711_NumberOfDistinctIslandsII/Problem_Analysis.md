# 711. Number of Distinct Islands II / Số lượng Đảo Phân biệt II

## Problem Description / Mô tả bài toán
You are given an `m x n` binary matrix `grid`. An island is a group of `1`s (representing land) connected **4-directionally**.
Bạn được cho một ma trận nhị phân `grid` kích thước `m x n`. Một hòn đảo là một nhóm các số `1` (đại diện cho đất) được kết nối theo **4 hướng**.

Two islands are considered to be the same if one island can be transformed into the other by rotation (90, 180, or 270 degrees) or reflection (horizontal, vertical, or diagonal).
Hai hòn đảo được coi là giống nhau nếu một hòn đảo có thể được chuyển đổi thành hòn đảo kia bằng cách xoay (90, 180 hoặc 270 độ) hoặc phản chiếu (theo chiều ngang, chiều dọc hoặc đường chéo).

Return the number of **distinct** islands.
Trả về số lượng hòn đảo **phân biệt**.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Group Symmetry / Đối xứng Nhóm
To compare islands under rotation and reflection, we must generate all 8 possible representations of each island:
Để so sánh các hòn đảo dưới dạng xoay và phản chiếu, chúng ta phải tạo ra tất cả 8 biểu diễn khả thi của mỗi hòn đảo:
1. `(x, y)`
2. `(x, -y)`
3. `(-x, y)`
4. `(-x, -y)`
5. `(y, x)`
6. `(y, -x)`
7. `(-y, x)`
8. `(-y, -x)`

For each representation:
- Normalize coordinates by subtracting the minimum `x` and `y`.
- Sort the resulting coordinates.
- Pick the "canonical" representation (e.g., lexicographically smallest) to store in a `Set`.

### Complexity / Độ phức tạp
- **Time**: O(M * N * log(M * N)). Sorting the coordinates of each island.
- **Space**: O(M * N).

---

## Analysis / Phân tích

### Approach: Canonical Representation
Extract all coordinates of an island. Generate all 8 symmetries. Normalize each. Use the lexicographically smallest sorted list as the key for distinct counting.
Trích xuất tất cả các tọa độ của một hòn đảo. Tạo ra tất cả 8 đối xứng. Chuẩn hóa từng cái. Sử dụng danh sách đã sắp xếp nhỏ nhất theo thứ tự từ điển làm khóa để đếm phân biệt.

---
