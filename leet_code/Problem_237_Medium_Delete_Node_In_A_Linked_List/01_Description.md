# Result for Delete Node in a Linked List
# *Kết quả cho bài toán Xóa nút trong Danh sách liên kết*

## Description
## *Mô tả*

There is a singly-linked list `head` and we want to delete a node `node` in it.
*Có một danh sách liên kết đơn `head` và chúng ta muốn xóa một nút `node` trong đó.*

You are given the node to be deleted `node`. You will **not be given access to the first node of `head`**.
*Bạn được cung cấp nút cần xóa `node`. Bạn sẽ **không được cấp quyền truy cập vào nút đầu tiên của `head`**.*

All the values of the linked list are **unique**, and it is guaranteed that the given node `node` is not the last node in the linked list.
*Tất cả các giá trị của danh sách liên kết là **duy nhất**, và đảm bảo rằng nút đã cho `node` không phải là nút cuối cùng trong danh sách liên kết.*

Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
*Xóa nút đã cho. Lưu ý rằng việc xóa nút không có nghĩa là loại bỏ nó khỏi bộ nhớ. Chúng tôi có ý là:*

*   The value of the given node should not exist in the linked list.
*   The number of nodes in the linked list should decrease by one.
*   All the values before `node` should be in the same order.
*   All the values after `node` should be in the same order.

## Example 1:
## *Ví dụ 1:*

**Input:** `head = [4,5,1,9], node = 5`
**Output:** `[4,1,9]`
**Explanation:** You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

## Example 2:
## *Ví dụ 2:*

**Input:** `head = [4,5,1,9], node = 1`
**Output:** `[4,5,9]`
**Explanation:** You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.

## Constraints:
## *Ràng buộc:*

*   The number of the nodes in the given list is in the range `[2, 1000]`.
*   `-1000 <= Node.val <= 1000`
*   The value of each node in the list is **unique**.
*   The `node` to be deleted is **in the list** and is **not a tail** node.
