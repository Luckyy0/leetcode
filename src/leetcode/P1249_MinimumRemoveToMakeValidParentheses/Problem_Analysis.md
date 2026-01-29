# 1249. Minimum Remove to Make Valid Parentheses / Xóa Tối thiểu để Tạo Dấu ngoặc Hợp lệ

## Problem Description / Mô tả bài toán
Given string `s` of '(', ')' and letters.
Remove min parenthesis to make valid.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Stack / Two Passes
Stack method:
1. Iterate string.
2. If `(`, push index to stack.
3. If `)`, stack empty -> invalid `)`. Mark for removal.
   Stack not empty -> pop (match).
4. After loop, if stack not empty (`(` left), mark them for removal.
5. Rebuild string skipping marked.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Stack and Set
Use a stack to track indices of open parentheses. Traverse the string: if `(` is found, push its index. If `)` is found: if the stack is non-empty, pop (match found); otherwise, the `)` is unmatched and must be removed (add index to a removal set). After traversing, any indices remaining in the stack represent unmatched `(`; add them to the removal set. Construct the result string by excluding characters at indices in the set.
Sử dụng một ngăn xếp để theo dõi các chỉ số của dấu ngoặc đơn mở. Duyệt chuỗi: nếu tìm thấy `(`, đẩy chỉ số của nó vào. Nếu tìm thấy `)`: nếu ngăn xếp không rỗng, hãy lấy ra (tìm thấy khớp); nếu không, `)` không khớp và phải bị xóa (thêm chỉ số vào tập hợp xóa). Sau khi duyệt, mọi chỉ số còn lại trong ngăn xếp đại diện cho `(` không khớp; thêm chúng vào tập hợp xóa. Xây dựng chuỗi kết quả bằng cách loại trừ các ký tự tại các chỉ số trong tập hợp.

---
