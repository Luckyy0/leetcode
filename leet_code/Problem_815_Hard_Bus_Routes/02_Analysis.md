# Analysis for Bus Routes
# *Phân tích cho bài toán Các tuyến xe buýt*

## 1. Problem Essence & BFS on Buses
## *1. Bản chất vấn đề & BFS trên các tuyến xe*

### The Challenge
### *Thách thức*
We need to find the minimum number of buses to get from `source` to `target`. Each bus route can be thought of as a set of connected stops. This is a shortest path problem in a graph where nodes can be either stops or buses. However, since the goal is to minimize the number of **buses**, it is more efficient to treat each **bus** as a node in our BFS.
*Chúng ta cần tìm số lượng xe buýt tối thiểu để đi từ `source` đến `target`. Mỗi tuyến xe buýt có thể được coi là một tập hợp các điểm dừng được kết nối. Đây là bài toán tìm đường đi ngắn nhất trong một đồ thị nơi các nút có thể là trạm dừng hoặc xe buýt. Tuy nhiên, vì mục tiêu là tối thiểu hóa số lượng **xe buýt**, sẽ hiệu quả hơn nếu coi mỗi **tuyến xe** là một nút trong BFS của chúng ta.*

---

## 2. Strategy: Breadth-First Search (BFS)
## *2. Chiến lược: Tìm kiếm theo chiều rộng (BFS)*

### Why BFS?
### *Tại sao dùng BFS?*
BFS is the standard algorithm for finding the shortest path in an unweighted graph. Here, each "edge" is a transfer between buses at a shared stop, representing one additional bus taken.
*BFS là thuật toán tiêu chuẩn để tìm đường đi ngắn nhất trong đồ thị không trọng số. Ở đây, mỗi "cạnh" là một lần chuyển xe giữa các tuyến tại một trạm dừng chung, đại diện cho việc đi thêm một chiếc xe buýt.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Stop-to-Bus Mapping:** Create a `Map<Integer, List<Integer>>` where the key is a stop ID and the value is a list of bus indices that pass through that stop.
    *   **Bản đồ Trạm-Xe:** Tạo một `Map` lưu trữ: khóa là ID trạm, giá trị là danh sách các chỉ số xe buýt đi qua trạm đó.*

2.  **Initialize BFS:**
    - If `source == target`, return `0`.
    - Push all buses that pass through the `source` stop into a `Queue`.
    - Mark these buses as `visited`.
    - Set `busCount = 1`.
    *   **Khởi tạo BFS:** Nếu `source == target`, trả về 0. Đưa tất cả các xe buýt đi qua trạm `source` vào `Queue`. Đánh dấu đã thăm và đặt `busCount = 1`.*

3.  **Process BFS:**
    - For each level (bus count):
      - For each bus in the current queue:
        - Check every stop in this bus's route.
        - If the stop is `target`, return current `busCount`.
        - For each stop:
          - Find all other buses that pass through this stop.
          - If a bus hasn't been visited, mark it `visited` and add it to the `Queue`.
    - After processing a level, increment `busCount`.
    *   **Xử lý BFS:** Với mỗi cấp độ (số xe): Duyệt các xe trong hàng đợi. Kiểm tra mọi trạm trên tuyến của xe đó. Nếu thấy `target`, trả về `busCount`. Với mỗi trạm, tìm các xe khác đi qua trạm đó mà chưa được thăm để thêm vào hàng đợi. Tăng `busCount` sau mỗi cấp độ.*

4.  **Failure Case:** If the queue is empty and we haven't reached `target`, return `-1`.
    *   **Trường hợp thất bại:** Nếu hàng đợi trống mà chưa đến được mục tiêu, trả về -1.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int numBusesToDestination(int[][] routes, int source, int target) {
    if (source == target) return 0;
    
    // Map stop to list of buses that pass through it
    Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
    for (int bus = 0; bus < routes.length; bus++) {
        for (int stop : routes[bus]) {
            stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(bus);
        }
    }
    
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visitedBuses = new HashSet<>();
    Set<Integer> visitedStops = new HashSet<>();
    
    // Initial: collect all buses passing through source
    if (!stopToBuses.containsKey(source)) return -1;
    for (int bus : stopToBuses.get(source)) {
        queue.offer(bus);
        visitedBuses.add(bus);
    }
    
    int count = 1;
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int bus = queue.poll();
            for (int stop : routes[bus]) {
                if (stop == target) return count;
                // For each stop on this bus route, find other buses
                if (visitedStops.contains(stop)) continue;
                visitedStops.add(stop);
                
                for (int nextBus : stopToBuses.getOrDefault(stop, new ArrayList<>())) {
                    if (!visitedBuses.contains(nextBus)) {
                        visitedBuses.add(nextBus);
                        queue.offer(nextBus);
                    }
                }
            }
        }
        count++;
    }
    return -1;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\sum routes[i].length)$. Each stop is visited once when its bus list is processed, and each bus is visited once.
    *   **Độ phức tạp thời gian:** $O(N)$, với $N$ là tổng số điểm dừng trong tất cả các tuyến. Mỗi trạm và mỗi xe được xử lý một lần.*
*   **Space Complexity:** $O(\sum routes[i].length)$ to store the stop-to-bus mapping and visited sets.
    *   **Độ phức tạp không gian:** $O(N)$, để lưu trữ bản đồ ánh xạ và các tập hợp đã thăm.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `routes = [[1,2,7],[3,6,7]], source = 1, target = 6`
1. Stop 1: Bus 0.
2. Stop 7: Bus 0, Bus 1.
3. Stop 6: Bus 1.
4. BFS Level 1: Start Bus 0 (passes through 1).
5. Bus 0 stops: 1, 2, 7.
   - At stop 7, find Bus 1. Add Bus 1 to queue.
6. BFS Level 2: Pop Bus 1.
   - Bus 1 stops: 3, 6, 7.
   - Found stop 6 (target)!
**Result:** 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

BFS on bus routes (rather than on stops) is the most efficient strategy because there are far fewer buses ($\le 500$) than stops ($10^6$). Using `visited` sets for both buses and stops ensures we don't process redundant paths, keeping the complexity linear relative to the total number of route entries.
*BFS trên các tuyến xe buýt (thay vì trên các trạm) là chiến lược hiệu quả nhất vì có ít tuyến xe ($\le 500$) hơn nhiều so với các trạm ($10^6$). Sử dụng tập hợp `visited` cho cả xe buýt và trạm đảm bảo chúng ta không xử lý lặp lại các đường đi dư thừa, giữ cho độ phức tạp tuyến tính so với tổng số mục nhập tuyến đường.*
