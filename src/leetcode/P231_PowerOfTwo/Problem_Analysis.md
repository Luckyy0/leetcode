# 231. Power of Two / Lũy Thừa của Hai

## Problem Description / Mô tả bài toán
Given an integer `n`, return `true` if it is a power of two. Otherwise, return `false`.
Cho một số nguyên `n`, hãy trả về `true` nếu nó là lũy thừa của hai. Nếu không, trả về `false`.

An integer `n` is a power of two, if there exists an integer `x` such that `n == 2^x`.
Một số nguyên `n` là lũy thừa của hai nếu tồn tại một số nguyên `x` sao cho `n == 2^x`.

### Example 1:
```text
Input: n = 1
Output: true
Explanation: 2^0 = 1
```

### Example 2:
```text
Input: n = 16
Output: true
Explanation: 2^4 = 16
```

### Example 3:
```text
Input: n = 3
Output: false
```

## Constraints / Ràng buộc
- `-2^31 <= n <= 2^31 - 1`

**Follow up**: Could you solve it without loops/recursion?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Bit Manipulation / Thao Tác Bit
A positive number `n` is a power of two if and only if its binary representation has exactly **one** bit set to `1` (e.g., `1` (1), `2` (10), `4` (100), `8` (1000)).

**Trick**:
`n & (n - 1)` removes the rightmost set bit of `n`.
If `n` is a power of two, it has only one set bit. Removing it should result in `0`.

Condition: `n > 0` AND `(n & (n - 1)) == 0`.

---

## Analysis / Phân tích

### Approach: Bitwise Trick

**Complexity / Độ phức tạp**:
- **Time**: O(1).
- **Space**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **n = 0**: False (0 is not power of 2).
2.  **n = 1**: True (2^0).
3.  **Negative numbers**: False (Powers of 2 are positive). "n & (n-1)" trick works for negatives too (e.g. -2 is ...1110) but negatives aren't powers of 2. So check `n > 0`.
