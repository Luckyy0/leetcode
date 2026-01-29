/* Write your T-SQL query statement below */
WITH SecondSale AS (
    SELECT seller_id, item_id
    FROM (
        SELECT seller_id, item_id, 
               ROW_NUMBER() OVER (PARTITION BY seller_id ORDER BY order_date ASC) as rn
        FROM Orders
    ) t
    WHERE rn = 2
)
SELECT 
    u.user_id AS seller_id, 
    CASE 
        WHEN i.item_brand = u.favorite_brand THEN 'yes'
        ELSE 'no' 
    END AS 2nd_item_fav_brand
FROM Users u
LEFT JOIN SecondSale ss ON u.user_id = ss.seller_id
LEFT JOIN Items i ON ss.item_id = i.item_id;
