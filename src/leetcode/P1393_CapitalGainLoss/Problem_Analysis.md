# 1393. Capital Gain/Loss / Lãi/Lỗ Vốn

## Problem Description / Mô tả bài toán
Table `Stocks` (stock_name, operation ('Buy'/'Sell'), operation_day, price).
Each 'Sell' has a corresponding 'Buy'.
Report Total Gain/Loss for each stock.
Result `stock_name`, `capital_gain_loss`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Aggregation with Case
Gain/Loss = Total Sell Price - Total Buy Price.
Sum `price` if `Sell`.
Subtract `price` if `Buy`.
Group by `stock_name`.

---
