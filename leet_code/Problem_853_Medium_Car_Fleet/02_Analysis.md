# Analysis for Car Fleet
# *Phân tích cho bài toán Đội xe*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to determine the number of distinct fleets arriving at the target. Cars closer to the target dictate the speed of those behind them if caught up. A car `A` behind `B` forms a fleet with `B` if `A` reaches the target at the same time or before `B` would if it were alone.
*Chúng ta cần xác định số lượng đội xe riêng biệt đến đích. Những chiếc xe ở gần đích hơn sẽ quyết định tốc độ của những chiếc xe phía sau nếu bị đuổi kịp. Một chiếc xe `A` đằng sau `B` tạo thành một đội xe với `B` nếu `A` đến đích cùng lúc hoặc trước `B` (giả sử `B` chạy một mình).*

---

## 2. Strategy: Sorting & Time Calculation
## *2. Chiến lược: Sắp xếp & Tính toán thời gian*

### Key Concept
### *Khái niệm chính*
The most important factor is the **time taken** to reach the target. Let $time[i] = (target - position[i]) / speed[i]$.
*Yếu tố quan trọng nhất là **thời gian cần thiết** để đến đích. Gọi $time[i] = (target - position[i]) / speed[i]$.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Pair and Sort:** Pair each car's position with its speed and sort these pairs by position in **descending order** (closest to the target first).
    *   **Ghép đôi và Sắp xếp:** Ghép vị trí của mỗi chiếc xe với tốc độ của nó và sắp xếp các cặp này theo vị trí theo **thứ tự giảm dần** (gần đích nhất trước).*

2.  **Calculate Arrival Times:** Iterate through the sorted cars and calculate their arrival times.
    *   **Tính thời gian đến:** Duyệt qua các xe đã sắp xếp và tính thời gian đến của chúng.*

3.  **Count Fleets:** 
    - Maintain a variable `maxTime` representing the arrival time of the current fleet leader.
    - If the current car's time is greater than `maxTime`, it cannot catch up to the fleet ahead. It becomes the leader of a **new fleet**. Update `maxTime` and increment the fleet count.
    - If the current car's time is less than or equal to `maxTime`, it catches up and becomes part of the existing fleet.
    *   **Đếm đội xe:** Duy trì một biến `maxTime` đại diện cho thời gian đến của trưởng đội xe hiện tại. Nếu thời gian của chiếc xe hiện tại lớn hơn `maxTime`, nó không thể đuổi kịp đội xe phía trước. Nó trở thành trưởng của một **đội xe mới**. Cập nhật `maxTime` và tăng số lượng đội xe. Nếu thời gian của chiếc xe hiện tại nhỏ hơn hoặc bằng `maxTime`, nó sẽ đuổi kịp và trở thành một phần của đội xe hiện tại.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int carFleet(int target, int[] position, int[] speed) {
    int n = position.length;
    double[][] cars = new double[n][2];
    for (int i = 0; i < n; i++) {
        cars[i][0] = position[i];
        cars[i][1] = (double)(target - position[i]) / speed[i];
    }
    
    // Sort by position descending
    Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
    
    int fleets = 0;
    double maxTime = 0;
    for (int i = 0; i < n; i++) {
        if (cars[i][1] > maxTime) {
            fleets++;
            maxTime = cars[i][1];
        }
    }
    return fleets;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \log N)$ due to sorting the positions. The linear scan takes $O(N)$.
    *   **Độ phức tạp thời gian:** $O(N \log N)$ do sắp xếp các vị trí. Lượt duyệt tuyến tính tốn $O(N)$.*
*   **Space Complexity:** $O(N)$ to store the position-time pairs.
    *   **Độ phức tạp không gian:** $O(N)$ để lưu trữ các cặp vị trí-thời gian.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]`
1. (Pos 10, Time 1.0)
2. (Pos 8, Time 1.0) -> Same as leader, 1 fleet.
3. (Pos 5, Time 7.0) -> New leader, 2 fleets.
4. (Pos 3, Time 3.0) -> Faster than leader, part of fleet.
5. (Pos 0, Time 12.0) -> New leader, 3 fleets.
**Result:** 3 fleets.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Sorting cars by position from target is the key. Those ahead define the "blocking" time for those behind.
*Sắp xếp xe theo vị trí từ đích là chìa khóa. Những xe đi trước xác định thời gian "chặn" cho những xe đi sau.*
