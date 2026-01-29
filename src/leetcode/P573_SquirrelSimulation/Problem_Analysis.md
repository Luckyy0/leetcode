# 573. Squirrel Simulation / Mô Phỏng Sóc

## Problem Description / Mô tả bài toán
There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 2D grid. Your goal is to find the **minimal distance** for the squirrel to collect all the nuts and put them under the tree one by one. The squirrel can only take at most one nut at one time and can move in four directions - up, down, left and right, to the adjacent cell. The distance is represented by the number of moves.
Có một cái cây, một con sóc và vài hạt dẻ. Vị trí được biểu diễn bằng các ô trong lưới 2D. Mục tiêu của bạn là tìm **khoảng cách tối thiểu** để con sóc thu thập tất cả các hạt dẻ và đặt chúng dưới gốc cây từng cái một. Con sóc chỉ có thể lấy tối đa một hạt dẻ mỗi lần và có thể di chuyển theo bốn hướng - lên, xuống, trái và phải, đến ô liền kề. Khoảng cách được biểu diễn bằng số bước di chuyển.

### Example 1:
```text
Input: height = 5, width = 7, tree = [2,2], squirrel = [4,4], nuts = [[3,0], [2,5]]
Output: 12
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Manhattan Distance / Khoảng Cách Manhattan
Regular trip for a nut `i`: `Tree -> Nut_i -> Tree`. Distance = `2 * dist(Tree, Nut_i)`.
Total limit distance if squirrel started at Tree: `Sum(2 * dist(Tree, Nut_i))`.

But squirrel starts at `Squirrel`.
It must pick the **first** nut, say `Nut_k`.
Path for first nut: `Squirrel -> Nut_k -> Tree`.
Savings compared to standard trip:
`Standard_k = dist(Tree, Nut_k) + dist(Nut_k, Tree) = 2 * dist(Tree, Nut_k)`.
`Actual_k = dist(Squirrel, Nut_k) + dist(Nut_k, Tree)`.
`Saving = Standard_k - Actual_k = dist(Tree, Nut_k) - dist(Squirrel, Nut_k)`.

We want to maximize the saving (since we subtract savings from total standard distance).
Maximize `dist(Tree, Nut_k) - dist(Squirrel, Nut_k)`.

Algorithm:
1. Calculate `TotalStandard = Sum(2 * dist(Tree, nut))` for all nuts.
2. Iterate through all nuts to find `maxSaving`.
   - `saving = dist(Tree, nut) - dist(Squirrel, nut)`.
   - `maxSaving = max(maxSaving, saving)`.
3. Result = `TotalStandard - maxSaving`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is number of nuts.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Greedy Saving Calculation

**Algorithm**:
1.  Compute standard round-trip distance for all nuts from tree.
2.  Iterate each nut to calculate the "saving" if it is picked first.
3.  Saving = (Tree-Nut distance) - (Squirrel-Nut distance).
4.  Standard Total - Max Saving = Minimal Distance.

---
