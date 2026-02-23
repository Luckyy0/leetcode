# Result for Largest Perimeter Triangle
# *Kết quả cho bài toán Chu vi Tam giác Lớn nhất*

## Description
## *Mô tả*

Given an integer array `nums`, return *the largest perimeter of a triangle with a non-zero area, formed from three of these lengths*. If it is impossible to form any triangle of a non-zero area, return `0`.
*Cho một mảng số nguyên `nums`, trả về *chu vi lớn nhất của một tam giác có diện tích khác không, được tạo thành từ ba trong số các độ dài này*. Nếu không thể tạo thành bất kỳ tam giác nào có diện tích khác không, trả về `0`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** nums = [2,1,2]
**Output:** 5
**Explanation:** You can form a triangle with sides 1, 2, and 2. The perimeter is 1 + 2 + 2 = 5.

## Example 2:
## *Ví dụ 2:*

**Input:** nums = [1,2,1,10]
**Output:** 0
**Explanation:** 
You can't use the side length 10, because 1 + 2 <= 10, and 1 + 1 <= 10.
The only way to use side 10 is if the other two sides sum to > 10.
The other sides available are 1, 2, 1. Max sum is 2+1 = 3 < 10.
Without 10, remaining sides are 1, 2, 1. Max side 2, sum of others 1+1=2. 2 < 2 is false (must be strict > for non-zero area). 1+1=2 -> degenerate triangle (area 0).
So output is 0.

---

## Constraints:
## *Ràng buộc:*

*   `3 <= nums.length <= 10^4`
*   `1 <= nums[i] <= 10^6`
