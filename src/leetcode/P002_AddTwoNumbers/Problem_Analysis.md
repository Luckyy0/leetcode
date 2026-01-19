# 2. Add Two Numbers / Cộng Hai Số

## Problem Description / Mô tả bài toán
You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
Bạn được cho hai danh sách liên kết **không rỗng** biểu diễn hai số nguyên không âm. Các chữ số được lưu trữ theo **thứ tự ngược**, và mỗi nút của chúng chứa một chữ số duy nhất. Cộng hai số và trả về tổng dưới dạng một danh sách liên kết.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Bạn có thể giả định rằng hai số không chứa bất kỳ số 0 nào ở đầu, ngoại trừ chính số 0.

### Example 1:
```text
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
```

### Example 2:
```text
Input: l1 = [0], l2 = [0]
Output: [0]
```

### Example 3:
```text
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
```

## Constraints / Ràng buộc
- The number of nodes in each linked list is in the range `[1, 100]`.
- `0 <= Node.val <= 9`
- It is guaranteed that the list represents a number that does not have leading zeros.

---

## Analysis / Phân tích

### Approach: Elementary Math / Toán sơ cấp
- **Idea**: Traverse both linked lists simultaneously, digit by digit. Keep track of a `carry`. At each step, calculate the sum `x + y + carry`. The new digit is `sum % 10`, and the new carry is `sum / 10`.
- **Ý tưởng**: Duyệt đồng thời cả hai danh sách liên kết, từng chữ số một. Theo dõi biến nhớ `carry`. Tại mỗi bước, tính tổng `x + y + carry`. Chữ số mới là `sum % 10`, và biến nhớ mới là `sum / 10`.
- **Handling Different Lengths**: If one list is shorter, assume its corresponding digits are 0.
- **Xử lý độ dài khác nhau**: Nếu một danh sách ngắn hơn, coi các chữ số tương ứng của nó là 0.
- **Time Complexity**: O(max(m, n)). We iterate at most max(m, n) times.
- **Space Complexity**: O(max(m, n)). The length of the new list is at most max(m, n) + 1.

---

## Sample Tests & Walkthrough / Bộ Test & Kiểm Thử Chi Tiết

### Walkthrough
**Input:** `l1 = [2, 4, 3]`, `l2 = [5, 6, 4]` (342 + 465)

| Step | l1 Value | l2 Value | Carry In | Sum | New Carry | New Node Val | Result List |
|---|---|---|---|---|---|---|---|
| 1 | 2 | 5 | 0 | 7 | 0 | 7 | `7` |
| 2 | 4 | 6 | 0 | 10 | 1 | 0 | `7 -> 0` |
| 3 | 3 | 4 | 1 | 8 | 0 | 8 | `7 -> 0 -> 8` |
| End | null | null | 0 | - | - | - | Return `[7, 0, 8]` |

### Edge Case: Carry at the end
**Input:** `l1 = [9, 9]`, `l2 = [1]` (99 + 1)

| Step | l1 Value | l2 Value | Carry In | Sum | New Carry | New Node Val | Result List |
|---|---|---|---|---|---|---|---|
| 1 | 9 | 1 | 0 | 10 | 1 | 0 | `0` |
| 2 | 9 | 0 | 1 | 10 | 1 | 0 | `0 -> 0` |
| 3 | 0 | 0 | 1 | 1 | 0 | 1 | `0 -> 0 -> 1` |
| End | - | - | - | - | - | - | Return `[0, 0, 1]` |
