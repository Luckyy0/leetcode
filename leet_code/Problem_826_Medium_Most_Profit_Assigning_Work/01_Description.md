# Result for Most Profit Assigning Work
# *Kết quả cho bài toán Giao việc đạt lợi nhuận tối đa*

## Description
## *Mô tả*

You have `n` jobs and `m` workers. You are given three arrays: `difficulty`, `profit`, and `worker` where:
*Bạn có `n` công việc và `m` công nhân. Bạn được cho ba mảng: `difficulty`, `profit`, và `worker` trong đó:*

*   `difficulty[i]` and `profit[i]` are the difficulty and the profit of the `i`-th job.
    *   `difficulty[i]` và `profit[i]` là độ khó và lợi nhuận của công việc thứ `i`.*
*   `worker[j]` is the ability of `j`-th worker (i.e., the `j`-th worker can only complete a job with difficulty at most `worker[j]`).
    *   `worker[j]` là năng lực của công nhân thứ `j` (tức là công nhân thứ `j` chỉ có thể hoàn thành công việc có độ khó tối đa là `worker[j]`).*

Every worker can be assigned **at most one** job, but one job can be **completed multiple times**.
*Mỗi công nhân có thể được giao **tối đa một** công việc, nhưng một công việc có thể được **hoàn thành nhiều lần**.*

*   For example, if three workers have the same ability, they can all do the same job with the best profit.
*   *Ví ví dụ: nếu ba công nhân có cùng năng lực, họ đều có thể làm cùng một công việc có lợi nhuận tốt nhất.*

Return *the maximum profit we can achieve after assigning every worker to a job*.
*Trả về *lợi nhuận tối đa chúng ta có thể đạt được sau khi giao việc cho mọi công nhân*.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
**Output:** 100
**Explanation:** Workers are assigned jobs of difficulties [4,4,6,6] and they get profits of [20,20,30,30] separately.

## Example 2:
## *Ví dụ 2:*

**Input:** difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
**Output:** 0

---

## Constraints:
## *Ràng buộc:*

*   `n == difficulty.length`
*   `n == profit.length`
*   `m == worker.length`
*   `1 <= n, m <= 10^4`
*   `1 <= difficulty[i], profit[i], worker[i] <= 10^5`
