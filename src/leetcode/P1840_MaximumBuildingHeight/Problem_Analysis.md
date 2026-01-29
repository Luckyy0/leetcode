# Problem Analysis: Maximum Building Height

## Problem Description
`n` buildings. `restrictions` (id, maxh).
`h[1] = 0`.
`|h[i] - h[i+1]| <= 1`.

## Analysis

1.  **Constraint Propagation**:
    -   Add `(1, 0)` constraint.
    -   Add `(n, n-1)`? Effectively usually assume infinite, but `h[n]` is bounded by `h[n-1]+1`.
        Since we want *max* height anywhere, we don't strictly constrain `h[n]` to `n-1` unless problem says `h[n]` must be something. No, but `h` can't grow faster than restriction.
    -   Sort restrictions by id.
    -   Pass 1 (Left to Right): `res[i].h = min(res[i].h, res[i-1].h + dist)`.
    -   Pass 2 (Right to Left): `res[i].h = min(res[i].h, res[i+1].h + dist)`.
        -   Note: `res` array needs to include `n` if not present?
        -   Actually, we only care about intervals between restrictions to find peaks.
        -   We should add `(n, infinity)`? Actually, the rightmost segment goes from `res[last]` to `n`. Peak is `res[last].h + (n - res[last].id)`. So effectively just calculate that.
        -   So sort restrictions. Prepend `(1, 0)`.
        -   Run L->R. Run R->L.
        -   Then calculate max height in each interval.
        -   Interval between `i` and `i+1`: `h1` at `x1`, `h2` at `x2`.
        -   Peak height: `(h1 + h2 + (x2 - x1)) / 2`.
        -   Also check final segment `x_last` to `n`. Height at `n` is `h_last + n - x_last`.
        -   Wait, usually we don't add `(n, inf)` unless logical.
        -   Actually max height can be anywhere.
        -   If last restriction is at `x_m`, then height at `n` max is `h_m + (n - x_m)`. The peak in this range `[x_m, n]` is at `n`, value `h_m + n - x_m`.
        -   So this is covered by "interval" logic if we consider interval `(x_m, x_m)` with length? No. Just simply `max(ans, h_last + n - last_id)`.

2.  **Implementation**:
    -   List of `int[]{id, mass}`. Add `{1, 0}`.
    -   Sort.
    -   Propagate.
    -   Calc peaks.

## Implementation Details
-   `ArrayList`. Sort.
-   Be careful with index.
