# Result for Set Intersection Size At Least Two
# *Kết quả cho bài toán Kích thước Giao của Tập hợp Ít nhất là Hai*

## Description
## *Mô tả*

You are given a 2D integer array `intervals` where `intervals[i] = [starti, endi]` represents all the integers from `starti` to `endi` inclusively.
*Bạn được cho một mảng số nguyên 2D `intervals` trong đó `intervals[i] = [starti, endi]` đại diện cho tất cả các số nguyên từ `starti` đến `endi` bao gồm cả hai đầu mút.*

A **containing set** is an integer set `S` such that each integer interval `[starti, endi]` in `intervals` has **at least two** integers in `S`.
*Một **tập hợp chứa** là một tập hợp số nguyên `S` sao cho mỗi khoảng số nguyên `[starti, endi]` trong `intervals` có **ít nhất hai** số nguyên nằm trong `S`.*

Return *the minimum possible size of a containing set*.
*Hãy trả về *kích thước nhỏ nhất có thể của một tập hợp chứa*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** intervals = [[1,3],[1,4],[2,5],[3,5]]
**Output:** 3
**Explanation:** There are two ways to get a set size of 3.
- The set {2, 3, 4}:
  - [1, 3] contains {2, 3} (size 2)
  - [1, 4] contains {2, 3, 4} (size 3)
  - [2, 5] contains {2, 3, 4} (size 3)
  - [3, 5] contains {3, 4} (size 2)
- The set {2, 3, 5}:
  - [1, 3] contains {2, 3}
  - [1, 4] contains {2, 3}
  - [2, 5] contains {2, 3, 5}
  - [3, 5] contains {3, 5}

## Example 2:
## *Ví dụ 2:*

**Input:** intervals = [[1,2],[2,3],[2,4],[4,5]]
**Output:** 5
**Explanation:** An example of a containing set is {1, 2, 3, 4, 5}.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= intervals.length <= 3000`
*   `intervals[i].length == 2`
*   `0 <= starti < endi <= 10^8`
