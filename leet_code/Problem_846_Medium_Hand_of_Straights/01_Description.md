# Result for Hand of Straights
# *Kết quả cho bài toán Bộ bài liên tiếp*

## Description
## *Mô tả*

Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size `groupSize`, and consists of `groupSize` consecutive cards.
*Alice có một số thẻ bài và cô ấy muốn sắp xếp lại chúng thành các nhóm sao cho mỗi nhóm có kích thước `groupSize`, và bao gồm `groupSize` thẻ bài liên tiếp.*

Given an integer array `hand` where `hand[i]` is the value written on the `i`-th card and an integer `groupSize`, return `true` *if she can rearrange the cards, or* `false` *otherwise*.
*Cho một mảng số nguyên `hand` trong đó `hand[i]` là giá trị được viết trên thẻ bài thứ `i` và một số nguyên `groupSize`, hãy trả về `true` *nếu cô ấy có thể sắp xếp lại các thẻ bài, ngược lại trả về* `false`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
**Output:** true
**Explanation:** Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].

## Example 2:
## *Ví dụ 2:*

**Input:** hand = [1,2,3,4,5], groupSize = 4
**Output:** false
**Explanation:** Alice's hand can not be rearranged into groups of 4.

---

## Constraints:
## *Ràng buộc:*

*   `1 <= hand.length <= 10^4`
*   `0 <= hand[i] <= 10^9`
*   `1 <= groupSize <= hand.length`
