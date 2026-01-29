# 803. Bricks Falling When Hit / Gạch rơi khi bị Vá chạm

## Problem Description / Mô tả bài toán
You are given an `m x n` binary `grid`, where each `1` represents a brick and `0` represents an empty space. A brick is **stable** if:
Bạn được cho một lưới nhị phân `m x n`, trong đó mỗi số `1` đại diện cho một viên gạch và `0` đại diện cho một khoảng trống. Một viên gạch được gọi là **ổn định** nếu:

1. It is directly connected to the top of the grid.
Nó được kết nối trực tiếp với đỉnh của lưới.
2. At least one of its four adjacent neighbors is stable.
Ít nhất một trong bốn láng giềng lân cận của nó ổn định.

You are also given an array `hits`, which is a sequence of erasures. When you hit a brick, that brick disappears. Any brick that becomes unstable because of the hit falls.
Bạn cũng được cung cấp một mảng `hits`, là một chuỗi các lần xóa. Khi bạn va chạm vào một viên gạch, viên gạch đó biến mất. Bất kỳ viên gạch nào trở nên không ổn định do tác động sẽ bị rơi.

Return an array `result` where `result[i]` is the number of bricks that fall after the `ith` hit.
Trả về một mảng `result` trong đó `result[i]` là số lượng gạch rơi sau đợt va chạm thứ `i`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Reverse Processing with Union-Find / Xử lý Ngược với Union-Find
Simulating hits forward is difficult because one hit can cause many disconnected components to fall.
Mô phỏng các lần va chạm theo chiều thuận là khó khăn vì một lần va chạm có thể khiến nhiều thành phần bị ngắt kết nối rơi xuống.

Optimization:
1. Mark all bricks that will ever be hit as `0` (or `2` if it was empty, `1` if it was a brick).
2. Perform a "pre-calculation" using DSU on the final state.
3. Add a special "dummy node" representing the top boundary (source of stability).
4. Process hits in **reverse order** (falling becomes connecting).
5. When adding a brick back:
   - Calculate how many bricks were already connected to the top.
   - Perform the union and check the new size of the component connected to the top.
   - The difference (minus 1 for the hit brick itself) is the number of bricks that fell.

### Complexity / Độ phức tạp
- **Time**: O((N + Q) * α(N)), where N is total cells and Q is number of hits.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Reverse Connectivity Logic
Instead of removing bricks, we add them back in the reverse order of the hits. Whenever an addition connects a previously isolated cluster to the "stable" top row, the size of that cluster represents the bricks that would have fallen during that hit.
Thay vì loại bỏ gạch, chúng ta thêm ngược lại chúng theo thứ tự ngược của các lần va chạm. Bất cứ khi nào việc thêm vào kết nối một cụm bị cô lập trước đó với hàng trên cùng "ổn định", kích thước của cụm đó đại diện cho số gạch đã rơi trong lần va chạm đó.

---
