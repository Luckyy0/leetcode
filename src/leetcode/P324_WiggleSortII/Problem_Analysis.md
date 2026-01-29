# 324. Wiggle Sort II / Sắp Xếp Lắc Lư II

## Problem Description / Mô tả bài toán
Given an integer array `nums`, reorder it such that `nums[0] < nums[1] > nums[2] < nums[3]...`.
Cho một mảng số nguyên `nums`, sắp xếp lại sao cho `nums[0] < nums[1] > nums[2] < nums[3]...`.

You may assume the input array always has a valid answer.

### Example 1:
```text
Input: nums = [1,5,1,1,6,4]
Output: [1,6,1,5,1,4]
Explanation: [1,4,1,5,1,6] is is also accepted.
```

### Example 2:
```text
Input: nums = [1,3,2,2,3,1]
Output: [2,3,1,3,1,2]
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 5 * 10^4`
- `0 <= nums[i] <= 5000`
- It is guaranteed that there will be an answer for the given input `nums`.

**Follow Up**: Can you do it in `O(n)` time and/or in-place with `O(1)` extra space?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Sort and Interleave / Sắp Xếp và Đan Xen
To ensure `Small < Large > Small < Large`, we can sort the array and split it into two halves:
- `Small` half (smaller elements).
- `Large` half (larger elements).
If we interleave them `Small[0], Large[0], Small[1], Large[1]`, we might have issues if there are duplicate medians (e.g., `4, 5, 5, 6` -> `4, 5, 5, 6`. `4 < 5` ok. `5 !> 5`. Fail).
**Reverse Interleaving**:
To avoid adjacent duplicates (which cluster around the median), we should reverse the order or pick from the ends.
Pattern: `Small[last], Large[last], Small[last-1], Large[last-1]...`.
This puts the largest of the smalls far from the smallest of the larges (which are both likely equal to median), separating them.

**Algorithm (O(N log N) Time, O(N) Space)**:
1.  Copy `nums` to `copy` and sort `copy`.
2.  `n = nums.length`.
3.  `mid = (n + 1) / 2`. (Size of small half).
4.  Pointers: `i` for `copy` small end (`mid - 1`), `j` for `copy` large end (`n - 1`).
5.  Fill `nums`:
    - Even indices `0, 2, ...`: `copy[i--]`.
    - Odd indices `1, 3, ...`: `copy[j--]`.

### O(N) Time O(1) Space (Virtual Indexing)
- Find Median using QuickSelect (O(N)).
- Virtual Indexing (`A(i)` maps logical index `0..n-1` to `1, 3, 5, 0, 2, 4` in physical array).
- 3-way partition (Dutch National Flag) around Median using Virtual Indexing.
  - Put larger than median to "front" (logical 0, 1..) -> physical (1, 3..).
  - Put smaller than median to "back" (logical last..) -> physical (0, 2..).
- This ensures separation and wiggle property.

I will implement the **Sort and Interleave** approach (O(N log N)) as it is robust and significantly simpler to implement correctly than Virtual Indexing + QuickSelect, while satisfying the core constraints (Follow-up is optional bonus).

---

## Analysis / Phân tích

### Approach: Sort + Interleave

**Correct filling order**:
Indices `0, 1, 2, 3, 4, 5`.
Values `S, L, S, L, S, L`.
We take `S` from `mid-1` downwards.
We take `L` from `n-1` downwards.

---
