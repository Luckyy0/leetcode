# 1288. Remove Covered Intervals / Xóa các Khoảng bị Che phủ

## Problem Description / Mô tả bài toán
Given intervals. Interval `[a, b)` is covered by `[c, d)` if `c <= a` and `b <= d`.
Remove covered intervals. Return remaining count.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sorting
1. Sort by start time ascending. If start times equal, sort by end time descending.
   - Why end time descending? So that larger interval `[1, 10)` comes before `[1, 8)`. This way `[1, 10)` covers `[1, 8)` naturally in linear scan.
2. Iterate. Keep track of current `maxEnd`.
   - If `curr.end <= maxEnd`: `curr` is covered (since `curr.start >= prev.start` and `curr.end <= prev.end`).
   - If `curr.end > maxEnd`: `curr` extends the range. Update `maxEnd`. Not covered.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(1) or O(log N) stack.

---

## Analysis / Phân tích

### Approach: Sort and Scan
Sort the intervals primarily by start time in ascending order, and secondarily by end time in descending order. This ensures that if two intervals start at the same point, the longer one appears first. Iterate through the sorted intervals maintaining a `maxEnd` seen so far. If an interval's end time is $\le$ `maxEnd`, it is completely covered by a previous interval (since its start is $\ge$ previous start and end $\le$ previous end). Otherwise, it is not covered; increment the count of non-covered intervals and update `maxEnd`.
Sắp xếp các khoảng chủ yếu theo thời gian bắt đầu theo thứ tự tăng dần, và thứ yếu theo thời gian kết thúc theo thứ tự giảm dần. Điều này đảm bảo rằng nếu hai khoảng bắt đầu tại cùng một điểm, khoảng dài hơn sẽ xuất hiện trước. Lặp qua các khoảng đã sắp xếp duy trì `maxEnd` đã thấy cho đến nay. Nếu thời gian kết thúc của một khoảng $\le$ `maxEnd`, nó hoàn toàn bị che phủ bởi một khoảng trước đó (vì thời gian bắt đầu của nó $\ge$ thời gian bắt đầu trước đó và kết thúc $\le$ kết thúc trước đó). Ngược lại, nó không bị che phủ; tăng số lượng các khoảng không bị che phủ và cập nhật `maxEnd`.

---
