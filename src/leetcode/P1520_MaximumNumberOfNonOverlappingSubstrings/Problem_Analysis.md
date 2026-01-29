# 1520. Maximum Number of Non-Overlapping Substrings / Số lượng Tối đa các Chuỗi con Không chồng chéo

## Problem Description / Mô tả bài toán
String `s`. Find max number of non-overlapping substrings satisfying:
"A substring containing a character `c` must also contain ALL occurrences of `c` in `s`."
(i.e., minimal valid substrings).
Minimize total length if counts equal.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Interval Identification + Greedy Selection
1. Find valid intervals.
   - For each char `c` present in `s`, find first and last occurrence: `start[c]`, `end[c]`.
   - The minimal valid substring containing `c` starts at `start[c]`? No.
   - It starts at `start[c]` and ends at `end[c]`.
   - But if it contains another char `d` between start and end, we must expand to include all `d`.
   - Expand `[L, R]` until it satisfies condition for all chars inside.
   - If expansion valid, we have a candidate interval `[newL, newR]`.
   - If expansion creates `[newL, newR]` identical to another char's expanded interval, deduplicate.
2. Select max non-overlapping intervals.
   - Standard Interval Scheduling. Sort by end time. Pick greedily.
   - If equal end time, pick shorter? No, interval scheduling just sort by end time works for max count. Wait.
   - "Maximize number... if multiple solutions, choose one with min total length".
   - Standard greedy by end time maximizes count.
   - Does it minimize total length? Usually yes if we check start times?
   - Wait. If interval A is inside interval B, we should pick A. (A is shorter, and picking B prevents picking A is wrong logic? But picking B consumes A's space anyway).
   - Actually, if A inside B, B is overlapping A. Can we pick both? No. Pick A or B?
   - If we pick B, we use 1. If we pick A, we use 1. A leaves more space. So pick A.
   - So we only care about "minimal" valid substrings?
   - The expansion process might produce nested intervals. E.g., `aba`. 'a' needs whole string. 'b' only needs middle. 'b' interval is inside 'a' interval.
   - If we pick 'a' interval, we get 1. If we pick 'b', we get 1.
   - We prefer 'b' (shorter).
   - So filter out intervals that contain other intervals?
   - Or just sort by end time, and if end times equal, sort by length (shortest first)? Or just pick non-overlapping.
   - Actually standard greedy by end time: if current interval doesn't overlap previous, pick it.
   - Correct logic: If we have `[1, 5]` and `[2, 3]`. Sorted by end: `[2, 3]`, `[1, 5]`.
   - Pick `[2, 3]`. Next `[1, 5]` overlaps `[2, 3]`. Skip.
   - We get `[2, 3]`, count 1.
   - If we sorted differently?
   - Seems standard greedy works if we exclude intervals containing smaller valid ones? No, standard greedy handles it naturally if sorted by end time. `[2, 3]` comes before `[1, 5]`.

### Complexity / Độ phức tạp
- **Time**: O(N * 26).
- **Space**: O(26).

---

## Analysis / Phân tích

### Approach: Expand and Greedy
Calculate first/last for all 26 chars.
For each char `c`:
  Expand strictly valid interval starting from `start[c]`.
  Check all chars in range. Update bounds.
  If valid, store interval.
Sort intervals by Right asc, then (Right-Left) asc.
Greedy selection.
Tính toán đầu/cuối cho tất cả 26 ký tự.
Đối với mỗi ký tự `c`:
  Mở rộng khoảng hợp lệ nghiêm ngặt bắt đầu từ `start[c]`.
  Kiểm tra tất cả các ký tự trong phạm vi.
Sắp xếp các khoảng theo Right tăng dần, sau đó (Right-Left) tăng dần.
Lựa chọn tham lam.

---
