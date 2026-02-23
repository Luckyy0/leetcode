# Analysis for Shopping Offers
# *Phân tích cho bài toán Ưu đãi Mua sắm*

## 1. Problem Essence & Optimization with Constraints
## *1. Bản chất vấn đề & Tối ưu hóa với Ràng buộc*

### The Challenge
### *Thách thức*
We need to fulfill an exact list of "needs" (quantities for $n$ items) at the minimum total cost, using a combination of individual unit prices and bundled special offers.
*Chúng ta cần đáp ứng chính xác một danh sách "nhu cầu" (số lượng cho $n$ mặt hàng) với tổng chi phí tối thiểu, sử dụng sự kết hợp giữa đơn giá riêng lẻ và các ưu đãi đặc biệt theo gói.*

The constraint is that we cannot buy *more* than what we need. This prevents us from using a greedy "cheapest per unit" approach and makes it a variation of the Knapsack or Change-making problem.
*Ràng buộc là chúng ta không được mua *nhiều hơn* mức cần thiết. Điều này ngăn cản chúng ta sử dụng cách tiếp cận tham lam "rẻ nhất trên mỗi đơn vị" và biến nó thành một biến thể của bài toán Cái túi (Knapsack) hoặc Đổi tiền (Change-making).*

---

## 2. Strategy: Backtracking with Memoization
## *2. Chiến lược: Quay lui với Bộ nhớ đệm (Memoization)*

Since the number of items is small ($n \le 6$) and each need is small ($\le 10$), the state space of `needs` is finite and manageable ($11^6 \approx 1.7 \times 10^6$).
*Vì số lượng mặt hàng ít ($n \le 6$) và mỗi nhu cầu nhỏ ($\le 10$), không gian trạng thái của `needs` là hữu hạn và có thể quản lý được.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Baseline Cost:** For any given `needs` vector, the initial "best price" is the cost of buying everything at individual prices: `sum(needs[i] * price[i])`.
    * **Chi phí Cơ sở:** Đối với bất kỳ véc-tơ `needs` nào, "giá tốt nhất" ban đầu là chi phí mua mọi thứ theo giá riêng lẻ.*

2.  **Explore Special Offers:** Iterate through each available `special` offer.
    * **Khám phá Ưu đãi Đặc biệt:** Duyệt qua từng ưu đãi `special` có sẵn.*
    - **Validity Check:** Does this offer provide more of any item than we currently need? If yes, skip it.
    - **Recursive Call:** If valid, subtract the offer's quantities from our `needs` and recursively call the function to find the minimum cost for the *remaining* needs.
    - **Price Comparison:** `total = offerPrice + recursiveCall(remainingNeeds)`. Update the overall minimum cost for the current state.

3.  **Memoization:** Store the result for each `needs` vector (converted to a string or list as a Key) in a `Map<List<Integer>, Integer>`.
    * **Ghi nhớ (Memoization):** Lưu trữ kết quả cho mỗi véc-tơ `needs` trong một `Map`.*

---

## 3. Structural Advantages & Nuances
## *3. Ưu điểm Cấu trúc & Sắc thái*

*   **Pruning:** The "cannot buy more" rule naturally prunes the search tree. We only descend into recursive branches that are valid.
    * **Cắt tỉa:** Quy tắc "không mua quá mức" cắt tỉa cây tìm kiếm một cách tự nhiên. Chúng ta chỉ đi xuống các nhánh đệ quy hợp lệ.*
*   **Exact Matching:** The exhaustive nature of backtracking ensures that we consider all possible combinations of offers that could potentially lead to a lower total price than the individual prices.
    * **Khớp chính xác:** Tính chất thấu đáo của quay lui đảm bảo rằng chúng ta xem xét tất cả các kết hợp ưu đãi có thể dẫn đến tổng giá thấp hơn giá riêng lẻ.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(\text{SpecialOffers} \times (\text{MaxNeed} + 1)^N)$, though significantly reduced by memoization and pruning.
    * **Độ phức tạp thời gian:** $O(\text{SpecialOffers} \times (\text{MaxNeed} + 1)^N)$, mặc dù được giảm bớt đáng kể nhờ ghi nhớ và cắt tỉa.*
*   **Space Complexity:** $O((\text{MaxNeed} + 1)^N)$ to store results in the memoization map.
    * **Độ phức tạp không gian: $O((\text{MaxNeed} + 1)^N)$ để lưu trữ các kết quả trong bản đồ ghi nhớ.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng Hình ảnh*

**Needs:** [3, 2], Prices: A=2, B=5. Offers: [3, 0, 5], [1, 2, 10].
1. Baseline: 3*2 + 2*5 = 16.
2. Try Offer 1 [3,0,5]:
   - Remaining: [0, 2].
   - Recurse [0, 2] -> Baseline: 2*5 = 10.
   - Total: 5 + 10 = 15 (Better than 16).
3. Try Offer 2 [1,2,10]:
   - Remaining: [2, 0].
   - Recurse [2, 0] -> Baseline: 2*2 = 4.
   - Total: 10 + 4 = 14 (Better than 15).
**Result:** 14.

---

## 6. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

When faced with a "best combination" problem with a relatively small state space, Top-down DP (Recursion + Memoization) is often easier to implement and reason about than bottom-up DP. It automatically focuses only on reachable states.
*Khi đối mặt với bài toán "kết hợp tốt nhất" với không gian trạng thái tương đối nhỏ, DP từ trên xuống (Đệ quy + Ghi nhớ) thường dễ triển khai và suy luận hơn so với DP từ dưới lên. Nó tự động chỉ tập trung vào các trạng thái có thể tiếp cận.*
---
*Giá trị (Value) thực sự được tìm thấy khi ta biết tận dụng những cơ hội đúng lúc (Special offers). Trong bài toán mua sắm (Shopping), việc tối ưu hóa chi phí (Lowest price) không chỉ là chọn cái rẻ nhất, mà là sự tính toán tỉ mỉ giữa nhu cầu (Needs) và sự đánh đổi (Combinations). Dữ liệu dạy ta rằng sự kiên trì trong việc thử nghiệm mọi khả năng (Backtracking) kết hợp với trí nhớ sắc bén (Memoization) sẽ dẫn lối đến sự thông thái trong tiêu dùng.*
True value (Value) is found when we know how to take advantage of opportunities at the right time (Special offers). In shopping (Shopping), cost optimization (Lowest price) is not just choosing the cheapest, but a meticulous calculation between needs (Needs) and trade-offs (Combinations). Data teaches us that persistence in testing all possibilities (Backtracking) combined with a sharp memory (Memoization) will lead to wisdom in consumption.
