# Result for Reverse Nodes in k-Group
# *Kết quả cho bài toán Đảo Ngược Các Nút trong Nhóm k*

## Description
## *Mô tả*

Given the `head` of a linked list, reverse the nodes of the list `k` at a time, and return the modified list.
*Cho `head` của một danh sách liên kết, đảo ngược các nút của danh sách theo từng nhóm `k`, và trả về danh sách đã sửa đổi.*

`k` is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of `k` then left-out nodes, in the end, should remain as it is.
*`k` là một số nguyên dương và nhỏ hơn hoặc bằng độ dài của danh sách liên kết. Nếu số lượng nút không phải là bội số của `k` thì các nút còn lại ở cuối nên được giữ nguyên.*

You may not alter the values in the list's nodes, only nodes themselves may be changed.
*Bạn không được thay đổi giá trị trong các nút của danh sách, chỉ các nút mới được hoán đổi.*

## Example 1:
## *Ví dụ 1:*

**Input:** `head = [1,2,3,4,5]`, `k = 2`
**Output:** `[2,1,4,3,5]`

## Example 2:
## *Ví dụ 2:*

**Input:** `head = [1,2,3,4,5]`, `k = 3`
**Output:** `[3,2,1,4,5]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the list is `n`.
*   `1 <= k <= n <= 5000`
*   `0 <= Node.val <= 1000`
