# 921. Minimum Add to Make Parentheses Valid / Số lượng Dấu ngoặc cần thêm tối thiểu để hợp lệ

## Problem Description / Mô tả bài toán
Given a string `s` of '(' and ')' characters, return the minimum number of parentheses we prefix or append in any order to make the resulting string valid.
Cho một chuỗi `s` gồm các ký tự '(' và ')', hãy trả về số lượng dấu ngoặc ít nhất cần thêm vào đầu hoặc cuối chuỗi theo bất kỳ thứ tự nào để tạo thành một chuỗi hợp lệ.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Balance Counting / Đếm số dư
Algorithm:
1. Maintain `balance` (number of open parentheses not yet closed).
2. Maintain `addCount` (number of signs needed to be added).
3. For each char:
   - If `(`: `balance++`.
   - If `)`:
     - If `balance > 0`, `balance--`.
     - Else, `addCount++` (need an open bracket for this closing one).
4. Final result = `addCount + balance` (remaining open brackets need closing).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Structural Equilibrium Tracking
Monitor the "deficit" and "surplus" of parentheses dynamically. Every closing bracket that lacks a preceding opener represents a required addition, as does every opening bracket left dangling at the end.
Theo dõi động "sự thiếu hụt" và "dư thừa" của các dấu ngoặc. Mọi dấu ngoặc đóng thiếu dấu ngoặc mở phía trước đều đại diện cho một phần cần thêm vào, tương tự như mọi dấu ngoặc mở bị bỏ lửng ở cuối chuỗi.

---
