/*
Problem: 627. Swap Salary
Difficulty: Easy
Description: Swap 'm' and 'f' values in a single update statement.
Approach: Use the CASE statement within the UPDATE SET clause to perform the swap atomically.
*/

UPDATE Salary
SET 
    sex = CASE 
        WHEN sex = 'm' THEN 'f' 
        ELSE 'm' 
    END;

/*
-- Alternative for MySQL:
-- Using IF() function is also possible and slightly more concise.
-- Giải pháp thay thế cho MySQL: Sử dụng hàm IF() cũng khả thi và ngắn gọn hơn một chút.

-- UPDATE Salary SET sex = IF(sex = 'm', 'f', 'm');
*/
