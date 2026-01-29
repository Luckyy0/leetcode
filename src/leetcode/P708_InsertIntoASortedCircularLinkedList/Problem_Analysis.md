# 708. Insert into a Sorted Circular Linked List / Chèn vào Danh sách Liên kết Vòng đã Sắp xếp

## Problem Description / Mô tả bài toán
Given a node from a **Circular Linked List** which is sorted in non-descending order, write a function to insert a value `insertVal` into the list such that it remains a sorted circular list.
Cho một nút từ **Danh sách Liên kết Vòng** được sắp xếp theo thứ tự không giảm, hãy viết một hàm để chèn giá trị `insertVal` vào danh sách sao cho danh sách vẫn là một danh sách vòng đã sắp xếp.

The node given can be any single node in the list and may not necessarily be the smallest value in the circular list.
Nút được cho có thể là bất kỳ nút nào trong danh sách và không nhất thiết phải là giá trị nhỏ nhất trong danh sách vòng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Circular List Traversal / Duyệt Danh sách Vòng
We need to find the correct gap to insert the new node.
Chúng ta cần tìm khoảng trống chính xác để chèn nút mới.

Cases:
1. **Empty list**: Create a new node and point its `next` to itself.
2. **Standard gap**: `curr.val <= insertVal <= curr.next.val`.
3. **End of cycle**: `curr.val > curr.next.val` (this is the wrap-around point).
   - If `insertVal >= curr.val` OR `insertVal <= curr.next.val`, chèn vào đây.
4. **All nodes same**: If we loop back to the start, insert anywhere.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the number of nodes.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Traverse once with Gap Check
Iterate through the circular list using `curr` and `next` pointers. Handle the three logical cases (standard, wrap-around, and identity loop).
Duyệt qua danh sách vòng bằng con trỏ `curr` và `next`. Xử lý ba trường hợp logic (tiêu chuẩn, vòng lại và lặp về điểm xuất phát).

---
