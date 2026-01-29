# 1339. Maximum Product of Splitted Binary Tree / Tích Lớn nhất của Cây Nhị phân Đã tách

## Problem Description / Mô tả bài toán
Binary Tree. Remove 1 edge to split into 2 trees.
Maximize product of sums of the 2 trees.
Modulo `10^9 + 7`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Subtree Sums
Total Sum `S`.
If we remove edge above subtree `u` with sum `S_u`:
Sum of tree 1: `S_u`.
Sum of tree 2: `S - S_u`.
Product: `S_u * (S - S_u)`.
Need to compute all subtree sums.
Two passes:
1. DFS to get Total Sum.
2. DFS to get all subtree sums and maximize product.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(H).

---

## Analysis / Phân tích

### Approach: Two-Pass DFS
First DFS: Compute the total sum of all node values.
Second DFS (or reuse values from first if stored): Calculate the sum of each subtree. For each subtree sum `s`, calculate the product `s * (totalSum - s)` and update the maximum. Be careful with overflow; perform the calculation using `long` before taking modulo at the very end.
DFS đầu tiên: Tính tổng tất cả các giá trị nút.
DFS thứ hai (hoặc sử dụng lại các giá trị từ lần đầu nếu được lưu trữ): Tính tổng của mỗi cây con. Đối với mỗi tổng cây con `s`, tính tích `s * (totalSum - s)` và cập nhật giá trị tối đa. Cẩn thận với tràn số; thực hiện phép tính bằng `long` trước khi lấy modulo ở bước cuối cùng.

---
