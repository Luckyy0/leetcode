# 16. 3Sum Closest / Tổng Ba Số Gần Nhất

## Problem Description / Mô tả bài toán
Given an integer array `nums` of length `n` and an integer `target`, find three integers in `nums` such that the sum is closest to `target`.
Cho một mảng số nguyên `nums` có độ dài `n` và một số nguyên `target`, tìm ba số nguyên trong `nums` sao cho tổng của chúng gần nhất với `target`.

Return the sum of the three integers.
Trả về tổng của ba số nguyên đó.

You may assume that each input would have exactly one solution.
Bạn có thể giả định rằng mỗi đầu vào sẽ có chính xác một giải pháp.

### Example 1:
```text
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
```

### Example 2:
```text
Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
```

## Constraints / Ràng buộc
- `3 <= nums.length <= 1000`
- `-1000 <= nums[i] <= 1000`
- `-10^4 <= target <= 10^4`

---

## Analysis / Phân tích

### Approach: Sorting + Two Pointers / Sắp xếp + Hai con trỏ
- **Idea**: Similar to 3Sum, we sort the array and use two pointers.
- **Ý tưởng**: Tương tự như 3Sum, chúng ta sắp xếp mảng và sử dụng hai con trỏ.
- We iterate `i` from 0 to n-2.
- Set `lo = i + 1`, `hi = n - 1`.
- Calculate `sum = nums[i] + nums[lo] + nums[hi]`.
- If `abs(target - sum) < abs(target - closestSum)`, update `closestSum`.
- If `sum < target`, `lo++` (we need a larger sum).
- If `sum > target`, `hi--` (we need a smaller sum).
- If `sum == target`, return `sum` immediately (diff is 0).
- **Time Complexity**: O(n^2). Sorting is O(n log n), loop is O(n^2).
- **Space Complexity**: O(log n) or O(n) for sorting.

---

## Edge Cases / Các trường hợp biên
1.  **Exact Match**: Return immediately.
2.  **All Positive/Negative**: Logic holds.
3.  **Small Array**: n=3, logic holds.
