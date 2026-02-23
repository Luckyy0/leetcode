# Analysis for Minimum Number of Refueling Stops
# *Phân tích cho bài toán Số lần Dừng tiếp nhiên liệu Tối thiểu*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Reach a destination `target` miles away with minimum refueling stops. We have an initial `startFuel` and gas stations $[pos, fuel]$ along the way.
*Đến được điểm đích cách xa `target` dặm với số lần dừng tiếp nhiên liệu ít nhất. Chúng ta có nhiên liệu ban đầu `startFuel` và các trạm xăng $[pos, fuel]$ dọc đường.*

---

## 2. Strategy: Greedy with Max-Heap
## *2. Chiến lược: Tham lam với Hàng đợi ưu tiên (Max-Heap)*

### Key Concept
### *Khái niệm chính*
Think of it this way: instead of deciding to refuel **at** a station, we "carry" the stations with us as we pass them. If we run out of fuel before reaching the next station or the target, we look back at all the stations we've passed and pick the one with the **most fuel** to refuel from.
*Hãy nghĩ theo cách này: thay vì quyết định đổ xăng **tại** một trạm, chúng ta "mang theo" các trạm đó khi đi ngang qua. Nếu hết xăng trước khi đến trạm tiếp theo hoặc đích, chúng ta nhìn lại tất cả các trạm đã đi qua và chọn trạm có **nhiều xăng nhất** để tiếp nhiên liệu.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** 
    - `maxHeap`: Stores the fuel amounts of stations we have passed but not yet used.
    - `stops`: Count of refueling stops.
    - `currFuel`: Total distance we can travel with current fuel.
    - `stationIdx`: Index in the `stations` array.
    *   **Khởi tạo:** `maxHeap` lưu trữ lượng xăng của các trạm đã đi qua nhưng chưa sử dụng. `stops` là số lần dừng. `currFuel` là tổng quãng đường có thể đi với lượng xăng hiện tại.*

2.  **Drive through stations:**
    - While `currFuel < target`:
        - Add all stations reachable with `currFuel` to the `maxHeap`.
        - If `maxHeap` is empty and we still haven't reached the next station/target, it's impossible. Return `-1`.
        - Pop the max fuel from `maxHeap`, add to `currFuel`, and increment `stops`.
    *   **Đi qua các trạm:** Khi `currFuel < target`: Thêm tất cả các trạm có thể đạt tới với `currFuel` vào `maxHeap`. Nếu `maxHeap` trống và vẫn chưa tới được mốc tiếp theo, trả về -1. Lấy lượng xăng lớn nhất từ `maxHeap`, cộng vào `currFuel`, và tăng số lần dừng.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int minRefuelStops(int target, int startFuel, int[][] stations) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    int res = 0, curr = startFuel, i = 0, n = stations.length;
    
    while (curr < target) {
        while (i < n && stations[i][0] <= curr) {
            pq.offer(stations[i][1]);
            i++;
        }
        if (pq.isEmpty()) return -1;
        curr += pq.poll();
        res++;
    }
    return res;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$, where $N$ is the number of stations. Each station is added to and removed from the priority queue at most once.
    *   **Độ phức tạp thời gian:** $O(N \log N)$, vì mỗi trạm được thêm và xóa khỏi hàng đợi ưu tiên tối đa một lần.*
*   **Space Complexity:** $O(N)$ for the priority queue.
    *   **Độ phức tạp không gian:** $O(N)$ cho hàng đợi ưu tiên.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

This lazy refueling strategy is a classic greedy pattern. By only refueling when absolutely necessary and always picking the largest available amount, we guarantee the minimum number of stops.
*Chiến lược tiếp nhiên liệu "lười biếng" này là một mô hình tham lam kinh điển. Bằng cách chỉ đổ xăng khi tuyệt đối cần thiết và luôn chọn lượng xăng lớn nhất hiện có, chúng ta đảm bảo số lần dừng là tối thiểu.*
