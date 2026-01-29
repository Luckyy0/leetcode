# 998. Maximum Binary Tree II / Cây Nhị phân Lớn nhất II

## Problem Description / Mô tả bài toán
A maximum tree is a tree where every node has a value greater than its children.
Cây lớn nhất là cây mà mọi nút đều có giá trị lớn hơn các con của nó.

Given the `root` of a maximum tree and an integer `val`, you want to insert `val` into the tree. Since `val` was added at the end of the original list used to build the tree, it must be inserted into the **right** branch.
Cho gốc `root` của một cây lớn nhất và một số nguyên `val`, bạn muốn chèn `val` vào cây. Vì `val` được thêm vào cuối danh sách ban đầu dùng để xây dựng cây, nó phải được chèn vào nhánh **phải**.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Recursive Right-side Insertion / Chèn nhánh phải đệ quy
In a Max Tree, the list construction order maps to an in-order traversal. Adding to the end of the list means the new node must be the rightmost child or take over an existing branch's position if it's larger.
Trong một Cây cực đại, thứ tự xây dựng danh sách tương ứng với phép duyệt giữa (in-order). Việc thêm vào cuối danh sách có nghĩa là nút mới phải là nút con ngoài cùng bên phải hoặc thay thế vị trí của một nhánh hiện có nếu nó lớn hơn.

Algorithm:
1. If `root == null`, return `new Node(val)`.
2. If `val > root.val`:
   - `val` becomes the new root.
   - Old root becomes the `left` child because everything in the old tree was "to the left" of the new `val`.
3. Else (`val < root.val`):
   - Recursively insert into `root.right`.

### Complexity / Độ phức tạp
- **Time**: O(H).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Right-Spine Migration
Navigate down the right spine of the tree, looking for the correct insertion point. Because the new element originated from the end of the data stream, it either becomes the new parent of a smaller existing node on the right spine or attaches as a new terminal leaf.
Điều hướng xuống xương sống bên phải của cây, tìm kiếm điểm chèn chính xác. Bởi vì phần tử mới bắt nguồn từ cuối luồng dữ liệu, nó sẽ trở thành cha mới của một nút hiện có nhỏ hơn trên xương sống bên phải hoặc được gắn vào như một lá cuối cùng mới.

---
