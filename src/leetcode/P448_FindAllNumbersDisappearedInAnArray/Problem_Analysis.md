# 448. Find All Numbers Disappeared in an Array / Tìm Tất Cả Các Số Biến Mất Trong Mảng

## Problem Description / Mô tả bài toán
Given an array `nums` of `n` integers where `nums[i]` is in the range `[1, n]`, return an array of all the integers in the range `[1, n]` that do not appear in `nums`.
Cho một mảng `nums` gồm `n` số nguyên trong đó `nums[i]` nằm trong phạm vi `[1, n]`, hãy trả về một mảng chứa tất cả các số nguyên trong phạm vi `[1, n]` không xuất hiện trong `nums`.

### Example 1:
```text
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
```

### Example 2:
```text
Input: nums = [1,1]
Output: [2]
```

## Constraints / Ràng buộc
- `n == nums.length`
- `1 <= n <= 10^5`
- `1 <= nums[i] <= n`

### Follow up:
Can you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Index as Marker / Chỉ số như cờ đánh dấu
Exactly like problem 442, we can use the array itself to track seen values.
Since the values are in range `[1, n]`, for each value `x` in the array, we go to index `abs(x) - 1` and mark it by making it negative.

Algorithm:
1. Iterate through `nums`:
   - `idx = abs(nums[i]) - 1`.
   - `nums[idx] = -abs(nums[idx])`. (Ensure it's negative).
2. Iterate through `nums` again:
   - If `nums[i] > 0`, it means index `i` was never visited/marked.
   - The value `i + 1` is missing. Add to result list.
3. Return result.

### Complexity / Độ phức tạp
- **Time**: O(N) for two passes.
- **Space**: O(1) (in-place modification).

---

## Analysis / Phân tích

### Approach: In-Place Marking

**Algorithm**:
1.  First pass: Flip sign at `nums[val - 1]`.
2.  Second pass: Identify positive indices.

---
