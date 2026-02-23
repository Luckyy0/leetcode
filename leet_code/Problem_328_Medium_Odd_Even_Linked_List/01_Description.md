# Result for Odd Even Linked List
# *Kết quả cho bài toán Danh sách Liên kết Lẻ Chẵn*

## Description
## *Mô tả*

Given the `head` of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return *the reordered list*.
*Cho `head` của một danh sách liên kết đơn, hãy nhóm tất cả các nút có chỉ số lẻ lại với nhau, sau đó là các nút có chỉ số chẵn, và trả về *danh sách đã sắp xếp lại*.*

The first node is considered **odd**, and the second node is **even**, and so on.
*Nút đầu tiên được coi là **lẻ**, và nút thứ hai là **chẵn**, v.v.*

Note that the relative order inside both the even and odd groups should remain as it was in the input.
*Lưu ý rằng thứ tự tương đối bên trong cả hai nhóm chẵn và lẻ phải giữ nguyên như trong đầu vào.*

You must solve the problem in `O(1)` extra space complexity and `O(n)` time complexity.
*Bạn phải giải quyết vấn đề với độ phức tạp không gian phụ `O(1)` và độ phức tạp thời gian `O(n)`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `head = [1,2,3,4,5]`
**Output:** `[1,3,5,2,4]`

## Example 2:
## *Ví dụ 2:*

**Input:** `head = [2,1,3,5,6,4,7]`
**Output:** `[2,3,6,7,1,5,4]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the linked list is in the range `[0, 10^4]`.
*   `-10^6 <= Node.val <= 10^6`
