# Problem Analysis: Stock Price Fluctuation

## Problem Description
Stream of stock prices `(timestamp, price)`.
Corrections possible (update price at old timestamp).
Functions:
-   `update(timestamp, price)`.
-   `current()`: price at max timestamp.
-   `maximum()`: max price across all records.
-   `minimum()`: min price across all records.

## Analysis

1.  **Data Structures**:
    -   `Map<timestamp, price>` to store current price for each timestamp.
    -   `TreeMap<price, count>` to store prices and find min/max efficiently.
    -   `maxTimestamp` to track `current`.
    -   When `update`:
        -   If timestamp exists: decrement old price count in TreeMap (remove if 0).
        -   Update Map.
        -   Add new price to TreeMap.
        -   Update `maxTimestamp`.

## Implementation Details
-   `HashMap`.
-   `TreeMap`.
