# Result for Tree Node
# *Kết quả cho bài toán Nút Cây*

## Description
## *Mô tả*

**SQL Schema**

Table: `Tree`
```
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| p_id        | int  |
+-------------+------+
id is the primary key column for this table.
Each row of this table contains information about the id of a node and the id of its parent node.
```

Each node in the tree can be one of three types:
*Mỗi nút trong cây có thể thuộc một trong ba loại:*

1.  **"Root"**: if the node is the root of the tree.
    * **"Root"**: nếu nút đó là gốc của cây.*
2.  **"Leaf"**: if the node is a leaf node.
    * **"Leaf"**: nếu nút đó là nút lá.*
3.  **"Inner"**: if the node is neither a root nor a leaf node.
    * **"Inner"**: nếu nút đó không phải là gốc cũng không phải là lá.*

Write an SQL query to report the ID and the type of each node in the tree.
*Viết một truy vấn SQL để báo cáo ID và loại của từng nút trong cây.*

Return the result table in **any order**.
*Trả về bảng kết quả theo **bất kỳ thứ tự nào**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** 
Tree table:
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
**Output:** 
```
+----+-------+
| id | type  |
+----+-------+
| 1  | Root  |
| 2  | Inner |
| 3  | Leaf  |
| 4  | Leaf  |
| 5  | Leaf  |
+----+-------+
```

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.
