# 50. Pow(x, n) / Lũy Thừa (x, n)

## Problem Description / Mô tả bài toán
Implement `pow(x, n)`, which calculates `x` raised to the power `n` (i.e., `x^n`).
Thực hiện `pow(x, n)`, tính `x` lũy thừa `n` (tức là `x^n`).

### Example 1:
```text
Input: x = 2.00000, n = 10
Output: 1024.00000
```

### Example 2:
```text
Input: x = 2.10000, n = 3
Output: 9.26100
```

### Example 3:
```text
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
```

## Constraints / Ràng buộc
- `-100.0 < x < 100.0`
- `-2^31 <= n <= 2^31 - 1`
- `n` is an integer.
- Either `x` is not zero or `n > 0`.
- `-10^4 <= x^n <= 10^4`

---

## Analysis / Phân tích

### Approach: Binary Exponentiation (Fast Power) / Lũy Thừa Nhị Phân (Lũy Thừa Nhanh)
- **Idea**: Rather than multiplying x n times (O(n)), we can square the base and halve the exponent.
- **Ý tưởng**: Thay vì nhân x n lần (O(n)), chúng ta có thể bình phương cơ số và chia đôi số mũ.
- **Recursive Formula**:
    - `pow(x, 2k) = pow(x^2, k)`
    - `pow(x, 2k+1) = x * pow(x^2, k)`
- **Handling Negative n**:
    - If `n < 0`, let `x = 1/x` and `n = -n`.
    - **Note**: `n` can be `Integer.MIN_VALUE`. Negating `MIN_VALUE` overflows int. So use `long` for N.
- **Time Complexity**: O(log n).
- **Space Complexity**: O(1) (iterative) or O(log n) (recursive stack).

---

## Edge Cases / Các trường hợp biên
1.  **n = 0**: Returns 1.
2.  **n = min_int**: Handle overflow.
3.  **x = 1**: Returns 1.
