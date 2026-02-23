# Result for Interval List Intersections
# *Kết quả cho bài toán Giao của Danh sách Đoạn*

## Description
## *Mô tả*

You are given two lists of closed intervals, `firstList` and `secondList`, where `firstList[i] = [start_i, end_i]` and `secondList[j] = [start_j, end_j]`. Each list of intervals is pairwise **disjoint** and in **sorted order**.
*Bạn được cho hai danh sách các đoạn đóng, `firstList` và `secondList`, trong đó `firstList[i] = [start_i, end_i]` và `secondList[j] = [start_j, end_j]`. Mỗi danh sách các đoạn rời rạc từng đôi một và được **sắp xếp**.*

Return *the intersection of these two interval lists*.
*Trả về *giao của hai danh sách đoạn này*.*

A **closed interval** `[a, b]` (with `a <= b`) denotes the set of real numbers `x` with `a <= x <= b`.
*Một **đoạn đóng** `[a, b]` (với `a <= b`) biểu thị tập hợp các số thực `x` với `a <= x <= b`.*

The **intersection** of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of `[1, 3]` and `[2, 4]` is `[2, 3]`.
*Sự **giao nhau** của hai đoạn đóng là một tập hợp các số thực trống hoặc được biểu diễn dưới dạng một đoạn đóng. Ví dụ, giao của `[1, 3]` và `[2, 4]` là `[2, 3]`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
**Output:** [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
**Explanation:** The list of intersections is calculated by examining overlapping bounds between any two intervals. Note that point intersections such as [5, 5] and [25, 25] are valid closed intervals.

## Example 2:
## *Ví dụ 2:*

**Input:** firstList = [[1,3],[5,9]], secondList = []
**Output:** []

---

## Constraints:
## *Ràng buộc:*

*   `0 <= firstList.length, secondList.length <= 1000`
*   `firstList.length + secondList.length >= 1`
*   `0 <= start_i < end_i <= 10^9`
*   `end_i < start_i+1`
*   `0 <= start_j < end_j <= 10^9`
*   `end_j < start_j+1`
