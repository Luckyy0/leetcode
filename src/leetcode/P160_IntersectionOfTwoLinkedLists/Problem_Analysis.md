# 160. Intersection of Two Linked Lists / Giao Điểm Của Hai Danh Sách Liên Kết

## Problem Description / Mô tả bài toán
Given the heads of two singly linked-lists `headA` and `headB`, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return `null`.
Cho đầu của hai danh sách liên kết đơn `headA` và `headB`, hãy trả về nút mà tại đó hai danh sách giao nhau. Nếu hai danh sách liên kết hoàn toàn không có giao điểm, hãy trả về `null`.

For example, the following two linked lists begin to intersect at node `c1`:
Ví dụ, hai danh sách liên kết sau đây bắt đầu giao nhau tại nút `c1`:
```text
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
```

The test cases are generated such that there are no cycles anywhere in the entire linked structure.
Các bộ kiểm tra được tạo ra sao cho không có chu trình ở bất kỳ đâu trong toàn bộ cấu trúc liên kết.

**Note** that the linked lists must **retain their original structure** after the function returns.
**Lưu ý** rằng các danh sách liên kết phải **giữ nguyên cấu trúc ban đầu** sau khi hàm kết thúc.

### Constraints / Ràng buộc
- The number of nodes of `listA` is in the `m`.
- The number of nodes of `listB` is in the `n`.
- `1 <= m, n <= 3 * 10^4`
- `1 <= Node.val <= 10^5`
- `intersectVal` is `0` if `listA` and `listB` do not intersect.
- `intersectVal` exists in both `listA` and `listB` if they intersect.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Symmetry and Length Difference / Đối xứng và Chênh lệch Độ dài
The main challenge is that the two lists may have different lengths before they potentially intersect.
Thách thức chính là hai danh sách có thể có độ dài khác nhau trước khi chúng có thể giao nhau.

#### Method 1: Difference in Length / Chênh lệch Độ dài
- Calculate the lengths of both lists.
- Align the starting points by skipping the extra nodes in the longer list.
- Traverse together until nodes match.

#### Method 2: Two Pointers (Elegant Solution) / Hai Con Trỏ (Giải pháp Tối ưu)
- Use two pointers `pA` and `pB` starting at `headA` and `headB`.
- When `pA` reaches the end of `listA`, redirect it to `headB`.
- When `pB` reaches the end of `listB`, redirect it to `headA`.
- If they intersect, they will meet at the intersection point after at most `m + n` steps.
- **Why?** Because both pointers will eventually travel the same total distance: `lengthA + lengthB`.

---

## Analysis / Phân tích

### Approach: Two Pointers (Distance Alignment)

**Algorithm**:
1. Initialize `pA = headA` and `pB = headB`.
2. While `pA != pB`:
    - `pA = (pA == null) ? headB : pA.next`
    - `pB = (pB == null) ? headA : pB.next`
3. Return `pA` (it's either the intersection node or `null`).

### Complexity / Độ phức tạp
- **Time**: O(M + N) - each pointer travels at most two lists.
- **Space**: O(1) - constant memory.

---

## Edge Cases / Các trường hợp biên
1.  **No intersection**: Pointers both become `null` at the same time after redirected traversal.
2.  **Lists of same length**: Meet in the first pass.
3.  **One list is a suffix of another**: Meet correctly.
4.  **Intersection at the very first node**: Meet immediately.
