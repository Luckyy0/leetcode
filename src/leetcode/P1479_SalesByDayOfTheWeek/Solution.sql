/* Write your T-SQL query statement below */
SELECT 
    i.item_category AS Category,
    SUM(CASE WHEN DATENAME(weekday, o.order_date) = 'Monday' THEN o.quantity ELSE 0 END) AS Monday,
    SUM(CASE WHEN DATENAME(weekday, o.order_date) = 'Tuesday' THEN o.quantity ELSE 0 END) AS Tuesday,
    SUM(CASE WHEN DATENAME(weekday, o.order_date) = 'Wednesday' THEN o.quantity ELSE 0 END) AS Wednesday,
    SUM(CASE WHEN DATENAME(weekday, o.order_date) = 'Thursday' THEN o.quantity ELSE 0 END) AS Thursday,
    SUM(CASE WHEN DATENAME(weekday, o.order_date) = 'Friday' THEN o.quantity ELSE 0 END) AS Friday,
    SUM(CASE WHEN DATENAME(weekday, o.order_date) = 'Saturday' THEN o.quantity ELSE 0 END) AS Saturday,
    SUM(CASE WHEN DATENAME(weekday, o.order_date) = 'Sunday' THEN o.quantity ELSE 0 END) AS Sunday
FROM Items i
LEFT JOIN Orders o ON i.item_id = o.item_id
GROUP BY i.item_category
ORDER BY i.item_category;
