# 1325. Delete Leaves With a Given Value / Xóa Lá Với một Giá trị Đã cho

## Problem Description / Mô tả bài toán
Given root of binary tree and `target`.
Delete leaves with value `target`.
Note: if parent becomes leaf after deletion, and has value `target`, delete it too.
Recursively happen.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Post-Order Traversal
Process children first.
`node.left = removeLeafNodes(node.left, target)`
`node.right = removeLeafNodes(node.right, target)`
Check current node: if `node.left == null` and `node.right == null` (is leaf) AND `node.val == target`, return `null` (delete self).
Else return `node`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Post-Order Classification
Use post-order traversal (process children before parent). Recursively call the function for left and right children. After the recursive calls return, if a node has no children (became a leaf) and its value equals `target`, return `null` to effectively delete it. Otherwise, return the node itself.
Sử dụng duyệt theo thứ tự sau (xử lý con trước cha). Gọi đệ quy hàm cho con trái và phải. Sau khi các cuộc gọi đệ quy trả về, nếu một nút không có con (trở thành lá) và giá trị của nó bằng `target`, hãy trả về `null` để xóa nó một cách hiệu quả. Ngược lại, trả về chính nút đó.

---
