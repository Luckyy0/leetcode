# Analysis for Partition Array into Disjoint Intervals
# *Phân tích cho bài toán Phân chia Mảng thành các Khoảng Rời rạc*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the smallest index `i` such that `max(nums[0...i]) <= min(nums[i+1...n-1])`.
*Tìm chỉ số `i` nhỏ nhất sao cho giá trị lớn nhất của phần bên trái nhỏ hơn hoặc bằng giá trị nhỏ nhất của phần bên phải.*

### KEY INSIGHT
### *Nhận xét quan trọng*
- We need to find a split point such that all elements to the left are smaller or equal to all elements to the right.
- This means `partition_idx` is correct if `max(left_part) <= min(right_part)`.
- We can iterate through the array maintaining the `current_max` of the left part.
- However, knowing the max of the left part isn't enough; we need to know if everything to the right is larger.
- A brute force: For each `i`, check `max(0..i) <= min(i+1..n)`. $O(N^2)$.
- Better 1: Precompute `min_right` array where `min_right[i]` is $\min(A[i \dots n-1])$. Then iterate `i` and check `max_left[i] <= min_right[i+1]`. $O(N)$ time, $O(N)$ space.
- Better 2: One pass $O(N)$ time, $O(1)$ space logic.
  - Maintain `max_left` (max of the current valid left partition).
  - Iterate `i`. If `nums[i] < max_left`, then `nums[i]` CANNOT be in the right partition (because it's smaller than something in the left). It must belong to the left partition.
  - So we must extend the left partition to include `i`. Update the partition split index.
  - Update `max_left` to be the max of `nums[0...new_split]`.
  - Also track `global_max` seen so far to update `max_left` when the partition extends.

*Cần tìm điểm chia sao cho `max(trái) <= min(phải)`. Cách tốt nhất $O(N)$ thời gian, $O(1)$ không gian: Duyệt qua mảng. Nếu gặp phần tử nhỏ hơn `max` hiện tại của phần bên trái, nghĩa là phần tử này buộc phải thuộc về phần bên trái. Ta mở rộng phần bên trái đến vị trí hiện tại và cập nhật `max` của phần bên trái mới.*

---

## 2. Strategy: One Pass Optimal
## *2. Chiến lược: Một vòng lặp tối ưu*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize:** 
    - `partitionIdx = 0` (End index of left partition).
    - `maxLeft = nums[0]` (Max value in current left partition).
    - `currentMax = nums[0]` (Max value seen so far).
    *   **Khởi tạo:** `partitionIdx`, `maxLeft`, `currentMax`.*

2.  **Iterate:** `i` from 1 to `n-1`.
    - `currentMax = max(currentMax, nums[i])`.
    - If `nums[i] < maxLeft`:
        - `partitionIdx = i`. (Extend partition)
        - `maxLeft = currentMax`. (Update max of the now extended partition)
    *   **Duyệt:** Nếu `nums[i] < maxLeft`, mở rộng phân vùng và cập nhật `maxLeft`.*

3.  **Return:** `partitionIdx + 1` (Length is index + 1).
    *   **Trả về:** Độ dài.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int partitionDisjoint(int[] nums) {
    int partitionIdx = 0;
    int maxLeft = nums[0];
    int currentMax = nums[0];
    
    for (int i = 1; i < nums.length; i++) {
        currentMax = Math.max(currentMax, nums[i]);
        
        if (nums[i] < maxLeft) {
            partitionIdx = i;
            maxLeft = currentMax;
        }
    }
    
    return partitionIdx + 1;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Single pass.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$. Only a few variables used.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

The one-pass logic works by lazily extending the partition only when a violation of the "left <= right" condition is found (i.e., encountering a small number).
*Logic một vòng lặp hoạt động bằng cách mở rộng phân vùng một cách lười biếng chỉ khi phát hiện vi phạm điều kiện "trái <= phải" (tức là gặp một số nhỏ).*
