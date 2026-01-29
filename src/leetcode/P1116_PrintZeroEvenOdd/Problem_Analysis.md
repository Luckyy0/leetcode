# 1116. Print Zero Even Odd / In Số Không Chẵn Lẻ

## Problem Description / Mô tả bài toán
Specifically design a class to execute code in order.
Example: n=2. Output: "0102".
The code should output "0", then next number, then "0", then next number...
Odd and Even threads for numbers. Zero thread for 0.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Concurrency / Semaphores / Đồng thời / Semaphores
Three threads: `zero`, `odd`, `even`.
`sZero` (init 1), `sOdd` (init 0), `sEven` (init 0).
Loop `i` from 1 to `n`:
- `zero`: `sZero.acquire()`, print 0, if `i` odd `sOdd.release()` else `sEven.release()`.
- `odd`: `sOdd.acquire()`, print `i`, `sZero.release()`.
- `even`: `sEven.acquire()`, print `i`, `sZero.release()`.
Note: `zero` loop logic must drive which of `odd` or `even` goes next.

### Complexity / Độ phức tạp
- **Time**: Minimal.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Cyclic Semaphore Coordination
Synchronize three threads (Zero, Even, Odd). The `Zero` thread acts as the controller, printing '0' and then signalling either `Odd` or `Even` based on the current iteration counter. The `Odd` and `Even` threads print their respective numbers and signal `Zero` to continue the cycle.
Đồng bộ hóa ba luồng (Zero, Even, Odd). Luồng `Zero` hoạt động như bộ điều khiển, in '0' rồi báo hiệu `Odd` hoặc `Even` dựa trên bộ đếm vòng lặp hiện tại. Các luồng `Odd` và `Even` in số tương ứng của chúng và báo hiệu `Zero` tiếp tục chu kỳ.

---
