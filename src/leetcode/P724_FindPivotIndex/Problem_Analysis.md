# 724. Find Pivot Index / Tìm Chỉ số Trung tâm

## Problem Description / Mô tả bài toán
Given an array of integers `nums`, calculate the **pivot index** of this array.
Cho một mảng các số nguyên `nums`, hãy tính **chỉ số trung tâm** của mảng này.

The **pivot index** is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
**Chỉ số trung tâm** là chỉ số mà tổng của tất cả các số nằm bên trái chỉ số đó bằng tổng của tất cả các số nằm bên phải chỉ số đó.

If the index is on the left edge of the array, the left sum is 0. If the index is on the right edge, the right sum is 0.
Nếu chỉ số nằm ở mép trái của mảng, tổng bên trái là 0. Nếu chỉ số nằm ở mép phải, tổng bên phải là 0.

Return the leftmost pivot index. If no such index exists, return -1.
Trả về chỉ số trung tâm ngoài cùng bên trái. Nếu không tồn tại chỉ số như vậy, trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Prefix Sum / Tổng Tiền tố
Let `totalSum` be the sum of all elements.
Gọi `totalSum` là tổng của tất cả các phần tử.

If we are at index `i`, let `leftSum` be the sum of elements before `i`.
The `rightSum` is `totalSum - leftSum - nums[i]`.
Chúng ta cần `leftSum == rightSum`, tức là `leftSum == totalSum - leftSum - nums[i]`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of `nums`.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear Scan with Running Sum
First, calculate the total sum. Then iterate through the array, updating the `leftSum` as you go and checking the pivot condition at each step.
Đầu tiên, tính tổng số. Sau đó lặp qua mảng, cập nhật `leftSum` khi di chuyển và kiểm tra điều kiện trung tâm ở mỗi bước.

---
