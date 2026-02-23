# Analysis for Array Nesting
# *Phân tích cho bài toán Lồng mảng*

## 1. Problem Essence & Circular Permutations
## *1. Bản chất vấn đề & Các hoán vị vòng lặp*

### The Challenge
### *Thách thức*
We are given an array `nums` which is a permutation of integers from $0$ to $n-1$. We need to find the longest "nesting" set where each value points to the next index.
*Chúng ta được trao một mảng `nums` vốn là một hoán vị của các số nguyên từ $0$ đến $n-1$. Chúng ta cần tìm tập hợp "lồng nhau" dài nhất trong đó mỗi giá trị trỏ đến chỉ số tiếp theo.*

Because the array is a permutation (no duplicates, all values $0...n-1$ present), the entire array can be visualized as a set of **disjoint cycles**.
*Vì mảng là một hoán vị (không trùng lặp, tất cả các giá trị $0...n-1$ đều hiện diện), toàn bộ mảng có thể được hình dung như một tập hợp các **chu trình rời nhau**.*

---

## 2. Strategy: Cycle Decomposition with Visiting Marks
## *2. Chiến lược: Phân tách Chu trình với Đánh dấu*

Starting from any index $i$, and following the path $i \rightarrow nums[i] \rightarrow nums[nums[i]] \dots$, you will eventually return to $i$.
*Bắt đầu từ bất kỳ chỉ số $i$ nào, và đi theo con đường $i \rightarrow nums[i] \rightarrow nums[nums[i]] \dots$, cuối cùng bạn sẽ quay trở lại $i$.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Iterate through all indices:** Loop from `i = 0` to `n-1`.
    * **Duyệt qua tất cả các chỉ số:** Lặp từ `i = 0` đến `n-1`.*

2.  **Check if Visited:** Since cycles are disjoint, once we have explored a cycle, we never need to explore any element of that cycle again.
    * **Kiểm tra xem đã thăm chưa:** Vì các chu trình là rời nhau, một khi chúng ta đã khám phá một chu trình, chúng ta không bao giờ cần khám phá lại bất kỳ phần tử nào của chu trình đó nữa.*

3.  **Trace the Cycle:** If `nums[i]` is not marked:
    * **Truy vết Chu trình:** Nếu `nums[i]` chưa được đánh dấu:*
    - Start traversing the current cycle.
    - *Bắt đầu duyệt chu trình hiện tại.*
    - For each element in the cycle, mark it as "visited" (e.g., set its value to -1 or use a boolean array).
    - *Đối với mỗi phần tử trong chu trình, hãy đánh dấu nó là "đã thăm" (ví dụ: đặt giá trị của nó thành -1 hoặc sử dụng một mảng boolean).*
    - Count the number of elements in this cycle.
    - *Đếm số lượng phần tử trong chu trình này.*

4.  **Update Global Maximum:** Keep track of the length of the longest cycle found.
    * **Cập nhật Giá trị lớn nhất toàn cục:** Theo dõi độ dài của chu trình dài nhất tìm thấy.*

---

## 3. Structural Advantages & Efficiency
## *3. Ưu điểm Cấu trúc & Hiệu quả*

*   **Linear Efficiency:** Even though we have a nested loop (one for indices, one for the cycle), each element is touched exactly once across the entire execution.
    * **Hiệu quả Tuyến tính:** Mặc dù chúng ta có một vòng lặp lồng nhau (một cho các chỉ số, một cho chu trình), mỗi phần tử chỉ được chạm vào đúng một lần trong toàn bộ quá trình thực thi.*
*   **In-place Modification:** By marking the original array, we can achieve $O(1)$ auxiliary space.
    * **Sửa đổi tại chỗ:** Bằng cách đánh dấu mảng ban đầu, chúng ta có thể đạt được không gian phụ trợ $O(1)$.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Each node in the graph (index) is visited once.
    * **Độ phức tạp thời gian:** $O(N)$. Mỗi nút trong đồ thị (chỉ số) đều được thăm một lần.*
*   **Space Complexity:** $O(1)$ if you modify the input, or $O(N)$ if you use an extra `visited` array.
    * **Độ phức tạp không gian:** $O(1)$ nếu bạn sửa đổi đầu vào, hoặc $O(N)$ nếu bạn sử dụng một mảng `visited` bổ sung.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `nums = [5, 4, 0, 3, 1, 6, 2]`
- i = 0 (Val 5): 5 -> 6 -> 2 -> 0 -> (Returns to 5). Length = 4. Mark {5, 6, 2, 0}.
- i = 1 (Val 4): 4 -> 1 -> (Returns to 4). Length = 2. Mark {4, 1}.
- i = 2 (Marked): Skip.
- i = 3 (Val 3): 3 -> (Returns to 3). Length = 1. Mark {3}.
- i = 4 (Marked): Skip.
- **Max length found:** 4.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Permutations naturally form disjoint cycles; identifying these cycles is a fundamental technique for many array pointer problems.
*Các hoán vị tạo thành các chu trình rời nhau một cách tự nhiên; việc xác định các chu trình này là một kỹ thuật cơ bản cho nhiều bài toán về con trỏ mảng.*
---
*Cuộc sống giống như một mạng lưới các chu trình (Cycles). Đôi khi ta cảm thấy mình đang lặp lại những bước chân cũ (nums[i]), nhưng thực chất ta đang khám phá phạm vi (Length) của một vòng lặp lớn hơn. Chỉ bằng cách dũng cảm bước đi và đánh dấu (Visited) những gì đã qua, ta mới thấy được vòng lặp vĩ đại nhất.*
Life is like a network of cycles (Cycles). Sometimes we feel that we are repeating our old steps (nums[i]), but in fact we are exploring the range (Length) of a larger loop. Only by bravely walking and marking (Visited) what has passed can we see the greatest loop.
