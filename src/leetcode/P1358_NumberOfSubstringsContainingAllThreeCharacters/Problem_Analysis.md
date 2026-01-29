# 1358. Number of Substrings Containing All Three Characters / Số lượng Chuỗi con Chứa Tất cả Ba Ký tự

## Problem Description / Mô tả bài toán
String `s` containing 'a', 'b', 'c'.
Count substrings containing at least one 'a', one 'b', one 'c'.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Sliding Window / Three Pointers
Iterate `right` from 0 to N.
Add `s[right]` to counts.
While window `[left, right]` has all 3 characters:
- All substrings starting from `left` and ending at `k >= right` are valid?
- No, easiest way to count:
- If window `[left, right]` is valid (contains all 3), then it is the minimal valid substring ending at `right` starting from `left`.
- Actually, any substring ending at `right` starting at `k <= left` is also valid (since it contains more).
- So if `[left, right]` is valid, then `[0...right], [1...right], ... [left...right]` are valid.
- Total `left + 1` substrings ending at `right`.
- Wait. "While valid, increment left".
- Correct logic:
  - Expand right.
  - While window valid:
    - Add `n - right` to answer? No, standard approaches count differently.
    - Here:
      - For each `right`, find the largest `left` such that `s[left...right]` has all chars? No, find smallest window.
      - While `s[left....right]` valid: `left++`. The valid windows ending at `right` are `s[0...right], s[1...right] ... s[left-1...right]`. So count += `left`.
      - E.g. `aaabc`. right at `c` (idx 4). `left` moves to 2 (after `aaa`). Valid are `0..4, 1..4, 2..4`. Count = 3 (which is roughly `left` index after loop).

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Sliding Window
Maintain counts of 'a', 'b', 'c'. Expand `right` pointer.
When `count['a'] > 0 && count['b'] > 0 && count['c'] > 0`:
- This means current window `[left, right]` is valid (and so are all super-windows extending to the left).
- While the window is valid, remove `s[left]` and increment `left`.
- For each step where valid, we could add... wait.
- Better logic:
  For a fixed `right`, find the MAX `left` such that `[left, right]` contains all 3.
  Actually, let's just use the `while` loop.
  Expand `right`. Update counts.
  While (valid):
     count += `n - right`? No.
     The problem asks for TOTAL substrings.
     Method 1: Count *at each right*, how many valid substrings END at right.
       - Smallest valid starting at `L`. Then valid ones are `0..right`, `1..right`, ..., `L..right`. Total `L + 1`.
       - So while valid, shrink `left`. When inner loop breaks, the validity holds for `left-1`.
       - The number of valid substrings ending at `right` is `left`. (Because `0..right` to `left-1..right` are valid. Indices 0 to left-1 are `left` indices).
       - Add `left` to answer.
  Method 2: Count *at each left*, how many valid substrings START at left. `n - right`.
  Method 1 is standard.
  
Duy trì số lượng 'a', 'b', 'c'. Mở rộng con trỏ `right`.
Khi `count['a'] > 0 && count['b'] > 0 && count['c'] > 0`:
- Điều này có nghĩa là cửa sổ hiện tại `[left, right]` là hợp lệ (và tất cả các cửa sổ siêu mở rộng sang trái cũng vậy).
- Trong khi cửa sổ hợp lệ, xóa `s[left]` và tăng `left`.
- Logic:
  - Mở rộng `right`. Cập nhật số lượng.
  - Trong khi (hợp lệ):
     - Số lượng các chuỗi con hợp lệ kết thúc tại `right` là `left`. (Bởi vì `0..right` đến `left-1..right` là hợp lệ. Các chỉ số từ 0 đến left-1 là `left` chỉ số).
     - Cộng `left` vào kết quả.
Lưu ý: "Trong khi hợp lệ, tăng `left`".
Sau khi vòng lặp while, `left` chỉ vào phần tử đầu tiên làm cho cửa sổ KHÔNG hợp lệ.
Điều đó có nghĩa là `0` đến `left-1` là các điểm bắt đầu hợp lệ. Có `left` điểm.
Vì vậy, cộng `left` vào tổng.

---
