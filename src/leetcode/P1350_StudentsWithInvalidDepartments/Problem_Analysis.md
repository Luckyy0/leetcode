# 1350. Students With Invalid Departments / Sinh viên Có Khoa Không hợp lệ

## Problem Description / Mô tả bài toán
Tables `Departments` (id, name) and `Students` (id, name, department_id).
Find students whose `department_id` is NOT in `Departments` table.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Left Join / Not In
`SELECT s.id, s.name`
`FROM Students s`
`LEFT JOIN Departments d ON s.department_id = d.id`
`WHERE d.id IS NULL`.

---
