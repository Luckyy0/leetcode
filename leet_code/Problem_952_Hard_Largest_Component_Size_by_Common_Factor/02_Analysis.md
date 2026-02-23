# Analysis for Largest Component Size by Common Factor
# *Phân tích cho bài toán Kích thước Thành phần Lớn nhất theo Thừa số Chung*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Nodes are numbers. Edge exists if GCD > 1. Find size of largest connected component.
*Các nút là số. Có cạnh nếu UCLN > 1. Tìm kích thước thành phần liên thông lớn nhất.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Brute Force: Check GCD for every pair. $O(N^2 \log(\max V))$. If $N=20000$, this is too slow ($4 \cdot 10^8$ ops).
- Factorization Approach:
  - If a number has prime factors $p_1, p_2, \dots$, it is connected to all other numbers having any of these prime factors.
  - We can consider prime factors as "intermediate nodes".
  - For each number $x$ in `nums`:
    - Find all prime factors of $x$.
    - Union the sets containing the prime factors and the number $x$ itself.
    - Specifically, `union(x, factor)`.
  - Or simpler: Union all prime factors of $x$. The number $x$ belongs to the component defined by its prime factors.
  - Wait, indices matter.
  - Let's map each number `x` to its prime factors.
  - Use Union-Find on the **factors**.
  - Example: `nums = [4, 6, 15]`
    - 4: factors {2}. Union(2, 2).
    - 6: factors {2, 3}. Union(2, 3).
    - 15: factors {3, 5}. Union(3, 5).
    - Result: {2, 3, 5} are connected.
  - Then iterate through `nums` again. Find the root parent of its prime factor (e.g., first prime factor). Increment count for that root.
  - Max value is $10^5$. Max prime factor is $10^5$.
  - Sieve of Eratosthenes to find smallest prime factor (SPF) or iterate up to $\sqrt{x}$.
  - Since max value is small ($10^5$), iterating up to $\sqrt{10^5} \approx 316$ is fast.
*Phương pháp phân tích thừa số: Hợp nhất các thừa số nguyên tố của mỗi số. Dùng Union-Find trên các thừa số. max value nhỏ nên phân tích nhanh.*

---

## 2. Strategy: Union-Find on Prime Factors
## *2. Chiến lược: Union-Find trên Thừa số Nguyên tố*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Union-Find Init:** Array size `max(nums) + 1`. `parent[i] = i`.
    *   **Khởi tạo UF:** Kích thước bằng giá trị lớn nhất.*

2.  **Iterate `nums`:** For each num `x`:
    - Factorize `x`. Iterate `f` from 2 up to $\sqrt{x}$.
    - If `x % f == 0`:
      - `union(x, f)`.
      - While `x % f == 0`, `x /= f`.
      - `union(x, x_original)`. Wait, simpler: Union all factors with the number itself.
      - Actually, just unioning `f` with `x` is enough.
      - Then continue with reduced `x`.
    - If `x > 1` (remaining prime factor), `union(x, original_x)`.
    *   **Duyệt `nums`:** Phân tích thừa số `x`. Hợp nhất `x` với các thừa số của nó.*

3.  **Count Components:**
    - Use a HashMap or Array to count size of each component representing groups of numbers.
    - For each `n` in `nums`:
      - `root = find(n)`.
      - `count[root]++`.
    *   **Đếm thành phần:** Tìm cha của mỗi số trong `nums`, tăng biến đếm của cha đó.*

4.  **Result:** Max value in `count`.
    *   **Kết quả:** Max count.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    public int largestComponentSize(int[] nums) {
        int maxVal = Arrays.stream(nums).max().getAsInt();
        DSU dsu = new DSU(maxVal + 1);
        
        for (int num : nums) {
            int temp = num;
            for (int f = 2; f * f <= temp; f++) {
                if (temp % f == 0) {
                    dsu.union(num, f);
                    while (temp % f == 0) {
                        temp /= f;
                    }
                }
            }
            if (temp > 1) {
                dsu.union(num, temp);
            }
        }
        
        Map<Integer, Integer> count = new HashMap<>();
        int maxSize = 0;
        
        for (int num : nums) {
            int root = dsu.find(num);
            count.put(root, count.getOrDefault(root, 0) + 1);
            maxSize = Math.max(maxSize, count.get(root));
        }
        
        return maxSize;
    }
    
    class DSU {
        int[] parent;
        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) parent[rootX] = rootY;
        }
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \sqrt{M} \cdot \alpha(M))$ where $M$ is max value in `nums`. Factorization takes $\sqrt{M}$.
    *   **Độ phức tạp thời gian:** $O(N \sqrt{M})$.*
*   **Space Complexity:** $O(M)$ for DSU array.
    *   **Độ phức tạp không gian:** $O(M)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Union-Find over factors is the standard solution for connectivity based on divisibility.
*Union-Find trên các thừa số là giải pháp tiêu chuẩn cho tính liên thông dựa trên khả năng chia hết.*
