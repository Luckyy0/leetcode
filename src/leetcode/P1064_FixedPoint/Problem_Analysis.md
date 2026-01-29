# 1064. Fixed Point / Điểm Cố định

## Problem Description / Mô tả bài toán
Given an array of distinct integers `arr`, sorted in ascending order, return the smallest index `i` that satisfies `arr[i] == i`. If no such index exists, return -1.
Cho một mảng các số nguyên phân biệt `arr`, được sắp xếp theo thứ tự tăng dần, hãy trả về chỉ số nhỏ nhất `i` thỏa mãn `arr[i] == i`. Nếu không tồn tại chỉ số như vậy, hãy trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search / Tìm kiếm Nhị phân
The function `f(i) = arr[i] - i` is monotonically increasing because `arr` is distinct integers sorted ascending (slope >= 1).
`arr[i+1] >= arr[i] + 1` => `arr[i+1] - (i+1) >= arr[i] - i`.

We look for first `i` where `arr[i] - i == 0` (or `arr[i] >= i` and verify equality).
If `arr[mid] >= mid`, potential answer is `mid` or to the left.
If `arr[mid] < mid`, answer must be to the right.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Monotonic Function Search
Exploit the sorted, distinct property which ensures $arr[i] - i$ is non-decreasing. Use binary search to find the first index where $arr[i] \ge i$. Check if equality holds at that index.
Khai thác thuộc tính đã sắp xếp và phân biệt, đảm bảo $arr[i] - i$ là không giảm. Sử dụng tìm kiếm nhị phân để tìm chỉ số đầu tiên nơi $arr[i] \ge i$. Kiểm tra xem đẳng thức có giữ nguyên tại chỉ số đó hay không.

---
