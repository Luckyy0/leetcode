# Analysis for Partition to K Equal Sum Subsets
# *Phân tích cho bài toán Chia mảng thành K tập con có Tổng bằng nhau*

## 1. Problem Essence & Combinatorial Complexity
## *1. Bản chất vấn đề & Độ phức tạp Tổ hợp*

### The Challenge
### *Thách thức*
We need to group every number in an array into $K$ buckets such that each bucket has the same sum. This is an NP-hard problem (a variation of the Bin Packing problem or the Partition problem). With $N \le 16$, we can use bitmask-based dynamic programming or memoized backtracking.
*Chúng ta cần nhóm mọi số trong mảng vào $K$ nhóm sao cho mỗi nhóm có cùng tổng. Đây là một bài toán NP-hard. Với $N \le 16$, chúng ta có thể sử dụng quy hoạch động dựa trên bitmask.*

---

## 2. Strategy: Backtracking with Bitmask Memoization
## *2. Chiến lược: Đệ quy có nhớ với Bitmask*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Initial Checks:** 
    - Calculate total sum. If `sum % k != 0`, return `false`.
    - If any element `nums[i] > sum / k`, return `false`.
    * **Kiểm tra ban đầu:** Tính tổng mảng. Nếu tổng không chia hết cho $k$, hoặc có phần tử lớn hơn mức trung bình, trả về `false`.*

2.  **Bitmask State:** Use a bitmask of length $N$ where the $i$-th bit represents whether `nums[i]` has been used in a subset.
    * **Trạng thái Bitmask:** Sử dụng một dãy bit dài $N$ để đại diện cho việc các phần tử đã được sử dụng hay chưa.*

3.  **Recursive Function `canPartition(mask, currentSum)`:**
    - If `mask` has all bits set, we have successfully partitioned all numbers. Return `true`.
    - If `currentSum == target`, we have completed one subset. Move to the next one by calling `canPartition(mask, 0)`.
    - Otherwise, try adding an unused element `nums[i]` to the `currentSum`.
    - If `currentSum + nums[i] <= target`:
        - Recurse with `newMask` (flip $i$-th bit) and `newCurrentSum`.
    * **Hàm Đệ quy:** Nếu mặt nạ bit đầy, trả về `true`. Nếu tổng hiện tại đạt mục tiêu, bắt đầu nhóm tiếp theo. Nếu chưa, thử thêm phần tử chưa dùng vào nhóm hiện tại.*

4.  **Memoization:** Store the result of `canPartition(mask)` to avoid recalculating the same subset combinations.
    * **Ghi nhớ:** Lưu kết quả của từng trạng thái `mask`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Pruning:** Sorting the array in descending order helps the backtracking fail early if larger numbers cannot be accommodated.
    * **Cắt tỉa:** Sắp xếp giảm dần giúp giải thuật thất bại sớm nếu các số lớn không thể xếp vào nhóm.*
*   **State Space:** The state is only defined by the `mask` because the total sum of elements used determines how many full groups have been completed and the remaining sum to fill the current group.
    * **Không gian Trạng thái:** Trạng thái chỉ được định nghĩa bởi `mask` vì tổng các phần tử đã dùng sẽ tự biểu thị tiến độ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(2^N \times N)$. There are $2^N$ possible states for the mask, and for each state, we iterate through $N$ elements.
    * **Độ phức tạp thời gian:** $O(2^N \times N)$.*
*   **Space Complexity:** $O(2^N)$ for the memoization array.
    * **Độ phức tạp không gian:** $O(2^N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**nums = [4, 3, 2, 1], k = 2, target = 5**
1. mask = 0, current = 0.
2. Add 4: mask = 1, current = 4.
3. Add 1: mask = 9 (bits for 4 and 1), current = 5.
4. target reached! Record mask=9, next call with current = 0.
5. Add 3: mask = 11, current = 3.
6. Add 2: mask = 15, current = 5.
7. target reached! All bits set.
**Result:** true.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

For partition problems with small constraints ($N \le 20$), bitmasks are the preferred way to track usage. Combining this with sorting for pruning and memoization to skip redundant branches turns an exponential problem into a manageable one.
*Đối với các bài toán chia tập hợp với ràng buộc nhỏ, bitmask là lựa chọn ưu tiên. Kết hợp với sắp xếp và ghi nhớ giúp bài toán trở nên khả thi.*
---
*Sự phân chia (Partition) đòi hỏi một sự công bằng tuyệt đối (Equal sum). Trong thế giới của các con số, mỗi phần tử đều phải tìm thấy nơi thuộc về mình (Subset) để tạo nên sự hài hòa tổng thể. Dữ liệu dạy ta rằng bằng cách ghi lại dấu chân của từng lựa chọn (Bitmask) và kiên nhẫn thử nghiệm mọi khả năng (Backtracking), ta có thể tìm thấy trật tự trong sự hỗn loạn của những giá trị rời rạc.*
Division (Partition) requires absolute fairness (Equal sum). In the world of numbers, every element must find its place (Subset) to create the overall harmony. Data teaches us that by recording the footprints of every choice (Bitmask) and patiently testing every possibility (Backtracking), we can find order in the chaos of discrete values.
