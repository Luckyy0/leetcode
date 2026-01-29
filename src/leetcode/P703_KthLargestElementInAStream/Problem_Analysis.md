# 703. Kth Largest Element in a Stream / Phần tử Lớn thứ K trong một Luồng

## Problem Description / Mô tả bài toán
Design a class to find the `kth` largest element in a stream. Note that it is the `kth` largest element in the sorted order, not the `kth` distinct element.
Thiết kế một lớp để tìm phần tử lớn thứ `k` trong một luồng. Lưu ý rằng đó là phần tử lớn thứ `k` theo thứ tự đã sắp xếp, không phải phần tử phân biệt thứ `k`.

Implement `KthLargest` class:
- `KthLargest(int k, int[] nums)` Initializes the object with the integer `k` and the stream of integers `nums`.
- `int add(int val)` Appends the integer `val` to the stream and returns the element representing the `kth` largest element in the stream.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Min-Heap / Heap cực tiểu
A min-heap of size `k` can store the `k` largest elements encountered so far.
Một heap cực tiểu kích thước `k` có thể lưu trữ `k` phần tử lớn nhất đã gặp cho đến nay.

The root of this min-heap will be the smallest of these `k` largest elements, which is exactly the **kth largest** overall.
Gốc của heap cực tiểu này sẽ là phần tử nhỏ nhất trong số `k` phần tử lớn nhất này, chính xác là **phần tử lớn thứ k** tính tổng thể.

When adding a new value:
- If heap size < k, add it.
- If heap size == k and value > heap.root, replace root.

### Complexity / Độ phức tạp
- **Time**: `Constructor`: O(N log K), `add`: O(log K).
- **Space**: O(K).

---

## Analysis / Phân tích

### Approach: Maintain a K-size Min-Heap
Only keep the top `k` largest values. The root of the `PriorityQueue` will always represent the kth largest.
Chỉ giữ lại `k` giá trị lớn nhất hàng đầu. Gốc của `PriorityQueue` sẽ luôn đại diện cho giá trị lớn thứ k.

---
