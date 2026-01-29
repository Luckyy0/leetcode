# 747. Largest Number At Least Twice of Others / Số Lớn nhất Gấp đôi các số khác

## Problem Description / Mô tả bài toán
You are given an integer array `nums` where the largest integer is **unique**.
Bạn được cho một mảng số nguyên `nums` trong đó số nguyên lớn nhất là **duy nhất**.

Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.
Hãy xác định xem phần tử lớn nhất trong mảng có lớn gấp ít nhất hai lần so với mọi số khác trong mảng hay không. Nếu có, hãy trả về chỉ số của phần tử lớn nhất, ngược lại trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Finding Maximum and Second Maximum / Tìm Giá trị Lớn nhất và Lớn thứ hai
If the largest number `max1` is at least twice all others, it must specifically be at least twice the **second largest** number `max2`.
Nếu số lớn nhất `max1` lớn gấp ít nhất hai lần tất cả các số khác, thì cụ thể nó phải lớn gấp ít nhất hai lần số **lớn thứ hai** `max2`.

Algorithm:
1. One pass to find the maximum value and its index.
2. Second pass to ensure `max >= 2 * nums[i]` for all `i != max_index`.
OR
1. Single pass to keep track of `max1` and `max2`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Two-Extrema Tracking
Track the largest and second largest values. At the end, check if `max1 >= 2 * max2`.
Theo dõi giá trị lớn nhất và lớn thứ hai. Cuối cùng, kiểm tra xem `max1 >= 2 * max2` hay không.

---
