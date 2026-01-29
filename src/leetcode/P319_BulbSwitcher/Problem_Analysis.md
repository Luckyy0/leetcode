# 319. Bulb Switcher / Công Tắc Bóng Đèn

## Problem Description / Mô tả bài toán
There are `n` bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.
Có `n` bóng đèn ban đầu đều tắt. Đầu tiên bạn bật tất cả các bóng đèn, sau đó tắt mỗi bóng đèn thứ hai.

On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the `i-th` round, you toggle every `i` bulb. For the `n-th` round, you only toggle the last bulb.
Ở vòng thứ ba, bạn chuyển đổi mỗi bóng đèn thứ ba... Đối với vòng thứ `i`, bạn chuyển đổi mỗi bóng đèn chia hết cho `i`.

Return the number of bulbs that are on after `n` rounds.
Trả về số lượng bóng đèn đang bật sau `n` vòng.

### Example 1:
```text
Input: n = 3
Output: 1
Explanation:
At first, the three bulbs are [off, off, off].
After the first round, the three bulbs are [on, on, on].
After the second round, the three bulbs are [on, off, on].
After the third round, the three bulbs are [on, off, off]. 
So you should return 1, because there is only one bulb is on.
```

### Example 2:
```text
Input: n = 0
Output: 0
```

## Constraints / Ràng buộc
- `0 <= n <= 10^9`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Mathematical Property / Tính Chất Toán Học
A bulb `i` is toggled in rounds `d` where `d` is a divisor of `i`.
Specifically, bulb `i` is toggled `count(divisors of i)` times.
- Initially OFF.
- If toggled ODD times -> ON.
- If toggled EVEN times -> OFF.

We need to find how many numbers `i` in `1..n` have an **Odd Number of Divisors**.
Divisors come in pairs `(a, b)` where `a * b = i`.
If `a != b`, they contribute 2 divisors.
If `a == b` (i.e., `i` is a perfect square), the divisor `sqrt(i)` contributes only 1.
So, a number has an odd number of divisors if and only if it is a **Perfect Square**.

The number of perfect squares <= n is simply `floor(sqrt(n))`.
Primes: 1, 4, 9, 16... `k^2 <= n`. `k <= sqrt(n)`.

### Complexity / Độ phức tạp
- **Time**: O(1) using Math.sqrt.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Math Sqrt

**Algorithm**:
1.  Return `(int) Math.sqrt(n)`.

---
