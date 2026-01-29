# 519. Random Flip Matrix / Lật Ma Trận Ngẫu Nhiên

## Problem Description / Mô tả bài toán
There is an `m x n` binary grid `matrix` initially filled with all `0`s. Implement the `Solution` class:
Có một lưới nhị phân `m x n` ban đầu được lấp đầy bằng tất cả các số `0`. Hãy triển khai lớp `Solution`:

- `Solution(int m, int n)` Initializes the object with the size `m x n`.
- `int[] flip()` Returns a random `[row, col]` index of a matrix cell with value `0` and flips it to `1`. All cells with value `0` should have an equal probability of being chosen.
- `void reset()` Resets all the cells to `0`.

### Example:
```text
Input: ["Solution", "flip", "flip", "reset", "flip"]
       [[3, 1], [], [], [], []]
Output: [null, [1, 0], [2, 0], null, [0, 0]]
```

## Constraints / Ràng buộc
- `1 <= m, n <= 10^4`
- At most `1000` calls will be made to `flip` and `reset`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Virtual Array with HashMap / Mảng ảo với HashMap
Instead of maintaining the entire matrix, we can use a HashMap to track **flipped positions** virtually.

Algorithm:
1. Initialize `total = m * n`.
2. Maintain a `HashMap<Integer, Integer> map` to store virtual swaps.
3. For `flip()`:
   - Generate a random index `r` in `[0, total - 1]`.
   - Check if `map.get(r)` exists; if yes, use it as the flipped index. Otherwise, use `r` itself.
   - To avoid picking this cell again, we simulate a "swap" with the last available cell at `total - 1`.
     - `map.put(r, map.getOrDefault(total - 1, total - 1))`.
   - Decrement `total`.
   - Convert the index to `[row, col]` using `row = index / n`, `col = index % n`.
4. For `reset()`:
   - Clear the map.
   - Reset `total = m * n`.

### Complexity / Độ phức tạp
- **Time**: O(1) for both `flip()` and `reset()`.
- **Space**: O(K) where K is the number of flips.

---

## Analysis / Phân tích

### Approach: Fisher-Yates with Virtual Mapping

**Algorithm**:
1.  Random index generation.
2.  HashMap to track position swaps.
3.  Decrement available count.

---
