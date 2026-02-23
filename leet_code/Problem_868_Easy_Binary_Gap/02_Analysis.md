# Analysis for Binary Gap
# *Phân tích cho bài toán Khoảng cách Nhị phân*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the maximum distance between two consecutive `1`s in the binary representation of a number. $N \le 10^9$ means it fits in a 32-bit integer.
*Tìm khoảng cách tối đa giữa hai số `1` liên tiếp trong biểu diễn nhị phân của một số. $N \le 10^9$ có nghĩa là nó vừa với một số nguyên 32 bit.*

---

## 2. Strategy: Linear Bit Scanning
## *2. Chiến lược: Quét bit tuyến tính*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterate through bits:** Use a loop to check each bit of $N$ (from LSB to MSB).
    *   **Duyệt qua các bit:** Sử dụng một vòng lặp để kiểm tra từng bit của $N$ (từ LSB đến MSB).*

2.  **Track the Last '1':** Use a variable `lastPos` to store the index of the most recently encountered `1`. Initialize it to `-1`.
    *   **Theo dõi số '1' cuối cùng:** Sử dụng một biến `lastPos` để lưu trữ chỉ số của số `1` gặp gần đây nhất. Khởi tạo nó bằng `-1`.*

3.  **Calculate Distance:**
    - When a `1` is found at index `i`:
        - If `lastPos != -1`, a pair is found. Distance is `i - lastPos`.
        - Update `maxDist = Math.max(maxDist, i - lastPos)`.
        - Update `lastPos = i`.
    *   **Tính khoảng cách:** Khi tìm thấy số `1` tại chỉ số `i`: Nếu `lastPos != -1`, một cặp đã được tìm thấy. Khoảng cách là `i - lastPos`. Cập nhật `maxDist`. Cập nhật `lastPos = i`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int binaryGap(int n) {
    int last = -1, ans = 0;
    for (int i = 0; i < 32; i++) {
        if (((n >> i) & 1) > 0) {
            if (last != -1) ans = Math.max(ans, i - last);
            last = i;
        }
    }
    return ans;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$, which is $O(32)$ in the worst case (essentially constant time).
    *   **Độ phức tạp thời gian:** $O(\log N)$, tức là $O(32)$ trong trường hợp xấu nhất (về cơ bản là thời gian không đổi).*
*   **Space Complexity:** $O(1)$, only a few variables are used.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple bitwise shifts and identity comparisons are the best way to process binary data.
*Các thao tác dịch chuyển bit và so sánh đơn giản là cách tốt nhất để xử lý dữ liệu nhị phân.*
