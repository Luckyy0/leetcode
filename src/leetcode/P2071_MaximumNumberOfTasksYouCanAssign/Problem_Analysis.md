# Problem Analysis: Maximum Number of Tasks You Can Assign

## Problem Description
`tasks[]` (effort needed), `workers[]` (strength).
`pills` available, each strength `strength`.
Each worker can take at most 1 pill.
A worker can do a task if `strength + (pill ? strength : 0) >= task`.
Assign max tasks.

## Analysis

1.  **Binary Search on Answer**:
    -   Check if `k` tasks can be done.
    -   Which tasks? Smallest `k`.
    -   Which workers? Strongest `k` (or generally needed).
    -   Strategy for `check(k)`:
        -   Take smallest `k` tasks.
        -   Take strongest `k` workers. (Or strongest available? Strongest are most flexible).
        -   Actually, weaker workers need help more.
        -   Use `TreeMap` or `Deque` for workers.
        -   Iterate tasks from largest (hardest) to smallest.
        -   Try to assign current task to strongest worker *without* pill if possible?
        -   Or *with* pill if needed.
        -   Optimized Greedy Strategy:
            -   Tasks: `t_1, t_2 ... t_k` (sorted). Process Largest first (`t_k`).
            -   Workers: `w_1 ... w_k` (sorted largest).
            -   If strongest worker `W` can do `T` without pill: Use him?
            -   Wait. If `W` uses no pill, he is 'powerful'. Should we save him for harder tasks?
            -   But `T` is current hardest.
            -   If `W >= T`: Match.
            -   If `W < T`: Can `W + pill >= T`? If yes, match?
            -   Actually we process tasks descending.
            -   If `W` (strongest) can do `T` without pill: Does it hurt to use him?
                -   Maybe `W` is overkill. But `W` is the only one who might do *even harder* tasks. But we process hardest first. So `W` is best candidate?
                -   Actually, maybe WEAKER worker can do `T` with pill?
                -   If we use Strongest `W` for `T` (no pill), we save a pill.
                -   If we use Weaker `w` (with pill) for `T`, we use a pill but save Strongest `W`.
                -   Using a pill is limited resource. Saving `W` (strength) vs Saving Pill.
                -   BUT `W` is stronger. Keeping `W` allows handling future (smaller) tasks easily.
                -   However, smaller tasks are easier.
                -   Ideally: Use weakest worker capable of doing the task (with/without pill).
            -   Correct Greedy for `check(k)`:
                -   Tasks sorted `T_1 \le ... \le T_k`. Process from HARDEST `T_k` down to `T_1`.
                -   Workers sorted. Store in multiset/Deque.
                -   For `T` (current hardest):
                    -   Can greatest worker do it without pill?
                    -   If `max(W) >= T`: Use `max(W)`. (Why? Because `T` is hard. `max(W)` satisfies it. Saving `max(W)` for easier task is waste).
                    -   If `max(W) < T`:
                        -   Must use pill.
                        -   If pills == 0, fail.
                        -   Find weakest worker `w` such that `w + pill >= T`.
                        -   If no such worker, fail.
                        -   If exists, use that worker (remove from pool).
                        -   Why weakest valid? To save stronger workers for other hard tasks (that might not need pills or need higher base).
                        -   Wait. If we use strongest worker with pill?
                        -   If `max(W) + pill < T`, impossible.
            -   Algorithm:
                -   Tasks `0..k-1`. Workers `n-k..n-1` (strongest k).
                -   Deque of workers.
                -   Actually, efficiently finding "weakest >= val" requires `TreeMap` or `multiset`. `Deque` works if we only add workers that satisfy condition?
                -   Wait. Since we process tasks descending?
                -   It's complicated.
                -   Standard approach: Works `Deque`.
                -   For tasks usually smallest?
                -   Alternative Check:
                    -   Smallest `k` tasks. Strongest `k` workers.
                    -   Process tasks from SMALLEST?
                    -   If we process smallest `T`, we should use weakest capable worker?
                    -   Let's use `TreeMap` approach processing from Hardest Task.
                    -   Sort tasks. Take subarray `0..k-1`.
                    -   Sort workers. Take `n-k..n-1`. Put into TreeMap.
                    -   Iterate `task` in `k-1` down to `0`.
                    -   Check if `TreeMap.lastKey()` (strongest) `>= task`.
                        -   If yes, remove `lastKey`.
                        -   If no, use pill. Need `worker + pill >= task` => `worker >= task - strength`.
                        -   Find smallest key `>= task - strength`. `ceilingKey`.
                        -   If null, impossible.
                        -   Else remove that key, decrement pills.

## Implementation Details
-   Binary Search `0` to `min(tasks.len, workers.len)`.
-   `check(k)`: `TreeMap<Integer, Integer>`.
