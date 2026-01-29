# 1413. Minimum Value to Get Positive Step by Step Sum / Giá trị Tối thiểu để Có Tổng Từng bước Dương

## Problem Description / Mô tả bài toán
Array `nums`. Start value `x`.
Running sum `startValue + sum(nums[0]...nums[i])` must be >= 1 for all `i`.
Find min positive `startValue`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Sum Min
Calculate prefix sums of `nums`.
Find minimum prefix sum `minPref`.
If `minPref < 1`, we need `startValue` such that `startValue + minPref >= 1`.
`startValue >= 1 - minPref`.
If `minPref >= 1`, 1 is good? Wait.
Run sum must be >= 1.
`startValue + prefix >= 1`.
`startValue >= 1 - prefix`.
Max of `1 - prefix` over all prefixes. Also `startValue` must be >= 1.
So `res = max(1, 1 - minPrefix)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Track Minimum Prefix Sum
Iterate array, tracking `currentSum`. keep track of `minSum` achieved.
`startValue` needs to cover the `minSum` to keep it at least 1.
`minStart = 1 - minSum` (if minSum < 0).
Base case: if minSum never drops below 1, `startValue = 1`.
Simplified: `max(1, 1 - minSum)`.
Lặp lại mảng, theo dõi `currentSum`. theo dõi `minSum`.
`startValue` cần bao gồm `minSum` để giữ nó ít nhất là 1.
`minStart = 1 - minSum`.

---
