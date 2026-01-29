# 949. Largest Time for Given Digits / Thời gian Lớn nhất cho các Chữ số cho trước

## Problem Description / Mô tả bài toán
Given an array `arr` of 4 digits, return the largest 24-hour time that can be made using each digit once.
Cho một mảng `arr` gồm 4 chữ số, hãy trả về thời gian dạng 24 giờ lớn nhất có thể được tạo ra bằng cách sử dụng mỗi chữ số một lần.

24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59.
Thời gian 24 giờ được định dạng là "HH:MM", trong đó HH nằm trong khoảng từ 00 đến 23 và MM nằm trong khoảng từ 00 đến 59.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Brute Force Permutations / Duyệt tất cả các Hoán vị
Since there are only 4 digits, there are $4! = 24$ permutations.
Vì chỉ có 4 chữ số nên có $4! = 24$ hoán vị.

Algorithm:
1. Generate all permutations of the 4 digits.
2. For each permutation `[a, b, c, d]`:
   - Form `hour = a * 10 + b` and `minute = c * 10 + d`.
   - Check if `0 <= hour <= 23` and `0 <= minute <= 59`.
3. If valid, calculate total minutes: `hour * 60 + minute`.
4. Keep track of the maximum total minutes.
5. Format the result as "HH:MM".

### Complexity / Độ phức tạp
- **Time**: O(1) (fixed at 24 iterations).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Exhaustive Validation
Evaluate all possible orderings of the provided digits. By filtering for valid clock constraints and comparing the aggregate minute values, we pinpoint the orientation that represents the latest chronological event.
Đánh giá tất cả các thứ tự có thể có của các chữ số được cung cấp. Bằng cách lọc theo các ràng buộc đồng hồ hợp lệ và so sánh tổng giá trị phút, chúng ta xác định được hướng đại diện cho sự kiện thời gian muộn nhất.

---
