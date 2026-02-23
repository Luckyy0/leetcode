# Analysis for Satisfiability of Equality Equations
# *Phân tích cho bài toán Tính Thỏa mãn của Phương trình Đẳng thức*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Given a list of equality (`==`) and inequality (`!=`) equations among single lowercase variables, determine if they are logically consistent.
*Xác định bộ phương trình đẳng thức và bất đẳng thức xem chúng có nhất quán về mặt logic không.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Variables that are equal must be in the same connected component. This screams **Union-Find** (Disjoint Set Union).
- Equivalence (`==`) is transitive. "a==b" and "b==c" implies "a==c".
- Inequality (`!=`) simply asserts that the two variables MUST NOT be in the same connected component.
- The most robust strategy is a two-pass approach:
  1. **First Pass:** Process only `==` equations. Union the corresponding variables into sets.
  2. **Second Pass:** Process only `!=` equations. For each equation, check if the two variables are already in the same set according to the Union-Find structure. If they are, it's a contradiction; return `false`.
- If the second pass finishes without finding any contradictions, return `true`.
*Sử dụng kỹ thuật Union-Find. Lượt 1: gộp các biến bằng nhau. Lượt 2: kiểm tra các biến khác nhau, nếu chúng cùng một tập hợp thì trả về false.*

---

## 2. Strategy: Union Find
## *2. Chiến lược: Tập hợp rời rạc (Union-Find)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** Create a `parent` array of size 26 for the lowercase letters 'a' to 'z'. Each element is initially its own parent (`parent[i] = i`).
    *   **Khởi tạo:** Mảng `parent` kích thước 26, mỗi phần tử tự trỏ vào chính nó.*

2.  **Define Union-Find Functions:**
    - `find(int i)`: Find the root of `i` with path compression.
    - `union(int i, int j)`: Find roots of `i` and `j` and make one point to the other if they differ.
    *   **Hàm Union-Find:** Có nén đường dẫn.*

3.  **Pass 1 (Equalities):** Iterates over `equations`. If `eqn[1] == '='`, find the indices for `eqn[0]` and `eqn[3]` (e.g., `c - 'a'`) and `union` them.
    *   **Lượt 1:** Hợp nhất các biến có dấu `==`.*

4.  **Pass 2 (Inequalities):** Iterates over `equations` again. If `eqn[1] == '!'`, execute `find(eqn[0] - 'a') == find(eqn[3] - 'a')`. If true, contradiction, return `false`.
    *   **Lượt 2:** Kiểm tra mâu thuẫn cho các dấu `!=`.*

5.  **Return:** `true` if no conflict detected.
    *   **Trả về:** `true` nếu không có xung đột.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    int[] parent;

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Pass 1: Handle equalities
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                union(x, y);
            }
        }

        // Pass 2: Handle inequalities
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                // Contradiction if they have the same root
                if (find(x) == find(y)) {
                    return false;
                }
            }
        }

        return true;
    }

    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]); // Path compression
    }

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot \alpha(V))$ where $N$ is the length of `equations` and $V=26$ is the number of variables. $\alpha$ is the Inverse Ackermann function. Practically $O(N)$ since $V$ is a small constant (26).
    *   **Độ phức tạp thời gian:** $O(N)$ do $\alpha(26)$ là hằng số cực nhỏ.*
*   **Space Complexity:** $O(V)$ which is $O(1)$ constant auxiliary space since we only need an array of size 26.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Union-Find perfectly maps equality relationships into connected components, making it intuitively correct and blazingly fast.
*Union-Find ánh xạ hoàn hảo các mối quan hệ đẳng thức thành các thành phần liên thông, tạo nên một giải pháp trực quan và cực kỳ nhanh.*
