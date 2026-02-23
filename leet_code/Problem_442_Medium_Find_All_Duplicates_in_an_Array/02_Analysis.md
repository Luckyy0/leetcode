# Analysis for Find All Duplicates in an Array
# *Phân tích cho bài toán Tìm tất cả các Phần tử Trùng lặp trong Mảng*

## 1. Problem Essence & Index-as-Hash
## *1. Bản chất vấn đề & Chỉ số thay cho Băm*

### The Challenge
### *Thách thức*
Finding duplicates in $O(n)$ time and $O(1)$ space. The key constraint is that all numbers are in the range `[1, n]`. This allows us to use the array itself as a frequency tracker. Each number $x$ can be "mapped" to index $x-1$.

### Strategy: Negation as a Flag
### *Chiến lược: Đổi dấu làm Cờ hiệu*

1.  Iterate through the array.
2.  For each element `nums[i]`:
    - Calculate the corresponding index: `idx = Math.abs(nums[i]) - 1`.
    - Check the value at `nums[idx]`.
    - If `nums[idx] < 0`: This index has been visited before, meaning the current number `Math.abs(nums[i])` is a duplicate. Add it to the result.
    - If `nums[idx] > 0`: Mark it as visited by negating it: `nums[idx] = -nums[idx]`.
3.  The result list now contains all numbers that appeared twice.

---

## 2. Approach: In-Place Modification
## *2. Hướng tiếp cận: Chỉnh sửa tại chỗ*

### Logic
### *Logic*
(See above). Negating the value at an index effectively uses one bit of information (the sign) to record "visited" status without losing the original value (which can be recovered with `Math.abs()`).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Zero Extra Space:** No hash sets or frequency arrays needed.
    *Không tốn thêm không gian: Không cần HashSet hay mảng tần suất.*
*   **Linear Time:** Single pass through the array.
    *Thời gian tuyến tính: Duyệt mảng một lần.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(n)$.
    *Độ phức tạp thời gian: $O(n)$.*
*   **Space Complexity:** $O(1)$ (excluding the space for the result list).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums = [4,3,2,7,8,2,3,1]`
1. `i=0, v=4, idx=3`. `nums[3]=7 > 0`. Mark negative: `nums[3]=-7`.
2. `i=1, v=3, idx=2`. `nums[2]=2 > 0`. Mark negative: `nums[2]=-2`.
3. ...
4. `i=5, v=|2|, idx=1`. `nums[1]=3`. Wait, `nums[1]` was 3. If we find it again?
   Let's trace carefully: `2` appears twice.
   - First time: index 1 is negated.
   - Second time: index 1 is already negative. **Duplicate!**

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

In-place negation using index mapping.
*Đổi dấu tại chỗ sử dụng ánh xạ chỉ số.*
---
*Trong một môi trường hạn hẹp về tài nguyên ($O(1)$ space), ta phải học cách sử dụng chính những gì mình đang có để ghi lại dấu vết. Mỗi con số trong cuộc đời đều có một vị trí (index) riêng của nó. Bằng cách để lại một dấu ấn (negation) tại nơi ta đã qua, ta có thể nhận ra mình đang lặp lại những bước chân cũ, từ đó thấu hiểu sự trùng lặp (duplicates) trong dòng chảy của dữ liệu.*
In a resource-constrained environment ($O(1)$ space), we must learn to use what we already have to record traces. Every number in life has its own position (index). By leaving a mark (negation) at the place we have passed, we can recognize that we are repeating old steps, thereby understanding the duplicate (duplicates) in the flow of data.
