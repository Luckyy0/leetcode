# Analysis for Number of Enclaves
# *Phân tích cho bài toán Số lượng Vùng đất kín*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
In a binary grid where `1` holds Land and `0` holds Water, an enclave is an island of land surrounded entirely by water, trapping anyone inside from walking off the physical edges of the map. We must count how many total contiguous units of land (`1`s) belong exclusively to these landlocked enclaves.
*Trong một mạng lưới ma trận Nhị phân quy định `1` là Đất và `0` là Biển, một vùng nội khu (enclave) là dải Đất bị Vùng Nước bủa vây tứ phía, khóa chặt bất kỳ ai bên trong thoát ra mép bản đồ. Mục tiêu: Đếm có tổng bao nhiêu viên gạch ô vuông Đất Liền (`1`) thuộc về những cái khóa đó bị cách ly hoàn toàn!*

---

## 2. Strategy 1: Naive (Inner Island Search)
## *2. Chiến lược 1: Ngây thơ (Cày đảo hướng nội)*

### Idea and Weakness
### *Ý tưởng và Điểm yếu*

The naive idea is to traverse the entire grid. Every time we encounter an unvisited land cell `1`, we instigate a Breadth-First Search (BFS) or Depth-First Search (DFS) expansion trying to gauge the island's size. Simultaneously during the search, we carefully track if any edge cell pushes out of the grid bounds! If it touches the very map boundaries, we flag this specific island component as `false` (Not an Enclave) and discard the accumulated count. If it stays entirely within the water borders, we add the size of the island to the aggregate sum!
*Ý tưởng thuần phát là cới toàn bộ đồng ruộng. Bất cứ khi nào giẫm lên ô Đất `1` lạ hoắc, mình xòe thuật toán Loang rễ BFS/DFS ra xem đảo rộng bao nhiêu ô. Cùng lúc tung rễ, căng mắt ra trông chừng xem rễ có đâm xuyên mép tường bản đồ không! Nếu có một mảnh chọc thủng mép viền, tức là cả hòn đảo này Thất Thủ (`false`), hủy bỏ hết số đếm diện tích bừa này. Ngược lại nếu cả chuỗi tìm kiếm chỉ loay hoay trong khu nội cảnh thì mới đúc kết cộng tổng `sum`.*

```java
public class Solution {
    int currentIslandSize = 0;
    boolean reachesBoundary = false;
    
    public int numEnclavesNaive(int[][] grid) {
        int enclosedCount = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    currentIslandSize = 0;
                    reachesBoundary = false;
                    
                    dfs(grid, visited, i, j);
                    
                    if (!reachesBoundary) {
                        enclosedCount += currentIslandSize;
                    }
                }
            }
        }
        return enclosedCount;
    }
    
    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            reachesBoundary = true;
            return;
        }
        if (grid[i][j] == 0 || visited[i][j]) return;
        
        visited[i][j] = true;
        currentIslandSize++;
        
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }
}
```

- **Weakness (Điểm yếu):** Very rigid branching logic. The `reachesBoundary` flag gets messy and involves tracking lots of scattered global states or deep recursive parameter passing. We still have to blindly run DFS extensively on ALL islands, both enclosed and boundary ones. Computationally, it's $O(M \times N)$ but extremely clumsy in implementation footprint. 
  *(Code dài ngoằn ngoèo, cực kỳ cồng kềnh bộ máy biến số ngoại viện. Quản lý trạng thái Thủng viền `reachesBoundary` cực kì đau đầu và tiềm ẩn rủi ro logic sai sót do mớ code đệ quy vướng víu trả biến. Không chỉ thế, nó còn chui gầm quét DFS bừa bãi mọi hòn đảo (kể cả những khu đảo ven viền cực rộng) mà dã tràng xe cát! Xài dỡ tệ).*

---

## 3. Strategy 2: Optimal (Reverse Flood-Fill from Borders)
## *3. Chiến lược 2: Tối ưu (Tràn nước úng ngược từ Rìa Biên)*

### How it solves the weakness
### *Cách nó giải quyết điểm yếu*

Let's flip the perspective brilliantly! If we know exactly that ANY land cell structurally connected to the 4 map boundaries is eternally safe from being an enclave... why don't we just purposefully walk around the VERY PERIMETER (top, bottom, left, right edges) of the grid? 
When standing on a perimeter cell, if we see Land `1`, we trigger a devastating **DFS/Flood-Fill tsunami** that sinks that entire connected island mass, converting it completely into Water `0`! 
After this systematic border patrol, the ONLY land blocks surviving out there in the map MUST mathematically be the enclosed enclaves that edge floods couldn't touch!
Finally, just a simple double iteration over the grid counting the remaining `1`s yields the precise enclosed area perfectly. So smart and clean!

*Hãy "Lật ngược bàn cờ" thần thánh! Nếu ta biết chắc chắn MỘT ĐIỀU RẰNG mọi tấc đất dính liền với 4 vách tường ĐỀU THOÁT NẠN, vậy sao mình không cho binh lính đi rào DỌC THEO BỜ TƯỜNG nhỉ?*
*Rảo bước trên Mép viền bản đồ (trên cùng, dưới cùng, vách trái, vách phải). Cứ bám mép thấy có mô Đất `1`, ta gọi một cơn "TSUNAMI LỤT NGƯỢC DFS". Phép thuật này sẽ loang lở dìm xuống gạch nát bét cả chuỗi Lục địa nào dám bén mảng rễ vô sát tường Biên, Nhấn chìm nó lật mặt thành Nước Nông `0`!*
*Sau màn càn quét Viền khủng khiếp này, phần Lõi Nặng của Khu Đất vĩ đại kia đã BỊ DỘI RỬA SẠCH SẼ. Những gì THOI THÓP SỐNG SÓT ở khoảng giữa Bản Đồ CHẮC CHẮN 100% LÀ NHỮNG VÙNG ĐẤT NỘI KHU KÍN MÍT (Vì rễ nó không vươn ra tường nổi để bị lũ quét tràn vào).*
*Công đoạn cuối: Gẩy vòng lặp nhẹ quét giữa nhà, đếm xem sót bao nhiêu cái Đất `1` là chốt kèo chiến thắng. Siêu sạch - Siêu ảo.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
public class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Càn quét lũ Tsunami cột Dọc (Trái và Phải)
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) dfsSink(grid, i, 0); // Vách trái
            if (grid[i][n - 1] == 1) dfsSink(grid, i, n - 1); // Vách phải
        }
        
        // Càn quét lũ Tsunami hàng Ngang (Chóp trên và Đáy)
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) dfsSink(grid, 0, j); // Trần bản đồ
            if (grid[m - 1][j] == 1) dfsSink(grid, m - 1, j); // Đáy bản đồ
        }
        
        // Sau cuộc càn quét, những gì sót lại bên trong là Vùng Đất Chết Kín Mít
        int enclosedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    enclosedCount++;
                }
            }
        }
        
        return enclosedCount;
    }
    
    // Đổ bộ Đại Hồng Thủy (Thuật toán DFS nhấn chìm Đất thành Nước)
    private void dfsSink(int[][] grid, int i, int j) {
        // Đâm lố tường hoặc dội trúng Nước / phần đất đã lún (0), quay đầu!
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        
        // Nhấn chìm Đất
        grid[i][j] = 0;
        
        // Lan truyền cơn hồng thủy đi tứ phía
        dfsSink(grid, i + 1, j); // Xuống
        dfsSink(grid, i - 1, j); // Lên
        dfsSink(grid, i, j + 1); // Phải
        dfsSink(grid, i, j - 1); // Trái
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \times N)$. In the worst-case scenario, the entire grid is solid boundary-connected land. The depth-first search would forcefully touch every single cell once mutating it to `0`. The final double iterative array scan touches everything exactly once. Thus, total operations mathematically scale strictly proportionally to grid area $M \times N$.
    *   **Độ phức tạp thời gian:** $O(M \times N)$. Rủi ro cao nhất là cái sơ đồ chi chít Đất liền mạch nốii biên. Quả sóng DFS này sẽ tạt trôi càn qua từng ô đất ĐẶC DUY NHẤT đúng 1 lần (dìm nó thành Nước mãi mãi). Nên dù có lan thế nào thì cao thủ cũng chỉ tốn tổng phép tính vừa khít khung kích thước mảng. Bước đếm cuối cũng lặp đúng cỡ đó. Cân bằng tại $O(M \times N)$.*
*   **Space Complexity:** $O(M \times N)$ conceptually. Operating DFS recursion calls in the call stack implies max limits equal to the total elements array length in a worst-case snake-like grid layout configuration! We bypass arbitrary auxiliary allocated components dynamically changing elements directly on-the-spot (`in-place`), preserving raw memory excellently!
    *   **Độ phức tạp không gian:** Về danh nghĩa là khoảng $O(M \times N)$. Bản mảng thực thì không nắn ra một byte nào phụ thêm cả quá khỏe (Sửa trực tiếp thẳng vào mảng nhà nước `In-place`). Thế nhưng Cột trồng Tác Vụ Lệnh của Tháp đệ quy DFS lúc căng cực (đảo hình xoắn ốc) sẽ trích dung lượng ảo chồng xếp đạt nóc $M \times N$. Xài tạm OKe.*
