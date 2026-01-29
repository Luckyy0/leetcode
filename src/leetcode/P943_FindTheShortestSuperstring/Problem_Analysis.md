# 943. Find the Shortest Superstring / Tìm Siêu chuỗi Ngắn nhất

## Problem Description / Mô tả bài toán
Given an array of strings `words`, return the smallest string that contains each string in `words` as a substring.
Cho một mảng các chuỗi `words`, hãy trả về chuỗi nhỏ nhất chứa mỗi chuỗi trong `words` như một chuỗi con.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Travelling Salesperson Problem (TSP) on Strings / Bài toán Người giao hàng (TSP) trên Chuỗi
This is equivalent to finding a path in a graph that visits all nodes with minimum total cost.
Bài toán này tương đương với việc tìm một đường đi trong đồ thị đi qua tất cả các nút với tổng chi phí thấp nhất.
- Nodes: Words.
- Edge `(A, B)` weight: The number of characters to add to `A` to form `A + B` (minimizing overlap).

Algorithm:
1. Precompute overlapping characters between all pairs `(i, j)`.
2. Use Dynamic Programming with Bitmask: `dp[mask][i]` is the minimum length using words in `mask` ending at word `i`.
3. Reconstruct the path from the `dp` table.

### Complexity / Độ phức tạp
- **Time**: O(N^2 * 2^N).
- **Space**: O(N * 2^N).

---

## Analysis / Phân tích

### Approach: Overlap-optimized Trail
Treat each word as a location and the overlap as the distance saved. By finding the sequence that maximizes total saved distance (equivalent to minimizing total length), we solve a restricted form of the Hamiltonian path problem via bitmask DP.
Coi mỗi từ như một vị trí và phần chồng lặp như khoảng cách tiết kiệm được. Bằng cách tìm chuỗi giúp tối đa hóa tổng khoảng cách tiết kiệm được (tương đương với việc tối thiểu hóa tổng độ dài), chúng ta giải quyết một dạng hạn chế của bài toán đường đi Hamiltonian thông qua bitmask DP.

---
