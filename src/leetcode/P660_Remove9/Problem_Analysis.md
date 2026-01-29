# 660. Remove 9 / Loại bỏ số 9

## Problem Description / Mô tả bài toán
Start from integer 1 and remove any integer that contains 9 such as 9, 19, 29...
Bắt đầu từ số nguyên 1 và loại bỏ bất kỳ số nguyên nào có chứa số 9 chẳng hạn như 9, 19, 29...

Now, you will have a new integer sequence: 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, ...
Bây giờ, bạn sẽ có một dãy số nguyên mới: 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, ...

Given an integer `n`, return the nth element of the new sequence.
Cho một số nguyên `n`, hãy trả về phần tử thứ n của dãy số mới.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Base-9 Conversion / Chuyển đổi Cơ số 9
Removing all numbers containing the digit '9' is equivalent to counting numbers in a system that only uses digits 0-8.
Loại bỏ tất cả các số có chứa chữ số '9' tương đương với việc đếm các số trong một hệ thống chỉ sử dụng các chữ số từ 0-8.

This is exactly the base-9 representation of the number `n`.
Đây chính xác là biểu diễn cơ số 9 của số `n`.

### Complexity / Độ phức tạp
- **Time**: O(log9 N) because we are converting the number to base 9.
- **Space**: O(log9 N) to store the result string or numeric value.

---

## Analysis / Phân tích

### Approach: Base 10 to Base 9
To find the nth number without the digit 9, we simply convert `n` from decimal to base-9.
Để tìm số thứ n không có chữ số 9, chúng ta chỉ cần chuyển `n` từ hệ thập phân sang cơ số 9.

---
