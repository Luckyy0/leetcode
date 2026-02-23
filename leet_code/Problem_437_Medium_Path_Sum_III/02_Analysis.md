# Analysis for Path Sum III
# *Phân tích cho bài toán Tổng đường đi III*

## 1. Problem Essence & Prefix Sum on Trees
## *1. Bản chất vấn đề & Tổng tiền tố trên Cây*

### The Challenge
### *Thách thức*
Counting paths that sum to a target value, where paths can start and end anywhere in the tree as long as they go downwards. A brute force $O(N^2)$ approach would be to start a search from every single node. However, we can optimize this to $O(N)$ using the **Prefix Sum** technique.

### Strategy: DFS + Prefix Sum Map
### *Chiến lược: DFS + Bản đồ Tổng tiền tố*

1.  **Prefix Sum Logic:** In an array, a sub-segment sum between indices $i$ and $j$ is $Sum(0, j) - Sum(0, i-1)$. Similarly, on a tree, the sum of a path ending at node $U$ is the prefix sum from root to $U$.
2.  **Tracking:** Use a `HashMap<Long, Integer>` to store the frequency of prefix sums encountered along the current path from the root.
3.  **Deduction:** At node $U$ with prefix sum `currSum`, any ancestor node $A$ whose prefix sum was `currSum - targetSum` defines a path from $A$ to $U$ that sums exactly to `targetSum`.
4.  **DFS with Backtracking:**
    - Increase the count of `currSum` in the map.
    - Recurse into children.
    - **Backtrack:** Decrease the count of `currSum` when leaving the node to ensure it doesn't affect paths in other branches.

---

## 2. Approach: Optimal Path Counting
## *2. Hướng tiếp cận: Đếm Đường đi Tối ưu*

### Logic
### *Logic*
(See above). We use `Long` for the prefix sum to prevent overflow, as node values can reach $10^9$. The map check `map.getOrDefault(currSum - targetSum, 0)` gives us the number of valid paths ending at the current node in $O(1)$.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N) Complexity:** Linear pass through the tree.
    *Hiệu quả O(N): Duyệt cây tuyến tính.*
*   **Decoupled Paths:** Effectively counts all internal paths without nested loops.
    *Tách biệt các đường đi: Đếm hiệu quả mọi đường đi nội bộ mà không cần vòng lặp lồng nhau.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of nodes.
    *Độ phức tạp thời gian: $O(N)$.*
*   **Space Complexity:** $O(H)$, where $H$ is the height of the tree (for the recursion stack and the hash map).
    *Độ phức tạp không gian: $O(H)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Tree:** `10 -> 5 -> 3`, **Target:** 8
1. Start: `Map = {0:1}`.
2. At 10: `currSum = 10`. Need `10-8=2` in map. No. `Map = {0:1, 10:1}`.
3. At 5: `currSum = 15`. Need `15-8=7` in map. No. `Map = {0:1, 10:1, 15:1}`.
4. At 3: `currSum = 18`. Need `18-8=10` in map. **YES (value is 1)**. Path found!
Result: Total paths = 1.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

DFS with a Prefix Sum HashMap.
*DFS với một HashMap lưu Tổng tiền tố.*
---
*Mọi hành trình (path) đều có một khởi đầu và kết thúc. Thay vì mệt mỏi đi tìm từng điểm bắt đầu một, ta ghi nhớ những dấu chân đã qua (prefix sums) và đối chiếu chúng với mục tiêu (target). Tại nơi mà sự chênh lệch khớp với kỳ vọng, đó chính là nơi một con đường hoàn hảo vừa được hoàn thiện.*
Every journey (path) has a beginning and an end. Instead of tiringly finding each starting point, we remember the footprints passed (prefix sums) and check them against the goal (target). Where the difference matches expectations, that is where a perfect path has just been completed.
