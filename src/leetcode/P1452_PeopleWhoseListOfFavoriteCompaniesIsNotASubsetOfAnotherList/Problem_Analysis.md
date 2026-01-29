# 1452. People Whose List of Favorite Companies Is Not a Subset of Another List / Những Người Có Danh sách Công ty Yêu thích Không phải là Tập con của Danh sách Khác

## Problem Description / Mô tả bài toán
List of list of string `favoriteCompanies`.
Return indices of people whose list is NOT a subset of ANY other list.
Sorted indices.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Set Subset Check
Convert each list to a HashSet for O(1) checking? Or just keep sorted lists and use includes.
Subset check: `setA` is subset of `setB` if `setB.containsAll(setA)`.
Naive O(N^2 * M) check. N <= 100. M small. Feasible.
Optimization: Sort sets by size? Only check if smaller is subset of larger.

### Complexity / Độ phức tạp
- **Time**: O(N^2 * M).
- **Space**: O(N * M).

---

## Analysis / Phân tích

### Approach: Brute Force with Sets
Convert each person's company list to a `Set`.
Iterate each person `i`. Check if there exists `j != i` such that `sets[j].containsAll(sets[i])`.
If no such `j`, add `i` to result.
Return sorted indices.
Chuyển đổi danh sách công ty của mỗi người thành một `Set`.
Lặp lại từng người `i`. Kiểm tra xem có tồn tại `j != i` sao cho `sets[j].containsAll(sets[i])`.
Nếu không có `j` như vậy, thêm `i` vào kết quả.

---
