# Result for Reorder List
# *Kết quả cho bài toán Tái cấu trúc Danh sách*

## Description
## *Mô tả*

You are given the head of a singly linked-list. The list can be represented as:
*Bạn được cho đầu của một danh sách liên kết đơn. Danh sách có thể được biểu diễn như sau:*

`L0 -> L1 -> ... -> Ln-1 -> Ln`

Reorder the list to be on the following form:
*Hãy cấu trúc lại danh sách theo dạng sau:*

`L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 -> ...`

You may not modify the values in the list's nodes. Only nodes themselves may be changed.
*Bạn không được sửa đổi các giá trị trong các nút của danh sách. Chỉ các nút mới có thể bị thay đổi.*

## Example 1:
## *Ví dụ 1:*

**Input:** `head = [1,2,3,4]`
**Output:** `[1,4,2,3]`

## Example 2:
## *Ví dụ 2:*

**Input:** `head = [1,2,3,4,5]`
**Output:** `[1,5,2,4,3]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the list is in the range `[1, 5 * 10^4]`.
*   `1 <= Node.val <= 1000`
