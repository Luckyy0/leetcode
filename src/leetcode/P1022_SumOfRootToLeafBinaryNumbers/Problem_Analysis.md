# 1022. Sum of Root To Leaf Binary Numbers / Tổng các Số Nhị phân từ Gốc đến Lá

## Problem Description / Mô tả bài toán
You are given the `root` of a binary tree where each node has a value `0` or `1`. Each root-to-leaf path represents a binary number starting with the most significant bit.
Bạn được cho `root` của một cây nhị phân trong đó mỗi nút có giá trị `0` hoặc `1`. Mỗi đường dẫn từ gốc đến lá đại diện cho một số nhị phân bắt đầu bằng bit quan trọng nhất.

For example, if the path is `0 -> 1 -> 1 -> 0 -> 1`, then this could represent `01101` in binary, which is `13`.
Return the sum of these numbers.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS / Bitwise Traversal / DFS / Duyệt Bit
Algorithm:
1. `dfs(node, currentVal)`.
2. `currentVal = (currentVal << 1) | node.val`.
3. If leaf, return `currentVal`.
4. If not leaf, return `dfs(left, currentVal) + dfs(right, currentVal)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Path Accumulation
Propagate the current binary value down the tree. At each node, shift the inherited value left and add the node's bit. When a leaf is reached, the fully formed integer contributes to the global sum.
Lan truyền giá trị nhị phân hiện tại xuống cây. Tại mỗi nút, dịch chuyển giá trị kế thừa sang trái và nhận bit của nút đó. Khi chạm đến lá, số nguyên được hình thành đầy đủ sẽ đóng góp vào tổng toàn cục.

---
