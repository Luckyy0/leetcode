# Problem Analysis: Sum Game

## Problem Description
String `num` (digits and '?'). Length even.
Alice and Bob replace '?'.
Alice wants `sum(left) != sum(right)`.
Bob wants `sum(left) == sum(right)`.
Alice goes first.
Return true if Alice wins, false if Bob wins.

## Analysis

1.  **Game Theory / Balance**:
    -   Calculate `sumLeft`, `cntLeft` ('?'), `sumRight`, `cntRight`.
    -   Let `diff = sumLeft - sumRight`.
    -   Let `q = cntLeft - cntRight`.
    -   Alice wants final diff != 0. Bob wants final diff == 0.
    -   Total turns = `cntLeft + cntRight`.
    -   If total turns is odd, Alice makes the last move. Since she wants != 0, she can always ensure the last digit makes it unbalanced (unless exact constrained, but usually with sum she has control). Usually last move advantage for != 0 is huge.
    -   Wait. If `(cntLeft + cntRight)` is odd, Alice wins. Why? Because Bob makes `(total-1)/2` moves. Alice makes `(total+1)/2`.
    -   Actually, simpler logic:
        -   Final state: `sumLeft + valLeft = sumRight + valRight`.
        -   `diff + valLeft - valRight = 0`.
        -   `valRight - valLeft = diff`.
        -   Range of `valRight - valLeft` depends on `q` (net question marks).
        -   Specifically, each '?' adds [0, 9].
        -   If `q` is odd, total number of ? is odd (wait, q is diff. total is sum).
        -   If `cntLeft + cntRight` is odd, Alice wins.
    -   Assume `cntLeft + cntRight` is even.
    -   Bob can win (make sum equal) ONLY IF `diff + (q * 4.5) == 0`.
    -   Why 4.5? Because Bob can mirror Alice's moves on average to make average 9 per pair of moves (one Alice, one Bob).
    -   Wait.
        -   If `q = 0` (equal ? on both sides). Bob can copy Alice. If Alice puts `x` on left, Bob puts `x` on right. Or if Alice puts `x` on left, Bob puts `x` to balance?
        -   If `q = 0`, then `diff` must be 0 for Bob to win. If `diff != 0`, Alice wins.
        -   If `diff = 0` and `q = 0`, Bob wins (Copycat strategy guarantees equality).
    -   If `q != 0`. WLOG scale so `cntLeft >= cntRight`. Move `cntRight` pairs to be balanced (Bob copies). Remaining `q` ?s on left.
    -   Effectively standard logic:
        -   `Diff + (Remaining_Q / 2) * 9 == 0`.
        -   Why? Alice and Bob fill remaining `Q` slots on one side.
        -   There are `Q` slots. Alice moves first on these? No, global turn order.
        -   But generally, Bob can force the sum of `Q` slots to be `Q/2 * 9`.
        -   So if `diff + (Q/2 * 9) == 0`, Bob wins. Else Alice wins.
        -   Here `Q` is `cntLeft - cntRight`. `diff` is `sumLeft - sumRight`.
        -   Formula: `2 * diff + 9 * (cntLeft - cntRight) == 0`.

2.  **Verification**:
    -   Case: `num = "?329"`. L: `?`, 3. R: 2, 9. `cntL=1, sumL=3. cntR=0, sumR=11`.
    -   `diff = 3 - 11 = -8`. `q = 1`.
    -   Total ? is 1 (Odd). Alice wins. Correct.
    -   Case: `num = "5023"`. `sumL=5, sumR=5`. `q=0`. Bob wins.
    -   Formula: `2(-8) + 9(1) = -16+9 = -7 != 0`. True.
    -   Formula 2: `2(0) + 9(0) = 0`. False (Bob wins).

## Implementation Details
-   Count. Formula.
