# 379. Design Phone Directory / Thiết Kế Danh Bạ Điện Thoại

## Problem Description / Mô tả bài toán
Design a phone directory that initially has `maxNumbers` empty slots that can store numbers. The directory should store numbers, check if a certain slot is empty or not, and empty a given slot.
Thiết kế danh bạ điện thoại...

Implement the `PhoneDirectory` class:
- `PhoneDirectory(int maxNumbers)` Initializes the phone directory with the number of available slots `maxNumbers`.
- `int get()` Provides a number that is not assigned to anyone. Returns `-1` if no number is available.
- `bool check(int number)` Returns `true` if the slot `number` is available and `false` otherwise.
- `void release(int number)` Recycles or releases the slot `number`.

### Example 1:
```text
Input
["PhoneDirectory", "get", "get", "check", "get", "check", "release", "check"]
[[3], [], [], [2], [], [2], [2], [2]]
Output
[null, 0, 1, true, 2, false, null, true]

Explanation
PhoneDirectory directory = new PhoneDirectory(3);
directory.get(); // return 0
directory.get(); // return 1
directory.check(2); // return true
directory.get(); // return 2
directory.check(2); // return false
directory.release(2); 
directory.check(2); // return true
```

## Constraints / Ràng buộc
- `1 <= maxNumbers <= 10^4`
- `0 <= number < maxNumbers`
- At most `2 * 10^4` calls will be made to `get`, `check`, and `release`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### Queue + HashSet / Hàng Đợi + Tập Hợp
We need efficient `get`, `check`, and `release`.
- `available`: A Queue or Stack storing available numbers. Initially `0` to `maxNumbers - 1`.
- `used` / `isAvailable`: A HashSet or Boolean Array to track fast `check`.
- `get`: Poll from Queue. Mark as used.
- `release`: Add to Queue (only if not already available). Mark as available.
- `check`: Return status from Boolean Array.

### Complexity / Độ phức tạp
- **Time**: O(1) for all operations.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Queue and Boolean Array

**Algorithm**:
1.  `Queue<Integer> available`.
2.  `boolean[] used`.
3.  Init: All in Queue. `used` false.
    - Optimization: Don't fill Queue initially?
    - If N is large, filling Queue takes O(N) at init. N=10^4 is small. OK.
4.  `get`:
    - If Queue empty, -1.
    - Poll `n`. `used[n] = true`. Return `n`.
5.  `check(n)`:
    - Return `!used[n]`.
6.  `release(n)`:
    - If `used[n]`:
        - `used[n] = false`.
        - `available.offer(n)`.

---
