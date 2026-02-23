# Result for Bag of Tokens
# *Kết quả cho bài toán Túi Token*

## Description
## *Mô tả*

You have an initial **power** of `power`, an initial **score** of `0`, and a bag of `tokens` where `tokens[i]` is the value of the `i`th token (0-indexed).
*Bạn có một **sức mạnh** ban đầu là `power`, một **điểm số** ban đầu là `0`, và một túi `tokens` trong đó `tokens[i]` là giá trị của token thứ `i` (đánh chỉ số 0).*

Your goal is to maximize your total **score** by potentially playing each token in one of two ways:
*Mục tiêu của bạn là tối đa hóa tổng **điểm số** của mình bằng cách có khả năng chơi mỗi token theo một trong hai cách:*

*   If your current **power** is at least `tokens[i]`, you may play the `i`th token face up, losing `tokens[i]` **power** and gaining `1` **score**.
    *   *Nếu **sức mạnh** hiện tại của bạn ít nhất là `tokens[i]`, bạn có thể chơi token thứ `i` lật ngửa, mất `tokens[i]` **sức mạnh** và nhận được `1` **điểm số**.*
*   If your current **score** is at least `1`, you may play the `i`th token face down, gaining `tokens[i]` **power** and losing `1` **score**.
    *   *Nếu **điểm số** hiện tại của bạn ít nhất là `1`, bạn có thể chơi token thứ `i` lật úp, nhận được `tokens[i]` **sức mạnh** và mất `1` **điểm số**.*

Each token may be played **at most** once and **in any order**. You do not have to play all the tokens.
*Mỗi token có thể được chơi **tối đa** một lần và **theo bất kỳ thứ tự nào**. Bạn không cần phải chơi tất cả các token.*

Return *the largest possible **score** you can achieve after playing any number of tokens*.
*Trả về **điểm số** lớn nhất có thể mà bạn có thể đạt được sau khi chơi bất kỳ số lượng token nào.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** tokens = [100], power = 50
**Output:** 0
**Explanation:** Playing the only token in the bag is impossible because you either have too little power or too little score.

## Example 2:
## *Ví dụ 2:*

**Input:** tokens = [100,200], power = 150
**Output:** 1
**Explanation:** Play the 0th token (100) face up, your power becomes 50 and score becomes 1.
There is no need to play the 1st token since you cannot play it face up to add to your score.

## Example 3:
## *Ví dụ 3:*

**Input:** tokens = [100,200,300,400], power = 200
**Output:** 2
**Explanation:** Play the tokens in this order to get a score of 2:
1. Play the 0th token (100) face up, your power becomes 100 and score becomes 1.
2. Play the 3rd token (400) face down, your power becomes 500 and score becomes 0.
3. Play the 1st token (200) face up, your power becomes 300 and score becomes 1.
4. Play the 2nd token (300) face up, your power becomes 0 and score becomes 2.

---

## Constraints:
## *Ràng buộc:*

*   `0 <= tokens.length <= 1000`
*   `0 <= tokens[i], power < 10^4`
