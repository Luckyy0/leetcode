# 925. Long Pressed Name / Tên bị nhấn giữ lâu

## Problem Description / Mô tả bài toán
Your friend is typing his `name` on a keyboard. Sometimes, when typing a character `c`, the key might get long pressed, and the character will be typed 1 or more times.
Bạn của bạn đang gõ `name` của mình trên bàn phím. Đôi khi, khi gõ một ký tự `c`, phím có thể bị nhấn lâu và ký tự đó sẽ được gõ 1 hoặc nhiều lần.

Given `name` and the `typed` string, return `true` if it's possible that `typed` was your friend's name.
Cho `name` và chuỗi `typed`, hãy trả về `true` nếu có khả năng `typed` là tên của bạn bạn.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Two Pointers / Hai con trỏ
Algorithm:
1. `i = 0` (for `name`), `j = 0` (for `typed`).
2. While `j < typed.length`:
   - If `i < name.length && name[i] == typed[j]`, increment both.
   - Else if `j > 0 && typed[j] == typed[j-1]` (long press), increment only `j`.
   - Else, return `false`.
3. After the loop, check if `i == name.length`.

### Complexity / Độ phức tạp
- **Time**: O(Length(typed)).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Stream Matching with Redundancy
Process the `typed` string character by character. If a character matches the expected next letter in `name`, move both pointers. If it matches the previous character (redundancy), skip it. Any other character represents an impossible sequence.
Xử lý chuỗi `typed` theo từng ký tự. Nếu một ký tự khớp với chữ cái tiếp theo được mong đợi trong `name`, hãy di chuyển cả hai con trỏ. Nếu nó khớp với ký tự trước đó (tính dư thừa), hãy bỏ qua nó. Bất kỳ ký tự nào khác đều đại diện cho một chuỗi không thể xảy ra.

---
