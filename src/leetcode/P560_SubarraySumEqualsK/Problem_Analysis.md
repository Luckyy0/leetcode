# 560. Subarray Sum Equals K / Tổng Mảng Con Bằng K

## Problem Description / Mô tả bài toán
Given an array of integers `nums` and an integer `k`, return the total number of continuous subarrays whose sum equals to `k`.
Cho một mảng các số nguyên `nums` và một số nguyên `k`, hãy trả về tổng số lượng các mảng con liên tiếp có tổng bằng `k`.

### Example 1:
```text
Input: nums = [1,1,1], k = 2
Output: 2
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Sum + HashMap / Tổng Tiền Tố + HashMap
Let `P[i]` be the sum of `nums[0...i]`.
Sum of subarray `nums[j...i]` is `P[i] - P[j-1]`.
We want `P[i] - P[j-1] = k`, which means `P[j-1] = P[i] - k`.

Algorithm:
1. Initialize `count = 0`, `sum = 0`.
2. Map `prefixSum -> frequency`. Initialize with `{0: 1}` (handles cases where sum starts from index 0).
3. Iterate `num` in `nums`:
   - `sum += num`.
   - if `map.containsKey(sum - k)`, `count += map.get(sum - k)`.
   - `map.put(sum, map.getOrDefault(sum, 0) + 1)`.
4. Return `count`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Prefix Sum Frequency Map

**Algorithm**:
1.  Maintain running sum.
2.  Check if `sum - k` exists in history.
3.  Add frequency of `sum - k` to count.
4.  Update frequency map with current sum.

---
