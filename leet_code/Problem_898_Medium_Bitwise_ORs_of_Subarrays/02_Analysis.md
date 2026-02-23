# Analysis for Bitwise ORs of Subarrays
# *Phân tích cho bài toán OR bit của các mảng con*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the number of unique values obtainable by OR-ing contiguous subarrays.
*Tìm số lượng giá trị duy nhất có thể thu được bằng cách OR các mảng con liên tiếp.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Brute force checking all $O(N^2)$ subarrays is too slow ($N=50,000$).
- However, as we extend a subarray to the right, the OR value only changes when a **new bit is set**.
- Since integers are 32-bit (or ~30 bits for $10^9$), the OR value can only change monotonically (adding bits) **at most 30 times** for subarrays ending at a specific index `i`.
- Therefore, the number of distinct OR values ending at index `i` is small ($\le 30$).
*Kiểm tra vét cạn tất cả $O(N^2)$ mảng con là quá chậm. Tuy nhiên, khi ta mở rộng một mảng con sang phải, giá trị OR chỉ thay đổi khi một **bit mới được bật**. Vì các số nguyên có 32 bit, giá trị OR chỉ có thể thay đổi đơn điệu (thêm bit) **tối đa 30 lần** cho các mảng con kết thúc tại một chỉ số `i` cụ thể.*

---

## 2. Strategy: Dynamic Programming with Set Optimization
## *2. Chiến lược: Quy hoạch Động với Tối ưu hóa Tập hợp*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `ans` set to store all unique results found. `cur` set to store unique OR results for subarrays ending at the previous position.
    *   **Khởi tạo:** `ans` lưu tất cả kết quả duy nhất. `cur` lưu kết quả OR cho các mảng con kết thúc tại vị trí trước đó.*

2.  **Iterate:** Loop through each element `x` in `arr`.
    - Create `next` set.
    - Add `x` to `next`.
    - For each `val` in `cur`: add `val | x` to `next`.
    - Add all elements of `next` to `ans`.
    - Update `cur = next`.
    *   **Duyệt:** Với mỗi phần tử `x`. Tạo tập `next`. Thêm `x` vào `next`. Với mỗi `val` trong `cur`, thêm `val | x` vào `next`. Thêm tất cả `next` vào `ans`. Cập nhật `cur`.*

3.  **Return:** `ans.size()`.
    *   **Trả về:** Kích thước của `ans`.*

### Why is this efficient?
### *Tại sao cách này hiệu quả?*
The size of `cur` set is bounded by the number of bits (approx 30). So the inner loop runs at most 30 times. Total complexity is $O(30 \cdot N)$.
*Kích thước của tập `cur` bị giới hạn bởi số lượng bit (khoảng 30). Do đó, vòng lặp trong chạy tối đa 30 lần. Tổng độ phức tạp là $O(30 \cdot N)$.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int subarrayBitwiseORs(int[] arr) {
    Set<Integer> ans = new HashSet<>();
    Set<Integer> cur = new HashSet<>();
    
    for (int x : arr) {
        Set<Integer> next = new HashSet<>();
        next.add(x);
        for (int val : cur) {
            next.add(val | x);
        }
        cur = next;
        ans.addAll(cur);
    }
    
    return ans.size();
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot \log(\max(A)))$. In practice, bounded by $30N$.
    *   **Độ phức tạp thời gian:** $O(N \cdot 30)$.*
*   **Space Complexity:** $O(N \cdot \log(\max(A)))$ in worst case, but practically much smaller.
    *   **Độ phức tạp không gian:** $O(N \cdot 30)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Understanding the monotonic property of bitwise OR (bits only get set, never unset) allows us to realize that the number of distinct prefix-ORs is very small, enabling an efficient set-based solution.
*Hiểu được tính chất đơn điệu của phép OR bit (bit chỉ được bật, không bao giờ tắt) cho phép ta nhận ra rằng số lượng tiền tố OR khác biệt là rất nhỏ, giúp giải pháp dựa trên tập hợp trở nên hiệu quả.*
