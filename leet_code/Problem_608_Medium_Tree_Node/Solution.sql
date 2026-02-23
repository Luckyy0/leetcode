/*
Problem: 608. Tree Node
Difficulty: Medium
Description: Classify each node as Root, Inner, or Leaf.
Approach: 
1. If p_id is null, it's Root.
2. If id exists in the p_id column (has children), it's Inner.
3. Otherwise, it's Leaf.
*/

SELECT 
    id,
    CASE
        WHEN p_id IS NULL THEN 'Root'
        WHEN id IN (SELECT p_id FROM Tree) THEN 'Inner'
        ELSE 'Leaf'
    END AS type
FROM 
    Tree;

/*
-- Note: A slightly more verbose but robust filter for the 'Inner' check 
-- would be 'WHERE p_id IS NOT NULL' in the subquery, but CASE handles
-- the priority correctly here (Root is already matched before IN is checked).
*/
