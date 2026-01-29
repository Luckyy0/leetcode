# Problem Analysis: Sequentially Ordinal Rank Tracker

## Problem Description
System tracks scenery `(name, score)`.
`add(name, score)`: adds a location.
`get()`: returns the `k`-th best location.
Initially `k=1`. Each `get()` increments `k`.
"Best": Highest score. If tie, lexicographically smallest name.
So ordering is: `score` DESC, `name` ASC.

## Analysis

1.  **Two Heaps or Sorted Structure**:
    -   We need `k`-th element. `k` increases monotonically.
    -   Let `k` be current rank to return (1-based).
    -   We need to efficiently find element at rank `k`.
    -   Or maintain the element at rank `k`?
    -   Use two Priority Queues?
        -   `Lower`: Stores top `k` elements (best ones). Max-Heap (or Min-Heap?).
            -   Actually, if we want `k`-th best, we want the smallest in the "Top K" set.
            -   So `Lower` is a Min-Heap of the best `k` elements.
            -   Wait. If `k` increases, we move elements.
        -   `Upper`: Stores the rest (worse elements). Max-Heap.
    -   Current tracking:
        -   `current_k` (initialized 1).
        -   `left` heap (size `current_k`? or `current_k - 1`?).
        -   Let's maintain `left` heap containing the BEST `k` elements.
        -   The `k`-th best is the "worst" among the best `k`. So `left` should be a "Min-Heap" based on the specialized comparator (Score DESC, Name ASC).
        -   Ordering logic helper:
            -   Usually: `compare(a, b)` returns < 0 if a is "better".
            -   Here "better" means High Score.
            -   Let's clarify Order:
            -   Rank 1: Max Score.
            -   Rank 2: Second Max. ...
            -   Comparator `Comp`: Returns negative if `a` is better (higher rank).
            -   `a < b` if `a.score > b.score` or `a.score == b.score && a.name < b.name`.
        -   We want to maintain a "pivot" element? Or just heaps.
        -   Let's use the two-heap pattern for median finding, adapted.
        -   `left`: Stores the top `i` elements. We need the `i`-th element.
        -   Actually, simpler:
            -   Store BEST `i` items in a MIN-HEAP (according to 'better' criteria).
                -   The top of this heap is the `i`-th best, i.e., the worst among the best set.
            -   Store the REST in a MAX-HEAP (according to 'better' criteria).
                -   The top is the best among the rest.
        -   Wait.
            -   `Better` order: High Score.
            -   `Left`: Top `k` elements. Minimum of these (lowest rank/closest to k+1) is head.
                -   Since `Left` contains Rank 1 to Rank k.
                -   The "smallest" in `Left` (in terms of goodness) is Rank `k`.
                -   Rank 1 is "Maximum Goodness". Rank k is "Minimum Goodness within Top K".
                -   So `Left` should be a `Min-Heap` of Goodness. (i.e. Low Score, High Name).
                -   `Right`: Rest elements (Rank k+1 ...).
                -   We want efficiently access Rank k+1 if we grow `k`.
                -   `Right` should offer the "Best" of the rest (Rank k+1).
                -   So `Right` should be a `Max-Heap` of Goodness. (High Score, Low Name).
        -   `add()`:
            -   Add to `Left`? Or `Right`?
            -   Add to `Right`. Then check if `Right.top` is better than `Left.top`. Swap if needed.
            -   Maintain `Left` size = `k`.
        -   `get()`:
            -   Return `Left.top`.
            -   Increment `k`.
            -   Move best from `Right` to `Left` to increase `Left` size to `k+1`.

    -   Comparator:
        -   `isBetter(a, b)`: `a.score > b.score || (a.score == b.score && a.name < b.name)`.
        -   `Left`: Min-Heap (Score ASC, Name DESC). (Worst of Best).
        -   `Right`: Max-Heap (Score DESC, Name ASC). (Best of Worst).

## Implementation Details
-   Class `Entry`.
-   `PriorityQueue` left, right.
-   `k` is implicit (left.size()).
-   Initially `k=1`. On `get()`, we return element then increment requirement (move from right to left).
-   Wait. `get()` returns, *then* k increments? "The k-th best... query... increments k".
-   Yes.
-   Initially size 1?
-   Start: `Left` size 1. (Contains sentinel?). No, no items yet.
-   Wait. `add` happens before `get`.
-   Constraint: At least one `add` before `get`.
-   Algorithm:
    -   Maintain `Left` (Min-Heap) size `k`.
    -   `add(item)`:
        -   Push to `Left`.
        -   If `Left.size() > k` (actually we want to keep size k, but maybe item belongs in Right?):
            -   Push to `Left`.
            -   Move `Left.top` (weakest of best) to `Right`.
            -   Actually, standard logic:
                -   If new item is better than `Left.top` (weakest best): it enters `Left`, pushes `Left.top` to `Right`?
                -   Just `Left.add`, then `Right.add(Left.poll)`.
    -   `get()`:
        -   Answer is `Right.peek()`?
        -   Wait. Let's fix semantics.
        -   Let `Left` store Top `k-1` items.
        -   Let `Right` store Rank `k` and worse.
        -   Then `Right.peek()` is the answer.
        -   `get()`: `res = Right.peek()`. Increment `k` -> need `Left` size `k`.
        -   Move `Right.poll()` to `Left`.
        -   `add(item)`:
            -   Add to `Right` (candidate for rank k).
            -   Check if `Left` has any smaller?
            -   Actually standard logic: `Right.add(item)`. `Left.add(Right.poll())`. `Right.add(Left.poll())`?
            -   Wait. We maintain `Left` size `k-1` (the locked best ones).
            -   Add: `Left.add(item)`. `Right.add(Left.poll())`. (Ensure invariant).
            -   Invariant: `Left` has `k-1` best. `Right` has rest. `Left` elements are all BETTER than `Right` elements.
            -   So `Left` is Min-Heap of Goodness (lowest goodness among top).
            -   `Right` is Max-Heap of Goodness (best goodness among rest).
            -   Wait. Min-Heap of Goodness means `Left.peek()` is the worst of the top set.
            -   If `Right.peek()` is better than `Left.peek()` -> Violation.
            -   Correct flow:
                -   Add to `Left`. Then move `Left.poll()` (worst of Top) to `Right`? No.
                -   If valid, `Left` holds Best `k-1`. `Right` holds Worst `N-(k-1)`.
                -   We want `Right.peek()` to be the BEST of the Worst set (Rank k).
                -   So `Right` is Max-Heap of Goodness. (`Right.peek` is best).
                -   `Left` is Min-Heap of Goodness. (`Left.peek` is worst of Best).
                -   Invariant: `Left.peek()` is better than `Right.peek()`.
                -   Adding `x`:
                    -   If `x` better than `Left.peek()`: `Left.add(x)`, `Right.add(Left.poll())`.
                    -   Else: `Right.add(x)`.
                -   `get()`: `return Right.peek()`. `k++`. Move `Right.poll()` to `Left`.
    -   Edge case: `Left` empty. (`k=1`).
        -   Add `x`: `Right.add(x)`.
    -   Complexity: `O(log N)`.

## Implementation Details
-   `PriorityQueue`.
-   One MaxHeap, One MinHeap.
