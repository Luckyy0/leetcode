# Analysis for K-Similar Strings
# *Phân tích cho bài toán Chuỗi K-Tương đồng*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We need to find the minimum number of swaps needed to transform string `s1` into `s2`. Both strings are anagrams of each other. This is essentially a shortest path problem in the space of string permutations.
*Chúng ta cần tìm số lần tráo đổi tối thiểu cần thiết để biến chuỗi `s1` thành `s2`. Cả hai chuỗi đều là hoán vị của nhau. Về bản chất, đây là bài toán tìm đường đi ngắn nhất trong không gian các hoán vị của chuỗi.*

---

## 2. Strategy: Breadth-First Search (BFS)
## *2. Chiến lược: Tìm kiếm theo chiều rộng (BFS)*

### Why BFS?
### *Tại sao dùng BFS?*
BFS is naturally suited for finding the shortest path (minimum operations) in an unweighted state space graph. Each string transformation is an edge with weight 1.
*BFS phù hợp một cách tự nhiên để tìm đường đi ngắn nhất (số lượng thao tác tối thiểu) trong một đồ thị không gian trạng thái không có trọng số. Mỗi phép biến đổi chuỗi là một cạnh có trọng số 1.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize BFS:** Use a Queue to store strings and a HashSet to keep track of visited states. Push `s1` into the queue.
    *   **Khởi tạo BFS:** Sử dụng Hàng đợi để lưu trữ các chuỗi và HashSet để theo dõi các trạng thái đã ghé thăm. Đẩy `s1` vào hàng đợi.*

2.  **Level-by-Level Traversal:** Each level represents the number of swaps.
    *   **Duyệt theo cấp độ:** Mỗi cấp độ đại diện cho số lượng phép tráo đổi.*

3.  **Generate Neighbors:**
    - Find the first index `i` where `curr[i] != s2[i]`.
    - Find all indices `j > i` where `curr[j] == s2[i]` (characters that can be swapped to index `i` to match `s2`).
    - Attempt to swap `curr[i]` with `curr[j]` only if `curr[j] != s2[j]`. This pruning is important for performance.
    - If the new string hasn't been visited, add it to the queue.
    *   **Tạo các láng giềng:** Tìm chỉ số đầu tiên `i` mà `curr[i] != s2[i]`. Tìm tất cả các chỉ số `j > i` mà `curr[j] == s2[i]` (các ký tự có thể được tráo đổi sang chỉ số `i` để khớp với `s2`). Chỉ cố gắng tráo đổi `curr[i]` với `curr[j]` nếu `curr[j] != s2[j]`. Việc cắt tỉa này rất quan trọng cho hiệu suất. Nếu chuỗi mới chưa được ghé thăm, hãy thêm nó vào hàng đợi.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int kSimilarity(String s1, String s2) {
    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    queue.offer(s1);
    visited.add(s1);
    
    int k = 0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String curr = queue.poll();
            if (curr.equals(s2)) return k;
            
            // Generate next states
            int p = 0;
            while (curr.charAt(p) == s2.charAt(p)) p++;
            
            for (int j = p + 1; j < curr.length(); j++) {
                if (curr.charAt(j) == s2.charAt(p) && curr.charAt(j) != s2.charAt(j)) {
                    String next = swap(curr, p, j);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
        }
        k++;
    }
    return k;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** Exponential in terms of string length in the worst case, but the pruning and BFS level structure make it efficient for $L=20$.
    *   **Độ phức tạp thời gian:** Hàm mũ theo độ dài chuỗi trong trường hợp xấu nhất, nhưng việc cắt tỉa và cấu trúc cấp độ BFS giúp nó hiệu quả với $L=20$.*
*   **Space Complexity:** $O(L! / \dots)$ depending on unique characters, stored in the `visited` set.
    *   **Độ phức tạp không gian:** Phụ thuộc vào các ký tự duy nhất, được lưu trữ trong tập hợp `visited`.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

BFS is the standard approach for minimum swap problems. Pruning unnecessary swaps (where `curr[j]` already matches `s2[j]`) is critical for passing.
*BFS là cách tiếp cận tiêu chuẩn cho các bài toán tráo đổi tối thiểu. Cắt tỉa các phép tráo đổi không cần thiết (nơi `curr[j]` đã khớp với `s2[j]`) là rất quan trọng để vượt qua.*
