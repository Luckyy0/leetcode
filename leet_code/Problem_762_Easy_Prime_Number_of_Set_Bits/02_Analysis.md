# Analysis for Prime Number of Set Bits in Binary Representation
# *Phân tích cho bài toán Số lượng Bit Set là Số Nguyên tố trong Biểu diễn Nhị phân*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### The Challenge
### *Thách thức*
We need to count `1`s (set bits) for each number in a range. Then check if that count is prime.
*Chúng ta cần đếm số bit `1` (bit set) cho mỗi số trong phạm vi. Sau đó kiểm tra xem số lượng đó có phải là số nguyên tố hay không.*

### Range Analysis
### *Phân tích Phạm vi*
The maximum value of `right` is $10^6$. Since $2^{19} \approx 524,288$ and $2^{20} \approx 1,048,576$, the numbers will have at most 20 bits.
*Giá trị tối đa của `right` là $10^6$. Vì $2^{20} > 10^6$, các số sẽ có tối đa 20 bit.*

The possible number of set bits ranges from 1 to 20.
The primes in this range are: **2, 3, 5, 7, 11, 13, 17, 19**.
*Số lượng bit set có thể nằm trong khoảng từ 1 đến 20. Các số nguyên tố trong khoảng này là: **2, 3, 5, 7, 11, 13, 17, 19**.*

---

## 2. Strategy: Direct Iteration & Lookup
## *2. Chiến lược: Duyệt Trực tiếp & Tra cứu*

### Algorithm
### *Thuật toán*

1.  **Iteration (Duyệt):**
    Loop through numbers `i` from `left` to `right`.
    *Duyệt qua các số `i` từ `left` đến `right`.*

2.  **Bit Counting (Đếm Bit):**
    Use `Integer.bitCount(i)` (Java) or `__builtin_popcount` (C++) to find the number of set bits.
    *Sử dụng hàm có sẵn để tìm số lượng bit set.*

3.  **Prime Check (Kiểm tra Nguyên tố):**
    Since the set of possible primes is very small, we can use a boolean set, a switch case, or a bitmask integer to check "isPrime".
    *Vì tập hợp số nguyên tố rất nhỏ, ta có thể dùng tập hợp boolean, switch case, hoặc bitmask để kiểm tra.*
    
    Using a bitmask: `magic = 0b10100010100010101100`? No, simpler:
    Primes: 2, 3, 5, 7, 11, 13, 17, 19.
    Mask: Set bits at these indices to 1.
    `mask = (1<<2) | (1<<3) | (1<<5) | (1<<7) | (1<<11) | (1<<13) | (1<<17) | (1<<19)`
    Check: `((mask >> k) & 1) == 1`.

### Code Logic Preview
### *Xem trước Logic Mã*

```java
public int countPrimeSetBits(int left, int right) {
    // 665772 = 10100010100010101100 in binary
    // Representing primes: 2, 3, 5, 7, 11, 13, 17, 19
    int primeMask = 665772; 
    int count = 0;
    
    for (int i = left; i <= right; i++) {
        int bits = Integer.bitCount(i);
        // Check if the 'bits'-th bit in primeMask is 1
        // Kiểm tra xem bit thứ 'bits' trong primeMask có phải là 1 không
        if (((primeMask >> bits) & 1) == 1) {
            count++;
        }
    }
    return count;
}
```

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O((R-L) \cdot \log(\text{val}))$. `bitCount` typically takes logarithmic time w.r.t value (number of bits). Here it's effectively $O(1)$ since max bits is 20. Total is $O(N)$ where $N$ is range size.
    *   **Độ phức tạp thời gian:** $O(N)$ với $N$ là kích thước phạm vi.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:** 6 to 10
- 6 (110): bits=2. Is prime? Yes. Count=1.
- 7 (111): bits=3. Is prime? Yes. Count=2.
- 8 (1000): bits=1. Is prime? No.
- 9 (1001): bits=2. Is prime? Yes. Count=3.
- 10 (1010): bits=2. Is prime? Yes. Count=4.
**Result:** 4.

**The Bitmask Construction:**
 Indices: 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 0
 Primes:  1  0  1  0  0  0  1  0  1  0 0 0 1 0 1 0 1 1 0 0
 Value:   `0b10100010100010101100` = `665772`.
