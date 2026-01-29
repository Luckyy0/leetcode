# 662. Maximum Width of Binary Tree / Độ rộng Tối đa của Cây Nhị phân

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return the **maximum width** of the given tree.
Cho `root` của một cây nhị phân, hãy trả về **độ rộng tối đa** của cây đã cho.

The **maximum width** of a tree is the maximum **width** among all levels.
**Độ rộng tối đa** của một cây là **độ rộng** lớn nhất trong tất cả các cấp.

The **width** of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.
**Độ rộng** của một cấp được định nghĩa là khoảng cách giữa các nút ở hai đầu (các nút khác null ngoài cùng bên trái và ngoài cùng bên phải), trong đó các nút null ở giữa các nút ở hai đầu cũng được tính vào việc tính toán độ dài.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS with Indexing / BFS với Chỉ mục
We can assign an index to each node in the tree just like in a heap (array representation of a binary tree).
Chúng ta có thể gán một chỉ mục cho mỗi nút trong cây giống như trong một heap (biểu diễn mảng của một cây nhị phân).

For a node at index `i`:
- Left child is at `2 * i`.
- Right child is at `2 * i + 1`.
The width of a level is `(rightmostIndex - leftmostIndex + 1)`.
Độ rộng của một cấp là `(chỉSốPhảiCùng - chỉSốTráiCùng + 1)`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of nodes.
- **Space**: O(W) where W is the maximum width of the tree (size of queue).

---

## Analysis / Phân tích

### Approach: Level-order Traversal (BFS)
At each level, note the indices of the first and last nodes. Calculate the width and update the maximum width found so far.
Ở mỗi cấp độ, lưu ý các chỉ mục của các nút đầu tiên và cuối cùng. Tính toán độ rộng và cập nhật độ rộng tối đa tìm thấy cho đến nay.

---
