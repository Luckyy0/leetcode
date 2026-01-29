# 663. Equal Tree Partition / Phân chia Cây Bằng nhau

## Problem Description / Mô tả bài toán
Given the `root` of a binary tree, return `true` if you can partition the tree into two trees with equal sums of values after removing exactly one edge on the original tree.
Cho `root` của một cây nhị phân, hãy trả về `true` nếu bạn có thể chia cây thành hai cây có tổng giá trị bằng nhau sau khi loại bỏ đúng một cạnh trên cây ban đầu.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Subtree Sum / Tổng Cây con
The total sum of the tree is `S`. To partition the tree into two equal sums, we need to find a subtree whose sum is `S / 2`.
Tổng của cả cây là `S`. Để chia cây thành hai phần có tổng bằng nhau, chúng ta cần tìm một cây con có tổng là `S / 2`.

Crucially, the total sum `S` must be even, and the subtree representing `S/2` cannot be the root itself (as we must remove an edge).
Quan trọng là, tổng `S` phải là số chẵn, và cây con đại diện cho `S/2` không thể là chính nút gốc (vì chúng ta phải loại bỏ một cạnh).

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of nodes.
- **Space**: O(N) to store subtree sums in a set or hash map.

---

## Analysis / Phân tích

### Approach: Post-order Traversal
Calculate the sum of each subtree recursively. Store these sums in a collection. Finally, check if `totalSum / 2` exists in the collection.
Tính toán tổng của mỗi cây con một cách đệ quy. Lưu trữ các tổng này trong một tập hợp. Cuối cùng, kiểm tra xem `totalSum / 2` có tồn tại trong tập hợp đó hay không.

---
