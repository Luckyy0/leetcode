# Analysis for Sort Array By Parity
# *Phân tích cho bài toán Sắp xếp Mảng Theo Tính Chẵn Lẻ*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Move all even numbers to the front, and all odd numbers to the back. Order within the parities does not matter.
*Di chuyển tất cả các số chẵn lên phía trước và tất cả các số lẻ về phía sau. Thứ tự trong các nhóm chẵn/lẻ không quan trọng.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- This is a partitioning problem, similar to the partitioning step in QuickSort.
- We can use two pointers: `left` pointing to the start, `right` pointing to the end.
- `left` searches for an ODD number (misplaced).
- `right` searches for an EVEN number (misplaced).
- When both find their targets, swap them.
*Đây là một bài toán phân vùng, tương tự như bước phân vùng trong QuickSort. Sử dụng hai con trỏ `left` và `right`. `left` tìm số lẻ (sai chỗ). `right` tìm số chẵn (sai chỗ). Khi cả hai tìm thấy, hoán đổi chúng.*

---

## 2. Strategy: Two Pointers (Partition)
## *2. Chiến lược: Hai Con trỏ (Phân vùng)*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** `l = 0`, `r = n - 1`.
    *   **Khởi tạo:** `l = 0`, `r = n - 1`.*

2.  **Loop:** While `l < r`:
    - While `l < r` and `nums[l]` is even: `l++`. (Correctly placed evens)
    - While `l < r` and `nums[r]` is odd: `r--`. (Correctly placed odds)
    - If `l < r`: Swap `nums[l]` and `nums[r]`.
    *   **Lặp:** Trong khi `l < r`: Bỏ qua các số chẵn ở đầu. Bỏ qua các số lẻ ở cuối. Nếu còn sai chỗ, hoán đổi.*

3.  **Return:** `nums`.
    *   **Trả về:** `nums`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int[] sortArrayByParity(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    
    while (left < right) {
        // Increment left until an odd number is found
        while (left < right && nums[left] % 2 == 0) {
            left++;
        }
        
        // Decrement right until an even number is found
        while (left < right && nums[right] % 2 != 0) {
            right--;
        }
        
        // Swap if pointers haven't crossed
        if (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
    
    return nums;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$ because each element is visited at most once by either `left` or `right`.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$ in-place.
    *   **Độ phức tạp không gian:** $O(1)$ tại chỗ.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

In-place two-pointer approach is the most efficient. Alternatively, creating a new array and filling it from both ends is also $O(N)$ but requires $O(N)$ space.
*Phương pháp hai con trỏ tại chỗ là hiệu quả nhất. Ngoài ra, tạo mảng mới và điền từ hai đầu cũng là $O(N)$ nhưng tốn $O(N)$ không gian.*
