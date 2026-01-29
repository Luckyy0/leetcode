# 641. Design Circular Deque / Thiết Kế Hàng Đợi Hai Đầu Vòng

## Problem Description / Mô tả bài toán
Design your implementation of the circular double-ended queue (deque).
Thiết kế triển khai hàng đợi hai đầu vòng (deque) của bạn.

Implement the `MyCircularDeque` class:
- `MyCircularDeque(int k)` Initializes the deque with a maximum size of `k`.
- boolean `insertFront()`: Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
- boolean `insertLast()`: Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
- boolean `deleteFront()`: Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.
- boolean `deleteLast()`: Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
- int `getFront()`: Returns the front item from the Deque. Returns -1 if the deque is empty.
- int `getRear()`: Returns the last item from Deque. Returns -1 if the deque is empty.
- boolean `isEmpty()`: Returns true if the deque is empty, or false otherwise.
- boolean `isFull()`: Returns true if the deque is full, or false otherwise.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Array Implementation / Triển Khai Mảng
Similar to Circular Queue (P622), but with `head` and `tail` pointers moving both ways.
Variables: `data`, `head`, `count`, `capacity`.
- `insertFront`: `head = (head - 1 + capacity) % capacity`. `data[head] = val`.
- `insertLast`: `tail = (head + count) % capacity`. `data[tail] = val`.
- `deleteFront`: `head = (head + 1) % capacity`.
- `deleteLast`: Just decrement count. Tail pointer is implicitly `head + count`.
Wait, using `head` and `count` is easiest.
- `Front`: `data[head]`.
- `Rear`: `data[(head + count - 1) % capacity]`.

### Complexity / Độ phức tạp
- **Time**: O(1) for all ops.
- **Space**: O(k).

---

## Analysis / Phân tích

### Approach: Array with Modulo

**Algorithm**:
1.  Use `head` index and `size`.
2.  Modulo arithmetic handles wrap around.
3.  Check capacity bounds.

---
