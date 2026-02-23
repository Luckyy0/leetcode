# Result for Maximum Distance in Arrays
# *Kết quả cho bài toán Khoảng cách Lớn nhất trong các Mảng*

## Description
## *Mô tả*

You are given `m` `arrays`, where each array is sorted in **ascending order**.
*Bạn được cho `m` `arrays`, trong đó mỗi mảng được sắp xếp theo **thứ tự tăng dần**.*

You can pick up two integers from two different arrays (each array at most once) and calculate the distance. We define the distance between two integers `a` and `b` to be their absolute difference `|a - b|`.
*Bạn có thể chọn hai số nguyên từ hai mảng khác nhau (mỗi mảng tối đa một lần) và tính khoảng cách. Chúng ta định nghĩa khoảng cách giữa hai số nguyên `a` và `b` là giá trị tuyệt đối của hiệu số `|a - b|`.*

Return the maximum distance.
*Trả về khoảng cách lớn nhất.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** arrays = [[1,2,3],[4,5],[1,2,3]]
**Output:** 4
**Explanation:** One way to reach the maximum distance 4 is to pick 1 in the first or third array and 5 in the second array.

## Example 2:
## *Ví dụ 2:*

**Input:** arrays = [[1],[1]]
**Output:** 0

---

## Constraints:
## *Ràng buộc:*

*   `m == arrays.length`
*   `2 <= m <= 10^5`
*   `1 <= arrays[i].length <= 500`
*   `-10^4 <= arrays[i][j] <= 10^4`
*   `arrays[i]` is sorted in **ascending order**.
*   There will be at least `2` integers in total across all the arrays.
