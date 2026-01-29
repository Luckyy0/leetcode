# 402. Remove K Digits / Xóa K Chữ Số

## Problem Description / Mô tả bài toán
Given string `num` representing a non-negative integer `num`, and an integer `k`, return the smallest possible integer after removing `k` digits from `num`.
Cho chuỗi `num` đại diện cho một số nguyên không âm `num` và một số nguyên `k`, hãy trả về số nguyên nhỏ nhất có thể sau khi xóa `k` chữ số từ `num`.

### Example 1:
```text
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
```

### Example 2:
```text
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
```

### Example 3:
```text
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
```

## Constraints / Ràng buộc
- `1 <= k <= num.length <= 10^5`
- `num` consists of only digits.
- `num` does not have any leading zeros except for the zero itself.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Greedy with Monotonic Stack / Tham lam với Ngăn xếp đơn điệu
To minimize the number, we want smaller digits at higher place values (more to the left).
If we find a digit `d` that is smaller than the digit before it, removing the larger previous digit will always result in a smaller number.

Algorithm:
1. Use a stack to keep digits in non-decreasing order.
2. Iterate through each digit in `num`.
3. While the stack is not empty, `k > 0`, and the top of the stack is greater than the current digit:
   - Pop from the stack (remove the larger digit).
   - Decrement `k`.
4. Push current digit.
5. If `k > 0` after the loop, remove digits from the end of the stack.
6. Build the result string from the stack, removing leading zeros.
7. If result is empty, return "0".

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `num`.
- **Space**: O(N) for the stack.

---

## Analysis / Phân tích

### Approach: Monotonic Stack

**Algorithm**:
1.  Initialize a `StringBuilder` or `Deque` as a stack.
2.  Traverse digits in `num`.
3.  Compare current digit with stack top.
4.  Handle edge cases (leading zeros, `k` remaining).

---
