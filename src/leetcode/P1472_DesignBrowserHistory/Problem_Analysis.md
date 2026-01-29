# 1472. Design Browser History / Thiết kế Lịch sử Trình duyệt

## Problem Description / Mô tả bài toán
Class `BrowserHistory`.
- `visit(url)`: clear forward history.
- `back(steps)`: move back.
- `forward(steps)`: move forward.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Doubly Linked List or Array/Stack
Methods:
1. Two Stacks (`back`, `forward`).
2. List + Index pointer.
`visit`: Add to List at `idx+1`, remove subsequent. Update `idx`.
`back`: `idx = max(0, idx - steps)`.
`forward`: `idx = min(len-1, idx + steps)`.
Array/ArrayList is better for `get` and specific index jumps. Removing tail is O(1) in ArrayList usually (or just maintain `size` variable distinct from capacity).
Maintain `current` index and `max` index to define the valid range.
`visit(url)` overwrites `index+1`, sets `max = index+1`, `current++`.

### Complexity / Độ phức tạp
- **Time**: O(1) for all ops.
- **Space**: O(N*L) for URLs.

---

## Analysis / Phân tích

### Approach: Dynamic Array with Pointer
Use an ArrayList to store history. Use an integer `curr` to track current position.
`visit`:
If `curr` is not at end, we logically truncate. In ArrayList, we can do `list.subList(curr+1, list.size()).clear()` or maintain a separate `bound`. Using `bound` is cleaner (logical size).
`list[curr+1] = url`. `curr++`. `bound = curr`.
If Array is used, dynamic resizing needed. Java ArrayList is fine.
Wait, `visit`: "clears up all the forward history".
If we use `bound`, we overwrite `index+1` and set `bound = curr`.
Wait, pre-allocated array (size 5000 max calls) or ArrayList.
Using ArrayList: `list.subList(curr+1, list.size()).clear()` is O(K) where K is removed elements. This amortized O(1)? No, worst case removing many.
But total clears <= total visits. Amortized O(1).
Or just overwrite up to `bound`.
Sử dụng ArrayList và con trỏ `curr`.
`visit`: ghi đè tại `curr+1`. Cập nhật `bound`.
`back/forward`: cập nhật `curr` trong giới hạn.

---
