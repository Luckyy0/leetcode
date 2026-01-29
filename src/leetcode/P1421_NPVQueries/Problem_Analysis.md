# 1421. NPV Queries / Truy vấn NPV

## Problem Description / Mô tả bài toán
Tables `NPV` (id, year, npv) and `Queries` (id, year).
Return `npv` for each query.
If not found, return 0.
Order by `id`, `year`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Left Join with IFNULL / Coalesce
`Queries` Left Join `NPV`.
If `npv` is null, replace with 0.

---
