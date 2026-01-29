# 727. Minimum Window Subsequence / Chuỗi con Cửa sổ Tối thiểu

## Problem Description / Mô tả bài toán
Given strings `s1` and `s2`, return the minimum contiguous substring of `s1` such that `s2` is a **subsequence** of the substring.
Cho các chuỗi `s1` và `s2`, hãy trả về chuỗi con liên tiếp tối thiểu của `s1` sao cho `s2` là một **chuỗi con (không nhất thiết liên tiếp)** của chuỗi con đó.

If there is no such window in `s1` that covers all characters in `s2`, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.
Nếu không có cửa sổ nào như vậy trong `s1` bao phủ tất cả các ký tự trong `s2`, hãy trả về chuỗi trống "". Nếu có nhiều cửa sổ có độ dài tối thiểu như vậy, hãy trả về cửa sổ có chỉ số bắt đầu ngoài cùng bên trái.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming or Two Pointers / Quy hoạch Động hoặc Hai con Trỏ
We can use a "forward and backward" two-pointer approach for efficiency.
Chúng ta có thể sử dụng phương pháp hai con trỏ "tiến và lùi" để đạt hiệu quả.

1. **Forward**: Iterate through `s1` looking for characters of `s2` in order. When the last character of `s2` is found, the window `[start, end]` contains `s2` as a subsequence.
2. **Backward**: From the `end` position, walk backwards through `s1` to find the last possible occurrences of `s2` characters. This helps shrink the window from the left to its minimal size.

### Complexity / Độ phức tạp
- **Time**: O(N * M) but practically much faster.
- **Space**: O(1) beyond input storage.

---

## Analysis / Phân tích

### Approach: Two-Way Scan
Search for a valid window moving forward. Once found, retract from the right moving backward to minimize the start index. Repeat starting from after the current window's start.
Tìm kiếm một cửa sổ hợp lệ di chuyển về phía trước. Sau khi tìm thấy, thu hồi từ bên phải di chuyển ngược lại để giảm thiểu chỉ số bắt đầu. Lặp lại bắt đầu từ sau điểm bắt đầu của cửa sổ hiện tại.

---
