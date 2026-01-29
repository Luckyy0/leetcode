# 950. Reveal Cards In Increasing Order / Tiết lộ các Thẻ theo Thứ tự Tăng dần

## Problem Description / Mô tả bài toán
You are given an integer array `deck`. There are some rules to reveal cards:
Bạn được cho một mảng số nguyên `deck`. Có một số quy tắc để tiết lộ các thẻ:
1. Take the top card and reveal it.
2. If there are still cards in the deck, put the next top card at the bottom of the deck.
3. Repeat until all cards are revealed.

Return an ordering of the deck that would reveal the cards in increasing order.
Hãy trả về một thứ tự của bộ bài sao cho các thẻ được tiết lộ theo thứ tự tăng dần.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Queue Simulation (Reverse Engineering) / Mô phỏng Hàng đợi (Kỹ thuật Ngược)
It's easier to simulate the process using indices.
Mô phỏng quy trình bằng cách sử dụng các chỉ số sẽ dễ dàng hơn.

Algorithm:
1. Sort the `deck`.
2. Initialize a `Queue` with indices `0, 1, ..., n-1`.
3. For each card in the sorted `deck`:
   - `idx = queue.poll()`. This is where the smallest available card goes.
   - If queue is not empty:
     - `queue.add(queue.poll())`. Move the next available index to the back.
4. Fill the result array at assigned indices.

### Complexity / Độ phức tạp
- **Time**: O(N log N) for sorting.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Index Reordering
Map the sorted cards to indices in the order they would be physically selected. By mimicking the deck's rotation logic (top-out, top-to-bottom) on a list of indices, we determine exactly where each ranked card belongs in the initial layout.
Lập bản đồ các thẻ đã sắp xếp vào các chỉ số theo thứ tự chúng sẽ được chọn vật lý. Bằng cách bắt chước logic xoay của bộ bài (trên cùng lấy ra, trên cùng xuống dưới cùng) trên một danh sách các chỉ số, chúng ta xác định chính xác vị trí của mỗi thẻ theo xếp hạng trong bố cục ban đầu.

---
