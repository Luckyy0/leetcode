# 1188. Design Bounded Blocking Queue / Thiết kế Hàng đợi Chặn có Giới hạn

## Problem Description / Mô tả bài toán
Implement a thread-safe bounded blocking queue.
1. `BoundedBlockingQueue(int capacity)`
2. `void enqueue(int element)`: If full, blocks.
3. `int dequeue()`: If empty, blocks.
4. `int size()`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Condition Variables / Semaphores / Biến Điều kiện / Semaphores
Queue data structure.
Two condition variables: `notFull` and `notEmpty`.
Mutex lock.

### Complexity / Độ phức tạp
- **Time**: O(1) ops.
- **Space**: O(Capacity).

---
