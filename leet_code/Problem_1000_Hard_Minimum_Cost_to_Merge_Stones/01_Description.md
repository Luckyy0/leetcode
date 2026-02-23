# Result for Minimum Cost to Merge Stones
# *Kết quả cho bài toán Chi phí Tối thiểu để Gộp Đá*

## Description
## *Mô tả*

There are `n` piles of `stones` arranged in a row. The `i`th pile has `stones[i]` stones.
*Có `n` đống đá `stones` được sắp xếp thành một hàng. Đống thứ `i` có `stones[i]` viên đá.*

A move consists of merging exactly `k` consecutive piles into one pile, and the cost of this move is equal to the total number of stones in these `k` piles.
*Một nước cờ bao gồm việc gộp chính xác `k` đống liên tiếp thành một đống, và chi phí của nước cờ này bằng tổng số lượng đá trong `k` đống đó.*

Return *the minimum cost to merge all piles of stones into one pile*. If it is impossible, return `-1`.
*Trả về *chi phí tối thiểu để gộp tất cả các đống đá thành một đống*. Nếu điều này là không thể, trả về `-1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** stones = [3,2,4,1], k = 2
**Output:** 20
**Explanation:** We start with [3, 2, 4, 1].
We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
We merge [4, 1] for a cost of 5, and we are left with [5, 5].
We merge [5, 5] for a cost of 10, and we are left with [10].
The total cost was 5 + 5 + 10 = 20, and this is the minimum possible.

## Example 2:
## *Ví dụ 2:*

**Input:** stones = [3,2,4,1], k = 3
**Output:** -1
**Explanation:** After any merge operation, there are 2 piles left, and we can't merge anymore.  So the task is impossible.

## Example 3:
## *Ví dụ 3:*

**Input:** stones = [3,5,1,2,6], k = 3
**Output:** 25
**Explanation:** We start with [3, 5, 1, 2, 6].
We merge [5, 1, 2] for a cost of 8, and we are left with [3, 8, 6].
We merge [3, 8, 6] for a cost of 17, and we are left with [17].
The total cost was 8 + 17 = 25, and this is the minimum possible.

---

## Constraints:
## *Ràng buộc:*

*   `n == stones.length`
*   `1 <= n <= 30`
*   `1 <= stones[i] <= 100`
*   `2 <= k <= 30`
