# Analysis for Escape a Large Maze
# *Phân tích bài toán Thoát Khỏi Mê Cung Rộng Rớn*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
There is a 1 million by 1 million grid. You are positioned at a starting coordinate `source`, trying to arrive at a target coordinate `target`. Some cells are `blocked`. Determine if it is possible to reach the target from the source without stepping onto blocked cells. A key constraint is that the number of blocked cells is very small (at most 200).
*Đất diễn là một Mê Cung Khổng Lồ $1,000,000 \times 1,000,000$. Bạn kẹt ở Vị trí Đầu `source`, tìm đường bò tới Đích `target`. Trong ma trận có vài Khối Đá Đen `blocked` đang ngáng đường. Ràng buộc Siêu Cấp: Tối đa chỉ có đúng 200 khối đá đen!*

---

## 2. Strategy: Optimal (Bounded Bi-directional BFS)
## *2. Chiến lược: Tối ưu (Duyệt Loang BFS Bị Chặn Bằng Tối Đa Chu Vi Của Đá)*

### Logic and Rules
### *Lý luận và Quy tắc*

Running a standard BFS on a $1,000,000^2$ grid will result in Time Limit Exceeded (TLE). However, because there are only a maximum of 200 blocked cells, the maximum enclosed area of blocked cells is formed when they are arranged diagonally against the grid corner. The maximum area constrained by $B$ blocks is $B \times (B - 1) / 2$. For $B = 200$, this area is strictly $19900$ squares.
*Chạy thuật toán Vết Loang BFS trên Lưới $10^{12}$ ô là án Tử Xóa Kịch Kim Thời Gian. Nhưng với ràng buộc 200 Cục Đá, cách Tụ Nhóm Đá bao kín để tạo ra cái lồng nhốt có chu vi rộng nhất chính là Kê Vuông Góc vào Góc Tường Biên Ảo! Dùng công thức toán học, sức chứa diện tích của Cái rào đá bao quanh đó tối đa chỉ đạt độ chứa là: $200 \times (200 - 1) / 2 = 19900$ phần tử không gian.*

Therefore:
1. Run a BFS from `source`. If the number of visited cells exceeds $19900$, it proves the source is literally free in the infinite open grid and is not trapped.
2. We must similarly run an independent BFS from `target` to ensure the target itself isn't trapped in a separate blocked cage.
3. If both ends can visit more than $19900$ cells, they are both in the main open ocean of the grid, ensuring connectivity.
*Suy luận tuyệt diệu:*
*1. Loang từ gốc Xóa Mù (Source). Nếu Càng quét được số Điểm lớn hơn 19900 (Độ Kẹt MAX BỌC THÉP LỚN NHẤT CÓ THỂ), thì 100% Điểm đó LÀ TỰ DO, NÓ ĐÃ THOÁT RA BIỂN LỚN không bị nhốt!*
*2. Tương tự, Đích (Target) cũng có thể âm thầm bị Nhốt cách biệt trong Bọc Kén. Lật mũi Loang ngược từ Đích (Target) kiểm tra tiếp, phải qua ngưỡng 19900 Điểm Tự Do Mới Cho Qua Chốt!*
*3. Kết Hợp Kép: Hai thằng đều Chắc Chắn Thoát được ra đại dương. Mà Biển Đại Dương thì chả chứa đá nữa, VẬY TRĂM PHẦN TRĂM sẽ vớt bèo Nối Liền Sợi Dây với Nhau! Chấm Kịch Trúng Độc.*

### Java Optimal Implementation
### *Triển khai giải pháp Java tối ưu*

```java
import java.util.*;

public class Solution {
    private static final int MAX_AREA = 20000;
    private static final int[][] DIRS = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private static final long LIMIT = 1000000;
    
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0) return true;
        
        Set<Long> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add((long) b[0] * LIMIT + b[1]);
        }
        
        return bfsCheck(source, target, blockedSet) && bfsCheck(target, source, blockedSet);
    }
    
    private boolean bfsCheck(int[] start, int[] end, Set<Long> blockedSet) {
        Set<Long> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(start);
        visited.add((long) start[0] * LIMIT + start[1]);
        
        while (!queue.isEmpty()) {
            if (visited.size() > MAX_AREA) return true; 
            
            int[] current = queue.poll();
            if (current[0] == end[0] && current[1] == end[1]) return true; 
            
            for (int[] dir : DIRS) {
                int r = current[0] + dir[0];
                int c = current[1] + dir[1];
                
                if (r >= 0 && r < LIMIT && c >= 0 && c < LIMIT) {
                    long key = (long) r * LIMIT + c;
                    if (!visited.contains(key) && !blockedSet.contains(key)) {
                        visited.add(key);
                        queue.offer(new int[]{r, c});
                    }
                }
            }
        }
        return false; 
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(B^2)$, where $B$ is the number of blocked points. The BFS explores at most $B^2/2 \approx 20000$ points.
    *   **Độ phức tạp thời gian:** $O(B^2)$ Với Toán Học $B$ là Số Chướng Ngại Vật `Blocked`. Kích nổ Thuật Loang bị Bó Dừng chốt ở Đỉnh `20000` Lặp Nhẹ.*
*   **Space Complexity:** $O(B^2)$ for storing the BFS visited set.
    *   **Độ phức tạp không gian:** $O(B^2)$. Lưu Vết Chân Tọa Độ Hash Set trong phạm vi diện tích Kén Trứng `MAX_AREA`.*
