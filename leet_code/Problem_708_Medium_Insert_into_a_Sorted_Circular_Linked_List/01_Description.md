# Result for Insert into a Sorted Circular Linked List
# *Kết quả cho bài toán Chèn vào Danh sách Liên kết Vòng đã sắp xếp*

## Description
## *Mô tả*

Given a node from a **Circular Linked List** which is sorted in non-descending order, write a function to insert a value `insertVal` into the list such that it remains a sorted circular list.
*Cho một nút từ một **Danh sách Liên kết Vòng** đã được sắp xếp theo thứ tự không giảm, hãy viết một hàm để chèn một giá trị `insertVal` vào danh sách sao cho nó vẫn là một danh sách vòng đã sắp xếp.*

The given node can be a reference to any single node in the list and may not necessarily be the smallest value in the circular list.
*Nút được cho có thể là tham chiếu đến bất kỳ nút đơn nào trong danh sách và không nhất thiết phải là giá trị nhỏ nhất.*

If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the circular list should remain sorted.
*Nếu có nhiều vị trí thích hợp để chèn, bạn có thể chọn bất kỳ vị trí nào. Sau khi chèn, danh sách v phải vẫn được sắp xếp.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** head = [3,4,1], insertVal = 2
**Output:** [3,4,1,2]
**Explanation:** The list initially is [1, 3, 4]. After inserting 2, the list is [1, 2, 3, 4].

## Example 2:
## *Ví dụ 2:*

**Input:** head = [], insertVal = 1
**Output:** [1]
**Explanation:** The list is empty (null). Inserting 1 creates a single-node circular list.

---

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the list is in the range `[0, 5000]`.
*   `-10^6 <= Node.val, insertVal <= 10^6`
