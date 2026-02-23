# Analysis for Reconstruct Itinerary
# *Phân tích cho bài toán Tái tạo Lịch trình*

## 1. Problem Essence & Eulerian Path
## *1. Bản chất vấn đề & Đường đi Euler*

### The Challenge
### *Thách thức*
Use all edges exactly once. Start vertex fixed ("JFK").
This is finding an Eulerian Path (or Circuit) in a directed graph.
Standard condition for Eulerian Path:
- At most 1 node has `outDegree - inDegree = 1` (Start).
- At most 1 node has `inDegree - outDegree = 1` (End).
- All others balanced.
Since the problem guarantees a valid itinerary starting at JFK, these conditions verify themselves.
We need the *Lexicographically Smallest* path.

### Strategy: Hierholzer's Algorithm (Modified)
### *Chiến lược: Thuật toán Hierholzer (Sửa đổi)*
Hierholzer finds Eulerian circuit. Because we have valid path assumption, we can use a DFS approach:
- "Stuck" logic: If we are at `u` and take edge `u -> v`, we might get stuck in `v` if it's not the true end of the global path.
- Algorithm: Always pick smallest neighbor first (PriorityQueue). Recursively visit.
- **Key Insight:** Add node to results *after* visiting all children (Post-order).
- Why? The node that leads to a "dead end" (the true global destination) will be finished first and put at the end of our result list. The "main loop" nodes will be finished later and put earlier.
- Reversing the post-order list gives the path.

### Logic Flow
### *Luồng Logic*
1.  Properties `Map<String, PriorityQueue<String>> targets`.
2.  Populate map with tickets. Sort automatically by PQ.
3.  `dfs("JFK")`.
    - While `targets.get(u)` is not empty:
        - `next = targets.get(u).poll()`.
        - `dfs(next)`.
    - `path.addFirst(u)`.

---

## 2. Approach: DFS Post-Order
## *2. Hướng tiếp cận: DFS Post-Order*

### Logic
### *Logic*
(See above). The use of PriorityQueue ensures lexical order. The post-order accumulation ensures we handle dead-ends correctly (by putting them effectively at the end of the reversed list).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Handling Cycles:** Works perfectly for graphs with cycles (which is the case for Eulerian circuits) without back-tracking complexity.
    *Xử lý chu trình: Hoạt động hoàn hảo cho đồ thị có chu trình mà không cần độ phức tạp quay lui.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(E \log E)$ due to Priority Queue sorting. E is number of tickets.
    *Độ phức tạp thời gian: $O(E \log E)$.*
*   **Space Complexity:** $O(E)$ to store graph.
    *Độ phức tạp không gian: $O(E)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** JFK -> SFO, JFK -> ATL, SFO -> ATL, ATL -> JFK, ATL -> SFO.
Map:
JFK: [ATL, SFO]
ATL: [JFK, SFO]
SFO: [ATL]

DFS(JFK):
1. Poll ATL. Map JFK:[SFO]. Call DFS(ATL).
   DFS(ATL):
   1. Poll JFK. Map ATL:[SFO]. Call DFS(JFK).
      DFS(JFK):
      1. Poll SFO. Map JFK:[]. Call DFS(SFO).
         DFS(SFO):
         1. Poll ATL. Map SFO:[]. Call DFS(ATL).
            DFS(ATL):
            1. Poll SFO. Map ATL:[]. Call DFS(SFO).
               DFS(SFO):
               - No neighbors. Add SFO. Stack: [SFO]. Return.
            - DFS(ATL) continues. Add ATL. Stack: [ATL, SFO]. Return.
         - DFS(SFO) continues. Add SFO. Stack: [SFO, ATL, SFO]. Return.
      - DFS(JFK) continus. Add JFK. Stack: [JFK, SFO, ATL, SFO]. Return.
   - DFS(ATL) continues. Poll SFO. Map ATL:[]. Call DFS(SFO). But SFO neighbor already empty?
     Wait, dry run mistake. SFO neighbors depleted in step 1.1.1.
     PriorityQueue logic handles "greedy" choices. But Hierholzer backtracking is implicit?
     Wait. The logic "While targets[u] not empty" ensures we traverse ALL edges.
     If there are separate cycles, Hierholzer stitches them.
     Let's trace properly.
     Path should be: JFK -> ATL -> JFK -> SFO -> ATL -> SFO.
     Trace again:
     DFS(JFK):
       Pick ATL. DFS(ATL):
         Pick JFK. DFS(JFK):
            Pick SFO. DFS(SFO):
               Pick ATL. DFS(ATL):
                  Pick SFO. DFS(SFO): (Stuck, add SFO). Path: [SFO]
                  Done. (Back to ATL)
                  (ATL has no more edges). Add ATL. Path: [ATL, SFO]
               Done. (Back to SFO)
               Add SFO. Path: [SFO, ATL, SFO]
            Done. (Back to JFK)
            Add JFK. Path: [JFK, SFO, ATL, SFO]
         Done. (Back to ATL)
         Add ATL. Path: [ATL, JFK, SFO, ATL, SFO]
       Done. (Back to JFK)
       Add JFK. Path: [JFK, ATL, JFK, SFO, ATL, SFO].
     Correct logic.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Hierholzer's algorithm is the standard solution.
*Thuật toán Hierholzer là giải pháp tiêu chuẩn.*
---
*Đôi khi để tìm được đường đi trọn vẹn (itinerary), ta phải dám đi đến tận cùng (dead end) trước, rồi mới quay lại nhìn nhận toàn bộ hành trình (reconstruct backwards).*
Sometimes to find the complete itinerary, we must dare to go to the very end (dead end) first, then look back to perceive the entire journey (reconstruct backwards).
