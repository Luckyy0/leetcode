# 1364. Number of Trusted Contacts of a Customer / Số lượng Liên hệ Đáng tin cậy của Khách hàng

## Problem Description / Mô tả bài toán
Tables `Customers` (customer_id, customer_name, email), `Contacts` (user_id, contact_name, contact_email), `Invoices` (invoice_id, price, user_id).
For each invoice, list:
- invoice_id, customer_name, price
- contacts_cnt (total contacts)
- trusted_contacts_cnt (contacts whose email exists in Customers table)
Order by invoice_id.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Joins and Aggregation
1. Join `Invoices` with `Customers`.
2. Left Join `Contacts` on `user_id`.
3. Left Join `Customers` (as Trusted) on `contact_email = Trusted.email`.
4. Group by invoice_id.
5. `COUNT(contact_name)` vs `COUNT(Trusted.email)`.

---
