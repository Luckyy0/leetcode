# Problem Analysis: The Number of Rich Customers

## Problem Description
Table `Store` (bill_id, customer_id, amount).
Rich customer: has at least one bill with amount > 500.
Count number of rich customers.

## Analysis

1.  **Filtering**:
    -   Filter `amount > 500`.
    -   Distinct `customer_id`.
    -   Count.

## Implementation Details
-   `COUNT(DISTINCT customer_id)`.
