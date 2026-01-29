# 1186. Maximum Subarray Sum with One Deletion / Tổng Mảng con Lớn nhất với Một lần Xóa

## Problem Description / Mô tả bài toán
Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion.
In other words, you want to choose a subarray and optionally delete one element from it so that there is still at least one element left and the sum of the remaining elements is maximized.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming (Kadane's Variant) / Quy hoạch Động (Biến thể của Kadane)
`dp[i][0]` = max subarray sum ending at `i` (no deletions).
`dp[i][1]` = max subarray sum ending at `i` with 1 deletion.
Transitions:
`dp[i][0] = max(nums[i], dp[i-1][0] + nums[i])`.
`dp[i][1] = max(dp[i-1][0] (delete current), dp[i-1][1] + nums[i] (delete previous))`.
Wait, deletion can be at current element OR at previous steps.
Strictly:
`dp[i][0]`: max sum ending at `i`, no deletion yet.
`dp[i][1]`: max sum ending at `i` (current element is kept), with exactly 1 deletion somewhere before `i`.
Wait, if we delete current element, the subarray TECHNICALLY "ends" at `i` but `i` is skipped. So `dp[i-1][0]` is the sum.
Let's refine:
`kept[i]`: max sum ending at index `i`, no deletion in `0..i`.
`deleted[i]`: max sum ending *technically* at `i` (or effectively ending at `i`, involving `i` or skipping `i`?).
Better state:
`withoutDeletion[i]`: max subarray sum ending at `i` using `nums[i]`, with 0 deletions.
`withDeletion[i]`: max subarray sum ending at `i` using `nums[i]` (meaning `nums[i]` is INCLUDED), having deleted 1 element previously. OR ending at `i` where `nums[i]` IS DELETED (meaning sum is from `withoutDeletion[i-1]`).
Actually, if `nums[i]` is deleted, the subarray continues to `i+1`. We assume `withDeletion` tracks the max sum ending at `i` (either `nums[i]` is the end, or `nums[i]` was the deleted part? No, if deleted, it doesn't end there).
Standard DP:
`ignored[i]`: max sum ending at `i` with one deletion happened.
`notIgnored[i]`: max sum ending at `i` with no deletion.
`notIgnored[i] = max(nums[i], notIgnored[i-1] + nums[i])`.
`ignored[i] = max(ignored[i-1] + nums[i], notIgnored[i-1])`.
   - `ignored[i-1] + nums[i]`: deletion happened before `i`.
   - `notIgnored[i-1]`: current `nums[i]` is deleted.
Result is `max(max(notIgnored), max(ignored))`.
Edge case: max sum could be negative (all numbers negative). The problem says "at least one element left".
So initialize result with `-inf`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N) or O(1).

---

## Analysis / Phân tích

### Approach: Two-State DP
Maintain two states for each position `i`: `noDelete` (max subarray sum ending at `i` with 0 deletions) and `oneDelete` (max subarray sum ending at `i` with exactly 1 deletion). The `oneDelete` state can be reached either by deleting the current element (taking `noDelete[i-1]`) or by extending a previous state that already had a deletion (`oneDelete[i-1] + nums[i]`). The maximum of these states across all indices is the answer.
Duy trì hai trạng thái cho mỗi vị trí `i`: `noDelete` (tổng mảng con tối đa kết thúc tại `i` với 0 lần xóa) và `oneDelete` (tổng mảng con tối đa kết thúc tại `i` với đúng 1 lần xóa). Trạng thái `oneDelete` có thể đạt được bằng cách xóa phần tử hiện tại (lấy `noDelete[i-1]`) hoặc bằng cách mở rộng trạng thái trước đó đã có một lần xóa (`oneDelete[i-1] + nums[i]`). Giá trị lớn nhất của các trạng thái này trên tất cả các chỉ số là câu trả lời.

---
