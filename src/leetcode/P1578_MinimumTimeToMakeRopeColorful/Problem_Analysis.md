# Problem Analysis: Minimum Time to Make Rope Colorful

## Problem Description
Alice has `n` balloons arranged on a rope. You are given a string `colors` where `colors[i]` is the color of the i-th balloon.
Alice wants the rope to be colorful. She does not want **two consecutive balloons** to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given an integer array `neededTime` where `neededTime[i]` is the time (in seconds) that Bob needs to remove the i-th balloon from the rope.
Return the minimum time Bob needs to make the rope colorful.

## Analysis

1.  **Logic**:
    -   If we have a group of consecutive balloons with the same color (e.g., "aa", "bbb"), we need to remove all but one of them to break the consecutiveness.
    -   To minimize the removal cost, we should keep the balloon with the highest removal cost (max `neededTime`) and remove the rest.
    -   Group Cost = `Sum(group costs) - Max(group costs)`.

2.  **Algorithm**:
    -   Iterate through the `colors` string.
    -   Identify consecutive groups.
    -   For each group of size > 1:
        -   Calculate sum of costs.
        -   Track max cost.
        -   `TotalCost += Sum - Max`.
    -   If size == 1, cost 0.

3.  **One Pass Implementation**:
    -   Track `currentSum` and `currentMax` for the current color group.
    -   If `colors[i] == colors[i-1]`, update `currentSum` and `currentMax`.
    -   If `colors[i] != colors[i-1]`, add `currentSum - currentMax` to `result`, reset for new group.
    -   Handle end of string logic (add last group).

4.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$.

## Implementation Details
-   Standard iteration.
