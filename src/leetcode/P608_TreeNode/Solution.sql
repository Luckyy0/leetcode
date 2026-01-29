/*
# 608. Tree Node

Table: Tree
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| p_id        | int  |
+-------------+------+
id is the primary key column for this table.
Each row of this table contains information about the id of a node and the id of its parent node in a tree.
The given structure is always a valid tree.

Write an SQL query to report the type of each node in the tree.
*/

/*
SELECT 
    id,
    CASE 
        WHEN p_id IS NULL THEN 'Root'
        WHEN id IN (SELECT p_id FROM Tree WHERE p_id IS NOT NULL) THEN 'Inner' -- Filtering NULL is safer for IN clause
        ELSE 'Leaf'
    END AS type
FROM 
    Tree;
*/
