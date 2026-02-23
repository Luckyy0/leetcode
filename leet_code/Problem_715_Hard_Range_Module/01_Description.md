# Result for Range Module
# *Kết quả cho bài toán Mô-đun Quản lý Khoảng*

## Description
## *Mô tả*

A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.
*Range Module là một mô-đun theo dõi các khoảng số. Nhiệm vụ của bạn là thiết kế và cài đặt các giao diện sau một cách hiệu quả.*

- `RangeModule()` Initializes the object of the range module.
- `void addRange(int left, int right)` Adds the half-open interval `[left, right)`, tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval `[left, right)` that are not already tracked.
- `boolean queryRange(int left, int right)` Returns `true` if every real number in the interval `[left, right)` is currently being tracked.
- `void removeRange(int left, int right)` Stops tracking every real number currently being tracked in the half-open interval `[left, right)`.

---

## Example 1:
## *Ví dụ 1:*

**Input:** ["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
[[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 20]]
**Output:** [null, null, null, true, false, true]
**Explanation:**
- RangeModule rm = new RangeModule();
- rm.addRange(10, 20);
- rm.removeRange(14, 16);
- rm.queryRange(10, 14); // return true (Every number in [10, 14) is being tracked)
- rm.queryRange(13, 15); // return false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
- rm.queryRange(16, 20); // return true (Every number in [16, 20) is being tracked)

---

## Constraints:
## *Ràng buộc:*

*   `1 <= left < right <= 10^9`
*   At most `10^4` calls will be made to `addRange`, `queryRange`, and `removeRange`.
