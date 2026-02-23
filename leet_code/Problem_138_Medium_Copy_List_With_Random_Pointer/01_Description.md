# Result for Copy List with Random Pointer
# *Kết quả cho bài toán Sao Chép Danh Sách Với Con Trỏ Ngẫu Nhiên*

## Description
## *Mô tả*

A linked list of length `n` is given such that each node contains an additional random pointer, which could point to any node in the list, or `null`.
*Một danh sách liên kết có độ dài `n` được cho sẵn sao cho mỗi nút chứa thêm một con trỏ ngẫu nhiên (random), con trỏ này có thể trỏ tới bất kỳ nút nào trong danh sách hoặc trỏ tới `null`.*

Construct a **deep copy** of the list. The deep copy should consist of exactly `n` brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the `next` and `random` pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. **None of the pointers in the new list should point to nodes in the original list.**
*Xây dựng một **bản sao sâu (deep copy)** của danh sách. Bản sao sâu phải bao gồm đúng `n` nút hoàn toàn mới, trong đó mỗi nút mới có giá trị được đặt thành giá trị của nút gốc tương ứng. Cả con trỏ `next` và `random` của các nút mới đều phải trỏ đến các nút mới trong danh sách sao chép sao cho các con trỏ trong danh sách gốc và danh sách sao chép đại diện cho cùng một trạng thái danh sách. **Không có con trỏ nào trong danh sách mới được trỏ đến các nút trong danh sách gốc.***

For example, if there are two nodes `X` and `Y` in the original list, where `X.random --> Y`, then for the corresponding two nodes `x` and `y` in the copied list, `x.random --> y`.
*Ví dụ, nếu có hai nút `X` và `Y` trong danh sách gốc, trong đó `X.random --> Y`, thì đối với hai nút tương ứng `x` và `y` trong danh sách sao chép, `x.random --> y`.*

Return *the head of the copied linked list*.
*Trả về *đầu (head) của danh sách liên kết đã sao chép.***

The linked list is represented in the input/output as a list of `n` nodes. Each node is represented as a pair of `[val, random_index]` where:
- `val`: an integer representing the value of the node.
- `random_index`: the index of the node (range from `0` to `n-1`) that the `random` pointer points to, or `null` if it does not point to any node.
Your code will only be given the `head` of the original linked list.

## Example 1:
## *Ví dụ 1:*

**Input:** `head = [[7,null],[13,0],[11,4],[10,2],[1,0]]`
**Output:** `[[7,null],[13,0],[11,4],[10,2],[1,0]]`

## Example 2:
## *Ví dụ 2:*

**Input:** `head = [[1,1],[2,1]]`
**Output:** `[[1,1],[2,1]]`

## Example 3:
## *Ví dụ 3:*

**Input:** `head = [[3,null],[3,0],[3,null]]`
**Output:** `[[3,null],[3,0],[3,null]]`

## Constraints:
## *Ràng buộc:*

*   `0 <= n <= 1000`
*   `-10000 <= Node.val <= 10000`
*   `Node.random` is `null` or is pointing to some node in the linked list.
