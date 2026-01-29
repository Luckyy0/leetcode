# 532. K-diff Pairs in an Array / Các Cặp K-khác biệt trong Mảng

## Problem Description / Mô tả bài toán
Given an array of integers `nums` and an integer `k`, return the number of **unique** k-diff pairs in the array.
Cho một mảng các số nguyên `nums` và một số nguyên `k`, hãy trả về số lượng các cặp k-khác biệt **duy nhất** trong mảng.

A **k-diff** pair is an integer pair `(nums[i], nums[j])`, where the following are true:
Một cặp **k-khác biệt** là một cặp số nguyên `(nums[i], nums[j])`, trong đó các điều sau là đúng:

- `0 <= i, j < nums.length`
- `i != j`
- `|nums[i] - nums[j]| == k`

**Note**: The result must count distinct pairs `(val1, val2)`. `(1, 3)` is the same pair as `(3, 1)`. Since we look for distinct values, standardizing as `(min, max)` helps. Typically, we look for `x` such that `x + k` exists.

### Constraints / Ràng buộc
- `1 <= nums.length <= 10^4`
- `0 <= k <= 10^7`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### HashMap Frequency / Tần suất HashMap
We need to handle `k=0` and `k > 0` separately or unified using a frequency map.

Algorithm:
1. Count frequency of each number using a HashMap.
2. Initialize `count = 0`.
3. Iterate through `keySet` of the map:
   - If `k > 0`: Check if `key + k` exists in the map. If yes, `count++`.
   - If `k == 0`: Check if `map.get(key) >= 2`. If yes, `count++`.
   - If `k < 0`: Impossible (absolute difference is non-negative), return 0.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Hash Map Bucketing

**Algorithm**:
1.  Populate frequency map.
2.  Iterate unique keys.
3.  Check for partner existence (`key + k`).
4.  Handle `k=0` duplicate case specially.

---
