# Result for Linked List Cycle
# *Kết quả cho bài toán Chu trình trong Danh sách liên kết*

## Description
## *Mô tả*

Given `head`, the head of a linked list, determine if the linked list has a cycle in it.
*Cho `head` là đầu của một danh sách liên kết, hãy xác định xem danh sách liên kết đó có chu trình hay không.*

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to. **Note that `pos` is not passed as a parameter.**
*Một danh sách liên kết có chu trình nếu tồn tại một nút nào đó trong danh sách có thể được truy cập lại bằng cách liên tục đi theo con trỏ `next`. Trong nội bộ, `pos` được sử dụng để biểu thị chỉ số của nút mà con trỏ `next` của phần đuôi kết nối tới. **Lưu ý rằng `pos` không được truyền dưới dạng tham số.***

Return `true` if there is a cycle in the linked list. Otherwise, return `false`.
*Trả về `true` nếu có chu trình trong danh sách liên kết. Nếu không, hãy trả về `false`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `head = [3,2,0,-4], pos = 1`
**Output:** `true`
**Explanation:** There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

## Example 2:
## *Ví dụ 2:*

**Input:** `head = [1,2], pos = 0`
**Output:** `true`
**Explanation:** There is a cycle in the linked list, where the tail connects to the 0th node.

## Example 3:
## *Ví dụ 3:*

**Input:** `head = [1], pos = -1`
**Output:** `false`
**Explanation:** There is no cycle in the linked list.

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the list is in the range `[0, 10^4]`.
*   `-10^5 <= Node.val <= 10^5`
*   `pos` is `-1` or a valid index in the linked-list.
