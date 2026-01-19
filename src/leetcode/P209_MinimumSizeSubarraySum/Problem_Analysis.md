# 209. Minimum Size Subarray Sum / Kích thước Tối thiểu của Mảng con có Tổng

## Problem Description / Mô tả bài toán
Given an array of positive integers `nums` and a positive integer `target`, return the minimal length of a **subarray** whose sum is greater than or equal to `target`. If there is no such subarray, return `0` instead.
Cho một mảng các số nguyên dương `nums` và một số nguyên dương `target`, hãy trả về độ dài tối thiểu của một **mảng con** có tổng lớn hơn hoặc bằng `target`. Nếu không có mảng con nào như vậy, hãy trả về `0`.

### Example 1:
```text
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
```

### Example 2:
```text
Input: target = 4, nums = [1,4,4]
Output: 1
```

### Example 3:
```text
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
```

## Constraints / Ràng buộc
- `1 <= target <= 10^9`
- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^4`

**Follow up**: If you have figured out the `O(n)` solution, try coding another solution of which the time complexity is `O(n log n)`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Sliding Window (Two Pointers) / Cửa sổ trượt (Hai con trỏ)
Since all numbers are **positive**, the sum of a subarray increases as we extend to the right and decreases as we shrink from the left.
Vì tất cả các số đều **dương**, tổng của một mảng con tăng lên khi chúng ta mở rộng sang phải và giảm đi khi chúng ta thu hẹp từ trái.

1.  Use `left` pointer fixed at 0.
2.  Expand `right` pointer and add `nums[right]` to `currentSum`.
3.  While `currentSum >= target`:
    - Update `minLength = min(minLength, right - left + 1)`.
    - Subtract `nums[left]` from `currentSum`.
    - Increment `left`.
4.  Return `minLength` (or 0 if not found).

This approach is **O(N)**.

### Binary Search O(n log n)
Compute `prefixSum` array. For each `i`, binary search for the smallest `j >= i` such that `prefixSum[j] - prefixSum[i] >= target`.

---

## Analysis / Phân tích

### Approach: Sliding Window

**Complexity / Độ phức tạp**:
- **Time**: O(N) - Each element is added once and removed at most once.
- **Space**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **Total sum < target**: Return 0.
2.  **Single element >= target**: Return 1.
3.  **Entire array = target**: Return N.
