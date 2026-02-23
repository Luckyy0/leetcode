# Analysis for Summary Ranges
# *Phân tích cho bài toán Tóm tắt phạm vi*

## 1. Problem Essence & Iteration
## *1. Bản chất vấn đề & Sự lặp lại*

### The Continuity Check
### *Kiểm tra tính liên tục*
Since the array is sorted, we just need to group consecutive numbers.
`a, b` are consecutive if `b == a + 1`.

### The Logic
### *Logic*
Iterate through the array. Maintain a `start` of the current range.
- If `nums[i] + 1 == nums[i+1]`, continue (extend range).
- If `nums[i] + 1 != nums[i+1]`:
    - Range ends at `nums[i]`.
    - Format: if `start == nums[i]`, output `"start"`. Else `"start->nums[i]"`.
    - Reset `start = nums[i+1]`.

---

## 2. Approach: Linear Scan
## *2. Hướng tiếp cận: Quét tuyến tính*

### Algorithm
### *Thuật toán*
1.  Initialize `i = 0`.
2.  While `i < n`:
    - `start = nums[i]`.
    - While `i + 1 < n` and `nums[i+1] == nums[i] + 1`: `i++` (Fast forward).
    - Create string based on start and current `nums[i]`.
    - Add to list.
    - `i++` (Move to next range).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Simplicity:** Pure single pass.
    *Đơn giản: Chỉ cần một lần quét.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(1)$ (ignoring output).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[0,1,2,4,5,7]`

1.  i=0. start=0.
    - nums[1] (1) == 0+1. i++.
    - nums[2] (2) == 1+1. i++.
    - nums[3] (4) != 2+1. Stop.
    - Range `0->2`. Add.
    - i++ (becomes 3).
2.  i=3. start=4.
    - nums[4] (5) == 4+1. i++.
    - nums[5] (7) != 5+1. Stop.
    - Range `4->5`. Add.
    - i++ (becomes 5).
3.  i=5. start=7.
    - End of array.
    - Range `7`. Add.
    - i++ (becomes 6). Loop ends.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Very straightforward. Be careful with handling the loop end correctly.
*Rất đơn giản. Cẩn thận xử lý kết thúc vòng lặp.*
---
*Những con số đứng cạnh nhau tạo nên một dòng chảy (range), nhưng chính những khoảng trống (gap) mới định nghĩa nên các chương hồi.*
Numbers standing next to each other create a flow (range), but it is the gaps that define the chapters.
