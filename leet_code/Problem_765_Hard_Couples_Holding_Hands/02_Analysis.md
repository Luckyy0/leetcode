# Analysis for Couples Holding Hands
# *Phân tích cho bài toán Các Cặp đôi Nắm Tay*

## 1. Problem Essence & Cyclic Permutation
## *1. Bản chất vấn đề & Hoán vị Vòng*

### The Challenge
### *Thách thức*
We have seats grouped into couches `[0,1], [2,3], ...`. Each couch should hold a couple satisfying `(x, x^1)`.
*Chúng ta có các ghế được nhóm thành các băng ghế đôi. Mỗi băng ghế nên chứa một cặp đôi thỏa mãn `(x, x^1)` (nghĩa là `0` với `1`, `2` với `3`...).*

This can be modeled as a graph where nodes are "Couches" (0 to n-1) and edges represent "who is sitting here". If Couch 0 has person 0 (Couple A) and person 2 (Couple B), it means Couch 0 connects Couple A and Couple B.
*Bài toán có thể mô hình hóa dưới dạng đồ thị nơi các nút là "Băng ghế" và các cạnh đại diện cho "ai đang ngồi ở đây".*

If we view this as a permutation problem, the minimum swaps needed to sort a cycle of size $k$ is $k-1$.
The total swaps = $\sum (\text{cycle\_size} - 1) = N - \text{number\_of\_cycles}$.
*Nếu xem đây là bài toán hoán vị, số lần hoán đổi tối thiểu để sắp xếp một chu trình kích thước $k$ là $k-1$. Tổng số hoán đổi = $N - \text{số lượng chu trình}$.*

### Connection Logic
### *Logic Kết nối*
- Person `x` belongs to Couple `x/2`.
- The seats are grouped as `(0,1), (2,3), ...`.
- For each seat pair `i` (indices `2i, 2i+1`):
    - Person `p1 = row[2i]` is from Couple `p1/2`.
    - Person `p2 = row[2i+1]` is from Couple `p2/2`.
    - If `p1/2 != p2/2`, we have an edge between Node `p1/2` and Node `p2/2`.
    *   *Người `x` thuộc Cặp `x/2`. Ghế được nhóm đôi. Nếu hai người ngồi trên cùng băng ghế thuộc hai cặp khác nhau, ta có một cạnh nối hai nút Cặp đó.*

---

## 2. Strategy: Union-Find (DSU) or Cyclic Graph
## *2. Chiến lược: Union-Find (DSU) hoặc Đồ thị Vòng*

### Algorithm
### *Thuật toán*

1.  **DSU Initialization:** `n` elements (representing the `n` couples).
    *   **Khởi tạo DSU:** `n` phần tử (đại diện cho `n` cặp đôi).*

2.  **Iterate Seats:**
    - Loop `i` from 0 to `n-1`.
    - People at current couch: `u = row[2*i]`, `v = row[2*i + 1]`.
    - They belong to Couple `u/2` and Couple `v/2`.
    - `Union(u/2, v/2)`.
    *   **Duyệt Ghế:** Lặp qua từng băng ghế. Liên kết hai cặp tương ứng thông qua phép Union.*

3.  **Calculate Result:**
    - Initially, we assume we need `n` discrete components (everyone is happy). No swaps needed means `n` components.
    - Every successful `Union` (merging two different components) reduces the number of components by 1.
    - Minimum swaps = `Initial Components` - `Final Components`? No.
    - Min swaps = `n` - `number of connected components`.
    - Why? If we have a cycle of $k$ nodes, we need $k-1$ swaps to break it into $k$ self-loops.
    - Total swaps = $\sum (size_i - 1) = \sum size_i - \sum 1 = n - \text{num\_components}$.
    *   **Tính toán Kết quả:** Số lần hoán đổi tối thiểu = `n` - `số lượng thành phần liên thông`.*

### Code Logic Preview
### *Xem trước Logic Mã*

```java
// DSU structure
int[] parent = new int[n];
for(int i=0; i<n; i++) parent[i] = i;

// Iterate couches
for(int i = 0; i < n; i++) {
    int p1 = row[2*i];
    int p2 = row[2*i+1];
    
    // Couples involved
    int c1 = p1 / 2;
    int c2 = p2 / 2;
    
    union(c1, c2);
}

// Result
return n - countConnectedComponents();
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \alpha(N))$ or $O(N)$ with simplified DSU. Given constraints $N \le 30$, even $O(N^2)$ is fine.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for DSU parent array.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:** `[0, 2, 1, 3]` (Couches: `(0,2)`, `(1,3)`)
- Couch 0: People 0 (Couple 0) and 2 (Couple 1). Union(0, 1). Parent `[0, 0]`. Count=1.
- Couch 1: People 1 (Couple 0) and 3 (Couple 1). Union(0, 1). Already same set.
- Components: 1.
- N = 2 couples.
- Swaps = 2 - 1 = 1.
**Result:** 1.

**Input:** `[3, 2, 0, 1]`
- Couch 0: 3(C1), 2(C1). Union(1, 1).
- Couch 1: 0(C0), 1(C0). Union(0, 0).
- Components: 2 (Couple 1 is one, Couple 0 is another).
- Swaps = 2 - 2 = 0.
**Result:** 0.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

The problem maps directly to finding cycles in a permutation graph. DSU is the cleanest implementation.
*Bài toán ánh xạ trực tiếp đến việc tìm chu trình trong đồ thị hoán vị. DSU là cách cài đặt gọn gàng nhất.*
