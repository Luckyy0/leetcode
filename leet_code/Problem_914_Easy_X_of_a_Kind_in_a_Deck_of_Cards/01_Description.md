# Result for X of a Kind in a Deck of Cards
# *Kết quả cho bài toán X quân bài cùng loại trong bộ bài*

## Description
## *Mô tả*

In a deck of cards, each card has an integer written on it.
*Trong một bộ bài, mỗi lá bài có một số nguyên được viết trên đó.*

Return `true` if and only if you can choose `X >= 2` such that it is possible to split the entire deck into 1 or more groups of cards, where:
*Trả về `true` khi và chỉ khi bạn có thể chọn `X >= 2` sao cho có thể chia toàn bộ bộ bài thành 1 hoặc nhiều nhóm bài, trong đó:*

*   Each group has exactly `X` cards.
    *   *Mỗi nhóm có chính xác `X` lá bài.*
*   All the cards in each group have the same integer.
    *   *Tất cả các lá bài trong mỗi nhóm đều có cùng số nguyên.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** deck = [1,2,3,4,4,3,2,1]
**Output:** true
**Explanation:** Possible partition [1,1],[2,2],[3,3],[4,4].

## Example 2:
## *Ví dụ 2:*

**Input:** deck = [1,1,1,2,2,2,3,3]
**Output:** false
**Explanation:** No possible partition.

## Example 3:
## *Ví dụ 3:*

**Input:** deck = [1]
**Output:** false
**Explanation:** No possible partition.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= deck.length <= 10^4`
*   `0 <= deck[i] < 10^4`
