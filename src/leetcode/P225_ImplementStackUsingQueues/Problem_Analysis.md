# 225. Implement Stack using Queues / Cài Đặt Ngăn Xếp Bằng Hàng Đợi

## Problem Description / Mô tả bài toán
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (`push`, `top`, `pop`, and `empty`).
Cài đặt một ngăn xếp (stack) hoạt động theo nguyên tắc vào sau ra trước (LIFO) chỉ sử dụng hai hàng đợi. Ngăn xếp được cài đặt phải hỗ trợ tất cả các chức năng của một ngăn xếp thông thường (`push`, `top`, `pop`, và `empty`).

Implement the `MyStack` class:
- `void push(int x)` Pushes element x to the top of the stack.
- `int pop()` Removes the element on the top of the stack and returns it.
- `int top()` Returns the element on the top of the stack.
- `boolean empty()` Returns `true` if the stack is empty, `false` otherwise.

**Notes**:
- You must use **only** standard operations of a queue, which means that only `push to back`, `peek/pop from front`, `size` and `is empty` operations are valid.
- Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.

### Example 1:
```text
Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]
```

## Constraints / Ràng buộc
- `1 <= x <= 9`
- At most `100` calls will be made to `push`, `pop`, `top`, and `empty`.
- All the calls to `pop` and `top` are valid.

**Follow-up**: Can you implement the stack using only one queue?

---

## Theoretical Foundation / Cơ sở lý thuyết

### One Queue Rotation Approach / Cách tiếp cận Xoay Một Hàng Đợi
Using a single queue is cleaner.
To ensure the last added element is at the "front" of the queue (simulate stack top):
1.  **Push(x)**:
    - Add `x` to the queue.
    - Rotate the queue: Dequeue and Enqueue `size - 1` times. This moves the new element `x` to the front, and preserves the relative order of the others as if they were below `x` in a stack.
2.  **Pop()**: Simply dequeue the front (which is the stack top).
3.  **Top()**: Peek the front.

**Complexity**:
- `push`: O(N) where N is current size.
- `pop`: O(1).
- `top`: O(1).

### Two Queues Approach (Push O(1), Pop O(N))
- Push to `q1`.
- Pop: Move all except last from `q1` to `q2`. Return last. Swap references.

We will implement the **One Queue** approach as per the follow-up.

---

## Analysis / Phân tích

### Approach: One Queue

**Complexity / Độ phức tạp**:
- **Time**: Push O(N), Pop O(1).
- **Space**: O(N) to store elements.

---

## Edge Cases / Các trường hợp biên
1.  **Empty Stack**: Typically `pop` or `top` won't be called (constraints say valid calls). `empty` returns true.
2.  **One element**: Works fine.
