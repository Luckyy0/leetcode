# 110. Balanced Binary Tree / Cây Nhị Phân Cân Bằng

## Problem Description / Mô tả bài toán
Given a binary tree, determine if it is **height-balanced**.
Cho một cây nhị phân, xác định xem nó có **cân bằng chiều cao** hay không.

A **height-balanced** binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
Một cây nhị phân **cân bằng chiều cao** là một cây nhị phân trong đó độ sâu của hai cây con của mọi nút không bao giờ chênh lệch quá một.

### Example 1:
```text
Input: root = [3,9,20,null,null,15,7]
Output: true
```

### Example 2:
```text
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
```

### Example 3:
```text
Input: root = []
Output: true
```

## Constraints / Ràng buộc
- The number of nodes in the tree is in the range `[0, 5000]`.
- `-10^4 <= Node.val <= 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Height-Balanced (AVL) Property / Thuộc tính Cân Bằng Chiều Cao (AVL)
For every node in the tree:
Đối với mỗi nút trong cây:
```
|height(left subtree) - height(right subtree)| <= 1
```

AND both subtrees must also be balanced (recursive property).
VÀ cả hai cây con cũng phải cân bằng (thuộc tính đệ quy).

### Naive Approach Problem / Vấn đề của Phương pháp Ngây thơ
```
isBalanced(node):
    if node == null: return true
    leftHeight = getHeight(node.left)   // O(N)
    rightHeight = getHeight(node.right) // O(N)
    return |leftHeight - rightHeight| <= 1 
           AND isBalanced(node.left) 
           AND isBalanced(node.right)
```
- **Problem**: `getHeight()` is called repeatedly, leading to O(N²) time.
- **Vấn đề**: `getHeight()` được gọi lặp lại, dẫn đến thời gian O(N²).

### Optimized Approach: Bottom-Up / Phương pháp Tối ưu: Từ Dưới Lên
Combine height calculation with balance check in a single pass:
Kết hợp tính chiều cao với kiểm tra cân bằng trong một lần duyệt:

```
checkHeight(node):
    if node == null: return 0
    
    leftHeight = checkHeight(node.left)
    if leftHeight == -1: return -1  // Left subtree is unbalanced
    
    rightHeight = checkHeight(node.right)
    if rightHeight == -1: return -1  // Right subtree is unbalanced
    
    if |leftHeight - rightHeight| > 1: return -1  // Current node unbalanced
    
    return 1 + max(leftHeight, rightHeight)  // Return height if balanced
```

**Key Insight**: Use `-1` as a sentinel value to indicate "unbalanced".
**Điểm quan trọng**: Sử dụng `-1` làm giá trị sentinel để chỉ ra "không cân bằng".

---

## Analysis / Phân tích

### Approach: Bottom-Up Height Check / Kiểm tra Chiều cao Từ Dưới Lên

**Algorithm Summary**:
1.  Recursively compute height.
2.  At each node, check if `|left - right| <= 1`.
3.  If violation found, return `-1` immediately.
4.  Final result: `checkHeight(root) != -1`.

### Complexity / Độ phức tạp
- **Time**: O(N) - each node visited exactly once.
- **Space**: O(H) - recursion stack, where H is tree height.

### Comparison / So sánh
| Approach | Time | Space |
|----------|------|-------|
| Naive (top-down) | O(N²) | O(H) |
| **Optimized (bottom-up)** | **O(N)** | O(H) |

---

## Edge Cases / Các trường hợp biên
1.  **Empty tree**: Balanced (by definition).
2.  **Single node**: Balanced.
3.  **Skewed tree with more than 1 level difference**: Unbalanced.
