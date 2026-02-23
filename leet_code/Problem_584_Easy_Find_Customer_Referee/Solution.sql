/*
Problem: 584. Find Customer Referee
Difficulty: Easy
Description: Find names of customers NOT referred by ID 2.
Approach: Use OR ... IS NULL to explicitly include rows where referee_id is missing.
*/

SELECT 
    name
FROM 
    Customer
WHERE 
    -- We must handle both the inequality and the NULL case
    referee_id != 2 
    OR referee_id IS NULL;
