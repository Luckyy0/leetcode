# Result for Card Flipping Game
# *Kết quả cho bài toán Trò chơi Lật bài*

## Description
## *Mô tả*

You are given two **0-indexed** integer arrays `fronts` and `backs` of length `n`, representing the fronts and backs of `n` cards. If we flip the `i`-th card, the front and back numbers are interchanged.
*Bạn được cho hai mảng số nguyên `fronts` và `backs` độ dài `n`, đại diện cho mặt trước và mặt sau của `n` lá bài. Nếu chúng ta lật lá bài thứ `i`, số ở mặt trước và mặt sau sẽ được tráo đổi cho nhau.*

We choose one of the cards, and after flipping it if we want to, we choose the number on its front side. If this number is not on the back side of **any** of the other cards, then this number is **good**.
*Chúng ta chọn một trong các lá bài, sau khi có thể lật nó, ta chọn con số ở mặt trước. Nếu con số này không xuất hiện ở mặt sau của **bất kỳ** lá bài nào khác, thì con số này là **tốt**.*

Return *the minimum good number*. If no number is good, return `0`.
*Trả về *số tốt nhỏ nhất*. Nếu không có số nào tốt, trả về `0`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** fronts = [1,2,4,4,7], backs = [1,3,4,1,3]
**Output:** 2
**Explanation:** 
If we flip the second card, the fronts are [1,3,4,4,7] and the backs are [1,2,4,1,3].
We choose the second card, which has number 2 on the back side, and it isn't on the front side of any card, so 2 is good.
Application of the rules: if we choose 2, it is not on the back of any other card. (Note: the rule is "not on the back side of ANY of the cards", including itself after picking the front side).

## Example 2:
## *Ví dụ 2:*

**Input:** fronts = [1], backs = [1]
**Output:** 0

---

## Constraints:
## *Ràng buộc:*

*   `n == fronts.length == backs.length`
*   `1 <= n <= 1000`
*   `1 <= fronts[i], backs[i] <= 2000`
