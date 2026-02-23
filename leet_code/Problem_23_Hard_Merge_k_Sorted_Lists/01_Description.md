# Result for Merge k Sorted Lists
# *Kết quả cho bài toán Gộp k Danh Sách Đã Sắp Xếp*

## Description
## *Mô tả*

You are given an array of `k` linked-lists `lists`, each linked-list is sorted in ascending order.
*Bạn được cho một mảng gồm `k` danh sách liên kết `lists`, mỗi danh sách liên kết được sắp xếp theo thứ tự tăng dần.*

Merge all the linked-lists into one sorted linked-list and return it.
*Gộp tất cả các danh sách liên kết thành một danh sách liên kết đã sắp xếp và trả về nó.*

## Example 1:
## *Ví dụ 1:*

**Input:** `lists = [[1,4,5],[1,3,4],[2,6]]`
**Output:** `[1,1,2,3,4,4,5,6]`
**Explanation:** The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

## Example 2:
## *Ví dụ 2:*

**Input:** `lists = []`
**Output:** `[]`

## Example 3:
## *Ví dụ 3:*

**Input:** `lists = [[]]`
**Output:** `[]`

## Constraints:
## *Ràng buộc:*

*   `k == lists.length`
*   `0 <= k <= 10^4`
*   `0 <= lists[i].length <= 500`
*   `-10^4 <= lists[i][j] <= 10^4`
*   `lists[i]` is sorted in **ascending order**.
*   The sum of `lists[i].length` will not exceed `10^4`.
