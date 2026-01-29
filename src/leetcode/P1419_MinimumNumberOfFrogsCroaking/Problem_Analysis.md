# 1419. Minimum Number of Frogs Croaking / Số lượng Ếch Croaking Tối thiểu

## Problem Description / Mô tả bài toán
String `croakOfFrogs`. Contains only 'c', 'r', 'o', 'a', 'k'.
Each frog prints "croak".
Find min frogs to print the string simultaneously (overlapping).
Return -1 if invalid.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### State Machines / Counters
Five states/counters: `c`, `r`, `o`, `a`, `k`.
When 'c' comes: A frog starts. Increment `c`.
When 'r' comes: Previous must be `c`. Decrement `c`, increment `r`.
...
When 'k' comes: Decrement `a`, increment `k` (frog finishes).
Actually, to find min frogs:
Active frogs = `sum(c + r + o + a)`? (Wait, distinct frogs).
Actually just track how many are currently in process.
When 'c', increment `active`. Update global `maxFrogs`.
When 'k', decrement `active`.
For validity:
`count['c'] >= count['r'] >= count['o'] >= count['a'] >= count['k']` at ALL TIMES.
Actually, when 'r' comes, `c` count must be > `r` count?
Better: `c` count represents frogs currently at stage 'c' (waiting for 'r').
When 'r' comes, decrement `c`, increment `r`.
When 'k' comes, decrement `a`. We don't increment `k` stage counter since they finish. Or increment `k` just for total check?
Just decrement `a`. The frog becomes free.
We can reuse free frogs? The problem says "find minimum frogs". Yes, reusing implies same frog.
Wait, "simultaneously".
If a frog finishes 'k', it can start a new 'c'.
So `active` count logic works.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Stage Counters
Maintain counters for `c, r, o, a`.
Iterate string.
- 'c': increment `c`. `activeFrogs++`. `max = max(max, activeFrogs)`.
- 'r': check `c > 0`. `c--`, `r++`.
- 'o': check `r > 0`. `r--`, `o++`.
- 'a': check `o > 0`. `o--`, `a++`.
- 'k': check `a > 0`. `a--`. `activeFrogs--`.
Check at end: `activeFrogs` should be 0 (all finished). If not, invalid (-1).
Need to ensure counters never negative.
Also final validation: all counts 0.
Wait. My activeFrogs logic: 'c' increases active. 'k' decreases active. Max value is answer. Correct.
But check transitions specifically.
Duy trì bộ đếm cho `c, r, o, a`.
Lặp lại chuỗi.
- 'c': tăng `c`. `activeFrogs++`. `max = max(max, activeFrogs)`.
- 'r': kiểm tra `c > 0`. `c--`, `r++`.
...
- 'k': kiểm tra `a > 0`. `a--`. `activeFrogs--`.
Kiểm tra ở cuối: `activeFrogs` phải bằng 0.

---
