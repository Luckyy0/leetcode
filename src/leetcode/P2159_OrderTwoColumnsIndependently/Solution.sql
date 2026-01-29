-- SQL Solution for P2159
WITH First AS (
    SELECT first_col, ROW_NUMBER() OVER (ORDER BY first_col ASC) as rn
    FROM Data
),
Second AS (
    SELECT second_col, ROW_NUMBER() OVER (ORDER BY second_col DESC) as rn
    FROM Data
)
SELECT f.first_col, s.second_col
FROM First f
JOIN Second s ON f.rn = s.rn
ORDER BY f.rn;
