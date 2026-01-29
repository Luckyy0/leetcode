# 1167. Minimum Cost to Connect Sticks / Chi phí Tối thiểu để Kết nối Các Que

## Problem Description / Mô tả bài toán
You have some sticks with positive integer lengths.
You can connect any two sticks of lengths `X` and `Y` into one stick by paying a cost of `X + Y`. You perform this action until there is one stick remaining.
Return the minimum cost of connecting all the given sticks into one stick in this way.
Bạn có một số que có độ dài số nguyên dương.
Bạn có thể kết nối bất kỳ hai que nào có độ dài `X` và `Y` thành một que bằng cách trả chi phí `X + Y`. Bạn thực hiện hành động này cho đến khi còn lại một que.
Trả về chi phí tối thiểu để kết nối tất cả các que đã cho thành một que theo cách này.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Huffman Coding / Priority Queue (Greedy) / Mã hóa Huffman / Hàng đợi Ưu tiên (Tham lam)
Always combine two smallest sticks to minimize total cost.
Algorithm:
1. Put all lengths in Min-Heap.
2. While size > 1:
   - `a = poll()`.
   - `b = poll()`.
   - `sum = a + b`.
   - `cost += sum`.
   - `offer(sum)`.
3. Return cost.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Greedy Min-Heap Strategy
This is equivalent to constructing a Huffman tree. To minimize the total cost, always merge the two shortest available sticks. Since the cost of a merger is added to the total and the merged stick participates in future mergers, smaller values should be merged earlier (contributing to fewer future sums) and larger values later. A Priority Queue (Min-Heap) efficiently supports retrieving the two smallest elements.
Điều này tương đương với việc xây dựng một cây Huffman. Để giảm thiểu tổng chi phí, luôn hợp nhất hai que ngắn nhất có sẵn. Vì chi phí sáp nhập được cộng vào tổng số và que đã hợp nhất tham gia vào các vụ sáp nhập trong tương lai, nên các giá trị nhỏ hơn nên được hợp nhất sớm hơn (góp phần vào ít tổng hơn trong tương lai) và các giá trị lớn hơn sau này. Hàng đợi ưu tiên (Min-Heap) hỗ trợ hiệu quả việc lấy hai phần tử nhỏ nhất.

---
