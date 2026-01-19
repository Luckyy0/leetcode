# 190. Reverse Bits / Đảo ngược Bit

## Problem Description / Mô tả bài toán
Reverse bits of a given 32 bits unsigned integer.
Đảo ngược các bit của một số nguyên không dấu 32 bit cho trước.

**Note**:
- In some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
- In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in the example below, the input integer `43261596` represents the signed integer `-43261596` in 2's complement and its binary representation is `00000010100101000001111010011100$.

### Example 1:
```text
Input: n = 00000010100101000001111010011100 (43261596)
Output:    964176192 (00111001011110000010100101000000)
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
```

## Constraints / Ràng buộc
- The input must be a **binary string** of length 32.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Bitwise Operations / Thao tác Bit
To reverse the bits of a 32-bit integer:
Để đảo ngược các bit của một số nguyên 32 bit:
1.  Initialize `result = 0`.
2.  Iterate 32 times:
    - Shift `result` to the left by 1 to make room for the next bit.
    - Extract the last bit of `n` using `n & 1`.
    - Add this bit to `result` (using OR `|`).
    - Shift `n` to the right by 1 to process the next bit.

---

## Analysis / Phân tích

### Approach: Bitwise Shifting

**Complexity / Độ phức tạp**:
- **Time**: O(1) - we always loop exactly 32 times.
- **Space**: O(1) - constant space.

---

## Edge Cases / Các trường hợp biên
1.  **All zeros**: Result is 0.
2.  **All ones**: Result is -1 (in signed representation, 2^32 - 1).
3.  **Positive and Negative inputs**: Handled naturally by bitwise operations in Java.
