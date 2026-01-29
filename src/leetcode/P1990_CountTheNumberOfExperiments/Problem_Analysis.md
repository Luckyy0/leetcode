# Problem Analysis: Count the Number of Experiments

## Problem Description
Table `Experiments` (experiment_id, platform, experiment_name).
Possible platforms: 'Android', 'IOS', 'Web'.
Possible names: 'Reading', 'Sports', 'Programming'.
Count number of experiments for EACH (platform, name) pair.
Output 0 if no experiments.

## Analysis

1.  **Cross Join + Left Join**:
    -   Generate all combinations of Platform x Name.
    -   Left join `Experiments` table and count.
    -   Use `GROUP BY`.

## Implementation Details
-   Values constructor or Union for platforms/names.
