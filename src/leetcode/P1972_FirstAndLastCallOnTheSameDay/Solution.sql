-- SQL Solution for P1972
WITH AllCalls AS (
    SELECT caller_id AS user_id, recipient_id AS other_id, call_time FROM Calls
    UNION ALL
    SELECT recipient_id AS user_id, caller_id AS other_id, call_time FROM Calls
),
RankedCalls AS (
    SELECT 
        user_id,
        other_id,
        DATE(call_time) AS call_day,
        FIRST_VALUE(other_id) OVER (PARTITION BY user_id, DATE(call_time) ORDER BY call_time ASC) AS first_other,
        FIRST_VALUE(other_id) OVER (PARTITION BY user_id, DATE(call_time) ORDER BY call_time DESC) AS last_other
    FROM AllCalls
)
SELECT DISTINCT user_id
FROM RankedCalls
WHERE first_other = last_other;
