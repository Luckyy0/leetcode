# Analysis for Similar String Groups
# *Phân tích cho bài toán Các Nhóm Chuỗi Tương đồng*

## 1. Problem Essence & Connectivity
## *1. Bản chất vấn đề & Tính kết nối*

### THE CHALLENGE
### *Thách thức*
We need to group strings that are "similar" to each other. Similarity is defined as having at most 2 differing character positions (since all strings are anagrams). The grouping is transitive: if $A \approx B$ and $B \approx C$, then $A$ and $C$ belong to the same group. This is a classic graph problem where we need to find the number of **Connected Components**.
*Chúng ta cần nhóm các chuỗi "tương đồng" với nhau. Sự tương đồng được định nghĩa là có tối đa 2 vị trí ký tự khác nhau. Việc phân nhóm có tính chất bắc cầu: nếu $A$ tương đồng với $B$ và $B$ tương đồng với $C$, thì $A$ và $C$ cùng thuộc một nhóm. Đây là bài toán tìm số lượng **Thành phần liên thông** trong đồ thị.*

---

## 2. Strategy: Disjoint Set Union (DSU)
## *2. Chiến lược: Cấu trúc các tập hợp rời nhau (DSU)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Similarity Check Function:**
    - To check if string $S_1$ and $S_2$ are similar:
        - Count the number of indices where $S_1[i] \neq S_2[i]$.
        - If the count is 0 or 2, they are similar.
    *   **Hàm kiểm tra tương đồng:** Đếm số lượng vị trí mà ký tự của hai chuỗi khác nhau. Nếu đếm được 0 hoặc 2, chúng tương đồng.*

2.  **Initialize DSU:**
    - Each string starts as its own parent.
    - `num_groups = total_strings`.
    *   **Khởi tạo DSU:** Mỗi chuỗi bắt đầu là một tập hợp riêng. `số_nhóm = tổng_số_chuỗi`.*

3.  **Union-Find Operations:**
    - Iterate through all pairs $(i, j)$ of strings.
    - If `isSimilar(strs[i], strs[j])`, perform `Union(i, j)`.
    - Every successful `Union` (where $i$ and $j$ were in different sets) decrements `num_groups`.
    *   **Thao tác Hợp-Tìm:** Duyệt qua tất cả các cặp chuỗi $(i, j)$. Nếu chúng tương đồng, thực hiện phép `Union`. Mỗi khi `Union` thành công, giảm `số_nhóm` đi 1.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int numSimilarGroups(String[] strs) {
    int n = strs.length;
    DSU dsu = new DSU(n);
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (isSimilar(strs[i], strs[j])) {
                dsu.union(i, j);
            }
        }
    }
    return dsu.count;
}

private boolean isSimilar(String s1, String s2) {
    int diff = 0;
    for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
            diff++;
            if (diff > 2) return false;
        }
    }
    return diff == 2 || diff == 0;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2 \cdot L)$, where $N$ is the number of strings and $L$ is the length of each string. $N$ and $L$ are relatively small (up to 300), so $300 \cdot 300 \cdot 300 = 2.7 \cdot 10^7$, which fits in time limit.
    *   **Độ phức tạp thời gian:** $O(N^2 \cdot L)$, vì ta duyệt mọi cặp chuỗi và so sánh từng ký tự.*
*   **Space Complexity:** $O(N)$, to store the parent pointers in DSU.
    *   **Độ phức tạp không gian:** $O(N)$ để lưu mảng parent.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `["tars", "rats", "arts"]`
1. (0,1): "tars" vs "rats". Diff positions [0, 2]. `isSimilar` = True. `Union(0, 1)`. Groups: {0,1}, {2}.
2. (0,2): "tars" vs "arts". Diff positions [0, 2, 3]. `isSimilar` = False.
3. (1,2): "rats" vs "arts". Diff positions [0]. Wait, anagram property. Diff positions [0, 1]... no, 'r' vs 'a'.
   Actually, (1) "rats" (2) "arts" -> 'r' vs 'a', 'a' is same, 't' is same, 's' is same. Diff = 2.
   `Union(1, 2)`. Groups: {0, 1, 2}.
**Result:** 1.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Disjoint Set Union is preferred over BFS/DFS here because we can process the edges (similarity) incrementally. Since $N$ and $L$ are comparable, $O(N^2 L)$ is the most straightforward and efficient implementation.
*DSU được ưu tiên hơn BFS/DFS ở đây vì ta có thể xử lý các cạnh (sự tương đồng) một cách tăng dần. Vì $N$ và $L$ tương đương nhau, $O(N^2 L)$ là cách triển khai trực tiếp và hiệu quả nhất.*
