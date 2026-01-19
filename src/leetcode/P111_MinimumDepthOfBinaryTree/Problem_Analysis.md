# 111. Minimum Depth of Binary Tree / Độ Sâu Tối Thiểu của Cây Nhị Phân

## Problem Description / Mô tả bài toán
Given a binary tree, find its minimum depth.
Cho một cây nhị phân, tìm độ sâu tối thiểu của nó.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Độ sâu tối thiểu là số lượng nút dọc theo đường dẫn ngắn nhất từ nút gốc đến nút lá gần nhất.

**Note**: A leaf is a node with no children.
**Lưu ý**: Một lá là một nút không có con.

### Example 1:
```text
Input: root = [3,9,20,null,null,15,7]
Output: 2
```

### Example 2:
```text
Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 10^5]`.
- `-1000 <= Node.val <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Key Difference from Maximum Depth / Sự Khác Biệt Chính với Độ Sâu Tối Đa

| Problem | Goal | Key Consideration |
|---------|------|-------------------|
| Max Depth (P104) | Longest path to leaf | Simple max of left and right |
| **Min Depth (P111)** | **Shortest path to leaf** | **Must reach a LEAF node** |

### Critical Insight: Must Reach a Leaf / Điểm Quan Trọng: Phải Đến Được Một Lá

**Wrong Approach**:
```
minDepth(node):
    if node == null: return 0
    return 1 + min(minDepth(left), minDepth(right))  // WRONG!
```

**Why it's wrong**: If a node has only one child, `min(0, height) = 0`, but zero is not the depth to a leaf - there's no leaf on that side!
**Tại sao sai**: Nếu một nút chỉ có một con, `min(0, height) = 0`, nhưng 0 không phải là độ sâu đến một lá - không có lá ở phía đó!

**Example / Ví dụ**:
```
    1
     \
      2
       \
        3  <- Only leaf
        
Wrong answer: 1 (treating null as depth 0)
Correct answer: 3 (path: 1 -> 2 -> 3)
```

### Correct Approach / Phương pháp Đúng
Handle the case where one child is null:
Xử lý trường hợp một con là null:

```
minDepth(node):
    if node == null: return 0
    if node.left == null: return 1 + minDepth(right)   // Must go right
    if node.right == null: return 1 + minDepth(left)   // Must go left
    return 1 + min(minDepth(left), minDepth(right))    // Both exist, take min
```

---

## Analysis / Phân tích

### Approach 1: DFS (Recursion) / DFS (Đệ Quy)
- Handle null children explicitly.
- **Time**: O(N), **Space**: O(H).

### Approach 2: BFS (Level Order) / BFS (Theo Tầng)
- **Key Advantage**: BFS finds the **first leaf** encountered, which is guaranteed to be at minimum depth.
- **Ưu điểm chính**: BFS tìm **lá đầu tiên** gặp được, được đảm bảo là ở độ sâu tối thiểu.
- Early termination: Stop as soon as we find a leaf.
- **Time**: O(N) worst case, but often less. **Space**: O(W).

### Why BFS is Often Better Here / Tại sao BFS Thường Tốt hơn Ở Đây
- DFS must explore entire tree to find minimum.
- BFS can stop early when first leaf is found.
- For wide shallow trees, BFS wins significantly.

---

## Edge Cases / Các trường hợp biên
1.  **Empty tree**: Return 0.
2.  **Single node (leaf)**: Return 1.
3.  **Skewed tree (one child at each level)**: Depth = N.
4.  **Complete tree**: Depth = log₂(N) + 1.
