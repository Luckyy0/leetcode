# Problem Analysis: Accepted Candidates From the Interviews

## Problem Description
Table `Candidates` (candidate_id, name, years_of_exp, interview_id).
Table `Rounds` (interview_id, round_id, score).
Candidate accepted if:
1.  Years of exp >= 2.
2.  Sum of scores across all rounds > 15.

## Analysis

1.  **Join and Aggregation**:
    -   Join Candidates and Rounds on `interview_id`.
    -   Group by `candidate_id`.
    -   Filter `SUM(score) > 15` AND `years_of_exp >= 2` (or filter exp before group).
    -   Best: Filter `years_of_exp >= 2` in WHERE clause, then GROUP BY, then HAVING `SUM(score) > 15`.

## Implementation Details
-   `GROUP BY`.
-   `HAVING`.
