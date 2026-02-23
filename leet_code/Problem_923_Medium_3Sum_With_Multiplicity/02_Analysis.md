# Analysis for 3Sum With Multiplicity
# *Phân tích cho bài toán 3Sum Với Đa hình*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Count tuples `(i, j, k)` with `i < j < k` such that `arr[i] + arr[j] + arr[k] == target`.
*Đếm số bộ ba `(i, j, k)` với `i < j < k` sao cho `arr[i] + arr[j] + arr[k] == target`.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The input array length is up to 3000, so $O(N^2)$ is acceptable.
- However, the values `arr[i]` are small (0 to 100).
- This constraint allows us to count the frequency of each number first.
- Let `count[x]` be the number of occurrences of value `x`.
- We can iterate through all unique triplets `(x, y, z)` such that `x + y + z == target`.
- For each valid triplet, calculate how many ways to form it using combinations:
  - If `x != y != z`: `count[x] * count[y] * count[z]`.
  - If `x == y != z`: `C(count[x], 2) * count[z]`.
  - If `x != y == z`: `count[x] * C(count[y], 2)`.
  - If `x == y == z`: `C(count[x], 3)`.
- Iterate `x` (0 to 100) and `y` (x to 100). Calculate `z = target - x - y`.
- Check if `z` is valid (y <= z <= 100).
- Sum up the possibilities modulo $10^9 + 7$.
*Độ dài mảng lên tới 3000, $O(N^2)$ chấp nhận được. Nhưng giá trị `arr[i]` nhỏ (0-100). Ta có thể đếm tần suất mỗi số trước. Sau đó duyệt qua các bộ ba giá trị `(x, y, z)` duy nhất thỏa mãn tổng bằng target. Tính tổ hợp dựa trên tần suất.*

---

## 2. Strategy: Count Frequency + Combinatorics
## *2. Chiến lược: Đếm Tần suất + Tổ hợp*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Frequency Map:** Count occurrences of each number `0..100`.
    *   **Bản đồ Tần suất:** Đếm số lần xuất hiện của các số `0..100`.*

2.  **Iterate:** `x` from 0 to 100.
    - `y` from `x` to 100.
    - `z = target - x - y`.
    - If `z < y` or `z > 100`, continue. (Ensure `x <= y <= z`).
    - **Case 1: `x == y == z`**: Add `C(count[x], 3)`.
    - **Case 2: `x == y != z`**: Add `C(count[x], 2) * count[z]`.
    - **Case 3: `x != y == z`**: Add `count[x] * C(count[y], 2)`.
    - **Case 4: `x != y != z`**: Add `count[x] * count[y] * count[z]`.
    *   **Duyệt:** `x`, `y` để tính `z`. Đảm bảo `x <= y <= z`. Xét các trường hợp số giống nhau để tính tổ hợp.*

3.  **Modulo:** Apply modulo $10^9 + 7$ at each addition.
    *   **Modulo:** Áp dụng modulo.*

### Combinations Formulas
### *Công thức Tổ hợp*
- `C(n, 2) = n * (n - 1) / 2`
- `C(n, 3) = n * (n - 1) * (n - 2) / 6`

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int threeSumMulti(int[] arr, int target) {
    long[] count = new long[101];
    for (int x : arr) {
        count[x]++;
    }
    
    long ans = 0;
    long MOD = 1_000_000_007;
    
    // Iterate x <= y <= z
    for (int x = 0; x <= 100; x++) {
        for (int y = x; y <= 100; y++) {
            int z = target - x - y;
            if (z < y || z > 100) continue;
            
            if (x == y && y == z) {
                ans += count[x] * (count[x] - 1) * (count[x] - 2) / 6;
            } else if (x == y && y != z) {
                ans += count[x] * (count[x] - 1) / 2 * count[z];
            } else if (x < y && y == z) {
                ans += count[x] * count[y] * (count[y] - 1) / 2;
            } else { // x < y < z
                ans += count[x] * count[y] * count[z];
            }
            
            ans %= MOD;
        }
    }
    
    return (int) ans;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(101^2 + N) \approx O(1)$ effectively, or $O(N + W^2)$ where $W$ is the range of values.
    *   **Độ phức tạp thời gian:** $O(N + W^2)$.*
*   **Space Complexity:** $O(W)$ for count array.
    *   **Độ phức tạp không gian:** $O(W)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Leveraging the small range of values (0-100) makes the counting strategy extremely efficient compared to generic 3Sum.
*Tận dụng phạm vi giá trị nhỏ (0-100) làm cho chiến lược đếm cực kỳ hiệu quả so với 3Sum thông thường.*
