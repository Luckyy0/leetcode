# 625. Minimum Factorization / Phân Tích Thừa Số Tối Thiểu

## Problem Description / Mô tả bài toán
Given a positive integer `num`, return the smallest positive integer `x` whose multiplication of each digit equals `num`. If there is no answer or the answer is not fit in 32-bit signed integer, return 0.
Cho một số nguyên dương `num`, hãy trả về số nguyên dương nhỏ nhất `x` mà tích của mỗi chữ số bằng `num`. Nếu không có câu trả lời hoặc câu trả lời không vừa trong số nguyên có dấu 32 bit, hãy trả về 0.

### Example 1:
```text
Input: num = 48
Output: 68
Explanation: 6 * 8 = 48.
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Factorization / Phân Tích Thừa Số Tham Lam
To minimize the number formed by digits:
1. Digits should be as few as possible. So use large digits (9, 8, ...).
2. Large digits should be placed at the less significant positions (right) to minimize magnitude. So we process digits from 9 down to 2.
3. If `num` is divisible by 9, add 9 to result digits, `num /= 9`. Repeat.
4. Then check 8, 7, ... 2.
5. If after checking all digits `num > 1`, return 0 (contains prime factors > 7 e.g. 11, 13...).
6. Construct number from digits (reverse order). Check for overflow.

Special Case: `num = 1`. Result is 1.

### Complexity / Độ phức tạp
- **Time**: O(log Num).
- **Space**: O(log Num) digits storage.

---

## Analysis / Phân tích

### Approach: Reverse Greedy

**Algorithm**:
1.  Handle `num < 2` separately.
2.  Try dividing by 9 down to 2.
3.  Collect factors.
4.  If `num` remains > 1, impossible.
5.  Reconstruct number. overflow check using long.

---
