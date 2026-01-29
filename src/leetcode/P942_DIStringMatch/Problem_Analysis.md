# 942. DI String Match / Khớp Chuỗi DI

## Problem Description / Mô tả bài toán
Given a string `s` of length `n` containing 'I' (Increase) or 'D' (Decrease), return any permutation `res` of `[0, 1, ..., n]` such that for all `i`:
- If `s[i] == 'I'`, `res[i] < res[i+1]`
- If `s[i] == 'D'`, `res[i] > res[i+1]`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Range Selection / Lựa chọn Phạm vi Tham lam
Since we can use numbers from `0` to `n`:
- If we see 'I', we should pick the smallest available number to allow the next number to be larger.
- If we see 'D', we should pick the largest available number to allow the next number to be smaller.

Algorithm:
1. Initialize `low = 0`, `high = n`.
2. For each char `c` in `s`:
   - If `c == 'I'`, add `low++` to result.
   - If `c == 'D'`, add `high--` to result.
3. At the end, add the remaining `low` (or `high`, they are equal).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) for result array.

---

## Analysis / Phân tích

### Approach: Extreme Point Assignment
Strategically assign the absolute extremes of the currently available number set. By using the smallest value for an upward step and the largest for a downward step, we guarantee that the subsequent value in the sequence has the maximum possible room to satisfy the next constraint.
Gán một cách chiến lược các điểm cực trị tuyệt đối của tập hợp số hiện có. Bằng cách sử dụng giá trị nhỏ nhất cho một bước tăng và giá trị lớn nhất cho một bước giảm, chúng ta đảm bảo rằng giá trị tiếp theo trong chuỗi có không gian tối đa có thể để thỏa mãn ràng buộc tiếp theo.

---
