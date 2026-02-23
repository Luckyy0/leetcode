# Result for Flatten a Multilevel Doubly Linked List
# *Kết quả cho bài toán Làm phẳng Danh sách Liên kết Đôi đa cấp*

## Description
## *Mô tả*

You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional **child** pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.
*Bạn được cho một danh sách liên kết đôi, chứa các nút có con trỏ "tiếp theo" (next), con trỏ "trước đó" (previous), và một con trỏ **con** (child) bổ sung. Con trỏ con này có thể hoặc không trỏ tới một danh sách liên kết đôi riêng biệt, cũng chứa các nút đặc biệt này. Các danh sách con này có thể có một hoặc nhiều con riêng của chúng, và cứ thế, tạo thành một cấu trúc dữ liệu đa cấp như trong ví dụ dưới đây.*

Given the `head` of the first level of the list, **flatten** the list so that all the nodes appear in a single-level, doubly linked list. Let `curr` be a node with a child list. The nodes in the child list should appear **after** `curr` and **before** `curr.next` in the flattened list.
*Cho `head` của cấp đầu tiên của danh sách, hãy **làm phẳng** danh sách sao cho tất cả các nút xuất hiện trong một danh sách liên kết đôi cấp duy nhất. Giả sử `curr` là một nút có danh sách con. Các nút trong danh sách con phải xuất hiện **sau** `curr` và **trước** `curr.next` trong danh sách đã làm phẳng.*

Return *the `head` of the flattened list*.
*Hãy trả về *`head` của danh sách đã được làm phẳng*.*

## Example 1:
## *Ví dụ 1:*

**Input:** `head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]`
**Output:** `[1,2,3,7,8,11,12,9,10,4,5,6]`

## Constraints:
## *Ràng buộc:*

*   The number of nodes will not exceed `1000`.
*   `1 <= Node.val <= 10^5`
