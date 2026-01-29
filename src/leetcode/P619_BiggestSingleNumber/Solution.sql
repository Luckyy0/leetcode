/*
# 619. Biggest Single Number

Table: MyNumbers
+-------------+------+
| Column Name | Type |
+-------------+------+
| num         | int  |
+-------------+------+
There is no primary key for this table. It may contain duplicates.
Each row of this table contains an integer.

Write an SQL query to report the largest single number. If there is no single number, report null.
*/

/*
SELECT 
    MAX(num) AS num
FROM (
    SELECT 
        num
    FROM 
        MyNumbers
    GROUP BY 
        num
    HAVING 
        COUNT(num) = 1
) t;
*/
