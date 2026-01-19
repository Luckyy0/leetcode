# 293. Flip Game / Trò Chơi Lật

## Problem Description / Mô tả bài toán
You are playing a Flip Game with your friend.
Bạn đang chơi Trò chơi Lật với bạn của mình.

You are given a string `currentState` that contains only `'+'` and `'-'`. You and your friend take turns to flip two **consecutive** `"++"` into `"--"`. The game ends when a person can no longer make a move, and therefore the other person will be the winner.
Bạn được cung cấp một chuỗi `currentState` chỉ chứa `'+'` và `'-'`. Bạn và bạn của bạn thay phiên nhau lật hai `"++"` **liên tiếp** thành `"--"`. Trò chơi kết thúc khi một người không thể thực hiện nước đi nữa, và do đó người kia sẽ là người chiến thắng.

Return all possible states of the string `currentState` after **one valid move**. You may return the answer in **any order**. If there are no valid moves, return an empty list `[]`.
Trả về tất cả các trạng thái có thể có của chuỗi `currentState` sau **một nước đi hợp lệ**.

### Example 1:
```text
Input: currentState = "++++"
Output: ["--++","+--+","++--"]
```

### Example 2:
```text
Input: currentState = "+"
Output: []
```

## Constraints / Ràng buộc
- `1 <= currentState.length <= 500`
- `currentState[i]` is either `'+'` or `'-'`.

---

## Theoretical Foundation / Cơ sở lý thuyết

### String Manipulation / Thao Tác Chuỗi
- Iterate through string from `0` to `len - 2`.
- Check if `s[i] == '+'` and `s[i+1] == '+'`.
- If yes, create a new string where these two are replaced by `--`.
- Add to result list.

### Complexity / Độ phức tạp
- **Time**: O(N^2) (Loop N times, substring creates string of size N). Actually simple concatenation.
- **Space**: O(N) for each result string.

---

## Analysis / Phân tích

### Approach: Linear Scan

**Algorithm**:
1.  List `res`.
2.  Loop `i` 0 to `n-2`.
3.  If `s.startsWith("++", i)`:
    - `res.add(s.sub(0, i) + "--" + s.sub(i+2))`.
4.  Return `res`.

---
