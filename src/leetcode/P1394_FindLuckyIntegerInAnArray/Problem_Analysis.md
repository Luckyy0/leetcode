# 1394. Find Lucky Integer in an Array / Tìm Số Nguyên May Mắn trong Mảng

## Problem Description / Mô tả bài toán
Lucky integer: integer `x` such that its frequency is `x`.
Return largest lucky integer. If none, -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Frequency Map
Count frequencies.
Iterate map. Check `key == value`.
Find max `key`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Hash Map
Use a HashMap to count occurrences of each number. Iterate through the map entries. If a key equals its value, compare it with the current maximum. Return -1 if no lucky integer is found.
Sử dụng HashMap để đếm số lần xuất hiện của mỗi số. Lặp lại qua các mục bản đồ. Nếu một khóa bằng giá trị của nó, hãy so sánh nó với mức tối đa hiện tại. Trả về -1 nếu không tìm thấy số nguyên may mắn nào.

---
