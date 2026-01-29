# 1378. Replace Employee ID With The Unique Identifier / Thay thế ID Nhân viên bằng Mã định danh Duy nhất

## Problem Description / Mô tả bài toán
Tables `Employees` (id, name), `EmployeeUNI` (id, unique_id).
Show unique ID for each user. If not exists, show null.
Result `unique_id`, `name`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Left Join
`SELECT u.unique_id, e.name`
`FROM Employees e`
`LEFT JOIN EmployeeUNI u ON e.id = u.id`.

---
