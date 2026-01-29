/* Write your T-SQL query statement below */
SELECT TOP 1 person_name
FROM (
    SELECT person_name, turn, SUM(weight) OVER (ORDER BY turn) as cum_weight
    FROM Queue
) t
WHERE cum_weight <= 1000
ORDER BY turn DESC;
