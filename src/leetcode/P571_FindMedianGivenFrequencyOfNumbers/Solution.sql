/*
# 571. Find Median Given Frequency of Numbers

Table: Numbers
+-------------+------+
| Column Name | Type |
+-------------+------+
| num         | int  |
| frequency   | int  |
+-------------+------+
num is the primary key for this table.
Each row of this table shows the frequency of a number in the database.

Write an SQL query to find the median of all numbers and report it as the result.
*/

/*
WITH T1 AS (
    SELECT 
        num, 
        frequency,
        SUM(frequency) OVER (ORDER BY num) AS cum_sum,
        (SUM(frequency) OVER ()) / 2.0 AS mid
    FROM 
        Numbers
)
SELECT 
    AVG(num) AS median
FROM 
    T1
WHERE 
    mid BETWEEN cum_sum - frequency AND cum_sum;
*/
