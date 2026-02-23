# Analysis for Add to Array-Form of Integer
# *Phân tích cho bài toán Cộng vào Dạng mảng của Số nguyên*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Add an integer `k` to another integer represented by an array `num` of its digits.
*Cộng một số nguyên `k` vào một số nguyên khác được biểu diễn bằng một mảng `num` chứa các chữ số của nó.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- The array `num` can be very long (up to 10^4 elements). This means converting the array to a primitive integer (like `long`) will cause an overflow.
- Instead of converting the array, we must perform the addition digit by digit, simulating how we add numbers on paper.
- Start from the least significant digit (right end of the array `num`).
- Add the corresponding digit from the array and `k` together.
- Extract the last digit of the sum (`sum % 10`) and add it to the result.
- Carry over the remaining part (`sum / 10`) to the next iteration by simply updating `k`.
- Proceed this way until both the array has been fully traversed AND `k` becomes 0.
*Không thể chuyển mảng thành số nguyên vì sẽ bị tràn bộ nhớ. Phải cộng từng chữ số từ phải sang trái. Cộng trực tiếp k vào từng chữ số, lấy modulo 10 làm kết quả chữ số hiện tại, phần nguyên chia 10 làm số nhớ (cập nhật lại k).*

---

## 2. Strategy: Right-to-Left Addition
## *2. Chiến lược: Cộng từ Phải sang Trái*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `n = num.length`, `i = n - 1`, and a `result` list.
    *   **Khởi tạo:** `n = num.length`, `i = n - 1`, và danh sách `result`.*

2.  **Iterate:** Loop while `i >= 0` or `k > 0`.
    - At each step, if `i >= 0`, add `num[i]` to `k`. (Now `k` holds the sum of the current place value including any carry from previous steps).
    - Add the last digit of `k` (`k % 10`) to the `result` list.
    - Update `k` to represent the carry by dividing it by 10 (`k /= 10`).
    - Decrement `i`.
    *   **Vòng lặp:** Cộng trực tiếp `num[i]` vào `k`. Thêm chữ số hàng đơn vị `k % 10` vào kết quả, và giữ phần nhớ cho lần mảng tiếp theo.*

3.  **Reverse:** Since we added digits from least significant to most significant, the `result` list is backward. Reverse it before returning.
    *   **Đảo ngược:** Danh sách thu được bị ngược, cần lật ngược trước khi trả về.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
import java.util.*;

public class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;
        
        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
            }
            result.add(k % 10);
            k /= 10;
            i--;
        }
        
        Collections.reverse(result);
        return result;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\max(N, \log_{10} K))$ where $N$ is the length of `num` and $\log_{10} K$ is the number of digits in `K`. We process each logical digit exactly once.
    *   **Độ phức tạp thời gian:** $O(\max(N, \log_{10} K))$.*
*   **Space Complexity:** $O(\max(N, \log_{10} K))$ to hold the answer in the result list.
    *   **Độ phức tạp không gian:** không gian cần thiết cho mảng kết quả.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

This direct addition approach is perfectly suited to handle arbitrarily large numbers represented as arrays without overflow issues.
*Cách tiếp cận cộng trực tiếp hoàn toàn phù hợp để xử lý các con số lớn được biểu diễn dưới dạng mảng để tránh bị tràn bộ nhớ.*
