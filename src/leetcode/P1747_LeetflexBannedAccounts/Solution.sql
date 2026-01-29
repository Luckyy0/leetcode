-- SQL Solution for P1747
SELECT DISTINCT l1.account_id
FROM LogInfo l1
JOIN LogInfo l2 ON l1.account_id = l2.account_id
WHERE l1.ip_address != l2.ip_address
  AND l1.login_time <= l2.logout_time
  AND l2.login_time <= l1.logout_time;
