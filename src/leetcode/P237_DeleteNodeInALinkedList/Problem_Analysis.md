# 237. Delete Node in a Linked List / Xóa Nút trong Danh Sách Liên Kết

## Problem Description / Mô tả bài toán
There is a singly-linked list `head` and we want to delete a node `node` in it.
Có một danh sách liên kết đơn `head` và chúng ta muốn xóa một nút `node` trong đó.

You are given the node to be deleted `node`. You will **not be given access** to the first node of `head`.
Bạn được cung cấp nút cần xóa `node`. Bạn sẽ **không được cấp quyền truy cập** vào nút đầu tiên của `head`.

All the values of the linked list are **unique**, and it is guaranteed that the given node `node` is not the last node in the linked list.
Tất cả các giá trị của danh sách liên kết là **duy nhất**, và đảm bảo rằng nút `node` được cho không phải là nút cuối cùng trong danh sách liên kết.

Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
Xóa nút đã cho. Lưu ý rằng bằng cách xóa nút, chúng tôi không có ý nói là xóa nó khỏi bộ nhớ. Ý chúng tôi là:
- The value of the given node should not exist in the linked list.
- Giá trị của nút đã cho không nên tồn tại trong danh sách liên kết.
- The number of nodes in the linked list should decrease by one.
- Số lượng nút trong danh sách liên kết sẽ giảm đi một.
- All the values before `node` should be in the same order.
- Tất cả các giá trị trước `node` nên giữ nguyên thứ tự.
- All the values after `node` should be in the same order.
- Tất cả các giá trị sau `node` nên giữ nguyên thứ tự.

### Example 1:
```text
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
```

### Example 2:
```text
Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
```

## Constraints / Ràng buộc
- The number of the nodes in the given list is in the range `[2, 1000]`.
- `-1000 <= Node.val <= 1000`
- The value of each node in the list is **unique**.
- The `node` to be deleted is **in the list** and is **not a tail** node.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Data Copying / Sao Chép Dữ Liệu
Since we do not have access to the `head` of the list, we cannot iterate to find the **predecessor** (node before the target) to adjust its `next` pointer.
Normally, to delete `node`, we do `prev.next = node.next`.

Since we cannot get `prev`, we must act on `node` itself.
We can copy the **value** of `node.next` into `node.val`.
Then, `node` effectively becomes a copy of `node.next`.
Finally, we calculate `node.next = node.next.next` to remove the original `node.next` from the chain.

Essentially, we "become" the next node and delete the next node (which is now duplicate).

---

## Analysis / Phân tích

### Approach: Copy Next Node Value

**Algorithm**:
1.  `node.val = node.next.val` (Overwrite current value with next value).
2.  `node.next = node.next.next` (Skip the next node).

### Complexity / Độ phức tạp
- **Time**: O(1) - Constant number of operations.
- **Space**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Tail node**: Problem guarantee says node is NOT tail. If it were, this method fails (cannot copy next).
2.  **Two nodes**: Works.
