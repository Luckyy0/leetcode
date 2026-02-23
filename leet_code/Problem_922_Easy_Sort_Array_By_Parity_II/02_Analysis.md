# Analysis for Sort Array By Parity II
# *Phân tích cho bài toán Sắp xếp Mảng theo Tính chẵn lẻ II*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Rearrange array elements such that even indices have even numbers and odd indices have odd numbers. In-place preferred.
*Sắp xếp lại các phần tử mảng sao cho chỉ số chẵn chứa số chẵn và chỉ số lẻ chứa số lẻ. Ưu tiên tại chỗ.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- We have exactly `N/2` evens and `N/2` odds.
- We can use two pointers:
  - `i` tracks even indices (0, 2, 4...).
  - `j` tracks odd indices (1, 3, 5...).
- Iterate `i` through even positions.
- If `nums[i]` is odd, it is misplaced. We need to find an even number at an odd position to swap with.
- Move `j` through odd positions until we find `nums[j]` which is even (also misplaced).
- Swap `nums[i]` and `nums[j]`.
- Continue until `i` reaches end.
*Chúng ta có đúng `N/2` số chẵn và `N/2` số lẻ. Dùng hai con trỏ `i` (chẵn) và `j` (lẻ). Duyệt `i` qua các vị trí chẵn. Nếu `nums[i]` lẻ (sai chỗ), ta tìm một số chẵn ở vị trí lẻ `j` (cũng sai chỗ) để hoán đổi. Tiếp tục đến khi xong.*

---

## 2. Strategy: In-Place Swap
## *2. Chiến lược: Hoán đổi Tại chỗ*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `i = 0`, `j = 1`, `n = nums.length`.
    *   **Khởi tạo:** `i = 0`, `j = 1`, `n = độ dài mảng`.*

2.  **Loop:** While `i < n`:
    - If `nums[i]` is even: `i += 2`. Continue.
    - If `nums[i]` is odd (misplaced):
        - While `nums[j]` is odd: `j += 2`. (Find the first misplaced even number at odd index).
        - Swap `nums[i]` and `nums[j]`.
        - `i += 2`. (Problem at `i` fixed).
    *   **Vòng lặp:** Nếu `nums[i]` chẵn, OK. Nếu lẻ, tìm số chẵn ở vị trí lẻ `j` để đổi.*

3.  **Return:** `nums`.
    *   **Trả về:** `nums`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int[] sortArrayByParityII(int[] nums) {
    int i = 0; // Even index pointer
    int j = 1; // Odd index pointer
    int n = nums.length;
    
    while (i < n && j < n) {
        // Find misplaced odd number at even index i
        while (i < n && nums[i] % 2 == 0) {
            i += 2;
        }
        
        // Find misplaced even number at odd index j
        while (j < n && nums[j] % 2 == 1) {
            j += 2;
        }
        
        // Swap if both found
        if (i < n && j < n) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    
    return nums;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Each element is visited at most constant times.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$. In-place.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Two pointers moving independently (one on even indices, one on odd) efficiently solve this in one pass.
*Hai con trỏ di chuyển độc lập (một trên chỉ số chẵn, một trên chỉ số lẻ) giải quyết vấn đề hiệu quả trong một lần duyệt.*
