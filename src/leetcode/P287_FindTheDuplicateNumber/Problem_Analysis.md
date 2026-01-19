# 287. Find the Duplicate Number / Tìm Số Trùng Lặp

## Problem Description / Mô tả bài toán
Given an array of integers `nums` containing `n + 1` integers where each integer is in the range `[1, n]` inclusive.
Cho một mảng các số nguyên `nums` chứa `n + 1` số nguyên trong đó mỗi số nguyên nằm trong khoảng `[1, n]` bao gồm cả hai đầu mút.

There is only **one repeated number** in `nums`, return this repeated number.
Chỉ có **một số lặp lại** trong `nums`, hãy trả về số lặp lại này.

You must solve the problem **without** modifying the array `nums` and uses only constant extra space.
Bạn phải giải quyết vấn đề **mà không** sửa đổi mảng `nums` và chỉ sử dụng không gian phụ hằng số.

### Example 1:
```text
Input: nums = [1,3,4,2,2]
Output: 2
```

### Example 2:
```text
Input: nums = [3,1,3,4,2]
Output: 3
```

## Constraints / Ràng buộc
- `1 <= n <= 10^5`
- `nums.length == n + 1`
- `1 <= nums[i] <= n`
- All the integers in `nums` appear only once except for precisely one integer which appears two or more times.

**Follow up**:
- How can we prove that at least one duplicate number must exist? (Pigeonhole Principle).
- Can you solve it in linear runtime complexity?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Linked List Cycle Detection (Floyd's Tortoise and Hare) / Phát Hiện Chu Trình (Rùa và Thỏ)
Since values are in `[1, n]`, we can treat `nums` as a pointer mapping: `index` -> `nums[index]`.
- Node 0 points to `nums[0]`.
- Node `val` points to `nums[val]`.
Since there is a duplicate number, 2 indices point to the same value (or rather, the value `X` appears twice, so if we view indices as nodes and `nums[i]` as next pointer...). Wait.
Mapping `i -> nums[i]`.
If we have duplicate value `X`, then there are indices `a` and `b` such that `nums[a] = X` and `nums[b] = X`.
This means nodes `a` and `b` both point to node `X`? No.
Actually, graph is `0 -> nums[0] -> nums[nums[0]] ...`.
Since range is `[1, n]`, index `0` is never a target (values start at 1). So `0` is the entry point.
The cycle occurs because multiple nodes point to the entrance of the cycle.
The duplicate number is the **start of the cycle**.

**Algorithm**:
1.  `slow = nums[0]`, `fast = nums[0]`.
2.  Phase 1:
    - `slow = nums[slow]`.
    - `fast = nums[nums[fast]]`.
    - Repeat until `slow == fast`.
3.  Phase 2:
    - `slow = nums[0]`.
    - `fast` stays at meeting point.
    - Move both one step at a time: `slow = nums[slow]`, `fast = nums[fast]`.
    - They meet at the **Entrance of Cycle** (the duplicate number).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Floyd's Algorithm

**Edge Cases**:
1.  **Multiple duplicates?** Problem says "precisely one integer... appears two or more times". So only one value is duplicated.

---
