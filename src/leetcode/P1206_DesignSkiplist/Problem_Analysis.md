# 1206. Design Skiplist / Thiết kế Skiplist

## Problem Description / Mô tả bài toán
Design a Skiplist without using any built-in library.
A skiplist is a data structure that allows O(log(n)) search, insertion and deletion.
Methods: `search(target)`, `add(num)`, `erase(num)`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Skiplist Structure / Cấu trúc Skiplist
Multi-level linked list.
Bottom level contains all elements.
Higher levels act as express lanes.
Probabilistic height assignment during `add`.
`Node`: value, `next[]` (array of pointers for different levels).
`Head`: sentinel.

Algorithm:
- `search(target)`: Start at top level, move right while `next.val < target`, then down. At bottom, check if `next.val == target`.
- `add(num)`:
  - Find update path (node at each level before insertion point).
  - Determine random height.
  - Insert new node, update pointers in update path.
- `erase(num)`:
  - Find update path to nodes pointing to target.
  - If `curr.next[0]` matches target, remove it at all levels where present.
  - If duplicate values exist, remove one instance.

### Complexity / Độ phức tạp
- **Time**: Average O(log N).
- **Space**: Average O(N).

---

## Analysis / Phân tích

### Approach: Probabilistic Multi-Level Search
Construct a skiplist where each node contains an array of `next` pointers representing different levels. The bottom level (0) is a standard sorted linked list. Use a random coin flip (e.g., probability 0.5) to determine the height of a new node during insertion.
- `search`: Traverse from the highest level down. At each level, move forward as far as possible without exceeding the target. If the target is found at level 0, return true.
- `add`: Determine the insertion position at each level by tracking predecessors. Create a new node with a random height and update the predecessor pointers for all levels up to that height.
- `erase`: Traverse to find the node, tracking predecessors. If found, unlink the node from all levels it occupies.
Xây dựng một skiplist trong đó mỗi nút chứa một mảng các con trỏ `next` đại diện cho các cấp độ khác nhau. Cấp độ dưới cùng (0) là một danh sách liên kết được sắp xếp tiêu chuẩn. Sử dụng một lần tung đồng xu ngẫu nhiên (ví dụ: xác suất 0.5) để xác định chiều cao của một nút mới trong quá trình chèn.
- `search`: Duyệt từ cấp độ cao nhất xuống. Ở mỗi cấp độ, di chuyển về phía trước xa nhất có thể mà không vượt quá mục tiêu. Nếu mục tiêu được tìm thấy ở cấp độ 0, trả về true.
- `add`: Xác định vị trí chèn ở mỗi cấp độ bằng cách theo dõi các nút tiền nhiệm. Tạo một nút mới với chiều cao ngẫu nhiên và cập nhật các con trỏ tiền nhiệm cho tất cả các cấp độ lên đến chiều cao đó.
- `erase`: Duyệt để tìm nút, theo dõi các nút tiền nhiệm. Nếu tìm thấy, hủy liên kết nút khỏi tất cả các cấp độ mà nó chiếm giữ.

---
