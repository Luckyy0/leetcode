# 1029. Two City Scheduling / Lên lịch cho Hai Thành phố

## Problem Description / Mô tả bài toán
A company is planning to interview `2n` people. Given the array `costs` where `costs[i] = [aCost_i, bCost_i]`, the cost of flying the `i-th` person to city A is `aCost_i`, and to city B is `bCost_i`.
Một công ty đang lên kế hoạch phỏng vấn `2n` người. Cho mảng `costs` trong đó `costs[i] = [aCost_i, bCost_i]`, chi phí bay người thứ `i` đến thành phố A là `aCost_i`, và đến thành phố B là `bCost_i`.

Return the minimum cost to fly every person to a city such that exactly `n` people arrive in each city.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy Difference Sorting / Sắp xếp Chênh lệch Tham lam
We want to send a person to A if `costA` is significantly smaller than `costB`.
Chúng ta muốn gửi một người đến A nếu `costA` nhỏ hơn đáng kể so với `costB`.
Basically, minimize `costA - costB`.

Algorithm:
1. Sort people based on `(costA - costB)`.
2. The first `n` people (smallest difference, meaning most savings for A relative to B) go to City A.
3. The remaining `n` people go to City B.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(log N) for sorting.

---

## Analysis / Phân tích

### Approach: Marginal Cost Optimization
Calculate the "opportunity cost" of sending each person to City A instead of City B (`val = costA - costB`). Sort the candidates by this difference. The top N candidates (those with the smallest/most negative difference) are ideally suited for City A, while the rest are assigned to City B to minimize total expenditure.
Tính toán "chi phí cơ hội" của việc gửi mỗi người đến Thành phố A thay vì Thành phố B (`val = costA - costB`). Sắp xếp các ứng cử viên theo sự khác biệt này. N ứng cử viên hàng đầu (những người có sự khác biệt nhỏ nhất/âm nhất) phù hợp nhất với Thành phố A, trong khi những người còn lại được chỉ định đến Thành phố B để giảm thiểu tổng chi phí.

---
