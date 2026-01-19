# 113. Path Sum II / Tổng Đường Đi II

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree and an integer `targetSum`, return **all root-to-leaf paths** where the sum of the node values in the path equals `targetSum`. Each path should be returned as a list of the node **values**, not node references.
Cho `root` của một cây nhị phân và một số nguyên `targetSum`, trả về **tất cả các đường đi từ gốc đến lá** trong đó tổng các giá trị nút trong đường đi bằng `targetSum`. Mỗi đường đi nên được trả về dưới dạng danh sách các **giá trị** nút, không phải tham chiếu nút.

A **root-to-leaf** path is a path starting from the root and ending at any leaf node. A **leaf** is a node with no children.
Một đường đi **từ gốc đến lá** là một đường đi bắt đầu từ gốc và kết thúc tại bất kỳ nút lá nào. Một **lá** là một nút không có con.

### Example 1:
```text
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
```

### Example 2:
```text
Input: root = [1,2,3], targetSum = 5
Output: []
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 5000]`.
- `-1000 <= Node.val <= 1000`
- `-1000 <= targetSum <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Extension of Problem 112 / Mở rộng từ Bài toán 112

| Problem | Task | Return Type |
|---------|------|-------------|
| **112** | Check if ANY path exists | boolean |
| **113** | Find ALL valid paths | List of paths |

### Backtracking for Path Collection / Quay lui để Thu thập Đường đi
This is a classic **backtracking** problem:
Đây là một bài toán **quay lui** kinh điển:

1.  **Choose**: Add current node to path.
2.  **Explore**: Recurse into children.
3.  **Unchoose**: Remove current node from path (backtrack).

```
backtrack(node, remainingSum, currentPath, result):
    if node == null: return
    
    // Choose
    currentPath.add(node.val)
    remainingSum -= node.val
    
    // Check if valid leaf
    if node is leaf and remainingSum == 0:
        result.add(copy of currentPath)
    
    // Explore children
    backtrack(node.left, remainingSum, currentPath, result)
    backtrack(node.right, remainingSum, currentPath, result)
    
    // Unchoose (backtrack)
    currentPath.removeLast()
```

### Why Copy the Path? / Tại sao Sao chép Đường đi?
- We use ONE path list throughout recursion.
- When a valid path is found, we add a **copy** to result.
- If we added the original, it would be mutated by subsequent backtracking.
- Chúng ta sử dụng MỘT danh sách đường đi trong suốt đệ quy.
- Khi tìm thấy đường đi hợp lệ, chúng ta thêm một **bản sao** vào kết quả.

---

## Analysis / Phân tích

### Approach: DFS Backtracking / Quay lui DFS

**Complexity / Độ phức tạp**:
- **Time**: O(N²) worst case - O(N) nodes, each path can be O(N) length, copying takes O(N).
- **Space**: O(N) for path + O(H) for recursion = O(N).

---

## Edge Cases / Các trường hợp biên
1.  **Empty tree**: Return `[]`.
2.  **No valid paths**: Return `[]`.
3.  **Multiple valid paths**: Return all.
4.  **Negative values**: Handled naturally.
