# 232. Implement Queue using Stacks / Cài Đặt Hàng Đợi Bằng Ngăn Xếp

## Problem Description / Mô tả bài toán
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (`push`, `peek`, `pop`, and `empty`).
Cài đặt một hàng đợi (queue) hoạt động theo nguyên tắc vào trước ra trước (FIFO) chỉ sử dụng hai ngăn xếp. Hàng đợi được cài đặt phải hỗ trợ tất cả các chức năng của một hàng đợi thông thường (`push`, `peek`, `pop`, và `empty`).

Implement the `MyQueue` class:
- `void push(int x)` Pushes element x to the back of the queue.
- `int pop()` Removes the element from the front of the queue and returns it.
- `int peek()` Returns the element at the front of the queue.
- `boolean empty()` Returns `true` if the queue is empty, `false` otherwise.

**Notes**:
- You must use **only** standard operations of a stack, which means only `push to top`, `peek/pop from top`, `size`, and `is empty` operations are valid.
- Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.

### Example 1:
```text
Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]
```

## Constraints / Ràng buộc
- `1 <= x <= 9`
- At most `100` calls will be made to `push`, `pop`, `peek`, and `empty`.
- All the calls to `pop` and `peek` are valid.

**Follow-up**: Can you implement the queue such that each operation is amortized `O(1)` time complexity? In other words, performing `n` operations will take overall `O(n)` time even if one of those operations may take longer.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Two Stacks Approach / Cách tiếp cận Hai Ngăn Xếp
We can use two stacks:
1.  **Input Stack (`s1`)**: Handles `push` operations.
2.  **Output Stack (`s2`)**: Handles `pop` and `peek` operations.

**Logic**:
- **Push(x)**: Always push to `s1`.
- **Pop()** / **Peek()**:
    - If `s2` is NOT empty: Simply pop or peek from `s2`.
    - If `s2` is EMPTY: Transfer **all** elements from `s1` to `s2`. This reverses their order. The element at the bottom of `s1` (first added) ends up at the top of `s2` (ready to be popped).
    - If `s2` is still empty after check (means both empty), queue is empty.

**Amortized Complexity**:
- Each element is pushed to `s1` once, popped from `s1` once, pushed to `s2` once, and popped from `s2` once.
- Total 4 operations per element.
- Pushing to `s1` is O(1).
- Popping from `s2` is mostly O(1), occasionally O(N) (transfer).
- Amortized time per operation is O(1).

---

## Analysis / Phân tích

### Approach: Two Stacks (Amortized O(1))

**Complexity / Độ phức tạp**:
- **Time**: Amortized O(1).
- **Space**: O(N) to store elements.

---

## Edge Cases / Các trường hợp biên
1.  **Empty Queue**: `empty()` returns true.
2.  **Interleaved Operations**: Push, Pop, Push, Peek. Transfer logic maintains correct order.
