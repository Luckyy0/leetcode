# Result for Linked List Random Node
# *Kết quả cho bài toán Nút Ngẫu nhiên trong Danh sách Liên kết*

## Description
## *Mô tả*

Given a singly linked list, return a random node's value from the linked list. Each node must have the **same probability** of being chosen.
*Cho một danh sách liên kết đơn, hãy trả về giá trị của một nút ngẫu nhiên từ danh sách đó. Mỗi nút phải có **cùng xác suất** được chọn.*

Implement the `Solution` class:
*Thực hiện lớp `Solution`:*

*   `Solution(ListNode head)` Initializes the object with the head of the singly-linked list `head`.
    *`Solution(ListNode head)` Khởi tạo đối tượng với đầu của danh sách liên kết đơn `head`.*
*   `int getRandom()` Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be chosen.
    *`int getRandom()` Chọn ngẫu nhiên một nút từ danh sách và trả về giá trị của nó. Tất cả các nút trong danh sách phải có khả năng được chọn như nhau.*

## Example 1:
## *Ví dụ 1:*

**Input:**
`["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]`
`[[[1, 2, 3]], [], [], [], [], []]`
**Output:**
`[null, 1, 3, 2, 2, 3]`

**Explanation:**
```java
Solution solution = new Solution([1, 2, 3]);
solution.getRandom(); // return 1
solution.getRandom(); // return 3
solution.getRandom(); // return 2
solution.getRandom(); // return 2
solution.getRandom(); // return 3
// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
```

## Constraints:
## *Ràng buộc:*

*   The number of nodes in the linked list will be in the range `[1, 10^4]`.
*   `-10^4 <= Node.val <= 10^4`
*   At most `10^4` calls will be made to `getRandom`.

**Follow up:**
*   What if the linked list is extremely large and its length is unknown to you?
*   Could you solve this efficiently without using extra space?
*   *Điều gì xảy ra nếu danh sách liên kết cực kỳ lớn và bạn không biết độ dài của nó?*
*   *Bạn có thể giải quyết vấn đề này một cách hiệu quả mà không sử dụng thêm không gian không?*
