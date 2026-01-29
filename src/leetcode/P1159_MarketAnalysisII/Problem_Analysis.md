# 1159. Market Analysis II / Phân tích Thị trường II

## Problem Description / Mô tả bài toán
Find for each user whether the brand of the second item (by date) they sold is their favorite brand. If a user sold fewer than 2 items, report "no".
Sorted by `user_id`.
Tìm xem đối với mỗi người dùng, nhãn hiệu của mặt hàng thứ hai (theo ngày tháng) họ bán có phải là nhãn hiệu yêu thích của họ không. Nếu người dùng bán ít hơn 2 mặt hàng, hãy báo cáo "no".
Sắp xếp theo `user_id`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Ranking (ROW_NUMBER) and Join
1. Rank sales for each seller by date ASC.
2. Select rows where rank = 2.
3. Join with Items to get brand.
4. Join with Users to check favorite brand.
5. Outer join all Users to handle those with < 2 sales.

---
