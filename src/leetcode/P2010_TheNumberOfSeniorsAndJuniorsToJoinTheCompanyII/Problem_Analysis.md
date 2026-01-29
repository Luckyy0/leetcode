# Problem Analysis: The Number of Seniors and Juniors to Join the Company II

## Problem Description
P2010 usually similar to P2004 but possibly different output format or small variation?
"The Number of Seniors and Juniors to Join the Company II".
Usually asks to list the IDs instead of count?
"Report the IDs of the candidates".
Same logic: Seniors within 70000, then Juniors with remaining.
Return `employee_id`.

## Analysis

1.  **CTE + Window Functions**:
    -   Same logic as P2004.
    -   Output `employee_id`.

## Implementation Details
-   CTE HiredSeniors.
-   CTE HiredJuniors.
-   Union.
