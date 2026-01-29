# 1185. Day of the Week / Ngày trong Tuần

## Problem Description / Mô tả bài toán
Given `day`, `month`, `year`, return the day of the week (e.g. "Sunday").
Input is valid date. 1971 to 2100.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Zeller's Congruence / Java API / Công thức Zeller / Java API
Use built-in `java.time.LocalDate`.
Or Zeller's congruence via math.
Or simple counting from a reference date (1971-01-01 was Friday).

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Reference Date Counting
Calculate the total number of days elapsed since a known reference date (e.g., Friday, Jan 1, 1971). Account for days in each month and leap years correctly. Take the total days modulo 7 to determine the offsets.
Tính tổng số ngày trôi qua kể từ một ngày tham chiếu đã biết (ví dụ: Thứ Sáu, ngày 1 tháng 1 năm 1971). Tính toán số ngày trong mỗi tháng và năm nhuận một cách chính xác. Lấy tổng số ngày modulo 7 để xác định độ lệch.

---
