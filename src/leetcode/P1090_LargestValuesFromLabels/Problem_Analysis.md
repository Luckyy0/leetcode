# 1090. Largest Values From Labels / Giá trị Lớn nhất Từ Nhãn

## Problem Description / Mô tả bài toán
We have a set of items: the `i-th` item has value `values[i]` and label `labels[i]`.
Choosing a subset of these items such that:
1. Size of subset is at most `num_wanted`.
2. For any label `L`, the number of items with label `L` in subset is at most `use_limit`.

Return the maximum sum of values of the subset.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy / Sorting / Tham lam / Sắp xếp
We want larger values. So sort items by value descending.
Iterate through sorted items. Pick item if:
- Total picked < `num_wanted`.
- Count of item's label < `use_limit`.
Keep track of counts using a Map.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Greedy Selection with Constraints
Pair values and labels, then sort them by value in descending order. Iterate through the sorted items to greedily select the highest values. Maintain a count of used labels. Include an item only if the total selected items are fewer than `num_wanted` and the usage count for that specific label hasn't reached `use_limit`. This ensures value maximization under constraints.
Ghép nối giá trị và nhãn, sau đó sắp xếp chúng theo giá trị theo thứ tự giảm dần. Lặp qua các mục đã sắp xếp để chọn các giá trị cao nhất một cách tham lam. Duy trì số lượng nhãn đã sử dụng. Chỉ bao gồm một mục nếu tổng số mục đã chọn ít hơn `num_wanted` và số lượng sử dụng cho nhãn cụ thể đó chưa đạt đến `use_limit`. Điều này đảm bảo tối đa hóa giá trị theo các ràng buộc.

---
