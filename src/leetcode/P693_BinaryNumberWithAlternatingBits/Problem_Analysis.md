# 693. Binary Number with Alternating Bits / Số Nhị phân với các Bit Luân phiên

## Problem Description / Mô tả bài toán
Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
Cho một số nguyên dương, hãy kiểm tra xem nó có các bit luân phiên hay không: cụ thể là nếu hai bit liền kề sẽ luôn có các giá trị khác nhau.

### Example 1:
```text
Input: n = 5
Output: true (101)
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bit Manipulation / Thao tác Bit
If a number `n` has alternating bits, then `n XOR (n >> 1)` will be a number consisting of all 1s.
Nếu một số `n` có các bit luân phiên, thì `n XOR (n >> 1)` sẽ là một số bao gồm tất cả các bit 1.

Example: `5 (101) XOR 2 (010) = 7 (111)`.
Once we have a number `x` with all bits as 1s, `(x & (x + 1))` will be 0.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Logical Bit Check
Perform `n ^ (n >> 1)` and check if the result is of the form `2^k - 1`.
Thực hiện `n ^ (n >> 1)` và kiểm tra xem kết quả có ở dạng `2^k - 1` hay không.

---
