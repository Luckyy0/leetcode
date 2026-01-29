# 694. Number of Distinct Islands / Số lượng Đảo Phân biệt

## Problem Description / Mô tả bài toán
You are given an `m x n` binary matrix `grid`. An island is a group of `1`s (representing land) connected **4-directionally** (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
Bạn được cho một ma trận nhị phân `grid` kích thước `m x n`. Một hòn đảo là một nhóm các số `1` (đại diện cho đất) được kết nối theo **4 hướng** (ngang hoặc dọc). Bạn có thể giả định rằng tất cả bốn cạnh của lưới đều được bao quanh bởi nước.

Two islands are considered to be the same if and only if one island can be translated (and not rotated or reflected) to equal the other.
Hai hòn đảo được coi là giống nhau khi và chỉ khi một hòn đảo có thể được tịnh tiến (không xoay hoặc phản chiếu) để bằng hòn đảo kia.

Return the number of **distinct** islands.
Trả về số lượng hòn đảo **phân biệt**.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS & Shape Serialization / DFS & Tuần tự hóa Hình dạng
To distinguish between islands, we need a way to encode their shapes.
Để phân biệt giữa các hòn đảo, chúng ta cần một cách để mã hóa hình dạng của chúng.

During DFS traversal:
1. Record every move relative to the starting point of the island.
2. OR, record the directions taken (`u`, `d`, `l`, `r`).
The sequence of moves/directions forms a unique "path" or "shape" string.
Chuỗi chuyển động/hướng tạo thành một chuỗi "đường đi" hoặc "hình dạng" duy nhất.

We store these shape strings in a `Set` to count distinct ones.

### Complexity / Độ phức tạp
- **Time**: O(M * N) as we visit each cell at most once.
- **Space**: O(M * N) for the set and DFS recursion.

---

## Analysis / Phân tích

### Approach: Path Encoding DFS
Starting from an unvisited `1`, perform DFS and record the steps taken (including backtracking steps) relative to the start cell. Using relative directions ensures that islands with the same shape but different locations yield the same string.
Bắt đầu từ một số `1` chưa được truy cập, thực hiện DFS và ghi lại các bước đã thực hiện (bao gồm cả các bước quay lui) so với ô bắt đầu. Sử dụng các hướng tương đối đảm bảo rằng các hòn đảo có cùng hình dạng nhưng ở các vị trí khác nhau sẽ tạo ra cùng một chuỗi.

---
