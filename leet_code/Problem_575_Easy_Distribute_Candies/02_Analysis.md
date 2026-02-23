# Analysis for Distribute Candies
# *Phân tích cho bài toán Phân chia Kẹo*

## 1. Problem Essence & The Upper Bound of Variety
## *1. Bản chất vấn đề & Giới hạn trên của sự Đa dạng*

### The Challenge
### *Thách thức*
Alice has $N$ candies and can eat at most $N/2$ of them. There are $T$ distinct types of candies in the collection.
*Alice có $N$ viên kẹo và chỉ có thể ăn tối đa $N/2$ viên. Có $T$ loại kẹo khác nhau trong bộ sưu tập.*

We want to maximize the number of unique types she can eat. This is limited by two simple factors:
*Chúng ta muốn tối đa hóa số lượng loại kẹo duy nhất mà cô ấy có thể ăn. Điều này bị giới hạn bởi hai yếu tố đơn giản:*
1.  **The Supply of Variety:** She cannot eat more types than actually exist ($T$).
    * **Nguồn cung đa dạng:** Cô ấy không thể ăn nhiều loại hơn số loại thực sự tồn tại ($T$).*
2.  **The Doctor's Limit:** She cannot eat more than $N/2$ total candies, regardless of their type.
    * **Giới hạn của bác sĩ:** Cô ấy không thể ăn tổng cộng nhiều hơn $N/2$ viên kẹo, bất kể chúng thuộc loại nào.*

---

## 2. Strategy: HashSet and Mathematical Minima
## *2. Chiến lược: HashSet và Giá trị Nhỏ nhất Toán học*

The result is simply the smaller of these two limits.
*Kết quả đơn giản là giá trị nhỏ hơn trong hai giới hạn này.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Count Unique Types ($T$):** Use a `HashSet` to store all types of candies present in the `candyType` array. The size of the set will be $T$.
    * **Đếm số loại duy nhất ($T$):** Sử dụng một `HashSet` để lưu trữ tất cả các loại kẹo có trong mảng `candyType`. Kích thước của tập hợp sẽ là $T$.*

2.  **Calculate Allowance ($A$):** Divide the array length by 2. $A = N / 2$.
    * **Tính toán mức cho phép ($A$):** Chia độ dài mảng cho 2. $A = N / 2$.*

3.  **Find Minimum:** The maximum number of different types Alice can eat is `min(T, A)`.
    * **Tìm giá trị nhỏ nhất:** Số lượng loại kẹo khác nhau tối đa mà Alice có thể ăn là `min(T, A)`.*

---

## 3. Structural Advantages & Efficiency
## *3. Ưu điểm Cấu trúc & Hiệu quả*

*   **HashSet Mapping:** Since we only care about "existence" and not "frequency", a HashSet is perfect for filtering duplicates in $O(N)$ time.
    * **Ánh xạ HashSet:** Vì chúng ta chỉ quan tâm đến "sự tồn tại" chứ không phải "tần suất", HashSet là lựa chọn hoàn hảo để lọc các phần tử trùng lặp trong thời gian $O(N)$.*
*   **Simple Logic:** The logic is purely mathematical once $T$ is found, avoiding any complex permutations or search algorithms.
    * **Logic đơn giản:** Logic hoàn toàn mang tính toán học sau khi tìm thấy $T$, tránh được bất kỳ hoán vị hoặc thuật toán tìm kiếm phức tạp nào.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We iterate through the candy array once to populate the HashSet.
    * **Độ phức tạp thời gian:** $O(N)$. Chúng ta duyệt qua mảng kẹo một lần để đưa dữ liệu vào HashSet.*
*   **Space Complexity:** $O(N)$ in the worst case where every candy is a different type, to store them in the HashSet.
    * **Độ phức tạp không gian:** $O(N)$ trong trường hợp xấu nhất khi mỗi viên kẹo là một loại khác nhau, để lưu trữ chúng trong HashSet.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** `candyType = [1, 1, 2, 3]`
- Unique types (T): `{1, 2, 3}` -> Size = 3.
- Allowance (A): `4 / 2 = 2`.
- Result: `min(3, 2) = 2`.
- Alice can eat [1, 2] or [1, 3] or [2, 3]. Max types = 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

When faced with multiple constraints, identify the limiting factor (the bottleneck) to find the optimal result quickly.
*Khi đối mặt với nhiều ràng buộc, hãy xác định yếu tố giới hạn (điểm nghẽn) để tìm ra kết quả tối ưu một cách nhanh chóng.*
---
*Hạnh phúc (Happiness) không nằm ở số lượng kẹo ta có, mà ở sự đa dạng (Variety) của những trải nghiệm ta nhận được. Dù cuộc sống (Doctor) có đặt ra những giới hạn về định mức, ta vẫn có thể đạt được sự phong phú tối đa bằng cách chọn lọc những điều khác biệt nhất trong khả năng cho phép.*
Happiness (Happiness) does not lie in the number of candies we have, but in the variety (Variety) of experiences we receive. Although life (Doctor) sets limits on quotas, we can still achieve maximum richness by selecting the most different things within the allowable capacity.
