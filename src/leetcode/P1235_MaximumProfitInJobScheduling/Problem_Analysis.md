# 1235. Maximum Profit in Job Scheduling / Lợi nhuận Tối đa trong Lập lịch Công việc

## Problem Description / Mô tả bài toán
Given `startTime`, `endTime`, `profit` arrays.
Find max profit such that no two jobs overlap.
`startTime[i] <= endTime[i]`. If job ends at time `X`, you can start another job at time `X`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming + Binary Search
Sort jobs by `endTime`.
`dp[i]` = max profit considering first `i` jobs (sorted).
`dp[i] = max(dp[i-1], profit[i] + dp[prev_compatible_index])`.
`prev_compatible_index`: largest index `j < i` such that `endTime[j] <= startTime[i]`.
Use `TreeMap` or Array + Binary Search to find `prev_compatible`.
`TreeMap<EndTime, MaxProfit>`:
Iterate jobs sorted by endTime.
`prevProfit = treeMap.floorEntry(current.start).getValue()`.
`currentProfit = current.profit + prevProfit`.
If `currentProfit > treeMap.lastEntry().getValue()`, put in map.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: DP with TreeMap
Sort jobs based on their end times. Use a `TreeMap` to store the maximum profit achievable up to a certain end time (`endTime -> maxProfit`). Iterate through the sorted jobs. For each job `i`, compute the profit if included: `job.profit + map.floorEntry(job.start).getValue()`. If this combined profit exceeds the max profit seen so far, add the entry `(job.end, combinedProfit)` to the map. The TreeMap effectively maintains the DP state `dp[time] = max_profit` and allows efficient binary search for the latest non-overlapping job.
Sắp xếp các công việc dựa trên thời gian kết thúc của chúng. Sử dụng `TreeMap` để lưu trữ lợi nhuận tối đa có thể đạt được cho đến một thời điểm kết thúc nhất định (`endTime -> maxProfit`). Lặp lại qua các công việc đã sắp xếp. Đối với mỗi công việc `i`, tính lợi nhuận nếu bao gồm: `job.profit + map.floorEntry(job.start).getValue()`. Nếu lợi nhuận kết hợp này vượt quá lợi nhuận tối đa đã thấy cho đến nay, hãy thêm mục `(job.end, combinedProfit)` vào bản đồ. TreeMap duy trì hiệu quả trạng thái DP `dp[time] = max_profit` và cho phép tìm kiếm nhị phân hiệu quả cho công việc không chồng chéo mới nhất.

---
