# Result for Students Report By Geography
# *Kết quả cho bài toán Báo cáo Sinh viên theo Địa lý*

## Description
## *Mô tả*

**SQL Schema**

Table: `Student`
```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| name        | varchar |
| continent   | varchar |
+-------------+---------+
There is no primary key for this table. It may contain duplicate rows.
Each row of this table indicates the name of a student and the continent they came from.
```

A school has students from Asia, Europe, and America.
*Một trường học có sinh viên đến từ Châu Á, Châu Âu và Châu Mỹ.*

Write an SQL query to pivot the continent column in the `Student` table so that each name is sorted alphabetically and displayed underneath its corresponding continent. The output headers should be Asia, Europe, and America, respectively.
*Viết một truy vấn SQL để xoay (pivot) cột châu lục trong bảng `Student` sao cho mỗi tên được sắp xếp theo bảng chữ cái và hiển thị bên dưới châu lục tương ứng của nó. Các tiêu đề đầu ra lần lượt là Asia, Europe và America.*

The test cases are generated so that the student number from America is no less than either Asia or Europe.
*Các trường hợp kiểm thử được tạo ra sao cho số lượng sinh viên từ America không ít hơn Asia hoặc Europe.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** 
Student table:
```
+--------+-----------+
| name   | continent |
+--------+-----------+
| Jane   | America   |
| Pascal | Europe    |
| Xi     | Asia      |
| Jack   | America   |
+--------+-----------+
```
**Output:** 
```
+--------+--------+--------+
| America| Asia   | Europe |
+--------+--------+--------+
| Jack   | Xi     | Pascal |
| Jane   | null   | null   |
+--------+--------+--------+
```

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.
