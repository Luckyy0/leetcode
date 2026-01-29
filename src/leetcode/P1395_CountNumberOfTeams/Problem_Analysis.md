# 1395. Count Number of Teams / Đếm Số lượng Đội

## Problem Description / Mô tả bài toán
Array `rating`. Choose 3 indices `i < j < k`.
Condition: `rating[i] < rating[j] < rating[k]` OR `rating[i] > rating[j] > rating[k]`.
Count teams.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Iteration (Middle Element)
Fix `j` (the middle element).
Count `leftSmaller`, `leftLarger`.
Count `rightSmaller`, `rightLarger`.
Teams using `j` = `leftSmaller * rightLarger` + `leftLarger * rightSmaller`.
Iterate `j` from 1 to `n-2`.
Total sum.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(1).
Note: Can be O(N log N) using BIT/Fenwick Tree, but N <= 1000 so N^2 is fine.

---

## Analysis / Phân tích

### Approach: Iterate Middle
For each element at index `j`, count how many elements to the left are smaller (`ls`) and larger (`ll`), and how many to the right are smaller (`rs`) and larger (`rl`). The number of valid teams with `rating[j]` as the middle element is `ls * rl + ll * rs`. Sum this over all `j`.
Đối với mỗi phần tử tại chỉ số `j`, đếm xem có bao nhiêu phần tử bên trái nhỏ hơn (`ls`) và lớn hơn (`ll`), và bao nhiêu phần tử bên phải nhỏ hơn (`rs`) và lớn hơn (`rl`). Số lượng các đội hợp lệ với `rating[j]` là phần tử ở giữa là `ls * rl + ll * rs`. Cộng tổng số này trên tất cả các `j`.

---
