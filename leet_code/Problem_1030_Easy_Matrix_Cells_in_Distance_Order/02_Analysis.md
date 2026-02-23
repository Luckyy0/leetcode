# Analysis for Matrix Cells in Distance Order
# *Phân tích bài toán Ô Ma Trận Xếp Theo Khoảng Cách*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given a matrix of size `rows x cols` and a starting central coordinate `(rCenter, cCenter)`, return all possible cell coordinates in the matrix sorted by their Manhattan distance from the center. The Manhattan distance between `(r1, c1)` and `(r2, c2)` is `|r1 - r2| + |c1 - c2|`.
*Cho một ma trận kích thước `rows x cols` và tọa độ trung tâm xuất phát `(rCenter, cCenter)`, hãy trả về tất cả các tọa độ ô trong ma trận, được sắp xếp theo cự ly khoảng cách Manhattan tính từ tâm. Khoảng cách Manhattan giữa `(r1, c1)` và `(r2, c2)` là `|r1 - r2| + |c1 - c2|`.*

---

## 2. Strategy 1: Naive (Generate and Sort)
## *2. Chiến lược 1: Ngây Thơ (Tạo và Sắp xếp)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive idea simply iterates through all `rows x cols`, pushes every coordinate into a massive array, and finally sorts this array entirely using a custom comparator based on the Manhattan distance computed against the central point.
*Cách tiếp cận nguyên thủy là cứ duyệt qua tất cả các ô trong ma trận `rows x cols`, nhét hết toàn bộ vào một mảng khổng lồ, rồi gọi Hàm sắp xếp toàn mảng đó dựa trên bộ so sánh từ khoảng cách Manhattan đến tâm.*

```java
public class Solution {
    public int[][] allCellsDistOrderNaive(int rows, int cols, int rCenter, int cCenter) {
        int[][] res = new int[rows * cols][2];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i * cols + j] = new int[]{i, j};
            }
        }
        Arrays.sort(res, (a, b) -> {
            int distA = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int distB = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);
            return Integer.compare(distA, distB);
        });
        return res;
    }
}
```

- **Weakness:** The sorting step governs the ultimate time complexity, dragging it down to $O(N \log N)$ where $N = \text{rows} \times \text{cols}$. While acceptable for arrays up to $100 \times 100$, the algorithm lacks spatial awareness and does not take advantage of the concentric rings of natural grid expansion.
- ***Điểm yếu:** Khâu Sắp xếp ở cuối sẽ rút cạn thời gian chạy xuống còn $O(N \log N)$ (với N là tổng số ô). Dù vẫn đủ nhanh để qua bài, thuật toán phàm phu này đã bỏ lỡ Không gian Địa lý và Vòng phân bố bức xạ tự nhiên xung quanh tâm vòng xoáy.*

---

## 3. Strategy 2: Optimal (Breadth-First Search - BFS)
## *3. Chiến lược 2: Tối ưu (Duyệt theo chiều rộng - BFS)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Why globally sort randomly located coordinates when a BFS automatically traverses the grid layer by layer, concentrically radiating precisely by mathematical distance from the epicenter?
*Tại sao phải đánh đồng toàn mảng rồi bắt máy tính đi sắp xếp, trong khi thuật toán BFS (Duyệt theo chiều rộng) đương nhiên sẽ lan tỏa ra thành từng vòng lớp, tuần tự bọc sát lấy nhau theo thứ tự Tăng Dần tuyệt đối của Cự Ly? Nước dâng tới đâu, bắt cá bỏ túi tới đó!*

By explicitly launching a conventional BFS Queue seeded from `(rCenter, cCenter)`, every distinct neighbor is iteratively enqueued. The queue automatically enforces order. Nodes closer to the center are processed and permanently stored into the result output array before coordinates positioned further out mathematically.
*Sử dụng BFS và Hàng Đợi (Queue). Đầu tiên nhét cái Tâm `(rCenter, cCenter)` vào hàng đợi và cấu hình "Đã Tham Quan" (Visited). Lôi từng đứa trong Queue ra nhét trực tiếp vào kết quả $\rightarrow$ Tiếp tục lan ra 4 Thằng Bạn Bốn Bên (NẾU CHƯA THĂM). Tính chất bất hủ của BFS ĐẢM BẢO rằng đứa Nào Gần Tâm Hơn sẽ rớt vào mảng kết quả sớm hơn Trăm Phần Trăm!*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] res = new int[rows * cols][2];
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{rCenter, cCenter});
        visited[rCenter][cCenter] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int index = 0;

        while (!queue.isEmpty()) {
            int[] currentCell = queue.poll(); 
            res[index++] = currentCell;       

            int r = currentCell[0];
            int c = currentCell[1];

            for (int[] dir : directions) {
                int neighborR = r + dir[0];
                int neighborC = c + dir[1];

                if (neighborR >= 0 && neighborR < rows &&
                    neighborC >= 0 && neighborC < cols &&
                    !visited[neighborR][neighborC]) {

                    visited[neighborR][neighborC] = true;  
                    queue.offer(new int[]{neighborR, neighborC}); 
                }
            }
        }
        return res;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N = \text{rows} \times \text{cols}$. Every matrix square structurally enters the BFS validation layer and output array correctly exactly once.
*   *   **Độ phức tạp thời gian:** $O(N)$. Vượt qua mỗi nút đúng một lần định mệnh. Thuật BFS nhặt đúng $N$ Ô không phát sinh thêm khâu sắp xếp nên chỉ tốn $O(N)$ Sắc bén.*
*   **Space Complexity:** $O(N)$, since storing the `visited` array consumes direct proportional bounds corresponding directly strictly to the matrix.
*   *   **Độ phức tạp không gian:** $O(N)$. Mảng cờ Đánh Dấu `visited` 2 chiều được lấp bằng y nguyên chu vi diện tích Ruộng $M \times N$. Túi Queue cũng hút RAM lên ngang ngưỡng giới hạn.*
