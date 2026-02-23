# Analysis for Maximum Average Subarray II
# *Phân tích cho bài toán Mảng con có Trung bình cộng Lớn nhất II*

## 1. Problem Essence & Variable Window Size
## *1. Bản chất vấn đề & Kích thước Cửa sổ Biến đổi*

### The Challenge
### *Thách thức*
We need to find a subarray of length $L \ge k$ that maximizes the average value. Unlike the "Easy" version, the window size is not fixed, making a simple sliding window insufficient.
*Chúng ta cần tìm một mảng con có độ dài $L \ge k$ để tối đa hóa giá trị trung bình. Không giống như phiên bản "Dễ", kích thước cửa sổ ở đây không cố định, khiến việc sử dụng cửa sổ trượt đơn giản là không đủ.*

---

## 2. Strategy: Binary Search on Answer
## *2. Chiến lược: Tìm kiếm nhị phân trên Kết quả*

If we guess a potential average value `mid`, we want to check if there exists *any* subarray of length $\ge k$ with an average $\ge mid$.
*Nếu chúng ta đoán một giá trị trung bình tiềm năng `mid`, chúng ta muốn kiểm tra xem có tồn tại *bất kỳ* mảng con nào có độ dài $\ge k$ với giá trị trung bình $\ge mid$ hay không.*

### Mathematical Transformation
### *Biến đổi Toán học*
$\frac{\sum_{i=j}^{j+L-1} nums[i]}{L} \ge mid \iff \sum_{i=j}^{j+L-1} (nums[i] - mid) \ge 0$
*By subtracting `mid` from every element, the problem becomes: Is there a subarray of length $\ge k$ with a non-negative sum?*
*Bằng cách trừ `mid` khỏi mỗi phần tử, bài toán trở thành: Liệu có mảng con nào độ dài $\ge k$ có tổng không âm không?*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Binary Search Range:** `low` = min value in `nums`, `high` = max value in `nums`.
    * **Phạm vi Tìm kiếm Nhị phân:** `low` là giá trị nhỏ nhất, `high` là giá trị lớn nhất trong mảng.*

2.  **`check(mid)` Function:**
    * **Hàm `check(mid)`:** *
    - Create a modified array (conceptually) where $B[i] = nums[i] - mid$.
    - Use a prefix sum approach with a sliding window of at least $k$ elements.
    - `sum` = prefix sum of $B$.
    - `prevSum` = prefix sum up to `i - k`.
    - `minPrevSum` = the minimum value of `prevSum` seen so far.
    - If `sum[i] - minPrevSum >= 0`, then a valid subarray exists. Return `true`.

3.  **Iteration:** Loop until the difference between `high` and `low` is smaller than $10^{-5}$.
    * **Vòng lặp:** Tiếp tục cho đến khi sự khác biệt giữa `high` và `low` nhỏ hơn $10^{-5}$.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Convergence:** Binary search on the answer converges quickly. For a range of $20000$ and precision $10^{-5}$, it takes about 30-40 iterations.
    * **Sự hội tụ:** Tìm kiếm nhị phân trên kết quả hội tụ nhanh chóng. Với phạm vi 20000 và độ chính xác $10^{-5}$, tốn khoảng 30-40 lần lặp.*
*   **Linear Check:** The `check` function runs in $O(N)$, making the total complexity $O(N \log(\text{range}/\epsilon))$.
    * **Kiểm tra Tuyến tính:** Hàm `check` chạy trong $O(N)$, làm cho tổng độ phức tạp là tuyến tính nhân với logarit.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log(\frac{Max-Min}{10^{-5}}))$.
    * **Độ phức tạp thời gian:** $O(N \log(\frac{Max-Min}{10^{-5}}))$.*
*   **Space Complexity:** $O(1)$. We can perform the check using rolling sums without actually creating a new array.
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Visualized Dry Run (Check Idea)
## *5. Chạy thử bằng Hình ảnh (Ý tưởng Kiểm tra)*

**Nums:** [1, 12, -5, -6], k=2, Mid=3
1. B: [-2, 9, -8, -9]
2. Initial sum (k=2): sum = -2 + 9 = 7. 
3. currentPrefixSum = 7. minPrevSum = 0 (before start).
4. Since 7 - 0 >= 0, **true**. An average of at least 3 exists (e.g., [1, 12] avg 6.5).

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Whenever a problem asks for an optimal "average" or "ratio", consider shifting the perspective by subtracting the target value. This transformation often turns the problem into a simpler sum-based search.
*Bất cứ khi nào bài toán yêu cầu tìm "trung bình" hoặc "tỷ lệ" tối ưu, hãy cân nhắc chuyển đổi góc nhìn bằng cách trừ đi giá trị mục tiêu.*
---
*Sự cân bằng (Average) không phải là sự cố định, mà là một mục tiêu dịch chuyển. Trong toán học, việc đi tìm mức trung bình tối đa (Max Average) trong một phạm vi linh hoạt đòi hỏi ta phải đặt ra những giả thuyết (Binary search) và kiểm chứng tính khả thi của chúng. Dữ liệu dạy ta rằng bằng cách đo lường độ lệch (nums[i] - mid), ta có thể thấu hiểu được thực tại nằm ở đâu trong dải khả năng.*
Balance (Average) is not a fixed point, but a shifting goal. In mathematics, searching for the maximum average (Max Average) in a flexible range requires us to propose hypotheses (Binary search) and verify their feasibility. Data teaches us that by measuring deviations (nums[i] - mid), we can understand where reality lies within the range of possibilities.
