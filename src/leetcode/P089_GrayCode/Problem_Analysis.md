# 89. Gray Code / Mã Gray

## Problem Description / Mô tả bài toán
An **n-bit gray code sequence** is a sequence of `2^n` integers where:
Một **chuỗi mã Gray n-bit** là một chuỗi gồm `2^n` số nguyên trong đó:
- Every integer is in the inclusive range `[0, 2^n - 1]`,
- The first integer is `0`,
- An integer appears **no more than once** in the sequence,
- The binary representation of every pair of adjacent integers differs by **exactly one bit**, and
- The binary representation of the first and last integers differs by **exactly one bit**.

Given an integer `n`, return the valid **n-bit gray code sequence**.
Cho một số nguyên `n`, trả về **chuỗi mã Gray n-bit** hợp lệ.

### Example 1:
```text
Input: n = 2
Output: [0,1,3,2]
Explanation:
The binary representation of [0,1,3,2] is [00,01,11,10].
- 00 and 01 differ by one bit
- 01 and 11 differ by one bit
- 11 and 10 differ by one bit
- 10 and 00 differ by one bit
[0,2,3,1] is also a valid gray code sequence, whose binary representation is [00,10,11,01].
- 00 and 10 differ by one bit
- 10 and 11 differ by one bit
- 11 and 01 differ by one bit
- 01 and 00 differ by one bit
```

### Example 2:
```text
Input: n = 1
Output: [0,1]
```

## Constraints / Ràng buộc
- `1 <= n <= 16`

---

## Analysis / Phân tích

### Approach 1: Mirror Reflection (Recursive/Iterative) / Phản Xạ Gương
- **Idea**: To generate G(n), take G(n-1), prepend 0 to it. Then take G(n-1) reversed, prepend 1 to it.
- **Ý tưởng**: Để tạo G(n), lấy G(n-1), thêm 0 vào trước nó. Sau đó lấy G(n-1) đảo ngược, thêm 1 vào trước nó.
- **Example n=2**:
    - G(1) = [0, 1]
    - Add 0 prefix -> [00, 01] -> [0, 1]
    - Add 1 prefix to reversed (1, 0) -> [11, 10] -> [3, 2]
    - Result: [0, 1, 3, 2]
- **Time Complexity**: O(2^n).
- **Space Complexity**: O(1) (ignoring result).

### Approach 2: Formula / Công Thức
- **Formula**: `G(i) = i ^ (i >> 1)`.
- **Logic**: The i-th Gray code is `i` XOR `i/2`.
- **Time Complexity**: O(2^n).

---

## Edge Cases / Các trường hợp biên
1.  **n = 1**: [0, 1].
