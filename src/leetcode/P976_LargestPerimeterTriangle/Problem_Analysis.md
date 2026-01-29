# 976. Largest Perimeter Triangle / Tam giác có Chu vi Lớn nhất

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths.
Cho một mảng các số nguyên `nums`, hãy trả về chu vi lớn nhất của một tam giác có diện tích khác không, được tạo thành từ ba trong số các độ dài này.

If it is impossible to form any triangle of non-zero area, return 0.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Triangle Inequality / Bất đẳng thức Tam giác
Three lengths $a, b, c$ (where $a \le b \le c$) can form a triangle if $a + b > c$.
Ba độ dài $a, b, c$ (trong đó $a \le b \le c$) có thể tạo thành một tam giác nếu $a + b > c$.

Algorithm:
1. Sort `nums` in descending order.
2. Iterate through consecutive triplets `(nums[i], nums[i+1], nums[i+2])`.
3. The first triplet that satisfies the triangle inequality `nums[i+2] + nums[i+1] > nums[i]` will give the largest perimeter.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(log N).

---

## Analysis / Phân tích

### Approach: Greedy Descending Search
Sort the list and evaluate triplets from largest to smallest. Since we seek the maximum perimeter, checking the most significant values first ensures an immediate, optimal result the moment the triangle inequality condition is met.
Sắp xếp danh sách và đánh giá các bộ ba từ lớn nhất đến nhỏ nhất. Vì chúng ta tìm kiếm chu vi tối đa, việc kiểm tra các giá trị lớn nhất trước tiên đảm bảo mang lại kết quả tối ưu ngay khi điều kiện bất đẳng thức tam giác được thỏa mãn.

---
