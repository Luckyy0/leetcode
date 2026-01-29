# Problem Analysis: Delete the Middle Node of a Linked List

## Problem Description
Linked list. Delete middle node.
Middle: `floor(n / 2)`.
0-indexed: `n=1`: mid 0 (delete head? No, example 1 node -> empty? Yes).
`n=2`: mid 1.
`n=3`: mid 1.
`n=4`: mid 2.
Return head.

## Analysis

1.  **Fast and Slow Pointers**:
    -   Need to find `prev` of middle node.
    -   `fast` moves 2, `slow` moves 1.
    -   Start `slow` at head, `fast` at `head.next.next`?
    -   Or simply: count `n`. Target index `n / 2`. Traverse.
    -   With pointers:
        -   `slow` ptr, `prev` ptr.
    -   Actually, if `fast` starts at head and moves 2, `slow` at head moves 1.
    -   When `fast` end, `slow` is at `n/2`?
        -   n=1: fast(0). Loop doesn't run. Slow 0.
        -   n=2: fast(0). next!=null. fast(2)=null. Slow(1). Correct.
        -   n=3: fast(0). fast(2). loop runs once. Slow(1). Correct.
        -   n=4: fast(0)..2..4(null). loop twice. Slow(2). Correct.
    -   But we need predecessor to delete.
    -   Maintain `prev`.
    -   Handle n=1 case separately (return null).

## Implementation Details
-   Check n=1.
-   Pointers.
