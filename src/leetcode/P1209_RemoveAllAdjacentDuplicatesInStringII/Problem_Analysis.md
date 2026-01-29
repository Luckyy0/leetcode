# 1209. Remove All Adjacent Duplicates in String II / Xóa Tất cả các Bản sao Liền kề trong Chuỗi II

## Problem Description / Mô tả bài toán
Given string `s` and integer `k`, repeatedly remove `k` adjacent duplicates.
E.g. `s = "deeedbbcccbdaa", k = 3`.
"eee" removed -> "ddbbcccbdaa". "ccc" removed -> "ddbbbdaa". "bbb" removed -> "dddaa". "ddd" removed -> "aa".

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Stack with Counting / Ngăn xếp với Đếm
Stack of `Pair(char, count)`.
Iterate char `c`:
- If stack empty or top char != `c`: push `(c, 1)`.
- If top char == `c`:
  - Increment top count.
  - If count == `k`: pop.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Stack Aggregation
Use a stack to store characters along with their consecutive counts `(char, count)`. When traversing the string:
1. If the current character matches the stack's top character, increment the count. If the count reaches `k`, pop the element (effectively removing the sequence).
2. If the current character differs, push it onto the stack with a count of 1.
After processing, reconstruct the string from the remaining stack elements.
Sử dụng ngăn xếp để lưu trữ các ký tự cùng với số lượng liên tiếp của chúng `(char, count)`. Khi duyệt chuỗi:
1. Nếu ký tự hiện tại khớp với ký tự ở đầu ngăn xếp, hãy tăng số đếm. Nếu số đếm đạt đến `k`, hãy lấy phần tử ra (xóa chuỗi một cách hiệu quả).
2. Nếu ký tự hiện tại khác, hãy đẩy nó vào ngăn xếp với số đếm là 1.
Sau khi xử lý, hãy tái tạo chuỗi từ các phần tử ngăn xếp còn lại.

---
