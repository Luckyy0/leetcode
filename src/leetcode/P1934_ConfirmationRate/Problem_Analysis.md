# Problem Analysis: Confirmation Rate

## Problem Description
Table `Signups` (user_id, time_stamp). Table `Confirmations` (user_id, time_stamp, action 'confirmed'/'timeout').
Confirmation Rate: (number of 'confirmed' messages) / (total requested confirmation messages). 0 if no requests.
Round to 2 decimals.
Return for all users in `Signups`.

## Analysis

1.  **Left Join Group By**:
    -   Select from Signups `s`.
    -   Left join Confirmations `c`.
    -   Group by `s.user_id`.
    -   Rate: `AVG(IF(action='confirmed', 1, 0))`.
    -   Coalesce null to 0.

## Implementation Details
-   SQL.
