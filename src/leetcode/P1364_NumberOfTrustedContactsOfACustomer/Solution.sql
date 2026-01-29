/* Write your T-SQL query statement below */
SELECT 
    i.invoice_id,
    c.customer_name,
    i.price,
    COUNT(con.contact_name) AS contacts_cnt,
    SUM(CASE WHEN cust.email IS NOT NULL THEN 1 ELSE 0 END) AS trusted_contacts_cnt
FROM Invoices i
JOIN Customers c ON i.user_id = c.customer_id
LEFT JOIN Contacts con ON c.customer_id = con.user_id
LEFT JOIN Customers cust ON con.contact_email = cust.email
GROUP BY i.invoice_id, c.customer_name, i.price
ORDER BY i.invoice_id;
