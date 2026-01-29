# 1040. Moving Stones Until Consecutive II / Di chuyển Đá cho đến khi Liên tiếp II

## Problem Description / Mô tả bài toán
There are `n` stones on a number line.
Game rules similar to P1033, but valid for `n` stones.
Pick endpoint, move to empty position between other stones (cannot move endpoint to adjacent to new endpoint if it destroys range? No, just "not an endpoint").

Find min and max moves.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window / Cửa sổ Trượt
Sort stones.
Min Moves:
- Find a window of size `n`.
- Count how many stones are already in this window.
- Moves needed = `n - count`.
- Edge case: e.g., `1, 2, 3, 4, 10`. Window size 5. `1,2,3,4` are consecutive. Only `10` is outlier. But we can't move `10` to `5` immediately because we can't move endpoint to endpoint. We might need 2 moves (move 1 to 6, then 10 to 5? No).
  - Special logic: If `n-1` stones are consecutive and gap is > 1 for the last stone, takes 2 moves.
  - Else `n - max_stones_in_window`.

Max Moves:
- We lose at least the gap at one end in the first move.
- `gap1 = stones[1] - stones[0] - 1`.
- `gap_last = stones[n-1] - stones[n-2] - 1`.
- `total_gaps = stones[n-1] - stones[0] + 1 - n`.
- `max_moves = total_gaps - min(gap1, gap_last)`.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Boundary Compression vs Window Fit
For max moves, we utilize the wasted space in the gaps. We essentially fill every gap one by one, losing only the gap at the very end we choose to abandon first. For min moves, we look for the best "fit" - a cluster of stones that can accommodate the others with minimal displacement, using a sliding window.
Đối với số lần di chuyển tối đa, chúng ta tận dụng không gian lãng phí trong các khoảng trống. Về cơ bản, chũng ta lấp đầy từng khoảng trống một, chỉ mất khoảng trống ở ngay cuối mà chúng ta chọn bỏ đi trước. Đối với số lần di chuyển tối thiểu, chúng ta tìm kiếm "sự vừa vặn" tốt nhất - một cụm đá có thể chứa những viên đá khác với sự dịch chuyển tối thiểu, sử dụng cửa sổ trượt.

---
