# Problem Analysis: Maximum Employees to Be Invited to a Meeting

## Problem Description
`favorite` array. Graph where edge `i -> favorite[i]`.
Round table. Attendee `i` must sit next to `favorite[i]`.
Maximize attendees.

## Analysis

1.  **Functional Graph**:
    -   Each node has exactly one outgoing edge.
    -   Configuration of components: Cycles with trees attached.
    -   Seating logic:
        -   If `i` sits next to `j` (`fav[i] == j`), then `j` can be left or right of `i`.
        -   Condition: for every `i`, one neighbor is `fav[i]`.
        -   Possibilities:
            1.  **Full Cycle**: A cycle of length `k > 2`. Everyone in cycle sits together. Size `k`.
                -   Trees attached to cycle CANNOT join, because cycle nodes already use their "fav" neighbor. They need the other neighbor to complete the cycle.
                -   Specifically, node `u` in cycle needs `fav[u]` on one side. The other side is occupied by `v` where `fav[v] == u`.
                -   So only cycle nodes participate. Maximize cycle length.
            2.  **Mutal Pair (Cycle of length 2)**: `i <-> j`.
                -   `i` needs `j`. `j` needs `i`.
                -   `i` has `j` on one side. Other side is free.
                -   `j` has `i` on one side. Other side is free.
                -   We can extend "chains" (trees) towards `i` and `j`.
                -   Longest arm incoming to `i` (excluding `j`) + Longest arm incoming to `j` (excluding `i`) + 2.
                -   We can sum up sizes of All such 2-cycle components (since they can sit in disjoint arcs of the table).
                -   Table allows disconnected components? NO. "Round table". But we can place multiple linear segments (chains ending in 2-cycles) next to each other?
                -   Wait. If we have multiple 2-cycle groups. Group A (linear chain A) and Group B.
                -   Can we place them?
                -   Chain A: ... -> u -> v <-> w <- ...
                -   The ends are "leaves".
                -   Actually, the requirement is "For EACH person, must sit next to favorite".
                -   In Chain A: Leaves are happy? No.
                -   Constraint: Every invited person must satisfy condition.
                -   If chain `x -> y -> z <-> w`.
                -   `z` likes `w`. `w` likes `z`.
                -   `y` likes `z`. `z` must sit next to `y` and `w`. Condition met for `z`.
                -   `y` needs `z`. Sits next to `z`. Other side free.
                -   `x` likes `y`. Sits next to `y`. Other side free.
                -   Leaf `x` likes `y`. Has `y`.
                -   So we can form a long line `LeftChain -> A <-> B <- RightChain`.
                -   This entire line is valid.
                -   Can we combine multiple such lines on a round table?
                -   Yes. `Line1 ... Line2 ...`.
                -   Does the connection point break validity?
                -   If `Line1` end is `x`, `Line2` start is `p`.
                -   `x` sits next to `p`. Does `x` need `p`? No, `x` needs its neighbor in Line1.
                -   `x` requirement met by Line1 neighbor. The other neighbor is irrelevant.
                -   So YES, we can concatenate ALL 2-cycle components.
                -   Total size = Sum of (LongestChain(A) + LongestChain(B) + 2) for all mutual pairs `A <-> B`.
    
    -   Result is `max(MaxCycleSize, SumOf2CycleChains)`.
    -   Max Cycle Size (for k > 2): Only one cycle can be picked? Yes, disconnected cycles can't sit together because cycle nodes have NO free side. (Each cycle node `u` needs `forward`. `backward` needs `u`. Both sides occupied).

## Implementation Details
-   Find all components/cycles.
-   Calculate `indegree` for topological sort (to find chains/trees depth).
-   `depth[u]` = max length of chain ending at `u`.
-   Use BFS on reversed graph (edges `fav[u] <- u`)? Or Topo Sort.
    -   Topo Sort allows computing max depth for nodes in trees.
    -   After Topo Sort, only cycles remain with non-zero indegree.
-   Iterate remaining nodes to find cycles.
    -   If cycle len == 2: (`u, v`). Add `depth[u] + depth[v] + 2` to `sum2Cycles`.
    -   If cycle len > 2: Update `maxCycle`.
-   Implementation:
    -   Indegree array.
    -   Queue inputs with 0 indegree.
    -   `dp[u]` stores max chain length ending at `u` (using nodes processed in topo). Initial 0 (since count starts at u, actually chain length outside u). Let's say `dp[u]` is max length of path ending at `u` *exclusive* or *inclusive*. Let's say length of `x->...->u`.
    -   When processing `u`, push to `v = fav[u]`. `dp[v] = max(dp[v], dp[u] + 1)`.
    -   Finally, find cycles.
    -   Vis array for cycle detection.

