# 1120. Maximum Average Subtree / Cây con Trung bình Lớn nhất

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, find the maximum average value of any subtree of that tree.
(A subtree of a tree is any node of that tree plus all its descendants.)
Cho `root` của một cây nhị phân, hãy tìm giá trị trung bình lớn nhất của bất kỳ cây con nào của cây đó.
(Một cây con của một cây là bất kỳ nút nào của cây đó cộng với tất cả các hậu duệ của nó.)

Return the maximum average value.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Post-Order DFS / DFS Hậu tố
Each node returns `[sum, count]`.
Average = `sum / count`.
Global max tracked.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Recursive Aggregation
Perform a post-order traversal where each node returns the sum of values and the count of nodes in its subtree. Use these aggregated values to calculate the average for the current subtree. Update a global maximum average whenever a higher value is found.
Thực hiện duyệt hậu tố trong đó mỗi nút trả về tổng các giá trị và số lượng nút trong cây con của nó. Sử dụng các giá trị tổng hợp này để tính trung bình cho cây con hiện tại. Cập nhật mức trung bình tối đa toàn cầu bất cứ khi nào tìm thấy giá trị cao hơn.

---
