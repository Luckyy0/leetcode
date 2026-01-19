# 106. Construct Binary Tree from Inorder and Postorder Traversal / Xây Dựng Cây Nhị Phân từ Duyệt Trung Tự và Hậu Tự

## Problem Description / Mô tả bài toán
Given two integer arrays `inorder` and `postorder` where `inorder` is the inorder traversal of a binary tree and `postorder` is the postorder traversal of the same tree, construct and return the binary tree.
Cho hai mảng số nguyên `inorder` và `postorder` trong đó `inorder` là duyệt trung tự của một cây nhị phân và `postorder` là duyệt hậu tự của cùng một cây, xây dựng và trả về cây nhị phân.

### Example 1:
```text
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
```

### Example 2:
```text
Input: inorder = [-1], postorder = [-1]
Output: [-1]
```

## Constraints / Ràng buộc
- `1 <= inorder.length <= 3000`
- `postorder.length == inorder.length`
- `-3000 <= inorder[i], postorder[i] <= 3000`
- `inorder` and `postorder` consist of **unique** values.
- Each value of `postorder` also appears in `inorder`.
- `inorder` is **guaranteed** to be the inorder traversal of the tree.
- `postorder` is **guaranteed** to be the postorder traversal of the tree.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Comparison with Problem 105 / So sánh với Bài toán 105

| Problem | Root Location | Order |
|---------|---------------|-------|
| **105** (Preorder + Inorder) | **First** in preorder | Root → Left → Right |
| **106** (Inorder + Postorder) | **Last** in postorder | Left → Right → Root |

### Key Insight for Postorder / Điểm quan trọng cho Hậu Tự

1.  **Postorder property**: The **last element** is always the **root** of the current subtree.
    **Thuộc tính hậu tự**: **Phần tử cuối cùng** luôn là **gốc** của cây con hiện tại.

2.  **Inorder property**: Same as Problem 105 - elements to the left of root belong to left subtree.
    **Thuộc tính trung tự**: Giống như Bài toán 105 - các phần tử bên trái gốc thuộc về cây con trái.

3.  **Build Order**: Since we consume postorder from the end, we should build **right subtree first**, then left subtree.
    **Thứ tự Xây dựng**: Vì chúng ta tiêu thụ postorder từ cuối, chúng ta nên xây dựng **cây con phải trước**, sau đó cây con trái.

### Reconstruction Algorithm / Thuật toán Tái tạo

```
Example: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]

Step 1: Root = postorder[last] = 3
        Find 3 in inorder at index 1
        Left subtree inorder: [9] (indices 0-0)
        Right subtree inorder: [15,20,7] (indices 2-4)

Step 2: Right subtree size = 3
        Right subtree postorder: [15,7,20] (before root)
        Left subtree postorder: [9] (before right subtree)

Step 3: Recursively build RIGHT subtree FIRST (since we consume postorder from end)
        Then build LEFT subtree
```

---

## Analysis / Phân tích

### Approach: Recursion with HashMap and Index Pointer / Đệ Quy với HashMap và Con Trỏ Chỉ Số

**Algorithm**:
```
buildTree(inorder, postorder):
    Build HashMap: inorderIndex[val] = index
    postIdx = n - 1  // Start from end of postorder
    return build(0, n-1)

build(inStart, inEnd):
    if inStart > inEnd: return null
    
    rootVal = postorder[postIdx--]  // Consume from end
    root = new TreeNode(rootVal)
    
    inIdx = inorderIndex[rootVal]
    
    // BUILD RIGHT FIRST (because we consume postorder backwards)
    root.right = build(inIdx + 1, inEnd)
    root.left = build(inStart, inIdx - 1)
    
    return root
```

### Why Build Right First? / Tại sao Xây dựng Phải Trước?
- Postorder: Left → Right → **Root**
- When we process backwards: Root → **Right** → Left
- So after taking root, the next elements in reverse postorder are the right subtree nodes.
- Khi xử lý ngược: Gốc → **Phải** → Trái
- Vì vậy sau khi lấy gốc, các phần tử tiếp theo trong postorder ngược là các nút cây con phải.

### Complexity / Độ phức tạp
- **Time**: O(N)
- **Space**: O(N) for HashMap + O(H) for recursion

---

## Edge Cases / Các trường hợp biên
1.  **Single node**.
2.  **Left/Right skewed trees**.
