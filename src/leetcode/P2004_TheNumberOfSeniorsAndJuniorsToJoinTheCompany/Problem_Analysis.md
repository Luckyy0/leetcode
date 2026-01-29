# Problem Analysis: The Number of Seniors and Juniors to Join the Company

## Problem Description
Table `Candidates` (employee_id, experience, salary).
Hire Seniors first (exp='Senior') within budget $70000.
Then hire Juniors (exp='Junior') with **remaining** budget.
Maximize number of hires.
When prioritizing, cheaper salary first.

## Analysis

1.  **CTE + Cumulative Sum**:
    -   Separate Seniors and Juniors.
    -   Calculate cumulative salary for Seniors (ordered by salary).
    -   Filter Seniors where cum_sum <= 70000. Count them.
    -   Calculate `remaining_budget = 70000 - max(senior_cost)`.
    -   Calculate cumulative salary for Juniors.
    -   Filter Juniors where cum_sum <= remaining_budget. Count them.
    -   Union results or count separately.

## Implementation Details
-   `SUM() OVER (ORDER BY salary)`.
-   `IFNULL`.
