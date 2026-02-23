# Analysis for Sum of Even Numbers After Queries
# *Phân tích cho bài toán Tổng của các số Chẵn sau các Câu truy vấn*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Calculate the sum of all even numbers in `nums` after EACH query updates a single element.
*Tính tổng các số chẵn trong mảng sau MỖI lần cập nhật một phần tử.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Brute-force re-calculating the sum after each query takes $O(N \times Q)$, which will Time Out.
- We should maintain the `evenSum` dynamically.
- Total sum starts with the sum of all even numbers initially.
- When an element `nums[index]` changes:
  1. If `nums[index]` WAS even, we subtract it from `evenSum` (since it's going away or changing).
  2. We update `nums[index] += val`.
  3. If the NEW `nums[index]` IS even, we add it back to `evenSum`.
- This update takes $O(1)$ per query! Total time $O(N + Q)$.
*Duy trì tổng số chẵn. Trừ giá trị cũ (nếu nó chẵn), cập nhật giá trị mới, và cộng giá trị mới (nếu nó chẵn) vào tổng. Cập nhật trong $O(1)$ thời gian.*

---

## 2. Strategy: Running Sum
## *2. Chiến lược: Tổng cộng dồn (Tổng di động)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Sum:** Iterate `nums` and calculate the initial `sum` of all even values.
    *   **Khởi tạo Tổng:** Tính tổng các số chẵn ban đầu.*

2.  **Process Queries:** For each given query `[val, index]`:
    - Check if `nums[index]` is even. If so, `sum -= nums[index]`.
    - Apply the change: `nums[index] += val`.
    - Check if the updated `nums[index]` is even. If so, `sum += nums[index]`.
    - Store `sum` as the result for this query.
    *   **Xử lý Truy vấn:** Áp dụng trừ và cộng, sau đó trực tiếp cập nhật mảng giá trị của `nums[index]`.*

3.  **Return:** Array of results.
    *   **Trả về:** Mảng kết quả.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        // Compute initial sum of even numbers
        for (int x : nums) {
            if (x % 2 == 0) {
                sum += x;
            }
        }
        
        int[] result = new int[queries.length];
        
        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            
            // If the old value was even, remove it from the sum
            if (nums[index] % 2 == 0) {
                sum -= nums[index];
            }
            
            // Update the value
            nums[index] += val;
            
            // If the new value is even, add it to the sum
            if (nums[index] % 2 == 0) {
                sum += nums[index];
            }
            
            // Store the result
            result[i] = sum;
        }
        
        return result;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N + Q)$, where $N$ is the length of `nums` and $Q$ is the number of queries. We iterate through `nums` once initially and process each query in $O(1)$ time.
    *   **Độ phức tạp thời gian:** $O(N + Q)$.*
*   **Space Complexity:** $O(Q)$ to store the result array (or $O(1)$ if the result array is required output and not counted towards auxiliary space limits).
    *   **Độ phức tạp không gian:** Mảng kết quả kích thước $Q$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

This tracking-deltas approach is the standard pattern for multiple updates + range/overall query scenarios when calculating everything from scratch repeatedly is too slow.
*Cách tiếp cận theo dõi sự thay đổi (delta) là mẫu chuẩn hóa cho việc kết hợp nhiều cập nhật và truy vấn khi phương pháp vét cạn quá chậm.*
