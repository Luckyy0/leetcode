# 403. Frog Jump / Cú Nhảy Của Ếch

## Problem Description / Mô tả bài toán
A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not be a stone. The frog can jump on a stone, but it must not jump into the water.
Một con ếch đang băng qua một con sông. Con sông được chia thành một số đơn vị, và tại mỗi đơn vị có thể có hoặc không có đá. Con ếch có thể nhảy lên một hòn đá, nhưng không được nhảy xuống nước.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can reach the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
Cho một danh sách các vị trí của các hòn đá (tính theo đơn vị) được sắp xếp theo thứ tự tăng dần, hãy xác định xem con ếch có thể đến được hòn đá cuối cùng hay không. Ban đầu, con ếch đang ở hòn đá đầu tiên và giả định rằng cú nhảy đầu tiên phải là 1 đơn vị.

If the frog's last jump was `k` units, its next jump must be either `k - 1`, `k`, or `k + 1` units. The frog can only jump in the forward direction.
Nếu cú nhảy cuối cùng của con ếch là `k` đơn vị, thì cú nhảy tiếp theo của nó phải là `k - 1`, `k`, hoặc `k + 1` đơn vị. Con ếch chỉ có thể nhảy về phía trước.

### Example 1:
```text
Input: stones = [0,1,3,5,6,8,12,17]
Output: true
Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
```

### Example 2:
```text
Input: stones = [0,1,2,3,4,8,9,11]
Output: false
Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.
```

## Constraints / Ràng buộc
- `2 <= stones.length <= 2000`
- `0 <= stones[i] <= 2^31 - 1`
- `stones[0] == 0`
- `stones` is sorted in a strictly increasing order.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Dynamic Programming with Map / Quy hoạch động với Map
We can represent the state as `(stone_position, last_jump_size)`.
Since we want to find if the last stone is reachable, we can maintain a map where the key is the stone position and the value is a set of jump sizes that can reach this stone.

Algorithm:
1. Initialize a `Map<Integer, Set<Integer>>`.
2. For each stone position, empty set initially.
3. Stone 0 gets jump 0: `map[0] = {0}`. (Wait, description says first jump must be 1 unit. So from 0 with k=0, next jump is 0+1=1. Which matches).
4. Iterate through each stone `S` in order:
   - For each jump `K` in `map[S]`:
     - For `nextStep` in `{K-1, K, K+1}`:
       - If `nextStep > 0`:
         - If `S + nextStep` exists in the map:
           - Add `nextStep` to `map[S + nextStep]`.
5. Check if the set for the last stone is non-empty.

### Complexity / Độ phức tạp
- **Time**: O(N^2) in worst case (each stone could be reached by almost every other stone).
- **Space**: O(N^2) to store jump sizes for each stone.

---

## Analysis / Phân tích

### Approach: Map of Sets DP

**Algorithm**:
1.  Verify basic reachability (first gap must be 1).
2.  Populate jump sets for each stone iteratively.

---
