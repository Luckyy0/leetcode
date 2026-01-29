# 1481. Least Number of Unique Integers after K Removals / Số lượng Số Nguyên Duy nhất Ít nhất sau K lần Loại bỏ

## Problem Description / Mô tả bài toán
Array `arr`. Integer `k`. Remove `k` elements.
Minimize number of unique integers remaining.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy
Count frequencies. Store in map.
Sort frequencies ascending.
Remove items with smallest frequency first.
If `k >= freq`, remove all instances of that number (reduce unique count), `k -= freq`.
If `k < freq`, cannot remove all, stop.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Frequency Map + Priority Queue/Sorting
Count frequencies. Put counts into a list and sort.
Iterate sorted counts. Subtract count from `k`.
If `k >= 0`: removed one unique.
If `k < 0`: break.
Return remaining unique count.
Đếm tần suất. Đưa số đếm vào danh sách và sắp xếp.
Lặp lại số đếm đã sắp xếp. Trừ số đếm khỏi `k`.
Nếu `k >= 0`: đã xóa một số duy nhất.
Nếu `k < 0`: nghỉ.
Trả về số lượng duy nhất còn lại.

---
