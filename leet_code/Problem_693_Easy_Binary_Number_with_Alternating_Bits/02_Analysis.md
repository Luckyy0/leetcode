# Analysis for Binary Number with Alternating Bits
# *Phân tích cho bài toán Số Nhị phân có các Bit xen kẽ*

## 1. Problem Essence & Bitwise Symmetry
## *1. Bản chất vấn đề & Sự đối xứng của Bit*

### The Challenge
### *Thách thức*
We need to determine if a number, when written in binary, follows a pattern like `10101...` or `1010...`. Two consecutive bits must never be the same.
*Chúng ta cần xác định xem một con số, khi viết ở dạng nhị phân, có tuân theo mẫu `10101...` hay không. Hai bit liên tiếp không bao giờ được giống nhau.*

---

## 2. Strategy: Bit Manipulation Magic
## *2. Chiến lược: Ma thuật Thao tác Bit*

While we could convert the number to a string and check, there is a far more elegant bitwise approach.
*Mặc dù chúng ta có thể chuyển số thành chuỗi và kiểm tra, nhưng có một cách tiếp cận bằng bit tao nhã hơn nhiều.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Shift and XOR:** Let $m = n \oplus (n >> 1)$. 
    - If the bits of $n$ are alternating (e.g., `10101`), then $n >> 1$ will be `01010`.
    - XORing them will result in a sequence where every bit is `1` (e.g., `10101 ^ 01010 = 11111`).
    * **Dịch và XOR:** Gọi $m = n \oplus (n >> 1)$. Nếu các bit của $n$ xen kẽ, kết quả của phép XOR sẽ là một dãy toàn các bit 1.*

2.  **Check for All Ones:** A number $m$ consists of all ones if and only if $m \& (m + 1) == 0$.
    - For example, if $m = 111$ (7), then $m + 1 = 1000$ (8).
    - $111 \& 1000 = 0$.
    * **Kiểm tra Dãy toàn 1:** Một số $m$ gồm toàn bit 1 khi và chỉ khi $m \& (m + 1) == 0$.*

3.  **Conclusion:** If $(m \& (m + 1)) == 0$, return `true`. Otherwise, `false`.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Linear Time:** The bitwise operations are $O(1)$ relative to the size of the integer (constant time for 32-bit/64-bit integers).
    * **Thời gian Tuyến tính:** Các thao tác bit tốn thời gian không đổi $O(1)$.*
*   **Precision:** No extra memory (like strings) is needed, making it $O(1)$ space.
    * **Độ chính xác:** Không cần bộ nhớ phụ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(1)$. It performs a constant number of shifts and logic operations.
    * **Độ phức tạp thời gian:** $O(1)$.*
*   **Space Complexity:** $O(1)$.
    * **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** n = 5 (Binary 101)
1. `n >> 1`: 010 (binary).
2. `m = 101 ^ 010`: 111 (binary, decimal 7).
3. `m + 1`: 1000 (binary, decimal 8).
4. `m & (m + 1)`: `111 & 1000 = 0`.
**Result:** true.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Bit manipulation is the most efficient way to detect structural patterns in the binary representation of integers. Inverting bits (via XOR with a shifted version) is a powerful technique to transform alternating patterns into uniform patterns, which are then easily verifiable.
*Thao tác bit là cách hiệu quả nhất để phát hiện các mẫu cấu trúc trong nhị phân. Việc đảo bit thông qua XOR là một kỹ thuật mạnh mẽ để biến các mẫu xen kẽ thành các mẫu đồng nhất.*
---
*Sự xen kẽ (Alternating) của các bit thể hiện một sự cân bằng tuyệt đối giữa tồn tại (1) và hư vô (0). Trong dòng chảy của dữ liệu, phép dịch và phép loại trừ (XOR) giúp ta nhìn thấy sự đồng chất ẩn giấu (All ones) đằng sau vẻ ngoài thay đổi. Dữ liệu dạy ta rằng bằng cách soi chiếu một thực thể vào chính chiếc bóng của nó (Shift), ta có thể thấu thị được tính quy luật của toàn bộ hệ thống.*
The alternation (Alternation) of bits represents an absolute balance between existence (1) and nothingness (0). In the flow of data, shifts and exclusions (XOR) help us see the hidden homogeneity (All ones) behind the changing appearance. Data teaches us that by reflecting an entity onto its own shadow (Shift), we can see the regularity of the entire system.
