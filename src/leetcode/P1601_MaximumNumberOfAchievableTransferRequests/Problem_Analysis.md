# Problem Analysis: Maximum Number of Achievable Transfer Requests

## Problem Description
We have `n` buildings numbered from 0 to `n - 1`. Each building has a number of employees.
We have a list of `requests` where `requests[i] = [from_i, to_i]` represents an employee's request to transfer from building `from_i` to building `to_i`.
All buildings are full, so a list of requests is achievable only if for each building, the net change in employee count is zero. This means the number of employees leaving is equal to the number of employees entering.
Return the maximum number of achievable requests.

## Analysis

1.  **Constraints**:
    -   `n <= 20`.
    -   `requests.length <= 16`.
    -   Small constraints suggest exhaustive search / backtracking.

2.  **Backtracking Algorithm**:
    -   We iterate through each request index (0 to `requests.length`).
    -   State: `index`, `netChange` array (size `n`).
    -   At each step, we have two choices:
        1.  **Take the request**: `netChange[from]--`, `netChange[to]++`. Recursive call. `count + 1`.
        2.  **Skip the request**: No change to `netChange`. Recursive call. `count`.
    -   Base Case: `index == requests.length`.
        -   Check if `netChange` is all zeros.
        -   If yes, return 0 (valid path end).
        -   If no, return -Infinity (invalid path).
    -   Result depends on picking the max of (1 + take, skip).

3.  **Optimization**:
    -   Since we want the *maximum* number, counting "taken" requests is straightforward.
    -   The maximum depth is 16. $2^{16} = 65536$.
    -   Checking array takes 20 steps. Total operations $\approx 1.3 \times 10^6$. Very safe.

4.  **Complexity**:
    -   Time: $O(2^L \cdot N)$ where L is requests length.
    -   Space: $O(N)$ for recursion stack and array.

## Implementation Details
-   `backtrack(int idx, int count, int[] countArr)`? No, `netChange` array needs to be modified and backtracking (restored).
