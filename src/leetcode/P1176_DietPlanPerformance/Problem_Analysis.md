# 1176. Diet Plan Performance / Hiệu suất Kế hoạch Ăn kiêng

## Problem Description / Mô tả bài toán
A dieter consumes `calories[i]` calories on the `i-th` day.
Given an integer `k`, for every consecutive sequence of `k` days (`calories[i], ..., calories[i+k-1]`), they look at `T` (total calories).
- If `T < lower`, they lose 1 point.
- If `T > upper`, they gain 1 point.
- Otherwise, 0 points.
Return the total points.
Một người ăn kiêng tiêu thụ `calories[i]` calo vào ngày thứ `i`.
Cho một số nguyên `k`, đối với mọi chuỗi `k` ngày liên tiếp (`calories[i], ..., calories[i+k-1]`), họ xem xét `T` (tổng lượng calo).
- Nếu `T < lower`, họ mất 1 điểm.
- Nếu `T > upper`, họ nhận được 1 điểm.
- Nếu không, 0 điểm.
Trả về tổng số điểm.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window / Cửa sổ Trượt
Maintain a sum of window size `k`.
Slide window: subtract outgoing, add incoming.
Check condition.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Fixed Rolling Sum
Use a sliding window of size `k` to maintain the sum of calories for the current period. Initialize by summing the first `k` days. Evaluate the points. Then slide the window one day at a time: add the new day's calories and subtract the exiting day's calories. Evaluate and accumulate points at each step.
Sử dụng cửa sổ trượt có kích thước `k` để duy trì tổng lượng calo cho giai đoạn hiện tại. Khởi tạo bằng cách tính tổng `k` ngày đầu tiên. Đánh giá số điểm. Sau đó trượt cửa sổ mỗi lần một ngày: thêm lượng calo của ngày mới và trừ đi lượng calo của ngày thoát. Đánh giá và tích lũy điểm ở mỗi bước.

---
