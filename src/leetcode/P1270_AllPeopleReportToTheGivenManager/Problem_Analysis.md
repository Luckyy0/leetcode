# 1270. All People Report to the Given Manager / Tất cả Mọi người Báo cáo cho Người quản lý Đã cho

## Problem Description / Mô tả bài toán
Table `Employees`: `employee_id`, `employee_name`, `manager_id`.
Find all employees who report to `employee_id = 1` directly or indirectly.
Indirectly means report to manager who reports to 1, etc.
Boss (1) reports to himself.
Do not include 1 in result? "excluding the boss himself". Maybe or maybe not? "Write an SQL query to find employee_id of all employees that directly or indirectly report to the Head of the Company."
Example usually clarifies if 1 is included.
Example output shows 1 is NOT included if asked for "employees under boss". Usually yes.
Usually recursive limit is small (e.g. 3 levels). "The head of the company is employee 1. The managers of all employees are unique."
Wait. "Indirect relation ... up to 3 levels".
Specifically "The indirect relation between managers will not exceed 3 managers as the company is small."
So just check `manager` or `manager's manager` or `manager's manager's manager` is 1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Self Joins
Since depth is limited to 3:
`e1.manager_id = 1` OR `e2.manager_id = 1 AND e1.manager_id = e2.employee_id` ...
Method: Join table to itself 3 times.
`FROM Employees e1 LEFT JOIN Employees e2 ON e1.manager_id = e2.employee_id LEFT JOIN Employees e3 ...`
Check if any manager in chain is 1. And `e1.employee_id != 1`.

### Complexity / Độ phức tạp
- **Time**: O(N log N) join.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Multiple Joins or Recursive CTE
Given the constraint that the hierarchy depth is at most 3, we can use simple self-joins.
Identify employees:
1. `e1.manager_id = 1` (Level 1)
2. `e1.manager_id = e2.employee_id` AND `e2.manager_id = 1` (Level 2)
3. `e1.manager_id = e2.employee_id` AND `e2.manager_id = e3.employee_id` AND `e3.manager_id = 1` (Level 3)
Actually, simpler condition: `e1.manager_id = 1` OR `e2.manager_id = 1` (where e2 is e1's manager) OR `e3.manager_id = 1` (where e3 is e2's manager).
We also exclude employee 1.
Với ràng buộc độ sâu phân cấp tối đa là 3, chúng ta có thể sử dụng tự nối đơn giản.
Xác định nhân viên:
1. `e1.manager_id = 1` (Cấp 1)
2. `e1.manager_id = e2.employee_id` VÀ `e2.manager_id = 1` (Cấp 2)
3. `e1.manager_id = e2.employee_id` VÀ `e2.manager_id = e3.employee_id` VÀ `e3.manager_id = 1` (Cấp 3)
Thực ra, điều kiện đơn giản hơn: `e1.manager_id = 1` HOẶC `e2.manager_id = 1` (nơi e2 là quản lý của e1) HOẶC `e3.manager_id = 1` (nơi e3 là quản lý của e2).
Chúng ta cũng loại trừ nhân viên 1.

---
