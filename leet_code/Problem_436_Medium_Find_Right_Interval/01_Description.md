# Result for Find Right Interval
# *Kết quả cho bài toán Tìm Khoảng bên Phải*

## Description
## *Mô tả*

You are given an array of `intervals`, where `intervals[i] = [starti, endi]` and each `starti` is **unique**.
*Bạn được cho một mảng các `intervals`, trong đó `intervals[i] = [starti, endi]` và mỗi `starti` là **duy nhất**.*

The **right interval** for an interval `i` is an interval `j` such that `startj >= endi` and `startj` is **minimized**. Note that `i` may equal `j`.
* **Khoảng bên phải** của một khoảng `i` là một khoảng `j` sao cho `startj >= endi` và `startj` là **nhỏ nhất**. Lưu ý rằng `i` có thể bằng `j`.*

Return *an array of **right interval** indices for each interval `i`*. If no right interval exists for interval `i`, then put `-1` at index `i`.
*Hãy trả về *một mảng các chỉ số của **khoảng bên phải** cho mỗi khoảng `i`*. Nếu không có khoảng bên phải nào tồn tại cho khoảng `i`, hãy đặt `-1` tại chỉ số `i`.*

## Example 1:
## *Ví dụ 1:*

**Input:** `intervals = [[1,2]]`
**Output:** `[-1]`
**Explanation:** There is only one interval in the collection, so it cannot have a right interval.

## Example 2:
## *Ví dụ 2:*

**Input:** `intervals = [[3,4],[2,3],[1,2]]`
**Output:** `[-1, 0, 1]`
**Explanation:** 
- For [3,4], there is no "right" interval.
- For [2,3], the smallest "right" start is 3, which is the start of interval [3,4] (index 0).
- For [1,2], the smallest "right" start is 2, which is the start of interval [2,3] (index 1).

## Constraints:
## *Ràng buộc:*

*   `1 <= intervals.length <= 2 * 10^4`
*   `intervals[i].length == 2`
*   `-10^6 <= starti <= endi <= 10^6`
*   The start points are **unique**.
