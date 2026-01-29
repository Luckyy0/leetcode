# 1009. Complement of Base 10 Integer / Phần bù của Số nguyên Cơ số 10

## Problem Description / Mô tả bài toán
The complement of an integer is the integer you get when you flip all the `0`s to `1`s and all the `1`s to `0`s in its binary representation.
Phần bù của một số nguyên là số nguyên bạn nhận được khi lật tất cả số `0` thành `1` và tất cả số `1` thành `0` trong biểu diễn nhị phân của nó.

Given `n`, return its complement.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bit Manipulation / Thao tác Bit
To flip bits, we can XOR with a mask of all 1s.
Để lật bit, chúng ta có thể XOR với một mặt nạ gồm toàn các số 1.
The mask should have the same length as `n`.

Algorithm:
1. Find `mask`: number with all 1s and same bit length as `n`.
2. `mask = (highestOneBit(n) << 1) - 1`.
3. Return `n ^ mask`.
4. Special case: `n=0` -> result `1`.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Full-Mask XOR
Generate a bitmask consisting of 1s that spans the length of the input number. XORing the number with this mask strictly inverts each significant bit while leaving leading zeros unaffected.
Tạo một mặt nạ bit bao gồm các số 1 có độ dài bằng số đầu vào. XOR số với mặt nạ này sẽ đảo ngược nghiêm ngặt từng bit quan trọng trong khi không ảnh hưởng đến các số không ở đầu.

---
