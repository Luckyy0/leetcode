# 894. All Possible Full Binary Trees / Tất cả các Cây Nhị phân Đầy đủ có thể

## Problem Description / Mô tả bài toán
A full binary tree is a binary tree where each node has either 0 or 2 children.
Cây nhị phân đầy đủ là cây nhị phân mà mỗi nút có 0 hoặc 2 nút con.

Given an integer `n`, return a list of all possible full binary trees with `n` nodes.
Cho một số nguyên `n`, hãy trả về danh sách tất cả các cây nhị phân đầy đủ có thể có với `n` nút.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursive Construction with Memoization / Xây dựng Đệ quy với Memoization
A full binary tree must have an odd number of nodes.
Cây nhị phân đầy đủ phải có số lượng nút là lẻ.

Algorithm:
1. If `n` is even, return an empty list.
2. Base case: `n == 1`, return a list containing a single node.
3. For a given `n`, try all possible splits for children:
   - Left subtree has `i` nodes.
   - Right subtree has `n - 1 - i` nodes.
   - Both `i` and `n - 1 - i` must be odd.
4. Get all possible trees for `i` and `n - 1 - i` recursively.
5. Combine them into new roots.

### Complexity / Độ phức tạp
- **Time**: Exponential (Catalan number related).
- **Space**: Exponential.

---

## Analysis / Phân tích

### Approach: Recursive Substructure
The problem exhibits overlapping subproblems (e.g., calculating trees for $n=5$ requires trees for $n=1$ and $n=3$, which are used multiple times). Memoization ensures each configuration for a specific size is computed only once.
Bài toán thể hiện các bài toán con chồng chéo (ví dụ: tính toán các cây cho $n=5$ yêu cầu các cây cho $n=1$ và $n=3$, vốn được sử dụng nhiều lần). Memoization đảm bảo rằng mỗi cấu hình cho một kích thước cụ thể chỉ được tính toán một lần.

---
