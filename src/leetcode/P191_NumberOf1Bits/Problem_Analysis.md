# 191. Number of 1 Bits / Số lượng Bit 1

## Problem Description / Mô tả bài toán
Write a function that takes the binary representation of a positive integer and returns the number of set bits it has (also known as the Hamming weight).
Viết một hàm nhận vào biểu diễn nhị phân của một số nguyên dương và trả về số lượng các set bit (còn được gọi là Hamming weight).

### Example 1:
```text
Input: n = 11
Output: 3
Explanation: The input binary string 1011 has a total of three set bits.
```

### Example 2:
```text
Input: n = 128
Output: 1
Explanation: The input binary string 10000000 has a total of one set bit.
```

### Example 3:
```text
Input: n = 2147483645
Output: 30
```

## Constraints / Ràng buộc
- `1 <= n <= 2^31 - 1`

**Follow up**: If this function is called many times, how would you optimize it?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Brian Kernighan's Algorithm / Thuật toán Brian Kernighan
This is an efficient way to count set bits:
Đây là một cách hiệu quả để đếm các set bit:
1.  Subtracting 1 from a number flips all the bits after the rightmost set bit (including the rightmost set bit itself).
2.  Therefore, `n & (n - 1)` will clear the rightmost set bit of `n`.
3.  We can count how many times we can perform this operation until `n` becomes 0.

*Example: `n = 12 (1100)`*
1.  `n = 12 & 11 = 1100 & 1011 = 1000 (8)` -> Count = 1
2.  `n = 8 & 7 = 1000 & 0111 = 0000 (0)` -> Count = 2
*Result: 2 bits.*

---

## Analysis / Phân tích

### Approach: Brian Kernighan's Algorithm

**Complexity / Độ phức tạp**:
- **Time**: O(K) - where K is the number of set bits (better than O(32) bit shifting).
- **Space**: O(1).

---

## Edge Cases / Các trường hợp biên
1.  **n = 0**: Should return 0. (Though constraints say n >= 1).
2.  **n = 2^31 - 1**: All bits except sign bit are 1.
3.  **Power of 2**: Always returns 1.
