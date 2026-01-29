/* Write your T-SQL query statement below */
SELECT q.id, q.year, ISNULL(n.npv, 0) AS npv
FROM Queries q
LEFT JOIN NPV n ON q.id = n.id AND q.year = n.year
ORDER BY q.id, q.year;
