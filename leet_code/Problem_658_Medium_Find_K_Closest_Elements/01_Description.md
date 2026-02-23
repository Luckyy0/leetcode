# Result for Find K Closest Elements
# *Kết quả cho bài toán Tìm K Phần tử Gần nhất*

## Description
## *Mô tả*

Given a **sorted** integer array `arr`, two integers `k` and `x`, return the `k` closest integers to `x` in the array. The result should also be sorted in ascending order.
*Cho một mảng số nguyên đã được **sắp xếp** `arr`, và hai số nguyên `k` và `x`, hãy trả về `k` số nguyên gần `x` nhất trong mảng. Kết quả cũng phải được sắp xếp theo thứ tự tăng dần.*

An integer `a` is closer to `x` than an integer `b` if:
*Số nguyên `a` gần `x` hơn số nguyên `b` nếu:*
*   `|a - x| < |b - x|`, or
*   `|a - x| == |b - x|` and `a < b`

---

## Example 1:
## *Ví dụ 1:*

**Input:** arr = [1,2,3,4,5], k = 4, x = 3
**Output:** [1,2,3,4]

## Example 2:
## *Ví dụ 2:*

**Input:** arr = [1,2,3,4,5], k = 4, x = -1
**Output:** [1,2,3,4]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= k <= arr.length`
*   `1 <= arr.length <= 10^4`
*   `arr` is sorted in **ascending** order.
*   `-10^4 <= arr[i], x <= 10^4`
