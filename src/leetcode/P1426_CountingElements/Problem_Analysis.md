# 1426. Counting Elements / Đếm Phần Tử

## Problem Description / Mô tả bài toán
Array `arr`. Count elements `x` such that `x + 1` exists in `arr`.
Duplicates handled individually.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Hash Set
Store all elements in a Set for O(1) existence check.
Iterate original array. If `set.contains(x + 1)`, increment count.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Hash Set Lookup
Add all elements to a HashSet. Iterate through the array again. For each element `x`, check if `x + 1` is in the set. If yes, increment the counter. Return total.
Thêm tất cả các phần tử vào HashSet. Lặp lại qua mảng một lần nữa. Đối với mỗi phần tử `x`, kiểm tra xem `x + 1` có trong tập hợp không. Nếu có, tăng bộ đếm. Trả về tổng số.

---
