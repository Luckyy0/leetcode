# Result for Customer Placing the Largest Number of Orders
# *Kết quả cho bài toán Khách hàng Đặt nhiều Đơn hàng nhất*

## Description
## *Mô tả*

**SQL Schema**

Table: `Orders`
```
+-----------------+----------+
| Column Name     | Type     |
+-----------------+----------+
| order_number    | int      |
| customer_number | int      |
+-----------------+----------+
order_number is the primary key for this table.
This table contains information about the order ID and the customer ID.
```

Write an SQL query to find the `customer_number` for the customer who has placed **the largest number of orders**.
*Viết một truy vấn SQL để tìm `customer_number` của khách hàng đã đặt **số lượng đơn hàng lớn nhất**.*

The test cases are generated so that **exactly one customer** will have placed more orders than any other customer.
*Các trường hợp kiểm thử được tạo ra sao cho **chính xác một khách hàng** sẽ đặt nhiều đơn hàng hơn bất kỳ khách hàng nào khác.*

The query result format is in the following example.
*Định dạng kết quả truy vấn theo ví dụ sau.*

## Example 1:
## *Ví dụ 1:*

**Input:** 
Orders table:
```
+--------------+-----------------+
| order_number | customer_number |
+--------------+-----------------+
| 1            | 1               |
| 2            | 2               |
| 3            | 3               |
| 4            | 3               |
+--------------+-----------------+
```
**Output:** 
```
+-----------------+
| customer_number |
+-----------------+
| 3               |
+-----------------+
```
**Explanation:** 
The customer with number 3 has two orders, which is greater than either customer 1 or 2 because each of them only has one order. 
So the result is customer_number 3.

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.

## Follow up:
What if multiple customers have the same largest number of orders? Can you find all the `customer_number` in this case?
*Điều gì sẽ xảy ra nếu nhiều khách hàng có cùng số lượng đơn hàng lớn nhất? Bạn có thể tìm thấy tất cả các `customer_number` trong trường hợp này không?*
