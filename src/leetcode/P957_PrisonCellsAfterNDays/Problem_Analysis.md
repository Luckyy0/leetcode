# 957. Prison Cells After N Days / Các ô nhà tù sau N ngày

## Problem Description / Mô tả bài toán
There are 8 prison cells in a row. Each cell is either occupied (1) or vacant (0).
Có 8 ô nhà tù trong một hàng. Mỗi ô hoặc là có người (1) hoặc là trống (0).

Rule: If a cell has two adjacent neighbors that are either both occupied or both vacant, then the cell becomes occupied. Otherwise, it becomes vacant.
Quy tắc: Nếu một ô có hai ô lân cận đều có người hoặc đều trống, thì ô đó sẽ có người. Ngược lại, nó sẽ trống.

Given the initial state and `n`, return the state after `n` days.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Cycle Detection / Phát hiện Chu kỳ
Since there are only 8 cells, and the first and last cells always become 0 after one day, there are only $2^6 = 64$ possible states.
Vì chỉ có 8 ô và các ô đầu tiên và cuối cùng luôn trở thành 0 sau một ngày, nên chỉ có $2^6 = 64$ trạng thái có thể có.

Algorithm:
1. Use a `HashMap` to store state and when it first occurred.
2. If we see a state again, a cycle is found.
3. Calculate the remaining steps using `n % cycleLength`.
4. Return the state after the remaining steps.

### Complexity / Độ phức tạp
- **Time**: O(2^Length).
- **Space**: O(2^Length).

---

## Analysis / Phân tích

### Approach: Periodic Shortcut
Simulate the prison transition. Because the state space is extremely small, the system will inevitably enter a repeating loop. Identifying this period allows us to skip virtually all iterations and compute the final state with just a few operations.
Mô phỏng sự chuyển đổi của nhà tù. Bởi vì không gian trạng thái cực kỳ nhỏ, hệ thống chắc chắn sẽ đi vào một vòng lặp lặp lại. Việc xác định chu kỳ này cho phép chúng ta bỏ qua hầu như tất cả các lần lặp và tính toán trạng thái cuối cùng chỉ với một vài thao tác.

---
