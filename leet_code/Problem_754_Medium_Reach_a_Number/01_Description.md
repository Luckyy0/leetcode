# Result for Reach a Number
# *Kết quả cho bài toán Đạt tới một Số*

## Description
## *Mô tả*

You are standing at position `0` on an infinite number line. There is a destination at position `target`.
*Bạn đang đứng tại vị trí `0` trên một trục số vô hạn. Có một đích đến tại vị trí `target`.*

You can make some number of moves `numModes` so that:
*   On each move, you can either go left or right.
*   During the `i-th` move (starting from `i == 1` to `numMoves`), you take `i` steps in the chosen direction.
*Bạn có thể thực hiện một số bước đi `numMoves` sao cho:*
*   *Ở mỗi bước, bạn có thể đi sang trái hoặc sang phải.*
*   *Trong bước đi thứ `i` (bắt đầu từ `i == 1` đến `numMoves`), bạn đi `i` bước theo hướng đã chọn.*

Given the integer `target`, return *the minimum number of moves required (i.e., the minimum `numMoves`) to reach the destination*.
*Cho số nguyên `target`, hãy trả về *số bước đi tối thiểu cần thiết (tức là `numMoves` nhỏ nhất) để đến đích*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** target = 2
**Output:** 3
**Explanation:**
On the 1st move, we step from 0 to 1 (1 step).
On the 2nd move, we step from 1 to 3 (2 steps).
On the 3rd move, we step from 3 to 2 (3 steps).

## Example 2:
## *Ví dụ 2:*

**Input:** target = 3
**Output:** 2
**Explanation:**
On the 1st move, we step from 0 to 1 (1 step).
On the 2nd move, we step from 1 to 3 (2 steps).

---

## Constraints:
## *Ràng buộc:*

*   `-10^9 <= target <= 10^9`
*   `target != 0`
