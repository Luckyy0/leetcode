# Problem Analysis: Best Team With No Conflicts

## Problem Description
You are the manager of a basketball team. For the upcoming tournament, you want to choose the team with the highest overall score. The score of the team is the sum of scores of all the players in the team.
However, the team must not have conflicts. A conflict exists if a younger player has a **strictly higher** score than an older player. A conflict does not occur between players of the same age.
Given lists `scores` and `ages`, return the highest overall score of all possible basketball teams.

## Analysis

1.  **Constraints**:
    -   $N \le 1000$. Scores, Ages $\le 10^5$.
    -   $O(N^2)$ solution is acceptable.

2.  **Sorting**:
    -   Sort players primarily by age (ascending), and secondarily by score (ascending).
    -   Consider players in sorted order $p_0, p_1, \dots, p_{n-1}$.
    -   For any pair $p_i, p_j$ with $j < i$:
        -   Age of $p_j \le$ Age of $p_i$.
        -   If Age($p_j$) < Age($p_i$), we must have Score($p_j$) $\le$ Score($p_i$) to allow including both (if we want to append $p_i$ to a team ending with $p_j$). Wait.
        -   Actually, avoiding conflict implies: If we pick a set, for any two players, if $age_A < age_B$, then $score_A \le score_B$.
        -   Since we sorted by age, if we pick a subsequence of players, the age condition is always "current index $\ge$ previous index".
        -   If ages are equal, no restriction.
        -   If ages distinct ($age_j < age_i$), we need $score_j \le score_i$.
        -   Basically, we need to find a subsequence such that scores are non-decreasing (monotonic).
        -   Since we sorted by Score for same Age, even within same age we are processing in increasing score order.
        -   So the problem reduces to: Find the subsequence of players (sorted) such that their scores are non-decreasing, maximizing the sum of scores.
        -   This is the "Maximum Sum Increasing Subsequence" problem.

3.  **DP Algorithm**:
    -   Combine `ages` and `scores` into `Player` objects. Sort.
    -   `dp[i]`: Max score of a team ending with player $i$.
    -   `dp[i] = score[i]`.
    -   For $j < i$:
        -   If `players[j].score <= players[i].score`:
            -   `dp[i] = max(dp[i], players[i].score + dp[j])`.
    -   Result is `max(dp)`.

4.  **Complexity**:
    -   Time: $O(N^2)$.
    -   Space: $O(N)$.

## Implementation Details
-   `Arrays.sort(players, (a, b) -> a.age == b.age ? a.score - b.score : a.age - b.age)`.
