# 839. Similar String Groups / Nhóm Chuỗi Tương tự

## Problem Description / Mô tả bài toán
Two strings `X` and `Y` are similar if they are equal, or if we can swap two letters in `X` to get `Y`.
Hai chuỗi `X` và `Y` tương tự nhau nếu chúng bằng nhau, hoặc nếu chúng ta có thể hoán đổi hai chữ cái trong `X` để được `Y`.

Given an array of strings `strs`, group similar strings. Return the number of groups.
Cho một mảng các chuỗi `strs`, hãy nhóm các chuỗi tương tự lại với nhau. Trả về số lượng nhóm.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Union-Find (DSU) / Union-Find (DSU)
This is a connected component problem in a graph.
Đây là bài toán tìm thành phần liên thông trong đồ thị.

Algorithm:
1. Two strings are similar if they have 0 or exactly 2 different characters (same characters, different positions).
2. For every pair of strings `(i, j)`:
   - If `i` and `j` are similar, perform `union(i, j)`.
3. The answer is the number of distinct roots.

### Complexity / Độ phức tạp
- **Time**: O(N^2 * L) where N is number of strings and L is length.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Pairwise Similarity Graph
Check every combination of strings to establish connections. Since similarity is an equivalence relation (transitive), use DSU to efficiently merge these individuals into clusters.
Kiểm tra mọi tổ hợp chuỗi để thiết lập các kết nối. Vì tính tương tự là một quan hệ tương đương (có tính bắc cầu), hãy sử dụng DSU để hợp nhất các cá thể này vào các cụm một cách hiệu quả.

---
