# 1542. Find Longest Awesome Substring / Tìm Chuỗi con Tuyệt vời Dài nhất

## Problem Description / Mô tả bài toán
String `s` (digits).
"Awesome" if it can be made a palindrome (at most one odd frequency digit).
Longest awesome substring.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bitmask + Prefix Hash Map
State: Parity of counts of digits 0-9.
Bitmask length 10.
If substring `s[i...j]` is awesome: `mask[j] ^ mask[i-1]` has at most 1 bit set.
Targets: `0` (all even) or `1 << k` (one odd).
Store first occurrence of each mask in `map` (array of size 1024).
Initialize `map[0] = -1`.
Iterate:
  Update mask.
  Check `mask` in map: `len = i - map[mask]`.
  Check `mask ^ (1<<k)` in map: `len = i - map[mask ^ (1<<k)]`.
  Update max length.
  If mask not in map, store index.

### Complexity / Độ phức tạp
- **Time**: O(N * 10).
- **Space**: O(1024).

---

## Analysis / Phân tích

### Approach: Bitmask
Array `seen` size 1024 initialized to -2 (or infinity).
Set `seen[0] = -1`.
Iterate, update mask. Check all 11 possibilities (0 diff, 1 bit diff).
Update answer.
Mảng `seen` kích thước 1024.
Đặt `seen[0] = -1`.
Lặp lại, cập nhật mặt nạ. Kiểm tra tất cả 11 khả năng.

---
