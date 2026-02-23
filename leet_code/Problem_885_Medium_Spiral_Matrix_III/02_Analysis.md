# Analysis for Spiral Matrix III
# *Phân tích cho bài toán Ma trận Xoắn ốc III*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Simulate a spiral walk starting from `(rStart, cStart)` and record the order in which we visit valid grid cells. The walk continues even outside the grid boundaries.
*Mô phỏng một bước đi xoắn ốc bắt đầu từ `(rStart, cStart)` và ghi lại thứ tự chúng ta ghé thăm các ô hợp lệ trong lưới. Bước đi vẫn tiếp tục ngay cả khi ra ngoài biên giới của lưới.*

### KEY PATTERN
### *Mẫu hình quan trọng*
The spiral movement follows a specific pattern of step lengths:
- Move East 1 step.
- Move South 1 step.
- Move West 2 steps.
- Move North 2 steps.
- Move East 3 steps.
- Move South 3 steps.
- ...
The sequence of step lengths is: 1, 1, 2, 2, 3, 3, 4, 4, ...
*Chuyển động xoắn ốc tuân theo một mẫu độ dài bước cụ thể: Đông 1, Nam 1, Tây 2, Bắc 2, Đông 3, Nam 3... Dãy độ dài bước là: 1, 1, 2, 2, 3, 3, 4, 4, ...*

---

## 2. Strategy: Simulation
## *2. Chiến lược: Mô phỏng*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:**
    - `result` array of size `rows * cols`.
    - `count = 0` (number of valid cells visited).
    - `step = 1` (current leg length).
    - `directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]` (East, South, West, North).
    - `dirIdx = 0` (current direction index).
    - Start at `(r, c) = (rStart, cStart)`.
    - Add start cell to result if valid.
    *   **Khởi tạo:** Mảng kết quả, biến đếm, độ dài bước, hướng đi và vị trí bắt đầu.*

2.  **Loop:** While `count < rows * cols`:
    - For `k` from 0 to 1 (two legs for each step length):
        - Determine direction `d = directions[dirIdx]`.
        - Move `step` times in direction `d`.
        - After each single move, update `(r, c)`.
        - Check if `(r, c)` is inside grid boundaries. If yes, add to `result` and increment `count`.
        - `dirIdx = (dirIdx + 1) % 4`.
    - Increment `step`.
    *   **Vòng lặp:** Trong khi chưa thăm đủ số ô: Với mỗi độ dài bước, đi 2 lần (2 hướng khác nhau). Di chuyển từng ô một, nếu ô hợp lệ thì thêm vào kết quả. Sau 2 lần đổi hướng, tăng độ dài bước lên 1.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
    int[][] result = new int[rows * cols][2];
    int count = 0;
    int r = rStart, c = cStart;
    
    // Directions: East, South, West, North
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int dirIdx = 0; // Start facing East
    int stepLength = 1;
    
    // Add starting point
    result[count++] = new int[]{r, c};
    
    while (count < rows * cols) {
        // Move twice for each step length (e.g., 1 East, 1 South, then 2 West, 2 North)
        for (int i = 0; i < 2; i++) {
            for (int k = 0; k < stepLength; k++) {
                // Move one step
                r += dirs[dirIdx][0];
                c += dirs[dirIdx][1];
                
                // Check bounds
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    result[count++] = new int[]{r, c};
                }
            }
            // Change direction
            dirIdx = (dirIdx + 1) % 4;
        }
        // Increase step length after every two directions
        stepLength++;
    }
    
    return result;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\max(R, C)^2)$. We simulate the spiral path until it covers the entire grid. The spiral essentially expands in a square area.
    *   **Độ phức tạp thời gian:** $O(\max(R, C)^2)$. Chúng ta mô phỏng đường xoắn ốc cho đến khi nó bao phủ toàn bộ lưới.*
*   **Space Complexity:** $O(R \cdot C)$ for the output array.
    *   **Độ phức tạp không gian:** $O(R \cdot C)$ cho mảng kết quả.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simulation is the most direct way to solve path-following problems. Identifying the sequence `1, 1, 2, 2, 3, 3...` is key to implementing the spiral logic concisely.
*Mô phỏng là cách trực tiếp nhất để giải quyết các bài toán tuân theo đường đi. Việc nhận ra dãy số `1, 1, 2, 2, 3, 3...` là chìa khóa để triển khai logic xoắn ốc một cách ngắn gọn.*
