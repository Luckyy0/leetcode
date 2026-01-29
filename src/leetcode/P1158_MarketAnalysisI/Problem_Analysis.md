# 1158. Market Analysis I / Phân tích Thị trường I

## Problem Description / Mô tả bài toán
Table `Users`: `user_id`, `join_date`, `favorite_brand`.
Table `Orders`: `order_id`, `order_date`, `item_id`, `buyer_id`, `seller_id`.
Table `Items`: `item_id`, `item_brand`.
Write an SQL query to find for each user, the join date and number of orders they made as a buyer in 2019.
Viết một truy vấn SQL để tìm cho mỗi người dùng, ngày tham gia và số lượng đơn đặt hàng họ đã thực hiện với tư cách là người mua vào năm 2019.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Left Join with Filter
1. Select from `Users`.
2. Left join `Orders` where `order_date` is in 2019.
3. Group by `user_id`.
4. Count orders.

---
