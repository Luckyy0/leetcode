# 1441. Build an Array With Stack Operations / Xây dựng Mảng với Hoạt động Stack

## Problem Description / Mô tả bài toán
Target array `target`. Numbers `1` to `n`.
Operations: `"Push"`, `"Pop"`.
Build `target`. Return ops.
Input stream: `1, 2, 3...`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation
Stream provides `1, 2, 3...` up to `n`.
Iterate stream numbers `curr`.
If `curr` is in `target`: `"Push"`.
If `curr` is not in `target` (and `< max(target)`): `"Push"`, `"Pop"`.
Stop when last element of `target` is reached.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Stream Comparison
Keep a pointer `idx` to the `target` array.
Iterate `i` from 1 to `n`.
If `idx == target.length`, breakdown (reached end).
Always push `i` (`"Push"`).
If `i == target[idx]`, we keep it. `idx++`.
If `i != target[idx]`, we pop it. (`"Pop"`).
Return result.
Giữ một con trỏ `idx` tới mảng `target`.
Lặp lại `i` từ 1 đến `n`.
Nếu `idx == target.length`, ngắt (đã đến cuối).
Luôn đẩy `i` (`"Push"`).
Nếu `i == target[idx]`, chúng ta giữ nó. `idx++`.
Nếu `i != target[idx]`, chúng ta bật nó ra. (`"Pop"`).
Trả về kết quả.

---
