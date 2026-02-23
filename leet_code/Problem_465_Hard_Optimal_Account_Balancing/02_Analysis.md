# Analysis for Optimal Account Balancing
# *Phân tích cho bài toán Cân bằng Tài khoản Tối ưu*

## 1. Problem Essence & Net Balance
## *1. Bản chất vấn đề & Số dư ròng*

### The Challenge
### *Thách thức*
Settling all debts with minimum transactions. The exact history of who gave to whom doesn't matter; only the **net balance** of each person matters.
- If person A gave $10 and received $5, their net balance is $+5$.
- If person B received $10 and gave $0, their net balance is $-10$.
- The goal is to make all net balances zero using minimum transfers.

### Strategy: Backtracking with Pruning
### *Chiến lược: Quay lui kết hợp Cắt tỉa*

1.  **Calculate Balances:** Use a `Map` to calculate the net balance for each person. Filter out people with zero balance.
2.  **Backtracking:**
    - `dfs(index)`: Try to settle the balance of `balance[index]` using balances from `index + 1` to `N-1`.
    - To minimize transactions, we want to pick a person `j > index` such that `balance[i] * balance[j] < 0` (opposite signs).
    - Update `balance[j] += balance[index]`.
    - Recurse: `1 + dfs(index + 1)`.
    - Backtrack: `balance[j] -= balance[index]`.
3.  **Optimization:** Skip people whose balance is already zero.

---

## 2. Approach: State-Space Search
## *2. Hướng tiếp cận: Tìm kiếm không gian trạng thái*

### Logic
### *Logic*
(See above). Since we only care about the number of transactions, we treat each person as a node in a graph. We are essentially trying to partition the balances into a maximum number of subsets that sum to zero. Each such subset of size $k$ can be settled in $k-1$ transactions. The more zero-sum subsets we find, the fewer transactions we need.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Financial Accuracy:** Only cares about final debt obligations.
    *Độ chính xác tài chính: Chỉ quan tâm đến nghĩa vụ nợ cuối cùng.*
*   **Effective for Small N:** Works perfectly for the problem's constraints.
    *Hiệu quả với N nhỏ: Hoạt động hoàn hảo với các ràng buộc của bài toán.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N!)$, where $N$ is the number of people with non-zero balance. However, the search space is limited by pruning.
    *Độ phức tạp thời gian: $O(N!)$.*
*   **Space Complexity:** $O(N)$ for the recursion stack and balance list.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Net Balances:** `[10, -5, -2, -3]`
1. `dfs(0)`: Settle +10.
2. Try `j=1 (-5)`: New balance `[0, 5, -2, -3]`. 1 transaction.
   - `dfs(1)`: Settle +5.
   - Try `j=2 (-2)`: New balance `[0, 0, 3, -3]`. 2 transactions.
     - `dfs(2)`: Settle +3.
     - Try `j=3 (-3)`: 3 transactions. All zero.
Total: 3 transactions.
*Wait, if we matched 10 with (-5, -2, -3) it's 3. If we matched 10 with -10, it's 1.*

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Calculate net balances and use DFS to settle them.
*Tính toán số dư ròng và sử dụng DFS để tất toán.*
---
*Nợ nần là sợi dây liên kết vô hình giữa những con người (transactions). Tuy nhiên, trong nghệ thuật quản lý tài chính, sự tinh gọn là đỉnh cao của trí tuệ. Thay vì trả nợ theo vòng lặp dài lê thê, ta gộp tất cả về những con số ròng rã (net balance) và tìm con đường ngắn nhất để đưa tất cả về số không (zero-sum). Khi gánh nặng được trút bỏ với ít nỗ lực nhất, đó cũng là lúc sự tự do bắt đầu.*
Debt is an invisible link between people (transactions). However, in the art of financial management, conciseness is the pinnacle of intellect. Instead of paying debt in a long loop, we aggregate everything to net numbers (net balance) and find the shortest path to bring it all to zero (zero-sum). When the burden is thrown away with the least effort, that is also when freedom begins.
