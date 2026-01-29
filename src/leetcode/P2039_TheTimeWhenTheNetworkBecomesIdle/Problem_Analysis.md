# Problem Analysis: The Time When the Network Becomes Idle

## Problem Description
Graph (edges). Server 0.
Nodes send message to 0. Master 0 replies.
Round trip time `2 * dist[i]`.
Nodes re-send message every `patience[i]` seconds until reply received.
Find when network idle (no messages in flight).

## Analysis

1.  **BFS Shortest Path**:
    -   Calculate `dist[i]` from 0. `2 * dist[i]` is RTT.
2.  **Simulation per Node**:
    -   Node `u` sends at `t=0`.
    -   First reply arrives at `RTT`.
    -   If `RTT <= patience[u]`: Only 1 message sent. Idle at `RTT`.
    -   If `RTT > patience[u]`:
        -   Resends at `p, 2p, ... kp`.
        -   Last resend happens at `last_send_time < RTT`.
        -   Last resend time `k * p` such that `k * p < RTT`.
        -   Formula: `last_resend = ((RTT - 1) / p) * p`.
        -   This last message arrives back at `last_resend + RTT`.
        -   Idle at `last_resend + RTT + 1`.
    -   Network idle when max of all nodes idle times.

## Implementation Details
-   Adjacency List.
-   BFS.
-   Max loop.
