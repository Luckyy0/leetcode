# 786. K-th Smallest Prime Fraction / Phân số Nguyên tố Nhỏ thứ K

## Problem Description / Mô tả bài toán
You are given a sorted integer array `arr` containing `1` and prime numbers, where all the integers of `arr` are unique. You are also given an integer `k`.
Bạn được cho một mảng số nguyên đã sắp xếp `arr` chứa số `1` và các số nguyên tố, trong đó tất cả các số nguyên trong `arr` là duy nhất. Bạn cũng được cho một số nguyên `k`.

For every `i` and `j` where `0 <= i < j < arr.length`, the fraction `arr[i] / arr[j]` is formed.
Đối với mỗi `i` và `j` sao cho `0 <= i < j < arr.length`, phân số `arr[i] / arr[j]` được tạo thành.

Return the `kth` smallest fraction answer as an array of two integers `[arr[i], arr[j]]`.
Trả về phân số nhỏ thứ `k` dưới dạng một mảng gồm hai số nguyên `[arr[i], arr[j]]`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### PriorityQueue or Binary Search / PriorityQueue hoặc Tìm kiếm Nhị phân
Since we want the "kth smallest", we can use a Min-PriorityQueue to explore the smallest fractions.
Vì chúng ta muốn tìm "phần tử nhỏ thứ k", chúng ta có thể sử dụng Min-PriorityQueue để khám phá các phân số nhỏ nhất.

Algorithm (PQ):
1. For each `j`, the smallest possible fraction is `arr[0] / arr[j]`. Add all `(arr[0]/arr[j], 0, j)` to the PQ.
2. Poll the smallest. If it's the `kth` poll, that's the answer.
3. Otherwise, if you polled `(arr[i]/arr[j], i, j)`, add the next potential fraction `(arr[i+1]/arr[j], i+1, j)` for the same `j`.

Algorithm (Binary Search on Value):
- Search in `[0, 1]`. For a target value `V`, count how many fractions are `<= V` using two pointers.

### Complexity / Độ phức tạp
- **Time**: O(K log N) for PQ approach or O(N log(Range)) for Binary Search.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: PriorityQueue exploration
Treat the fractions as multiple sorted lists (one for each denominator). Use a Min-Heap to perform a K-way merge to find the K-th smallest element.
Coi các phân số như nhiều danh sách đã được sắp xếp (mỗi danh sách cho một mẫu số). Sử dụng Min-Heap để thực hiện hợp nhất K-đường nhằm tìm phần tử nhỏ thứ K.

---
