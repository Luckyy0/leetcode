# 327. Count of Range Sum / Đếm Tổng Phạm Vi

## Problem Description / Mô tả bài toán
Given an integer array `nums` and two integers `lower` and `upper`, return the number of range sums that lie in `[lower, upper]` inclusive.
Cho một mảng số nguyên `nums` và hai số nguyên `lower` và `upper`, trả về số lượng các tổng phạm vi nằm trong `[lower, upper]`.

Range sum `S(i, j)` is defined as the sum of the elements in `nums` between indices `i` and `j` inclusive, where `i <= j`.
Tổng phạm vi `S(i, j)` được định nghĩa là tổng các phần tử trong `nums` giữa các chỉ số `i` và `j`.

### Example 1:
```text
Input: nums = [-2,5,-1], lower = -2, upper = 2
Output: 3
Explanation: The three ranges are: [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^5`
- `-2^31 <= nums[i] <= 2^31 - 1`
- `-10^5 <= lower <= upper <= 10^5`
- The answer is guaranteed to fit in a 32-bit integer.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Prefix Sum + Divide and Conquer (Merge Sort) / Tổng Tiền Tố + Chia Để Trị
Let `sums` be the prefix sum array. `S(i, j) = sums[j+1] - sums[i]`.
We want `lower <= sums[j+1] - sums[i] <= upper` for `i < j+1`.
Let `k = j+1`. We check `lower <= sums[k] - sums[i] <= upper` for `i < k`.
Condition: `sums[k] - upper <= sums[i] <= sums[k] - lower`.

During standard Merge Sort on `sums` array:
- When merging Left (`start` to `mid`) and Right (`mid+1` to `end`).
- Iterate `k` in Right part.
- Maintain pointers `m` and `n` in Left part.
  - `m` is first index where `sums[m] >= sums[k] - upper`.
  - `n` is first index where `sums[n] > sums[k] - lower`.
  - The count of valid `i`'s for this `k` is `n - m`.
- Since `sums` in Left and Right are sorted (due to recursion), `m` and `n` only move forward.
- Then proceed with standard merge.

### Complexity / Độ phức tạp
- **Time**: `O(N log N)`.
- **Space**: `O(N)` for merge sort aux array. Note prefix sums need `long` to avoid overflow.

---

## Analysis / Phân tích

### Approach: Merge Sort Counting

**Algorithm**:
1.  Long array `prefix`. Size `n+1`. `prefix[0]=0`. Calc prefix sums.
2.  `countRangeSumRecursive(prefix, lower, upper, 0, n)`.
3.  Recursive step:
    - `mid = (lo + hi) / 2`.
    - `count = leftCount + rightCount`.
    - Loop `i` from `lo` to `mid`. (Wait, logic above was iter `k` in right. Swap roles is fine).
    - Actually, standard: iter `i` in Left. No, iter `k` in Right is easier.
      For each `right[j]`, find range in `left`.
      `curr = prefix[j]`.
      `lowerBound = curr - upper`.
      `upperBound = curr - lower`.
      Count elements in `left` within `[lowerBound, upperBound]`.
    - Optimization: Two pointers `m, n`.
      For `i` in `[mid+1, hi]`:
        while `m <= mid` and `prefix[m] < prefix[i] - upper`: `m++`
        while `n <= mid` and `prefix[n] <= prefix[i] - lower`: `n++`
        `count += n - m`.
    - Merge `[lo, mid]` and `[mid+1, hi]` sortedly.

---
