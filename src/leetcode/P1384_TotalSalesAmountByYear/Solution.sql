/* Write your T-SQL query statement below */
WITH Years AS (
    SELECT '2018' AS report_year, '2018-01-01' AS year_start, '2018-12-31' AS year_end
    UNION ALL SELECT '2019', '2019-01-01', '2019-12-31'
    UNION ALL SELECT '2020', '2020-01-01', '2020-12-31'
    -- Add more if needed based on constraints, problem description usually implies range
)
SELECT 
    s.product_id,
    p.product_name,
    y.report_year,
    (DATEDIFF(day, 
        CASE WHEN s.period_start > y.year_start THEN s.period_start ELSE y.year_start END,
        CASE WHEN s.period_end < y.year_end THEN s.period_end ELSE y.year_end END
    ) + 1) * s.average_daily_sales AS total_amount
FROM Sales s
CROSS JOIN Years y
JOIN Product p ON s.product_id = p.product_id
WHERE s.period_start <= y.year_end AND s.period_end >= y.year_start
ORDER BY s.product_id, y.report_year;
