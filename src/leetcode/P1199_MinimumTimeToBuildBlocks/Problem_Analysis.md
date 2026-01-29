# 1199. Minimum Time to Build Blocks / Thời gian Tối thiểu để Xây dựng Khối

## Problem Description / Mô tả bài toán
You are given a list of blocks, where `blocks[i]` is the tme to build the `i-th` block. To build a block, you need one worker. Initially, you have 1 worker.
Worker can either:
- Split into two workers. Takes `split` time. After splitting, both workers can work or split further.
- Build a block. Takes `blocks[i]` time. Worker effectively disappears after building (is occupied).
Return minimum time to build all blocks.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Huffman Coding (Reverse) / Greedy Priority Queue / Mã hóa Huffman (Ngược) / Hàng đợi Ưu tiên Tham lam
This is identical to Huffman coding with a cost.
Splitting increases the "depth" or "cost" for subsequent operations.
Imagine we combine two tasks. If we have two blocks needing `a` and `b`, we can treat them as one task that takes `max(a, b) + split`.
Why? Because `split` is incurred *before* parallel execution.
Wait.
If we have 2 workers ready, time is `max(a, b)`.
But we start with 1 worker. To process `a` and `b`, we must split. Time `split`. Then `max(a, b)` in parallel.
Total time `split + max(a, b)`.
This effectively "merges" `a` and `b` into a super-task of cost `split + max(a, b)`.
We want to minimize the final single task cost.
This is exactly Huffman Coding where merge cost is `split + max(left, right)`.
Algorithm:
1. Min-Heap of all blocks.
2. While `heap.size() > 1`:
   - `x = poll()`.
   - `y = poll()`.
   - `new_cost = split + max(x, y)`.
   - Wait. Since `x <= y`, `max(x, y) = y`.
   - So `new_cost = split + y`.
   - `offer(new_cost)`.
3. Return `heap.poll()`.

Proof sketch: We always want to merge the cheapest/fastest blocks deeply in the split tree, so the `split` penalty is amortized or hidden by larger block times?
Actually, `split` adds to the path length.
The leaf weights are block times.
Final time = `max over leaves (leaf_time + split * depth)`.
This looks like Min-Max optimal tree?
Huffman minimizes `sum (weight * depth)`.
Here we minimize `max (weight + split * depth)`.
Huffman logic still holds?
Yes, merging smallest elements first minimizes the impact of adding `split` to them (making them larger/deeper).
If we merge large blocks early, they get `+split`, becoming even larger.
By merging small blocks, `small + split` might still be smaller than `large`, keeping the max value low.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Greedy Merge (Huffman Variant)
This problem models an optimal merge tree where merging two nodes with costs $a$ and $b$ produces a new node with cost $split + \max(a, b)$. To minimize the final root cost, we should essentially perform merges on the smallest available costs. Using a Min-Heap, repeatedly extract the two smallest elements ($x, y$), combine them into $split + \max(x, y)$ (which is $split + y$ since $x \le y$), and insert back. Repeat until one element remains.
Bài toán này mô hình hóa một cây hợp nhất tối ưu, trong đó việc hợp nhất hai nút có chi phí $a$ và $b$ tạo ra một nút mới có chi phí $split + \max(a, b)$. Để giảm thiểu chi phí gốc cuối cùng, về cơ bản chúng ta nên thực hiện hợp nhất trên các chi phí khả dụng nhỏ nhất. Sử dụng Min-Heap, trích xuất lặp lại hai phần tử nhỏ nhất ($x, y$), kết hợp chúng thành $split + \max(x, y)$ (tức là $split + y$ vì $x \le y$), và chèn lại. Lặp lại cho đến khi còn lại một phần tử.

---
