# Analysis for Shifting Letters
# *Phân tích cho bài toán Dịch chuyển Chữ cái*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We apply cumulative shifts to prefixes of a string. Each element `shifts[i]` indicates how much all characters from index 0 to `i` should be shifted.
*Chúng ta áp dụng dịch chuyển tích lũy cho các tiền tố của một chuỗi. Mỗi phần tử `shifts[i]` cho biết tất cả các ký tự từ chỉ số 0 đến `i` nên được dịch chuyển bao nhiêu.*

### KEY OBSERVATION
### *Quan sát quan trọng*
The character at index `i` is affected by `shifts[i]`, and all subsequent shifts `shifts[j]` where `j > i`.
Specifically, the total shift for character `s[i]` is:
$TotalShift(i) = \sum_{j=i}^{n-1} shifts[j]$
*Ký tự tại chỉ số `i` bị ảnh hưởng bởi `shifts[i]` và tất cả các lần dịch chuyển sau đó `shifts[j]` với `j > i`. Tổng dịch chuyển cho `s[i]` là tổng của tất cả các `shifts` từ `i` đến cuối mảng.*

---

## 2. Strategy: Suffix Sum
## *2. Chiến lược: Tổng hậu tố (Suffix Sum)*

### Why Suffix Sum?
### *Tại sao dùng Tổng hậu tố?*
Calculating the total shift for each character $O(N^2)$ would be too slow. By iterating from the end of the array, we can maintain a running total of the shifts in $O(N)$.
*Việc tính tổng dịch chuyển cho từng ký tự theo cách thông thường tốn $O(N^2)$ sẽ rất chậm. Bằng cách lặp ngược từ cuối mảng, ta có thể duy trì một tổng lũy kế trong $O(N)$.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize running total:** `long totalShift = 0`.
    *   **Khởi tạo tổng lũy kế:** `long totalShift = 0`.*

2.  **Iterate backwards:** Loop from `i = n - 1` down to 0:
    - `totalShift = (totalShift + shifts[i]) % 26`.
    - Apply `totalShift` to character `s[i]`.
    - Update `s[i]` in the result array/StringBuilder.
    *   **Duyệt ngược:** Chạy từ `i = n - 1` về 0. Cập nhật `totalShift` bằng cách cộng thêm `shifts[i]` và lấy dư cho 26. Áp dụng `totalShift` cho ký tự `s[i]` và lưu vào kết quả.*

3.  **Char Transformation:** `(current_char - 'a' + totalShift) % 26 + 'a'`.
    *   **Biến đổi ký tự:** Công thức trên đảm bảo kết quả luôn là một chữ cái tiếng Anh viết thường.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public String shiftingLetters(String s, int[] shifts) {
    char[] chars = s.toCharArray();
    long currentShift = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
        currentShift = (currentShift + shifts[i]) % 26;
        int newChar = (chars[i] - 'a' + (int) currentShift) % 26;
        chars[i] = (char) ('a' + newChar);
    }
    return new String(chars);
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the length of the string. We perform exactly one pass from end to start.
    *   **Độ phức tạp thời gian:** $O(N)$, duyệt qua chuỗi đúng một lần từ cuối về đầu.*
*   **Space Complexity:** $O(N)$ to store the character array/result string.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

When multiple operations overlap, checking for the cumulative effect on each element (often using prefix or suffix sums) is usually the key to an optimal solution.
*Khi có nhiều thao tác chồng lấn, hãy kiểm tra hiệu ứng tích lũy lên từng phần tử (thường dùng tổng tiền tố hoặc hậu tố). Đây chính là chìa khóa cho giải pháp tối ưu.*
