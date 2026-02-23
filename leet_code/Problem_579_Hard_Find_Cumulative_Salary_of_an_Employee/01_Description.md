# Result for Find Cumulative Salary of an Employee
# *Kết quả cho bài toán Tìm Lương Tích lũy của một Nhân viên*

## Description
## *Mô tả*

**SQL Schema**

Table: `Employee`
```
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| month       | int  |
| salary      | int  |
+-------------+------+
(id, month) is the primary key for this table.
Each row in the table indicates the salary of an employee in a specific month during the year 2020.
```

Write an SQL query to calculate the **cumulative salary summary** for every employee each month in 2020.
*Viết một truy vấn SQL để tính toán **tổng hợp lương tích lũy** cho mỗi nhân viên hàng tháng trong năm 2020.*

The **cumulative salary summary** for an employee in month `m` is the sum of their salaries from month `m`, `m-1`, and `m-2`. It is the sum of at most three months of salaries. However, you should **exclude** the most recent month for every employee (the month with the highest value).
* **Tổng hợp lương tích lũy** cho một nhân viên trong tháng `m` là tổng tiền lương của họ từ tháng `m`, `m-1`, và `m-2`. Đó là tổng số tiền lương tối đa ba tháng. Tuy nhiên, bạn nên **loại bỏ** tháng gần nhất đối với mỗi nhân viên (tháng có giá trị cao nhất).*

Return the result table ordered by `id` ascending then by `month` descending.
*Trả về bảng kết quả được sắp xếp theo `id` tăng dần sau đó theo `month` giảm dần.*

The query result format is in the following example.
*Định dạng kết quả truy vấn theo ví dụ sau.*

## Example 1:
## *Ví dụ 1:*

**Input:** 
Employee table:
```
+----+-------+--------+
| id | month | salary |
+----+-------+--------+
| 1  | 1     | 20     |
| 2  | 1     | 20     |
| 1  | 2     | 30     |
| 2  | 2     | 30     |
| 3  | 2     | 40     |
| 1  | 3     | 40     |
| 3  | 3     | 60     |
| 1  | 4     | 60     |
| 3  | 4     | 70     |
+----+-------+--------+
```
**Output:** 
```
+----+-------+--------+
| id | month | Salary |
+----+-------+--------+
| 1  | 3     | 90     |
| 1  | 2     | 50     |
| 1  | 1     | 20     |
| 2  | 1     | 20     |
| 3  | 3     | 100    |
| 3  | 2     | 40     |
+----+-------+--------+
```
**Explanation:** 
Employee '1':
- Month 4 is the most recent month, so exclude it.
- Month 3: Salary sum = 40 (month 3) + 30 (month 2) + 20 (month 1) = 90.
- Month 2: Salary sum = 30 (month 2) + 20 (month 1) = 50.
- Month 1: Salary sum = 20 (month 1).
- Result: [[1, 3, 90], [1, 2, 50], [1, 1, 20]].
... and similarly for other employees.

## Constraints:
## *Ràng buộc:*

*   The record for an employee in the table only comes from the year 2020.
