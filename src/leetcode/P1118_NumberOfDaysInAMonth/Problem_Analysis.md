# 1118. Number of Days in a Month / Số ngày trong Một Tháng

## Problem Description / Mô tả bài toán
Given a year `Y` and a month `M`, return the number of days in that month.
Cho một năm `Y` và một tháng `M`, hãy trả về số ngày trong tháng đó.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Calendar Logic / Leap Year / Logic Lịch / Năm Nhuận
Days mapping:
1, 3, 5, 7, 8, 10, 12 -> 31
4, 6, 9, 11 -> 30
2 -> 28 or 29 (Leap year)

Leap Year: `(Y % 4 == 0 && Y % 100 != 0) || (Y % 400 == 0)`.

---
