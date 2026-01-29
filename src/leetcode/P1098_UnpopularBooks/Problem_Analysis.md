# 1098. Unpopular Books / Sách Không phổ biến

## Problem Description / Mô tả bài toán
Table `Books`: `book_id`, `name`, `available_from`.
Table `Orders`: `order_id`, `book_id`, `quantity`, `dispatch_date`.
Write an SQL query to report the books that have sold **less than 10 copies** in the last year, excluding books that have been available for less than one month from today. Assume today is `2019-06-23`.
Viết một truy vấn SQL để báo cáo các cuốn sách đã bán **ít hơn 10 bản** trong năm ngoái, loại trừ các cuốn sách đã có sẵn ít hơn một tháng kể từ ngày hôm nay. Giả sử hôm nay là `2019-06-23`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Date Filtering and Left Join
1. Filter `Books` available before `2019-05-23` (one month before).
2. Left Join `Orders` filtered by `dispatch_date` between `2018-06-23` and `2019-06-23`.
3. Group by `book_id`.
4. Having `SUM(quantity) < 10` (or sum is null, treat as 0).

---
