# Result for Minimum Cost to Hire K Workers
# *Kết quả cho bài toán Chi phí Tối thiểu để Thuê K Công nhân*

## Description
## *Mô tả*

There are `n` workers. You are given two integer arrays `quality` and `wage` where `quality[i]` is the quality of the `i`-th worker and `wage[i]` is the minimum wage expectation for the `i`-th worker.
*Có `n` công nhân. Bạn được cho hai mảng số nguyên `quality` và `wage`, trong đó `quality[i]` là chất lượng của công nhân thứ `i` và `wage[i]` là mức lương mong đợi tối thiểu của công nhân thứ `i`.*

We want to hire exactly `k` workers to form a paid group. To hire a group of `k` workers, we must pay them according to the following rules:
*Chúng ta muốn thuê đúng `k` công nhân để tạo thành một nhóm được trả lương. Để thuê một nhóm `k` công nhân, chúng ta phải trả lương cho họ theo các quy tắc sau:*

1.  Every worker in the paid group must be paid at least their minimum wage expectation.
2.  In the group, each worker's pay must be directly proportional to their quality. This means if a worker with quality 10 is paid $20, then a worker with quality 5 must be paid $10.

Given the integer `k`, return *the least amount of money needed to form a paid group satisfying the above conditions*. Answers within `10^-5` of the actual answer will be accepted.
*Cho số nguyên `k`, hãy trả về *số tiền ít nhất cần thiết để tạo thành một nhóm được trả lương thỏa mãn các điều kiện trên*. Kết quả chênh lệch trong khoảng `10^-5` so với đáp án thực tế sẽ được chấp nhận.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** quality = [10,20,5], wage = [7,10,4], k = 2
**Output:** 14.07143
**Explanation:** We pay 10.5 to 0-th worker and 3.5 to 2-nd worker.

## Example 2:
## *Ví dụ 2:*

**Input:** quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
**Output:** 30.66667
**Explanation:** We pay 4 to 0-th worker, 13.33333 to 2-nd worker and 13.33333 to 3-rd worker.

---

## Constraints:
## *Ràng buộc:*

*   `n == quality.length == wage.length`
*   `1 <= k <= n <= 10^4`
*   `1 <= quality[i], wage[i] <= 10^4`
