# 1517. Find Users With Valid E-Mails / Tìm Người dùng có E-mail Hợp lệ

## Problem Description / Mô tả bài toán
Table `Users` (user_id, name, mail).
Valid email:
- Prefix name + '@leetcode.com'.
- Prefix name: start with letter. Can contain letter, digit, underscore, dot, dash.
Regex check.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Regex
MySQL `REGEXP '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\\.com$'`.
Note escaping dot.

---
