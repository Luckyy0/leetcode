# Analysis for Longest Harmonious Subsequence
# *Phân tích cho bài toán Chuỗi con Hài hòa Dài nhất*

## 1. Problem Essence & Numeric Proximity
## *1. Bản chất vấn đề & Sự gần gũi của các Con số*

### The Challenge
### *Thách thức*
A harmonious subsequence contains only two distinct numbers, $x$ and $x+1$. We need to find the pair $(x, x+1)$ that appears most frequently in the original array.
*Một chuỗi con hài hòa chỉ chứa hai con số riêng biệt, $x$ và $x+1$. Chúng ta cần tìm cặp $(x, x+1)$ xuất hiện thường xuyên nhất trong mảng ban đầu.*

The order of elements doesn't matter for a subsequence when we are only concerned about content and length, so this effectively becomes a frequency counting problem.
*Thứ tự của các phần tử không quan trọng đối với một chuỗi con khi chúng ta chỉ quan tâm đến nội dung và độ dài, vì vậy điều này thực sự trở thành một bài toán đếm tần suất.*

---

## 2. Strategy: HashMap Frequency Counting
## *2. Chiến lược: Đếm tần suất bằng HashMap*

We use a `HashMap` to store how many times each number appears.
*Chúng ta sử dụng một `HashMap` để lưu trữ số lần mỗi con số xuất hiện.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Build Frequency Map:** Iterate through `nums` and populate a Map where `key = number` and `value = count`.
    * **Xây dựng Bản đồ Tần suất:** Duyệt qua `nums` và đưa dữ liệu vào một Map trong đó `key = số` và `value = số lần xuất hiện`.*

2.  **Evaluate Pairs:** Iterate through the keys of the Map.
    * **Đánh giá các Cặp:** Duyệt qua các khóa của Map.*
    - For each number `x` in the Map, check if `x + 1` also exists in the Map.
    - *Đối với mỗi số `x` trong Map, kiểm tra xem `x + 1` cũng tồn tại trong Map hay không.*
    - If it exists, the length of the potential harmonious subsequence is `Count(x) + Count(x + 1)`.
    - *Nếu nó tồn tại, độ dài của chuỗi con hài hòa tiềm năng là `Count(x) + Count(x + 1)`.*

3.  **Track Maximum:** Update a global `maxLen` variable with the highest value found.
    * **Theo dõi Giá trị Tối đa:** Cập nhật biến `maxLen` toàn cục với giá trị cao nhất được tìm thấy.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Optimal Search:** `HashMap` provides $O(1)$ average time for checking the existence of `x + 1`.
    * **Tìm kiếm Tối ưu:** `HashMap` cung cấp thời gian trung bình $O(1)$ để kiểm tra sự tồn tại của `x + 1`.*
*   **Irrelevance of Order:** By summarizing the array into a frequency map first, we ignore the complexity of element positions, which is allowed because we are looking for a subsequence.
    * **Thứ tự không liên quan:** Bằng cách tóm tắt mảng vào một bản đồ tần suất trước, chúng ta bỏ qua sự phức tạp về vị trí phần tử, điều này được phép vì chúng ta đang tìm kiếm một chuỗi con.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$. We sweep the array once to build the map ($O(N)$) and sweep the map keys once to find the max harmony ($O(N)$).
    * **Độ phức tạp thời gian:** $O(N)$. Chúng ta quét mảng một lần để xây dựng bản đồ ($O(N)$) và quét các khóa bản đồ một lần để tìm sự hài hòa tối đa ($O(N)$).*
*   **Space Complexity:** $O(N)$ In the worst case where every number is unique, we store all of them in the map.
    * **Độ phức tạp không gian:** $O(N)$ Trong trường hợp xấu nhất khi mọi con số là duy nhất, chúng ta lưu trữ tất cả chúng trong bản đồ.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Input:** [1, 3, 2, 2, 2, 3]
- **Map:** {1: 1, 3: 2, 2: 3}
- Check key 1: Is 2 in map? Yes. Count = 1 + 3 = 4.
- Check key 2: Is 3 in map? Yes. Count = 3 + 2 = 5.
- Check key 3: Is 4 in map? No.
- **Max Length:** 5.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Whenever a problem asks for properties of a subsequence that depend only on the values and not their positions, always consider a frequency-based approach as it reduces the problem dimensionality.
*Bất cứ khi nào một bài toán yêu cầu các thuộc tính của một chuỗi con chỉ phụ thuộc vào giá trị chứ không phải vị trí của chúng, hãy luôn cân nhắc phương pháp tiếp cận dựa trên tần suất vì nó làm giảm chiều của bài toán.*
---
*Sự hài hòa (Harmony) không đến từ sự tương đồng tuyệt đối, mà từ sự kết nối giữa những điều khác biệt nhưng cận kề. Trong toán học, một sự chênh lệch nhỏ nhất nhưng chính xác (Exactly 1) lại tạo nên một chuỗi con dài nhất. Sự bổ khuyết cho nhau (Complementarity) chính là chìa khóa của sự phát triển.*
Harmony (Harmony) does not come from absolute similarity, but from the connection between different but nearby things. In mathematics, a smallest but precise difference (Exactly 1) creates a longest subsequence. Complementarity is the key to development.
