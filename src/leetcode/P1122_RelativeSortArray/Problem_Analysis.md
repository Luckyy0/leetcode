# 1122. Relative Sort Array / Sắp xếp Mảng Tương đối

## Problem Description / Mô tả bài toán
Given two arrays `arr1` and `arr2`, the elements of `arr2` are distinct, and all elements in `arr2` are also in `arr1`.
Sort the elements of `arr1` such that the relative ordering of items in `arr1` are the same as in `arr2`. Elements that don't appear in `arr2` should be placed at the end of `arr1` in ascending order.
Cho hai mảng `arr1` và `arr2`, các phần tử của `arr2` là phân biệt, và tất cả các phần tử trong `arr2` cũng có trong `arr1`.
Sắp xếp các phần tử của `arr1` sao cho thứ tự tương đối của các mục trong `arr1` giống như trong `arr2`. Các phần tử không xuất hiện trong `arr2` nên được đặt ở cuối `arr1` theo thứ tự tăng dần.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Custom Comparison / Frequency Count + Construct / So sánh Tùy chỉnh / Đếm Tần suất + Xây dựng
Approach 1: Custom Comparator.
Map each element in `arr2` to its index. Elements not in `arr2` get a high index and sorted by value. O(N log N).

Approach 2: Counting Sort (bucket sort).
Count frequencies of `arr1`.
Iterate `arr2`, append counts.
Iterate buckets (0 to 1000) skipping those in `arr2` (mark processed), append remaining counts.

### Complexity / Độ phức tạp
- **Time**: O(N + M + K) where K is range (1000). Linear since range is small.
- **Space**: O(K).

---

## Analysis / Phân tích

### Approach: Bucket Counting Construction
Count the frequency of each element in `arr1`. Construct the result by iterating through `arr2` and appending each element the requisite number of times (from the count map). Finally, iterate through the remaining numbers in the count map (in ascending order) and append them. This avoids explicit sorting of the main array.
Đếm tần suất của mỗi phần tử trong `arr1`. Xây dựng kết quả bằng cách lặp qua `arr2` và thêm từng phần tử với số lần cần thiết (từ bản đồ đếm). Cuối cùng, lặp qua các số còn lại trong bản đồ đếm (theo thứ tự tăng dần) và thêm chúng. Điều này tránh việc sắp xếp rõ ràng mảng chính.

---
