# Analysis for 4Sum II
# *Phân tích cho bài toán 4Sum II*

## 1. Problem Essence & Divide and Conquer Mapping
## *1. Bản chất vấn đề & Ánh xạ Chia để Trị*

### The Challenge
### *Thách thức*
Counting tuples from 4 arrays that sum to zero. A brute force $O(N^4)$ approach is too slow for $N=200$ ($200^4 = 1.6 \times 10^9$). We need a way to reduce the complexity, ideally to $O(N^2)$.

### Strategy: Two-by-Two Hashing
### *Chiến lược: Băm Hai kèm Hai*

1.  **Group A & B:** 
    - Iterate through all pairs `(i, j)` from `nums1` and `nums2`.
    - Calculate their sum $S = nums1[i] + nums2[j]$.
    - Store the frequency of each sum $S$ in a `HashMap<Integer, Integer>`.
2.  **Group C & D:**
    - Iterate through all pairs `(k, l)` from `nums3` and `nums4`.
    - Calculate their sum $T = nums3[k] + nums4[l]$.
    - We need $S + T = 0$, which means $S = -T$.
    - Check the `HashMap` for the value `-T`. If it exists, add its frequency to the total count.

---

## 2. Approach: HashMap Aggregation
## *2. Hướng tiếp cận: Tổng hợp bằng HashMap*

### Logic
### *Logic*
(See above). Dividing the 4-sum problem into two 2-sum sub-problems drastically reduces the search space. The $O(N^2)$ time is perfectly efficient for $N=200$.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Optimal Complexity:** Corrects the $O(N^4) \to O(N^2)$ reduction using information theory (hashing).
    *Độ phức tạp tối ưu: Chuyển đổi O(N^4) thành O(N^2) nhờ lý thuyết thông tin (băm).*
*   **Simple Implementation:** Clear separation between building the map and querying it.
    *Triển khai đơn giản: Phân tách rõ ràng việc xây dựng bản đồ và truy vấn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$, where $N$ is the length of the arrays.
    *Độ phức tạp thời gian: $O(N^2)$.*
*   **Space Complexity:** $O(N^2)$ in the worst case to store all possible sums of `nums1` and `nums2`.
    *Độ phức tạp không gian: $O(N^2)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums1=[1,2], nums2=[-2,-1], nums3=[-1,2], nums4=[0,2]`
1. **Map (nums1 + nums2):**
   - 1+(-2) = -1
   - 1+(-1) = 0
   - 2+(-2) = 0
   - 2+(-1) = 1
   `Map: {-1:1, 0:2, 1:1}`
2. **Scan (nums3 + nums4):**
   - -1+0 = -1. Need 1 in map? Yes (count 1). Total = 1.
   - -1+2 = 1. Need -1 in map? Yes (count 1). Total = 2.
   - 2+0 = 2. Need -2 in map? No.
   - 2+2 = 4. Need -4 in map? No.
Result: 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

HashMap to store sums of pairs from two arrays.
*Sử dụng HashMap để lưu tổng các cặp từ hai mảng.*
---
*Khi đối mặt với sự phức tạp của bốn thực thể (4Sum), chìa khóa của sự cân bằng nằm ở việc chia đôi gánh nặng (divide and conquer). Bằng cách để hai bên (A, B) chuẩn bị sẵn sàng những gì họ có (hashing) và hai bên còn lại (C, D) đi tìm mảnh ghép tương xứng (counterpart), ta tạo nên một sự hòa hợp tuyệt đối (sum=0) chỉ trong một khoảng thời gian ngắn ngủi ($O(N^2)$). Sự hợp tác chính là gốc rễ của hiệu quả.*
When facing the complexity of four entities (4Sum), the key to balance lies in dividing the burden (divide and conquer). By letting two sides (A, B) prepare what they have (hashing) and the remaining two sides (C, D) find the corresponding puzzle piece (counterpart), we create absolute harmony (sum=0) in a short time ($O(N^2)$). Cooperation is the root of efficiency.
