# 826. Most Profit Assigning Work / Lợi nhuận Tối đa khi Giao việc

## Problem Description / Mô tả bài toán
You have `n` jobs and `m` workers. You are given three arrays: `difficulty`, `profit`, and `worker`.
Bạn có `n` công việc và `m` công nhân. Bạn được cấp ba mảng: `difficulty`, `profit` và `worker`.

- `difficulty[i]` and `profit[i]` are the difficulty and the profit of the `ith` job.
- `worker[j]` is the ability of the `jth` worker. Every worker can be assigned at most one job, but one job can be completed multiple times by different workers.

Return the maximum profit we can achieve.
Trả về lợi nhuận tối đa mà chúng ta có thể đạt được.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy and Sorting / Tham lam và Sắp xếp
A worker with ability `A` should pick a job with `difficulty <= A` that has the maximum profit.
Một công nhân có khả năng `A` nên chọn một công việc có độ khó `difficulty <= A` và mang lại lợi nhuận cao nhất.

Algorithm:
1. Combine jobs into pairs `(difficulty, profit)`.
2. Sort jobs by difficulty.
3. Sort workers by their ability.
4. Iterate through the workers:
   - For each worker, identify all feasible jobs (difficulty <= ability).
   - Keep track of the `bestProfit` seen so far among feasible jobs.
   - Add `bestProfit` to the total result.

### Complexity / Độ phức tạp
- **Time**: O(N log N + M log M) where N is jobs and M is workers.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Two-Pointer Greedy
By sorting both jobs and workers, we can use a two-pointer approach to keep track of the maximum possible profit for a given ability level without redundant computations.
Bằng cách sắp xếp cả công việc và công nhân, chúng ta có thể sử dụng phương pháp hai con trỏ để theo dõi lợi nhuận tối đa có thể cho một mức khả năng nhất định mà không cần tính toán dư thừa.

---
