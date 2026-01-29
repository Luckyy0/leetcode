# 744. Find Smallest Letter Greater Than Target / Tìm Chữ cái Nhỏ nhất Lớn hơn Mục tiêu

## Problem Description / Mô tả bài toán
Given a characters array `letters` that is sorted in non-decreasing order and a character `target`, return the smallest character in the array that is larger than `target`.
Cho một mảng ký tự `letters` được sắp xếp theo thứ tự không giảm và một ký tự `target`, hãy trả về ký tự nhỏ nhất trong mảng mà lớn hơn `target`.

Note that the letters wrap around. For example, if `target == 'z'` and `letters == ['a', 'b']`, the answer is `'a'`.
Lưu ý rằng các chữ cái có tính chất vòng (wrap around). Ví dụ: nếu `target == 'z'` và `letters == ['a', 'b']`, câu trả lời là `'a'`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search / Tìm kiếm Nhị phân
Since the array is sorted, we can use binary search to find the insertion point of `target`.
Vì mảng đã được sắp xếp, chúng ta có thể sử dụng tìm kiếm nhị phân để tìm vị trí chèn của `target`.

Algorithm:
- Find the first character `c` such that `c > target`.
- If no such character is found, return the first element (due to the wrap-around rule).

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search for Upper Bound
The binary search logic returns the index of the first element strictly larger than target. Using modulo ensures the wrap-around logic.
Logic tìm kiếm nhị phân trả về chỉ số của phần tử đầu tiên lớn hơn hẳn mục tiêu. Sử dụng phép chia lấy dư đảm bảo logic vòng lặp.

---
