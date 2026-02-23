# Analysis for Peak Index in a Mountain Array
# *Phân tích cho bài toán Chỉ số Đỉnh trong Mảng Ngọn núi*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We are given a mountain array and need to find the index of its highest element (the peak). The array is guaranteed to have exactly one peak. The strict requirement is to find this index in $O(\log N)$ time.
*Chúng ta được cung cấp một mảng ngọn núi và cần tìm chỉ số của phần tử cao nhất (đỉnh). Mảng được đảm bảo có đúng một đỉnh. Yêu cầu khắt khe là tìm chỉ số này trong thời gian $O(\log N)$.*

---

## 2. Strategy: Binary Search
## *2. Chiến lược: Tìm kiếm nhị phân*

### Why Binary Search?
### *Tại sao dùng Tìm kiếm nhị phân?*
A mountain array has a specific property: items to the left of the peak are in increasing order, and items to the right are in decreasing order. This binary nature allows us to apply binary search.
*Một mảng ngọn núi có một đặc tính cụ thể: các mục bên trái của đỉnh theo thứ tự tăng dần và các mục bên phải theo thứ tự giảm dần. Bản chất nhị phân này cho phép chúng ta áp dụng tìm kiếm nhị phân.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Pointers:** Set `low = 0` and `high = arr.length - 1`.
    *   **Khởi tạo con trỏ:** Đặt `low = 0` và `high = mảng.length - 1`.*

2.  **Binary Search Loop:**
    - Calculate `mid = low + (high - low) / 2`.
    - If `arr[mid] < arr[mid + 1]`: This means we are on the ascending slope, so the peak must be to the right of `mid`. Update `low = mid + 1`.
    - Else if `arr[mid] > arr[mid + 1]`: This means we are on the descending slope or at the peak itself. Update `high = mid`.
    *   **Vòng lặp tìm kiếm nhị phân:** Tính `mid = low + (high - low) / 2`. Nếu `arr[mid] < arr[mid + 1]`: Điều này có nghĩa là chúng ta đang ở dốc đi lên, vì vậy đỉnh phải nằm bên phải `mid`. Cập nhật `low = mid + 1`. Ngược lại nếu `arr[mid] > arr[mid + 1]`: Điều này có nghĩa là chúng ta đang ở dốc đi xuống hoặc chính tại đỉnh. Cập nhật `high = mid`.*

3.  **Result:** The loop ends when `low == high`, which points to the peak index.
    *   **Kết quả:** Vòng lặp kết thúc khi `low == high`, trỏ đến chỉ số đỉnh.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int peakIndexInMountainArray(int[] arr) {
    int low = 0, high = arr.length - 1;
    while (low < high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] < arr[mid + 1]) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }
    return low;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\log N)$, as we divide the search space by half in each step.
    *   **Độ phức tạp thời gian:** $O(\log N)$, vì chúng ta chia đôi không gian tìm kiếm sau mỗi bước.*
*   **Space Complexity:** $O(1)$, as we only use a few variables for pointers.
    *   **Độ phức tạp không gian:** $O(1)$, vì chúng ta chỉ sử dụng một vài biến cho các con trỏ.*

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Binary search is the optimal way to find an extreme point in a unimodal sequence.
*Tìm kiếm nhị phân là cách tối ưu để tìm một điểm cực trị trong một dãy đơn mốt.*
