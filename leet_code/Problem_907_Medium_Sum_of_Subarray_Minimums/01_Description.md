# Result for Sum of Subarray Minimums
# *Kết quả cho bài toán Tổng Các Giá trị Nhỏ nhất của Mảng con*

## Description
## *Mô tả*

Given an array of integers `arr`, find the sum of `min(b)`, where `b` ranges over every (contiguous) subarray of `arr`. Since the answer may be large, return the answer **modulo** `10^9 + 7`.
*Cho một mảng các số nguyên `arr`, hãy tìm tổng của `min(b)`, trong đó `b` trải dài qua mọi mảng con (liên tiếp) của `arr`. Vì câu trả lời có thể rất lớn, hãy trả về câu trả lời **modulo** `10^9 + 7`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [3,1,2,4]
**Output:** 17
**Explanation:** 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [11,81,94,43,3]
**Output:** 444

---

## Constraints:
## *Ràng buộc:*

*   `1 <= arr.length <= 3 * 10^4`
*   `1 <= arr[i] <= 3 * 10^4`
