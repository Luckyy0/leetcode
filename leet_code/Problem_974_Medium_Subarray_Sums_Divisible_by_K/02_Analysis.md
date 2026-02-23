# Analysis for Subarray Sums Divisible by K
# *Phân tích cho bài toán Tổng mảng con chia hết cho K*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find number of contiguous subarrays summing to a multiple of `K`.
*Tìm số lượng mảng con liên tiếp có tổng là bội số của K.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Standard Prefix Sum trick.
- `sum[i..j] = P[j] - P[i-1]`.
- We want `(P[j] - P[i-1]) % K == 0`.
- This means `P[j] % K == P[i-1] % K`.
- Compute prefix sums modulo `K`.
- For any remainder value `r` appearing `count` times, the number of pairs with that remainder is `count * (count - 1) / 2`.
- Careful with negative numbers: `(-2) % 5 = -2` in Java. We want `3`.
- Normalize: `rem = (sum % K + K) % K`.
- Initialize with `P[-1] = 0` having remainder 0 (count for 0 starts at 1).
*Sử dụng mảng tổng tiền tố. Hai tổng tiền tố có cùng số dư khi chia cho K thì hiệu của chúng chia hết cho K. Chuẩn hóa số dư âm.*

---

## 2. Strategy: Prefix Sum Frequency
## *2. Chiến lược: Tần suất Tổng Tiền tố*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Count Array:** `count` of size `K`. `count[0] = 1` (empty prefix).
    *   **Mảng đếm:** `count[0] = 1`.*

2.  **Iterate:** `num` in `nums`.
    - `sum += num`.
    - `rem = (sum % K + K) % K`.
    - `ans += count[rem]`.
    - `count[rem]++`.
    *   **Duyệt:** Tính tổng, chuẩn hóa số dư, cộng dồn kết quả.*

3.  **Return:** `ans`.
    *   **Trả về:** `ans`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        count[0] = 1; // Consider empty prefix sum 0
        int prefixSum = 0;
        int result = 0;
        
        for (int num : nums) {
            prefixSum += num;
            // Handle negative remainders
            int remainder = (prefixSum % k + k) % k;
            
            // Add previous occurrences of this remainder
            result += count[remainder];
            
            // Increment count for this remainder
            count[remainder]++;
        }
        
        return result;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Single pass.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(K)$. Array size `K`.
    *   **Độ phức tạp không gian:** $O(K)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Classic prefix sum modulo arithmetic problem.
*Bài toán số học modulo tổng tiền tố kinh điển.*
