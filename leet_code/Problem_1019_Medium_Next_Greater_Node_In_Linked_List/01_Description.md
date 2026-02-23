# Result for Next Greater Node In Linked List
# *Kết quả cho bài toán Nút Lớn hơn Tiếp theo trong Danh sách Liên kết*

## Description
## *Mô tả*

You are given the `head` of a linked list with `n` nodes.
*Bạn được cung cấp `head` (nút đầu) của một danh sách liên kết có `n` nút.*

For each node in the list, find the value of the **next strictly greater** node. That is, for each node, find the value of the first node that is next to it and has a **strictly larger** value than it.
*Đối với mỗi nút trong danh sách, hãy tìm giá trị của nút **lớn hơn nghiêm ngặt tiếp theo**. Nghĩa là, đối với mỗi nút, tìm giá trị của nút đầu tiên nằm sau nó và có giá trị **lớn hơn hẳn** nó.*

Return an integer array `answer` where `answer[i]` is the value of the next greater node of the `i`-th node (1-indexed). If the `i`-th node does not have a next greater node, set `answer[i] = 0`.
*Trả về một mảng số nguyên `answer` trong đó `answer[i]` là giá trị của nút lớn hơn tiếp theo của nút thứ `i` (chỉ số tính từ 1). Nếu nút thứ `i` không có nút nào lớn hơn ở phía sau, đặt `answer[i] = 0`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** head = [2,1,5]
**Output:** [5,5,0]
**Explanation:** 
- The next strictly greater element to 2 is 5.
- The next strictly greater element to 1 is 5.
- The next strictly greater element to 5 does not exist, so it's 0.
*Giải thích:*
*- Sau số 2, số lớn hơn đầu tiên là 5.*
*- Sau số 1, số lớn hơn đầu tiên là 5.*
*- Phía sau số 5 chẳng còn ai lớn hơn, nên là 0.*

## Example 2:
## *Ví dụ 2:*

**Input:** head = [2,7,4,3,5]
**Output:** [7,0,5,5,0]
**Explanation:** 
- Next to 2 is 7.
- Next to 7 is nothing greater (0).
- Next to 4 is 5.
- Next to 3 is 5.
- Next to 5 is nothing (0).

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the list is `n`.
*   `1 <= n <= 10^4`
*   `1 <= Node.val <= 10^9`
