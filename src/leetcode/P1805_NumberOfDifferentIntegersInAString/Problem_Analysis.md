# Problem Analysis: Number of Different Integers in a String

## Problem Description
String `word` mixed digits and letters.
Replace non-digits with space.
Parse integers. Count distinct integers.
"123" and "0123" are same.

## Analysis

1.  **Regex Split**:
    -   Split by `[a-z]+`.
    -   Filter empty strings.
    -   Remove leading zeros from each part.
    -   Store in Set.

2.  **Implementation**:
    -   `Set<String>`. Store as string because integer might overflow `long`? Length up to 1000. String required.
    -   Remove leading zeros carefully. "000" -> "0".

## Implementation Details
-   `replaceAll`. `split`.
