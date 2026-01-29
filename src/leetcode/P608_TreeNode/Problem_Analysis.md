# 608. Tree Node / Nút Cây

## Problem Description / Mô tả bài toán
Each node in the tree can be one of three types:
Mỗi nút trong cây có thể là một trong ba loại:
- "Leaf": if the node is a leaf node. / "Lá": nếu nút là nút lá.
- "Root": if the node is the root of the tree. / "Gốc": nếu nút là gốc của cây.
- "Inner": If the node is neither a leaf node nor a root node. / "Trong": Nếu nút không phải là nút lá cũng không phải là nút gốc.

Write an SQL query to report the type of each node in the tree.
Viết một truy vấn SQL để báo cáo loại của mỗi nút trong cây.

Table: `Tree`
```
+----+------+
| id | p_id |
+----+------+
| 1  | null |
| 2  | 1    |
| 3  | 1    |
| 4  | 2    |
| 5  | 2    |
+----+------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Case When / Case When
Logic:
1. `p_id IS NULL` -> Root.
2. `id IN (SELECT p_id FROM Tree)` -> Inner (if not Root).
3. Else -> Leaf.

Query:
```sql
SELECT id,
    CASE 
        WHEN p_id IS NULL THEN 'Root'
        WHEN id IN (SELECT p_id FROM Tree) THEN 'Inner' -- Note: p_id list includes NULLs, but id is not NULL usually. `IN` with NULLs works fine if checking for existence usually, but `NOT IN` fails with NULLs. Here we verify if `id` is present as a parent.
        ELSE 'Leaf'
    END AS type
FROM Tree
```
Warning: `IN (SELECT p_id ...)` works if we want to check existence. `p_id` column contains NULLs. `val IN (..., NULL)` returns TRUE if found, NULL is ignored unless valid.
Better safe: `SELECT p_id FROM Tree WHERE p_id IS NOT NULL`.

### Complexity / Độ phức tạp
- **Time**: O(N^2) or O(N) depending on DB optimization for `IN`.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Conditional Classification

**Algorithm**:
1.  Check root condition (parent is null).
2.  Check inner condition (is a parent to someone else).
3.  Default to leaf.

---
