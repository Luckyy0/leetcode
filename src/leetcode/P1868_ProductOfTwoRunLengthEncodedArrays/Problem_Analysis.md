# Problem Analysis: Product of Two Run-Length Encoded Arrays

## Problem Description
`encoded1`, `encoded2`. `[val, freq]`.
Compute dot product logic... wait, no. "Product of Two Run-Length Encoded Arrays".
Calculate `nums1[i] * nums2[i]`. Result is also RLE.
Both arrays decompress to same length.

## Analysis

1.  **Two Pointers**:
    -   Iterate both RLE arrays.
    -   Pointers `i`, `j`.
    -   Interval length to process: `len = min(encoded1[i][1], encoded2[j][1])`.
    -   Product value: `val = encoded1[i][0] * encoded2[j][0]`.
    -   Append `[val, len]` to result. Merge if last element in result has same `val`.
    -   Decrement counts. If count becomes 0, move pointer.
    -   Continue until end.

## Implementation Details
-   List of int arrays.
-   Result merging logic.
