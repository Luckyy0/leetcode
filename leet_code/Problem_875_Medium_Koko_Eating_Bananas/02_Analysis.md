# Analysis for Koko Eating Bananas
# *Phân tích cho bài toán Koko Ăn Chuối*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the minimum speed $K$ (bananas per hour) such that Koko can finish all piles within $H$ hours. Speed $K$ can range from 1 to the maximum pile size ($10^9$).
*Tìm tốc độ $K$ (số quả chuối mỗi giờ) tối thiểu sao cho Koko có thể ăn hết tất cả các nải trong vòng $H$ giờ. Tốc độ $K$ có thể nằm trong khoảng từ 1 đến kích thước nải lớn nhất ($10^9$).*

---

## 2. Strategy: Binary Search on Answer
## *2. Chiến lược: Tìm kiếm nhị phân trên tập kết quả*

### Why Binary Search?
### *Tại sao dùng Tìm kiếm nhị phân?*
The total hours required to eat all bananas is a **monotonic decreasing** function of speed $K$. If Koko can finish with speed $K$, she can also finish with any speed $> K$. This property allows us to perform binary search on the value of $K$.
*Tổng số giờ cần thiết để ăn hết chuối là một hàm **giảm đơn điệu** theo tốc độ $K$. Nếu Koko có thể ăn xong với tốc độ $K$, cô ấy cũng có thể ăn xong với bất kỳ tốc độ nào $> K$. Đặc tính này cho phép chúng ta thực hiện tìm kiếm nhị phân trên giá trị của $K$.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Search Range:** `low = 1`, `high = max(piles)`.
    *   **Khởi tạo phạm vi tìm kiếm:** `low = 1`, `high = phần\_tử\_lớn\_nhất\_của\_mảng`.*

2.  **Binary Search Loop:**
    - Calculate `mid = low + (high - low) / 2`.
    - Calculate total hours needed with speed `mid`. For each pile, hours = `ceil(pile / mid)`.
    - If `totalHours <= h`: Koko can finish. Try picking a smaller speed: `high = mid`.
    - Else: Speed is too slow. Increase speed: `low = mid + 1`.
    *   **Vòng lặp tìm kiếm nhị phân:** Tính `mid`. Tính tổng số giờ cần thiết với tốc độ `mid`. Với mỗi nải, giờ = `(pile + mid - 1) / mid`. Nếu `tổng_giờ <= h`: Koko có thể hoàn thành. Thử tốc độ nhỏ hơn: `high = mid`. Ngược lại: Tốc độ quá chậm. Tăng tốc độ: `low = mid + 1`.*

3.  **Result:** The value `low` will be the minimum speed required.
    *   **Kết quả:** Giá trị `low` sẽ là tốc độ tối thiểu cần thiết.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int minEatingSpeed(int[] piles, int h) {
    int low = 1, high = 1000000000;
    while (low < high) {
        int mid = low + (high - low) / 2;
        if (canFinish(piles, h, mid)) {
            high = mid;
        } else {
            low = mid + 1;
        }
    }
    return low;
}

private boolean canFinish(int[] piles, int h, int k) {
    long hours = 0;
    for (int p : piles) {
        hours += (p + k - 1) / k;
    }
    return hours <= h;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log M)$, where $N$ is the number of piles and $M$ is the search range ($M = 10^9$). The binary search takes $\log(10^9) \approx 30$ iterations, and each iteration takes $O(N)$ to calculate total hours.
    *   **Độ phức tạp thời gian:** $O(N \log M)$, với $N$ là số nải và $M$ là phạm vi tìm kiếm. Tìm kiếm nhị phân tốn khoảng 30 lượt, mỗi lượt tốn $O(N)$ để tính tổng số giờ.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Binary search on answer is the most efficient way to solve optimization problems where a monotonic relationship exists between the input and the constraint.
*Tìm kiếm nhị phân trên tập kết quả là cách hiệu quả nhất để giải các bài toán tối ưu hóa khi có mối quan hệ đơn điệu giữa đầu vào và ràng buộc.*
