# Result for Linked List Cycle II
# *Kết quả cho bài toán Chu trình trong Danh sách liên kết II*

## Description
## *Mô tả*

Given the `head` of a linked list, return *the node where the cycle begins. If there is no cycle, return `null`.*
*Cho `head` của một danh sách liên kết, hãy trả về *nút nơi chu trình bắt đầu. Nếu không có chu trình, hãy trả về `null`**.*

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to (**0-indexed**). It is `-1` if there is no cycle. **Note that `pos` is not passed as a parameter.**
*Một danh sách liên kết có chu trình nếu tồn tại một nút nào đó trong danh sách có thể được truy cập lại bằng cách liên tục đi theo con trỏ `next`. Trong nội bộ, `pos` được sử dụng để biểu thị chỉ số của nút mà con trỏ `next` của phần đuôi kết nối tới (**0-indexed**). Nó là `-1` nếu không có chu trình. **Lưu ý rằng `pos` không được truyền dưới dạng tham số.***

**Do not modify** the linked list.
**Không sửa đổi** danh sách liên kết.

## Example 1:
## *Ví dụ 1:*

**Input:** `head = [3,2,0,-4], pos = 1`
**Output:** `tail connects to node index 1`
**Explanation:** There is a cycle in the linked list, where tail connects to the second node.

## Example 2:
## *Ví dụ 2:*

**Input:** `head = [1,2], pos = 0`
**Output:** `tail connects to node index 0`
**Explanation:** There is a cycle in the linked list, where tail connects to the first node.

## Example 3:
## *Ví dụ 3:*

**Input:** `head = [1], pos = -1`
**Output:** `no cycle`
**Explanation:** There is no cycle in the linked list.

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the list is in the range `[0, 10^4]`.
*   `-10^5 <= Node.val <= 10^5`
*   `pos` is `-1` or a valid index in the linked-list.
