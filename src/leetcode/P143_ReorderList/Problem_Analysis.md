# 143. Reorder List / Sắp xếp lại Danh sách

## Problem Description / Mô tả bài toán
You are given the head of a singly linked-list. The list can be represented as:
Bạn được cho đầu của một danh sách liên kết đơn. Danh sách có thể được biểu diễn như sau:

`L0 → L1 → … → Ln - 1 → Ln`

Reorder the list to be on the following form:
Sắp xếp lại danh sách theo dạng sau:

`L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …`

You may not modify the values in the list's nodes. Only nodes themselves may be changed.
Bạn không được sửa đổi các giá trị trong các nút của danh sách. Chỉ các nút mới có thể được thay đổi.

### Example 1:
```text
Input: head = [1,2,3,4]
Output: [1,4,2,3]
```

### Example 2:
```text
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
```

## Constraints / Ràng buộc
- The number of nodes in the list is in the range `[1, 5 * 10^4]`.
- `1 <= Node.val <= 1000`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Divide and Conquer-like Strategy / Chiến lược kiểu Chia để Trị
To achieve the `L0 -> Ln -> L1 -> Ln-1 ...` pattern, we can divide the task:
Để đạt được mẫu `L0 -> Ln -> L1 -> Ln-1 ...`, chúng ta có thể chia nhỏ nhiệm vụ:
1.  **Find the middle** of the linked list using slow/fast pointers.
2.  **Reverse the second half** of the list.
3.  **Merge the two halves** by alternating nodes.

---

## Analysis / Phân tích

### Approach: Triple Step - Find Mid, Reverse, Merge / Ba Bước - Tìm Trung điểm, Đảo ngược, Trộn

**Complexity / Độ phức tạp**:
- **Time**: O(N) - N/2 to find mid, N/2 to reverse, N to merge.
- **Space**: O(1) - only pointers used.

---

## Edge Cases / Các trường hợp biên
1.  **Length 1 or 2**: Already satisfies or simple swap.
2.  **Odd vs Even length**: Pointers handle termination.
3.  **Large list**: Linear complexity is optimal.
