-- SQL Solution for P1809
SELECT session_id
FROM Playback p
WHERE session_id NOT IN (
    SELECT p.session_id
    FROM Playback p
    JOIN Ads a ON p.customer_id = a.customer_id
    WHERE a.timestamp BETWEEN p.start_time AND p.end_time
);
