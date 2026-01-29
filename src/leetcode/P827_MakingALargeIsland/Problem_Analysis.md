# 827. Making A Large Island / Tạo Đảo Lớn

## Problem Description / Mô tả bài toán
You are given an `n x n` binary grid `grid`. You are allowed to change at most one `0` to be `1`.
Bạn được cấp một lưới nhị phân `n x n` `grid`. Bạn được phép thay đổi tối đa một số `0` thành số `1`.

Return the size of the largest island in `grid` after applying this operation.
Hãy trả về kích thước của hòn đảo lớn nhất trong `grid` sau khi thực hiện thao tác này.

An island is a 4-directionally connected group of `1`s.
Một hòn đảo là một nhóm các số `1` được kết nối theo 4 hướng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Connected Components and Mapping / Các thành phần liên thông và Ánh xạ
Changing a `0` to `1` can connect several existing islands.
Việc thay đổi một số `0` thành số `1` có thể kết nối nhiều hòn đảo hiện có.

Algorithm:
1. Identify all islands and their sizes. Use DFS or BFS.
2. Label each island with a unique ID (e.g., 2, 3, 4...).
3. Store `ID -> Size` in a `Map`.
4. Iterate through all `0` cells:
   - Identify all unique island IDs among its 4 neighbors.
   - The potential new island size = `1 + sum(sizes of unique neighbor islands)`.
5. Keep track of the maximum size seen.

Edge case: The grid might already be all `1`s.
Trường hợp đặc biệt: Lưới có thể đã toàn số `1`.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: Pre-calculation and Bridging
First, we analyze all existing terrain to quantify the island clusters. Then, we simulate "building a bridge" at every possible water location to see which one creates the largest combined continent.
Đầu tiên, chúng ta phân tích toàn bộ địa hình hiện có để định lượng các cụm đảo. Sau đó, chúng ta mô phỏng việc "xây cầu" tại mọi vị trí nước có thể để xem vị trí nào tạo ra lục địa kết hợp lớn nhất.

---
