# Problem Analysis: Longest Common Subpath

## Problem Description
`n` cities (0 to n-1). `m` friends.
`paths` array of arrays.
Longest common subpath appearing in ALL friends' paths.
Constraint: total length of paths $\le 10^5$. Max length $\le 10^5$.
This means we can do $O(\text{total length} \cdot \log (\text{min\_len}))$.

## Analysis

1.  **Binary Search on Length + Rolling Hash**:
    -   Search `len` from 0 to `min(path_lengths)`.
    -   Check if a common subpath of length `len` exists.
    -   Use Rolling Hash (Rabin-Karp) to collect hashes of length `len` for each friend.
    -   Intersect sets of hashes.
    -   If intersection not empty, check possible (hash collision). Since constraints are loose enough for one hash? No, use double hash for safety or handle collisions.
    -   Rolling hash updates are $O(1)$. Total check time $O(L_{total})$.
    -   Overall complexity $O(L_{total} \log (\min\_len))$.
    -   Base: Large prime (e.g. 100003), Mod: $10^9+7$ and maybe another one. Single Mod might collide. $10^5$ elements, collision probability with $2^{64}$ (unsigned long) is low. With $10^9+7$, birthday paradox roughly $\sqrt{P} \approx 30000$. Collision likely.
    -   Use two mods or `unsigned long long`.

2.  **Suffix Automaton / Suffix Array**:
    -   Generalized Suffix Array/Automaton. Linear time.
    -   But implementation is complex.
    -   BS + Hash is standard for this scope.

## Implementation Details
-   `check(len)` function.
-   Double hash to pass strong tests.
-   `Set<Long>` intersection.
