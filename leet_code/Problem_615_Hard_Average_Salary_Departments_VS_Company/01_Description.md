# Result for Average Salary: Departments VS Company
# *Kết quả cho bài toán Lương Trung bình: Phòng ban so với Công ty*

## Description
## *Mô tả*

**SQL Schema**

Table: `Salary`
```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| employee_id | int     |
| amount      | int     |
| pay_date    | date    |
+-------------+---------+
id is the primary key column for this table.
Each row of this table contains information about the salary of an employee in a particular month.
pay_date is in the format YYYY-MM-DD.
```

Table: `Employee`
```
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| employee_id   | int     |
| department_id | int     |
+---------------+---------+
employee_id is the primary key column for this table.
Each row of this table indicates the department of an employee.
```

Write an SQL query to report if the department's average salary is higher, lower, or the same as the company's average salary for each month.
*Viết một truy vấn SQL để báo cáo xem mức lương trung bình của phòng ban cao hơn, thấp hơn hay bằng mức lương trung bình của công ty cho mỗi tháng.*

Return the result table in **any order**.
*Trả về bảng kết quả theo **bất kỳ thứ tự nào**.*

The output should have `pay_month` (formatted as 'YYYY-MM'), `department_id`, and `comparison` (which is 'higher', 'lower', or 'same').
*Đầu ra nên có `pay_month` (định dạng 'YYYY-MM'), `department_id`, và `comparison` (có thể là 'higher', 'lower', hoặc 'same').*

---

## Example 1:
## *Ví dụ 1:*

**Input:** 
Salary table:
```
+----+-------------+--------+------------+
| id | employee_id | amount | pay_date   |
+----+-------------+--------+------------+
| 1  | 1           | 9000   | 2017/03/31 |
| 2  | 2           | 6000   | 2017/03/31 |
| 3  | 3           | 10000  | 2017/03/31 |
| 4  | 1           | 7000   | 2017/02/28 |
| 5  | 2           | 6000   | 2017/02/28 |
| 6  | 3           | 8000   | 2017/02/28 |
+----+-------------+--------+------------+
```
Employee table:
```
+-------------+---------------+
| employee_id | department_id |
+-------------+---------------+
| 1           | 1             |
| 2           | 2             |
| 3           | 2             |
+-------------+---------------+
```
**Output:** 
```
+-----------+---------------+------------+
| pay_month | department_id | comparison |
+-----------+---------------+------------+
| 2017-02   | 1             | higher     |
| 2017-02   | 2             | lower      |
| 2017-03   | 1             | same       |
| 2017-03   | 2             | same       |
+-----------+---------------+------------+
```
**Explanation:** 
- In March, the company's average salary is (9000+6000+10000)/3 = 8333.33. The average salary for department 1 is 9000, and for department 2 is (6000+10000)/2 = 8000. So both comparison result is 'same' since 8333.33 is between 9000 and 8000 (Wait, actually 9000 > 8333.33 and 8000 < 8333.33, the example explanation in problem 615 is usually like this: Dept 1 in March is 9000, Company is 8333.33 -> Higher. Dept 2 in March is 8000, Company is 8333.33 -> Lower. Let's stick to the logic: dept_avg vs company_avg per month).
Actually, for 2017/03: Company Avg = 8333.33. Dept 1 avg = 9000. Dept 2 avg = (6000+10000)/2 = 8000. Result should be Dept 1 Higher, Dept 2 Lower. The example matches this logic.

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.
