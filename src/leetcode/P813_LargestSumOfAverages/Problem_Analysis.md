# 813. Largest Sum of Averages / Tổng Giá trị Trung bình Lớn nhất

## Problem Description / Mô tả bài toán
You are given an integer array `nums` and an integer `k`. You can partition the array into at most `k` non-empty adjacent subarrays. The score of a partition is the sum of the averages of each subarray.
Bạn được cho một mảng số nguyên `nums` và một số nguyên `k`. Bạn có thể chia mảng thành tối đa `k` mảng con kề nhau không rỗng. Điểm của một phân vùng là tổng các giá trị trung bình của từng mảng con.

Return the maximum score you can achieve of all the possible partitions.
Trả về số điểm tối đa bạn có thể đạt được trong tất cả các phân vùng có thể.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
Let `dp[i][j]` be the maximum score for partitioning the first `i` elements into `j` subarrays.
Gọi `dp[i][j]` là điểm số tối đa khi chia `i` phần tử đầu tiên thành `j` mảng con.

Transition:
To compute `dp[i][j]`, we can pick the last subarray starting at index `p` and ending at `i-1`.
`dp[i][j] = max(dp[p][j-1] + average(nums[p...i-1]))` for all `0 < p < i`.

Base Case:
`dp[i][1] = average(nums[0...i-1])`.

### Complexity / Độ phức tạp
- **Time**: O(K * N^2).
- **Space**: O(N * K) or optimized to O(N).

---

## Analysis / Phân tích

### Approach: Recursive Subarray Partitioning
We optimize the partition by trying every possible split point for the last subarray. Precalculating prefix sums allows for O(1) average calculation.
Chúng ta tối ưu hóa phân vùng bằng cách thử mọi điểm chia có thể cho mảng con cuối cùng. Việc tính toán trước tổng tiền tố cho phép tính giá trị trung bình với O(1).

---
