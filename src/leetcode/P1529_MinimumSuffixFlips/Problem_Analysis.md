# 1529. Minimum Suffix Flips / Lật Hậu tố Tối thiểu

## Problem Description / Mô tả bài toán
Target string `target` (0s and 1s). Start with `000...`.
Operation: Pick index `i`, flip `i...n-1`.
Min operations to match `target`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy State Transition
Simulate current state of bulb. Initially `0`.
Iterate target.
If `target[i]` != `currentState`, we MUST flip at `i` to match `target[i]`.
Flip operation affects all subsequent bits. `currentState` flips.
Count flips.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: One Pass
`state = '0'`. `flips = 0`.
Loop chars in target.
If `c != state`: `flips++`, `state = c`.
Return `flips`.
`state = '0'`. `flips = 0`.
Lặp lại các ký tự trong mục tiêu.
Nếu `c != state`: `flips++`, `state = c`.

---
