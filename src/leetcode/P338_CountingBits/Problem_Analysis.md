# 338. Counting Bits / Đếm Bit

## Problem Description / Mô tả bài toán
Given an integer `n`, return an array `ans` of length `n + 1` such that for each `i` (`0 <= i <= n`), `ans[i]` is the number of `1`'s in the binary representation of `i`.
Cho một số nguyên `n`, trả về một mảng `ans` có độ dài `n + 1` sao cho với mỗi `i` (`0 <= i <= n`), `ans[i]` là số lượng số `1` trong biểu diễn nhị phân của `i`.

### Example 1:
```text
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
```

### Example 2:
```text
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
```

## Constraints / Ràng buộc
- `0 <= n <= 10^5`

**Follow up**:
- It is very easy to come up with a solution with a run time of `O(n log n)`. Can you do it in linear time `O(n)` and possibly in a single pass?
- Can you do it without using any built-in function (i.e., like `__builtin_popcount` in C++)?

---

## Theoretical Foundation / Cơ sở lý thuyết

### DP / Bit Manipulation Patterns
We want `countBits(i)` based on previous values.
Patterns:
1.  `i` is even: `i` ends with 0. `i` is `x << 1`. `count(i) = count(x)`. Because shifting left adds a 0, count of 1s doesn't change. `count(i) = count(i/2)`.
2.  `i` is odd: `i` ends with 1. `i` is `(x << 1) + 1`. `count(i) = count(x) + 1`. `count(i) = count(i/2) + 1`.

Unified formula: `ans[i] = ans[i >> 1] + (i & 1)`.

Another pattern (Last set bit):
`i & (i - 1)` drops the last set bit.
`ans[i] = ans[i & (i - 1)] + 1`.

Both are O(N). I will use the `i >> 1` approach.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) (output array).

---

## Analysis / Phân tích

### Approach: Linear Scan DP

**Algorithm**:
1.  Array `ans` size `n+1`.
2.  `ans[0] = 0`.
3.  Loop `i` from 1 to `n`:
    - `ans[i] = ans[i >> 1] + (i & 1)`.

---
