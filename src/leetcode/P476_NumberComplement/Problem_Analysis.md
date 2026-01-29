# 476. Number Complement / Số Bù

## Problem Description / Mô tả bài toán
The **complement** of an integer is the integer you get when you flip all the `0`'s to `1`'s and all the `1`'s to `0`'s in its binary representation.
**Số bù** của một số nguyên là số nguyên mà bạn có được khi lật tất cả các số `0` thành `1` và tất cả các số `1` thành `0` trong biểu diễn nhị phân của nó.

- For example, The integer `5` is `"101"` in binary and its complement is `"010"` which is the integer `2`.

Given an integer `num`, return its complement.
Cho một số nguyên `num`, hãy trả về số bù của nó.

### Example 1:
```text
Input: num = 5
Output: 2
```

### Example 2:
```text
Input: num = 1
Output: 0
```

## Constraints / Ràng buộc
- `1 <= num < 2^31`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bit Manipulation / Thao tác Bit
To flip all bits of a number `num`, we can XOR it with a mask of the same length consisting only of `1`s.
For `num = 5` ("101"), the mask should be `7` ("111").
Result: `5 ^ 7 = 2` ("010").

How to generate the mask?
The mask for `num` should have the same number of bits as `num`.
1. Calculate the number of bits in `num`: `L = (int)(Math.log(num) / Math.log(2)) + 1`.
2. Generate mask: `(1 << L) - 1`.
   - Special care for `num = 2^31 - 1` to avoid overflow (use `long` or unsigned shift).

Alternatively: Find the highest set bit and build the mask from there.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Mask-Based Bit Flipping

**Algorithm**:
1.  Find bit length.
2.  Generate all-ones mask.
3.  XOR with `num`.

---
