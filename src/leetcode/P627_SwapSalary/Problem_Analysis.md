# 627. Swap Salary / Hoán Đổi Lương

## Problem Description / Mô tả bài toán
Write an SQL query to swap all 'f' and 'm' values (i.e., change all 'f' values to 'm' and vice versa) with a **single update statement** and no intermediate temporary tables.
Viết một truy vấn SQL để hoán đổi tất cả các giá trị 'f' và 'm' (tức là thay đổi tất cả các giá trị 'f' thành 'm' và ngược lại) bằng một **câu lệnh cập nhật duy nhất** và không có bảng tạm thời trung gian.

Note that you must write a single `UPDATE` statement, do not write any `SELECT` statement for this problem.
Lưu ý rằng bạn phải viết một câu lệnh `UPDATE` duy nhất, không viết bất kỳ câu lệnh `SELECT` nào cho vấn đề này.

Table: `Salary`
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

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Conditional Update / Cập Nhật Có Điều Kiện
Use `CASE` in `UPDATE` statement.
`SET sex = CASE WHEN sex = 'm' THEN 'f' ELSE 'm' END`.
Alternatively, `IF(sex = 'm', 'f', 'm')`.

Query:
```sql
UPDATE Salary
SET sex = CASE 
    WHEN sex = 'm' THEN 'f' 
    ELSE 'm' 
END;
```

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Update with Case

**Algorithm**:
1.  Execute update command.
2.  Set sex column based on current value.

---
