# Problem Analysis: Daily Leads and Partners

## Problem Description
Table `DailySales` (date_id, make_name, lead_id, partner_id).
Count distinct leads and partners for each date_id and make_name.

## Analysis

1.  **Group By**:
    -   `date_id`, `make_name`.
    -   `COUNT(DISTINCT lead_id)`.
    -   `COUNT(DISTINCT partner_id)`.

2.  **Implementation**:
    -   Standard.
