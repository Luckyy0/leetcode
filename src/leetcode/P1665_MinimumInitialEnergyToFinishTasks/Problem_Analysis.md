# Problem Analysis: Minimum Initial Energy to Finish Tasks

## Problem Description
You are given an array `tasks` where `tasks[i] = [actual_i, minimum_i]`.
To process task `i`, you need energy $\ge minimum_i$. After processing, energy decreases by `actual_i`.
Return minimum initial energy needed to finish all tasks.

## Analysis

1.  **Greedy Order**:
    -   We should process tasks that have the largest "Gap" (`minimum - actual`) first.
    -   Why? Because these tasks require a high threshold but consume little. Processing them early when we have high energy is optimal.
    -   Actually, sort by `(minimum - actual)` descending.
    -   Proof Idea:
        -   Suppose two adjacent tasks A and B.
        -   Order A, B: Init $E$. NEED $E \ge m_A$ and $E - a_A \ge m_B \implies E \ge m_B + a_A$.
        -   Requiring $\max(m_A, m_B + a_A)$.
        -   Order B, A: Requiring $\max(m_B, m_A + a_B)$.
        -   Let's check example: A=[2, 10], B=[2, 5].
            -   Diffs: A->8, B->3. Order A, B (high diff first).
            -   Req(A, B) = $\max(10, 5+2) = 10$.
            -   Req(B, A) = $\max(5, 10+2) = 12$.
            -   Clearly A first is better.
        -   Sorting by diff desc works.

2.  **Validation**:
    -   Calculate requirements. Or simulate backwards?
    -   Actually, just calculating $\max(\dots)$ based on sorted order.
    -   Simulate:
        -   Current Energy needed `curr = 0`.
        -   Iterate tasks.
        -   For task `[a, m]`:
            -   If `curr < m`: Add `m - curr` to `initial`. `curr = m` (conceptually boosted).
            -   `curr -= a`.
        -   Actually better: just accumulate needed.
        -   Or simply: compute required start energy.
        -   Current needed = 0 (at end).
        -   Traverse Backwards (from last task to first task):
            -   To do task, we need `max(m, needed + a)`.
            -   `needed = max(m, needed + a)`.
            -   But this assumes fixed order.
            -   If we sort by diff descending, we process forward.
        -   Forward Simulation:
            -   Sort `tasks` by `(m-a)` descending.
            -   `ans` = 0. `current` = 0.
            -   For `t` in tasks:
                -   If `current < t[1]`: `add = t[1] - current`. `ans += add`. `current += add`.
                -   `current -= t[0]`.
            -   Return `ans`.

3.  **Complexity**:
    -   Time: $O(N \log N)$.
    -   Space: $O(1)$ (or login sort).

## Implementation Details
-   Comparator `(a, b) -> (b[1] - b[0]) - (a[1] - a[0])`.
