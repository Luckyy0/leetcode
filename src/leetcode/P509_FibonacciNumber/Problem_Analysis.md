# 509. Fibonacci Number / Số Fibonacci

## Problem Description / Mô tả bài toán
The **Fibonacci numbers**, commonly denoted `F(n)` form a sequence, called the **Fibonacci sequence**, such that each number is the sum of the two preceding ones, starting from `0` and `1`.
Các **số Fibonacci**, thường được ký hiệu là `F(n)`, tạo thành một dãy số được gọi là **dãy Fibonacci**, trong đó mỗi số là tổng của hai số đứng trước nó, bắt đầu từ `0` và `1`.

- `F(0) = 0, F(1) = 1`
- `F(n) = F(n - 1) + F(n - 2)`, for `n > 1`.

Given `n`, calculate `F(n)`.
Cho `n`, hãy tính `F(n)`.

### Example 1:
```text
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
```

### Example 2:
```text
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
```

## Constraints / Ràng buộc
- `0 <= n <= 30`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Iterative DP with Space Optimization / Quy hoạch động tối ưu không gian
We can calculate `F(n)` by keeping track of the previous two numbers.

Algorithm:
1. Handle base cases `n=0` and `n=1`.
2. Initialize `prev2 = 0` and `prev1 = 1`.
3. Loop from `i = 2` to `n`:
   - `curr = prev1 + prev2`.
   - `prev2 = prev1`.
   - `prev1 = curr`.
4. Return `prev1`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear Recurrence

**Algorithm**:
1.  Check base cases.
2.  Iterate and update previous two values.
3.  Return the sum for `n`.

---
