# 229. Majority Element II / Phần Tử Đa Số II

## Problem Description / Mô tả bài toán
Given an integer array of size `n`, find all elements that appear more than `⌊ n/3 ⌋` times.
Cho một mảng số nguyên có kích thước `n`, hãy tìm tất cả các phần tử xuất hiện nhiều hơn `⌊ n/3 ⌋` lần.

### Example 1:
```text
Input: nums = [3,2,3]
Output: [3]
```

### Example 2:
```text
Input: nums = [1]
Output: [1]
```

### Example 3:
```text
Input: nums = [1,2]
Output: [1,2]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 5 * 10^4`
- `-10^9 <= nums[i] <= 10^9`

**Follow up**: Could you solve the problem in linear time and in `O(1)` space?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Boyer-Moore Voting Algorithm (Extended) / Thuật toán Bầu cử Boyer-Moore (Mở rộng)
The original algorithm finds a majority element (> n/2). It allows for **at most 1** candidate.
For (> n/3), there can be **at most 2** candidates.

**Logic**:
- Maintain `candidate1`, `count1`, `candidate2`, `count2`.
- Loop through `nums`:
    - If `num == candidate1`, `count1++`.
    - Else if `num == candidate2`, `count2++`.
    - Else if `count1 == 0`, `candidate1 = num`, `count1 = 1`.
    - Else if `count2 == 0`, `candidate2 = num`, `count2 = 1`.
    - Else (num is distinct from both), `count1--`, `count2--`.

**Verification Pass**:
- Unlike n/2 check (where existence is guaranteed often), here we might end up with candidates that don't satisfy the condition.
- Reset counts and iterate again to calculate true frequencies of `candidate1` and `candidate2`.
- Add to result if `freq > n/3`.

---

## Analysis / Phân tích

### Approach: Boyer-Moore Voting Extension

**Complexity / Độ phức tạp**:
- **Time**: O(N) - Two passes.
- **Space**: O(1) - Two candidate variables.

---

## Edge Cases / Các trường hợp biên
1.  **Small arrays**: `[1, 2]` -> Both appear > 2/3 (0). Wait, > 2/3? No, > 2/3 is 0. Both 1 and 2 count > 0.
2.  **No majority**: `[1, 2, 3]` -> No one appears > 1. Output `[]`.
3.  **One candidate**: `[1, 1, 2]` -> 1 is > 1. Output `[1]`.
