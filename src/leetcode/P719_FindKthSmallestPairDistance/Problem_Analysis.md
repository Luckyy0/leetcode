# 719. Find K-th Smallest Pair Distance / Tìm Khoảng cách Cặp nhỏ thứ K

## Problem Description / Mô tả bài toán
The distance of a pair of integers `(a, b)` is defined as the absolute difference between `a` and `b`.
Khoảng cách của một cặp số nguyên `(a, b)` được định nghĩa là giá trị tuyệt đối của hiệu giữa `a` và `b`.

Given an integer array `nums` and an integer `k`, return the `kth` smallest **distance** among all the pairs `nums[i]` and `nums[j]` where (0 <= i < j < nums.length).
Cho một mảng số nguyên `nums` và một số nguyên `k`, hãy trả về **khoảng cách** nhỏ thứ `k` trong số tất cả các cặp `nums[i]` và `nums[j]` sao cho (0 <= i < j < nums.length).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Binary Search on Answer / Tìm kiếm Nhị phân trên Kết quả
The distance range is `[0, MaxValue - MinValue]`.
Phạm vi khoảng cách là `[0, Giá_trị_Max - Giá_trị_Min]`.

For a chosen distance `mid`, we can efficiently count how many pairs have distance `<= mid` using Two Pointers on a sorted array:
Đối với một khoảng cách `mid` đã chọn, chúng ta có thể đếm hiệu quả xem có bao nhiêu cặp có khoảng cách `<= mid` bằng cách sử dụng Hai con trỏ trên một mảng đã sắp xếp:

- Sort `nums`.
- For each `right` index, find minimum `left` such that `nums[right] - nums[left] <= mid`.
- Number of pairs with `right` as endpoint is `right - left`.

### Complexity / Độ phức tạp
- **Time**: O(N log N + N log(MaxDist)) where N is the length of `nums`.
- **Space**: O(1) beyond sorting.

---

## Analysis / Phân tích

### Approach: Binary Search with Sliding Window
Combine binary searching the answer with a linear scan using two pointers to count satisfying pairs.
Kết hợp tìm kiếm nhị phân kết quả với quét tuyến tính sử dụng hai con trỏ để đếm các cặp thỏa mãn.

---
