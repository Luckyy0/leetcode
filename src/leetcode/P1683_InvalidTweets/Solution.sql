-- SQL Solution for P1683
SELECT tweet_id 
FROM Tweets 
WHERE CHAR_LENGTH(content) > 15;
