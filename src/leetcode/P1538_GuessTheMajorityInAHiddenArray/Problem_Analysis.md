# 1538. Guess the Majority in a Hidden Array / Đoán Phần tử Đa số trong Mảng Ẩn

## Problem Description / Mô tả bài toán
Hidden binary array `nums`. Length `n` (even/odd?). Problem says even? "n is even" NO. Wait.
Query `query(a, b, c, d)` returns count of 1s in those 4 indices? No.
Returns: 4 if all equal, 2 if 2 equal 2 diff, 0 if 20-21 split.
Wait. API `query(a, b, c, d)` returns different values depending on problem statement detail.
Correct API: `query(a, b, c, d)` returns the number of set bits (1s) at those indices?
Actually, `query` returns 0, 2, or 4.
0: Two 0s, Two 1s.
2: Three 0s/One 1 OR Three 1s/One 0.
4: Four 0s OR Four 1s.
Goal: Find index of a majority element. (count > n/2). Or -1 if tie.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Determining Relative Values
Query `(0, 1, 2, 3)` gives `q0 = q(0,1,2,3)`.
Query `(0, 1, 2, 4)` gives `q1 = q(0,1,2,4)`.
Compare `q0` and `q1`.
If `q1 == q0`, then `nums[3]` and `nums[4]` have SAME parity (both 0 or both 1 relative to others).
If `abs(q1 - q0) == 2` or something?
Wait. The query returns number of 1s? No.
"Return number of elements with value 1" - Yes.
If `q(0,1,2,3) = x` and `q(0,1,2,4) = y`.
`y - x` = `nums[4] - nums[3]`.
If `y - x == 0`, `nums[4] == nums[3]`.
If `y - x == 1`, `nums[4] = 1, nums[3] = 0`.
If `y - x == -1`, `nums[4] = 0, nums[3] = 1`.
Assume `nums[0], nums[1], nums[2], nums[3]` known relative to `nums[3]`.
We can find relative values of ALL elements to `nums[3]`?
We need to know at least relations.
We can relate all indices `i` to `0` or `3`.
Algorithm:
1. `base = query(0, 1, 2, 3)`.
2. `q4 = query(0, 1, 2, 4)`. If `q4 == base`, `nums[4] == nums[3]`. Else `nums[4] != nums[3]`.
   Generally `query(0, 1, 2, i)` relates `nums[i]` to `nums[3]`.
   Wait. The indices must be distinct.
   We can classify all `i` (from 4 to n-1) relative to `nums[3]`.
   `nums[3]` is in group A. `nums[i]` in group A or B.
   What about `0, 1, 2`?
   `q(0, 1, 2, 4)` vs `q(0, 1, 3, 4)` relates `2` to `3`?
   `q(0, 1, 3, 4)` uses `3`. `q(0, 1, 2, 4)` uses `2`.
   Diff relates `nums[2]` vs `nums[3]`.
   Similarly `q(0, 2, 3, 4)` relates `1` vs `?`.
   `q(1, 2, 3, 4)` relates `0` vs `?`.
   So we can classify ALL elements into two groups: "Same as `nums[3]`" and "Different from `nums[3]`".
   Group 1 size `c1`. Group 2 size `c2`.
   If `c1 > c2`, return any index in Group 1.
   If `c2 > c1`, return any index in Group 2.
   If `c1 == c2`, return -1.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Classification
Use `0, 1, 2, 3` as base.
Let `q0123 = query(0, 1, 2, 3)`.
Classify `i` for `i` in `4..n-1`:
  `q = query(0, 1, 2, i)`.
  If `q == q0123`, `nums[i] == nums[3]`. Add to Group A.
  Else, `nums[i] != nums[3]`. Add to Group B.
Classify `0, 1, 2`:
  Use auxiliary query `q0124 = query(0, 1, 2, 4)`. (Already done above).
  Compare with `q0134 = query(0, 1, 3, 4)`. Diff relates `nums[2]` vs `nums[3]`.
  Wait. `q0124` uses `2`. `q0134` uses `3`.
  If `q0124 == q0134`, then `nums[2] == nums[3]`.
  Similarly for `1` and `0`.
Groups initialized with one element (index 3).
Sử dụng `0, 1, 2, 3` làm cơ sở.
Phân loại tất cả các phần tử thành hai nhóm: "Giống như `nums[3]`" và "Khác với `nums[3]`".
Nếu `c1 > c2`, trả về bất kỳ chỉ số nào trong Nhóm 1.
Nếu `c2 > c1`, trả về bất kỳ chỉ số nào trong Nhóm 2.

---
