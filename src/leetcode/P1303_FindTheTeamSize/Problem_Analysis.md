# 1303. Find the Team Size / Tìm Kích thước Nhóm

## Problem Description / Mô tả bài toán
Table `Employee` (employee_id, team_id).
Find team size for each employee.
Result: `employee_id`, `team_size`.
Same order not required (usually).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Window Function
`COUNT(*) OVER (PARTITION BY team_id)` gives team size for each row.
Simple select.

---
