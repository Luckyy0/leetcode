# Analysis for Maximize Distance to Closest Person
# *Phân tích cho bài toán Tối đa hóa Khoảng cách đến Người gần nhất*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Alex wants to find an empty seat where the distance to the nearest occupied seat is maximized. We need to consider gaps between people, as well as the gaps at the very beginning and end of the row.
*Alex muốn tìm một ghế trống nơi khoảng cách đến ghế có người gần nhất là lớn nhất. Chúng ta cần xem xét khoảng trống giữa hai người, cũng như khoảng trống ở đầu và cuối hàng.*

---

## 2. Strategy: Linear Scan for Gaps
## *2. Chiến lược: Quét tuyến tính tìm khoảng trống*

### Key Scenarios
### *Các tình huống chính*
1.  **Left Edge:** Gap between index 0 and the first occupied seat at index `i`. Distance = `i`.
2.  **Right Edge:** Gap between the last occupied seat at index `j` and the end of the row. Distance = `(n - 1) - j`.
3.  **Middle:** Gap between two occupied seats at indices `left` and `right`. Distance = `(right - left) / 2`.
*1. Cạnh trái: Khoảng cách từ đầu hàng đến người đầu tiên. 2. Cạnh phải: Khoảng cách từ người cuối cùng đến cuối hàng. 3. Ở giữa: Khoảng cách giữa hai người liên tiếp (chia đôi).*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Track last occupied seat:** Use a pointer `prev` to store the index of the previous occupied seat.
    *   **Theo dõi ghế có người cuối cùng:** Sử dụng con trỏ `prev`.*

2.  **Handle Left Edge:** Initialize `maxDist` with the index of the first `1` found.
    *   **Xử lý cạnh trái:** Khởi tạo `maxDist` bằng chỉ số của số `1` đầu tiên.*

3.  **Iterate and calculate middle gaps:** For every subsequent `1` at index `i`:
    - `maxDist = max(maxDist, (i - prev) / 2)`.
    - `prev = i`.
    *   **Duyệt và tính khoảng trống ở giữa:** Với mỗi số `1` tiếp theo, tính khoảng cách chia đôi và cập nhật `maxDist`.*

4.  **Handle Right Edge:** After the loop, check the gap from the final `prev` to the end: `maxDist = max(maxDist, (n - 1) - prev)`.
    *   **Xử lý cạnh phải:** Sau vòng lặp, kiểm tra khoảng cách từ người cuối cùng đến cuối hàng.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int maxDistToClosest(int[] seats) {
    int n = seats.length;
    int prev = -1, maxDist = 0;
    
    for (int i = 0; i < n; i++) {
        if (seats[i] == 1) {
            if (prev == -1) maxDist = i; // Left edge
            else maxDist = Math.max(maxDist, (i - prev) / 2); // Middle
            prev = i;
        }
    }
    // Right edge
    maxDist = Math.max(maxDist, n - 1 - prev);
    return maxDist;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of seats. We perform a single pass.
    *   **Độ phức tạp thời gian:** $O(N)$, vì chúng ta duyệt qua một lần.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Always pay attention to boundary conditions (start and end of the array) as they often follow different mathematical rules than the interior elements.
*Luôn chú ý đến các điều kiện biên (đầu và cuối mảng) vì chúng thường tuân theo các quy tắc toán học khác với các phần tử bên trong.*
