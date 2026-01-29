# 1360. Number of Days Between Two Dates / Số Ngày Giữa Hai Ngày

## Problem Description / Mô tả bài toán
Two dates "YYYY-MM-DD".
Absolute difference in days.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Date Conversion
Convert each date to "days since 1971-01-01" (or similar epoch).
Account for leap years.
Leap year: divisible by 4, not 100, unless 400.
Days in months: 31, 28/29, 31, 30...

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Days from Epoch
Implement a function `countDays(date)` that returns the number of days from a fixed start date (e.g., year 1971).
Sum days for full years passed.
Add days for months passed in current year.
Add day of month.
Difference is `abs(count1 - count2)`.
Or use Java `LocalDate`. "You can use standard libraries".
Using `java.time.LocalDate` is preferred.
Thực hiện hàm `countDays(date)` trả về số ngày từ ngày bắt đầu cố định (ví dụ: năm 1971).
Tổng số ngày cho các năm trôi qua.
Cộng số ngày cho các tháng trôi qua trong năm hiện tại.
Cộng ngày trong tháng.
Sự khác biệt là `abs(count1 - count2)`.

---
