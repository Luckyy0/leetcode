# Result for Reveal Cards In Increasing Order
# *Kết quả cho bài toán Lật Ngửa Các Quân Bài Theo Thứ Tự Tăng Dần*

## Description
## *Mô tả*

You are given an integer array `deck`. There is a deck of cards where every card has a unique integer. The integer on the `i`th card is `deck[i]`.
*Bạn được cho một mảng số nguyên `deck`. Có một bộ bài trong đó mỗi lá bài có một số nguyên duy nhất. Số nguyên trên lá bài thứ `i` là `deck[i]`.*

You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.
*Bạn có thể sắp xếp bộ bài theo bất kỳ thứ tự nào bạn muốn. Ban đầu, tất cả các lá bài bắt đầu úp xuống (chưa lật) trong một bộ bài.*

You will do the following steps repeatedly until all cards are revealed:
*Bạn sẽ thực hiện các bước sau liên tục cho đến khi tất cả các lá bài được lật:*

1.  Take the top card of the deck, reveal it, and take it out of the deck.
    *   *Lấy lá bài trên cùng của bộ bài, lật nó và lấy nó ra khỏi bộ bài.*
2.  If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
    *   *Nếu vẫn còn các lá bài trong bộ bài thì đặt lá bài trên cùng tiếp theo của bộ bài vào dưới cùng của bộ bài.*
3.  If there are still unrevealed cards, go back to step 1. Otherwise, stop.
    *   *Nếu vẫn còn các lá bài chưa lật, quay lại bước 1. Ngược lại, dừng lại.*

Return *an ordering of the deck that would reveal the cards in increasing order*.
*Trả về *một thứ tự của bộ bài sẽ lật các lá bài theo thứ tự tăng dần*.*

**Note** that the first entry in the answer is considered to be the top of the deck.
***Lưu ý** rằng mục đầu tiên trong câu trả lời được coi là trên cùng của bộ bài.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** deck = [17,13,11,2,3,5,7]
**Output:** [2,13,3,11,5,17,7]
**Explanation:**
We get the deck in the order [17,13,11,2,3,5,7] (this order does not matter), and reorder it.
After reordering, the deck starts as [2,13,3,11,5,17,7], where 2 is the top of the deck.
We reveal 2, and move 13 to the bottom.  The deck is now [3,11,5,17,7,13].
We reveal 3, and move 11 to the bottom.  The deck is now [5,17,7,13,11].
We reveal 5, and move 17 to the bottom.  The deck is now [7,13,11,17].
We reveal 7, and move 13 to the bottom.  The deck is now [11,17,13].
We reveal 11, and move 17 to the bottom.  The deck is now [13,17].
We reveal 13, and move 17 to the bottom.  The deck is now [17].
We reveal 17.
Since all the cards revealed are in increasing order, the answer is correct.

## Example 2:
## *Ví dụ 2:*

**Input:** deck = [1,1000]
**Output:** [1,1000]

---

## Constraints:
## *Ràng buộc:*

*   `1 <= deck.length <= 1000`
*   `1 <= deck[i] <= 10^6`
*   All the values of `deck` are **unique**.
