# Analysis for Subarray Product Less Than K
# *Phân tích cho bài toán Tích mảng con nhỏ hơn K*

## 1. Problem Essence & Sliding Window
## *1. Bản chất vấn đề & Cửa sổ Trượt*

### The Challenge
### *Thách thức*
We need to count all contiguous subarrays whose product is less than $K$. Since all elements in `nums` are positive ($\ge 1$), the product of a subarray grows as we add more elements. This monotonic property makes the problem perfect for a **Sliding Window** approach.
*Chúng ta cần đếm tất cả các mảng con liên tục có tích nhỏ hơn $K$. Vì mọi phần tử đều dương, tích của mảng con sẽ tăng dần khi ta thêm phần tử. Tính chất đơn điệu này giúp bài toán cực kỳ phù hợp với phương pháp **Cửa sổ trượt**.*

---

## 2. Strategy: Two Pointers (Left and Right)
## *2. Chiến lược: Hai con trỏ (Trái và Phải)*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Handle Corner Case:** If $K \le 1$, return `0` because all elements are $\ge 1$, and there's no way to get a product strictly less than 1.
    * **Xử lý trường hợp đặc biệt:** Nếu $K \le 1$, trả về 0.*

2.  **Initialize Window:**
    - `left = 0`, `prod = 1`, `count = 0`.
    * **Khởi tạo cửa sổ:** Con trỏ trái, biến tích và biến đếm.*

3.  **Expansion (Right Pointer):**
    - Move `right` from `0` to `n-1`.
    - Update `prod *= nums[right]`.
    * **Mở rộng (Con trỏ Phải):** Nhân tích với phần tử mới.*

4.  **Contraction (Left Pointer):**
    - If `prod >= k`, divide `prod` by `nums[left]` and increment `left` until `prod < k` or `left > right`.
    * **Thu hẹp (Con trỏ Trái):** Nếu tích vượt quá ngưỡng, thu hẹp cửa sổ từ bên trái.*

5.  **Counting:**
    - At each step where `prod < k`, the number of new valid subarrays ending at `right` is exactly `right - left + 1`. These are:
        - `[nums[right]]`
        - `[nums[right-1], nums[right]]`
        - ...
        - `[nums[left], ..., nums[right]]`
    * **Đếm số lượng:** Với mỗi vị trí `right` hợp lệ, số mảng con mới kết thúc tại `right` là `right - left + 1`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Linear Time:** Each pointer (`left` and `right`) travels the length of the array at most once, making the algorithm extremely efficient.
    * **Thời gian Tuyến tính:** Mỗi con trỏ chỉ đi qua mảng tối đa một lần.*
*   **Counting Logic:** The key insight is understanding why `right - left + 1` works. It counts subarrays that *must* include the new element at `right`, ensuring no duplicates.
    * **Logic Đếm:** Điểm mấu chốt là hiểu tại sao công thức `right - left + 1` hoạt động chính xác.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the array.
    * **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**nums = [10, 5, 2, 6], k = 100**
1. Right=0 (10): prod=10 < 100. Count += (0-0+1) = 1. Window: [10].
2. Right=1 (5): prod=50 < 100. Count += (1-0+1) = 2. Subarrays: [5], [10, 5].
3. Right=2 (2): prod=100. NOT < 100.
   - Shrink: prod /= 10 = 10. Left=1.
   - Now prod=10 < 100. Count += (2-1+1) = 2. Subarrays: [2], [5, 2].
4. Right=3 (6): prod=60 < 100. Count += (3-1+1) = 3. Subarrays: [6], [2, 6], [5, 2, 6].
**Total:** 1 + 2 + 2 + 3 = 8.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For "Number of subarrays meeting condition X" where the condition depends on accumulation (sum, product), Sliding Window is the standard optimization over $O(N^2)$.
*Đối với các bài toán "đếm mảng con thỏa mãn điều kiện" dựa trên sự tích lũy, Cửa sổ trượt là sự tối ưu hóa chuẩn mực.*
---
*Tích lũy (Product) mang đến sự tăng trưởng, nhưng giới hạn (K) dạy ta cách dừng lại. Trong sự trải dài của những con số (Numbers), cửa sổ trượt (Sliding window) giúp ta cân bằng giữa sự mở rộng (Expansion) và sự kiềm chế (Contraction). Dữ liệu dạy ta rằng bằng cách đo lường từng mảng con ngay tại khoảnh khắc chúng vừa hình thành (Right-indexed counting), ta có thể thấu thị được toàn bộ những khả năng tiềm ẩn mà không bao giờ bị lạc lối.*
Accumulation (Product) brings growth, but the limit (K) teaches us how to stop. In the stretch of numbers (Numbers), the sliding window (Sliding window) helps us balance between expansion (Expansion) and restraint (Contraction). Data teaches us that by measuring each subarray at the very moment it forms (Right-indexed counting), we can see all latent possibilities without ever getting lost.
