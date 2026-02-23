# Analysis for Employee Free Time
# *Phân tích cho bài toán Thời gian Rảnh của Nhân viên*

## 1. Problem Essence & Merge Intervals
## *1. Bản chất vấn đề & Gộp Khoảng*

### The Challenge
### *Thách thức*
We have multiple lists of "busy" intervals. We need to find the gaps that result when we overlay all these busy times on a single timeline.
*Chúng ta có nhiều danh sách các khoảng "bận". Chúng ta cần tìm các khoảng trống xuất hiện khi chồng lấp tất cả các khoảng thời gian bận này lên một trục thời gian duy nhất.*

This is equivalent to: Union of all intervals -> Gaps in the union.
*Điều này tương đương với: Hợp của tất cả các khoảng -> Khoảng trống trong tập hợp đó.*

---

## 2. Strategy: Line Sweep / Sorting
## *2. Chiến lược: Quét dòng / Sắp xếp*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Flatten & Sort:**
    - Collect all intervals from all employees into a single list.
    - Sort them by `start` time.
    *   **Làm phẳng & Sắp xếp:** Gom tất cả các khoảng từ mọi nhân viên vào một danh sách. Sắp xếp theo thời gian bắt đầu.*

2.  **Merge & Find Gaps:**
    - Initialize `end` as the end time of the first interval.
    - Iterate through the sorted intervals.
    - For current interval `[s, e]`:
        - If `s > end`: We found a gap! The busy time ended at `end` and the next busy time starts at `s`. The gap is `[end, s]`. Add to result. Update `end = e`.
        - Else (`s <= end`): Overlap. Extend the current busy block. `end = max(end, e)`.
    *   **Gộp & Tìm khoảng trống:** Khởi tạo `end` là thời gian kết thúc của khoảng đầu tiên. Duyệt qua danh sách đã sắp xếp. Nếu khoảng hiện tại bắt đầu sau khi khoảng trước kết thúc -> Tìm thấy khoảng trống. Ngược lại -> Mở rộng khoảng bận.*

3.  **Optimization (Priority Queue):**
    - Instead of flattening everything (which is fast enough here since $N$ is small, but theoretically better for merging K sorted lists), we could use a Min-Heap of iterators.
    - However, sorting all intervals takes $O(N \log N)$ where $N$ is total intervals. Given constraints, flattening is simplest.

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ where $N$ is the total number of intervals across all employees.
    *   **Độ phức tạp thời gian:** $O(N \log N)$.*
*   **Space Complexity:** $O(N)$ to store the flattened list.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:** `[[1,2], [5,6]]`, `[[1,3]]`, `[[4,10]]`
Flatten: `[1,2], [5,6], [1,3], [4,10]`
Sort: `[1,2], [1,3], [4,10], [5,6]`
1. First: `[1,2]`. `end = 2`.
2. Next: `[1,3]`. `1 <= 2`. Overlap. `end = max(2, 3) = 3`.
3. Next: `[4,10]`. `4 > 3`. GAP found `[3, 4]`. Update `end = 10`.
4. Next: `[5,6]`. `5 <= 10`. Overlap. `end = max(10, 6) = 10`.
**Result:** `[[3, 4]]`.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Flatten-and-sort is the standard solution for merging multiple sets of intervals when we care about the union. It is robust and easy to implement.
*Làm phẳng và sắp xếp là giải pháp tiêu chuẩn để gộp nhiều tập hợp khoảng khi ta quan tâm đến hợp của chúng. Nó mạnh mẽ và dễ cài đặt.*
---
*Thời gian rảnh (Free time) là những khoảng lặng (Gaps) giữa bản hợp xướng ồn ào của công việc (Busy intervals). Để tìm thấy sự bình yên chung (Common free time), ta không nhìn vào từng cá nhân riêng lẻ, mà phải sắp xếp lại toàn bộ dòng chảy thời gian (Sort & Merge). Dữ liệu dạy ta rằng chỉ khi nhìn thấy bức tranh toàn cảnh của sự bận rộn (Union of intervals), ta mới nhận ra những khe hở quý giá để thở.*
Free time (Free time) is the silence (Gaps) amidst the noisy symphony of work (Busy intervals). To find common peace (Common free time), we do not look at individuals alone, but must rearrange the entire flow of time (Sort & Merge). Data teaches us that only when we see the full picture of busyness (Union of intervals) do we realize the precious cracks to breathe.
