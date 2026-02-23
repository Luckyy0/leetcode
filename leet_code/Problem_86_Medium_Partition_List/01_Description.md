# Result for Partition List
# *Kết quả cho bài toán Phân Tách Danh Sách*

## Description
## *Mô tả*

Given the `head` of a linked list and a value `x`, partition it such that all nodes **less than** `x` come before nodes **greater than or equal to** `x`.
*Cho `head` của một danh sách liên kết và một giá trị `x`, hãy phân tách nó sao cho tất cả các nút **nhỏ hơn** `x` đứng trước các nút **lớn hơn hoặc bằng** `x`.*

You should **preserve** the original relative order of the nodes in each of the two partitions.
*Bạn nên **giữ nguyên** thứ tự tương đối ban đầu của các nút trong mỗi phần trong hai phần đó.*

## Example 1:
## *Ví dụ 1:*

**Input:** `head = [1,4,3,2,5,2], x = 3`
**Output:** `[1,2,2,4,3,5]`

## Example 2:
## *Ví dụ 2:*

**Input:** `head = [2,1], x = 2`
**Output:** `[1,2]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the list is in the range `[0, 200]`.
*   `-100 <= Node.val <= 100`
*   `-200 <= x <= 200`
