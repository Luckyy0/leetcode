# 134. Gas Station / Trạm Xăng

## Problem Description / Mô tả bài toán
There are `n` gas stations along a circular route, where the amount of gas at the `i`th station is `gas[i]`.
Có `n` trạm xăng dọc theo một cung đường tròn, trong đó lượng xăng tại trạm thứ `i` là `gas[i]`.

You have a car with an unlimited gas tank and it costs `cost[i]` of gas to travel from the `i`th station to its next (`i + 1`)th station. You begin the journey with an empty tank at one of the gas stations.
Bạn có một chiếc xe với bình xăng không giới hạn và tốn `cost[i]` lượng xăng để đi từ trạm thứ `i` đến trạm tiếp theo (`i + 1`). Bạn bắt đầu hành trình với bình xăng rỗng tại một trong các trạm xăng.

Given two integer arrays `gas` and `cost`, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return `-1`. If there exists a solution, it is **guaranteed to be unique**.
Cho hai mảng số nguyên `gas` và `cost`, hãy trả về chỉ số của trạm xăng bắt đầu nếu bạn có thể đi hết một vòng theo chiều kim đồng hồ, nếu không hãy trả về `-1`. Nếu tồn tại một giải pháp, nó được **đảm bảo là duy nhất**.

### Example 1:
```text
Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is 5. Your tank = 5 - 5 = 0.
Successfully travel back to station 3.
```

### Example 2:
```text
Input: gas = [2,3,4], cost = [3,4,3]
Output: -1
```

## Constraints / Ràng buộc
- `n == gas.length == cost.length`
- `1 <= n <= 10^5`
- `0 <= gas[i], cost[i] <= 10^4`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Total Balance Rule / Quy tắc Tổng số dư
A solution exists if and only if the total amount of gas is greater than or equal to the total cost:
Một giải pháp tồn tại khi và chỉ khi tổng lượng xăng lớn hơn hoặc bằng tổng chi phí:
`Sum(gas) >= Sum(cost)`.

### Greedy Strategy / Chiến lược Tham lam
If the car cannot reach station `B` from starting station `A`, then any station between `A` and `B` cannot reach `B` either.
Nếu chiếc xe không thể đi từ trạm bắt đầu `A` đến trạm `B`, thì bất kỳ trạm nào nằm giữa `A` và `B` cũng không thể đi đến `B`.
- We can skip all stations between `A` and `B` and try starting from `B + 1`.

---

## Analysis / Phân tích

### Approach: One-Pass Greedy / Tham lam Một Lượt

**Algorithm**:
1.  Initialize `total_gas = 0`, `current_gas = 0`, and `start_station = 0`.
2.  Iterate through each station `i`:
    - Calculate `gain = gas[i] - cost[i]`.
    - `total_gas += gain`.
    - `current_gas += gain`.
    - If `current_gas < 0`, it means we cannot reach station `i+1` starting from `start_station`. Reset `current_gas = 0` and update `start_station = i + 1`.
3.  After the loop, if `total_gas >= 0`, return `start_station`, otherwise return `-1`.

**Complexity / Độ phức tạp**:
- **Time**: O(N) - single pass through the array.
- **Space**: O(1) - constant space.

---

## Edge Cases / Các trường hợp biên
1.  **Solution doesn't exist**: Sum(gas) < Sum(cost).
2.  **Last station is the start**: Handle circular logic.
3.  **Large values**: Ensure variables don't overflow (though 10^5 * 10^4 fits in `int`).
