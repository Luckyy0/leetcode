# 936. Stamping The Sequence / Đóng dấu Chuỗi

## Problem Description / Mô tả bài toán
You are given two strings `stamp` and `target`. Initially, there is a string `s` of length `target.length` with all '?' characters.
Bạn được cho hai chuỗi `stamp` và `target`. Ban đầu, có một chuỗi `s` độ dài bằng `target.length` với tất cả là ký tự '?'.

In one turn, you can place the `stamp` over `s`. A stamp can overwrite existing characters.
Trong một lượt, bạn có thể đặt `stamp` lên `s`. Một dấu đóng có thể ghi đè lên các ký tự hiện có.

Return the sequence of index values for the stamps such that `s` becomes `target`. If impossible, or more than `10 * target.length` turns used, return an empty array.
Hãy trả về chuỗi các chỉ số của các dấu đóng sao cho `s` trở thành `target`. Nếu không thể, hãy trả về một mảng trống.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Reverse Stamping / Đóng dấu Ngược Tham lam
It's easier to work backward from `target` to `????`.
Làm việc ngược từ `target` về `????` sẽ dễ dàng hơn.

Algorithm:
1. In each step, find a position in current `target` that matches `stamp` (where `?` in `target` acts as a wildcard that matches any char in `stamp`).
2. If a match is found:
   - Change those characters in `target` to `?`.
   - Record the index.
   - Match at least one character that is not `?`.
3. Repeat until `target` is all `?`.
4. Return recorded indices in reverse order.

### Complexity / Độ phức tạp
- **Time**: O(N * (N - M)).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Deconstructive Substitution
Instead of building the sequence, we peel back the layers of the final target. By iteratively replacing substrings that align with the stamp with wildcards, we reveal the "underlying" sequence of operations in reverse chronology.
Thay vì xây dựng chuỗi, chúng ta bóc tách các lớp của mục tiêu cuối cùng. Bằng cách lặp đi lặp lại việc thay thế các chuỗi con khớp với dấu bằng các ký tự đại diện, chúng ta để lộ chuỗi các thao tác "nằm bên dưới" theo trình tự thời gian ngược.

---
