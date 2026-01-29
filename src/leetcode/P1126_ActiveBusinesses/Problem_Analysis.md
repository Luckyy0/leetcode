# 1126. Active Businesses / Doanh nghiệp Hoạt động

## Problem Description / Mô tả bài toán
Table `Events`: `business_id`, `event_type`, `occurences`.
Write an SQL query to find all active businesses.
An active business is a business that has more than one event type with occurrences greater than the average occurrences of that event type among all businesses.
Một doanh nghiệp hoạt động là doanh nghiệp có nhiều hơn một loại sự kiện với số lần xuất hiện lớn hơn số lần xuất hiện trung bình của loại sự kiện đó trong tất cả các doanh nghiệp.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Window Functions (AVG OVER) / Hàm Cửa sổ SQL
1. Calculate average occurrences for each event type: `AVG(occurences) OVER (PARTITION BY event_type)`.
2. Filter rows where occurrence > average.
3. Group by `business_id` and count these active event types.
4. Keep if count > 1.

---
