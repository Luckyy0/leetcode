# 129. Sum Root to Leaf Numbers / Tổng Các Số Từ Gốc Đến Lá

## Problem Description / Mô tả bài toán
You are given the `root` of a binary tree containing digits from `0` to `9` only.
Bạn được cho `root` của một cây nhị phân chỉ chứa các chữ số từ `0` đến `9`.

Each root-to-leaf path in the tree represents a number.
Mỗi đường đi từ gốc đến lá trong cây đại diện cho một số.

For example, the root-to-leaf path `1 -> 2 -> 3` represents the number `123`.
Ví dụ, đường đi từ gốc đến lá `1 -> 2 -> 3` đại diện cho số `123`.

Return the total sum of all root-to-leaf numbers.
Trả về tổng của tất cả các số từ gốc đến lá.

### Example 1:
```text
Input: root = [1,2,3]
Output: 25
Explanation:
1->2 represents 12.
1->3 represents 13.
Total sum = 12 + 13 = 25.
```

### Example 2:
```text
Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
4->9->5 represents 495.
4->9->1 represents 491.
4->0 represents 40.
Total sum = 495 + 491 + 40 = 1026.
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[1, 1000]`.
- `0 <= Node.val <= 9`
- The depth of the tree will not exceed `10`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Building Numbers Along Paths / Xây dựng Số Dọc Theo Đường đi
As we traverse from root to leaf:
Khi chúng ta duyệt từ gốc đến lá:

```
currentNumber = currentNumber * 10 + node.val
```

This is essentially building a number digit by digit.
Đây về cơ bản là xây dựng một số từng chữ số một.

### DFS Approach / Phương pháp DFS
Pass the "number so far" down the tree:
Truyền "số cho đến nay" xuống cây:

```
dfs(node, numSoFar):
    if node == null: return 0
    
    numSoFar = numSoFar * 10 + node.val
    
    // If leaf, return the complete number
    if node.left == null and node.right == null:
        return numSoFar
    
    // Otherwise, sum of left and right paths
    return dfs(node.left, numSoFar) + dfs(node.right, numSoFar)
```

### Similar to Path Sum with Accumulation / Tương tự Tổng Đường đi với Tích lũy
- Like Problem 112/113, but instead of checking sum equality, we build numbers.
- Accumulate at leaves, sum across all paths.

---

## Analysis / Phân tích

### Approach: DFS with Number Building / DFS với Xây dựng Số

**Complexity / Độ phức tạp**:
- **Time**: O(N) - visit each node once.
- **Space**: O(H) - recursion stack.

---

## Edge Cases / Các trường hợp biên
1.  **Single node**: Return node value.
2.  **Node value is 0**: Handle correctly (0 in the middle of number).
