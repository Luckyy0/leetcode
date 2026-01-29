# 674. Longest Continuous Increasing Subsequence / Dãy con Tăng Liên tục Dài nhất

## Problem Description / Mô tả bài toán
Given an unsorted array of integers `nums`, return the length of the longest **continuous increasing subsequence** (i.e. subarray). The subsequence must be **strictly** increasing.
Cho một mảng các số nguyên chưa được sắp xếp `nums`, hãy trả về độ dài của **dãy con tăng liên tục** (tức là mảng con) dài nhất. Dãy con phải tăng **nghiêm ngặt**.

A **continuous increasing subsequence** is defined by two indices `l` and `r` (`l <= r`) such that it is `[nums[l], nums[l + 1], ..., nums[r - 1], nums[r]]` and for each `l <= i < r`, `nums[i] < nums[i + 1]`.
Một **dãy con tăng liên tục** được định nghĩa bởi hai chỉ số `l` và `r` (`l <= r`) sao cho nó là `[nums[l], nums[l + 1], ..., nums[r - 1], nums[r]]` và với mỗi `l <= i < r`, `nums[i] < nums[i + 1]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window / Two Pointers / Cửa sổ Trượt / Hai con Trỏ
Since the subsequence must be continuous, we can use a single pass to track the length of the current increasing segment.
Vì dãy con phải liên tục, chúng ta có thể sử dụng một lượt quét để theo dõi độ dài của đoạn tăng hiện tại.

Whenever `nums[i] <= nums[i-1]`, the current segment breaks, and we start a new one from `nums[i]`.
Bất cứ khi nào `nums[i] <= nums[i-1]`, đoạn hiện tại sẽ bị đứt và chúng ta bắt đầu một đoạn mới từ `nums[i]`.

### Complexity / Độ phức tạp
- **Time**: O(N) where N is the length of the array.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear Scan
Maintain a `maxLen` variable and a `currentLen` counter. Reset `currentLen` to 1 whenever the increasing condition is violated.
Duy trì một biến `maxLen` và một bộ đếm `currentLen`. Đặt lại `currentLen` thành 1 bất cứ khi nào điều kiện tăng bị vi phạm.

---
