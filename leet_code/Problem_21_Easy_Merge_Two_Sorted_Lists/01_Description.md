# Result for Merge Two Sorted Lists
# *Kết quả cho bài toán Gộp Hai Danh Sách Đã Sắp Xếp*

## Description
## *Mô tả*

You are given the heads of two sorted linked lists `list1` and `list2`.
*Bạn được cho các đầu cúa hai danh sách liên kết đã sắp xếp `list1` và `list2`.*

Merge the two lists into one **sorted** list. The list should be made by splicing together the nodes of the first two lists.
*Gộp hai danh sách thành một danh sách **đã sắp xếp**. Danh sách này nên được tạo ra bằng cách nối các nút của hai danh sách ban đầu lại với nhau.*

Return the head of the merged linked list.
*Trả về đầu của danh sách liên kết đã gộp.*

## Example 1:
## *Ví dụ 1:*

**Input:** `list1 = [1,2,4]`, `list2 = [1,3,4]`
**Output:** `[1,1,2,3,4,4]`

## Example 2:
## *Ví dụ 2:*

**Input:** `list1 = []`, `list2 = []`
**Output:** `[]`

## Example 3:
## *Ví dụ 3:*

**Input:** `list1 = []`, `list2 = [0]`
**Output:** `[0]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in both lists is in the range `[0, 50]`.
*   `-100 <= Node.val <= 100`
*   Both `list1` and `list2` are sorted in **non-decreasing** order.
    *Cả `list1` và `list2` đều được sắp xếp theo thứ tự **không giảm**.*
