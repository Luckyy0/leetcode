# 152. Maximum Product Subarray / Tích Con Mảng Tối Đa

## Problem Description / Mô tả bài toán
Given an integer array `nums`, find a subarray that has the largest product, and return the product.
Cho một mảng số nguyên `nums`, hãy tìm một mảng con có tích lớn nhất và trả về tích đó.

The test cases are generated so that the answer will fit in a **32-bit** integer.
Các bộ kiểm tra được tạo ra để kết quả khớp trong một số nguyên **32-bit**.

### Example 1:
```text
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
```

### Example 2:
```text
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 2 * 10^4`
- `-10 <= nums[i] <= 10`
- The product of any subarray of `nums` is guaranteed to fit in a **32-bit integer**.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Comparison with Maximum Subarray Sum / So sánh với Tổng Con Mảng Tối Đa
In Problem 53 (Maximum Subarray Sum), we used Kadane's algorithm. For products, it is trickier because:
- **Positive × Positive = Positive** (Great!)
- **Negative × Negative = Positive** (Wait, a small negative could become a large positive later!)
- **Zero** resets the product.

### Key Insight: Track Max and Min / Điểm quan trọng: Theo dõi Cả Max và Min
For each element, the new character maximum product could come from:
1.  The element itself.
2.  `current element * previous maximum` (if element is positive).
3.  `current element * previous minimum` (if element is negative).

Therefore, we must maintain both the **maximum product** and the **minimum product** (a large negative value) at each step.

---

## Analysis / Phân tích

### Approach: Dynamic Programming (Optimized Kadane's)

**Algorithm**:
1.  Initialize `res`, `max_so_far`, and `min_so_far` with `nums[0]`.
2.  Iterate through `nums` starting from index 1.
3.  If current element is negative, **swap** `max_so_far` and `min_so_far` (because multiplying by negative flips order).
4.  Update:
    - `max_so_far = max(curr, max_so_far * curr)`
    - `min_so_far = min(curr, min_so_far * curr)`
5.  `res = max(res, max_so_far)`.

### Complexity / Độ phức tạp
- **Time**: O(N) - single pass.
- **Space**: O(1) - constant space for variables.

---

## Edge Cases / Các trường hợp biên
1.  **Zeros**: Effectively reset the sub-product calculation.
2.  **All negative numbers**: Odd number of negatives will result in smaller products, even will result in larger ones.
3.  **Single element array**: Handled by initialization.
