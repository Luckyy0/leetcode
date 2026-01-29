# 618. Students Report By Geography / Báo Cáo Sinh Viên Theo Địa Lý

## Problem Description / Mô tả bài toán
Write an SQL query to pivot the continent column in the `Student` table so that each name is sorted alphabetically and displayed underneath its corresponding continent.
Viết một truy vấn SQL để xoay cột lục địa trong bảng `Student` để mỗi tên được sắp xếp theo thứ tự bảng chữ cái và hiển thị bên dưới lục địa tương ứng của nó.

The output headers should be America, Asia, and Europe, respectively.
Tiêu đề đầu ra phải lần lượt là Mỹ, Châu Á và Châu Âu.

Table: `Student`
```
+--------+-----------+
| name   | continent |
+--------+-----------+
| Jack   | America   |
| Pascal | Europe    |
| Xi     | Asia      |
| Jane   | America   |
+--------+-----------+
```
Output:
```
+---------+------+--------+
| America | Asia | Europe |
+---------+------+--------+
| Jack    | Xi   | Pascal |
| Jane    | null | null   |
+---------+------+--------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Pivot with Row Number / Xoay Với Số Hàng
We need to align students by row number within their continent group.
1. Assign `ROW_NUMBER` to students partitioned by `continent` ordered by `name`.
2. Pivot based on `ROW_NUMBER`.
   `SELECT MIN(CASE WHEN continent='America' THEN name END) as America, ... GROUP BY row_num`.
   
Query:
```sql
SELECT
    MAX(CASE WHEN continent = 'America' THEN name END) AS America,
    MAX(CASE WHEN continent = 'Asia' THEN name END) AS Asia,
    MAX(CASE WHEN continent = 'Europe' THEN name END) AS Europe
FROM (
    SELECT *, ROW_NUMBER() OVER(PARTITION BY continent ORDER BY name) as rn
    FROM Student
) t
GROUP BY rn
```
Note: `MAX` or `MIN` is needed to aggregate the single value per group.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Row Number Pivot

**Algorithm**:
1.  Assign row numbers per continent.
2.  Use conditional aggregation (CASE WHEN) grouped by row number.

---
