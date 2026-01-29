# 1468. Calculate Salaries / Tính Lương

## Problem Description / Mô tả bài toán
Table `Salaries` (company_id, employee_id, employee_name, salary).
Calculate taxes.
- Max salary in company < 1000: 0% tax.
- 1000 <= Max salary <= 10000: 24% tax.
- Max salary > 10000: 49% tax.
Return salary after tax (rounded).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Window Functions
`MAX(salary) OVER (PARTITION BY company_id)` to get max salary per company.
Use `CASE` for tax rate.
Calculation: `salary - (salary * rate)`. Round result.

---
