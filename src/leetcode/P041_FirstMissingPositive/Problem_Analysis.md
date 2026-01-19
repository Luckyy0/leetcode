# 41. First Missing Positive / Số Nguyên Dương Thiếu Đầu Tiên

## Problem Description / Mô tả bài toán
Given an unsorted integer array `nums`, return the smallest missing positive integer.
Cho một mảng số nguyên chưa được sắp xếp `nums`, trả về số nguyên dương bị thiếu nhỏ nhất.

You must implement an algorithm that runs in `O(n)` time and uses `O(1)` auxiliary space.
Bạn phải cài đặt một thuật toán chạy trong thời gian `O(n)` và sử dụng không gian phụ trợ `O(1)`.

### Example 1:
```text
Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
```

### Example 2:
```text
Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
```

### Example 3:
```text
Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 5 * 10^5`
- `-2^31 <= nums[i] <= 2^31 - 1`

---

## Analysis / Phân tích

### Approach: Cycle Sort (In-place Swap) / Sắp Xếp Vòng (Hoán Đổi Tại Chỗ)
- **Idea**: We want to put `1` at index `0`, `2` at index `1`, etc. So `nums[i]` should be `i + 1`.
- **Ý tưởng**: Chúng ta muốn đặt `1` tại chỉ số `0`, `2` tại chỉ số `1`, v.v. Vì vậy `nums[i]` nên là `i + 1`.
- **Algorithm**:
    1.  Iterate `i` from 0 to `n-1`.
    2.  While `nums[i]` is in the valid range `[1, n]` AND `nums[i]` is not at its correct position (`nums[nums[i] - 1] != nums[i]`):
        - Swap `nums[i]` with `nums[nums[i] - 1]`.
    3.  Iterate `i` from 0 to `n-1`. The first index where `nums[i] != i + 1` is the missing number `i + 1`.
    4.  If all indices match, the missing number is `n + 1`.
- **Time Complexity**: O(n). Each number is swapped at most once to its correct position.
- **Space Complexity**: O(1). Modifying input array.

---

## Edge Cases / Các trường hợp biên
1.  **Empty**: (Constraint len >= 1).
2.  **No Positives**: `[-1, -2]` -> 1.
3.  **Sorted**: `[1, 2, 3]` -> 4.
