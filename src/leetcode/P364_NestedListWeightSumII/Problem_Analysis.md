# 364. Nested List Weight Sum II / Tổng Trọng Số Danh Sách Lồng Nhau II

## Problem Description / Mô tả bài toán
You are given a nested list of integers `nestedList`. Each element is either an integer or a list whose elements may also be integers or other lists.
Bạn được cung cấp danh sách lồng nhau `nestedList`.

The **depth** of an integer is the number of lists that it is inside of. For example, the nested list `[1,[2,2],[[3],2],1]` has each integer's value set to its depth.
Độ sâu...

Return the sum of each integer in `nestedList` multiplied by its **inverse depth**.
Trả về tổng của mỗi số nguyên nhân với **độ sâu ngược** của nó.

The **max depth** of the list is the maximum level of nesting.
The **inverse depth** of an integer is `maxDepth - (the depth of the integer) + 1`.

### Example 1:
```text
Input: nestedList = [[1,1],2,[1,1]]
Output: 8
Explanation: Four 1's at depth 2, one 2 at depth 1. Max depth is 2.
Inverse depth for 1's: 2 - 2 + 1 = 1.
Inverse depth for 2: 2 - 1 + 1 = 2.
Sum: 1*1 + 1*1 + 2*2 + 1*1 + 1*1 = 1+1+4+1+1 = 8.
```

## Constraints / Ràng buộc
- `1 <= nestedList.length <= 50`
- The values of the integers in the nested list is in the range `[-100, 100]`.
- The maximum depth of any integer is less than or equal to `50`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### BFS Level Order / Duyệt Theo Chiều Rộng Từng Mức
Instead of calculating max depth first (2 passes), we can accumulate sums intelligently.
Observation:
Let `S` be the sum of integers at current level or deeper.
Each time we go deeper, everything previously encountered in `S` gains +1 weight effectively.
Actually, formula:
Level 1 inverse depth: MAX - 1 + 1 = MAX.
Level 2 inverse depth: MAX - 2 + 1 = MAX - 1.
Algorithm:
1.  BFS levels.
2.  `levelSum`: Sum of integers at current level.
3.  `totalSum += levelSum + prevUncompletedSum`.
    - Wait.
    - Standard trick:
    - Keep `unweightedSum`: sum of all integers seen so far.
    - `weightedSum += unweightedSum` at each level step.
    - Start with `nestedList`. Collect all ints into `unweightedSum`. Collect all lists into `nextLevel`.
    - Repeat until no lists.
    - Example: [[1,1], 2, [1,1]]
      - Level 1: int 2. List [1,1], [1,1].
        - `unweighted = 2`.
        - `weighted += 2`.
      - Level 2: ints 1,1,1,1.
        - `unweighted = 2 + 1+1+1+1 = 6`.
        - `weighted += 6 = 2 + 6 = 8`.
        - Correct?
        - Weight of 2: Added at L1, L2. Total 2.
        - Weight of 1s: Added at L2. Total 1.
        - Inverse depths: 2 has weight 2, 1 has weight 1. Matches Example.
      - Logic: An integer at depth `d` is added to `unweighted` at step `d`, and remains in `unweighted` for steps `d+1...max`.
      - It contributes to `weighted` sum `(max - d + 1)` times?
      - Let Max depth be M. Steps: 1, 2, ..., M.
      - Int at depth 1: Added at step 1. Contributing in step 1, 2, ..., M. Count M terms. Corresponds to weight M.
      - Int at depth M: Added at step M. Contributing in step M. Count 1 term. Corresponds to weight 1.
      - Matches "Inverse Depth".

### Complexity / Độ phức tạp
- **Time**: O(N). Each integer processed once.
- **Space**: O(N) (BFS queue/list).

---

## Analysis / Phân tích

### Approach: Weighted Sum Accumulation (BFS)

**Algorithm**:
1.  `weighted = 0`, `unweighted = 0`.
2.  `currentList = nestedList`.
3.  While `!currentList.isEmpty()`:
    - `nextList = []`.
    - Loop `ni` in `currentList`:
        - If integer: `unweighted += val`.
        - If list: `nextList.addAll(ni.getList())`.
    - `weighted += unweighted`.
    - `currentList = nextList`.

---
