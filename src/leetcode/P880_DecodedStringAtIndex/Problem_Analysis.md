# 880. Decoded String at Index / Chuỗi Giải mã tại Chỉ số

## Problem Description / Mô tả bài toán
An encoded string `s` is given where a letter means repeating the letter, and a digit `d` means the entire current string is repeated `d` times.
Một chuỗi mã hóa `s` được cung cấp, trong đó một chữ cái có nghĩa là lặp lại chữ cái đó, và một chữ số `d` có nghĩa là toàn bộ chuỗi hiện tại được lặp lại `d` lần.

Find the `kth` letter (1-indexed) in the decoded string.
Tìm chữ cái thứ `k` (chỉ số 1) trong chuỗi đã được giải mã.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Reverse Processing / Xử trị Ngược
Expanding the string is impossible (it could be very long).
Việc mở rộng chuỗi là không thể (nó có thể rất dài).

Algorithm:
1. Calculate the total length of the decoded string `size`.
2. Iterate backwards through the encoded string `s`:
   - Keep `k = k % size`.
   - If `k == 0` and `s[i]` is a letter, that's our result.
   - If `s[i]` is a digit `d`, `size = size / d`.
   - Else, `size--`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Virtual Backtracking
Instead of building the gigantic decoded string, we track its total virtual size. By applying the modulo operation as we move backward through the encoded string, we "unwind" the repetitions until we hit the specific character at the relative index.
Thay vì xây dựng chuỗi giải mã khổng lồ, chúng ta theo dõi tổng kích thước ảo của nó. Bằng cách áp dụng phép toán modulo khi chúng ta di chuyển ngược lại qua chuỗi mã hóa, chúng ta "gỡ bỏ" các lần lặp lại cho đến khi chạm tới ký tự cụ thể tại chỉ số tương đối.

---
