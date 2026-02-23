# Analysis for Longest Mountain in Array
# *Phân tích cho bài toán Ngọn núi Dài nhất trong Mảng*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Identify the longest subarray that monotonically increases and then monotonically decreases. A mountain must have both a rising slope and a falling slope.
*Xác định mảng con dài nhất mà ban đầu tăng đơn điệu và sau đó giảm đơn điệu. Một ngọn núi phải có cả sườn dốc lên và sườn dốc xuống.*

---

## 2. Strategy: Peak Identification & Expansion
## *2. Chiến lược: Xác định Đỉnh & Mở rộng*

### Key Logic
### *Logic chính*
An element `arr[i]` can be a peak only if it's strictly greater than its neighbors: `arr[i-1] < arr[i] > arr[i+1]`. Once a peak is found, we expand left and right to find the full base of that mountain.
*Một phần tử `arr[i]` chỉ có thể là đỉnh nếu nó lớn hơn hẳn hai phần tử lân cận: `arr[i-1] < arr[i] > arr[i+1]`. Một khi tìm thấy đỉnh, ta mở rộng sang trái và phải để tìm toàn bộ chân núi.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Iterate through internal elements:** Loop from `i = 1` to `n - 2`.
    *   **Duyệt qua các phần tử bên trong:** Chạy từ `i = 1` đến `n - 2`.*

2.  **Check for Peak:**
    - If `arr[i] > arr[i-1]` and `arr[i] > arr[i+1]`:
        - Expand left: While `l > 0` and `arr[l] > arr[l-1]`, decrement `l`.
        - Expand right: While `r < n - 1` and `arr[r] > arr[r+1]`, increment `r`.
        - `CurrentLength = r - l + 1`.
        - Update `maxLength`.
    *   **Kiểm tra đỉnh:** Nếu `arr[i]` là đỉnh, mở rộng sang trái cho đến khi không còn tăng, mở rộng sang phải cho đến khi không còn giảm. Tính độ dài và cập nhật `maxLength`.*

3.  **Optimization:** After finding a mountain, we can skip `i` to `r` to avoid redundant checks.
    *   **Tối ưu hóa:** Sau khi tìm thấy một ngọn núi, chúng ta có thể nhảy `i` đến vị trí `r` để tránh kiểm tra trùng lặp.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int longestMountain(int[] arr) {
    int n = arr.length;
    int maxLen = 0;
    int i = 1;
    while (i < n - 1) {
        // Is it a peak?
        if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
            int left = i - 1;
            while (left > 0 && arr[left] > arr[left - 1]) left--;
            int right = i + 1;
            while (right < n - 1 && arr[right] > arr[right + 1]) right++;
            
            maxLen = Math.max(maxLen, right - left + 1);
            i = right; // Skip to the end of the current mountain
        } else {
            i++;
        }
    }
    return maxLen;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of elements. Although there are nested while loops, the outer index `i` is moved to `right` each time a mountain is found, ensuring each element is visited a constant number of times.
    *   **Độ phức tạp thời gian:** $O(N)$, vì mặc dù có vòng lặp lồng nhau, chỉ số `i` nhảy vọt sau mỗi lần tìm thấy núi, đảm bảo mỗi phần tử chỉ được xem xét một số lần cố định.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Identifying the specific structural property (the peak) and expanding from it is often more intuitive than tracking complex state transitions (increasing phase vs decreasing phase).
*Xác định thuộc tính cấu trúc cụ thể (đỉnh núi) và mở rộng từ đó thường trực quan hơn so với việc theo dõi các chuyển đổi trạng thái phức tạp (pha tăng so với pha giảm).*
