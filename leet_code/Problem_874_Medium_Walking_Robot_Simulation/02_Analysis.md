# Analysis for Walking Robot Simulation
# *Phân tích cho bài toán Mô phỏng Robot Di chuyển*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Simulate a robot's movement on a 2D plane with obstacles. We need to track the maximum squared distance $x^2 + y^2$ ever reached.
*Mô phỏng chuyển động của robot trên mặt phẳng 2D có chướng ngại vật. Chúng ta cần theo dõi bình phương khoảng cách tối đa $x^2 + y^2$ từng đạt được.*

---

## 2. Strategy: Simulation with Set Lookup
## *2. Chiến lược: Mô phỏng với Tra cứu Tập hợp*

### Representing Directions
### *Biểu diễn hướng*
Use an array `dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]` (North, East, South, West).
- Turn Right: `d = (d + 1) % 4`
- Turn Left: `d = (d + 3) % 4`
*Sử dụng mảng `dirs` để lưu 4 hướng. Rẽ phải: `d = (d + 1) % 4`. Rẽ trái: `d = (d + 3) % 4`.*

### Handling Obstacles
### *Xử lý chướng ngại vật*
To check for obstacles in $O(1)$, store them in a `HashSet`. Since coordinates are integers, we can store them as strings `"x,y"` or pack them into a `long`: `(x + 30000) * 60001 + (y + 30000)`.
*Để kiểm tra chướng ngại vật trong $O(1)$, hãy lưu chúng trong `HashSet`. Có thể lưu dưới dạng chuỗi "x,y" hoặc nén vào một số kiểu `long`.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `x=0, y=0, direction=0` (North), `maxDist=0`.
    *   **Khởi tạo:** Vị trí (0,0), hướng Bắc, khoảng cách tối đa = 0.*

2.  **Process Commands:**
    - If command is turn: update `direction`.
    - If command is move $k$:
        - For each step (1 to $k$):
            - Calculate next position `nx, ny`.
            - If `(nx, ny)` is an obstacle, break the loop.
            - Else, update `x = nx, y = ny` and calculate new distance squared.
    *   **Xử lý lệnh:** Nếu là lệnh quay: cập nhật `direction`. Nếu là lệnh di chuyển $k$ bước: Với mỗi bước, tính vị trí tiếp theo. Nếu là chướng ngại vật thì dừng lại. Ngược lại, cập nhật vị trí và tính bình phương khoảng cách.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int robotSim(int[] commands, int[][] obstacles) {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    Set<String> obstacleSet = new HashSet<>();
    for (int[] obs : obstacles) {
        obstacleSet.add(obs[0] + "," + obs[1]);
    }
    
    int x = 0, y = 0, d = 0, maxDistSq = 0;
    for (int cmd : commands) {
        if (cmd == -2) d = (d + 3) % 4;
        else if (cmd == -1) d = (d + 1) % 4;
        else {
            for (int i = 0; i < cmd; i++) {
                int nx = x + dirs[d][0];
                int ny = y + dirs[d][1];
                if (!obstacleSet.contains(nx + "," + ny)) {
                    x = nx; y = ny;
                    maxDistSq = Math.max(maxDistSq, x * x + y * y);
                } else break;
            }
        }
    }
    return maxDistSq;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(C \cdot K + O)$, where $C$ is number of commands, $K$ is max steps (9), and $O$ is number of obstacles. Total complexity is roughly $10^4 \cdot 10 + 10^4 = O(10^5)$.
    *   **Độ phức tạp thời gian:** $O(C \cdot K + O)$, xấp xỉ $O(10^5)$.*
*   **Space Complexity:** $O(O)$ to store obstacles in a set.
    *   **Độ phức tạp không gian:** $O(O)$ để lưu trữ chướng ngại vật.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Using a set for obstacle lookup is essential to avoid an $O(\text{commands} \cdot \text{obstacles})$ complexity.
*Sử dụng tập hợp để tra cứu chướng ngại vật là yếu tố quan trọng để tránh độ phức tạp $O(C \cdot O)$.*
