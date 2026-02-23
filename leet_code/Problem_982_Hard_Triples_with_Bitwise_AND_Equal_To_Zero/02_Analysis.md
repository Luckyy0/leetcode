# Analysis for Triples with Bitwise AND Equal To Zero
# *Phân tích cho bài toán Bộ ba có AND Bitwise Bằng Không*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find count of $(i, j, k)$ such that `nums[i] & nums[j] & nums[k] == 0`.
*Đếm số bộ ba sao cho toán tử AND trả về 0.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Brute force $O(N^3)$ is $10^9$, too slow ($N \le 1000$).
- Values are small ($< 2^{16} = 65536$).
- Precompute pairs $(i, j)$ first.
- Let `count[v]` be the number of pairs $(i, j)$ such that `nums[i] & nums[j] == v`.
- Then iterate $k$ and iterate over all possible values `v` (from 0 to 65535).
- If `nums[k] & v == 0`, add `count[v]` to answer.
- Complexity: $O(N^2 + N \cdot 2^{16})$.
- $N^2 = 10^6$. $N \cdot 2^{16} \approx 6.5 \cdot 10^7$.
- Total operations $\approx 7 \cdot 10^7$, well within 1-2 seconds limit.
*Tính trước tần suất kết quả AND của các cặp. Sau đó duyệt k và các giá trị kết quả đã tính.*

---

## 2. Strategy: Precompute Pairs
## *2. Chiến lược: Tính trước Cặp*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Count Pairs:** Array `count[65536]`.
    - Iterate $i, j$ from 0 to $N-1$.
    - `count[nums[i] & nums[j]]++`.
    *   **Đếm Cặp:** Tính tần suất AND của mọi cặp.*

2.  **Iterate Triples:** `result = 0`.
    - Iterate $k$ from 0 to $N-1$.
    - Iterate `val` from 0 to 65535.
    - If `(nums[k] & val) == 0`: `result += count[val]`.
    *   **Duyệt Bộ ba:** Kiểm tra điều kiện với phần tử thứ 3.*

3.  **Optimization:** Since `count[val]` is often 0, we can just iterate `val` where `count[val] > 0`. Or iterating 0 to 65535 is fast enough because it's a fixed loop.
    *   **Tối ưu:** Duyệt qua mảng cố định kích thước 65536.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public int countTriplets(int[] nums) {
        int[] count = new int[1 << 16];
        
        // Step 1: Count frequency of (nums[i] & nums[j])
        for (int x : nums) {
            for (int y : nums) {
                count[x & y]++;
            }
        }
        
        int ans = 0;
        
        // Step 2: Iterate through nums[k] and all possible pair-AND values
        for (int x : nums) {
            // Iterate all possible pair-AND values
            for (int val = 0; val < (1 << 16); val++) {
                // Optimization: Check if count[val] > 0
                if (count[val] == 0) continue;
                
                if ((x & val) == 0) {
                    ans += count[val];
                }
            }
        }
        
        return ans;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2 + N \cdot 2^{16})$.
    *   **Độ phức tạp thời gian:** $O(N^2 + N \cdot 2^{16})$.*
*   **Space Complexity:** $O(2^{16})$ for count array.
    *   **Độ phức tạp không gian:** $O(2^{16})$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Trading time for space by precomputing pair counts is the standard way to reduce $O(N^3)$ to roughly $O(N^2)$.
*Đổi thời gian lấy không gian bằng cách tính trước các cặp giúp giảm độ phức tạp từ $O(N^3)$ xuống xấp xỉ $O(N^2)$.*
