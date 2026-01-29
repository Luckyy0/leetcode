# 845. Longest Mountain in Array / Ngọn núi Dài nhất trong Mảng

## Problem Description / Mô tả bài toán
An array is a mountain if:
1. length $\ge 3$.
2. There exists some `i` with `0 < i < n - 1` such that:
   - `arr[0] < arr[1] < ... < arr[i]`
   - `arr[i] > arr[i+1] > ... > arr[n-1]`

Return the length of the longest mountain.
Trả về độ dài của ngọn núi dài nhất.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### One-pass greedy traversal / Quét tham lam một lượt
Identify potential peaks and expand outwards.
Xác định các đỉnh tiềm năng và mở rộng ra bên ngoài.

Algorithm:
1. Iterate `i` from 1 to `n-2`.
2. Check if `i` is a peak: `arr[i-1] < arr[i] > arr[i+1]`.
3. If it's a peak, expand `left` and `right` as far as the sequence is monotonic.
4. Calculate length `right - left + 1`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Local Peak Expansion
Treat every point as a potential summit. If the summit conditions are met, measure the full span of the slopes. The maximum such span is the solution.
Coi mọi điểm là một đỉnh tiềm năng. Nếu các điều kiện về đỉnh được thỏa mãn, hãy đo toàn bộ chiều rộng của các sườn dốc. Chiều rộng lớn nhất như vậy chính là lời giải.

---
