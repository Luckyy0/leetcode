# 1548. The Most Similar Path in a Graph / Đường đi Tương tự nhất trong Đồ thị

## Problem Description / Mô tả bài toán
Graph of `n` nodes. Cities and labels. `targetPath` of labels.
Find a path in the graph of exactly the same length as `targetPath` that minimizes the edit distance.
Edit distance = number of indices `i` such that `path[i]` label != `targetPath[i]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming
`dp[i][u]` = minimum edit distance for a path of length `i` ending at node `u`.
Transition:
`dp[i][u] = (label[u] == targetPath[i] ? 0 : 1) + min(dp[i-1][v])` for all neighbors `v` of `u`.
Base case: `dp[0][u] = (label[u] == targetPath[0] ? 0 : 1)`.
Track parents to reconstruct the path.

### Complexity / Độ phức tạp
- **Time**: O(L * (V + E)), where L is the target length.
- **Space**: O(L * V).

---

## Analysis / Phân tích

### Approach: 2D DP
Compute values and store parent indices.
Reconstruct the path by moving backward from the node in the last layer with the minimum DP value.
Tính toán các giá trị và lưu trữ các chỉ số cha.
Tái cấu trúc đường đi bằng cách đi giật lùi từ nút ở lớp cuối cùng có giá trị DP tối thiểu.

---
