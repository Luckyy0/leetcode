# 1285. Find the Start and End Number of Continuous Ranges / Tìm Số Bắt đầu và Kết thúc của Các Khoảng Liên tục

## Problem Description / Mô tả bài toán
Table `Logs`: `log_id`.
Find continuous ranges of logs.
Result: `start_id`, `end_id`.
Order by `start_id`.
Example: 1, 2, 3, 7, 8, 10.
Ranges: [1, 3], [7, 8], [10, 10].

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Gaps and Islands / Khoảng trống và Đảo
Classic problem.
1. Assign Row Number `rn` ordered by `log_id`.
2. Compute `grp = log_id - rn`.
   - Continuous ids will have constant `grp`.
   - 1-1=0, 2-2=0, 3-3=0.
   - 7-4=3, 8-5=3.
   - 10-6=4.
3. Group by `grp`.
4. `start_id` is MIN(log_id), `end_id` is MAX(log_id).

### Complexity / Độ phức tạp
- **Time**: SQL Complexity. O(N log N) sort.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Row Number Trick
Use the `ROW_NUMBER()` trick to identify continuous ranges. If IDs `p1, p2, p3...` are consecutive, then `p1 - 1`, `p2 - 2`, `p3 - 3`, etc., will produce the same constant value. Assign a row number `rn` to each ID ordered by `log_id`. Calculate the difference `log_id - rn`. Group by this difference. For each group, `MIN(log_id)` is the start and `MAX(log_id)` is the end.
Sử dụng thủ thuật `ROW_NUMBER()` để xác định các phạm vi liên tục. Nếu các ID `p1, p2, p3...` liên tiếp, thì `p1 - 1`, `p2 - 2`, `p3 - 3`, v.v., sẽ tạo ra cùng một giá trị hằng số. Gán số hàng `rn` cho mỗi ID được sắp xếp theo `log_id`. Tính toán sự khác biệt `log_id - rn`. Nhóm theo sự khác biệt này. Đối với mỗi nhóm, `MIN(log_id)` là điểm bắt đầu và `MAX(log_id)` là điểm kết thúc.

---
