# 374. Guess Number Higher or Lower / Đoán Số Cao Hơn Hay Thấp Hơn

## Problem Description / Mô tả bài toán
We are playing the Guess Game. The game is as follows:
I pick a number from `1` to `n`. You have to guess which number I picked.
Chúng ta đang chơi Trò chơi Đoán số... Tôi chọn một số từ `1` đến `n`. Bạn phải đoán xem tôi đã chọn số nào.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
Mỗi khi bạn đoán sai, tôi sẽ cho bạn biết số tôi chọn cao hơn hay thấp hơn số bạn đoán.

You call a pre-defined API `int guess(int num)`, which returns three possible results:
- `-1`: Your guess is higher than the number I picked (i.e. `num > pick`).
- `1`: Your guess is lower than the number I picked (i.e. `num < pick`).
- `0`: your guess is equal to the number I picked (i.e. `num == pick`).

Return the number that I picked.

### Example 1:
```text
Input: n = 10, pick = 6
Output: 6
```

### Example 2:
```text
Input: n = 1, pick = 1
Output: 1
```

## Constraints / Ràng buộc
- `1 <= n <= 2^31 - 1`
- `1 <= pick <= n`

---

## Theoretical Foundation / Cơ sở lý thuyết

### Binary Search / Tìm Kiếm Nhị Phân
Standard Binary Search Application.
Range `[1, n]`.
`mid = low + (high - low) / 2`.
Result of `guess(mid)`:
- `0`: Return `mid`.
- `-1`: `num > pick`. Pick is smaller. `high = mid - 1`.
- `1`: `num < pick`. Pick is larger. `low = mid + 1`.

### Complexity / Độ phức tạp
- **Time**: O(log N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Binary Search

**Algorithm**:
1.  `l = 1`, `r = n`.
2.  While `l <= r`:
    - `m = l + (r - l) / 2`.
    - `res = guess(m)`.
    - If `res == 0` return `m`.
    - If `res == -1` `r = m - 1`.
    - If `res == 1` `l = m + 1`.

---
