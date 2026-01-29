# Problem Analysis: Describe the Painting

## Problem Description
`segments` (`start, end, color`).
Paint segments on 1D line.
Colors are additive (sum). A mix of colors is the sum.
Return decomposition into disjoint segments where sum of colors is constant.
E.g. `[1, 4, 5], [4, 7, 7]`.
`[1, 4)`: 5. `[4, 7)`: 7.
Overlap: `[1, 5, 10], [2, 6, 20]`.
`[1, 2)`: 10.
`[2, 5)`: 10+20=30.
`[5, 6)`: 20.

## Analysis

1.  **Sweep Line**:
    -   Events at `start` (+color) and `end` (-color).
    -   Sort points.
    -   Iterate sorted points.
    -   From `prev_point` to `curr_point`, if `current_sum > 0`, add segment `[prev, curr, sum]`.
    -   Update `current_sum`.
    -   Merge duplicates? Use a Map `point -> change`. TreeMap to sort automatically.
    -   Note: "color" is additive (problem specific definitions: "Painting" usually distinct or sum? "sum of the colors"). Yes.
    -   Constraint points up to $10^5$. Length $10^5$. TreeMap efficient.

## Implementation Details
-   `TreeMap<Integer, Long> map`.
-   Iterate keys.
