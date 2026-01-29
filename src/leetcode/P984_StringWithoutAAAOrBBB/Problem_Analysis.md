# 984. String Without AAA or BBB / Chuỗi Không có AAA hoặc BBB

## Problem Description / Mô tả bài toán
Given two integers `a` and `b`, return **any** string `s` such that:
Cho hai số nguyên `a` và `b`, hãy trả về **bất kỳ** chuỗi `s` nào sao cho:
- `s` has length `a + b` and contains exactly `a` 'a' letters, and exactly `b` 'b' letters.
- The substring 'aaa' does not occur in `s`.
- The substring 'bbb' does not occur in `s`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Selection based on Remaining Counts / Lựa chọn Tham lam dựa trên Số lượng Còn lại
Algorithm:
1. Iterate `a + b` times.
2. At each step, decide whether to use 'a' or 'b'.
3. A character can be used if:
   - It has the higher remaining count.
   - OR the *other* character was just used twice in a row.
   - AND we are not about to create a triplet.

Simpler logic:
- If `a > b`, prefer writing "aab".
- If `b > a`, prefer writing "bba".
- If `a == b`, write "ab".

### Complexity / Độ phức tạp
- **Time**: O(A + B).
- **Space**: O(A + B).

---

## Analysis / Phân tích

### Approach: Adaptive Balanced placement
Incrementally build the string by prioritizing the character with the larger remaining pool. By imposing a local check to prevent three-in-a-row, we satisfy the "triplet-free" constraint while ensuring both character budgets are exhausted exactly.
Xây dựng chuỗi theo cách tăng dần bằng cách ưu tiên ký tự có lượng còn lại lớn hơn. Bằng cách áp dụng kiểm tra cục bộ để ngăn ba ký tự giống nhau liên tiếp, chúng ta thỏa mãn ràng buộc "không có bộ ba" đồng thời đảm bảo cả hai ngân sách ký tự đều được sử dụng hết một cách chính xác.

---
