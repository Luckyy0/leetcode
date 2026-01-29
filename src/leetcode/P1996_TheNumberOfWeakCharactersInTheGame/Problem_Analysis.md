# Problem Analysis: The Number of Weak Characters in the Game

## Problem Description
Array `properties` (attack, defense).
Weak character: exists another character `j` such that `attr_j > attr_i` AND `def_j > def_i`.
Count weak characters.

## Analysis

1.  **Sorting**:
    -   Sort by `attack` ascending.
    -   If `attack` equal, sort by `defense` descending.
    -   Why defense descending?
        -   If we process left to right, we want to know if there exists a character with GREATER attack and GREATER defense.
        -   Actually, simpler to sort by `attack` descending.
        -   Sort `attack` DESC. If equal, `defense` ASC? No.
        -   Let's process from highest attack downwards.
        -   Consider sorted: `(10, 4), (10, 3), (8, 5), ...`
        -   We track `maxDefense` seen so far.
        -   If current character has `defense < maxDefense`, does it mean it's weak?
        -   `maxDefense` must come from a character with **strictly greater** attack.
        -   If we sort by Attack DESC, then for current `i`, characters processed before have `attack >= curr.attack`.
        -   If `attack > curr.attack` and `defense > curr.defense`, then weak.
        -   If `attack == curr.attack`, we cannot use it to mark current as weak.
        -   So when sorting, for same attack group, we should process smallest defense first? No.
        -   Let's arrange to handle the "strictly greater" condition easily.
        -   Sort: Attack DESC. For ties: Defense DESC?
            -   Example: `(5, 5), (5, 4), (4, 3)`.
            -   Process (5, 5). MaxDef = 5.
            -   Process (5, 4). Attack same. We cannot say (5, 5) makes (5, 4) weak.
            -   Current logic: `def < maxDef` -> Weak.
            -   If sorted `(5, 5), (5, 4)`, then at (5, 4), MaxDef=5. 4 < 5. Would mark weak. Incorrect.
        -   We need to ensure MaxDef only includes defenses from Strictly Greater Attach.
        -   Trick: For equal attack, sort Defense ASC.
            -   `(5, 4), (5, 5), (4, 3)`.
            -   Process (5, 4). MaxDef = 4.
            -   Process (5, 5). 5 !< 4. MaxDef = 5.
            -   Process (4, 3). 3 < 5. Weak. Correct.
    -   So: Sort Attack DESC, Defense ASC.
    -   Then iterate: if `def < maxDef`, count++. Else `maxDef = def`.

## Implementation Details
-   `Arrays.sort`.
-   Comparator.
