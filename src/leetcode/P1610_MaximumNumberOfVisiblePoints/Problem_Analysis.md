# Problem Analysis: Maximum Number of Visible Points

## Problem Description
You are given an array `points`, an integer `angle`, and your `location`, where `location = [posx, posy]` and `points[i] = [xi, yi]`. Both your location and the target points are on a 2D plane.
You can see some set of points if the angle formed by the point, your position, and the immediate field of view does not exceed `angle`.
Return the maximum number of points you can see.

## Analysis

1.  **Geometry**:
    -   Calculate polar angle for each point relative to `location`. `atan2(dy, dx)` returns result in radians $[-\pi, \pi]$ or degrees.
    -   Convert to degrees for easier handling with `angle`.
    -   Points coincident with `location` are always visible. Count them separately (`baseCount`).

2.  **Sliding Window**:
    -   Sort the angles.
    -   The field of view is a circular sector.
    -   Since the range wraps around $360^\circ$, append the same angles + 360 to the list.
    -   Use sliding window to find max count of angles within window of size `angle`.
    -   `while (angles[j] - angles[i] <= angle)`: update max, increment j.

3.  **Complexity**:
    -   Time: $O(N \log N)$ for sorting.
    -   Space: $O(N)$ to store angles.

## Implementation Details
-   `Math.atan2(y, x)` returns radians. Convert `Math.toDegrees`.
-   Handle duplicate points (same as location).
-   List `angles`.
