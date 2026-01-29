# 848. Shifting Letters / Dịch chuyển Chữ cái

## Problem Description / Mô tả bài toán
You are given a string `s` and an integer array `shifts`.
Bạn được cấp một chuỗi `s` và một mảng số nguyên `shifts`.

The `ith` character of `s` is shifted `shifts[i]` times, plus all subsequent shifts `shifts[j]` for `j > i`.
Ký tự thứ `i` của `s` được dịch chuyển `shifts[i]` lần, cộng với tất cả các lần dịch chuyển tiếp theo `shifts[j]` cho `j > i`.

Return the final string.
Trả về chuỗi cuối cùng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Suffix Sum / Tổng hậu tố
The total number of shifts for character `i` is the sum of all elements in `shifts[i...n-1]`.
Tổng số lần dịch chuyển cho ký tự `i` là tổng của tất cả các phần tử trong `shifts[i...n-1]`.

Algorithm:
1. Iterate backwards through the `shifts` array to calculate cumulative sum (modulo 26).
2. For each character, apply its cumulative shift.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) for string builder/char array.

---

## Analysis / Phân tích

### Approach: Reverse Cumulative Shift
Calculating from the end reduces redundant work. By summing shifts from right to left, we determine the net displacement for each character in a single pass.
Tính toán từ cuối giúp giảm bớt công việc dư thừa. Bằng cách tổng hợp các phép dịch chuyển từ phải sang trái, chúng ta xác định được độ dịch chuyển ròng cho mỗi ký tự trong một lần duyệt duy nhất.

---
