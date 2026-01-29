# 919. Complete Binary Tree Inserter / Trình Chèn Cây Nhị phân Đầy đủ

## Problem Description / Mô tả bài toán
Design a structure that supports inserting a new node into a **complete** binary tree such that the tree remains complete.
Thiết kế một cấu trúc hỗ trợ việc chèn một nút mới vào một cây nhị phân **đầy đủ** sao cho cây đó vẫn ở trạng thái đầy đủ.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Level-order Queue / Hàng đợi Thứ tự Cấp độ
A complete binary tree is filled level by level. The first node that can accept a child is the first node in level-order that has less than 2 children.
Cây nhị phân đầy đủ được lấp đầy theo từng cấp độ. Nút đầu tiên có thể nhận nút con là nút đầu tiên theo thứ tự cấp độ mà có ít hơn 2 nút con.

Algorithm:
1. Maintain a `Queue` of nodes that can still accept children (i.e., nodes that don't have both left and right children).
2. `insert(v)`:
   - Peek at the first node `p` in the queue.
   - If `p` has no left child, add new node there.
   - Else, add new node to the right and `poll` `p` from the queue.
   - Add the new node to the queue.

### Complexity / Độ phức tạp
- **Construction**: O(N).
- **Insert**: O(1).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Parent Frontier Management
Track the current "frontier" of nodes that are capable of becoming parents. By always using the earliest available slot in the queue, we maintain the structural integrity of the complete binary tree efficiently.
Theo dõi "biên giới" hiện tại của các nút có khả năng trở thành cha mẹ. Bằng cách luôn sử dụng vị trí sớm nhất có sẵn trong hàng đợi, chúng ta duy trì tính toàn vẹn về cấu trúc của cây nhị phân đầy đủ một cách hiệu quả.

---
