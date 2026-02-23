# Analysis for Word Ladder II
# *Phân tích cho bài toán Tìm Thang Từ II*

## 1. Problem Understanding & Complexity
## *1. Hiểu Đề & Độ Phức Tạp*

### The Shortest Path Requirement
### *Yêu Cầu Đường Đi Ngắn Nhất*
*   The primary goal is not just to find *any* path from `beginWord` to `endWord`, nor is it just to find the *length* of the shortest path (that would be Word Ladder I). The requirement is to return **all** possible shortest paths.
    *Mục tiêu chính không chỉ là tìm *bất kỳ* con đường nào từ `beginWord` đến `endWord`, cũng không chỉ là tìm *độ dài* của con đường ngắn nhất (đó là bài Word Ladder I). Yêu cầu là phải trả về **tất cả** các con đường ngắn nhất có thể.*
*   The search space can be viewed as a graph where each word is a node and an edge exists between two words if they differ by exactly one character.
    *Không gian tìm kiếm có thể được coi là một đồ thị trong đó mỗi từ là một nút và một cạnh tồn tại giữa hai từ nếu chúng khác nhau đúng một ký tự.*

### Algorithmic Challenges
### *Thách Thức Thuật Toán*
*   A simple BFS (Breadth-First Search) can find the shortest distance, but storing all paths during BFS can lead to exponential memory consumption (MLE - Memory Limit Exceeded).
    *Một phép duyệt BFS đơn giản có thể tìm thấy khoảng cách ngắn nhất, nhưng việc lưu trữ tất cả các đường đi trong quá trình BFS có thể dẫn đến tiêu thụ bộ nhớ theo hàm mũ (Lỗi vượt quá giới hạn bộ nhớ - MLE).*
*   A pure DFS (Depth-First Search) or backtracking would be too slow because it doesn't naturally find the shortest path first, potentially exploring millions of unnecessary long paths.
    *Một phép duyệt DFS thuần túy hoặc quay lui sẽ quá chậm vì nó không tìm thấy con đường ngắn nhất trước tiên một cách tự nhiên, có khả năng khám phá hàng triệu con đường dài không cần thiết.*

---

## 2. Approach: Hybrid BFS + DFS Backtracking
## *2. Hướng Tiếp Cận: Kết Hợp BFS + DFS Quay Lui*

To solve this efficiently, we split the task into two distinct phases:
*Để giải quyết vấn đề này một cách hiệu quả, chúng ta chia nhiệm vụ thành hai giai đoạn riêng biệt:*

### Phase 1: BFS to Build Shorter-Path Graph
### *Giai Đoạn 1: BFS để Xây Dựng Đồ Thị Đường Đi Ngắn Hơn*
1.  Run a BFS starting from `beginWord`.
2.  Maintain a `distance` map (Word -> Min Distance from start).
3.  Maintain an `adj` map (Word -> List of preceding words in shortest paths).
4.  Standard BFS logic:
    -   While the queue is not empty:
        -   For each word at the current level, try changing each character (a-z).
        -   If the new word is in `wordList`:
            -   If it's the first time we see this word at this distance, record the distance and add it to the queue.
            -   If we see this word at `currentDistance + 1`, add the current word as a "parent" or "predecessor" of the new word.
5.  Stop once we exhaust the level containing `endWord`.

### Phase 2: DFS to Reconstruct Paths
### *Giai Đoạn 2: DFS để Tái Cấu Trúc Đường Đi*
1.  Start from `endWord`.
2.  Use the `adj` map built in Phase 1 to move backwards from `endWord` to `beginWord`.
3.  Because the `adj` map only contains edges that belong to shortest paths, every DFS branch that reaches `beginWord` is guaranteed to be a shortest path.
4.  Reverse the resulting paths (since we tracked backwards from end to start).

---

## 3. Mathematical & Structural Nuances
## *3. Sắc Thái Cấu Trúc & Toán Học*

*   **Graph Layers:** The BFS effectively organizes the `wordList` into layers based on their distance from `beginWord`. Any shortest path must strictly jump from layer $i$ to layer $i+1$.
    *Các Tầng Đồ Thị: BFS sắp xếp `wordList` thành các tầng dựa trên khoảng cách của chúng từ `beginWord`. Bất kỳ con đường ngắn nhất nào cũng phải nhảy nghiêm ngặt từ tầng $i$ sang tầng $i+1$.*
*   **Adjacency List:** By storing `adj[neighbor].add(current)`, we create a Directed Acyclic Graph (DAG) that represents all paths of length $D_{min}$.
    *Danh Sách Kề: Bằng cách lưu trữ `adj[neighbor].add(current)`, chúng ta tạo ra một Đồ thị có hướng không chu trình (DAG) đại diện cho tất cả các đường đi có độ dài $D_{min}$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot L \cdot 26 + \text{Paths})$, where $N$ is the number of words, $L$ is the word length. The BFS visits each word and tries all letter swaps. The DFS time depends on the number of shortest paths.
    *Độ phức tạp thời gian: $O(N \cdot L \cdot 26 + \text{Số_đường_đi})$, trong đó $N$ là số lượng từ, $L$ là độ dài từ. BFS truy cập mỗi từ và thử tất cả các hoán đổi chữ cái. Thời gian DFS phụ thuộc vào số lượng các con đường ngắn nhất.*
*   **Space Complexity:** $O(N \cdot L)$. We store distances and adjacency lists for the words in the list.
    *Độ phức tạp không gian: $O(N \cdot L)$. Chúng ta lưu trữ khoảng cách và danh sách kề cho các từ trong danh sách.*

---

## 5. Summary Recommendation
## *5. Khuyến nghị tổng kết*

This "BFS to find distance, DFS to find paths" pattern is a classic solution for "Find all shortest paths" problems. It's much more memory-efficient than storing paths directly in the BFS queue. For Java, using `HashMap<String, List<String>>` for adjacency and `HashMap<String, Integer>` for distances is the most standard approach.
*Mô hình "BFS để tìm khoảng cách, DFS để tìm đường đi" này là một giải pháp kinh điển cho các bài toán "Tìm tất cả các con đường ngắn nhất". Nó tiết kiệm bộ nhớ hơn nhiều so với việc lưu trữ trực tiếp các con đường trong hàng đợi BFS. Đối với Java, sử dụng `HashMap<String, List<String>>` cho danh sách kề và `HashMap<String, Integer>` cho khoảng cách là cách tiếp cận chuẩn nhất.*
---
*Việc tách biệt pha khám phá và pha tái cấu trúc giúp chúng ta kiểm soát tốt hơn tài nguyên hệ thống trong những bài toán tổ hợp phức tạp.*
Separating the exploration phase and the reconstruction phase helps us better control system resources in complex combinatorial problems.
