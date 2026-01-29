# 330. Patching Array / Vá Mảng

## Problem Description / Mô tả bài toán
Given a sorted integer array `nums` and an integer `n`, add/patch elements to the array such that any number in the range `[1, n]` inclusive can be formed by the sum of some elements in the array.
Cho một mảng số nguyên đã sắp xếp `nums` và một số nguyên `n`, thêm/vá các phần tử vào mảng sao cho bất kỳ số nào trong phạm vi `[1, n]` bao gồm đều có thể được tạo thành từ tổng của một số phần tử trong mảng.

Return the minimum number of patches required.
Trả về số lượng bản vá tối thiểu cần thiết.

### Example 1:
```text
Input: nums = [1,3], n = 6
Output: 1
Explanation:
Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.
```

### Example 2:
```text
Input: nums = [1,5,10], n = 20
Output: 2
Explanation: The two patches can be [2, 4].
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 1000`
- `1 <= nums[i] <= 10^4`
- `nums` is sorted in ascending order.
- `1 <= n <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Greedy Approach / Tiếp Cận Tham Lam
Let `miss` be the smallest sum in `[1, n]` that we cannot yet form. Ideally, we want `miss` to eventually be `> n`.
Initially, `miss = 1`.
If `nums` contains `nums[i] <= miss`, it means we can form sums up to `miss + nums[i] - 1` (since we could previously form `[1, miss - 1]`, adding `nums[i]` extends this range to `[1 + nums[i], miss - 1 + nums[i]]`. Since `nums[i] <= miss`, there is no gap).
New `miss` becomes `miss + nums[i]`.

If `nums[i] > miss` (or we ran out of numbers), we have a gap. We need to add a number to patch this gap. The best number to add to maximize reach is `miss` itself.
New `miss` becomes `miss + miss`.
Increment `patches`.

### Complexity / Độ phức tạp
- **Time**: O(N + log n). Iterate nums once, and `miss` doubles when patching (logarithmic).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Greedy

**Algorithm**:
1.  `miss = 1`, `added = 0`, `i = 0`.
2.  While `miss <= n`:
    - If `i < len` and `nums[i] <= miss`:
        - `miss += nums[i]`
        - `i++`
    - Else:
        - `miss += miss`
        - `added++`

*Caution*: `miss` can exceed Integer.MAX_VALUE. Use `long`.

---
