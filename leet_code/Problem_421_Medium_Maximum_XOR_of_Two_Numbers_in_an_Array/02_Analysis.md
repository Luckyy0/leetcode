# Analysis for Maximum XOR of Two Numbers in an Array
# *Phân tích cho bài toán XOR lớn nhất của hai số trong một mảng*

## 1. Problem Essence & Greedy Bit-by-Bit
## *1. Bản chất vấn đề & Tham lam từng Bit*

### The Challenge
### *Thách thức*
Finding two numbers in an array whose XOR sum is maximized. $O(N^2)$ is too slow given $N = 2 \times 10^5$. We need a more efficient way to "build" the best result bit by bit from left to right.

### Strategy: Greedy with Prefix Set
### *Chiến lược: Tham lam với Tập hợp Tiền tố*
1.  **Iterate from MSB to LSB:** We try to build the max XOR result bit by bit, from the 30th bit down to the 0th bit.
2.  **Hypothesis:** At each bit position `i`, assume the maximum possible result so far is `maxResult`. Let's see if we can set the `i`-th bit of `maxResult` to `1`.
    -   `hypotheticalMax = maxResult | (1 << i)`
3.  **Prefix Check:**
    -   Store all prefixes of length `31 - i` for every number in a `Set`.
    -   For every prefix `p` in the set, check if there exists another prefix `q` such that `p ^ q == hypotheticalMax`.
    -   This is equivalent to checking if `p ^ hypotheticalMax` exists in the set (since if $p \oplus q = R$ then $p \oplus R = q$).
4.  **Update:** If such an element exists, update `maxResult = hypotheticalMax`.

---

## 2. Approach: Bitmasking & Set Lookup
## *2. Hướng tiếp cận: Sử dụng Bitmask & Tra cứu Tập hợp*

### Logic
### *Logic*
(See above). We use a bitmask like `1111000...` to extract the prefix of all numbers in each iteration.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **O(N * log(MaxVal)) Efficiency:** Linear pass per bit position (31 passes in total).
    *Hiệu quả O(N * log(MaxVal)): Duyệt tuyến tính cho mỗi vị trí bit (tổng cộng 31 lần).*
*   **Intuitive Bit-Building:** Correctly prioritizes higher-order bits, which carry more weight in the final result.
    *Xây dựng bit trực quan: Ưu tiên các bit cao hơn, vì chúng có giá trị lớn hơn trong kết quả cuối.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(31 \times N)$.
    *Độ phức tạp thời gian: $O(31 \times N)$.*
*   **Space Complexity:** $O(N)$ for the `Set` of prefixes.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `nums = [3, 10, 5, 25, 2, 8]` (Binary: `00011, 01010, 00101, 11001, 00010, 01000`)
1. **Bit 4:** `hypo = 10000`. Prefixes contain `10000`. `10000 ^ 00000`? No.
2. ...
3. Building the bits step by step ensures we get the most "1"s in the most significant positions.
Result: 28.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Greedy bit-building from MSB to LSB using a HashSet for prefixes.
*Xây dựng bit tham lam từ MSB sang LSB sử dụng HashSet cho tiền tố.*
---
*Cuộc sống là một chuỗi các sự lựa chọn mang tính "loại trừ" (XOR). Để đạt được giá trị cao nhất (max result), ta phải bắt đầu từ những quyết định quan trọng nhất (most significant bits) và kiểm tra khả năng thực hiện (set check) của chúng trong một rừng dữ liệu (prefixes). Sự chính xác trong từng bit sẽ dẫn lối đến đỉnh cao tuyệt đối.*
Life is a series of "exclusive" (XOR) choices. To achieve the highest value (max result), we must start from the most significant decisions (most significant bits) and check their feasibility (set check) in a forest of data (prefixes). Precision in each bit will lead to the absolute peak.
