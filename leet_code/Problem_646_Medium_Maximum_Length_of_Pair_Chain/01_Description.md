# Result for Maximum Length of Pair Chain
# *Kết quả cho bài toán Độ dài Lớn nhất của Chuỗi Cặp*

## Description
## *Mô tả*

You are given an array of `n` pairs `pairs` where `pairs[i] = [left_i, right_i]` and `left_i < right_i`.
*Bạn được cho một mảng gồm `n` cặp `pairs` trong đó `pairs[i] = [left_i, right_i]` và `left_i < right_i`.*

A pair `p2 = [c, d]` follows a pair `p1 = [a, b]` if `b < c`. A chain of pairs can be formed in this fashion.
*Một cặp `p2 = [c, d]` theo sau một cặp `p1 = [a, b]` nếu `b < c`. Một chuỗi các cặp có thể được tạo thành theo cách này.*

Return the length of the longest chain which can be formed.
*Hãy trả về độ dài của chuỗi dài nhất có thể được tạo thành.*

You do not need to use up all the given pairs. You can select pairs in any order.
*Bạn không cần phải sử dụng hết tất cả các cặp đã cho. Bạn có thể chọn các cặp theo bất kỳ thứ tự nào.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** pairs = [[1,2], [2,3], [3,4]]
**Output:** 2
**Explanation:** The longest chain is [1,2] -> [3,4].

## Example 2:
## *Ví dụ 2:*

**Input:** pairs = [[1,2], [7,8], [4,5]]
**Output:** 3
**Explanation:** The longest chain is [1,2] -> [4,5] -> [7,8].

---

## Constraints:
## *Ràng buộc:*

*   `n == pairs.length`
*   `1 <= n <= 1000`
*   `-1000 <= left_i < right_i <= 1000`
