# 759. Employee Free Time / Thời gian rảnh của Nhân viên

## Problem Description / Mô tả bài toán
We are given a list `schedule` of employees, which represents the working time for each employee.
Chúng ta được cấp một danh sách `schedule` của nhân viên, đại diện cho thời gian làm việc của mỗi nhân viên.

Each employee has a list of non-overlapping `Intervals`, and these intervals are in sorted order.
Mỗi nhân viên có một danh sách các `Intervals` không chồng chéo và các khoảng này được sắp xếp theo thứ tự.

Return the list of finite intervals representing common, positive-length free time for **all** employees, also in sorted order.
Trả về danh sách các khoảng thời gian hữu hạn đại diện cho thời gian rảnh chung, có độ dài dương cho **tất cả** nhân viên, cũng theo thứ tự đã sắp xếp.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Interval Merging / Hợp nhất Khoảng
The "free time" for everyone is the gap between the merged intervals of everyone's working time.
"Thời gian rảnh" cho tất cả mọi người là khoảng trống giữa các khoảng thời gian đã hợp nhất từ thời gian làm việc của mọi người.

Algorithm:
1. Collect all working intervals from all employees.
2. Sort all intervals by their start time.
3. Merge the overlapping working intervals.
4. The gaps between the merged working intervals are the free time intervals.

### Complexity / Độ phức tạp
- **Time**: O(N log N) for sorting all working intervals, where N is total number of intervals across all employees.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Flatten and Merge
Flatten all schedules into a single list of intervals. Use the standard interval merging technique. The gaps between the results are the common free periods.
Làm phẳng tất cả các lịch trình thành một danh sách các khoảng duy nhất. Sử dụng kỹ thuật hợp nhất khoảng tiêu chuẩn. Các khoảng trống giữa kết quả thu được là các khoảng thời gian rảnh chung.

---
