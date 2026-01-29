# 1381. Design a Stack With Increment Operation / Thiết kế Ngăn xếp với Thao tác Tăng

## Problem Description / Mô tả bài toán
Stack with finite size.
- `push(x)`: pushes x if not full.
- `pop()`: pops top. -1 if empty.
- `increment(k, val)`: increments bottom `k` elements by `val`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Lazy Propagation / Array
Use an array to store stack elements.
Use an auxiliary array `inc` of same size to store "lazy" increment values.
`inc[i]` means "add this value to index `i` and everything below it".
When `pop()`:
- `res = stack[top] + inc[top]`.
- Propagate `inc[top]` to `inc[top-1]` (if `top > 0`).
- Clear `inc[top] = 0`.
- Return `res`.
When `increment(k, val)`:
- `k` limited by current stack size `cnt`.
- `index = min(k, cnt) - 1`.
- `inc[index] += val`.

### Complexity / Độ phức tạp
- **Time**: All ops O(1).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Lazy Increment Array
Maintain the stack using a simple array (or list) and a pointer `top`.
Also maintain an array `inc` to store pending increments.
`increment(k, val)` updates `inc[min(k-1, top)] += val`. This means the element at that index *and all below* should be incremented.
`pop()` retrieves `stack[top] + inc[top]`. Before decrementing `top`, it adds `inc[top]` to `inc[top-1]` (propagating the increment down), then resets `inc[top]`.
Duy trì ngăn xếp bằng một mảng đơn giản (hoặc danh sách) và một con trỏ `top`.
Cũng duy trì một mảng `inc` để lưu trữ các mức tăng đang chờ xử lý.
`increment(k, val)` cập nhật `inc[min(k-1, top)] += val`. Điều này có nghĩa là phần tử tại chỉ mục đó *và tất cả bên dưới* sẽ được tăng lên.
`pop()` lấy `stack[top] + inc[top]`. Trước khi giảm `top`, nó thêm `inc[top]` vào `inc[top-1]` (lan truyền mức tăng xuống), sau đó đặt lại `inc[top]`.

---
