# Result for Employee Importance
# *Kết quả cho bài toán Tính quan trọng của Nhân viên*

## Description
## *Mô tả*

You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.
*Bạn có một cấu trúc dữ liệu về thông tin nhân viên, bao gồm ID duy nhất của nhân viên, giá trị độ quan trọng và ID của các nhân viên cấp dưới trực tiếp.*

You are given an array of employees `employees` where:
*Bạn được cho một mảng các nhân viên `employees` trong đó:*

- `employees[i].id` is the ID of the $i^{th}$ employee.
    - *`employees[i].id` là ID của nhân viên thứ $i$.*
- `employees[i].importance` is the importance value of the $i^{th}$ employee.
    - *`employees[i].importance` là mức độ quan trọng của nhân viên thứ $i$.*
- `employees[i].subordinates` is a list of IDs of the direct subordinates of the $i^{th}$ employee.
    - *`employees[i].subordinates` là danh sách ID của các nhân viên cấp dưới trực tiếp của nhân viên thứ $i$.*

Given an integer `id` that represents an employee's ID, return the **total** importance value of this employee and all their subordinates.
*Cho một số nguyên `id` đại diện cho ID của một nhân viên, hãy trả về **tổng** giá trị độ quan trọng của nhân viên này và tất cả các nhân viên cấp dưới của họ.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** employees = [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], id = 1
**Output:** 11
**Explanation:**
Employee 1 has an importance value of 5 and has two direct subordinates: employee 2 and employee 3.
They both have an importance value of 3.
So the total importance value of employee 1 is 5 + 3 + 3 = 11.

## Example 2:
## *Ví dụ 2:*

**Input:** employees = [[1, 2, [5]], [5, -3, []]], id = 5
**Output:** -3
**Explanation:**
Employee 5 has an importance value of -3 and has no direct subordinates.
So the total importance value of employee 5 is -3.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= employees.length <= 2000`
*   `1 <= employees[i].id <= 2000`
*   All `employees[i].id` are **unique**.
*   `-100 <= employees[i].importance <= 100`
*   One employee has at most one direct leader and may have several subordinates.
*   The subordinates graph is a tree (no cycles).
