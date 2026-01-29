# 1505. Minimum Possible Integer After at Most K Adjacent Swaps On Digits / Số nguyên Nhỏ nhất Có thể Sau Tối đa K lần Đổi chỗ Liền kề trên Các Chữ số

## Problem Description / Mô tả bài toán
String `num`. Integer `k`.
Min integer possible by swapping adjacent at most `k` times.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy with Fenwick Tree (BIT)
We want smallest digit at leftmost possible position.
Positions 0 to N-1.
For current position `i` (in the final string), we can pick any digit from AVAILABLE original digits such that cost to move it to `i` is `<= k`.
Cost = `current_index - number_of_already_used_digits_before_it`.
Actually, cost = `original_index - count_removed_before_original_index`.
Or more simply: `original_pos + shift`.
Algorithm:
Iterate positions `i` from 0 to n-1.
Find smallest digit `d` (0-9) that occurs at `orig_idx` such that `cost(orig_idx) <= k`.
Cost calculation:
We need count of used elements before `orig_idx`. Use a BIT (Fenwick Tree) to mark used indices.
`shift = checkBIT(orig_idx - 1)`. Use `1` to mark index as removed.
True index = `orig_idx - shift`.? No.
Actually:
Original index `p`. Cost to bring to front = `p - count_removed_in(0..p-1)`.
Wait. If we construct result left to right.
Current cost to pick `num[p]` is `(p - queryBIT(p-1))`.
We greedily search digit 0..9.
For digit `d`, find list of indices. Pick first index `p`.
Check cost. If cost <= k, pick `d`. Update BIT, decrease `k` by cost, remove `p` from list. Start next position.
Optimization: Store indices of each digit in queues/lists.

### Complexity / Độ phức tạp
- **Time**: O(N * 10 * log N). N=30000. Fast enough.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Greedy + BIT
Store indices of each digit 0-9 in separate `Queue`s (sorted).
Iterate `i` from 0 to n-1 (constructing result).
Try digits `d` from 0 to 9.
Peek first occurrence `pos` from `dict[d]`.
Cost = `pos - BIT.query(pos - 1)`. (Number of jumps needed).
If `cost <= k`:
  We pick this digit.
  `k -= cost`.
  `BIT.update(pos, 1)`.
  Append `d` to result.
  Remove `pos` from `dict[d]`.
  Break (move to next output position, restart search from 0).
Since we always want smallest leftmost, once we pick, we restart digit search 0.
Lưu trữ chỉ số của mỗi chữ số 0-9 trong `Queue` riêng biệt.
Lặp lại `i` từ 0 đến n-1.
Thử các chữ số `d` từ 0 đến 9.
Peek lần xuất hiện đầu tiên `pos` từ `dict[d]`.
Chi phí = `pos - BIT.query(pos - 1)`. (Số lần nhảy cần thiết).
Nếu `chi phí <= k`:
  Chúng ta chọn chữ số này.
  `k -= chi phí`.

---
