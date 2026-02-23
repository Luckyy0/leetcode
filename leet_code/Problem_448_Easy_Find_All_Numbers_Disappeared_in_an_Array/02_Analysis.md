# Analysis for Find All Numbers Disappeared in an Array
# *Phân tích cho bài toán Tìm tất cả các Số bị mất trong Mảng*

## 1. Problem Essence & State Marking
## *1. Bản chất vấn đề & Đánh dấu Trạng thái*

### The Challenge
### *Thách thức*
Finding missing numbers in $O(n)$ time and $O(1)$ space. Since values are in the range `[1, n]`, we can use the array indices as a map to record which numbers are present.

### Strategy: Index Negation
### *Chiến lược: Đổi dấu Chỉ số*

1.  **Phase 1: Mark Presence:**
    - Iterate through the array. For each number $x$, find its target index `idx = |x| - 1`.
    - If `nums[idx]` is positive, make it negative. This "marks" that the number `idx + 1` exists in the array.
2.  **Phase 2: Detect Absence:**
    - Iterate through the array again.
    - If `nums[i]` is still positive, it means the number `i + 1` was never encountered in Phase 1.
    - Add `i + 1` to the result list.

---

## 2. Approach: Two-Pass Scan
## *2. Hướng tiếp cận: Quét hai lần*

### Logic
### *Logic*
(See above). The first pass marks existence without destroying original data (recoverable with `abs()`). The second pass identifies the "holes" in the data.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Optimal Space:** No auxiliary data structures needed besides the output.
    *Không gian tối ưu: Không cần cấu trúc dữ liệu phụ trợ ngoài đầu ra.*
*   **Simple Logic:** Clearly separates "reporting" from "recording".
    *Logic đơn giản: Tách biệt rõ ràng việc "ghi chép" và "báo cáo".*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(n)$, total two passes.
    *Độ phức tạp thời gian: $O(n)$.*
*   **Space Complexity:** $O(1)$ (excluding output).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[4,3,2,7,8,2,3,1]`
1. `i=0, v=4`: `nums[3]` becomes negative.
2. `i=1, v=3`: `nums[2]` becomes negative.
3. ...
4. After Phase 1, the values at indices 4 and 5 (corresponding to numbers 5 and 6) will remain positive because 5 and 6 never appeared as `|nums[i]|`.
Phase 2: Detect `nums[4] > 0` and `nums[5] > 0`.
Result: `[5, 6]`.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

In-place negation marking.
*Đánh dấu bằng cách đổi dấu tại chỗ.*
---
*Trong một hệ thống hoàn hảo, mỗi thực thể đều có một vị trí thuộc về mình (index). Những sự vắng mặt (disappeared numbers) không phải là sự hư vô, mà là những khoảng trống chưa được lấp đầy (positive values). Bằng cách đánh dấu những gì đã xuất hiện (negation), ta có thể nhận diện rõ ràng những gì còn thiếu sót, từ đó hoàn thiện bức tranh của dữ liệu.*
In a perfect system, every entity has a place of its own (index). Absences (disappeared numbers) are not non-existence, but unfilled gaps (positive values). By marking what has appeared (negation), we can clearly identify what is missing, thereby completing the picture of the data.
