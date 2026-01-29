# 481. Magical String / Chuỗi Kỳ Diệu

## Problem Description / Mô tả bài toán
A magical string `s` consists of only `'1'` and `'2'` and obeys the following rules:
Một chuỗi kỳ diệu `s` chỉ bao gồm các ký tự `'1'` và `'2'` và tuân theo các quy tắc sau:
- The string `s` is magical because concatenating the number of contiguous occurrences of characters `'1'` and `'2'` generates the string `s` itself.
- Chuỗi `s` là kỳ diệu vì khi nối số lần xuất hiện liên tiếp của các ký tự `'1'` và `'2'` sẽ tạo ra chính chuỗi `s`.

The first few elements of string `s` is `s = "1221121221221121122……"`.
If we group the consecutive 1's and 2's in `s`, it will be: `1 22 11 2 1 22 1 22 11 2 11 22`
and the occurrences can be written as: `1 2 2 1 1 2 1 2 2 1 2 2`
Observe that the sequence of occurrences is also `"122112122122..."`.

Given an integer `n`, return the number of `1`'s in the first `n` number in the magical string `s`.
Cho một số nguyên `n`, hãy trả về số lượng số `1` trong `n` chữ số đầu tiên của chuỗi kỳ diệu `s`.

### Example 1:
```text
Input: n = 6
Output: 3
Explanation: The first 6 elements of magical string s is "122112" and it contains three 1's, so return 3.
```

### Example 2:
```text
Input: n = 1
Output: 1
```

## Constraints / Ràng buộc
- `1 <= n <= 10^5`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation with Two Pointers / Mô phỏng với Hai con trỏ
We can generate the magical string step by step.
Let `A` be the magical string.
- Initial string: `122`.
- `head` pointer at index 2 (value is `2`).
- `tail` pointer at index 3 (where we will append next).

Algorithm:
1. Initialize `A = [1, 2, 2]` and `head = 2`.
2. While `A.size() < n`:
   - The value at `A[head]` tells us how many times to repeat the next character.
   - The next character is `3 - (last character in A)`. (If last was 1, next is 2; if last was 2, next is 1).
   - Append the next character `A[head]` times to `A`.
   - Increment `head`.
3. Count the number of `1`s in the first `n` elements of `A`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Generative Simulation

**Algorithm**:
1.  Seed array with `1, 2, 2`.
2.  Use `head` to read counts and `tail` to write.
3.  Count 1s in result.

---
