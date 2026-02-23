/*
Problem: 601. Human Traffic of Stadium
Difficulty: Hard
Description: Find rows with 3+ consecutive IDs where people >= 100.
Approach: 
1. Filter rows where people >= 100.
2. Assign row numbers and calculate (id - row_number) as a group identifier.
3. Count entries in each group and filter groups with size >= 3.
*/

WITH Filtered AS (
    SELECT 
        id, 
        visit_date, 
        people,
        -- Row number within the filtered set
        ROW_NUMBER() OVER(ORDER BY id) as rn
    FROM 
        Stadium
    WHERE 
        people >= 100
),
Grouped AS (
    SELECT 
        id, 
        visit_date, 
        people,
        -- Consecutive IDs will have the same (id - rn)
        (id - rn) as group_id,
        -- Count how many rows are in this consecutive group
        COUNT(*) OVER(PARTITION BY (id - rn)) as group_count
    FROM 
        Filtered
)
SELECT 
    id, 
    visit_date, 
    people
FROM 
    Grouped
WHERE 
    group_count >= 3
ORDER BY 
    visit_date ASC;
