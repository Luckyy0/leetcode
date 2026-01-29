# 1338. Reduce Array Size to The Half / Giảm Kích thước Mảng xuống Một nửa

## Problem Description / Mô tả bài toán
Array `arr`. Choose a set of integers and remove all occurrences of these integers.
Target: new size <= `original_size / 2`.
Min size of set.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Strategy
Remove elements with highest frequency first.
1. Count frequencies.
2. Sort frequencies descending.
3. Accumulate frequencies until sum >= N/2.
4. Count how many distinct elements used.

### Complexity / Độ phức tạp
- **Time**: O(N log N) or O(N) using counting sort for frequencies.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Greedy Frequency
Count the frequency of each element. Collect the frequencies into a list and sort them in descending order. Iterate through the sorted frequencies, summing them up. Stop once the accumulated sum is at least `n / 2`. The number of frequencies used is the minimum set size.
Đếm tần suất của mỗi phần tử. Thu thập các tần suất vào một danh sách và sắp xếp chúng theo thứ tự giảm dần. Lặp lại qua các tần suất đã sắp xếp, cộng tổng chúng lại. Dừng lại khi tổng tích lũy ít nhất là `n / 2`. Số tần suất được sử dụng là kích thước tập hợp tối thiểu.

---
