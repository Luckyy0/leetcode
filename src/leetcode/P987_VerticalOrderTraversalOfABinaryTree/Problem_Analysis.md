# 987. Vertical Order Traversal of a Binary Tree / Duyệt theo Chiều dọc của Cây Nhị phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the vertical order traversal of its nodes' values.
Cho `root` của một cây nhị phân, hãy trả về kết quả duyệt theo chiều dọc của các giá trị nút trong cây.

Rules:
- Column coordinate: root is 0, left child is `col-1`, right child is `col+1`.
- Row coordinate: root is 0, children are `row+1`.
- For nodes in the same column and row, sort by value.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Coordinate System and Sorting / Hệ tọa độ và Sắp xếp
Algorithm:
1. DFS or BFS to collect all nodes as triplets `(col, row, value)`.
2. Sort the triplets:
   - Primary: `col` ascending.
   - Secondary: `row` ascending.
   - Tertiary: `value` ascending.
3. Group nodes by `col` and return.

### Complexity / Độ phức tạp
- **Time**: O(N log N) for sorting.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Triple-Key Sorting
Assign a virtual Cartesian coordinate $(row, col)$ to every node. By sorting the entire node set based on a hierarchy of column position, then row depth, and finally value, we can easily slice the resulting sequence into vertical buckets for the final output.
Gán tọa độ Cartesian ảo $(row, col)$ cho mọi nút. Bằng cách sắp xếp toàn bộ tập hợp nút dựa trên hệ thống phân cấp gồm vị trí cột, sau đó là độ sâu hàng và cuối cùng là giá trị, chúng ta có thể dễ dàng chia chuỗi kết quả thành các nhóm dọc để đưa ra đầu ra cuối cùng.

---
