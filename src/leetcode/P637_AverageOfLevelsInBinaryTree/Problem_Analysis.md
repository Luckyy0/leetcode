# 637. Average of Levels in Binary Tree / Trung Bình Các Cấp Trong Cây Nhị Phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within `10^-5` of the actual answer will be accepted.
Cho `root` của một cây nhị phân, hãy trả về giá trị trung bình của các nút trên mỗi cấp dưới dạng một mảng. Các câu trả lời trong phạm vi `10^-5` của câu trả lời thực tế sẽ được chấp nhận.

### Example 1:
```text
Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS (Level Order Traversal) / Duyệt Theo Cấp (BFS)
Iterate through levels.
Sum values at each level and divide by count.
Use a Queue. Get queue size at start of loop to process exactly one level.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(W) where W is max width.

---

## Analysis / Phân tích

### Approach: BFS

**Algorithm**:
1.  Initialize Queue with root.
2.  While queue not empty:
    - Get size `s`.
    - Sum = 0.
    - Loop `s` times: poll node, add value to sum, add children.
    - Add `sum / s` to result.

---
