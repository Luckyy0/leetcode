# Result for Split Linked List in Parts
# *Kết quả cho bài toán Chia Danh sách Liên kết thành các Phần*

## Description
## *Mô tả*

Given the `head` of a singly linked list and an integer `k`, split the linked list into `k` consecutive linked list parts.
*Cho đầu (`head`) của một danh sách liên kết đơn và một số nguyên `k`, hãy chia danh sách liên kết thành `k` phần liên tiếp.*

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being `null`.
*Độ dài của mỗi phần nên bằng nhau nhất có thể: không có hai phần nào có kích thước chênh lệch quá một đơn vị. Điều này có thể dẫn đến việc một số phần có giá trị `null`.*

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.
*Các phần nên theo thứ tự xuất hiện trong danh sách đầu vào, và các phần xuất hiện trước nên luôn có kích thước lớn hơn hoặc bằng các phần xuất hiện sau.*

Return an array of the `k` parts.
*Hãy trả về một mảng chứa `k` phần đó.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** head = [1,2,3], k = 5
**Output:** [[1],[2],[3],[],[]]
**Explanation:**
The first three elements each go into separate parts, and the last two parts are null.

## Example 2:
## *Ví dụ 2:*

**Input:** head = [1,2,3,4,5,6,7,8,9,10], k = 3
**Output:** [[1,2,3,4],[5,6,7],[8,9,10]]
**Explanation:**
The head is split into three parts, where size is as equal as possible. The first part has size 4, and the others have size 3.

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the list is in the range `[0, 1000]`.
*   `0 <= Node.val <= 1000`
*   `1 <= k <= 50`
