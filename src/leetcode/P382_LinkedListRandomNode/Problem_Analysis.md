# 382. Linked List Random Node / Nút Ngẫu Nhiên Trong Danh Sách Liên Kết

## Problem Description / Mô tả bài toán
Given a singly linked list, return a random node's value from the linked list. Each node must have the **same probability** of being chosen.
Cho một danh sách liên kết đơn, trả về giá trị của một nút ngẫu nhiên.

Implement the `Solution` class:
- `Solution(ListNode head)` Initializes the object with the head of the singly-linked list `head`.
- `int getRandom()` Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be chosen.

### Example 1:
```text
Input
["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
[[[1, 2, 3]], [], [], [], [], []]
Output
[null, 1, 3, 2, 2, 3]
Explanation
Solution solution = new Solution([1, 2, 3]);
solution.getRandom(); // return 1
solution.getRandom(); // return 3
solution.getRandom(); // return 2
solution.getRandom(); // return 2
solution.getRandom(); // return 3
// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
```

## Constraints / Ràng buộc
- The number of nodes in the linked list will be in the range `[1, 10^4]`.
- `-10^4 <= Node.val <= 10^4`
- At most `10^4` calls will be made to `getRandom`.

**Follow up**:
- What if the linked list is extremely large and its length is unknown to you?
- Could you solve this efficiently without using extra space?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Reservoir Sampling / Lấy Mẫu Hồ Chứa
To select 1 element from a stream of unknown length N with probability `1/N`:
- Keep `result = head.val`.
- Iterate `curr` from 2nd node (index `i=2`, 1-based or index=1 `i=1` if we consider head index 0? Let's use 1-based counting).
- At index `i` (current node), replace `result` with `curr.val` with probability `1/i`.
- Proof:
    - P(Choosing `k`-th element) = P(Selected at step k) * P(Not selected at step k+1) * ... * P(Not selected at step N).
    - `(1/k) * (k/(k+1)) * ((k+1)/(k+2)) * ... * ((N-1)/N) = 1/N`. Correct.

### Pre-Calculation (ArrayList)
Since constraints say N <= 10^4 (small) and calls <= 10^4.
We can copy list to ArrayList. `getRandom` is O(1). Space O(N).
This is faster for valid constraints.
"Follow up" asks for Reservoir Sampling (O(1) space, but O(N) time per call).

I will implement **ArrayList** for efficiency under constraints, but mention Reservoir Sampling in comments or use Reservoir Sampling if strict space constraint is critical. The prompt implies normal constraints. ArrayList is standard O(N) init, O(1) query.
Actually, let's implement the **Reservoir Sampling** to satisfy the "Follow up" mindset as it's the specific algorithm for this problem type.

Wait, if number of calls is 10^4 and length is 10^4. Reservoir takes 10^4 * 10^4 = 10^8 ops. Might TLE?
10^8 is borderline.
ArrayList is fast.
However, problem title "Linked List Random Node" often tests Reservoir Sampling. I will provide ArrayList approach as it's more stable for multiple queries on static list. (Follow up asks specifically "if...").

Let's stick to Reservoir Sampling to demonstrate the algorithm.
Or better: If N is small enough to fit in memory (10^4 ints is tiny), ArrayList is strictly superior.
But since this is an "Algorithm" exercise, I'll do Reservoir Sampling to show I know it? Or ArrayList to be practical.
The User asks for "Implementing LeetCode Problems". Usually standard robust solutions.
Let's do Reservoir Sampling. It's the intended "trick".

Wait, actually, I'll use ArrayList because 10^8 operations in Java might be slow (100ms-1s). Standard time limit 1-2s. It's risky.
ArrayList approach:
- Init: O(N).
- Get: O(1).
- Total for M queries: O(N + M). Very fast.
Reservoir:
- Init: O(1).
- Get: O(N).
- Total: O(N*M). Slower.

I will implement the **ArrayList** approach. It is the efficient solution for the given constraints. I will include Reservoir implementation in comments or as an alternative method in the class if applicable, but primary logic will use ArrayList.

---

## Analysis / Phân tích

### Approach: ArrayList Copy

**Algorithm**:
1.  Copy linked list to `ArrayList`.
2.  `getRandom`: `list.get(rand.nextInt(size))`.

---
