# 1229. Meeting Scheduler / Lập lịch Cuộc họp

## Problem Description / Mô tả bài toán
Given availabilities of two people `slots1` and `slots2` (start, end) and a `duration`.
Find the earliest common time slot of length `duration`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two Pointers / Intersection
Sort both slots by start time.
Iterate with pointers `i`, `j`.
Intersection `[max(start1, start2), min(end1, end2)]`.
If length >= duration, return start.
Else, advance pointer of slot that ends earlier.

### Complexity / Độ phức tạp
- **Time**: O(N log N + M log M).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Sorted Intersection
Sort both availability arrays by start time. Use two pointers to iterate through the slots. For any pair of slots, find the intersection: `intersectStart = max(start1, start2)` and `intersectEnd = min(end1, end2)`. If `intersectEnd - intersectStart >= duration`, the meeting can start at `intersectStart` and end at `intersectStart + duration`. If the slot doesn't fit, increment the pointer of the slot that ends earlier to search for a better overlap.
Sắp xếp cả hai mảng khả dụng theo thời gian bắt đầu. Sử dụng hai con trỏ để lặp qua các khe thời gian. Đối với bất kỳ cặp khe nào, hãy tìm phần giao: `intersectStart = max(start1, start2)` và `intersectEnd = min(end1, end2)`. Nếu `intersectEnd - intersectStart >= duration`, cuộc họp có thể bắt đầu lúc `intersectStart` và kết thúc lúc `intersectStart + duration`. Nếu khe cắm không vừa, hãy tăng con trỏ của khe cắm kết thúc sớm hơn để tìm kiếm sự chồng chéo tốt hơn.

---
