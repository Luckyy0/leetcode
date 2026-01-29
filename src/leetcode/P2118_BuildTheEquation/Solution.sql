-- SQL Solution for P2118
WITH FormattedTerms AS (
    SELECT 
        power,
        CONCAT(
            IF(factor > 0, '+', ''), 
            factor, 
            IF(power = 0, '', CONCAT('X^', power))
        ) AS term
    FROM Terms
)
SELECT 
    CONCAT(GROUP_CONCAT(term ORDER BY power DESC SEPARATOR ''), '=0') AS equation
FROM FormattedTerms;
