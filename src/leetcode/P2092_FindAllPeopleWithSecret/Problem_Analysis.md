# Problem Analysis: Find All People With Secret

## Problem Description
`n` people. `meetings[i] = [x, y, time]`.
Person 0 knows secret at time 0. `firstPerson` also knows at time 0.
Secret spreads if known person meets someone.
Instant spread.
Spreads via meetings at strictly same time `t` transitively?
Yes, "meetings ... order of time".
Returns list of people who know it.

## Analysis

1.  **Sort and Union-Find / BFS per Time Period**:
    -   Sort meetings by time.
    -   Group meetings by same timestamp `t`.
    -   At time `t`, build graph of people meeting.
    -   Propagate secret from those who already know it.
    -   Efficient way:
        -   For a batch at time `t`, use Union-Find.
        -   Start with UF containing only involved people (fresh UF or reset state).
        -   Union pairs involved in meetings.
        -   Check which components contain someone who *already knows* the secret.
        -   Mark everyone in those components as knowing.
        -   Crucial: Reset UF parent pointers for those who didn't learn secret (so they don't stay connected in future steps if UF is reused? No, standard is to maintain global known set).
        -   Actually, UF nodes can be large (up to N). Only process involved nodes.
        -   Resetting involved nodes is $O(K)$ where K is batch size.
        -   Global Known set: `boolean[] known`.

2.  **Algorithm**:
    -   `known[0] = true`, `known[firstPerson] = true`.
    -   Sort meetings by time.
    -   Iterate chunks with same time.
    -   In a chunk:
        -   Construct graph (adjacency list) for people in this chunk.
        -   Find all people in chunk who *currently* know secret. Add to Queue.
        -   BFS in the chunk-graph. Mark reachable as known.
    -   Optimize: Don't use full UF. Adjacency list is better for reachability within sparse involved subgraph.

## Implementation Details
-   `Arrays.sort`.
-   Loop `i` through meetings. `j` to find end of time chunk.
-   `Set<Integer> chunkPeople`.
-   `Map<Integer, List<Integer>> graph`.
-   BFS.
