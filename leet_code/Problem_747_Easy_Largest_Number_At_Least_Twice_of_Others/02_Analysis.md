# Analysis for Largest Number At Least Twice of Others
# *Phân tích cho bài toán Số Lớn nhất Gấp Ít nhất Hai lần Các Số Khác*

## 1. Problem Essence & Dominance Check
## *1. Bản chất vấn đề & Kiểm tra Sự vượt trội*

### The Challenge
### *Thách thức*
We need to find the "Dominant Index" where the value is at least double any *other* value. Since it must be double *every* other value, it suffices to check if the largest value is at least double the **second largest** value.
*Chúng ta cần tìm "Chỉ số Vượt trội" nơi giá trị lớn gấp ít nhất hai lần bất kỳ giá trị *khác* nào. Vì nó phải gấp đôi *mọi* giá trị khác, chỉ cần kiểm tra xem giá trị lớn nhất có gấp ít nhất hai lần giá trị **lớn thứ hai** hay không là đủ.*

---

## 2. Strategy: Single Pass Max Tracking
## *2. Chiến lược: Theo dõi Max trong Một lần Duyệt*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Iterate:** Traverse the array to find the largest value (`maxVal`) and its index (`maxIndex`).
    *   **Duyệt:** Quét mảng để tìm giá trị lớn nhất (`maxVal`) và chỉ số của nó (`maxIndex`).*

2.  **Verify:** Traverse again (or track `secondMax` simultaneously) to check if `maxVal >= 2 * x` for all `x != maxVal`.
    *   **Xác minh:** Quét lại (hoặc theo dõi `secondMax` đồng thời) để kiểm tra điều kiện.*

3.  **Optimization:** We can maintain `max1` (largest) and `max2` (second largest) in a single loop.
    - If `num > max1`: `max2 = max1`, `max1 = num`.
    - Else if `num > max2`: `max2 = num`.
    *   **Tối ưu:** Duy trì số lớn nhất và số lớn nhì ngay trong một vòng lặp.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. Single pass.
    *   **Độ phức tạp thời gian:** $O(N)$.*
*   **Space Complexity:** $O(1)$.
    *   **Độ phức tạp không gian:** $O(1)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**nums = [3, 6, 1, 0]**
1. Num 3: max1=3 (idx 0), max2=-1.
2. Num 6: 6 > 3. max2=3, max1=6 (idx 1).
3. Num 1: 1 < 3. max2 unchanged.
4. Num 0: 0 < 3. max2 unchanged.
5. Final check: max1 (6) >= 2 * max2 (3)? 6 >= 6. Yes. Return 1.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Simple linear scan. Tracking the "top 2" elements is standard for dominance checks.
*Quét tuyến tính đơn giản. Việc theo dõi "top 2" phần tử là chuẩn mực cho các bài kiểm tra sự vượt trội.*
---
*Số một (Number One) chỉ thực sự là kẻ thống trị (Dominant) khi nó vượt xa người đứng thứ hai (Index max2) một khoảng cách an toàn (Twice). Dữ liệu dạy ta rằng trong một tập hợp ganh đua, sự vĩ đại không chỉ được đo bằng độ cao tuyệt đối (Max val) mà còn bằng khoảng cách tương đối so với những kẻ bám đuổi (Relative gap).*
Number one (Number One) is only truly dominant (Dominant) when it far exceeds the runner-up (Index max2) by a safe distance (Twice). Data teaches us that in a competitive set, greatness is measured not only by absolute height (Max val) but also by the relative gap to the pursuers (Relative gap).
