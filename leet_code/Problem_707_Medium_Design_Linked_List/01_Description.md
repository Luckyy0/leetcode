# Result for Design Linked List
# *Kết quả cho bài toán Thiết kế Danh sách Liên kết*

## Description
## *Mô tả*

Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
*Thiết kế bản cài đặt của danh sách liên kết. Bạn có thể chọn sử dụng danh sách liên kết đơn hoặc kép.*

A node in a singly linked list should have two attributes: `val` and `next`. `val` is the value of the current node, and `next` is a pointer/reference to the next node.
*Một nút trong danh sách liên kết đơn nên có hai thuộc tính: `val` và `next`. `val` là giá trị của nút hiện tại, và `next` là một con trỏ tới nút tiếp theo.*

Implement the `MyLinkedList` class:
*   `MyLinkedList()` Initializes the `MyLinkedList` object.
*   `int get(int index)` Get the value of the `indexth` node in the linked list. If the index is invalid, return `-1`.
*   `void addAtHead(int val)` Add a node of value `val` before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
*   `void addAtTail(int val)` Append a node of value `val` as the last element of the linked list.
*   `void addAtIndex(int index, int val)` Add a node of value `val` before the `indexth` node in the linked list. If `index` equals the length of the linked list, the node will be appended to the end of the linked list. If `index` is greater than the length, the node will not be inserted.
*   `void deleteAtIndex(int index)` Delete the `indexth` node in the linked list, if the index is valid.

---

## Example 1:
## *Ví dụ 1:*

**Input:** ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
**Output:** [null, null, null, null, 2, null, 3]

---

## Constraints:
## *Ràng buộc:*

*   `0 <= index, val <= 1000`
*   At most `2000` calls will be made to `get`, `addAtHead`, `addAtTail`, `addAtIndex`, and `deleteAtIndex`.
