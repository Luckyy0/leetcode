# Analysis for Find Peak Element
# *Phân tích cho bài toán Tìm phần tử cực đại*

## 1. Problem Essence & Intrinsic Truths
## *1. Bản chất vấn đề & Sự thật hiển nhiên*

### The Boundless Peak
### *Cực đại không giới hạn*
The problem states that `nums[-1] = nums[n] = -∞`. This is a crucial observation. It guarantees that a peak **must** exist. If the array is strictly increasing, the last element is the peak. If it's strictly decreasing, the first element is the peak. If it's mixed, there must be at least one "summit" somewhere.
*Đề bài nêu rằng `nums[-1] = nums[n] = -∞`. Đây là một quan sát quan trọng. Nó đảm bảo rằng một cực đại **phải** tồn tại. Nếu mảng tăng nghiêm ngặt, phần tử cuối cùng là cực đại. Nếu giảm nghiêm ngặt, phần tử đầu tiên là cực đại. Nếu hỗn hợp, chắc chắn sẽ có ít nhất một "đỉnh" ở đâu đó.*

### The O(log N) Constraint
### *Ràng buộc O(log N)*
An $O(log N)$ requirement in an array context almost always implies **Binary Search**. But how do we apply binary search to an unsorted array? The key is that we don't need the array to be sorted; we only need a **directional property**.
*Yêu cầu $O(log N)$ trong ngữ cảnh mảng hầu như luôn ám chỉ **Tìm kiếm nhị phân**. Nhưng làm thế nào để áp dụng tìm kiếm nhị phân cho một mảng chưa sắp xếp? Chìa khóa là chúng ta không cần mảng phải được sắp xếp; chúng ta chỉ cần một **thuộc tính định hướng**.*

---

## 2. Approach: Binary Search for a Local Slope
## *2. Hướng tiếp cận: Tìm kiếm nhị phân cho một độ dốc cục bộ*

### The Strategy
### *Chiến lược*
At any position `mid`, we look at its neighbor `mid + 1`. This tells us the **slope** of the function at that point.
1.  **`nums[mid] < nums[mid + 1]`**: We are on an upward slope. Since we know the array eventually ends at $-\infty$, there **must** be a peak somewhere to the right. 
    *Action:* `left = mid + 1`.
2.  **`nums[mid] > nums[mid + 1]`**: We are on a downward slope. There could be a peak to the left, or `mid` itself could be a peak (relative to its neighbors). 
    *Action:* `right = mid`.

By following the "ascents", we are guaranteed to find a peak. This is similar to a "greedy" version of binary search where we always move towards a higher value.
*Bằng cách đi theo "hướng đi lên", chúng ta được đảm bảo sẽ tìm thấy một cực đại. Điều này tương tự như một phiên bản "tham lam" của tìm kiếm nhị phân, nơi chúng ta luôn di chuyển về phía giá trị cao hơn.*

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Information Discard:** Even though there might be multiple peaks, we only need one. This allows us to discard an entire half of the array even if it also contains a peak, as long as we are sure the current half contains at least one.
    *Loại bỏ thông tin: Ngay cả khi có nhiều cực đại, chúng ta chỉ cần một cái. Điều này cho phép chúng ta loại bỏ một nửa mảng ngay cả khi nó cũng chứa cực đại, miễn là chúng ta chắc chắn nửa hiện tại chứa ít nhất một cái.*
*   **Edge Case Handling:** The condition `nums[mid] < nums[mid+1]` naturally handles cases where the array has only two elements or where the peak is at the boundaries.
    *Xử lý trường hợp biên: Điều kiện `nums[mid] < nums[mid+1]` tự nhiên xử lý các trường hợp mảng chỉ có hai phần tử hoặc cực đại nằm ở ranh giới.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(log N)$. Each step reduces the search space by half.
    *Độ phức tạp thời gian: $O(log N)$. Mỗi bước giảm một nửa không gian tìm kiếm.*
*   **Space Complexity:** $O(1)$. Only constant extra space for pointers.
    *Độ phức tạp không gian: $O(1)$. Chỉ tốn không gian hằng số cho các con trỏ.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** `[1, 2, 1, 3, 5, 6, 4]`

1. `left=0, right=6, mid=3`. `nums[3]=3, nums[4]=5`.
2. `3 < 5` (Slope is up). `left = mid + 1 = 4`.
3. `left=4, right=6, mid=5`. `nums[5]=6, nums[6]=4`.
4. `6 > 4` (Slope is down). `right = mid = 5`.
5. `left=4, right=5, mid=4`. `nums[4]=5, nums[5]=6`.
6. `5 < 6` (Slope is up). `left = mid + 1 = 5`.
7. `left == right == 5`. Stop.

**Result:** Index 5 (Value 6).

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Finding a peak element is a classic interview question that tests if you understand when Binary Search is applicable. The most common mistake is thinking Binary Search only works on sorted data. Remember: if you can define a rule to discard one half of the space while guaranteeing the answer exists in the other, Binary Search is the tool for the job.
*Tìm phần tử cực đại là một câu hỏi phỏng vấn kinh điển nhằm kiểm tra xem bạn có hiểu khi nào Tìm kiếm nhị phân có thể áp dụng được hay không. Sai lầm phổ biến nhất là nghĩ rằng Tìm kiếm nhị phân chỉ hoạt động trên dữ liệu đã sắp xếp. Hãy nhớ: nếu bạn có thể xác định một quy tắc để loại bỏ một nửa không gian trong khi đảm bảo câu trả lời tồn tại ở nửa còn lại, Tìm kiếm nhị phân là công cụ cho việc đó.*
---
*Đôi khi để tìm thấy đỉnh cao, chúng ta chỉ cần luôn bước về phía có triền dốc đi lên.*
Sometimes to find the peak, we just need to always walk towards the upward slope.
