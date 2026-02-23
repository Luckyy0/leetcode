# Result for New 21 Game
# *Kết quả cho bài toán Trò chơi 21 Mới*

## Description
## *Mô tả*

Alice plays the following game, loosely based on the card game "21".
*Alice chơi trò chơi sau đây, dựa trên trò chơi bài "21".*

Alice starts with `0` points and draws numbers while she has less than `k` points. During each draw, she gains an integer number of points randomly from the range `[1, maxPts]`, where each integer is equally likely. Alice stops drawing numbers when she gets `k` or more points.
*Alice bắt đầu với `0` điểm và rút các con số cho đến khi cô ấy có ít hơn `k` điểm. Trong mỗi lượt rút, cô nhận được một số điểm nguyên ngẫu nhiên trong khoảng `[1, maxPts]`, với mỗi số nguyên có khả năng xảy ra như nhau. Alice dừng rút số khi đạt được `k` điểm trở lên.*

Return *the probability that Alice has `n` or fewer points*.
*Trả về *xác suất Alice có `n` điểm trở xuống*.*

Answers within `10^-5` of the actual answer are considered accepted.
*Câu trả lời trong khoảng sai số `10^-5` so với đáp án thực tế sẽ được chấp nhận.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** n = 10, k = 1, maxPts = 10
**Output:** 1.00000
**Explanation:** Alice gets a single card, then stops.

## Example 2:
## *Ví dụ 2:*

**Input:** n = 6, k = 1, maxPts = 10
**Output:** 0.60000
**Explanation:** Alice gets a single card, then stops.
In 6 out of 10 cases, she gets 6 or fewer points.

## Example 3:
## *Ví dụ 3:*

**Input:** n = 21, k = 17, maxPts = 10
**Output:** 0.73278

---

## Constraints:
## *Ràng buộc:*

*   `0 <= k <= n <= 10^4`
*   `1 <= maxPts <= 10^4`
