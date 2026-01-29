# 1471. The k Strongest Values in an Array / K Giá trị Mạnh nhất trong Mảng

## Problem Description / Mô tả bài toán
Array `arr`. Median `m`.
Stronger definition: `|x - m| > |y - m|` or equal diff but `x > y`.
Return `k` strongest.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting / Two Pointers
Calculate median (sort, `(n-1)/2`).
Sort elements by strength:
Comparator: `(abs(a-m) != abs(b-m)) ? abs(b-m) - abs(a-m) : b - a`.
Return first `k`.
Alternatively, use two pointers on sorted array.
`[min, ..., median, ..., max]`.
Compare `arr[left]` and `arr[right]` relative to median.
If `right` is stronger, pick `right`. Else pick `left`.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(log N) stack or O(1).

---

## Analysis / Phân tích

### Approach: Two Pointers on Sorted Array
First, sort the array to find the median and to set up the two pointers structure.
Median `m = arr[(n-1)/2]`.
Left pointer `l = 0`, Right pointer `r = n-1`.
We need `k` elements.
Compare `|arr[l] - m|` and `|arr[r] - m|`.
Note: if diffs are equal, we check values. Since `arr[r] >= arr[l]`, `arr[r]` is stronger if diffs equal.
So if `|arr[l] - m| > |arr[r] - m|` we pick `arr[l]`. Else pick `arr[r]`.
Collect `k` items.
Sắp xếp mảng để tìm trung vị.
Cấu trúc 2 con trỏ `l=0`, `r=n-1`.
Trong mỗi bước, so sánh độ mạnh của `arr[l]` và `arr[r]`. Chọn cái mạnh hơn.

---
