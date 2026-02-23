# Analysis for Sliding Puzzle
# *Phân tích cho bài toán Trò chơi Trượt số*

## 1. Problem Essence & BFS Shortest Path
## *1. Bản chất vấn đề & Đường đi ngắn nhất BFS*

### The Challenge
### *Thách thức*
Find the minimum moves to reach a target state.
*Tìm số bước di chuyển tối thiểu để đạt đến trạng thái mục tiêu.*

This is a shortest path problem on a graph where nodes are board states and edges are swaps.
*Đây là bài toán đường đi ngắn nhất trên đồ thị nơi các nút là trạng thái bảng và các cạnh là các phép hoán đổi.*

State space size: $6! = 720$. Very small. BFS is perfect.
*Kích thước không gian trạng thái: $6! = 720$. Rất nhỏ. BFS là hoàn hảo.*

---

## 2. Strategy: BFS with String State
## *2. Chiến lược: BFS với Trạng thái Chuỗi*

### Algorithm
### *Thuật toán*

1.  **State Representation:** Flatten the 2x3 board into a string "123450". This simplifies storage in `HashSet`.
    *   **Biểu diễn Trạng thái:** Làm phẳng bảng 2x3 thành chuỗi "123450". Giúp lưu trữ trong `HashSet` dễ dàng.*

2.  **Adjacency Map:** Precompute neighbors for each index in the flat string (0-5).
    - 0 (0,0): neighbors 1 (0,1), 3 (1,0).
    - 1 (0,1): neighbors 0, 2, 4.
    - ...
    *   **Bản đồ Kề:** Tính trước các hàng xóm cho mỗi chỉ số trong chuỗi làm phẳng.*

3.  **Breadth-First Search:**
    - Queue stores flattened strings.
    - Set stores visited strings.
    - Level-by-level traversal.
    - If `current == "123450"`, return `level`.
    *   **Tìm kiếm theo Chiều rộng:** Hàng đợi lưu các chuỗi. Tập hợp lưu các chuỗi đã thăm. Duyệt theo từng cấp. Nếu `current == "123450"`, trả về mức hiện tại.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public int slidingPuzzle(int[][] board) {
    String target = "123450";
    String start = ""; 
    // Convert board to string...
    
    // Neighbors mapped for 2x3 board flattened
    int[][] dirs = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
    
    Queue<String> q = new LinkedList<>();
    q.offer(start);
    Set<String> visited = new HashSet<>();
    visited.add(start);
    
    int moves = 0;
    while (!q.isEmpty()) {
        int size = q.size();
        for(int i=0; i<size; i++) {
            String curr = q.poll();
            if (curr.equals(target)) return moves;
            
            int zeroIdx = curr.indexOf('0');
            for (int d : dirs[zeroIdx]) {
                String next = swap(curr, zeroIdx, d);
                if (visited.add(next)) q.offer(next);
            }
        }
        moves++;
    }
    return -1;
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(6! \cdot 6)$. Total states is 720. Each state has constant transitions. String ops take length.
    *   **Độ phức tạp thời gian:** $O(720)$.*
*   **Space Complexity:** $O(6! \cdot 6)$.
    *   **Độ phức tạp không gian:** $O(720)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Start:** `123405` (Target `123450`)
- Q: [`123405`]
- Pop `123405`. Zero at 4. Neighbors: 1, 3, 5.
  - Swap 4-1: `103425`.
  - Swap 4-3: `123045`.
  - Swap 4-5: `123450` -> Target found!
- Moves: 1.
**Result:** 1.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Flattening to string is standard for small sliding puzzles. Precomputing neighbors avoids 2D math during BFS loop.
*Làm phẳng thành chuỗi là chuẩn mực cho các trò chơi trượt nhỏ. Tính trước các hàng xóm giúp tránh toán học 2D trong vòng lặp BFS.*
