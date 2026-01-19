# 108. Convert Sorted Array to Binary Search Tree / Chuyển Đổi Mảng Đã Sắp Xếp Thành Cây Tìm Kiếm Nhị Phân

## Problem Description / Mô tả bài toán
Given an integer array `nums` where the elements are sorted in **ascending order**, convert it to a **height-balanced** binary search tree.
Cho một mảng số nguyên `nums` trong đó các phần tử được sắp xếp theo **thứ tự tăng dần**, hãy chuyển đổi nó thành một cây tìm kiếm nhị phân **cân bằng chiều cao**.

A **height-balanced** binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
Một cây nhị phân **cân bằng chiều cao** là một cây nhị phân trong đó độ sâu của hai cây con của mọi nút không bao giờ chênh lệch quá một.

### Example 1:
```text
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted.
```

### Example 2:
```text
Input: nums = [1,3]
Output: [3,1] or [1,null,3]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^4`
- `-10^4 <= nums[i] <= 10^4`
- `nums` is sorted in a **strictly increasing** order.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Binary Search Tree (BST) Definition / Định nghĩa Cây Tìm Kiếm Nhị Phân
- For each node: all left descendants < node < all right descendants.
- Inorder traversal of BST produces sorted sequence.

### Height-Balanced Tree / Cây Cân Bằng Chiều Cao
- Also known as **AVL property**: For every node, `|height(left) - height(right)| <= 1`.
- Ensures O(log N) operations.

### Key Insight: Middle Element as Root / Điểm quan trọng: Phần tử Giữa làm Gốc
For a sorted array to become a height-balanced BST:
Để một mảng đã sắp xếp trở thành BST cân bằng chiều cao:

1.  **Choose middle element as root**: This ensures left and right subtrees have nearly equal sizes.
    **Chọn phần tử giữa làm gốc**: Điều này đảm bảo cây con trái và phải có kích thước gần bằng nhau.

2.  **Recursively apply**: Apply the same logic to left half (becomes left subtree) and right half (becomes right subtree).
    **Áp dụng đệ quy**: Áp dụng logic tương tự cho nửa trái (trở thành cây con trái) và nửa phải (trở thành cây con phải).

### Why This Works / Tại sao Điều này Hoạt động
```
Array: [-10, -3, 0, 5, 9]
        ↑          ↑
       left       mid     right
       
- mid (index 2, value 0) becomes root
- Left half [-10, -3] becomes left subtree
- Right half [5, 9] becomes right subtree
- Each subtree is recursively balanced the same way
```

This is essentially **binary search** applied to tree construction!
Đây về cơ bản là **tìm kiếm nhị phân** được áp dụng cho việc xây dựng cây!

---

## Analysis / Phân tích

### Approach: Divide and Conquer (Recursion) / Chia để Trị (Đệ Quy)

**Algorithm**:
```
sortedArrayToBST(nums):
    return build(nums, 0, nums.length - 1)

build(nums, left, right):
    if left > right: return null
    
    mid = (left + right) / 2
    root = new TreeNode(nums[mid])
    
    root.left = build(nums, left, mid - 1)
    root.right = build(nums, mid + 1, right)
    
    return root
```

### Why Height-Balanced? / Tại sao Cân Bằng Chiều Cao?
- At each step, we pick the middle, so sublists differ by at most 1 element.
- This means subtree heights differ by at most 1.
- Mathematical induction proves the tree is height-balanced.

### Complexity / Độ phức tạp
- **Time**: O(N) - each element processed once.
- **Space**: O(log N) for recursion stack (tree is balanced).

---

## Edge Cases / Các trường hợp biên
1.  **Single element**: Returns single node.
2.  **Two elements**: Two valid configurations.
3.  **Odd/Even length**: Middle calculation handles both.
