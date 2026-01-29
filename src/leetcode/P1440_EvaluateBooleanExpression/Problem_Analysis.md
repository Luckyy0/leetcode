# 1440. Evaluate Boolean Expression / Đánh giá Biểu thức Boolean

## Problem Description / Mô tả bài toán
Tables `Variables` (name, value), `Expressions` (left_operand, operator, right_operand).
Evaluate each expression.
Result: `left`, `operator`, `right`, `value` ('true'/'false').

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Joining and Case
Join `Expressions` with `Variables` twice (left op and right op).
Use `CASE` to evaluate `x < y`, `x > y`, `x = y`.

---
