# 1003. Check If Word Is Valid After Substitutions / Kiểm tra xem Từ có hợp lệ sau khi Thay thế hay không

## Problem Description / Mô tả bài toán
Given a string `s`, determine if it can be valid.
A string is valid if:
- It is empty.
- It can be written as `x + "abc" + y`, where `x` and `y` are valid strings.

Basically, can we reduce `s` to an empty string by repeatedly removing "abc"?
Về cơ bản, liệu chúng ta có thể giảm `s` thành một chuỗi rỗng bằng cách loại bỏ liên tục "abc" hay không?

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Stack-based Reduction / Giảm trừ dựa trên Ngăn xếp
Algorithm:
1. Iterate through `s`.
2. Push characters onto a stack (or use StringBuilder as a stack).
3. Whenever we push 'c', check if the top two elements are 'b' and 'a'.
   - If yes, pop 'a', 'b', and 'c' (essentially remove "abc").
   - If no, keep 'c'.
4. If the stack is empty at the end, returning true.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Pattern Collapse
Simulate the reverse process of construction. Treat "abc" as a collapsible unit. Using a stack, accumulate characters until the sequence "abc" is detected at the top, effectively cancelling it out. If the entire string collapses to nothing, it is valid.
Mô phỏng quá trình xây dựng ngược. Coi "abc" là một đơn vị có thể thu gọn. Sử dụng ngăn xếp, tích lũy các ký tự cho đến khi chuỗi "abc" được phát hiện ở trên cùng, giúp loại bỏ nó một cách hiệu quả. Nếu toàn bộ chuỗi thu gọn thành không có gì, nó là hợp lệ.

---
