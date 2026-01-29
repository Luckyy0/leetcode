# 367. Valid Perfect Square / Số Chính Phương Hợp Lệ

## Problem Description / Mô tả bài toán
Given a positive integer `num`, return `true` if `num` is a perfect square or `false` otherwise.
Cho một số nguyên dương `num`, trả về `true` nếu `num` là số chính phương.

A **perfect square** is an integer that is the square of an integer. In other words, it is the product of some integer with itself.
You must not use any built-in library function, such as `sqrt`.

### Example 1:
```text
Input: num = 16
Output: true
```

### Example 2:
```text
Input: num = 14
Output: false
```

## Constraints / Ràng buộc
- `1 <= num <= 2^31 - 1`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Binary Search / Tìm Kiếm Nhị Phân
Search for `x` such that `x * x = num`.
Range `[1, num]` or better `[1, num/2]` (for num > 1).
Or `[1, 46340]` (since sqrt(2^31-1) approx 46340).
Check `mid * mid`. Use `long` to avoid overflow.

### Newton's Method / Phương Pháp Newton
`x = (x + num/x) / 2`.
Start `x = num`. Loop while `x * x > num`.

I will implement **Binary Search** as it is standard O(log N).

---

## Analysis / Phân tích

### Approach: Binary Search

**Algorithm**:
1.  `low = 1`, `high = num`. (Or optimize high).
2.  While `low <= high`:
    - `mid = low + (high - low) / 2`.
    - `sq = mid * mid`. (Cast to long).
    - If `sq == num` return true.
    - If `sq < num`: `low = mid + 1`.
    - Else: `high = mid - 1`.

---
