# 784. Letter Case Permutation / Hoán vị Kiểu chữ

## Problem Description / Mô tả bài toán
Given a string `s`, you can transform every letter individually to be lowercase or uppercase to create another string.
Cho một chuỗi `s`, bạn có thể chuyển đổi từng chữ cái riêng lẻ thành chữ thường hoặc chữ hoa để tạo ra một chuỗi khác.

Return a list of all possible strings we could create.
Trả về danh sách tất cả các chuỗi có thể tạo ra.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking / DFS / Quay lui / DFS
Each letter presents a choice: keep it as it is, or flip its case. Digits offer no choice.
Mỗi chữ cái đưa ra một lựa chọn: giữ nguyên hoặc đổi kiểu chữ. Chữ số không có lựa chọn nào.

Algorithm:
1. Start at `index = 0`.
2. If `s[index]` is a digit, move to `index + 1`.
3. If `s[index]` is a letter, explore two paths:
   - Lowercase.
   - Uppercase.
4. When `index == length`, add the result to the list.

### Complexity / Độ phức tạp
- **Time**: O(2^L * N) where L is the number of letters and N is length of string.
- **Space**: O(2^L * N).

---

## Analysis / Phân tích

### Approach: Recursive Choice Tree
Traverse the string and branch out for every alphabetic character encountered.
Duyệt qua chuỗi và phân nhánh cho mỗi ký tự chữ cái gặp phải.

---
