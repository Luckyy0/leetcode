# 105. Construct Binary Tree from Preorder and Inorder Traversal / Xây Dựng Cây Nhị Phân từ Duyệt Tiền Tự và Trung Tự

## Problem Description / Mô tả bài toán
Given two integer arrays `preorder` and `inorder` where `preorder` is the preorder traversal of a binary tree and `inorder` is the inorder traversal of the same tree, construct and return the binary tree.
Cho hai mảng số nguyên `preorder` và `inorder` trong đó `preorder` là duyệt tiền tự của một cây nhị phân và `inorder` là duyệt trung tự của cùng một cây, xây dựng và trả về cây nhị phân.

### Example 1:
```text
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
```

### Example 2:
```text
Input: preorder = [-1], inorder = [-1]
Output: [-1]
```

## Constraints / Ràng buộc
- `1 <= preorder.length <= 3000`
- `inorder.length == preorder.length`
- `-3000 <= preorder[i], inorder[i] <= 3000`
- `preorder` and `inorder` consist of **unique** values.
- Each value of `inorder` also appears in `preorder`.
- `preorder` is **guaranteed** to be the preorder traversal of the tree.
- `inorder` is **guaranteed** to be the inorder traversal of the tree.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Tree Traversal Orders / Thứ tự Duyệt Cây

| Traversal | Order | Mnemonic |
|-----------|-------|----------|
| **Preorder** | Root → Left → Right | **N**LR (Node first) |
| **Inorder** | Left → Root → Right | L**N**R (Node middle) |
| **Postorder** | Left → Right → Root | LR**N** (Node last) |

### Key Insight / Điểm quan trọng chính

1.  **Preorder property**: The **first element** is always the **root** of the current subtree.
    **Thuộc tính tiền tự**: **Phần tử đầu tiên** luôn là **gốc** của cây con hiện tại.

2.  **Inorder property**: Elements **to the left** of root belong to **left subtree**; elements **to the right** belong to **right subtree**.
    **Thuộc tính trung tự**: Các phần tử **bên trái** gốc thuộc về **cây con trái**; các phần tử **bên phải** thuộc về **cây con phải**.

### Reconstruction Algorithm / Thuật toán Tái tạo

```
Example: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]

Step 1: Root = preorder[0] = 3
        Find 3 in inorder at index 1
        Left subtree inorder: [9] (indices 0-0)
        Right subtree inorder: [15,20,7] (indices 2-4)

Step 2: Left subtree size = 1
        Left subtree preorder: [9] (indices 1-1)
        Right subtree preorder: [20,15,7] (indices 2-4)

Step 3: Recursively build left subtree from preorder[1:1], inorder[0:0]
        Recursively build right subtree from preorder[2:4], inorder[2:4]
```

### HashMap Optimization / Tối ưu hóa bằng HashMap
- Finding root in inorder array naively takes O(N) per call.
- Precompute a HashMap: `value -> index in inorder`.
- Lookup becomes O(1).
- Tìm gốc trong mảng trung tự một cách ngây thơ mất O(N) mỗi lần gọi.
- Tính trước một HashMap: `value -> chỉ số trong inorder`.
- Tra cứu trở thành O(1).

---

## Analysis / Phân tích

### Approach: Recursion with HashMap / Đệ Quy với HashMap

**Algorithm**:
```
buildTree(preorder, inorder):
    Build HashMap: inorderIndex[val] = index for each val in inorder
    return build(0, 0, n-1)

build(preIdx, inStart, inEnd):
    if inStart > inEnd: return null
    
    rootVal = preorder[preIdx]
    root = new TreeNode(rootVal)
    
    inIdx = inorderIndex[rootVal]
    leftSize = inIdx - inStart
    
    root.left = build(preIdx + 1, inStart, inIdx - 1)
    root.right = build(preIdx + 1 + leftSize, inIdx + 1, inEnd)
    
    return root
```

### Complexity Analysis / Phân tích Độ phức tạp
- **Time**: O(N) - each node processed once, HashMap lookup O(1).
- **Space**: O(N) for HashMap + O(H) for recursion stack.

---

## Edge Cases / Các trường hợp biên
1.  **Single node**: preorder = inorder = [x].
2.  **Left skewed**: All nodes in left subtree.
3.  **Right skewed**: All nodes in right subtree.
