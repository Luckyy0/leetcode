# 977. Squares of a Sorted Array / Bình phương của một Mảng đã sắp xếp

## Problem Description / Mô tả bài toán
Given an integer array `nums` sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
Cho một mảng số nguyên `nums` được sắp xếp theo thứ tự không giảm, hãy trả về một mảng gồm bình phương của mỗi số được sắp xếp theo thứ tự không giảm.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two Pointers / Hai con trỏ
The largest square must come from either the far left or the far right of the original array (because of negative numbers).
Bình phương lớn nhất phải đến từ phía cực bên trái hoặc cực bên phải của mảng ban đầu (do có các số âm).

Algorithm:
1. `left = 0`, `right = n - 1`.
2. Fill the result array from back to front.
3. Compare `nums[left]^2` and `nums[right]^2`:
   - Pick the larger one, move the corresponding pointer.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) for result array.

---

## Analysis / Phân tích

### Approach: Outward-In Magnitude sweep
Focus on the extremities of the sorted array, as they contain the numbers with the largest absolute values. By comparing heads and tails, we can determine the sequence of squares in descending order and populate the result list efficiently.
Tập trung vào các điểm cực biên của mảng đã sắp xếp, vì chúng chứa các số có giá trị tuyệt đối lớn nhất. Bằng cách so sánh điểm đầu và điểm cuối, chúng ta có thể xác định chuỗi bình phương theo thứ tự giảm dần và điền vào danh sách kết quả một cách hiệu quả.

---
