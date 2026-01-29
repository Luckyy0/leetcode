# 1117. Building H2O / Xây dựng H2O

## Problem Description / Mô tả bài toán
Two types of threads: Hydrogen and Oxygen.
Group 2 H and 1 O to release water.
Barrier synchronization.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Semaphores / Barrier / Semaphores / Rào cản
`sH` (init 2) -> actually we want `sH` available for threads to acquire?
No, we need to limit H threads.
Using `Semaphore h = new Semaphore(2)` and `Semaphore o = new Semaphore(1)` limits throughput but doesn't guarantee grouping.
Need a barrier to ensure 2H match 1O.
Better:
- `sH` (init 2 permits). H thread acquires.
- `sO` (init 0 permits). O thread acquires.
This logic is tricky if using semaphores for *release*.
Correct approach:
- `hPhore` (init 2): allows 2 H threads to enter waiting area.
- `oPhore` (init 1): allows 1 O thread to enter waiting area.
- Grouping logic: Use a `Phaser` or `CyclicBarrier` of size 3.
- Or simpler Semaphores:
  - H thread: `acquire(hPhore)`. `release(barrier)`. Wait for O to confirm? 
  - Actually, H just outputs H. We want output string grouping? No, just valid sequence. "HHO", "HOH", "OHH" etc.
  - Just ensure for every 2 H, there is 1 O.

Solution:
`Sem H(2)`, `Sem O(0)`. (Simple attempt)
H takes H. O checks if 2 H ready?
Try `Semaphore h = new Semaphore(2); Semaphore o = new Semaphore(0);`
When O arrives, it needs to wait for 2 H?
If we use `o.acquire(2)`, but H must signal O.
Logic: H acquires `h` (init 2). When 2 H arrived, they signal O?
Actually, O can gate the H.
O thread: `acquire(o)`, print O, `release(h, 2)`.
But we don't know if H threads exist.
Correct structure:
`sH` (init 2). `sO` (init 0).
Wait, if `O` releases `H`, then `O` must start first? No.
Maybe `sH` init 2 (capacity for H). `sO` init 1 (capacity for O).
We need a `CyclicBarrier(3)`.
Or:
- `h` acquires permit. print H. `barrier.await()`.
- `o` acquires permit. print O. `barrier.await()`.
Barrier action resets permits.

### Complexity / Độ phức tạp
- **Time**: Minimal.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Cyclic Barrier Phase
To bond 2 Hydrogen atoms with 1 Oxygen atom, use semaphores to limit admission (2 permits for H, 1 for O). Once threads pass admission, they enter a `CyclicBarrier(3)`. This barrier forces threads to wait until the full molecule group (H-H-O) is assembled before releasing them to process the next group.
Để liên kết 2 nguyên tử Hydro với 1 nguyên tử Oxy, sử dụng semaphores để giới hạn đầu vào (2 giấy phép cho H, 1 cho O). Khi các luồng vượt qua đầu vào, chúng đi vào `CyclicBarrier(3)`. Rào cản này buộc các luồng phải đợi cho đến khi nhóm phân tử đầy đủ (H-H-O) được lắp ráp trước khi giải phóng chúng để xử lý nhóm tiếp theo.

---
