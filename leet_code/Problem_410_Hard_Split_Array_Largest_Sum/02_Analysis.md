# Analysis for Split Array Largest Sum
# *Phân tích cho bài toán Chia Mảng Tổng Lớn nhất*

## 1. Problem Essence & Mini-Max
## *1. Bản chất vấn đề & Mini-Max*

### The Challenge
### *Thách thức*
Finding a way to partition an array into $k$ contiguous segments such that the weight of the "heaviest" segment is as small as possible. This is a classic "minimize the maximum" problem.

### Strategy: Binary Search on Answer
### *Chiến lược: Tìm kiếm Nhị phân trên Kết quả*
Instead of trying to find the splits directly, we look at the possible range of the "largest sum" and verify if a specific value is feasible.
1.  **Range:**
    - `low`: The maximum element in the array (because any subarray must contain at least one element).
    - `high`: The sum of all elements (if $k=1$).
2.  **Binary Search:** Pick a `mid` value.
3.  **Feasibility Check (`canSplit`):**
    - Can we split the array into $k$ or fewer subarrays such that each subarray's sum is $\le mid$?
    - Iterate through `nums` and greedily accumulate sums. When the sum exceeds `mid`, start a new subarray and increment our count.
    - If `count <= k`, then `mid` is potentially valid. Try smaller: `high = mid - 1`.
    - Else, `mid` is too small. Try larger: `low = mid + 1`.

---

## 2. Approach: Greedy Verification
## *2. Hướng tiếp cận: Xác thực Tham lam*

### Logic
### *Logic*
The `canSplit` check is greedy. Since the subarrays must be contiguous, we just keep adding elements until we hit the `mid` limit. This is the most efficient way to check for a given capacity.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N * log(Sum)) Efficiency:** Binary search is extremely fast, and the verification is a simple linear pass.
    *Hiệu quả: Tìm kiếm nhị phân cực nhanh, và việc xác thực chỉ là một lần duyệt tuyến tính.*
*   **Optimal Result:** Binary search on the answer space guaranteed to find the absolute minimum feasible maximum.
    *Kết quả tối ưu: Đảm bảo tìm được giá trị cực tiểu của cái cực đại.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot \log(\text{Sum of array}))$.
    *Độ phức tạp thời gian: $O(N \cdot \log(\sum))$.*
*   **Space Complexity:** $O(1)$.
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums = [7,2,5,10,8], k = 2`
1. `low = 10` (max element), `high = 32` (total sum).
2. `mid = 21`: 
   - Subarray 1: `7, 2, 5` (Sum 14).
   - Subarray 2: `10, 8` (Sum 18).
   - `count = 2`. `2 <= 2` is true. `ans = 21, high = 20`.
3. `mid = 15`: 
   - Subarray 1: `7, 2, 5` (14).
   - Subarray 2: `10` (10).
   - Subarray 3: `8` (8).
   - `count = 3`. `3 > 2` is false. `low = 16`.
... narrows down to 18.
Result: 18.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Binary Search on Answer with Greedy Check.
*Tìm kiếm nhị phân kết quả với kiểm tra tham lam.*
---
*Chia sẻ gánh nặng (splitting the sum) một cách công bằng nhất chính là nghệ thuật của sự kiềm tỏa. Bằng cách thăm dò (binary search) giới hạn của sự chịu đựng (mid-value) và kiểm tra khả năng thực tế (greedy check), ta tìm ra được điểm cân bằng hoàn hảo, nơi mà không một phân đoạn nào phải chịu áp lực quá lớn so với phần còn lại.*
Sharing the burden (splitting the sum) most fairly is the art of restraint. By exploring (binary search) the limits of endurance (mid-value) and checking practical feasibility (greedy check), we find the perfect balance point, where no segment has to bear too much pressure compared to the rest.
