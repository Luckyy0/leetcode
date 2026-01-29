# 396. Rotate Function / Hàm Xoay

## Problem Description / Mô tả bài toán
You are given an integer array `nums` of length `n`.
Cho một mảng số nguyên `nums` có độ dài `n`.

Assume `arr_k` to be an array obtained by rotating `nums` by `k` positions clock-wise. We define the **rotation function** `F` on `nums` as follows:
Giả sử `arr_k` là mảng có được bằng cách xoay `nums` đi `k` vị trí theo chiều kim đồng hồ. Chúng ta định nghĩa **hàm xoay** `F` trên `nums` như sau:
`F(k) = 0 * arr_k[0] + 1 * arr_k[1] + ... + (n - 1) * arr_k[n - 1]`.

Return the maximum value of `F(0), F(1), ..., F(n - 1)`.
Hãy trả về giá trị lớn nhất của `F(0), F(1), ..., F(n - 1)`.

The test cases are generated such that the answer fits in a 32-bit integer.

### Example 1:
```text
Input: nums = [4,3,2,6]
Output: 26
Explanation:
F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
```

## Constraints / Ràng buộc
- `n == nums.length`
- `1 <= n <= 10^5`
- `-100 <= nums[i] <= 100`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Mathematical Induction / Quy nạp toán học
Let `S` be the sum of all elements in `nums`.
`F(0) = 0*a0 + 1*a1 + 2*a2 + ... + (n-1)*an-1`
`F(1) = 0*an-1 + 1*a0 + 2*a1 + ... + (n-1)*an-2`

Wait, let's look at `F(1) - F(0)`:
`F(1) - F(0) = (1*a0 - 0*a0) + (2*a1 - 1*a1) + ... + ((n-1)*an-2 - (n-2)*an-2) + (0*an-1 - (n-1)*an-1)`
`F(1) - F(0) = a0 + a1 + a2 + ... + an-2 - (n-1)an-1`
`F(1) - F(0) = S - an-1 - (n-1)an-1 = S - n*an-1`.

So generally:
`F(k) = F(k-1) + S - n * nums[n - k]`.

This allows us to calculate each `F(k)` in O(1) time after initial `F(0)` and `S`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear DP Formula

**Algorithm**:
1.  Calculate `S` (sum of elements) and `F(0)`.
2.  `maxF = F(0)`.
3.  `currentF = F(0)`.
4.  Loop `k` from 1 to `n-1`:
    - `currentF = currentF + S - n * nums[n - k]`.
    - `maxF = max(maxF, currentF)`.
5.  Return `maxF`.

---
