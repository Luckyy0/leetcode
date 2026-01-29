# 871. Minimum Number of Refueling Stops / Số lượng Trạm Tiếp nhiên liệu Tối thiểu

## Problem Description / Mô tả bài toán
A car travels to a `target`. It starts with `startFuel` and consumes 1 unit per mile. There are `stations` where `stations[i] = [position_i, fuel_i]`.
Một chiếc xe ô tô di chuyển đến một `target`. Nó bắt đầu với `startFuel` và tiêu thụ 1 đơn vị nhiên liệu cho mỗi dặm. Có các `stations` trong đó `stations[i] = [position_i, fuel_i]`.

Return the minimum number of refueling stops to reach the target. If impossible, return -1.
Trả về số lượng trạm tiếp nhiên liệu tối thiểu để đến được đích. Nếu không thể, hãy trả về -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Greedy with PriorityQueue / Tham lam với PriorityQueue
Algorithm:
1. Maintain a Max-Heap of fuel amounts at stations we have passed but not yet used.
2. Maintain `currentDistance` that can be reached with current fuel.
3. Iterate through stations:
   - While `currentDistance` is less than next station's position:
     - Refuel from the largest available fuel in Max-Heap.
     - Increment `stops`.
     - If heap is empty and still can't reach, return -1.
   - Add current station's fuel to Heap.
4. Repeat similar check for the final `target`.

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Post-facto Refueling
Imagine the car keeps going as far as possible. Whenever it runs out of fuel, it "virtually" goes back to the best station it has already passed to refuel. This ensures each refueling operation adds the maximum possible range.
Hãy tưởng tượng chiếc xe tiếp tục đi xa nhất có thể. Bất cứ khi nào hết nhiên liệu, nó sẽ "hầu như" quay trở lại trạm tốt nhất mà nó đã đi qua để tiếp nhiên liệu. Điều này đảm bảo mỗi thao tác tiếp nhiên liệu sẽ tăng thêm phạm vi tối đa có thể.

---
