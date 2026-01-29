# 631. Design Excel Sum Formula / Thiết Kế Công Thức Tính Tổng Excel

## Problem Description / Mô tả bài toán
Design a basic Excel Sum Formula.
Thiết kế một Công thức Tính Tổng Excel cơ bản.
Implement the `Excel` class:
- `Excel(int height, char width)`: Constructs an object with specific height and width.
- `void set(int row, char column, int val)`: Changes the value at the cell `(row, column)` to be `val`.
- `int get(int row, char column)`: Returns the value at the cell `(row, column)`.
- `int sum(int row, char column, String[] numbers)`: Sets the value at cell `(row, column)` to be the sum of cells represented by `numbers` and returns the value. This sum formula should exist until this specific cell is overlapped by another value or another sum formula.

`numbers[i]` could be represented as:
- `"ColRow"`, e.g. `"A1"`.
- `"ColRow1:ColRow2"`, e.g. `"A1:C3"`.

### Example 1:
```text
Input:
["Excel", "set", "sum", "set", "get"]
[[3, "C"], [1, "A", 2], [3, "C", ["A1", "A1:B2"]], [2, "B", 2], [3, "C"]]
Output: [null, null, 4, null, 6]
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Graph Dependency / Topological Sort / Recursion / Dependency Graph / Sắp xếp Topo / Đệ quy
Cells can depend on other cells.
`set` breaks any existing formula at that cell.
`sum` establishes dependencies.
We can use a 2D array for values.
And a Map for formulas: `Map<Cell, Formula>`.
`Formula` contains list of cells or ranges it depends on.
When `get` is called, if it's a formula, evaluate it (recursively or using cached value if properly updated).
Since `set` can update values that other formula cells depend on, we need mechanism to update dependents.
Topological sort or recursive evaluation on access.
Given typical constraints (Height <= 26, Width <= 'Z'), N is small.
Recursive `get` with cycle detection (though problem implies DAG?) is feasible.
Or simpler: maintain values eagerly. When `set` is called, update all dependents.
Actually `sum` is called less often? No, `get` could be frequent.
If we re-calculate on `get`, we ensure freshness.
Or we store values and formula. `get` returns stored value. `set` updates value AND triggers updates for all referencing cells.
Dependency graph `Cell -> List<Cell>` (reverse dependency).

### Complexity / Độ phức tạp
- **Time**: Depends on dependency chain depth.
- **Space**: O(H * W).

---

## Analysis / Phân tích

### Approach: Recursive Evaluation

**Algorithm**:
1.  Store raw values in 2D array.
2.  Store Formulas in a Map (Key=Cell, Value=List of dependent cells/counts).
3.  On `set`: remove formula if exists, set value.
4.  On `sum`: store formula, calculate initial sum.
5.  Wait, if `A1` updates, `C3` (which is `SUM(A1:B2)`) must update.
    Easier: On `get`, if cell has formula, re-evaluate it recursively.
    Wait, `set` updates value. `get` retrieves.
    If I call `set(A1, 2)`, then `get(C3)`... if `C3` stores formula, `get(C3)` re-calculates.
    What about `sum` returning value immediately? It calculates once.
    Problem says "Sum formula should exist until...".
    So `get` should return CURRENT sum.
    
    Data Structure:
    `Formula[H][W]`: stores `HashMap<Cell, Multiplier>`.
    `Value[H][W]`: stores last calculated value.
    But this is complex if deep dependencies.
    
    Actually, simpler: Just store dependencies. `get` calls `calculate`.
    `calculate(r, c)`:
      If (r,c) has formula:
         sum = 0
         for dependent cell (dr, dc): sum += calculate(dr, dc)
         return sum
      Else: return Value[r][c]
    
    Since constraints are small (Height 26, Width 'Z'), recursion is fast enough.

---
