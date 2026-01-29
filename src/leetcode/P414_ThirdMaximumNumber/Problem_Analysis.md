# 414. Third Maximum Number / Số Lớn Thứ Ba

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return the **third distinct maximum** number in this array. If the third maximum does not exist, return the **maximum** number.
Cho một mảng số nguyên `nums`, hãy trả về **số lớn thứ ba phân biệt** trong mảng này. Nếu số lớn thứ ba không tồn tại, hãy trả về **số lớn nhất**.

### Example 1:
```text
Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.
```

### Example 2:
```text
Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.
```

### Example 3:
```text
Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together).
The third distinct maximum is 1.
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^4`
- `-2^31 <= nums[i] <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Iterative Tracking / Theo dõi theo vòng lặp
Since we only need the top 3 distinct maximums, we can use three variables to track them.

Algorithm:
1. Initialize `max1`, `max2`, `max3` as `null` (or use `Long.MIN_VALUE` if careful about constraints).
2. Iterate through each number `n` in `nums`:
   - If `n` is equal to any of the current maximums, skip it (distinct requirement).
   - If `n > max1`: shift `max2` to `max3`, `max1` to `max2`, and set `max1 = n`.
   - Else if `n > max2`: shift `max2` to `max3`, and set `max2 = n`.
   - Else if `n > max3`: set `max3 = n`.
3. If `max3` is still `null` (or wasn't updated), return `max1`. Otherwise, return `max3`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Three Variables Tracking

**Algorithm**:
1.  Use `Integer` wrapper or `Long` to handle initial state.
2.  Be careful with `Integer.MIN_VALUE` case.

---
