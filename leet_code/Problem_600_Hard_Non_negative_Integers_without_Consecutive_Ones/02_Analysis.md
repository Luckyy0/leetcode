# Analysis for Non-negative Integers without Consecutive Ones
# *Phân tích cho bài toán Số nguyên Không âm không có Hai chữ số 1 Liên tiếp*

## 1. Problem Essence & Combinatorial Constraints
## *1. Bản chất vấn đề & Ràng buộc Tổ hợp*

### The Challenge
### *Thách thức*
We need to count all non-negative integers up to $N$ whose binary representation does not have `11`.
*Chúng ta cần đếm tất cả các số nguyên không âm đến $N$ mà biểu diễn nhị phân của chúng không có `11`.*

This can be broken down into two parts:
*Điều này có thể được chia thành hai phần:*
1.  How many valid strings of length $K$ exist? (This is a Fibonacci property).
    *Có bao nhiêu chuỗi hợp lệ độ dài $K$ tồn tại? (Đây là đặc tính Fibonacci).*
2.  How many of those are less than or equal to $N$? (Digit-by-digit verification).
    *Có bao nhiêu chuỗi trong số đó nhỏ hơn hoặc bằng $N$? (Xác minh từng chữ số).*

---

## 2. Strategy: Binary Digit DP with Fibonacci
## *2. Chiến lược: Quy hoạch động chữ số Nhị phân với Fibonacci*

### The Fibonacci Connection
### *Mối liên hệ Fibonacci*
Let $f[k]$ be the number of binary strings of length $k$ without consecutive ones.
*Gọi $f[k]$ là số chuỗi nhị phân độ dài $k$ không có hai số một liên tiếp.*
- $f[0] = 1$ (empty string)
- $f[1] = 2$ ("0", "1")
- $f[2] = 3$ ("00", "01", "10")
- $f[3] = 5$ ("000", "001", "010", "100", "101")
- Recurrence: $f[k] = f[k-1] + f[k-2]$.

### Step-by-Step Logic
### *Logic từng bước*

1.  **Preparation:** Precompute the Fibonacci array $f$ up to 32 (since $N \le 10^9$).
    * **Chuẩn bị:** Tính trước mảng Fibonacci $f$ lên đến 32 (vì $N \le 10^9$).*

2.  **Binary Conversion:** Represent $N$ in binary.
    * **Chuyển đổi Nhị phân:** Biểu diễn $N$ trong hệ nhị phân.*

3.  **Digit-by-Digit Scan:** Scan from the highest bit (left to right).
    * **Quét từng chữ số:** Quét từ bit cao nhất (trái sang phải).*
    - If the current bit is `1`:
      - All valid numbers with a `0` at this position and shorter prefixes are covered by $f[k]$ (where $k$ is the current bit position). Add $f[k]$ to `result`.
      - *Nếu bit hiện tại là `1`: Tất cả các số hợp lệ với số `0` ở vị trí này và các tiền tố ngắn hơn được bao phủ bởi $f[k]$ (với $k$ là vị trí bit hiện tại). Thêm $f[k]$ vào `result`.*
      - If the previous bit was also `1`: We hit a consecutive one (`11`). Since anything further will have `11` in its prefix, we stop and return the current `result`.
      - *Nếu bit trước đó cũng là `1`: Chúng ta gặp hai số một liên tiếp (`11`). Vì bất kỳ số nào xa hơn cũng sẽ có `11` trong tiền tố của nó, chúng ta dừng lại và trả về `result` hiện tại.*
    - Continue to the next bit.
    - *Tiếp tục với bit tiếp theo.*

4.  **Final Inclusion:** If we finish scanning without hitting `11`, add 1 to the result (representing $N$ itself).
    * **Bao hàm Cuối cùng:** Nếu chúng ta quét xong mà không gặp `11`, hãy cộng thêm 1 vào kết quả (đại diện cho chính số $N$).*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Mathematical Elegance:** Leveraging the Fibonacci property of binary strings is far more efficient than checking every number.
    * **Sự thanh lịch của Toán học:** Tận dụng đặc tính Fibonacci của chuỗi nhị phân hiệu quả hơn nhiều so với việc kiểm tra từng con số.*
*   **Precision:** Digit DP ensures we count exactly up to $N$ without overcounting or missing candidates.
    * **Độ chính xác:** Digit DP đảm bảo chúng ta đếm chính xác đến $N$ mà không đếm thừa hoặc bỏ sót các ứng viên.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$. We iterate through the bits of $N$ (at most 32 bits).
    * **Độ phức tạp thời gian:** $O(\log N)$. Chúng ta duyệt qua các bit của $N$ (tối đa 32 bit).*
*   **Space Complexity:** $O(1)$ beyond the small Fibonacci array.
    * **Độ phức tạp không gian:** $O(1)$ ngoài mảng Fibonacci nhỏ.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** N = 5 (Binary 101)
- f = [1, 2, 3, 5, 8...]
- Bit 2 (val=4): is 1. Add f[2] (3) to result. Result = 3. (Covers 000, 001, 010 -> but adjusted for bit scale).
- Bit 1 (val=2): is 0. Do nothing.
- Bit 0 (val=1): is 1. Add f[0] (1) to result. Result = 3 + 1 = 4.
- End scan. Add 1 for the number 5 itself.
- **Total:** 5.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For problems involving counting binary strings with constraints, look for recurrence relations (like Fibonacci or Lucas numbers) and use bitwise digit DP to calculate the upper bound.
*Đối với các bài toán liên quan đến đếm chuỗi nhị phân có ràng buộc, hãy tìm các hệ thức truy hồi (như số Fibonacci hoặc Lucas) và sử dụng digit DP theo bit để tính giới hạn trên.*
---
*Số một (One) trong hệ nhị phân là biểu tượng của sự hiện diện. Khi hai thực thể (Ones) đứng quá gần nhau (Consecutive), chúng tạo ra một xung đột (Conflict) bị cấm. Trí tuệ (Logic) nằm ở chỗ biết cách sắp xếp các khoảng trống (Zeros) để đạt được sự cân bằng mà không vi phạm quy luật.*
One (One) in binary is a symbol of presence. When two entities (Ones) stand too close together (Consecutive), they create a forbidden conflict (Conflict). Wisdom (Logic) lies in knowing how to arrange spaces (Zeros) to achieve balance without violating the rules.
