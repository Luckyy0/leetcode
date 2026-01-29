# 844. Backspace String Compare / So sánh Chuỗi có Dấu xóa ngược

## Problem Description / Mô tả bài toán
Given two strings `s` and `t`, return `true` if they are equal when both are typed into empty text editors. `#` means a backspace character.
Cho hai chuỗi `s` và `t`, trả về `true` nếu chúng bằng nhau khi cả hai được nhập vào các trình soạn thảo văn bản trống. `#` đại diện cho ký tự xóa ngược (backspace).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Stack or Two Pointers (Reverse) / Ngăn xếp hoặc Hai con trỏ (Ngược)
Using a Stack is O(N) space.
Sử dụng Ngăn xếp mất O(N) không gian.

Optimization (O(1) space):
Iterate from the **end** of the strings.
Duyệt từ **cuối** chuỗi.

Algorithm:
1. Maintain two pointers at the end of `s` and `t`.
2. Keep track of how many backspaces we've encountered to skip characters.
3. Compare the first "real" character from the end for both strings.

### Complexity / Độ phức tạp
- **Time**: O(N + M).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Reverse scanning with Skip Counters
By moving backward, we process characters only after determining if they would have been deleted by subsequent backspaces. This allows for a single-pass comparison without auxiliary storage.
Bằng cách di chuyển ngược lại, chúng ta chỉ xử lý các ký tự sau khi xác định xem chúng có bị xóa bởi các dấu xóa ngược sau đó hay không. Điều này cho phép so sánh trong một lần duyệt mà không cần lưu trữ phụ trợ.

---
