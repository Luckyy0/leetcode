# 653. Two Sum IV - Input is a BST / Tổng Hai Số IV - Đầu Vào Là BST

## Problem Description / Mô tả bài toán
Given the `root` of a Binary Search Tree and a target number `k`, return `true` if there exist two elements in the BST such that their sum is equal to the given target.
Cho `root` của Cây Tìm Kiếm Nhị Phân và một số mục tiêu `k`, trả về `true` nếu tồn tại hai phần tử trong BST sao cho tổng của chúng bằng mục tiêu đã cho.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashSet / Two Pointers / HashSet / Hai Con Trỏ
Approach 1: HashSet - Traverse tree, check if `k - node.val` exists in set.
Approach 2: Convert BST to sorted array (inorder), use two pointers.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---
