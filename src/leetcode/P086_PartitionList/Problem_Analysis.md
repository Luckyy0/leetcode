# 86. Partition List / Phân Vùng Danh Sách

## Problem Description / Mô tả bài toán
Given the `head` of a linked list and a value `x`, partition it such that all nodes **less than** `x` come before nodes **greater than or equal to** `x`.
Cho `head` của một danh sách liên kết và một giá trị `x`, hãy phân vùng nó sao cho tất cả các nút **nhỏ hơn** `x` đứng trước các nút **lớn hơn hoặc bằng** `x`.

You should **preserve** the original relative order of the nodes in each of the two partitions.
Bạn nên **bảo tồn** thứ tự tương đối ban đầu của các nút trong cả hai phân vùng.

### Example 1:
```text
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
```

### Example 2:
```text
Input: head = [2,1], x = 2
Output: [1,2]
```

## Constraints / Ràng buộc
- `0 <= The number of nodes <= 200`
- `-100 <= Node.val <= 100`
- `-200 <= x <= 200`

---

## Analysis / Phân tích

### Approach: Two Pointers (Small & Large Lists) / Hai Con Trỏ (Danh Sách Nhỏ & Lớn)
- **Idea**: Maintain two separate lists: `lessVal` and `greaterOrEqualVal`.
- **Ý tưởng**: Duy trì hai danh sách riêng biệt: `lessVal` và `greaterOrEqualVal`.
- **Algorithm**:
    - `beforeHead`, `before`
    - `afterHead`, `after`
    - Iterate through original list:
        - If `node.val < x`: Append to `before`, move `before`.
        - Else: Append to `after`, move `after`.
    - `after.next = null` (Important! Cut off any remaining links).
    - `before.next = afterHead.next`.
    - Return `beforeHead.next`.
- **Time Complexity**: O(N).
- **Space Complexity**: O(1) (reusing nodes).

---

## Edge Cases / Các trường hợp biên
1.  **Empty List**: Return null.
2.  **All < x**: `after` list empty.
3.  **All >= x**: `before` list empty.
