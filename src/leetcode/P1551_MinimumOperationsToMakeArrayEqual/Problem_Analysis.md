# Problem Analysis: Minimum Operations to Make Array Equal

## Problem Description
You have an array `arr` of length `n` where `arr[i] = (2 * i) + 1` for all valid values of `i` (i.e., `0 <= i < n`).

In one operation, you can select two indices `x` and `y` where `0 <= x, y < n` and subtract 1 from `arr[x]` and add 1 to `arr[y]` (i.e., perform `arr[x] -= 1` and `arr[y] += 1`). The goal is to make all the elements of the array **equal**. It is guaranteed that all the elements of the array can be made equal using some operations.

Given an integer `n`, the length of the array, return *the minimum number of operations* needed to make all the elements of `arr` equal.

## Mathematical Analysis

1.  **Target Value**:
    The operation `arr[x] -= 1` and `arr[y] += 1` preserves the total sum of the array elements. Therefore, the final equal value for every element must be the average of the initial elements.
    Array elements: $1, 3, 5, \dots, 2n-1$.
    Sum of an arithmetic progression: $S_n = \frac{n}{2}(a_1 + a_n) = \frac{n}{2}(1 + 2n - 1) = \frac{n}{2}(2n) = n^2$.
    The target value for each element is $\frac{Sum}{n} = \frac{n^2}{n} = n$.

2.  **Operations Calculation**:
    We want to transform values $1, 3, \dots, 2n-1$ into $n, n, \dots, n$.
    Since we pair a decrement with an increment, the number of operations is equal to the sum of differences for the elements that are less than $n$ (or equivalently, greater than $n$).
    
    The elements less than $n$ are $1, 3, \dots$ up to the middle of the array.
    
    *   **Case 1: n is odd** ($n = 2k + 1$)
        The middle element is exactly $n$ and needs 0 operations.
        Elements: $1, 3, \dots, n-2, n, n+2, \dots, 2n-1$.
        We sum the differences $(n - (2i+1))$ for $i = 0$ to $k-1$.
        $Sum = \sum_{i=0}^{k-1} (n - (2i+1))$
        Example $n=3$ ($1, 3, 5$): Target 3. Ops for 1 is $3-1=2$. Total = 2.
        Formula: $\frac{n^2 - 1}{4}$.
    
    *   **Case 2: n is even** ($n = 2k$)
        Elements: $1, 3, \dots, n-1, n+1, \dots, 2n-1$.
        Target is $n$.
        We sum $(n - (2i+1))$ for $i = 0$ to $k-1$.
        Example $n=2$ ($1, 3$): Target 2. Ops for 1 is $2-1=1$. Total = 1.
        Formula: $\frac{n^2}{4}$.

    *   **Unified Formula**:
        Using integer division, both cases can be computed as `n * n / 4`.
        - If $n=3$, $9/4 = 2$. Correct.
        - If $n=2$, $4/4 = 1$. Correct.

## Complexity
-   **Time Complexity**: $O(1)$ - Direct mathematical formula.
-   **Space Complexity**: $O(1)$ - No extra space used.

## Implementation Details
-   Return `n * n / 4`.
