# 258. Add Digits / Cộng Các Chữ Số

## Problem Description / Mô tả bài toán
Given an integer `num`, repeatedly add all its digits until the result has only one digit, and return it.
Cho một số nguyên `num`, lặp đi lặp lại việc cộng tất cả các chữ số của nó cho đến khi kết quả chỉ còn một chữ số, và trả về nó.

### Example 1:
```text
Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.
```

### Example 2:
```text
Input: num = 0
Output: 0
```

## Constraints / Ràng buộc
- `0 <= num <= 2^31 - 1`

**Follow up**: Could you do it without any loop/recursion in `O(1)` runtime?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Digital Root / Căn Số
The problem asks for the **Digital Root** of a number.
There is a known congruence formula (congruence modulo 9).
`dr(n) = 1 + (n - 1) % 9`

Why?
`10^k = 1 mod 9`
`n = d_k * 10^k + ... + d_0 * 10^0`
`n = d_k + ... + d_0 (mod 9)`
The sum of digits is congruent to the number modulo 9.
Repeating the sum of digits maintains this congruence.
Since the digital root is in range `1..9` (except 0), taking `mod 9` gives `0..8` which maps to `1..9` unless `n=0`.

Simplified Logic:
- If `num == 0`, result is 0.
- If `num % 9 == 0`, result is 9.
- Else, result is `num % 9`.

Compressed: `1 + (num - 1) % 9` handles the `9` case well (since (9-1)%9 + 1 = 8%9 + 1 = 9).
Wait, for 0: `1 + (-1) % 9`. In Java, `-1 % 9` is `-1`. `1 + (-1) = 0`. Correct.

---

## Analysis / Phân tích

### Approach: Math (Digital Root)

**Algorithm**:
1.  If `num == 0` return 0.
2.  Return `1 + (num - 1) % 9`.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **0**: Returns 0.
2.  **9**: `1 + 8 % 9 = 9`.
3.  **10**: `1 + 9 % 9 = 1 + 0 = 1`.
