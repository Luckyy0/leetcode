# 666. Path Sum IV / Tổng Đường đi IV

## Problem Description / Mô tả bài toán
If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digit integers.
Nếu độ sâu của một cây nhỏ hơn 5, thì cây này có thể được biểu diễn bằng một danh sách các số nguyên có ba chữ số.

For each integer:
1. The hundreds digit represents the depth `d` of this node (1 <= d <= 4).
2. The tens digit represents the position `p` of this node in the level (1 <= p <= 8).
3. The units digit represents the value `v` of this node (0 <= v <= 9).

Given a list of three-digit integers representing a binary tree sorted in ascending order, return the sum of all paths from the root towards the leaves.
Cho một danh sách các số nguyên có ba chữ số đại diện cho một cây nhị phân được sắp xếp theo thứ tự tăng dần, hãy trả về tổng của tất cả các đường đi từ gốc đến các lá.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Tree Representation via Map / Biểu diễn Cây thông qua Map
The coordinates `(depth, position)` uniquely identify a node.
Tọa độ `(depth, position)` xác định duy nhất một nút.

A node at `(d, p)` has children at:
- Left child: `(d + 1, 2 * p - 1)`
- Right child: `(d + 1, 2 * p)`

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of nodes.
- **Space**: O(N) to store the tree in a map.

---

## Analysis / Phân tích

### Approach: Recursive Path Summing
Store the tree in a HashMap where the key is `10 * depth + position`. Perform a DFS starting from the root (11). Keep track of the running path sum. When a leaf is reached, add the current sum to the global answer.
Lưu trữ cây trong một HashMap nơi khóa là `10 * depth + position`. Thực hiện DFS bắt đầu từ nút gốc (11). Theo dõi tổng đường chạy. Khi chạm đến một lá, hãy thêm tổng hiện tại vào câu trả lời chung.

---
