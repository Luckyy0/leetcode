# 1546. Maximum Number of Non-Overlapping Subarrays With Sum Equals Target / Số lượng Tối đa các Mảng con Không chồng chéo có Tổng bằng Mục tiêu

## Problem Description / Mô tả bài toán
Array `nums`, integer `target`.
Find maximum number of non-overlapping non-empty subarrays such that sum of each equals `target`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy + Prefix Sum + HashSet
To maximize the number of non-overlapping subarrays, we should greedily pick subarrays that end as early as possible.
Use a HashSet to store reachable prefix sums since the last completed subarray.
Iterate through the array, maintaining `currSum`.
If `currSum - target` is in the set:
- Found a valid subarray.
- Increment `count`.
- Clear the set (to ensure non-overlapping).
- Reset the set with prefix sum `0` for the next potential subarray.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Greedy with Prefix Sums
Iterate through the array and track the prefix sum.
If the prefix sum minus the target has been seen before (in the current non-overlapping segment), we found a subarray.
We then reset the prefix sum tracking to start searching for the next subarray from the current position.
Lặp qua mảng và theo dõi tổng tiền tố.
Nếu tổng tiền tố trừ đi mục tiêu đã được thấy trước đó (trong đoạn không chồng chéo hiện tại), chúng ta đã tìm thấy mảng con.
Sau đó, chúng ta đặt lại việc theo dõi tổng tiền tố để bắt đầu tìm kiếm mảng con tiếp theo từ vị trí hiện tại.

---
