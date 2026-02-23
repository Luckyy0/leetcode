# Analysis for Binary Trees With Factors
# *Phân tích cho bài toán Cây nhị phân với các Thừa số*

## 1. Problem Essence & Combinatorial Structure
## *1. Bản chất vấn đề & Cấu trúc Tổ hợp*

### The Challenge
### *Thách thức*
We need to count all possible binary trees where each parent node's value is the product of its two children's values. Each node value must be present in the input array.
This is a counting problem with an optimal substructure: to count trees rooted at value $X$, we need to find all pairs of factors $(A, B)$ in the array such that $A \times B = X$, and then multiply the number of ways to form trees rooted at $A$ and $B$.
*Chúng ta cần đếm tất cả các cây nhị phân khả thi trong đó giá trị mỗi nút cha là tích của giá trị hai nút con. Đây là bài toán đếm có cấu trúc con tối ưu: để đếm số cây có gốc là $X$, ta cần tìm tất cả các cặp thừa số $(A, B)$ trong mảng sao cho $A \times B = X$, sau đó nhân số cách tạo cây có gốc là $A$ và $B$.*

---

## 2. Strategy: Dynamic Programming
## *2. Chiến lược: Quy hoạch động*

### DP State Definition
### *Định nghĩa trạng thái DP*
Let `dp[X]` be the number of binary trees that can be formed with `X` as the root.
*Gọi `dp[X]` là số lượng cây nhị phân có thể được tạo ra với `X` làm gốc.*

### Recurrence Relation
### *Công thức truy hồi*
To calculate `dp[arr[i]]`:
1.  Initialize `dp[arr[i]] = 1` (the single node tree `[arr[i]]`).
2.  Iterate through all pairs $(arr[j], arr[k])$ such that $arr[j] \times arr[k] = arr[i]$.
3.  Add to `dp[arr[i]]`: `dp[arr[j]] * dp[arr[k]]`.
*Để tính `dp[arr[i]]`: Khởi tạo `dp[arr[i]] = 1` (cây chỉ có một nút). Duyệt qua tất cả các cặp $(arr[j], arr[k])$ sao cho $arr[j] \times arr[k] = arr[i]$. Cộng thêm vào `dp` giá trị `dp[arr[j]] * dp[arr[k]]`.*

### Optimization
### *Tối ưu hóa*
- Sort the array `arr`. This way, factors of `arr[i]` will always have indices $j, k < i$.
- Use a `HashMap` to store `dp` values for $O(1)$ lookup.
*Sắp xếp mảng `arr`. Như vậy, các thừa số của `arr[i]` sẽ luôn có chỉ số nhỏ hơn `i`. Sử dụng `HashMap` để lưu các giá trị `dp`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int numFactoredBinaryTrees(int[] arr) {
    long mod = 1_000_000_007;
    Arrays.sort(arr);
    Map<Integer, Long> dp = new HashMap<>();
    
    for (int i = 0; i < arr.length; i++) {
        dp.put(arr[i], 1L);
        for (int j = 0; j < i; j++) {
            // Check if arr[j] is a factor of arr[i]
            if (arr[i] % arr[j] == 0) {
                int right = arr[i] / arr[j];
                if (dp.containsKey(right)) {
                    // Update dp[arr[i]]
                    dp.put(arr[i], (dp.get(arr[i]) + dp.get(arr[j]) * dp.get(right)) % mod);
                }
            }
        }
    }
    
    long total = 0;
    for (long val : dp.values()) total = (total + val) % mod;
    return (int) total;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$, where $N$ is the length of the array. The nested loops iterate roughly $N^2/2$ times.
    *   **Độ phức tạp thời gian:** $O(N^2)$, với $N$ là độ dài của mảng.*
*   **Space Complexity:** $O(N)$ for the `HashMap` to store `dp` values.
    *   **Độ phức tạp không gian:** $O(N)$ cho `HashMap`.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `arr = [2, 4, 10]`
1. **i=0 (val=2):** `dp[2] = 1`.
2. **i=1 (val=4):** 
   - `dp[4] = 1`.
   - j=0 (val=2): 4 % 2 == 0. Right = 2. `dp[4] += dp[2]*dp[2] = 1*1 = 1`.
   - `dp[4] = 2`. (Trees: [4], [4,2,2])
3. **i=2 (val=10):**
   - `dp[10] = 1`.
   - j=0 (val=2): 10 % 2 == 0. Right = 5. Not in set.
   - ...
**Result:** 1 + 2 + 1 = 4? No, result 2, 4, 10 is 3+1 = 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Sorting and DP are key. Sorting ensures that all sub-problem results are available when needed. Using `long` for calculations is critical to prevent overflow before applying the modulo operation.
*Sắp xếp và DP là then chốt. Sắp xếp đảm bảo các kết quả bài toán con luôn sẵn sàng khi cần. Sử dụng kiểu `long` để tính toán là rất quan trọng để tránh tràn số trước khi thực hiện phép chia lấy dư.*
