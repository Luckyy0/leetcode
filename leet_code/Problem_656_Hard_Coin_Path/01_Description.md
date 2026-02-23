# Result for Coin Path
# *Kết quả cho bài toán Đường đi Xu tiền*

## Description
## *Mô tả*

You are given an integer array `coins` (1-indexed) of length `n` and an integer `maxJump`. You can jump to any index `i + k` from index `i` if `1 <= k <= maxJump` and `coins[i + k] != -1`.
*Bạn được cho một mảng số nguyên `coins` (bắt đầu từ chỉ số 1) có độ dài `n` và một số nguyên `maxJump`. Bạn có thể nhảy đến bất kỳ chỉ số `i + k` nào từ chỉ số `i` nếu `1 <= k <= maxJump` và `coins[i + k] != -1`.*

The cost of the path is the sum of `coins[i]` for all indices `i` on the path.
*Chi phí của đường đi là tổng của `coins[i]` cho tất cả các chỉ số `i` trên đường đi.*

Return the **lexicographically smallest** path with the minimum cost from index `1` to index `n`. If there is no such path, return an empty array.
*Hãy trả về đường đi **nhỏ nhất theo thứ tự từ điển** có chi phí tối thiểu từ chỉ số `1` đến chỉ số `n`. Nếu không có đường đi nào như vậy, hãy trả về một mảng rỗng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** coins = [1,2,4,-1,2], maxJump = 2
**Output:** [1,3,5]

## Example 2:
## *Ví dụ 2:*

**Input:** coins = [1,2,4,-1,2], maxJump = 1
**Output:** []

---

## Constraints:
## *Ràng buộc:*

*   `1 <= coins.length <= 1000`
*   `-1 <= coins[i] <= 100`
*   `1 <= maxJump <= 100`
