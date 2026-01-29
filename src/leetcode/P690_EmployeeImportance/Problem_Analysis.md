# 690. Employee Importance / Tầm quan trọng của Nhân viên

## Problem Description / Mô tả bài toán
You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.
Bạn có cấu trúc dữ liệu về thông tin nhân viên, bao gồm ID duy nhất của nhân viên, giá trị tầm quan trọng và ID của các cấp dưới trực tiếp.

Given an array of employees `employees` and an ID `id`, return the total importance value of this employee and all their subordinates.
Cho một mảng nhân viên `employees` và một ID `id`, hãy trả về tổng giá trị tầm quan trọng của nhân viên này và tất cả các cấp dưới của họ.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Depth First Search (DFS) or BFS on a Graph / DFS hoặc BFS trên Đồ thị
The organizational structure is essentially a directed tree (or forest).
Cấu trúc tổ chức thực chất là một cây có hướng (hoặc rừng).

We can use a HashMap to quickly access an employee by their ID.
Chúng ta có thể sử dụng HashMap để truy cập nhanh một nhân viên theo ID của họ.

Algorithm:
1. Map all IDs to employee objects.
2. Initialize `totalImportance = 0`.
3. Use recursion to traverse the subordinates of the given `id` and sum their importance.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the total number of employees.
- **Space**: O(N) for the HashMap and recursion stack.

---

## Analysis / Phân tích

### Approach: Recursive Importance Summing
Map the IDs to objects. Start a DFS from the target employee. The result for any employee is their own importance plus the sum of importance of all their subordinates.
Ánh xạ các ID vào các đối tượng. Bắt đầu DFS từ nhân viên mục tiêu. Kết quả cho bất kỳ nhân viên nào là tầm quan trọng của chính họ cộng với tổng tầm quan trọng của tất cả các cấp dưới của họ.

---
