# 1518. Water Bottles / Chai Nước

## Problem Description / Mô tả bài toán
`numBottles` full. `numExchange` empty bottles exchange for 1 full.
Drink, exchange, drink... Total drunk.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation
While `empty >= numExchange`:
  `newFull = empty / numExchange`.
  `remEmpty = empty % numExchange`.
  `total += newFull`.
  `empty = newFull + remEmpty`.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Loop
Drink current full. Add to empty.
Exchange as much as possible.
Loop.
Uống hết hiện tại. Thêm vào rỗng.
Trao đổi càng nhiều càng tốt.

---
