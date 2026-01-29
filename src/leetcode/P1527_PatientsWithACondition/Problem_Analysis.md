# 1527. Patients With a Condition / Bệnh nhân Có Tình trạng

## Problem Description / Mô tả bài toán
Table `Patients` (patient_id, patient_name, conditions).
Find patients with `DIAB1` condition.
Format: `DIAB1` prefix. Could be start of string or start of a word (space + DIAB1).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Like
`conditions LIKE 'DIAB1%' OR conditions LIKE '% DIAB1%'`.

---
