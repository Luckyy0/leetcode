# 996. Number of Squareful Arrays / Số lượng Mảng Bình phương

## Problem Description / Mô tả bài toán
An array is **squareful** if the sum of every pair of adjacent elements is a perfect square.
Một mảng được gọi là **bình phương (squareful)** nếu tổng của mọi cặp phần tử liền kề là một số chính phương.

Given an integer array `nums`, return the number of permutations of `nums` that are squareful. Two permutations are different if they differ at any index.
Cho một mảng số nguyên `nums`, hãy trả về số lượng các hoán vị của `nums` sao cho nó là mảng bình phương. Hai hoán vị khác nhau nếu chúng khác nhau ở bất kỳ chỉ số nào.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking with Pruning / Backtracking với Cắt tỉa
Algorithm:
1. Sort `nums` and count frequencies to handle duplicates.
2. Maintain an adjacency list where `adj[u]` contains all `v` such that `u + v` is a perfect square.
3. Use DFS to build the permutations:
   - Start from each unique number.
   - For current number, try all neighbors that still have available counts.
   - Count valid full-length permutations.

### Complexity / Độ phức tạp
- **Time**: O(N!).
- **Space**: O(N^2) for adjacency list.

---

## Analysis / Phân tích

### Approach: Graph-based Permutation search
Transform the problem into finding Hamiltonian paths in a graph where edges connect "square-summing" pairs. By using frequency-guided backtracking, we can efficiently explore unique permutations while skipping redundant branches created by duplicate input values.
Chuyển đổi bài toán thành tìm đường đi Hamiltonian trong một đồ thị nơi các cạnh nối các cặp có "tổng là số chính phương". Bằng cách sử dụng backtracking dựa trên tần suất, chúng ta có thể khám phá hiệu quả các hoán vị duy nhất đồng thời bỏ qua các nhánh dư thừa được tạo ra bởi các giá trị đầu vào trùng lặp.

---
