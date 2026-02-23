# Result for Trips and Users
# *Kết quả cho bài toán Chuyến đi và Người dùng*

## Description
## *Mô tả*

Table: `Trips`

| Column Name | Type |
| :--- | :--- |
| id | int |
| client_id | int |
| driver_id | int |
| city_id | int |
| status | enum |
| request_at | date |

*   `id` is the primary key for this table.
*   The table holds all taxi trips. Each trip has a unique `id`, while `client_id` and `driver_id` are foreign keys to the `id` column of the `Users` table.
*   `status` is an ENUM type of `('completed', 'cancelled_by_driver', 'cancelled_by_client')`.

Table: `Users`

| Column Name | Type |
| :--- | :--- |
| users_id | int |
| banned | enum |
| role | enum |

*   `users_id` is the primary key for this table.
*   The table holds all users. Each user has a unique `users_id`, and `role` is an ENUM type of `('client', 'driver', 'partner')`.
*   `banned` is an ENUM type of `('Yes', 'No')`.

The **cancellation rate** is computed by dividing the number of canceled (by client or driver) requests with unbanned users by the total number of requests with unbanned users on that day.
*Tỷ lệ hủy được tính bằng cách chia số lượng yêu cầu bị hủy (bởi khách hàng hoặc tài xế) với người dùng không bị cấm cho tổng số yêu cầu với người dùng không bị cấm trong ngày đó.*

Write a SQL query to find the **cancellation rate** of requests with unbanned users (both client and driver must not be banned) each day between `"2013-10-01"` and `"2013-10-03"`.
*Viết câu lệnh SQL để tìm **tỷ lệ hủy** của các yêu cầu với người dùng không bị cấm (cả khách hàng và tài xế đều không bị cấm) mỗi ngày trong khoảng từ `"2013-10-01"` đến `"2013-10-03"`.*

Round the cancellation rate to **two decimal points**.
*Làm tròn tỷ lệ hủy đến **hai chữ số thập phân**.*

Return the result table in **any order**.
