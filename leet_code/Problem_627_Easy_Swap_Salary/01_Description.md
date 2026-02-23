# Result for Swap Salary
# *Kết quả cho bài toán Hoán đổi Lương*

## Description
## *Mô tả*

**SQL Schema**

Table: `Salary`
```
+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| id          | int      |
| name        | varchar  |
| sex         | ENUM     |
| salary      | int      |
+-------------+----------+
id is the primary key for this table.
The sex column is ENUM value of type ('m', 'f').
The table contains information about an employee.
```

Write an SQL query to swap all `'f'` and `'m'` values (i.e., change all `'f'` values to `'m'` and vice-versa) with a **single update statement** and no intermediate temporary tables.
*Viết một truy vấn SQL để hoán đổi tất cả các giá trị `'f'` và `'m'` (tức là chuyển tất cả giá trị `'f'` thành `'m'` và ngược lại) chỉ bằng một **câu lệnh update duy nhất** và không có bảng tạm trung gian.*

Note that you must write a single update statement, **do not** write any select statement for this problem.
*Lưu ý rằng bạn phải viết một câu lệnh update duy nhất, **không** viết bất kỳ câu lệnh select nào cho bài toán này.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** 
Salary table:
```
+----+------+-----+--------+
| id | name | sex | salary |
+----+------+-----+--------+
| 1  | A    | m   | 2500   |
| 2  | B    | f   | 1500   |
| 3  | C    | m   | 5500   |
| 4  | D    | f   | 500    |
+----+------+-----+--------+
```
**Output:** 
```
+----+------+-----+--------+
| id | name | sex | salary |
+----+------+-----+--------+
| 1  | A    | f   | 2500   |
| 2  | B    | m   | 1500   |
| 3  | C    | f   | 5500   |
| 4  | D    | m   | 500    |
+----+------+-----+--------+
```

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.
