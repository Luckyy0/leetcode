# 95. Unique Binary Search Trees II / Cây Tìm Kiếm Nhị Phân Duy Nhất II

## Problem Description / Mô tả bài toán
Given an integer `n`, return all the structurally unique **BST**'s (binary search trees), which has exactly `n` nodes of unique values from `1` to `n`. Return the answer in **any order**.
Cho một số nguyên `n`, trả về tất cả các **BST** (cây tìm kiếm nhị phân) duy nhất về mặt cấu trúc, có chính xác `n` nút có giá trị duy nhất từ `1` đến `n`. Trả về câu trả lời theo **bất kỳ thứ tự nào**.

### Example 1:
```text
Input: n = 3
Output:
[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
```

### Example 2:
```text
Input: n = 1
Output: [[1]]
```

## Constraints / Ràng buộc
- `1 <= n <= 8`

---

## Analysis / Phân tích

### Approach: Recursive Construction / Xây Dựng Đệ Quy
- **Idea**: To generate trees for range `[start, end]`:
    - Loop `i` from `start` to `end` making `i` the root.
    - Generate all left subtrees from `[start, i-1]`.
    - Generate all right subtrees from `[i+1, end]`.
    - Combine each left subtree with each right subtree under root `i`.
- **Base Case**: If `start > end`, return list containing `null`.
- **Time Complexity**: Catalan Number G(n). The number of BSTs grows fast. 4^n.
- **Space Complexity**: recursion stack O(N) + result size for G(N) trees.

---

## Edge Cases / Các trường hợp biên
1.  **n = 1**: Single tree.
