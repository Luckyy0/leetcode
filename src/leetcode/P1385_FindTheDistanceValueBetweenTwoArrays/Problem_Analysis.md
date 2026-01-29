# 1385. Find the Distance Value Between Two Arrays / Tìm Giá trị Khoảng cách Giữa Hai Mảng

## Problem Description / Mô tả bài toán
Arrays `arr1`, `arr2`. Integer `d`.
"Distance value" is number of elements `arr1[i]` such that NO element `arr2[j]` satisfies `|arr1[i] - arr2[j]| <= d`.
Basically count `arr1[i]` where for all `j`, `|arr1[i] - arr2[j]| > d`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting + Binary Search
We need to check if ANY `arr2[j]` is within `[val - d, val + d]`.
Sort `arr2`.
For each `val` in `arr1`:
  Binary Search in `arr2` for range `[val - d, val + d]`.
  If found, valid condition fails (distance <= d exists).
  If not found, count it.

### Complexity / Độ phức tạp
- **Time**: O(N log N + M log N) where N=len(arr2), M=len(arr1).
- **Space**: O(1) or O(N).

---

## Analysis / Phân tích

### Approach: Binary Search
Sort `arr2`. Iterate through `arr1`. For each element `x`, use binary search (`Arrays.binarySearch` or `TreeSet`) to find an element in `arr2` that is closest to `x`. If the closest element is within distance `d`, then `x` does not contribute to the answer. If no such element exists (closest element distance > `d`), increment the count.
Sắp xếp `arr2`. Lặp qua `arr1`. Đối với mỗi phần tử `x`, sử dụng tìm kiếm nhị phân (`Arrays.binarySearch` hoặc `TreeSet`) để tìm một phần tử trong `arr2` gần nhất với `x`. Nếu phần tử gần nhất nằm trong khoảng cách `d`, thì `x` không đóng góp vào câu trả lời. Nếu không tồn tại phần tử như vậy (khoảng cách phần tử gần nhất > `d`), hãy tăng số đếm.

---
