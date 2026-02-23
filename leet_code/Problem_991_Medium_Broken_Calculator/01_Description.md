# Result for Broken Calculator
# *Kết quả cho bài toán Máy Tính Hỏng*

## Description
## *Mô tả*

There is a broken calculator that has the integer `startValue` on its display initially. In one operation, you can:
*Có một máy tính bị hỏng có số nguyên `startValue` trên màn hình hiển thị ban đầu. Trong một thao tác, bạn có thể:*

*   multiply the number on display by `2`, or
    *   *nhân số trên màn hình hiển thị với `2`, hoặc*
*   subtract `1` from the number on display.
    *   *trừ `1` khỏi số trên màn hình hiển thị.*

Given two integers `startValue` and `target`, return *the minimum number of operations needed to display* `target` *on the calculator*.
*Cho hai số nguyên `startValue` và `target`, trả về *số lượng thao tác tối thiểu cần thiết để hiển thị* `target` *trên máy tính*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** startValue = 2, target = 3
**Output:** 2
**Explanation:** Use double operation and then decrement operation {2 -> 4 -> 3}.

## Example 2:
## *Ví dụ 2:*

**Input:** startValue = 5, target = 8
**Output:** 2
**Explanation:** Use decrement and then double {5 -> 4 -> 8}.

## Example 3:
## *Ví dụ 3:*

**Input:** startValue = 3, target = 10
**Output:** 3
**Explanation:** Use double, decrement and double {3 -> 6 -> 5 -> 10}.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= startValue, target <= 10^9`
