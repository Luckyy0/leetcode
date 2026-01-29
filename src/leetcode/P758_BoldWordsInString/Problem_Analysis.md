# 758. Bold Words in String / Chữ đậm trong Chuỗi

## Problem Description / Mô tả bài toán
Given a list of strings `words` and a string `s`, mark all the occurrences of the strings in `words` in `s` as bold. Any spanning characters of `s` that are bold should be wrapped by the tags `<b>` and `</b>`.
Cho một danh sách các chuỗi `words` và một chuỗi `s`, hãy đánh dấu tất cả các lần xuất hiện của các chuỗi trong `words` trong `s` là in đậm. Bất kỳ ký tự nào của `s` được in đậm phải được bao quanh bởi các thẻ `<b>` và `</b>`.

If two bold regions overlap, they should be merged.
Nếu hai vùng in đậm bị chồng chéo, chúng phải được hợp nhất.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Interval Merging / Hợp nhất Khoảng
1. Identify all occurrences of each word in `s` and mark their range `[start, end)` as bold.
2. We can use a boolean array `bold[s.length()]` where `bold[i]` is true if the character at `i` is bold.
3. For each word in `words`:
   - Find all its start positions in `s`.
   - Set `bold[j] = true` for `j` from `start` to `start + word.length - 1`.
4. Traverse the `bold` array to build the final string with tags.

### Complexity / Độ phức tạp
- **Time**: O(S * Σ(word_lengths)) to find all occurrences.
- **Space**: O(S) for the bold boolean flag.

---

## Analysis / Phân tích

### Approach: Character-wise Bold Flagging
Use a boolean array to track which characters are bold. Then, iterate through the string and the boolean array to insert the `<b>` and `</b>` tags at the transition points.
Sử dụng một mảng boolean để theo dõi những ký tự nào được in đậm. Sau đó, lặp qua chuỗi và mảng boolean để chèn các thẻ `<b>` và `</b>` tại các điểm chuyển đổi.

---
