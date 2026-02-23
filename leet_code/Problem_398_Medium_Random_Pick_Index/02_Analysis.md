# Analysis for Random Pick Index
# *Phân tích cho bài toán Chọn Chỉ số Ngẫu nhiên*

## 1. Problem Essence & Randomization
## *1. Bản chất vấn đề & Sự ngẫu nhiên*

### The Challenge
### *Thách thức*
Returning a random index for a target value $X$ where $X$ can appear multiple times. Every occurrence must have a $1/K$ probability (where $K$ is the frequency of $X$).

### Strategy 1: Map of Indices (Memory Intensive)
### *Chiến lược 1: Bản đồ các Chỉ số (Tốn bộ nhớ)*
Pre-process the array and store `target -> [index1, index2, ...]`.
- `pick`: $O(1)$.
- `Memory`: $O(N)$.

### Strategy 2: Reservoir Sampling (Space Efficient)
### *Chiến lược 2: Lấy mẫu Hồ chứa (Tiết kiệm không gian)*
Iterate through the array every time `pick` is called.
1.  Initialize `res = -1`, `count = 0`.
2.  Iterate `i` from `0` to `n-1`:
    - If `nums[i] == target`:
        - `count++`.
        - Generate random `r` in `[0, count-1]`.
        - If `r == 0`, update `res = i`.
3.  Return `res`.
- `pick`: $O(N)$.
- `Memory`: $O(1)$ extra space.

---

## 2. Approach: Reservoir Sampling
## *2. Hướng tiếp cận: Lấy mẫu Hồ chứa*

### Logic
### *Logic*
Given the memory constraints and the nature of the problem, Reservoir Sampling is often the preferred "elegant" solution, especially if the array is very large.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(1) Extra Space:** We don't need additional data structures to store indices.
    *Không gian phụ O(1): Chúng ta không cần cấu trúc dữ liệu bổ sung để lưu chỉ số.*
*   **Uniform Probability:** Guaranteed by the logic of Reservoir Sampling.
    *Xác suất đồng nhất: Được đảm bảo bởi logic của Lấy mẫu Hồ chứa.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ per `pick`.
    *Độ phức tạp thời gian: $O(N)$ cho mỗi lần gọi.*
*   **Space Complexity:** $O(1)$ extra (excluding input array).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**nums:** `[1, 2, 3, 3, 3]`, **target:** `3`
1. `i=2`: `nums[2]=3`. `count=1`. `r=rand(1)=0`. `res=2`.
2. `i=3`: `nums[3]=3`. `count=2`. `r=rand(2)`. 
   - If `r=0` (prob 1/2), `res=3`.
3. `i=4`: `nums[4]=3`. `count=3`. `r=rand(3)`.
   - If `r=0` (prob 1/3), `res=4`.
Result: Every index has 1/3 chance.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Reservoir Sampling for space efficiency.
*Lấy mẫu Hồ chứa để tiết kiệm không gian.*
---
*Sự công bằng (equal probability) trong việc lựa chọn không nhất thiết phải đến từ việc ghi nhớ tất cả quá khứ (storing all indices). Bằng cách luôn sẵn lòng thay đổi quyết định với một tỷ lệ hợp lý (Reservoir Sampling) khi gặp đối tượng phù hợp, ta đảm bảo rằng mọi cơ hội đều được đối xử như nhau.*
Fairness (equal probability) in selection does not necessarily come from remembering all the past (storing all indices). By always being willing to change decisions with a reasonable ratio (Reservoir Sampling) when encountering a suitable object, we ensure that all opportunities are treated equally.
