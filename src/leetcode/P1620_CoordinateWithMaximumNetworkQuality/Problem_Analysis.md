# Problem Analysis: Coordinate With Maximum Network Quality

## Problem Description
You are given an array of network towers `towers` where `towers[i] = [xi, yi, qi]` denotes the `i-th` network tower with location `(xi, yi)` and quality factor `qi`. You are also given an integer `radius`.
The network quality at any coordinate `(x, y)` is the sum of the qualities of the towers strictly within `radius` distance.
Quality contribution = $\lfloor \frac{q_i}{1 + d} \rfloor$, where `d` is Euclidean distance.
Find coordinate `[cx, cy]` with max network quality.
Constraints: coordinates $0 \dots 50$.

## Analysis

1.  **Search Value**:
    -   Coordinates are non-negative. Usually bounded by the min/max of tower locations.
    -   Max coordinate is 50. Range is small.
    -   We can iterate every integer coordinate $(x, y)$ in range $0 \le x \le 50, 0 \le y \le 50$.
    -   For each `(x, y)`, calculate network quality by summing contributions from all towers.
    -   Track max. Lexicographically smallest on tie.

2.  **Algorithm**:
    -   MaxX = 50, MaxY = 50.
    -   Loop x: 0 to 50. Loop y: 0 to 50.
    -   Inner loop towers: calculate dist. If $d \le radius$: sum `floor(q / (1+d))`.
    -   Update best.

3.  **Complexity**:
    -   $50 \times 50 \times N$. With $N \le 50$, total ops $\approx 1.25 \times 10^5$. Tiny.

## Implementation Details
-   `Math.sqrt`, `Math.floor`.
