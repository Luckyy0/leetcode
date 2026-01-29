# 1081. Smallest Subsequence of Distinct Characters / Chuỗi con Ký tự Phân biệt Nhỏ nhất theo Thứ tự Từ điển

## Problem Description / Mô tả bài toán
Return the lexicographically smallest subsequence of `s` that contains all the distinct characters of `s` exactly once.
Trả về chuỗi con nhỏ nhất theo thứ tự từ điển của `s` chứa tất cả các ký tự phân biệt của `s` chính xác một lần.

Note: This problem is the same as 316. Remove Duplicate Letters.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Monotonic Stack / Ngăn xếp Đơn điệu
Algorithm:
1. Count frequency of all characters.
2. Use a `boolean[] visited` to track characters in stack.
3. Iterate chars `c` in `s`:
   - Decrement frequency of `c`.
   - If `c` is visited, continue.
   - While stack is not empty and `top > c` and `freq[top] > 0`:
     - Pop `top`.
     - `visited[top] = false`.
   - Push `c`.
   - `visited[c] = true`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) (26 chars).

---

## Analysis / Phân tích

### Approach: Greedy Stack with Preservation
Iterate through the string, maintaining a monotonic increasing stack of characters. If a character is encountered that is smaller than the stack's top and the top character appears again later (checked via precomputed frequency counts), pop the stack to allow for a lexicographically smaller placement. Ensure each character is included exactly once.
Lặp qua chuỗi, duy trì một ngăn xếp tăng đơn điệu của các ký tự. Nếu gặp một ký tự nhỏ hơn đỉnh ngăn xếp và ký tự đỉnh xuất hiện lại sau này (được kiểm tra thông qua số liệu tần suất được tính trước), hãy pop ngăn xếp để cho phép sắp xếp nhỏ hơn theo thứ tự từ điển. Đảm bảo mỗi ký tự được bao gồm chính xác một lần.

---
