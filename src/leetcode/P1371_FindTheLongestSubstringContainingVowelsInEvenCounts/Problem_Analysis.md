# 1371. Find the Longest Substring Containing Vowels in Even Counts / Tìm Chuỗi con Dài nhất Chứa Nguyên âm với Số lượng Chẵn

## Problem Description / Mô tả bài toán
String `s`. Longest substring where count of 'a', 'e', 'i', 'o', 'u' is even.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Bitmask with Hash Map
State: 5 bits for 5 vowels (a, e, i, o, u).
1 means odd count, 0 means even count.
Start state 00000 at index -1.
Iterate string. Use XOR to update state.
Map `state -> first_index`.
If state repeats, substring between `first_index` and `current_index` has XOR difference 0 (meaning counts changed by even amount). Length `current - first`.
Maximize length.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1) (32 states).

---

## Analysis / Phân tích

### Approach: Bitmask State Tracking
Assign a bit to each vowel (a:0, e:1, i:2, o:3, u:4). Maintain a running `state` (integer bitmask) representing the parity of vowel counts encountered so far.
Iterate through the string.
- If current char is a vowel, XOR the `state` with `1 << bit`.
- If `state` has been seen before (stored in a map: `state -> firstIndex`), the substring from `firstIndex + 1` to `current` has even counts for all vowels (since parity didn't change). Calculate length and update max.
- If `state` is new, store `current` index.
Initialize map with `0 -> -1`.
Gán một bit cho mỗi nguyên âm (a:0, e:1, i:2, o:3, u:4). Duy trì một `state` đang chạy (bitmask số nguyên) đại diện cho tính chẵn lẻ của số lượng nguyên âm gặp phải cho đến nay.
Lặp lại chuỗi.
- Nếu ký tự hiện tại là một nguyên âm, XOR `state` với `1 << bit`.
- Nếu `state` đã được nhìn thấy trước đó (được lưu trữ trong một bản đồ: `state -> firstIndex`), chuỗi con từ `firstIndex + 1` đến `current` có số lượng chẵn cho tất cả các nguyên âm (vì tính chẵn lẻ không thay đổi). Tính độ dài và cập nhật tối đa.
- Nếu `state` là mới, lưu trữ chỉ số `current`.
Khởi tạo bản đồ với `0 -> -1`.

---
