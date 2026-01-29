# 1297. Maximum Number of Occurrences of a Substring / Số lần Xuất hiện Tối đa của một Chuỗi con

## Problem Description / Mô tả bài toán
String `s`, `maxLetters`, `minSize`, `maxSize`.
Return max occurrences of any substring with:
- unique chars <= `maxLetters`.
- length between `minSize` and `maxSize`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Substring Property
If a substring of length `L` satisfies conditions and appears `X` times, then any superset substring of length `L+1` appears `<= X` times.
To maximize occurrences, we should focus on the SMALLEST valid length, which is `minSize`.
Any valid substring of length > `minSize` (up to `maxSize`) is only formed by extending a shorter one. The shorter one (length `minSize`) will always have frequency >= longer one.
So we ONLY need to check substrings of length `minSize`.

### Complexity / Độ phức tạp
- **Time**: O(N * minSize).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Focusing on minSize
Crucial observation: we only need to count substrings of length exactly `minSize`. Any substring of length `L > minSize` that satisfies the conditions contains a substring of length `minSize` that also satisfies the conditions (at least the unique chars condition is easier to satisfy for smaller strings). Since the frequency of a superstring cannot exceed the frequency of its substring, maximum occurrences will always be found among the shortest valid substrings. Iterate through `s` with a window of size `minSize`, check unique characters constraint, count frequencies, and find max.
Quan sát quan trọng: chúng ta chỉ cần đếm các chuỗi con có độ dài chính xác `minSize`. Bất kỳ chuỗi con nào có độ dài `L > minSize` thỏa mãn các điều kiện đều chứa một chuỗi con có độ dài `minSize` cũng thỏa mãn các điều kiện (ít nhất điều kiện ký tự duy nhất dễ thỏa mãn hơn cho các chuỗi nhỏ hơn). Vì tần suất của chuỗi mẹ không thể vượt quá tần suất của chuỗi con, số lần xuất hiện tối đa sẽ luôn được tìm thấy trong số các chuỗi con hợp lệ ngắn nhất. Lặp qua `s` với cửa sổ kích thước `minSize`, kiểm tra ràng buộc ký tự duy nhất, đếm tần suất và tìm giá trị lớn nhất.

---
