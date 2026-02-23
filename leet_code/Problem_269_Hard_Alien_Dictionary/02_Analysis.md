# Analysis for Alien Dictionary
# *Phân tích cho bài toán Từ điển Người ngoài hành tinh*

## 1. Problem Essence & Topological Sort
## *1. Bản chất vấn đề & Sắp xếp topo*

### The Challenge
### *Thách thức*
We have specific pairwise orderings derived from adjacent words.
e.g., `["wrt", "wrf"]` -> `t` before `f`.
We need to combine these constraints into a global order.
Graph Theory: Directed Graph where edge `u -> v` means `u` comes before `v`.
Find a topological sort. If cycle exists -> Invalid.

### Edge Extraction
### *Trích xuất cạnh*
Compare adjacent words `words[i]` and `words[i+1]`.
Find the first differing character.
- "wrt", "wrf" -> 't' != 'f'. Edge `t -> f`.
- "wrf", "er" -> 'w' != 'e'. Edge `w -> e`.
- "er", "ett" -> 'r' != 't'. Edge `r -> t`.
- "ett", "rftt" -> 'e' != 'r'. Edge `e -> r`.

Corner case: "abc", "ab". Prefix is longer than next word. Invalid sort!
`abc` vs `ab`. They mismatch at index 2 ('c') vs nothing. `c` comes... ?
Actually, `ab` is prefix of `abc`. In dictionary, shorter prefix MUST come first.
So `abc` coming before `ab` is IMPOSSIBLE. Return invalid.

---

## 2. Approach: Kahn's Algorithm (BFS)
## *2. Hướng tiếp cận: Thuật toán Kahn (BFS)*

### Logic
### *Logic*
1.  **Build Graph:**
    - Initialize in-degree Map and Adjacency List for ALL unique chars.
    - Iterate `i` from 0 to `n-2`. Compare `words[i]` and `words[i+1]`.
    - Find first mismatch `c1, c2`. Add edge `c1 -> c2`. Increment in-degree of `c2`.
    - Check "Prefix" error case.
2.  **BFS:**
    - Queue all nodes with `in-degree == 0`.
    - While queue not empty:
        - Poll `u`. Append to result.
        - For `v` in `adj[u]`:
            - `in-degree[v]--`.
            - If `in-degree[v] == 0`, push `v`.
3.  **Validate:**
    - If `result.length == unique_chars.size`, return result.
    - Else (cycle or disconnected parts not fully resolved? No, disconnected is fine in topsort, but Cycle prevents nodes from reaching 0 degree), return "".

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Directed Graph:** Perfectly models precedence.
*   **Kahn's Algorithm:** Naturally detects cycles (result length mismatch).
    *Đồ thị có hướng: Mô hình hóa thứ tự ưu tiên. Thuật toán Kahn: Tự nhiên phát hiện chu trình.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(C)$, where $C$ is total characters in all words (to build graph) + $O(V+E)$ (BFS). $V \le 26$.
    *Độ phức tạp thời gian: $O(C)$.*
*   **Space Complexity:** $O(1)$ (26 nodes).
    *Độ phức tạp không gian: $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `["wrt","wrf","er","ett","rftt"]`
Unique chars: {w,r,t,f,e}. Total 5.

Edges:
1.  `t -> f`
2.  `w -> e`
3.  `r -> t`
4.  `e -> r`

Graph: `w -> e -> r -> t -> f`
In-degrees:
w: 0
e: 1 (from w)
r: 1 (from e)
t: 1 (from r)
f: 1 (from t)

Queue: `[w]`.
Pop `w`. Res="w". Neighbors `e`. In-degree `e`=0. Push `e`.
Pop `e`. Res="we". Neighbors `r`. In-degree `r`=0. Push `r`.
...
Res="wertf". Length 5. Valid.

**Input:** `["z", "x", "z"]`
`z -> x`, `x -> z`. Cycle `z <-> x`.
Queue: Empty (both in-degree 1).
Res="", len 0 != 2. Return "".

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Be careful with the prefix case (`abc` before `ab`). This is a subtle bug source.
*Cẩn thận với trường hợp tiền tố (`abc` trước `ab`). Đây là nguồn lỗi tinh vi.*
---
*Ngôn ngữ nào cũng cần quy tắc (lexicography). Khi các quy tắc mâu thuẫn (cycle), giao tiếp trở nên vô nghĩa.*
Every language needs rules. When rules conflict (cycle), communication becomes meaningless.
