# Result for Add Two Numbers
# *Kết quả cho bài toán Cộng Hai Số*

## Description
## *Mô tả*

You are given two **non-empty** linked lists representing two non-negative integers.
*Bạn được cho hai danh sách liên kết **không rỗng** đại diện cho hai số nguyên không âm.*

The digits are stored in **reverse order**, and each of their nodes contains a single digit.
*Các chữ số được lưu trữ theo **thứ tự ngược**, và mỗi nút của chúng chứa một chữ số duy nhất.*

Add the two numbers and return the sum as a linked list.
*Hãy cộng hai số này và trả về tổng dưới dạng một danh sách liên kết.*

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*Bạn có thể giả định rằng hai số này không chứa bất kỳ số 0 nào ở đầu, ngoại trừ chính số 0.*

## Example 1:
## *Ví dụ 1:*

**Input:** `l1 = [2,4,3]`, `l2 = [5,6,4]`
**Output:** `[7,0,8]`
**Explanation:** 342 + 465 = 807.
***Giải thích:** 342 + 465 = 807.*

## Example 2:
## *Ví dụ 2:*

**Input:** `l1 = [0]`, `l2 = [0]`
**Output:** `[0]`

## Example 3:
## *Ví dụ 3:*

**Input:** `l1 = [9,9,9,9,9,9,9]`, `l2 = [9,9,9,9]`
**Output:** `[8,9,9,9,0,0,0,1]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes in each linked list is in the range `[1, 100]`.
    *SOLượng nút trong mỗi danh sách liên kết nằm trong khoảng `[1, 100]`.*
*   `0 <= Node.val <= 9`
*   It is guaranteed that the list represents a number that does not have leading zeros.
    *Đảm bảo rằng danh sách đại diện cho một số không có số 0 ở đầu.*
