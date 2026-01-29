# 1046. Last Stone Weight / Trọng lượng Viên đá Cuối cùng

## Problem Description / Mô tả bài toán
You are given an array of integers `stones` where `stones[i]` is the weight of the `i-th` stone.
Bạn được cho một mảng các số nguyên `stones` trong đó `stones[i]` là trọng lượng của viên đá thứ `i`.

We play a game with the stones. On each turn, we choose the **heaviest two stones** and smash them together. Suppose the heaviest two stones have weights `x` and `y` with `x <= y`. The result of this smash is:
- If `x == y`, both stones are destroyed.
- If `x != y`, the stone of weight `x` is destroyed, and the stone of weight `y` has new weight `y - x`.

At the end of the game, there is at most one stone left. Return the weight of the last remaining stone. If there are no stones left, return 0.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Priority Queue (Max-Heap) / Hàng đợi Ưu tiên (Max-Heap)
We always need the two largest elements. A Max-Heap is ideal for this.
Chúng ta luôn cần hai phần tử lớn nhất. Hàng đợi ưu tiên cực đại là lý tưởng cho việc này.

Algorithm:
1. Put all stones into a Max-Heap.
2. While heap size > 1:
   - `y = heap.poll()`
   - `x = heap.poll()`
   - If `x != y`, `heap.add(y - x)`.
3. If heap is empty, return 0.
4. Else return `heap.poll()`.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Recursive Reduction with Max-Heap
Simulate the smashing process using a max-priority queue. Repeatedly extract the two largest elements, resolve their interaction, and re-insert any residue. This direct simulation naturally converges to the final state.
Mô phỏng quá trình đập vỡ bằng cách sử dụng hàng đợi ưu tiên cực đại. Lặp đi lặp lại việc trích xuất hai phần tử lớn nhất, giải quyết tương tác của chúng và chèn lại bất kỳ phần dư nào. Mô phỏng trực tiếp này hội tụ tự nhiên đến trạng thái cuối cùng.

---
