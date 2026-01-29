# Problem Analysis: Find Servers That Handled Most Number of Requests

## Problem Description
You have `k` servers numbered from `0` to `k-1` that are being used to handle multiple requests simultaneously. Each server has infinite computational capacity but cannot handle more than one request at a time.
The requests are assigned to servers according to a specific algorithm:
-   The $i^{th}$ (0-indexed) request arrives.
-   If all servers are busy, the request is dropped (not handled at all).
-   If the $(i \% k)^{th}$ server is available, assign the request to that server.
-   Otherwise, assign the request to the next available server (wrapping around the list of servers and starting from 0 if necessary). For example, if the $i^{th}$ server is busy, try $(i+1)^{th}$, then $(i+2)^{th}$, etc.

You are given a strictly increasing array `arrival` of positive integers, where `arrival[i]` represents the arrival time of the $i^{th}$ request, and another array `load`, where `load[i]` represents the load of the $i^{th}$ request (the time it takes to complete). Your task is to find the busiest server(s).

## Analysis

1.  **Simulation & Data Structures**:
    -   We need to track the status of each server.
    -   Specifically, we need to know:
        1.  Which servers are currently available (idle).
        2.  Which servers are busy and when they will become available.
    -   **Busy Servers**: Use a `PriorityQueue` storing `(endTime, serverId)`. Min-heap by `endTime`.
    -   **Available Servers**: Use a `TreeSet` (ordered set) storing `serverId`. This allows us to efficiently find the "next available server >= target index".

2.  **Algorithm**:
    -   Initialize `available` TreeSet with all indices `0` to `k-1`.
    -   Initialize `busy` PriorityQueue.
    -   Initialize `requestsHandled` count array.
    -   Iterate through each request `i` with time `start` and duration `len`.
    -   **Free up servers**: While `busy.peek().endTime <= start`:
        -   Pop from `busy`.
        -   Add `serverId` to `available`.
    -   **Assign Request**:
        -   If `available` is empty, drop request.
        -   Target server `startNode = i % k`.
        -   Find smallest server `node` in `available` such that `node >= startNode`. (Use `ceiling(startNode)`).
        -   If `null` (not found), finding wraps around. Use `available.first()`.
        -   Assign request to `node`.
        -   Remove `node` from `available`.
        -   Add `(start + len, node)` to `busy`.
        -   `requestsHandled[node]++`.

3.  **Complexity**:
    -   Time: $O(N \log K)$.
    -   Space: $O(K)$.

## Implementation Details
-   `TreeSet` in Java supports `ceiling`.
-   PriorityQueue stores pairs.
