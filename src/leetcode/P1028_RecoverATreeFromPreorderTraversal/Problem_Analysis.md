# 1028. Recover a Tree From Preorder Traversal / Khôi phục Cây từ Duyệt Thứ tự Trước

## Problem Description / Mô tả bài toán
We run a preorder traversal of a binary tree. At each node, we output `D` dashes (where `D` is the depth of this node), then we output the value of this node.
Chúng ta chạy duyệt thứ tự trước (preorder traversal) của một cây nhị phân. Tại mỗi nút, chúng ta xuất ra `D` dấu gạch ngang (trong đó `D` là độ sâu của nút này), sau đó chúng ta xuất ra giá trị của nút này.
- Root depth is 0.
- Return the root of the recovered tree.

Example: `1-2--3--4-5--6--7` -> Tree 1 -> (2 -> (3, 4), 5 -> (6, 7)).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Iterative Stack Approach / Phương pháp Ngăn xếp Lặp
The number of dashes tells us the depth.
Số lượng dấu gạch ngang cho chúng ta biết độ sâu.

Algorithm:
1. Use a stack to keep path from root.
2. Parse string loop:
   - Count dashes -> `depth`.
   - Parse number -> `val`.
   - Create `node`.
   - Adjust stack: `while (stack.size() > depth) stack.pop()`.
   - If stack not empty:
     - If `stack.peek().left == null`, `left = node`.
     - Else `right = node`.
   - `stack.push(node)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Depth-Matching Stack
Parse the string sequentially to extract depth-value pairs. Use a stack to maintain the current path from the root. Adjust the stack size to match the target depth, then blindly attach the new node as a child (preferring left) to the node currently at the stack's top.
Phân tích chuỗi theo tuần tự để trích xuất các cặp độ sâu-giá trị. Sử dụng ngăn xếp để duy trì đường dẫn hiện tại từ gốc. Điều chỉnh kích thước ngăn xếp để khớp với độ sâu mục tiêu, sau đó gắn nút mới làm con (ưu tiên bên trái) vào nút hiện đang ở trên cùng của ngăn xếp.

---
