# 456. 132 Pattern / Mẫu 132

## Problem Description / Mô tả bài toán
Given an array of `n` integers `nums`, a **132 pattern** is a subsequence of three integers `nums[i]`, `nums[j]` and `nums[k]` such that `i < j < k` and `nums[i] < nums[k] < nums[j]`.
Cho một mảng `n` số nguyên `nums`, một **mẫu 132** là một dãy con gồm ba số nguyên `nums[i]`, `nums[j]` và `nums[k]` sao cho `i < j < k` và `nums[i] < nums[k] < nums[j]`.

Return `true` if there is a **132 pattern** in `nums`, otherwise, return `false`.
Trả về `true` nếu có một **mẫu 132** trong `nums`, ngược lại trả về `false`.

### Example 1:
```text
Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
```

### Example 2:
```text
Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
```

### Example 3:
```text
Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
```

## Constraints / Ràng buộc
- `n == nums.length`
- `1 <= n <= 2 * 10^5`
- `-10^9 <= nums[i] <= 10^9`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Monotonic Stack / Ngăn xếp Đơn điệu
To efficiently find if such a pattern exists, we need to find `i, j, k` such that `nums[i]` is the minimum, and `nums[j]` is the maximum.
A clever way is to find a potential `nums[k]` (the "2" in "132") by scanning from right to left.

Algorithm:
1. Maintain a variable `num3` (which represents the "2") initialized to ` -infinity `.
2. Maintain a `Stack` that stores potential values for `nums[j]` (the "3"). The stack will be used to maintain values in decreasing order from top to bottom (Monotonic Stack).
3. Traverse the array from **right to left**:
   - If `nums[i] < num3`, we have found a 132 pattern! (Since `num3` was popped from the stack, there must be some `nums[j]` such that `nums[j] > num3`).
   - While the stack is not empty and `nums[i] > stack.peek()`:
     - The current `stack.peek()` is a potential "2". Update `num3 = stack.pop()`.
   - Push `nums[i]` onto the stack (as a potential "3").
4. Return `false` if the loop finishes without finding a pattern.

### Complexity / Độ phức tạp
- **Time**: O(N) as each element is pushed and popped at most once.
- **Space**: O(N) for the stack.

---

## Analysis / Phân tích

### Approach: Right-to-Left Monotonic Stack

**Algorithm**:
1.  Initialize `num3 = Min`.
2.  Iterate backwards.
3.  Check pattern, update stack, update `num3`.

---
