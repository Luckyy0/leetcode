# Analysis for Capacity To Ship Packages Within D Days
# *Phân tích cho bài toán Trọng tải chở hàng trong D ngày*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given an array of package weights, we need to partition the array into at most `days` contagious segments such that the maximum sum of any segment is minimized. The capacity must be large enough to hold the heaviest single package.
*Cho một mảng trọng lượng các kiện hàng, ta cần chia các phần tử liền kề của mảng thành nhiều nhất `days` các đoạn liên tiếp, sao cho tổng lớn nhất của mọi đoạn được làm cực tiểu. Năng lực chuyên chở của tàu ít nhất phải bằng kiện hảng nặng nhất trên băng chuyền.*

---

## 2. Strategy 1: Naive (Linear Search)
## *2. Chiến lược 1: Ngây thơ (Tìm kiếm tuyến tính)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive idea is to literally try every possible capacity `c`, starting from the minimum valid capacity (`c = max(weights)`) and incrementing by 1 until we find the first capacity `c` that can ship all packages in exactly `days` days or fewer. We need a helper method `canShip(weights, days, c)` to simulate sending packages.
*Ý tưởng ngây thơ là thử sức tải `c` chạy thật chậm từ thấp lên cao (Bắt đầu từ trọng lượng lớn nhất trong mảng). Cứ mỗi lần tăng `c` lên 1 đơn vị, tải toàn bộ băng chuyền lên tàu xem có chở kịp trong `days` ngày hay không. Hàm phụ `canShip(weights, days, c)` giả lập việc xếp hàng.*

```java
public class Solution {
    public int shipWithinDaysNaive(int[] weights, int days) {
        int maxWeight = 0;
        int totalWeight = 0;
        for (int w : weights) {
            maxWeight = Math.max(maxWeight, w);
            totalWeight += w;
        }
        
        // Thử từng tải trọng một
        for (int capacity = maxWeight; capacity <= totalWeight; capacity++) {
            if (canShip(weights, days, capacity)) {
                return capacity; // Capacity nhỏ nhất đáp ứng được!
            }
        }
        return totalWeight;
    }
    
    private boolean canShip(int[] weights, int days, int capacity) {
        int daysNeeded = 1;
        int currentLoad = 0;
        for (int w : weights) {
            if (currentLoad + w > capacity) {
                daysNeeded++;
                currentLoad = 0;
            }
            currentLoad += w;
        }
        return daysNeeded <= days;
    }
}
```

- **Weakness (Điểm yếu):** The maximum possible capacity is the sum of all elements in the array (up to $500 \times 5 \times 10^4 = 2.5 \times 10^7$). In the worst case, the loop `for (int capacity = maxWeight; ...)` could run tens of millions of times. Inside the loop, `canShip` scans the array ($N = 5 \times 10^4$). Therefore, the overall upper limit operations could hit a staggering $10^{12}$, unconditionally throwing a Time Limit Exceeded (TLE) error.
  *Sức tải vĩ đại nhất là tổng của tất cả các kiện hàng (lên tới con số khổng lồ $500 \times 5 \times 10^4 = 2.5 \times 10^7$). Ở tình huống xấu nhất, cái vòng lặp `for` bên ngoài sẽ chạy hai chục triệu lần. Mà bên trong vòng `for`, `canShip` lại quét cả cái mảng $N = 5 \times 10^4$. Cấp số nhân tung hoành đạt $10^{12}$ chu trình, tạch TLE sấp mặt.*

---

## 3. Strategy 2: Optimal (Binary Search on Answer)
## *3. Chiến lược 2: Tối ưu (Tìm kiếm Nhị phân trên khoảng Đáp án)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Notice that if a capacity `C` can ship all packages within `D` days, then any capacity strictly greater than `C` will undeniably also succeed in shipping the packages. This exhibits a **monotonic** property (false, false, false, ..., true, true, true).
Because of this monotonicity, we don't need a slow linear scan! We can unleash **Binary Search** over the realm of possible capacities. The search space bounds are exactly the array's max item (Lower Bound / `left`) and the array's total sum (Upper Bound / `right`). Halving the search space $O(\log(\text{Sum} - \text{Max}))$ instead of linearly iterating transforms tens of millions of steps into roughly ~25 steps!
*Hãy chú ý rằng nếu có một sức chứa `C` nào đó giao rảnh rỗi trong `D` ngày, thì bất kỳ sức chứa nào to hơn `C` cũng chắc chắn giao kịp. Tính chất này tạo ra một trục Không/Có tuyệt hảo: (F, F, F, ..., T, T, T, T). Đây là tín hiệu thần thánh của **Tính đơn điệu**!*
*Vì sự đơn điệu đó, ta xóa sổ việc tăng chầm chậm +1. Thay vào đó, áp dụng thẳng **Tìm kiếm nhị phân (Binary Search)** để khoanh vùng con số "T" đầu tiên.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Define Bounds:** `left` is the largest single weight (`max(weights)`), as the ship must be at least large enough to carry the heaviest package. `right` is the sum of all weights (`sum(weights)`), the capacity needed if we had only 1 day.
    *   *Kẻ vạch: `left` bằng trọng lượng kiện to nhất (tàu làm gì làm thì vẫn phải tải lọt kiện hàng ú nu nhất). `right` bằng tổng các kiện.*
2.  **Binary Search loop:** While `left <= right`:
    *   Find the middle point test capacity: `mid = left + (right - left) / 2`.
    *   Call `canShip(weights, days, mid)` to check.
    *   If it returns `true` (it can ship): This `mid` works, but there might be a lower capacity that also works. Shrink the ceiling: `right = mid - 1`.
    *   If it returns `false` (it's too small and took too many days): We MUST boost capacity. `left = mid + 1`.
    *   *Chiến thuật Nhị Phân: Lấy mốc giữa `mid`. Check xem tàu công suất `mid` này chở kịp không. Kịp thì ráng ép gắt xuống xíu nữa (`right = mid - 1`). Không kịp thì chứng tỏ tàu này nhỏ bé quá, mua vé tàu to hơn (`left = mid + 1`).*
3.  **Return `left`:** Once the binary search bounds cross, `left` will naturally rest at the smallest valid capacity.
    *   *Luật chia đôi: Khi `left` và `right` gác qua nhau, `left` chính là công suất tàu vừa vặn khít nhất.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        
        // Cưa đôi để tìm "Đáp án" (Capacity)
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canShip(weights, days, mid)) {
                right = mid - 1; // Tìm thử mốc nhỏ hơn
            } else {
                left = mid + 1; // Bắt buộc phải mướn tàu bự hơn
            }
        }
        
        return left;
    }
    
    private boolean canShip(int[] weights, int days, int capacity) {
        int daysNeeded = 1;
        int currentLoad = 0;
        
        for (int w : weights) {
            if (currentLoad + w > capacity) {
                daysNeeded++;
                currentLoad = w; // Đưa kiện hàng này qua chuyến của ngày mai
            } else {
                currentLoad += w;
            }
        }
        
        return daysNeeded <= days;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot \log(\text{Sum} - \text{Max}))$ where `Sum` is the total sum of weights, `Max` is the highest weight, and $N$ is the number of packages. Binary search effectively processes the search space in merely $\sim 25$ steps, executing an $O(N)$ linear array scan per step. Totally trivial.
    *   **Độ phức tạp thời gian:** $O(N \cdot \log(\text{Tổng} - \text{Lớn nhất}))$. Kỹ thuật cưa đôi dập tắt trục không gian siêu to và chỉ cho phép chạy khoảng 25 vòng quét. Mỗi vòng mượn tay quét kiểm kê đúng $O(N)$. Chạy siêu nhanh.*
*   **Space Complexity:** $O(1)$. Just pure bounds manipulation without any complex dynamic data structures.
    *   **Độ phức tạp không gian:** $O(1)$. Không phân rã mảng, không tái tạo lớp, không cấp thêm bộ nhớ ngoài biến tĩnh.*
