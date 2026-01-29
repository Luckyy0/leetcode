# 961. N-Repeated Element in Size 2N Array / Phần tử lặp lại N lần trong mảng kích thước 2N

## Problem Description / Mô tả bài toán
You are given an integer array `nums` of size `2n` where `n` different elements exist, and one of these elements is repeated `n` times.
Cho một mảng số nguyên `nums` kích thước `2n` trong đó có `n` phần tử khác nhau và một trong số các phần tử này được lặp lại `n` lần.

Return the element that is repeated `n` times.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Property of N repetition / Thuộc tính của phép lặp N lần
Since one element appears `n` times in a `2n` array, it must occupy half of the array. This creates a very high probability that this element will be close to its identical copy.
Vì một phần tử xuất hiện `n` lần trong mảng `2n`, nó phải chiếm một nửa mảng. Điều này tạo ra xác suất rất cao là phần tử này sẽ ở gần bản sao giống hệt của nó.

Algorithm:
1. Iterate through `nums` and check if `nums[i] == nums[i-1]`, `nums[i] == nums[i-2]`, or `nums[i] == nums[i-3]`.
2. Or simply use a `HashSet` to find the first element that repeats.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) with set, O(1) with sliding check.

---

## Analysis / Phân tích

### Approach: Short-range Detection
Exploit the high density of the repeated element. Because it occupies 50% of the slots, instances of it must frequently appear within a window of size 4 or less. A simple local redundancy check is sufficient to identify the target value.
Khai thác mật độ cao của phần tử lặp lại. Bởi vì nó chiếm 50% các vị trí, các bản sao của nó phải thường xuyên xuất hiện trong một cửa sổ có kích thước từ 4 trở xuống. Một bản kiểm tra dư thừa cục bộ đơn giản là đủ để xác định giá trị mục tiêu.

---
