# 164. Maximum Gap / Khoảng Cách Tối Đa

## Problem Description / Mô tả bài toán
Given an integer array `nums`, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return `0`.
Cho một mảng số nguyên `nums`, hãy trả về hiệu số lớn nhất giữa hai phần tử liên tiếp sau khi đã sắp xếp. Nếu mảng chứa ít hơn hai phần tử, hãy trả về `0`.

You must write an algorithm that runs in **linear time** and uses **linear extra space**.
Bạn phải viết một thuật toán chạy trong **thời gian tuyến tính** và sử dụng **không gian bổ sung tuyến tính**.

### Example 1:
```text
Input: nums = [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
```

### Example 2:
```text
Input: nums = [10]
Output: 0
Explanation: The array contains less than 2 elements.
```

## Constraints / Ràng buộc
- `1 <= nums.length <= 10^5`
- `0 <= nums[i] <= 10^9`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Why Not Sorting? / Tại sao không Sắp xếp?
Standard sorting takes O(N log N). The problem requires **O(N)**.
Sắp xếp chuẩn tốn O(N log N). Bài toán yêu cầu **O(N)**.

### Pigeonhole Principle & Bucketing / Nguyên lý Chuồng bồ câu & Chia Thùng
If we have `N` numbers between `min` and `max`, the maximum possible gap must be at least `(max - min) / (N - 1)`.
Nếu chúng ta có `N` số giữa `min` và `max`, khoảng cách tối đa có thể phải ít nhất là `(max - min) / (N - 1)`.

Let `bucketSize = max(1, (max - min) / (N - 1))`.
1.  Divide the range `[min, max]` into buckets of size `bucketSize`.
2.  Each bucket stores its **minimum** and **maximum** value.
3.  The maximum gap **cannot** occur within a single bucket (since bucket size is smaller than the average gap).
4.  The maximum gap **must** occur between the maximum of one bucket and the minimum of the next non-empty bucket.

---

## Analysis / Phân tích

### Approach: Bucket Sort Logic

**Algorithm**:
1. Find `min` and `max` of the array.
2. If `min == max`, return 0.
3. Calculate `bucketSize` and `bucketCount`.
4. Initialize arrays `bucketMin` and `bucketMax` (use `Integer.MAX_VALUE` and `Integer.MIN_VALUE`).
5. Map each number to a bucket and update its `min`/`max`.
6. Iterate through buckets to find the max gap between `bucketMax[i]` and `bucketMin[next_non_empty_j]`.

### Complexity / Độ phức tạp
- **Time**: O(N) - single pass to find min/max, single pass to bucket, single pass through buckets.
- **Space**: O(N) - to store bucket information.

---

## Edge Cases / Các trường hợp biên
1.  **Duplicate values**: Handled by bucket logic.
2.  **All elements identical**: Return 0.
3.  **Very large coordinates**: `0` to `10^9` handled by `long` if needed, but `int` is enough for values themselves.
