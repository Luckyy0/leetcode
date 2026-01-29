# 1430. Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree / Kiểm tra Xem Chuỗi có phải là Chuỗi Hợp lệ từ Gốc đến Lá trong Cây Nhị phân hay không

## Problem Description / Mô tả bài toán
Binary Tree `root`, array `arr`.
Check if `arr` matches a path from root to VALID LEAF.
(Must end at a leaf).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS
`dfs(node, index)`:
- If `node == null` return false.
- If `node.val != arr[index]` return false.
- If `index == arr.length - 1`: Return `node.isLeaf`.
- Recursive: `dfs(left, index+1) || dfs(right, index+1)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Recursive DFS
DFS function taking `node` and `index`.
Base checks: null node, value mismatch -> return false.
If `index` is last element of array: ensure `node` is a leaf (left and right children are null).
Recurse left and right with `index + 1`.
Hàm DFS nhận `node` và `index`.
Kiểm tra cơ sở: nút null, giá trị không khớp -> trả về false.
Nếu `index` là phần tử cuối cùng của mảng: đảm bảo `node` là một lá.
Đệ quy trái và phải với `index + 1`.

---
