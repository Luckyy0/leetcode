# 1460. Make Two Arrays Equal by Reversing Subarrays / Làm Hai Mảng Bằng Nhau bằng cách Đảo ngược Các Chuỗi con

## Problem Description / Mô tả bài toán
Arrays `target`, `arr`.
Can flip any subarray any number of times.
Check if they can be equal.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting properties
Reversing subarrays allows bubble sort / arbitrary permutation.
We can transform `arr` to ANY permutation.
So if `arr` and `target` have same elements (same counts), true.

### Complexity / Độ phức tạp
- **Time**: O(N log N) or O(N) with hash map.
- **Space**: O(N) or O(1) (sorting in place if allowed).

---

## Analysis / Phân tích

### Approach: Frequency Counting or Sorting
Sort both arrays. Check if equal.
Or use HashMap to count frequencies.
Or Array (1-1000 range).
Sắp xếp cả hai mảng. Kiểm tra xem có bằng nhau không.
Hoặc sử dụng HashMap để đếm tần suất.
Hoặc Mảng (phạm vi 1-1000).

---
