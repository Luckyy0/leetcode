# 1324. Print Words Vertically / In Từ theo Chiều dọc

## Problem Description / Mô tả bài toán
String `s` containing words separated by space.
Return list of strings representing vertical columns.
Remove trailing spaces.
"HOW ARE YOU" ->
H A Y
O R O
W E U

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Array Traversal
Split string into words.
Find max length `maxLen`.
Iterate column `c` from 0 to `maxLen - 1`.
Construct string for column `c`:
- Iterate each word `w`.
- If `c < w.length()`, append `w[c]`.
- Else, append space ' '.
- **Important**: Trim trailing spaces from right.

### Complexity / Độ phức tạp
- **Time**: O(N * MaxLen).
- **Space**: O(N * MaxLen).

---

## Analysis / Phân tích

### Approach: Column Iteration
Split the input string `s` into words. Find the maximum length among all words (`maxLen`). Iterate `j` from 0 to `maxLen - 1`. In each iteration, construct the `j-th` vertical word by checking the `j-th` character of each word in the list. If a word is too short, append a space. After constructing the vertical string, remove any trailing spaces (as per requirement).
Chia chuỗi đầu vào `s` thành các từ. Tìm độ dài tối đa trong số tất cả các từ (`maxLen`). Lặp lại `j` từ 0 đến `maxLen - 1`. Trong mỗi lần lặp, xây dựng từ dọc thứ `j` bằng cách kiểm tra ký tự thứ `j` của mỗi từ trong danh sách. Nếu một từ quá ngắn, hãy thêm dấu cách. Sau khi xây dựng chuỗi dọc, hãy xóa mọi dấu cách ở cuối (theo yêu cầu).

---
