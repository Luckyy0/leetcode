# 1405. Longest Happy String / Chuỗi Hạnh phúc Dài nhất

## Problem Description / Mô tả bài toán
Ints `a`, `b`, `c`. Return longest string with 'a', 'b', 'c' s.t. no "aaa", "bbb", "ccc".

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy with Max Heap
Always pick the character with the highest remaining count.
Unless picking it would cause "aaa" (same as previous 2).
In that case, pick the second highest count.
If no second highest (only one type left and blocked), stop.

### Complexity / Độ phức tạp
- **Time**: O(N) where N = a+b+c.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Priority Queue
Use a Max Heap to store counts of 'a', 'b', 'c'.
Loop:
1. Pop char with max count `(c1, char1)`.
2. Check if picking `char1` violates "no 3 consecutive".
   - Violation if last 2 chars appended were `char1`.
3. If violation:
   - If heap empty, break (can't proceed).
   - Pop `(c2, char2)`. Append `char2`. `c2--`. If `c2 > 0` push back.
   - Push `(c1, char1)` back.
4. If no violation:
   - Append `char1`. `c1--`. If `c1 > 0` push back.
Return string.
Sử dụng Max Heap để lưu trữ tần suất của 'a', 'b', 'c'.
Vòng lặp:
1. Pop ký tự có số đếm tối đa `(c1, char1)`.
2. Kiểm tra xem việc chọn `char1` có vi phạm "không có 3 liên tiếp" hay không.
3. Nếu vi phạm:
   - Nếu heap trống, break.
   - Pop `(c2, char2)`. Thêm `char2`. `c2--`.
   - Đẩy `(c1, char1)` trở lại.
4. Nếu không vi phạm:
   - Thêm `char1`. `c1--`.
Trả về chuỗi.

---
