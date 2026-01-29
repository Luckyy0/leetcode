# 857. Minimum Cost to Hire K Workers / Chi phí Tối thiểu để Thuê K Công nhân

## Problem Description / Mô tả bài toán
There are `n` workers. You are given two integer arrays `quality` and `wage` where `quality[i]` is the quality of the `ith` worker and `wage[i]` is the minimum wage expectation for the `ith` worker.
Có `n` công nhân. Bạn được cấp hai mảng số nguyên `quality` và `wage` trong đó `quality[i]` là chất lượng của công nhân thứ `i` và `wage[i]` là mức lương mong đợi tối thiểu của công nhân thứ `i`.

We want to hire exactly `k` workers such that:
Chúng ta muốn thuê đúng `k` công nhân sao cho:
1. Every worker in the paid group must be paid at least their minimum wage expectation.
Mọi công nhân trong nhóm được thuê phải được trả ít nhất là mức lương mong đợi tối thiểu của họ.
2. In the group, everyone's pay must be in the same ratio to their quality.
Trong nhóm, lương của mọi người phải có cùng tỷ lệ với chất lượng của họ.

Return the minimum cost.
Trả về chi phí tối thiểu.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy with PriorityQueue / Tham lam với PriorityQueue
Condition 2 implies: `pay[i] / quality[i] = Ratio` for all workers in the group.
Condition 1 implies: `Ratio * quality[i] >= wage[i]` => `Ratio >= wage[i] / quality[i]`.
To satisfy everyone, the group `Ratio` must be the maximum of all `wage/quality` in the $k$ workers.

Algorithm:
1. Calculate `ratio[i] = wage[i] / quality[i]` for all workers.
2. Sort workers by `ratio`.
3. Iterate through workers by ratio (as the potential group ratio):
   - Add current `quality` to a Max-Heap and maintain `totalQuality`.
   - If heap size exceeds `k`, remove the worker with the highest quality to minimize `totalQuality`.
   - If heap size is exactly `k`, calculate `cost = totalQuality * currentRatio`.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Ratio-Driven Selection
Since the group ratio is anchored by the maximum individual ratio among participants, we sort by this ratio. Then, for a fixed anchored ratio, we pick the $k$ workers with the lowest quality to minimize the total sum.
Vì tỷ lệ của nhóm được chốt bằng tỷ lệ cá nhân tối đa trong số những người tham gia, chúng ta sắp xếp theo tỷ lệ này. Sau đó, đối với một tỷ lệ chốt cố định, chúng ta chọn $k$ công nhân có chất lượng thấp nhất để giảm thiểu tổng chi phí.

---
