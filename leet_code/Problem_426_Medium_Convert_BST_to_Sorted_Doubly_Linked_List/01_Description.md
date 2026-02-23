# Result for Convert Binary Search Tree to Sorted Doubly Linked List
# *Kết quả cho bài toán Chuyển đổi Cây Tìm kiếm Nhị phân thành Danh sách Liên kết Đôi có thứ tự*

## Description
## *Mô tả*

Convert a **Binary Search Tree** to a sorted **Circular Doubly Linked List** in-place.
*Hãy chuyển đổi một **Cây Tìm kiếm Nhị phân** thành một **Danh sách Liên kết Đôi Vòng** có thứ tự tại chỗ (in-place).*

The left and right pointers in nodes are to be used as previous and next pointers respectively in the converted doubly linked list. The nodes in the doubly linked list should be in sorted order.
*Các con trỏ trái và phải trong các nút sẽ được sử dụng tương ứng làm con trỏ "trước đó" (previous) và "tiếp theo" (next) trong danh sách liên kết đôi đã chuyển đổi. Các nút trong danh sách liên kết đôi phải theo thứ tự đã được sắp xếp.*

For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
*Đối với một danh sách liên kết đôi vòng, phần tử đứng trước phần tử đầu tiên là phần tử cuối cùng, và phần tử đứng sau phần tử cuối cùng là phần tử đầu tiên.*

## Example 1:
## *Ví dụ 1:*

**Input:** `root = [4,2,5,1,3]`
**Output:** `[1,2,3,4,5]` (Circularly linked)

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the tree is in the range `[0, 2000]`.
*   `-1000 <= Node.val <= 1000`
*   All the values of the nodes in the tree are **unique**.
