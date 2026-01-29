-- SQL Solution for P2020
SELECT COUNT(DISTINCT account_id) AS accounts_count
FROM Subscriptions
WHERE (start_date <= '2021-12-31' AND end_date >= '2021-01-01')
  AND account_id NOT IN (
    SELECT DISTINCT account_id 
    FROM Streams 
    WHERE stream_date BETWEEN '2021-01-01' AND '2021-12-31'
  );
