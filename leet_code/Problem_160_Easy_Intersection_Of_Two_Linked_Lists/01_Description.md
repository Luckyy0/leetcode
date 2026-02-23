# Result for Intersection of Two Linked Lists
# *Kết quả cho bài toán Giao điểm của hai danh sách liên kết*

## Description
## *Mô tả*

Given the heads of two singly linked-lists `headA` and `headB`, return *the node at which the two lists intersect*. If the two linked lists have no intersection at all, return `null`.
*Cho đầu của hai danh sách liên kết đơn `headA` và `headB`, hãy trả về *nút nơi hai danh sách giao nhau*. Nếu hai danh sách liên kết không có giao điểm nào, hãy trả về `null`***.*

For example, the following two linked lists begin to intersect at node c1:
*Ví dụ, hai danh sách liên kết sau đây bắt đầu giao nhau tại nút c1:*
`A: a1 -> a2 -> c1 -> c2 -> c3`
`B: b1 -> b2 -> b3 -> c1 -> c2 -> c3`

The test cases are generated such that there are no cycles anywhere in the entire linked structure.
*Các trường hợp kiểm thử được tạo ra sao cho không có chu trình ở bất kỳ đâu trong toàn bộ cấu trúc liên kết.*

**Note** that the linked lists must **retain their original structure** after the function returns.
**Lưu ý** rằng các danh sách liên kết phải **giữ nguyên cấu trúc ban đầu** sau khi hàm trả về.

## Example 1:
## *Ví dụ 1:*

**Input:** `intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3`
**Output:** `Intersected at '8'`

## Example 2:
## *Ví dụ 2:*

**Input:** `intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1`
**Output:** `Intersected at '2'`

## Example 3:
## *Ví dụ 3:*

**Input:** `intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2`
**Output:** `No intersection`

## Constraints:
## *Ràng buộc:*

*   The number of nodes of `listA` is in the `m`.
*   The number of nodes of `listB` is in the `n`.
*   `1 <= m, n <= 3 * 10^4`
*   `1 <= Node.val <= 10^5`
*   `skipA` and `skipB` denote the index of the node where intersection begins.
*   `intersectVal` is `0` if there is no intersection.
