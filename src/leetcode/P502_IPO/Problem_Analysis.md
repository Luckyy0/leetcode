# 502. IPO

## Problem Description / Mô tả bài toán
Suppose LeetCode will start its **IPO** soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the **IPO**. Since it has limited resources, it can only finish at most `k` distinct projects before the **IPO**. Help LeetCode design the best way to maximize its total capital after finishing at most `k` distinct projects.
Giả sử LeetCode sẽ sớm thực hiện **IPO**. Để bán được cổ phiếu với giá tốt cho các Quỹ đầu tư mạo hiểm, LeetCode muốn thực hiện một số dự án để tăng vốn trước khi **IPO**. Vì nguồn lực có hạn, nó chỉ có thể hoàn thành tối đa `k` dự án khác nhau trước khi **IPO**. Hãy giúp LeetCode thiết kế cách tốt nhất để tối đa hóa tổng số vốn sau khi hoàn thành tối đa `k` dự án.

You are given `n` projects where the `i-th` project has a profit `profits[i]` and a minimum capital `capital[i]` needed to start it.
Bạn được cho `n` dự án, trong đó dự án thứ `i` có lợi nhuận `profits[i]` và số vốn tối thiểu `capital[i]` cần thiết để bắt đầu nó.

Initially, you have `w` capital. When you finish a project, you will obtain its profit and the profit will be added to your total capital.
Ban đầu, bạn có số vốn `w`. Khi bạn hoàn thành một dự án, bạn sẽ nhận được lợi nhuận của nó và lợi nhuận đó sẽ được cộng vào tổng số vốn của bạn.

Pick a list of at most `k` distinct projects from given projects to **maximize your final capital**, and return the final maximized capital.
Hãy chọn một danh sách tối đa `k` dự án khác nhau để **tối đa hóa số vốn cuối cùng** và trả về số vốn tối đa đó.

### Example 1:
```text
Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
Output: 4
Explanation: Since your initial capital is 0, you can only start the project indexed 0.
After finishing it, your capital becomes 0 + 1 = 1.
With capital 1, you can either start project indexed 1 or project indexed 2.
Since you can choose at most 2 projects, you need to finish project indexed 2 to get the maximum capital.
Therefore, your final capital is 1 + 3 = 4.
```

## Constraints / Ràng buộc
- `1 <= k <= 10^5`
- `0 <= w <= 10^9`
- `n == profits.length == capital.length`
- `1 <= n <= 10^5`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy with Max-Heap and Min-Heap / Tham lam với Hàng đợi ưu tiên
At each step, we should pick the project that gives the **highest profit** among all projects we can currently **afford**.

Algorithm:
1. Create a list of projects `(capital, profit)` and sort them by capital required in **ascending order**.
2. Use a **Max-Heap** to store the profits of projects we can afford.
3. For `k` times (or until no more projects can be picked):
   - Move all projects whose capital requirement is $\le w$ from the sorted project list to the Max-Heap.
   - If the Max-Heap is empty, break (no projects affordble).
   - Extract the highest profit from the Max-Heap and add it to `w`.
4. Return `w`.

### Complexity / Độ phức tạp
- **Time**: O(N log N + K log N) where N is the number of projects. O(N log N) for initial sorting and each project is pushed/popped from the heap at most once.
- **Space**: O(N) to store the projects.

---

## Analysis / Phân tích

### Approach: Affordability-based Greedy Selection

**Algorithm**:
1.  Sort projects by capital requirement.
2.  Iterate `k` rounds.
3.  Add all newly affordable projects to Max-Heap.
4.  Select top profit and update `w`.

---
