# 441. Arranging Coins / Sắp Xếp Tiền Xu

## Problem Description / Mô tả bài toán
You have `n` coins and you want to build a staircase with these coins. The staircase consists of `k` rows where the `i-th` row has exactly `i` coins. The last row of the staircase **may be** incomplete.
Bạn có `n` đồng xu và muốn xây dựng một cầu thang bằng những đồng xu này. Cầu thang bao gồm `k` hàng, trong đó hàng thứ `i` có đúng `i` đồng xu. Hàng cuối cùng của cầu thang **có thể** không hoàn chỉnh.

Given the integer `n`, return the number of **complete rows** of the staircase you will build.
Cho số nguyên `n`, hãy trả về số lượng **hàng hoàn chỉnh** mà bạn sẽ xây dựng được.

### Example 1:
```text
Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.
```

### Example 2:
```text
Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.
```

## Constraints / Ràng buộc
- `1 <= n <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Mathematical Equation (Arithmetic Progression) / Phương trình toán học
The number of coins needed for `k` complete rows is the sum of the first `k` positive integers:
`S = (k * (k + 1)) / 2`.
We want to find the largest `k` such that `(k * (k + 1)) / 2 <= n`.

Solving for `k`:
`k^2 + k - 2n <= 0`.
The positive root is `k = (-1 + sqrt(1 + 8n)) / 2`.
Since we want the integer part, we can use `Math.sqrt`.

Alternatively, we can use **Binary Search** in the range `[0, n]`.
For a given `mid`, check if `mid * (mid + 1) / 2 <= n`.

### Complexity / Độ phức tạp
- **Time**: O(1) for Math approach, or O(log N) for Binary Search.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search

**Algorithm**:
1.  Set `low = 0`, `high = n`.
2.  While `low <= high`:
    - `mid = low + (high - low) / 2`.
    - `sum = mid * (mid + 1) / 2`.
    - If `sum == n`, return `mid`.
    - If `sum < n`, `low = mid + 1`.
    - Else `high = mid - 1`.
3.  Return `high`.

---
