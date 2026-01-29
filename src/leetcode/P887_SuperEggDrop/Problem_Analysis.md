# 887. Super Egg Drop / Thử thả Trứng siêu cấp

## Problem Description / Mô tả bài toán
You are given `k` eggs and a building with `n` floors.
Bạn được cho `k` quả trứng và một tòa nhà có `n` tầng.

Find the minimum number of drops you need to determine the highest floor from which an egg can be dropped without breaking.
Hãy tìm số lần thả ít nhất để xác định tầng cao nhất mà tại đó một quả trứng có thể được thả xuống mà không bị vỡ.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming with Optimization / Quy hoạch Động với Tối ưu hóa
A standard DP would be $O(K \cdot N^2)$, too slow for $N=10000$.
Một phép toán DP tiêu chuẩn sẽ là $O(K \cdot N^2)$, quá chậm.

Reframing the problem:
Instead of "How many drops for $N$ floors?", ask "How many floors covered with $M$ drops and $K$ eggs?".
Thay vì câu hỏi "Cần bao nhiêu lần thả cho $N$ tầng?", hãy hỏi "Có thể phủ bao nhiêu tầng với $M$ lần thả và $K$ quả trứng?".

Let `dp[m][k]` be the maximum floors we can test with `m` drops and `k` eggs.
Transition:
If we drop an egg:
- It breaks: we can test `dp[m-1][k-1]` floors below.
- It doesn't break: we can test `dp[m-1][k]` floors above.
- Total floors: `dp[m][k] = 1 + dp[m-1][k-1] + dp[m-1][k]`.

Algorithm:
- Increment `m` until `dp[m][k] >= n`.

### Complexity / Độ phức tạp
- **Time**: O(K log N).
- **Space**: O(N * K) or O(K).

---

## Analysis / Phân tích

### Approach: Floor-Coverage DP
By treating drops as a resource and floors as the results, we flip the complexity. This approach focuses on the binary branching nature of the problem, where each outcome leads to a specific number of floors that can still be explored.
Bằng cách coi các lần thả là một nguồn lực và các tầng là kết quả, chúng ta đảo ngược độ phức tạp. Cách tiếp cận này tập trung vào bản chất phân nhánh nhị phân của bài toán, trong đó mỗi kết quả dẫn đến một số lượng tầng cụ thể vẫn có thể được khám phá.

---
