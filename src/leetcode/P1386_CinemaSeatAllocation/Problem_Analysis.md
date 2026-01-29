# 1386. Cinema Seat Allocation / Phân bổ Ghế Rạp chiếu phim

## Problem Description / Mô tả bài toán
Cinema `n` rows, 10 seats per row (1-10).
Aisle between 3-4 and 7-8.
Family of 4 needs 4 consecutive seats.
Valid ranges: `[2,5]`, `[4,7]`, `[6,9]`.
Reserved seats array `reservedSeats`.
Return max number of families.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bitmask / Hashing
Rows are independent.
For row with no reserved seats: 2 families (`[2,5]` and `[6,9]`).
For row with reserved seats:
Check availability of Left `[2,5]`, Middle `[4,7]`, Right `[6,9]`.
- If Left and Right both free: 2 families (Middle overlaps both, can't add 3rd).
- If Middle free (and Left/Right not): 1 family.
- If only Left free: 1 family.
- If only Right free: 1 family.
Logic:
If (2-5) free, add 1. Else if (4-7) free ... wait.
If (2-5) and (6-9) free -> 2 families. (Overlap middle doesn't matter, we prioritize 2).
If (2-5) blocked but (6-9) free -> 1 family.
If (2-5) free but (6-9) blocked -> 1 family.
If both (2-5) and (6-9) blocked, check (4-7). If free -> 1 family.
If all blocked -> 0.
Rows with NO reservations: `n - distinct_reserved_rows`. Each contributes 2.

### Complexity / Độ phức tạp
- **Time**: O(M log M) or O(M) where M is number of reserved seats.
- **Space**: O(M).

---

## Analysis / Phân tích

### Approach: Hash Map Processing
Use a Map to store reserved seats for each row (bitmask or set). Bitmask is efficient (10 bits).
Valid blocks:
- Left: 2,3,4,5 (Mask: 0111100000 -> shifted to logic)
- Middle: 4,5,6,7
- Right: 6,7,8,9
Actually simple boolean flags.
Iterate reserved seats, update row status.
Total = `(n - map.size()) * 2`.
For each processed row:
- Check availability. Add 0, 1, or 2.
Sử dụng Bản đồ để lưu trữ các ghế đã đặt cho mỗi hàng (bitmask hoặc tập hợp). Bitmask hiệu quả (10 bit).
Các khối hợp lệ:
- Trái: 2,3,4,5
- Giữa: 4,5,6,7
- Phải: 6,7,8,9
Thực ra cờ boolean đơn giản.
Lặp lại các ghế đã đặt, cập nhật trạng thái hàng.
Tổng = `(n - map.size()) * 2`.
Đối với mỗi hàng được xử lý:
- Kiểm tra tính khả dụng. Cộng 0, 1 hoặc 2.
Logic:
Cờ `isL` (2-5 bị chặn?), `isM` (4-7 bị chặn?), `isR` (6-9 bị chặn?).
Lặp qua đặt chỗ. Nếu col trong 2-5 -> `isL = true`. Trong 4-7 -> `isM = true`. Trong 6-9 -> `isR = true`.
Lưu ý: 2-3 chỉ ảnh hưởng L. 8-9 chỉ ảnh hưởng R. 4-5 ảnh hưởng L và M. 6-7 ảnh hưởng M và R.
Cụ thể:
Ghế 2,3: Chặn L.
Ghế 4,5: Chặn L và M.
Ghế 6,7: Chặn M và R.
Ghế 8,9: Chặn R.
Sau khi kiểm tra hàng:
Ban đầu `cnt = 0`.
Nếu !L và !R -> `cnt = 2`.
Nếu chỉ một trong L, R, M còn trống (và không đạt được 2) -> `cnt = 1`.
Cụ thể:
Nếu !L và !R: `cnt=2`.
Else if !L (R bị chặn): `cnt=1`.
Else if !R (L bị chặn): `cnt=1`.
Else if !M (L và R bị chặn): `cnt=1`.
Else `cnt=0`.

---
