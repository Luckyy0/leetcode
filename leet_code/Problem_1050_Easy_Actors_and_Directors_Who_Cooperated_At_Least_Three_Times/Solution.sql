-- 1050. Actors and Directors Who Cooperated At Least Three Times
-- Write a solution to find all the pairs (actor_id, director_id) where the actor has cooperated with the director at least three times.

-- Phân tích tối ưu: 
-- Gộp chung các dòng ghi chú lại THEO TỪNG CẶP NHẤT ĐỊNH (actor_id, director_id)
-- Đếm bằng bộ lọc HAVING, số lượng hợp tác (số dòng của cặp đó) phải >= 3.
-- Trả về 2 cột theo đúng yêu cầu.

SELECT 
    actor_id, 
    director_id
FROM 
    ActorDirector
GROUP BY 
    actor_id, 
    director_id
HAVING 
    COUNT(*) >= 3;
