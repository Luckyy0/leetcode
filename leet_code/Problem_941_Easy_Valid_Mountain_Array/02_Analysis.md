# Analysis for Valid Mountain Array
# *Phân tích cho bài toán Mảng Núi Hợp lệ*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Verify if an array increases strictly then decreases strictly, with `length >= 3`.
*Xác minh xem một mảng có tăng nghiêm ngặt rồi giảm nghiêm ngặt không, với độ dài >= 3.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Walk up from the start as long as it's strictly increasing (`arr[i] < arr[i+1]`).
- Walk down from the end as long as it's strictly decreasing (`arr[i] < arr[i+1]` when viewed from right, or `arr[i] > arr[i+1]` from left).
- Or better:
  - Walk up: `i` starts at 0. Increment `i` while `arr[i] < arr[i+1]`.
  - Check peak conditions:
    - `i` cannot be 0 (must increase at least once).
    - `i` cannot be `n-1` (must decrease at least once).
  - Walk down from `i`. Increment `i` while `arr[i] > arr[i+1]`.
  - Finally, check if `i == n-1`.
*Đi lên từ đầu cho đến khi đỉnh, sau đó đi xuống. Kiểm tra điều kiện đỉnh: không phải đầu hoặc cuối. Cuối cùng kiểm tra xem đã đi hết mảng chưa.*

---

## 2. Strategy: Linear Scan
## *2. Chiến lược: Quét Tuyến tính*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Check Length:** If `n < 3`, return `false`.
    *   **Kiểm tra độ dài:** Nếu `n < 3`, trả về `false`.*

2.  **Climb Up:** Find `i` such that `arr` is increasing until `i`.
    - `while (i+1 < n && arr[i] < arr[i+1]) i++;`
    *   **Leo lên:** Tăng `i` khi mảng tăng.*

3.  **Check Peak:** If `i == 0` or `i == n-1`, return `false`.
    *   **Kiểm tra Đỉnh:** Nếu `i` ở đầu hoặc cuối, sai (không có sườn lên hoặc sườn xuống).*

4.  **Climb Down:** Continue incrementing `i` while `arr` is decreasing.
    - `while (i+1 < n && arr[i] > arr[i+1]) i++;`
    *   **Leo xuống:** Tăng `i` khi mảng giảm.*

5.  **Result:** Return `i == n-1`.
    *   **Kết quả:** Trả về `i == n-1`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;
        
        int i = 0;
        
        // Walk up
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        
        // Check if peak is at start or end (invalid)
        if (i == 0 || i == n - 1) return false;
        
        // Walk down
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }
        
        // If we reached the end, it's a valid mountain
        return i == n - 1;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Single pass.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Simple two-phase scan mimics the mountain shape perfectly.
*Quét hai giai đoạn đơn giản mô phỏng hoàn hảo hình dạng ngọn núi.*
