# Problem Analysis: The Category of Each Member in the Store

## Problem Description
Tables: `Members` (member_id, name), `Visits` (visit_id, member_id, visit_date), `Purchases` (visit_id, charged_amount).
Categorize:
-   `conversion_rate` = (100 * total_purchases / total_visits).
-   `Diamond`: CR >= 80.
-   `Gold`: 50 <= CR < 80.
-   `Silver`: CR < 50.
-   `Bronze`: No visits.

## Analysis

1.  **Joins and Case**:
    -   Left join members with Visits.
    -   Left join Visits with Purchases (count purchase if `visit_id` in Purchases).
    -   Count visits. Count purchases (distinct visits with purchase).
    -   Compute conversion rate.
    -   Handle 0 visits case.

## Implementation Details
-   `COUNT(v.visit_id)`.
-   `COUNT(p.visit_id)`.
-   `CASE WHEN`.
