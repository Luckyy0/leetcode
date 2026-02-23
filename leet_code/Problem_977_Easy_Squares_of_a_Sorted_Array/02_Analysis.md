# Analysis for Squares of a Sorted Array
# *Phân tích cho bài toán Bình phương của Mảng đã Sắp xếp*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Convert sorted array $A$ to sorted array of $A^2$.
*Chuyển mảng đã sắp xếp A thành mảng bình phương A^2 đã sắp xếp.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- Input array may contain negative numbers.
- Squaring makes large negatives become large positives.
- The largest squares will be at the ends of the array (most negative or most positive).
- Use two pointers: `left=0`, `right=N-1`.
- Compare `abs(nums[left])` and `abs(nums[right])`.
- Place the larger square at the end of the `result` array.
- Move pointers inward.
*Sử dụng hai con trỏ so sánh giá trị tuyệt đối hai đầu và điền kết quả từ cuối về đầu.*

---

## 2. Strategy: Two Pointers
## *2. Chiến lược: Hai Con trỏ*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Init:** `left = 0`, `right = N-1`, `idx = N-1`.
    *   **Khởi tạo:** Con trỏ trái, phải, và chỉ số điền kết quả.*

2.  **Loop:** While `left <= right`.
    - If `abs(nums[left]) > abs(nums[right])`:
      - `res[idx--] = nums[left] * nums[left]`. `left++`.
    - Else:
      - `res[idx--] = nums[right] * nums[right]`. `right--`.
    *   **Vòng lặp:** So sánh và điền.*

3.  **Return:** `res`.
    *   **Trả về:** `res`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;
        
        while (left <= right) {
            int leftVal = Math.abs(nums[left]);
            int rightVal = Math.abs(nums[right]);
            
            if (leftVal > rightVal) {
                result[index] = leftVal * leftVal;
                left++;
            } else {
                result[index] = rightVal * rightVal;
                right--;
            }
            index--;
        }
        
        return result;
    }
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Single pass.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(N)$ for result array.
    *   **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Two pointers is optimal $O(N)$ compared to blunt sorting $O(N \log N)$.
*Hai con trỏ là tối ưu O(N) so với sắp xếp O(N log N).*
