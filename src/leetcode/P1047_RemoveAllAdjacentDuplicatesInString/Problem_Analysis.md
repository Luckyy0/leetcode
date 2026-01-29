# 1047. Remove All Adjacent Duplicates In String / Xóa Tất cả các Bản sao Liền kề trong Chuỗi

## Problem Description / Mô tả bài toán
You are given a string `s` consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
Bạn được cho một chuỗi `s` gồm các chữ cái tiếng Anh viết thường. Việc xóa bản sao bao gồm việc chọn hai chữ cái liền kề và bằng nhau và xóa chúng.

We repeatedly make duplicate removals on `s` until we no longer can. Return the final string.
Chúng ta lặp đi lặp lại việc xóa bản sao trên `s` cho đến khi không thể làm được nữa. Trả về chuỗi cuối cùng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Stack / StringBuilder as Stack / Ngăn xếp / StringBuilder làm Ngăn xếp
Algorithm:
1. Iterate through characters `c` in `s`.
2. Check if `c` is equal to the "top" of our stack/buffer.
   - If yes (`sb.length > 0` and `sb.lastChar == c`), pop stack (delete last char).
   - If no, push `c` to stack (append to sb).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) for output string.

---

## Analysis / Phân tích

### Approach: Stack-Based Cancellation
Process characters sequentially. Utilize a stack (or the end of a StringBuilder) to keep track of the current string state. If the incoming character matches the top of the stack, cancel both out (pop). Otherwise, add the character (push). This resolves recursive adjacent duplicates in a single pass.
Xử lý các ký tự theo tuần tự. Sử dụng ngăn xếp (hoặc phần cuối của StringBuilder) để theo dõi trạng thái chuỗi hiện tại. Nếu ký tự đến khớp với phần đầu của ngăn xếp, hãy hủy cả hai (pop). Nếu không, hãy thêm ký tự (push). Điều này giải quyết các bản sao liền kề đệ quy trong một lần duyệt.

---
