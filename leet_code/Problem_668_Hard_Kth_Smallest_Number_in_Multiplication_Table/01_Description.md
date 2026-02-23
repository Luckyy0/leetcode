# Result for Kth Smallest Number in Multiplication Table
# *Kết quả cho bài toán Số nhỏ thứ k trong Bảng Cửu chương*

## Description
## *Mô tả*

Nearly everyone has used the Multiplication Table. But could you find the `k-th` smallest number quickly?
*Hầu như ai cũng đã từng sử dụng Bảng Cửu chương. Nhưng liệu bạn có thể tìm thấy số nhỏ thứ `k` một cách nhanh chóng?*

Given dimensions `m` and `n` and an integer `k`, return the `k-th` smallest number in an `m x n` multiplication table.
*Cho kích thước `m`, `n` và một số nguyên `k`, hãy trả về số nhỏ thứ `k` trong bảng cửu chương kích thước `m x n`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** m = 3, n = 3, k = 5
**Output:** 3
**Explanation:** 
The Multiplication Table:
1	2	3
2	4	6
3	6	9

The 5-th smallest number is 3 (1, 2, 2, 3, 3).

## Example 2:
## *Ví dụ 2:*

**Input:** m = 2, n = 3, k = 6
**Output:** 6
**Explanation:** 
The Multiplication Table:
1	2	3
2	4	6

The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).

---

## Constraints:
## *Ràng buộc:*

*   `1 <= m, n <= 3 * 10^4`
*   `1 <= k <= m * n`
