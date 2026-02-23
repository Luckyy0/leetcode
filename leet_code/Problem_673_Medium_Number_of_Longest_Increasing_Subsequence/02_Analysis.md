# Analysis for Number of Longest Increasing Subsequence
# *Phân tích cho bài toán Số lượng Dãy con Tăng dài nhất*

## 1. Problem Essence & Dynamic Programming Expansion
## *1. Bản chất vấn đề & Mở rộng Quy hoạch động*

### The Challenge
### *Thách thức*
This problem is an extension of the classic Longest Increasing Subsequence (LIS). Beyond finding the length, we must track how many distinct subsequences achieve that length.
*Bài toán này là sự mở rộng của bài toán Dãy con tăng dài nhất (LIS) kinh điển. Ngoài việc tìm độ dài, chúng ta phải theo dõi có bao nhiêu dãy con khác nhau đạt được độ dài đó.*

---

## 2. Strategy: Dual DP Arrays
## *2. Chiến lược: Mảng DP Kép*

We use two arrays to track the state at each index `i`:
*Chúng ta sử dụng hai mảng để theo dõi trạng thái tại mỗi chỉ số `i`:*

- `lengths[i]`: The length of the longest increasing subsequence ending at `nums[i]`.
    - *`lengths[i]`: Độ dài của dãy con tăng dài nhất kết thúc tại `nums[i]`.*
- `counts[i]`: The number of such longest increasing subsequences ending at `nums[i]`.
    - *`counts[i]`: Số lượng các dãy con tăng dài nhất như vậy kết thúc tại `nums[i]`.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Initialize:** All `lengths[i] = 1`, all `counts[i] = 1`.
    * **Khởi tạo:** Tất cả các độ dài và số lượng ban đầu bằng 1.*

2.  **Iterate and Update:** For each `i` from 0 to $n-1$:
    * **Duyệt và Cập nhật:** *
    - For each `j < i`:
        - If `nums[j] < nums[i]` (strictly increasing):
            - Case A: `lengths[j] + 1 > lengths[i]`.
                - We found a new maximum length at `i`.
                - `lengths[i] = lengths[j] + 1`.
                - `counts[i] = counts[j]` (inherit the number of ways to reach length `lengths[j]`).
            - Case B: `lengths[j] + 1 == lengths[i]`.
                - We found another path to reach the *same* maximum length at `i`.
                - `counts[i] += counts[j]`.

3.  **Result Aggregation:** 
    - Find the global maximum length `maxLen` across all `lengths`.
    - Sum up `counts[i]` for all `i` where `lengths[i] == maxLen`.

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Inheritance vs. Addition:** The key is distinguishing between finding a *better* path (reset count) and finding an *alternative* path (add to count).
    * **Kế thừa và Cộng dồn:** Chìa khóa là phân biệt giữa việc tìm thấy một con đường *tốt hơn* (đặt lại số đếm) và một con đường *thay thế* (cộng thêm vào số đếm).*
*   **Quadratic Complexity:** $O(N^2)$ is efficient enough for $N \le 2000$. While LIS length can be found in $O(N \log N)$, counting them usually requires $O(N^2)$ with DP or segment trees.
    * **Độ phức tạp bậc hai:** $O(N^2)$ là đủ hiệu quả cho $N \le 2000$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N^2)$, where $N$ is the number of elements.
    * **Độ phức tạp thời gian:** $O(N^2)$.*
*   **Space Complexity:** $O(N)$ for the two DP arrays.
    * **Độ phức tạp không gian:** $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [1, 3, 5, 4, 7]
1. `lengths`: [1, 2, 3, 3, 4]
2. `counts`:  [1, 1, 1, 1, 2]
   - For `7` (index 4):
     - It can extend `5` (len 3, count 1) -> len 4, count 1.
     - It can extend `4` (len 3, count 1) -> len 4, count 1.
     - Total `counts[4] = 1 + 1 = 2`.
**Result:** 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

When a problem asks for "the number of ways" to reach an "optimal" value, DP is the most robust approach. Always maintain two states: one for the value being optimized (max/min) and one for the count of paths achieving that value.
*Khi một bài toán hỏi "số cách" để đạt được một giá trị "tối ưu", DP là cách tiếp cận mạnh mẽ nhất. Luôn duy trì hai trạng thái: một cho giá trị tối ưu và một cho số lượng con đường.*
---
*Số lượng (Quantity) là minh chứng cho sự đa dạng của con đường dẫn đến đỉnh cao (Maximum length). Trong dòng chảy của các con số (Subsequence), mỗi khi ta tìm thấy một nấc thang cao hơn (New max), ta kế thừa lịch sử cũ; mỗi khi ta tìm thấy một lối đi song song (Alternative path), ta cộng dồn sức mạnh. Dữ liệu dạy ta rằng chiều sâu của một vấn đề không chỉ nằm ở kết quả cuối cùng, mà ở vô vàn cách thức để chạm tới nó.*
Quantity (Quantity) is a testament to the diversity of paths leading to the summit (Maximum length). In the flow of numbers (Subsequence), every time we find a higher ladder (New max), we inherit the old history; every time we find a parallel path (Alternative path), we accumulate strength. Data teaches us that the depth of a problem lies not only in the final result, but in the myriad ways to reach it.
