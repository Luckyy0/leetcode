# Analysis for Minimum Genetic Mutation
# *Phân tích cho bài toán Đột biến Gen tối thiểu*

## 1. Problem Essence & BFS for Shortest Path
## *1. Bản chất vấn đề & BFS cho Đường đi ngắn nhất*

### The Challenge
### *Thách thức*
Finding the minimum number of changes to transform a source string into a target string, where each intermediate step must be valid (exist in a bank). This is a classic **Shortest Path Problem** on an unweighted graph.

### Strategy: Breadth-First Search (BFS)
### *Chiến lược: Duyệt theo chiều rộng (BFS)*

1.  **Nodes:** Each valid 8-character gene string in the `bank`.
2.  **Edges:** An edge exists between two genes if they differ by exactly **one** character.
3.  **Process:**
    - Use a `Queue` to store the genes to visit.
    - Use a `Set` for the `bank` (to allow $O(1)$ lookup) and a `visited` set to avoid cycles.
    - Start from `startGene`.
    - In each step, generate all possible one-character mutations of the current gene.
    - If a mutation is in the `bank` and not `visited`, add it to the queue.
    - Count the steps (levels) until `endGene` is reached.

---

## 2. Approach: Layer-by-Layer Exploration
## *2. Hướng tiếp cận: Khám phá từng lớp*

### Logic
### *Logic*
(See above). The choice of BFS over DFS is crucial because BFS naturally finds the shortest path in an unweighted graph. The search space is small (8 positions, 4 choices each), making this approach very efficient.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Guaranteed Shortest Path:** BFS discovers the target in the minimum possible number of levels.
    *Đảm bảo đường đi ngắn nhất: BFS tìm thấy mục tiêu với số cấp độ tối thiểu.*
*   **Early Termination:** Stop as soon as `endGene` is found.
    *Dừng sớm: Dừng ngay khi tìm thấy endGene.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(B \times L \times 4)$, where $B$ is the bank size and $L=8$. Since $B \le 10$, this is extremely fast.
    *Độ phức tạp thời gian: $O(B \times L \times 4)$.*
*   **Space Complexity:** $O(B)$ to store the bank and visited states.
    *Độ phức tạp không gian: $O(B)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Start:** `AACCGGTT`
1. Level 1: Try changing each of 8 positions to A, C, G, T.
    - Mutation found in bank: `AACCGGTA`.
2. Level 2: Try mutations of `AACCGGTA`.
    - Mutation found in bank: `AAACGGTA`.
**End found at level 2.**
Result: 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Standard BFS with a HashSet for the bank.
*BFS tiêu chuẩn với HashSet cho ngân hàng gen.*
---
*Đôi khi đột biến không phải là một sự ngẫu nhiên hỗn loạn, mà là một hành trình có trình tự (BFS). Bằng cách bước từng bước một (mutations) qua những điểm dừng an toàn (bank), ta có thể tìm ra con đường ngắn nhất để biến đổi bản thân từ điểm bắt đầu đến cái đích mong muốn, nơi sự sinh tồn được đảm bảo bởi những quy luật của tự nhiên.*
Sometimes mutation is not a chaotic randomness, but an ordered journey (BFS). By taking step by step (mutations) through safe stopping points (bank), we can find the shortest path to transform ourselves from the starting point to the desired destination, where survival is guaranteed by the laws of nature.
