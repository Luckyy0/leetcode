# 1198. Find Smallest Common Element in All Rows / Tìm Phần tử Chung Nhỏ nhất trong Tất cả các Hàng

## Problem Description / Mô tả bài toán
Given a matrix `mat` where every row is sorted in strictly increasing order.
Return the smallest common element in all rows. If none, return -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Counting / Binary Search / Multi-Pointers
Approach 1: Count frequency. Element with freq `rows` is answer. Since rows sorted, iterate and count.
Approach 2: Multi-pointers. Since rows sorted, advance min pointers. Like merging.
Approach 3: Iterate first row, check existence in all other rows via Binary Search.
Given constraints: `mat[i][j]` up to 10^4. Rows up to 500, cols up to 500.
Counting array is fastest `O(N*M)`.

### Complexity / Độ phức tạp
- **Time**: O(N*M).
- **Space**: O(10001) for frequency array.

---

## Analysis / Phân tích

### Approach: Frequency Counting
Since the element values are small (up to $10^4$) and rows are strictly increasing (no duplicates within a row), we can simply count the frequency of each number across the entire matrix. The first number that achieves a count equal to the number of rows is the smallest common element.
Vì giá trị phần tử nhỏ (tối đa $10^4$) và các hàng tăng ngặt (không có bản sao trong một hàng), chúng ta chỉ cần đếm tần suất của mỗi số trên toàn bộ ma trận. Số đầu tiên đạt được số đếm bằng số hàng là phần tử chung nhỏ nhất.

---
