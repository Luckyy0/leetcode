# Customers Who Bought All Products
# *Những Khách Hàng Đã Mua Lông Toàn Bộ Sản Phẩm*

## Description
## *Mô tả*

Table: `Customer`
*Bảng: `Customer`*

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| customer_id | int     |
| product_key | int     |
+-------------+---------+
This table may contain duplicates rows. 
Bảng này có thể chứa các hàng dữ liệu bị lặp lại (trùng lặp).
customer_id is not NULL.
customer_id không được phép có giá trị Rỗng (NULL).
product_key is a foreign key (reference column) to Product table.
product_key là Khóa Ngoại (cột tham chiếu chéo) trỏ sang bảng Product.
```

Table: `Product`
*Bảng: `Product`*

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| product_key | int     |
+-------------+---------+
product_key is the primary key (column with unique values) for this table.
product_key mang danh Khóa Chính (cột chứa những giá trị độc nhất vô nhị) dùng cho bảng này.
```

Write a solution to report the customer ids from the `Customer` table that bought all the products in the `Product` table.
*Hãy rặn ra một câu lệnh chiết xuất danh sách các `customer_id` (Mã người tiêu dùng) trích từ bảng `Customer` mà thể hiện chân dung những vị đại gia đã mua Sạch Bách vếch cạn Toàn Bộ các loại Sản Phẩm có mặt niêm yết trong bảng `Product`.*

Return the result table in **any order**.
*Trả về bảng dữ liệu kết quả theo **tùy ý bất kỳ thứ tự nào**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** 
Customer table:
```
+-------------+-------------+
| customer_id | product_key |
+-------------+-------------+
| 1           | 5           |
| 2           | 6           |
| 3           | 5           |
| 3           | 6           |
| 1           | 6           |
+-------------+-------------+
```
Product table:
```
+-------------+
| product_key |
+-------------+
| 5           |
| 6           |
+-------------+
```
**Output:** 
```
+-------------+
| customer_id |
+-------------+
| 1           |
| 3           |
+-------------+
```
**Explanation:** 
*Giải thích:*
The customers who bought all the products (5 and 6) are customers with IDs 1 and 3.
*Những nhà tài phiệt nhặt trọn bộ toàn bộ các mã sản phẩm (Mã 5 và Mã 6) trên kho kệ đích thị là Mấy ông khách vác Nhãn ID Số 1 và Số 3.*
