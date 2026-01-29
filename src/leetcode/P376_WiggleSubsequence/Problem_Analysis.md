# 376. Wiggle Subsequence / Dãy Con Lắc Lư

## Problem Description / Mô tả bài toán
A **wiggle sequence** is a sequence where the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with one element and a sequence with two non-equal elements are trivially wiggle sequences.
Một **dãy con lắc lư** là một dãy mà hiệu giữa các số liên tiếp xen kẽ chặt chẽ giữa dương và âm.

Given an integer array `nums`, return the length of the longest **wiggle subsequence**.
Cho một mảng số nguyên `nums`, trả về độ dài của **dãy con lắc lư** dài nhất.

### Example 1:
```text
Input: nums = [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence with differences (6, -3, 5, -7, 3).
```

### Example 2:
```text
Input: nums = [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length.
One is [1, 17, 10, 13, 10, 16, 8] with differences (16, -7, 3, -3, 6, -8).
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 1000`
- `0 <= nums[i] <= 1000`

**Follow up**: Could you solve this in `O(n)` time?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Greedy Approach / Phương Pháp Tham Lam
We want to count "peaks" and "valleys".
`up` = max length of wiggle subsequence ending with an upward move (positive difference).
`down` = max length of wiggle subsequence ending with a downward move (negative difference).

Transitions:
- If `nums[i] > nums[i-1]`:
    - We have an upward move. We can extend a sequence that ended with a downward move.
    - `up = down + 1`.
    - `down` remains same (we can't extend it with upward move to make it still end with downward, but we carry forward best accumulated).
- If `nums[i] < nums[i-1]`:
    - Downward move. Extend sequence ending with upward.
    - `down = up + 1`.
- If `nums[i] == nums[i-1]`:
    - No change.

Result: `max(up, down)`.
Initialize `up = 1`, `down = 1`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Greedy (State Machine)

**Algorithm**:
1.  If `n < 2` return `n`.
2.  `up = 1`, `down = 1`.
3.  Loop `i` from 1 to `n-1`:
    - `diff = nums[i] - nums[i-1]`.
    - If `diff > 0`: `up = down + 1`.
    - If `diff < 0`: `down = up + 1`.
4.  Return `max(up, down)`.

---
