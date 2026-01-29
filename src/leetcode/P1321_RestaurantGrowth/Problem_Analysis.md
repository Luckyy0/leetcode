# 1321. Restaurant Growth / Tăng trưởng Nhà hàng

## Problem Description / Mô tả bài toán
Table `Customer`: `customer_id`, `name`, `visited_on`, `amount`.
Compute moving average of `amount` for 7 days (including current day + 6 previous days).
Result: `visited_on`, `amount`, `average_amount`.
Round average to 2 decimal places.
Only include rows where there are at least 7 days of history (i.e., day >= min_date + 6).
Sorted by `visited_on` ascending.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Window Functions / Rolling Aggregation
Sum distinct customer amounts per day first.
Then use `SUM() OVER (ORDER BY visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW)`.
Also need to filter out first 6 days.
Wait. Rows between 6 preceding works if dates are consecutive.
But dates might be missing?
Problem says "visited_on is the date". If dates are missing, moving average logic should respect calendar days?
"Compute moving average of how much customer paid in a 7 days window (current day + 6 days before)".
If dates are missing in data, do we assume amount is 0?
Usually for SQL "moving average" on date, we should ensure all dates exist or use range. `RANGE BETWEEN INTERVAL 6 DAY PRECEDING AND CURRENT ROW`.
However, problem output only lists dates `visited_on` present in table (after filtering).
But for correct calculation, intermediate missing dates should count as 0.
Correct approach:
1. Aggregate daily total amounts.
2. Use Window Function with Range (or assume consecutive dates if guaranteed? Example has consecutive dates. But generally range is safer).
   Actually, usually these problems imply present dates. But "7 days window" implies calendar time.
   Common trick: Self Join or Window Function over Range.
   Or generates series of dates.
   Let's check constraints or standard interpretation.
   Standard: Sum amounts for `d` where `d` is between `current - 6` and `current`.
   Filter `visited_on >= (min_date + 6)`.

### Complexity / Độ phức tạp
- **Time**: O(N log N) typically.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Pre-aggregation and Self Join (or Window)
First, aggregate the data by `visited_on` to handle multiple customers on the same day. Let's call this `DailySum`.
To calculate the 7-day moving sum for a date `D`, we sum amounts from `DailySum` where date is between `D-6` and `D`.
We only output rows where `visited_on` is at least 6 days after the minimum `visited_on` in the table (ensuring a full 7-day window exists).
Query:
1. CTE `Daily` group by date.
2. Self join `Daily d1` and `Daily d2` where `d2.visited_on BETWEEN d1.visited_on - 6 AND d1.visited_on`.
   BUT this misses dates with 0 sales if they are not in `Daily`.
   If a date is not in `Daily`, it contributes 0. Self join only sums present dates. This is correct as non-present dates have 0 sum.
   We just need to check if the window spans 7 days.
   Actually, simpler: use window function `SUM(amount) OVER (ORDER BY visited_on ROWS 6 PRECEDING)`.
   **Warning**: `ROWS 6 PRECEDING` only works if dates are consecutive without gaps. If gaps exist, it will pick wrong 6 previous *available* days, not calendar days.
   If problem allows gaps, valid approach is `RANGE BETWEEN INTERVAL 6 DAY PRECEDING`.
   Many SQL dialects support `RANGE`. In standard LeetCode MySQL (8.0), `RANGE INTERVAL` works.
   Alternatively, join logic: `JOIN` on `datediff`.
   Constraints: "visited_on" are dates.
   Let's use Join approach for robustness if gaps exist. Or recursive CTE to fill gaps.
   Actually, if solution requires skipping dates with no customers in output, Join is fine.
   Wait, "average amount" is `total_amount / 7`. Sum is over 7 days. Even if some days have 0.
   So dividing by 7 is correct regardless of gaps (gaps are 0s).
   But we must ensure we sum calendar range.
   
Đầu tiên, tổng hợp dữ liệu theo `visited_on` để xử lý nhiều khách hàng trong cùng một ngày. Gọi đây là `DailySum`.
Để tính tổng di chuyển trong 7 ngày cho một ngày `D`, chúng ta cộng các khoản tiền từ `DailySum` trong đó ngày nằm trong khoảng từ `D-6` đến `D`.
Chúng ta chỉ xuất các hàng trong đó `visited_on` ít nhất là 6 ngày sau ngày `visited_on` tối thiểu trong bảng (đảm bảo cửa sổ 7 ngày đầy đủ tồn tại).
Truy vấn:
1. CTE `Daily` nhóm theo ngày.
2. Tự tham gia `Daily d1` và `Daily d2` trong đó `d2.visited_on BETWEEN d1.visited_on - 6 AND d1.visited_on`.
   NHƯNG điều này bỏ lỡ các ngày có 0 doanh số nếu chúng không có trong `Daily`.
   Nếu một ngày không có trong `Daily`, nó đóng góp 0. Tự tham gia chỉ tính tổng các ngày hiện tại. Điều này là chính xác vì các ngày không hiện tại có tổng bằng 0.
   Chúng ta chỉ cần kiểm tra xem cửa sổ có kéo dài 7 ngày hay không.
   Thực ra, đơn giản hơn: sử dụng hàm cửa sổ `SUM(amount) OVER (ORDER BY visited_on ROWS 6 PRECEDING)`.
   **Cảnh báo**: `ROWS 6 PRECEDING` chỉ hoạt động nếu các ngày liên tiếp không có khoảng trống. Nếu tồn tại khoảng trống, nó sẽ chọn sai 6 ngày *có sẵn* trước đó, không phải ngày theo lịch.

---
