# Problem Analysis: Product's Worth Over Invoices

## Problem Description
Table `Product` (product_id, name).
Table `Invoice` (invoice_id, product_id, rest, paid, canceled, refunded).
Calculate total rest, paid, canceled, refunded for each product.
Order by `name`.

## Analysis

1.  **Logic**:
    -   Left Join from `Product` to `Invoice` to include products with no invoices.
    -   Aggregation `SUM`. Use `IFNULL` or `COALESCE` to return 0 instead of NULL.
    -   Order by `name`.

2.  **Query**:
    ```sql
    SELECT 
        p.name, 
        IFNULL(SUM(i.rest), 0) AS rest, 
        IFNULL(SUM(i.paid), 0) AS paid,
        IFNULL(SUM(i.canceled), 0) AS canceled,
        IFNULL(SUM(i.refunded), 0) AS refunded
    FROM Product p
    LEFT JOIN Invoice i ON p.product_id = i.product_id
    GROUP BY p.product_id
    ORDER BY p.name;
    ```
    - Check if needed to group by name? Usually `product_id` is safe key. If names distinct, name works. If duplicate names allowed for different IDs, grouping by ID and selecting arbitrary name (or min/max) is safer, but usually LC problems assume implicit key grouping or unique names if grouping by name. Standard: Group by ID.

## Implementation Details
-   Standard SQL.
